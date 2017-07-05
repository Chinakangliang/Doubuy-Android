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
import com.tv.doubuy.model.responseModel.SearchModels;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.utils.PicassoHelper;

import java.util.List;

/**
 * Created by apple on 2017/7/3.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private Context mcontext;
    private LayoutInflater mInflater;
    private List<SearchModels.ResultsBean> resultsBeen;

    private AdapteCallBack callBack;

    public SearchAdapter(Context context) {

        this.mcontext = context;

        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<SearchModels.ResultsBean> results) {

        this.resultsBeen = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_product_list_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemIvwindow.setVisibility(View.INVISIBLE);
        holder.tvProductName.setText(resultsBeen.get(position).getName());
        holder.tvProductPice.setText(APIService.FUHAO + resultsBeen.get(position).getScore());
        PicassoHelper.getInstance().setImage(mcontext, resultsBeen.get(position).getAvatar(), holder.ivProductHead);
        holder.tvProductInven.setText(resultsBeen.get(position).getTotalIncome() + "'");
        holder.relaitemProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack!=null){
                    callBack.setItemClick(resultsBeen.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsBeen != null ? resultsBeen.size() : 0;
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

    public interface AdapteCallBack {
        void setItemClick(int productsid);

    }

    public void setAdapterClick(AdapteCallBack callBack) {

        this.callBack = callBack;
    }


}
