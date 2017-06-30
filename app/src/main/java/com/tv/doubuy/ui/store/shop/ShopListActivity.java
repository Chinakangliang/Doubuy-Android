package com.tv.doubuy.ui.store.shop;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.ui.store.shop.shopclass.ShopManageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class ShopListActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rb_allshop)
    RadioButton rbAllshop;
    @BindView(R.id.rb_shopcalss)
    RadioButton rbShopcalss;
    @BindView(R.id.rg_shoptitle)
    RadioGroup rgShoptitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_search)
    ImageView ivSearch;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplist);
        ButterKnife.bind(this);
        initViews();
        setListner();
    }


    public void setListner() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initViews() {
        fragments = new ArrayList<>();
        addFragment();
        rgShoptitle.check(R.id.rb_allshop);
        switchFragment(0);
        rgShoptitle.setOnCheckedChangeListener(this);


    }

    private void switchFragment(int position) {
        //开启事务
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        //遍历集合
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            if (i == position) {
                //显示fragment
                if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,显示
                    fragmentTransaction.show(fragment);
                } else {
                    //如果这个fragment没有被事务添加过,添加
                    fragmentTransaction.add(R.id.fragment, fragment);
                }
            } else {
                //隐藏fragment
                if (fragment.isAdded()) {
                    //如果这个fragment已经被事务添加,隐藏
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        //提交事务
        fragmentTransaction.commit();
    }

    private void addFragment() {
        fragments.add(AllShopFragment.newInstance(""));
        fragments.add(ShopManageFragment.newInstance(""));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_allshop:
                switchFragment(0);
                rbAllshop.setTextColor(getResources().getColor(R.color.white));
                rbShopcalss.setTextColor(getResources().getColor(R.color.color2851));
                break;
            case R.id.rb_shopcalss:
                switchFragment(1);
                rbAllshop.setTextColor(getResources().getColor(R.color.color2851));
                rbShopcalss.setTextColor(getResources().getColor(R.color.white));
                break;
        }
    }
}
