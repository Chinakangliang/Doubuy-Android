package com.tv.doubuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.ui.login.LoginActivity;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/12.
 */

public class WelcomeActivity extends BaseActivity {

    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
    }

    public void initViews() {

        douBuyCache = new DouBuyCache(this);
        Intent intent = new Intent();

        if (douBuyCache.getUserToken() != null && !douBuyCache.getUserToken().equals("")) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        } else {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
