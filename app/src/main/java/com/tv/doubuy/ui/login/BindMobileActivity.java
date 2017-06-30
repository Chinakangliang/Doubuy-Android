package com.tv.doubuy.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.responseModel.LoginModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;
import com.tv.doubuy.view.CountDownView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/7.
 */
public class BindMobileActivity extends BaseActivity implements OnClickListener {


    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_sendCode)
    TextView tvSendCode;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private String openid;
    private RegisPresenter regisPresenter;
    private LoginRequestModel requestModel;
    private CountDownView countDownView;

    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_mobile);
        ButterKnife.bind(this);

        initViews();
        setListener();
    }

    public void initViews() {

        openid = getIntent().getStringExtra("openid");

        countDownView = new CountDownView(60);
        regisPresenter = new RegisPresenter(this);

        requestModel = new LoginRequestModel();

        tvTitle.setText("绑定手机");

        douBuyCache = new DouBuyCache(this);

    }

    public void setListener() {

        tvSendCode.setOnClickListener(this);
        tvNext.setOnClickListener(this);
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

            case R.id.tv_next:
                setBindPhone();

                break;
            case R.id.iv_back:
                finish();
                break;
        }

    }

    // TODO 绑定手机  这里服务器存在问题,SO 接口暂时未调整
    public void setBindPhone() {

        BindMobileModel bindMobileModel = new BindMobileModel();

        bindMobileModel.setCode(etCode.getText().toString());
        bindMobileModel.setMobile(etMobile.getText().toString());
        bindMobileModel.setOpenid(openid);

        RetrofitUtils retrofitUtils = new RetrofitUtils(this);
        retrofitUtils.setBindMobile(bindMobileModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                LoginModel infoModel = APIUtils.gson.fromJson(o.toString(), LoginModel.class);
                if (infoModel.getToken() != null && !infoModel.getToken().equals("")) {

                    douBuyCache.saveUserId(infoModel.getUser().getId() + "");
                    douBuyCache.saveUserToken(infoModel.getToken());
                    douBuyCache.saveStoreId(infoModel.getUser().getShop().getId() + "");
                    Intent intent = new Intent(BindMobileActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, this));

    }


}
