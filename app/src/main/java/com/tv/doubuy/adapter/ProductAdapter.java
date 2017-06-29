package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.model.responseModel.ProductsListModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.utils.PicassoHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/16.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


    private List<ProductsListModel.ResultsBean> list = new ArrayList<>();
    private EmployAdapteCallBack callBack;
    private LayoutInflater mInflater;

    public ProductAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<ProductsListModel.ResultsBean> mlist) {
        list.clear();
        list.addAll(mlist);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_product_list_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setTag(position);

        holder.tvProductName.setText(list.get(position).getName());
        holder.tvProductPice.setText(APIService.FUHAO + list.get(position).getPromotionPrice());
        holder.tvProductInven.setText(list.get(position).getDescription());

        PicassoHelper.getInstance().setImage(holder.ivProductHead.getContext(), list.get(position).getThumb(), holder.ivProductHead);

        holder.relaitemProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.setItemClick(list.get(position).getId() + "");
                }
            }
        });
        holder.itemIvwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callBack != null) {
                    callBack.setItemShowPopWindowShow(position, holder.itemIvwindow, list.get(position).getId() + "");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox itemIvwindow;

        private TextView tvProductName;

        private TextView tvProductPice;

        private TextView tvProductInven;

        private ImageView ivProductHead;

        private RelativeLayout relaitemProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            itemIvwindow = (CheckBox) itemView.findViewById(R.id.item_iv_window);

            tvProductName = (TextView) itemView.findViewById(R.id.tv_productname);
            tvProductPice = (TextView) itemView.findViewById(R.id.tv_productprcie);
            tvProductInven = (TextView) itemView.findViewById(R.id.tv_productinven);
            ivProductHead = (ImageView) itemView.findViewById(R.id.iv_product_head);
            relaitemProduct = (RelativeLayout) itemView.findViewById(R.id.rela_item_product);
        }
    }


    public interface EmployAdapteCallBack {
        void setItemClick(String productsid);

        void setItemShowPopWindowShow(int position, View view, String productid);
    }

    public void setAdapterClick(EmployAdapteCallBack callBack) {

        this.callBack = callBack;
    }

    public void removeItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }
}
