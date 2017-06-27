package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tv.doubuy.R;
import com.tv.doubuy.model.responseModel.ShopClassListChildrenBean;
import com.tv.doubuy.model.responseModel.ShopClassListModel;
import com.tv.doubuy.view.drawer.DrawerViewHolder;

import java.util.List;

/**
 * Created by apple on 2017/6/19.
 */

public class ManageShopAdapter extends RecyclerView.Adapter {


    private LayoutInflater mInflater;

    private List<ShopClassListChildrenBean> mlist;

    public ManageShopAdapter(Context context, List<ShopClassListChildrenBean> list) {

        this.mlist = list;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_shop_list_all, parent, false);
        DrawerViewHolder holder = new DrawerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DrawerViewHolder viewHolder = (DrawerViewHolder) holder;

        viewHolder.itemView.setTag(position);
        viewHolder.content.setText(mlist.get(position).getName());
        viewHolder.tvSize.setText("(" + mlist.get(position).getId() + ")");
    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }

    public void removeItem(int position) {
        mlist.remove(position);
        notifyDataSetChanged();
    }
}
