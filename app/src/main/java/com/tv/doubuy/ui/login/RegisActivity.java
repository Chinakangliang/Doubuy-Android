package com.tv.doubuy.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.view.CountDownView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/6.
 */
public class RegisActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_sigup)
    TextView tvSigup;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private CountDownView countDownView;
    private RegisPresenter regisPresenter;
    private LoginRequestModel requestModel;

    @BindView(R.id.tv_sendCode)
    TextView tvSendCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        ButterKnife.bind(this);
        initViews();
        setListener();
    }

    public void initViews() {
        countDownView = new CountDownView(60);
        regisPresenter = new RegisPresenter(this);
        requestModel = new LoginRequestModel();
        tvTitle.setText("注册");
    }


    public void setListener() {
        tvSendCode.setOnClickListener(this);

        tvSigup.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sendCode:
                requestModel.setMobile(etMobile.getText().toString());
//                requestModel.setType("resetPassword");
                countDownView.onStart();
                if (requestModel != null) {
                    regisPresenter.setUserCode(requestModel);
                }
                countDownView.setCountDownTimerListener(new CountDownView.CountDownTimerListener() {
                    @Override
                    public void onTick(String second) {
                        tvSendCode.setText(second + "后重发");
                        tvSendCode.setTextColor(getResources().getColor(R.color.colora7a7a7));

                    }

                    @Override
                    public void onFinish() {
                        tvSendCode.setText("点击重新获取");
                        tvSendCode.setTextColor(getResources().getColor(R.color.color2851));

                    }

                });

                break;
            case R.id.tv_sigup:
                regisPresenter.isStringUp(etMobile.getText().toString(), etCode.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.iv_back:
                finish();
                break;
        }

    }


}
