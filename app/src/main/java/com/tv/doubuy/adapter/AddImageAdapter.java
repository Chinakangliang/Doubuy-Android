package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.utils.PicassoHelper;

import java.util.List;

/**
 * Created by apple on 2017/6/23.
 */

public class AddImageAdapter extends RecyclerView.Adapter<AddImageAdapter.ViewHolder> {


    private Context mcontext;
    private LayoutInflater mInlater;

    private List<String> mlist;

    private addImageViewListenr callback;

    public AddImageAdapter(Context context, List<String> list) {
        this.mlist = list;
        this.mcontext = context;
        mInlater = LayoutInflater.from(context);
    }

    public void setData(List<String> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInlater.inflate(R.layout.item_add_shop_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        if (mlist.size() == 1 && mlist.get(position).equals("选择")) {
            holder.iv_item_image.setVisibility(View.VISIBLE);
            holder.tv_save.setVisibility(View.VISIBLE);
            holder.iv_item_image.setImageResource(R.mipmap.product_btn_add_pic);
            holder.iv_item_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.setAddImage();
                    }
                }
            });

        } else {
            if (mlist.get(position).equals("选择")) {
                holder.iv_item_image.setImageResource(R.mipmap.product_btn_add_pic);
                holder.iv_item_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (callback != null) {
                            callback.setAddImage();
                        }
                    }
                });
            } else {
//                holder.ivDelete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (callBack != null) {
//                            callBack.onItemCancelClick(position);
//                        }
//                    }
//                });
//                ImageLoader.loadFile(holder.ivPhoto, imgs.get(position));
                PicassoHelper.getInstance().setLocalImage(mcontext, mlist.get(position), holder.iv_item_image);
            }
        }

        holder.tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.saveImage();
                    holder.tv_save.setText("保存");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist != null && mlist.size() > 0 ? mlist.size() : 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_item_image;

        private TextView tv_save;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_item_image = (ImageView) itemView.findViewById(R.id.iv_item_image);
            tv_save = (TextView) itemView.findViewById(R.id.tv_save);
        }
    }


    public void AddImageCallback(addImageViewListenr callback) {

        this.callback = callback;

    }

    public interface addImageViewListenr {


        void setAddImage();

        void saveImage();
    }
}
