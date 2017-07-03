package com.tv.doubuy.ui.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.StoreGridAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.model.responseModel.StoreInfoModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.ui.store.customer.CustomerActivity;
import com.tv.doubuy.ui.store.employees.EmployActivity;
import com.tv.doubuy.ui.store.freight.FreightActivity;
import com.tv.doubuy.ui.store.shop.ShopListActivity;
import com.tv.doubuy.utils.DouBuyCache;
import com.tv.doubuy.utils.PicassoHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/9.
 */

public class StoreFragment extends BaseExtendFragment implements View.OnClickListener, StoreGridAdapter.StoreAdapterCallBack {
    @BindView(R.id.tv_openStore)
    TextView tvOpenStore;
    @BindView(R.id.line_open_store)
    LinearLayout lineOpenStore;
    @BindView(R.id.line_store_type)
    LinearLayout lineStoreType;
    @BindView(R.id.liner_manage)
    RelativeLayout linerManage;
    @BindView(R.id.recyler)
    RecyclerView recyler;

    @BindView(R.id.iv_store_setting)
    ImageView ivStoreSetting;
    @BindView(R.id.tv_storeName)
    TextView tvStoreName;
    @BindView(R.id.tv_storeLevel)
    TextView tvStoreLevel;
    @BindView(R.id.iv_StoreHead)
    ImageView ivStoreHead;

    private StoreGridAdapter storeAdapter;
    private StoreInfoModel storeModel;

    private static final String ARG_PARAM = "param";
    private String mParam;

    public static StoreFragment newInstance(String param) {
        StoreFragment fragment = new StoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }


    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_store, null);
        ButterKnife.bind(this, view);
        setContentView(view);

    }

    @Override
    public void onResumeExtend() {
        super.onResumeExtend();
        initViews();
        setListener();
    }

    public void initViews() {
//        String id = APIUtils.getInstance(getActivity()).getStoreId();

        DouBuyCache douBuyCache = new DouBuyCache(getActivity());

        Log.i("111", "--douBuyCache---" + douBuyCache.getStoreId());
        RetrofitUtils retrofitUtils = new RetrofitUtils(getActivity());
        retrofitUtils.getStoreInfo(douBuyCache.getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                storeModel = APIUtils.gson.fromJson(o.toString(), StoreInfoModel.class);

                if (storeModel != null) {
                    PicassoHelper.getInstance().setAvatar(getActivity(), storeModel.getLogo(), ivStoreHead);
                    tvStoreName.setText(storeModel.getName());
                    //// TODO: 2017/6/14  这里需要判断审核状态 ，感觉不是很合理暂时未处理
                    switch (storeModel.getProfile().getRealNameStatus()) {
                        case "notApply":
                            lineOpenStore.setVisibility(View.VISIBLE);
                            lineStoreType.setVisibility(View.GONE);
                            break;
                        case "pending":
                            lineOpenStore.setVisibility(View.GONE);
                            lineStoreType.setVisibility(View.GONE);
                            linerManage.setVisibility(View.VISIBLE);
                            initData();
                            break;
                        case "verified":
                            break;
                    }


                }

            }
        }, getActivity()));
    }


    public void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyler.setLayoutManager(gridLayoutManager);
        storeAdapter = new StoreGridAdapter(getActivity());
        recyler.setAdapter(storeAdapter);

        storeAdapter.setOnItemClickStore(this);
    }

    public void setListener() {
        tvOpenStore.setOnClickListener(this);
        ivStoreSetting.setOnClickListener(this);
        ivStoreHead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_openStore:
                intent.setClass(getActivity(), OpenStoreActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_store_setting:
                intent.setClass(getActivity(), ContinueStoreActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_StoreHead:
                Bundle bundle = new Bundle();
                intent.setClass(getActivity(), StoreMessageActivity.class);
                bundle.putSerializable("storeModel", storeModel);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onStoreRecycler(int position) {

        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(getActivity(), ShopListActivity.class);
                startActivity(intent);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                intent.setClass(getActivity(), CustomerActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(getActivity(), FreightActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent.setClass(getActivity(), EmployActivity.class);
                startActivity(intent);
                break;
        }


    }


}
