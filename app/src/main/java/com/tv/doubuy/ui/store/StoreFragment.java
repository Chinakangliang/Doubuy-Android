package com.tv.doubuy.ui.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.model.responseModel.StoreModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by apple on 2017/6/9.
 */

public class StoreFragment extends BaseExtendFragment implements View.OnClickListener {
    @BindView(R.id.tv_openStore)
    TextView tvOpenStore;
    @BindView(R.id.line_open_store)
    LinearLayout lineOpenStore;
    @BindView(R.id.line_store_type)
    LinearLayout lineStoreType;

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_store, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        setListener();
        initViews();
    }


    public void initViews() {

        RetrofitUtils.getInstance(getActivity()).getStoreInfo(APIUtils.getInstance(getActivity()).getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                StoreModel storeModel = APIUtils.gson.fromJson(o.toString(), StoreModel.class);

                if (storeModel != null) {

                    if (storeModel.getProfile().getRealNameStatus().equals("notApply")) {
                        lineOpenStore.setVisibility(View.VISIBLE);
                        lineStoreType.setVisibility(View.GONE);
                    } else if (storeModel.getProfile().getRealNameStatus().equals("pending")) {

                    } else if (storeModel.getProfile().getRealNameStatus().equals("verified")) {

                    } else {

                    }

                }

            }
        }, getActivity()));
    }

    public void setListener() {
        tvOpenStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_openStore:

                intent.setClass(getActivity(), OpenStoreActivity.class);
                startActivity(intent);
                break;
        }
    }



}