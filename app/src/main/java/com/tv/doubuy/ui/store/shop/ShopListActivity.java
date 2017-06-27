package com.tv.doubuy.ui.store.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.ui.store.shop.search.SearchActivity;
import com.tv.doubuy.ui.store.shop.shopclass.ShopManageFragment;

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
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_search)
    ImageView ivSearch;

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

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopListActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        rgShoptitle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_allshop: {
                        fragment = AllShopFragment.newInstance("aaa");
                        rbAllshop.setTextColor(getResources().getColor(R.color.white));
                        rbShopcalss.setTextColor(getResources().getColor(R.color.color2851));
                    }
                    break;
                    case R.id.rb_shopcalss: {
                        fragment = ShopManageFragment.newInstance("cc");
                        rbAllshop.setTextColor(getResources().getColor(R.color.color2851));
                        rbShopcalss.setTextColor(getResources().getColor(R.color.white));
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
