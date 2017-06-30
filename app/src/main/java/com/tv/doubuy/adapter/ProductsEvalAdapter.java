package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tv.doubuy.R;

import java.util.List;

/**
 * Created by apple on 2017/6/29.
 */

public class ProductsEvalAdapter extends RecyclerView.Adapter<ProductsEvalAdapter.ViewHolder> {


    private Context mcontext;
    private LayoutInflater mInflater;

    private List<String> mlist;

    public ProductsEvalAdapter(Context context, List<String> str) {

        this.mcontext = context;
        this.mlist = str;

        mInflater = LayoutInflater.from(context);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_details_eval, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
