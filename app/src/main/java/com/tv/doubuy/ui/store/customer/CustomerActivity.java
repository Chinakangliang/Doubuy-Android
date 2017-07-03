package com.tv.doubuy.ui.store.customer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class CustomerActivity extends BaseActivity implements CustomerAdapter.CustomerAdapteCallBack, View.OnClickListener {
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
        setListenter();

        tvTitle.setText("客户管理");
    }

    public void initviews() {
        douBuyCache = new DouBuyCache(this);
        customerAdapter =new CustomerAdapter(this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(customerAdapter);
        RetrofitUtils.getInstance(this).getCustomerList(douBuyCache.getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                CustomerModel customerModel = APIUtils.gson.fromJson(o.toString(), CustomerModel.class);
                if (customerModel != null) {
                    customerAdapter.setData(customerModel.getResults());
                }
            }
        }, this));
    }

    private void setListenter() {
        customerAdapter.setAdapterClick(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void setItemClick(int position) {
        Toast.makeText(this, "gg" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
