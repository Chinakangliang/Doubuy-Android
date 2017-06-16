package com.tv.doubuy.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.utils.DouBuyApplication;
import com.tv.doubuy.utils.DouBuyCache;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/16.
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_exit)
    TextView tvExit;

    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        douBuyCache = new DouBuyCache(this);
        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                douBuyCache.removeCache();
                DouBuyApplication.getInstance().removeToken();
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.putExtra(MainActivity.TAG_EXIT, true);
                startActivity(intent);

            }
        });
    }

}
