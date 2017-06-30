package com.tv.doubuy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.model.responseModel.CustomerModel;
import com.tv.doubuy.utils.PicassoHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lxy on 2017/6/28.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    private List<CustomerModel.CustomerModelBean> list = new ArrayList<>();
    CustomerAdapteCallBack callBack;
    private LayoutInflater mInflater;

    public CustomerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<CustomerModel.CustomerModelBean> mlist) {
        this.list = mlist;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_customer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        PicassoHelper.getInstance().setImage(holder.icon.getContext(), list.get(position).getAvatar(), holder.icon);
        holder.username.setText(list.get(position).getName());
        holder.userid.setText(list.get(position).getId() + "");
        holder.price.setText(list.get(position).getTotalBoughtAmount().toString());
        holder.relaitemCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.setItemClick(position);
                }
            }
        });
        if (list.get(position).getGender().equals("male")) {
            holder.gender.setImageResource(R.mipmap.staff_icon_boy);
        } else  {
            holder.gender.setImageResource(R.mipmap.staff_icon_girl);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView username;
        private TextView price;
        private TextView userid;
        private ImageView gender;
        private RelativeLayout relaitemCustomer;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.iv_customer_icon);
            price = (TextView) itemView.findViewById(R.id.tv_allprice);
            userid = (TextView) itemView.findViewById(R.id.tv_userid);
            username = (TextView) itemView.findViewById(R.id.tv_username);
            gender = (ImageView) itemView.findViewById(R.id.iv_gender);
            relaitemCustomer = (RelativeLayout) itemView.findViewById(R.id.customercell);
        }
    }

    public interface CustomerAdapteCallBack {
        void setItemClick(int position);
    }

    public void setAdapterClick(CustomerAdapteCallBack callBack) {
        this.callBack = callBack;
    }
}
