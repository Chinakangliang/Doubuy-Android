package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/14.
 */

public class StoreGridAdapter extends RecyclerView.Adapter<StoreGridAdapter.ViewHolder> {


    private List<Integer> drawId;
    private List<String> storename;
    private LayoutInflater mInflater;

    private StoreAdapterCallBack callBack;

    public StoreGridAdapter(Context context) {

        mInflater = LayoutInflater.from(context);

        drawId = new ArrayList<>();
        storename = new ArrayList<>();
        setData();
    }

    public void setData() {
        drawId.add(R.mipmap.shop_btn_products);
        storename.add("商品管理");
        drawId.add(R.mipmap.shop_btn_activity);
        storename.add("活动管理");
        drawId.add(R.mipmap.shop_btn_liveroom);
        storename.add("直播管理");
        drawId.add(R.mipmap.shop_btn_customer);
        storename.add("客户管理");
        drawId.add(R.mipmap.shop_btn_delivery);
        storename.add("运费管理");
        drawId.add(R.mipmap.shop_btn_employee);
        storename.add("员工管理");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_store_grid, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_itemTest.setText(storename.get(position));
        holder.iv_itemImage.setImageResource(drawId.get(position));

        holder.line_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {

                    callBack.onStoreRecycler(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_itemTest;

        private ImageView iv_itemImage;
        private LinearLayout line_item;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_itemTest = (TextView) itemView.findViewById(R.id.tv_itemTest);
            iv_itemImage = (ImageView) itemView.findViewById(R.id.iv_itemImage);
            line_item = (LinearLayout) itemView.findViewById(R.id.line_item);
        }
    }


    public interface StoreAdapterCallBack {

        void onStoreRecycler(int position);
    }


    public void setOnItemClickStore(StoreAdapterCallBack callBack) {

        this.callBack = callBack;

    }
}
