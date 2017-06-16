package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tv.doubuy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/6/16.
 */

public class EmployAdapter extends RecyclerView.Adapter<EmployAdapter.ViewHolder> {


    private List<String> list = new ArrayList<>();
    private EmployAdapteCallBack callBack;
    private LayoutInflater mInflater;

    public EmployAdapter(Context context, List<String> mlist) {
        this.list = mlist;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_employ_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemView.setTag(position);
        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.setItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

    public interface EmployAdapteCallBack {
        void setItemClick(int position);
    }

    public void setAdapterClick(EmployAdapteCallBack callBack) {

        this.callBack = callBack;
    }
}
