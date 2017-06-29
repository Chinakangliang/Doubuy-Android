package com.tv.doubuy.ui.store.customer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.CustomerAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.responseModel.CustomerModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lxy on 2017/6/28.
 */

public class CustomerActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_right)
    Button btRight;
    @BindView(R.id.recycler_customer)
    RecyclerView recyler;

    private CustomerAdapter customerAdapter;
    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.bind(this);
        initviews();

    }

    public void initviews() {
        douBuyCache=new DouBuyCache(this);
        customerAdapter=new CustomerAdapter(this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(customerAdapter);
        RetrofitUtils.getInstance(this).getCustomerList(douBuyCache.getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                List<CustomerModel> customerModel= (List<CustomerModel>) APIUtils.gson.fromJson(o.toString(),CustomerModel.class);
                if (customerModel!=null) {
                    customerAdapter.setData(customerModel);

                }
            }
        }, this));
    }
}
