package com.tv.doubuy.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.requestModel.SiginModel;
import com.tv.doubuy.model.responseModel.UserInfoModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;
import com.tv.doubuy.view.CountDownView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 忘记密码
 */

public class ForgotActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_sendCode)
    TextView tvSendCode;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_sigup)
    TextView tvSigup;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private LoginRequestModel requestModel;
    private CountDownView countDownView;
    private RegisPresenter regisPresenter;
    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogot);
        ButterKnife.bind(this);
        initViews();
        setListener();

    }


    public void initViews() {

        requestModel = new LoginRequestModel();
        countDownView = new CountDownView(60);
        regisPresenter = new RegisPresenter(this);
        douBuyCache = new DouBuyCache(this);
        tvTitle.setText("设置新密码");
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

                setResterPassWord();
                break;
            case R.id.iv_back:
                finish();
                break;
        }

    }

    public void setResterPassWord() {

        SiginModel siginModel = new SiginModel();
        siginModel.setCode(etCode.getText().toString());
        siginModel.setMobile(etMobile.getText().toString());
        siginModel.setPassword(etPassword.getText().toString());


        RetrofitUtils.getInstance(this).setUserReste(siginModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                UserInfoModel infoModel = APIUtils.gson.fromJson(o.toString(), UserInfoModel.class);
                if (infoModel != null && infoModel.getToken() != null || !infoModel.getToken().equals("")) {
                    douBuyCache.saveUserToken(infoModel.getToken());
                    Intent intent = new Intent(ForgotActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, this));

    }
}
