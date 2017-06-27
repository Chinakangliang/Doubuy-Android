package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.tv.doubuy.R;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.ui.store.shop.adds.ReleaseHelep;
import com.tv.doubuy.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2017/6/22.
 */

public class SpecAdapter extends RecyclerView.Adapter<SpecAdapter.ViewHolder> {

    private List<String> list;

    private Context context;

    private HashMap<String, String> hashMap;
    private List<HashMap> hashMapList;

    private LayoutInflater mInflater;
    private SpecAdapterCallback callback;

    private ProductSKUsBean productSKUsBean;

    private List<ProductSKUsBean> skUsBeanList;

    public SpecAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        hashMap = new HashMap<>();
        hashMapList = new ArrayList<>();
        productSKUsBean = new ProductSKUsBean();

        skUsBeanList = new ArrayList<>();
    }

    public void setData(List<String> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.include_addshop_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setTag(position);

        holder.iv_detele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (callback != null) {

                        productSKUsBean.setCount(holder.et_item_inven.getText().toString());
                        productSKUsBean.setPrice(holder.et_item_pice.getText().toString());
                        productSKUsBean.setSpec(holder.et_item_spec.getText().toString());
                        skUsBeanList.add(productSKUsBean);
                        callback.itemonClick(position, skUsBeanList);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    public void removeitem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private EditText et_item_spec;
        private EditText et_item_pice;
        private EditText et_item_inven;
        private ImageView iv_detele;

        public ViewHolder(View itemView) {
            super(itemView);
            et_item_spec = (EditText) itemView.findViewById(R.id.et_item_spec);
            et_item_pice = (EditText) itemView.findViewById(R.id.et_item_pice);
            et_item_inven = (EditText) itemView.findViewById(R.id.et_item_inven);
            iv_detele = (ImageView) itemView.findViewById(R.id.iv_detele);
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
