package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.model.responseModel.CreateProductSKUs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/22.
 */

public class EditorAdapter extends RecyclerView.Adapter<EditorAdapter.ViewHolder> {

    private List<CreateProductSKUs> list;

    private Context context;


    private LayoutInflater mInflater;
    private SpecAdapterCallback callback;

    private ProductSKUsBean productSKUsBean;

    private List<ProductSKUsBean> skUsBeanList;


    public EditorAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        productSKUsBean = new ProductSKUsBean();

        skUsBeanList = new ArrayList<>();
    }

    public void setData(List<CreateProductSKUs> list) {
        this.list = list;
        notifyItemChanged(list.size() - 1);
    }


    public void setNotifyData(List<CreateProductSKUs> list, int position) {
        this.list = list;
        notifyItemInserted(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.include_addshop_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setTag(position + 1);
        holder.et_item_inven.setTag(position + 1);
        holder.et_item_spec.setTag(position + 1);
        holder.et_item_pice.setTag(position + 1);
        holder.iv_detele.setTag(position + 1);

        holder.et_item_pice.setText(list.get(position + 1).getPrice() + "");
        holder.et_item_spec.setText(list.get(position + 1).getSpec());
        holder.et_item_inven.setText(list.get(position + 1).getCount() + "");

        final String inven = holder.et_item_inven.getText().toString().trim();
        final String price = holder.et_item_pice.getText().toString().trim();
        final String sepc = holder.et_item_spec.getText().toString().trim();

        productSKUsBean.setCount(inven);
        productSKUsBean.setPrice(price);
        productSKUsBean.setSpec(sepc);
        skUsBeanList.add(productSKUsBean);

        if (skUsBeanList.size() > 0) {
            holder.et_item_pice.setText(skUsBeanList.get(position).getPrice());
            holder.et_item_spec.setText(skUsBeanList.get(position).getSpec());
            holder.et_item_inven.setText(skUsBeanList.get(position).getCount() + "");

        }

        holder.iv_detele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callback != null && (int) holder.iv_detele.getTag() == position + 1) {

                    callback.itemDetele(position + 1);

                }
            }
        });

        holder.tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.itemonClick(position + 1, skUsBeanList);
                    holder.tv_save.setVisibility(View.INVISIBLE);
                    holder.et_item_pice.setFocusable(false);
                    holder.et_item_inven.setFocusable(false);
                    holder.et_item_inven.setFocusable(false);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() - 1 : 0;
    }


    public void removeitem(int position) {
        list.remove(position);
        notifyItemInserted(position - 1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private EditText et_item_spec;
        private EditText et_item_pice;
        private EditText et_item_inven;
        private ImageView iv_detele;
        private TextView tv_save;
        private LinearLayout linear_item;

        public ViewHolder(View itemView) {
            super(itemView);
            et_item_spec = (EditText) itemView.findViewById(R.id.et_item_spec);
            et_item_pice = (EditText) itemView.findViewById(R.id.et_item_pice);
            et_item_inven = (EditText) itemView.findViewById(R.id.et_item_inven);
            iv_detele = (ImageView) itemView.findViewById(R.id.iv_detele);
            tv_save = (TextView) itemView.findViewById(R.id.tv_save);
            linear_item = (LinearLayout) itemView.findViewById(R.id.linear_item);
        }
    }


    public interface SpecAdapterCallback {
        void itemonClick(int position, List<ProductSKUsBean> listbean);

        void itemDetele(int position);

    }

    public void setSpecClick(SpecAdapterCallback callback) {

        this.callback = callback;
    }


}
