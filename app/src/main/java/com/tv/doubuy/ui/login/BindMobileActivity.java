package com.tv.doubuy.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
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

    private String openid;
    private RegisPresenter regisPresenter;
    private LoginRequestModel requestModel;
    private CountDownView countDownView;


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

    }

    public void setListener() {

        tvSendCode.setOnClickListener(this);
        tvNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_sendCode:
                requestModel.setMobile(etMobile.getText().toString());
                requestModel.setType("resetPassword");
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

//
//                Intent intent = new Intent(BindMobileActivity.this, SetPassActivity.class);
//                intent.putExtra("mobile", etMobile.getText().toString());
//                intent.putExtra("code", etCode.getText().toString());
//                startActivity(intent);
                setBindPhone();

                break;
        }

    }

    //
    public void setBindPhone() {

        BindMobileModel bindMobileModel = new BindMobileModel();

        bindMobileModel.setCode(etCode.getText().toString());
        bindMobileModel.setMobile(etMobile.getText().toString());
        bindMobileModel.setOpenid(openid);

        Log.i("111", "------------OPEN------" + openid + "----code-" + etCode.getText() + "-----mobile--" + etMobile.getText());
        RetrofitUtils.getInstance(this).setBindMobile(bindMobileModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                Log.i("111", "----Object---" + o.toString());
            }
        }, this));

    }


}
