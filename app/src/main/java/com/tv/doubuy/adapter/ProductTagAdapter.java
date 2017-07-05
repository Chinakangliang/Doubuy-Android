package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.tv.doubuy.R;
import com.tv.doubuy.model.responseModel.CreateProductSKUs;

import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2017/6/29.
 */

public class ProductTagAdapter extends RecyclerView.Adapter<ProductTagAdapter.ViewHolder> {


    private Context mcontext;
    private LayoutInflater mInflater;

    private List<CreateProductSKUs> mlist;

    private Itemcallback itemcallback;

    HashMap<Integer, Boolean> state = new HashMap<>();

    public ProductTagAdapter(Context context) {

        this.mcontext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<CreateProductSKUs> createProductSKUses) {

        this.mlist = createProductSKUses;
    }


    public void setHasMap(HashMap<Integer, Boolean> hasMap) {

        this.state = hasMap;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_product_detiasl_tag, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.tvDetialTage.setText(mlist.get(position).getSpec());

        if (state != null) {
            holder.tvDetialTage.setChecked(state.get(position));
        }

        holder.tvDetialTage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (itemcallback != null) {
                    itemcallback.isCheckTag(position, mlist);
                    buttonView.setTextColor(mcontext.getResources().getColor(R.color.color2525));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox tvDetialTage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDetialTage = (CheckBox) itemView.findViewById(R.id.tv_detials_tag);
        }
    }

    public interface Itemcallback {

        void isCheckTag(int position, List<CreateProductSKUs> mlist);
    }

    public void ItemTagListClick(Itemcallback callback) {

        this.itemcallback = callback;
    }
}
