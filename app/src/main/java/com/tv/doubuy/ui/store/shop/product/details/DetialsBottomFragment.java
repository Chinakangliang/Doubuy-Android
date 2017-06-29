package com.tv.doubuy.ui.store.shop.product.details;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.TabItemAdapter;
import com.tv.doubuy.base.BaseExtendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */

public class DetialsBottomFragment extends BaseExtendFragment {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.mSViewPager)
    ViewPager mSViewPager;

    private List<String> mTitleList;
    private List<Fragment> tabViews;

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_bottom_product_detials, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initviews();
    }


    public void initviews() {
        Bundle bundle = getArguments();

//        DetialsProductModel productModel = (DetialsProductModel) bundle.getSerializable("productModel");
        setTabViews();

    }


    public void setTabViews() {

        mTitleList = new ArrayList<>();
        tabViews = new ArrayList<>();

        tabViews.add(ProductsMessageFragment.newInstance(""));
        tabViews.add(ProductsMessageFragment.newInstance(""));
        mTitleList.add("图文详情");
        mTitleList.add("商品评价");


        tablayout.setTabMode(TabLayout.MODE_FIXED);
        mSViewPager.setAdapter(new TabItemAdapter(getActivity().getSupportFragmentManager(), tabViews, mTitleList));
        tablayout.setupWithViewPager(mSViewPager);
        mSViewPager.setCurrentItem(0);//默认选中

    }
}
