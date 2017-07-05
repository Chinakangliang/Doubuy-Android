package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tv.doubuy.R;
import com.tv.doubuy.utils.PicassoHelper;

import java.util.List;

/**
 * Created by apple on 2017/6/28.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mcontext;

    private LayoutInflater mInflater;

    private ImageAdapterCallBack callBack;


    public List<String> mlist;

    public ImageAdapter(Context context) {

        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<String> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_shop_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        if (!mlist.get(position).equals("选择")) {
            PicassoHelper.getInstance().setImage(mcontext, mlist.get(position), holder.iv_item_image);
            holder.iv_item_image.setOnClickListener(null);
        } else {
            holder.iv_item_image.setImageResource(R.mipmap.product_btn_add_pic);
            holder.iv_item_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callBack != null) {
                        callBack.addImage(position);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_item_image;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_item_image = (ImageView) itemView.findViewById(R.id.iv_item_image);
        }
    }

    public interface ImageAdapterCallBack {

        void addImage(int position);
    }

    public void setAdapterCallBack(ImageAdapterCallBack callBack) {

        this.callBack = callBack;
    }
}
