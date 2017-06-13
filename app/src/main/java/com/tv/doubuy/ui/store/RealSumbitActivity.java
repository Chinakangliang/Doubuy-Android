package com.tv.doubuy.ui.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/13.
 */

public class RealSumbitActivity extends BaseActivity implements OnClickListener {

    @BindView(R.id.bt_Continue)
    Button btContinue;
    @BindView(R.id.bt_now)
    Button btNow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_real_sumbit);
        ButterKnife.bind(this);
        setListener();
    }


    public void setListener() {
        btNow.setOnClickListener(this);
        btContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.bt_Continue:
                intent.setClass(this, ContinueStoreActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_now:
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                finish();

                break;
        }

    }
}
