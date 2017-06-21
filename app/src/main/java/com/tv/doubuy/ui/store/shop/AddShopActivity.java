package com.tv.doubuy.ui.store.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/21.
 */

public class AddShopActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.liner_shop_message)
    LinearLayout linerShopMessage;
    @BindView(R.id.tv_add_spec)
    TextView tvAddSpec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshop);
        ButterKnife.bind(this);
        initviews();
    }

    public void initviews() {
        tvTitle.setText("添加商品");
        final View view = LayoutInflater.from(this).inflate(R.layout.include_addshop_layout, null);

        tvAddSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerShopMessage.addView(view);
            }
        });
    }
}
