package com.tv.doubuy.ui.store.shop;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.TabLayoutPagerAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.dialog.ProductCheckDialog;
import com.tv.doubuy.dialog.SpinnerPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class AllShopFragment extends BaseExtendFragment implements View.OnClickListener {

    private static final String ARG_PARAM = "param";
    private String mParam;

    private List<Fragment> fragmentList;
    private List<String> stringList;
    @BindView(R.id.all_viewpager)
    ViewPager allViewpager;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.iv_spinner)
    ImageView ivSpinner;


    private SpinnerPopWindow spinnerWindow;
    private List<String> str = new ArrayList<>();


    public static AllShopFragment newInstance(String param) {
        AllShopFragment fragment = new AllShopFragment();
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

        View view = inflater.inflate(R.layout.fragment_allshop, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        initviews();
        setListener();
    }


    public void initviews() {
        for (int i = 0; i < 11; i++) {
            str.add("STR" + i);

        }

        fragmentList = new ArrayList<>();
        stringList = new ArrayList<>();
        fragmentList.add(SellFragment.newInstance("vbvnbnb"));
        fragmentList.add(SellFragment.newInstance("aa"));
        stringList.add("出售中");
        stringList.add("已下架");
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        TabLayoutPagerAdapter adapter = new TabLayoutPagerAdapter(getActivity().getSupportFragmentManager(),
                fragmentList, stringList);
        allViewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(allViewpager);

    }

    public void setListener() {
        ivSpinner.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_spinner:

                ProductCheckDialog productCheckDialog = new ProductCheckDialog(getActivity());
                productCheckDialog.setListData(str);
                productCheckDialog.show();
                productCheckDialog.setSelectListener(new ProductCheckDialog.ProductChecCallback() {
                    @Override
                    public void ProductCheckCallBack(int posotion, String newValue) {
                        Toast.makeText(getActivity(), "" + newValue, Toast.LENGTH_SHORT).show();
                    }
                });

                break;
        }
    }

    @Override
    public void onDestroyViewExtend() {
        if (spinnerWindow != null) {
            spinnerWindow.dismiss();
            spinnerWindow = null;
        }
        super.onDestroyViewExtend();
    }
}
