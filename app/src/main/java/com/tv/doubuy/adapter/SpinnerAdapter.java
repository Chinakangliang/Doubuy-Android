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
 * Created by apple on 2017/6/19.
 */

public class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.ViewHolder> {

    private Context mcontext;

    private LayoutInflater mInflater;

    private List<String> list;
    private SpinnerAdapterCallBack callBack;

    public SpinnerAdapter(Context context, List<String> mlist) {

        this.mcontext = context;
        this.list = mlist;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_wpinner_window_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        holder.item_test.setText(list.get(position));

        if (position == 0) {

            holder.item_test.setBackgroundResource(R.mipmap.product_bg_first_sort);
            holder.item_test.setTextColor(mcontext.getResources().getColor(R.color.white));
        } else {
            holder.item_test.setBackgroundResource(R.color.white);
            holder.item_test.setTextColor(mcontext.getResources().getColor(R.color.color0303));

        }


        holder.item_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.setItemClik(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_test;

        public ViewHolder(View itemView) {
            super(itemView);
            item_test = (TextView) itemView.findViewById(R.id.item_test);
        }
    }

    public interface SpinnerAdapterCallBack {

        void setItemClik(int position);
    }

    public void SpinnerAdapterItemCallBack(SpinnerAdapterCallBack callBack) {

        this.callBack = callBack;

    }
}
