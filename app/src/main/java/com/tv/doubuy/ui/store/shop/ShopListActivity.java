package com.tv.doubuy.ui.store.shop;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class ShopListActivity extends BaseActivity {

    @BindView(R.id.rb_allshop)
    RadioButton rbAllshop;
    @BindView(R.id.rb_shopcalss)
    RadioButton rbShopcalss;
    @BindView(R.id.rg_shoptitle)
    RadioGroup rgShoptitle;

    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplist);
        ButterKnife.bind(this);
        initViews();
        setListener();
    }


    public void initViews() {
        fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    private void setListener() {

        rgShoptitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_allshop: {
                        fragment = AllShopFragment.newInstance("aaa");
                    }
                    break;
                    case R.id.rb_shopcalss: {
                        fragment = ShopManageFragment.newInstance("cc");
                    }
                    break;

                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
                }
            }
        });

        if (fragment == null) {
            fragment = ShopManageFragment.newInstance("aaa");
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, AllShopFragment.newInstance("cc")).commit();
        }
    }

}
