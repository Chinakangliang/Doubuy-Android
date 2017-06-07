package com.tv.doubuy.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.network.RetrofitUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/7.
 */
public class SetPassActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_phoneNumber)
    TextView tvPhoneNumber;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_complete)
    TextView tvComplete;

    private String mobile;

    private String code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        ButterKnife.bind(this);
        initViews();
    }


    public void initViews() {

        mobile = getIntent().getStringExtra("mobile");
        code = getIntent().getStringExtra("code");

        tvPhoneNumber.setText("+86 " + mobile);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_complete:
//                initInterBind();
                break;
        }

    }

//    public void setBindPhone() {
//
//        BindMobileModel bindMobileModel = new BindMobileModel();
//
//        bindMobileModel.setCode(code);
//        bindMobileModel.setMobile();
//        RetrofitUtils.getInstance(this).setBindMobile();
//
//    }
}
