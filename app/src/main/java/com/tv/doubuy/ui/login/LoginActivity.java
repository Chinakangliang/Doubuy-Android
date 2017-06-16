package com.tv.doubuy.ui.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.SiginModel;
import com.tv.doubuy.model.responseModel.UserInfoModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyApplication;
import com.tv.doubuy.utils.DouBuyCache;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/6.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.video_view)
    VideoView videoView;
    @BindView(R.id.lin_wxlogin)
    LinearLayout linWxlogin;
    @BindView(R.id.lin_regis)
    LinearLayout linRegis;
    @BindView(R.id.ib_login)
    ImageButton ibLogin;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_mobileDetele)
    ImageView ivMobileDetele;
    @BindView(R.id.iv_passDetele)
    ImageView ivPassDetele;
    @BindView(R.id.ck_preview)
    CheckBox ckPreview;
    @BindView(R.id.tv_forgot)
    TextView tvForgot;


    private DouBuyCache douBuyCache;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        initVideoViews();

        setListener();

        douBuyCache = new DouBuyCache(LoginActivity.this);

    }


    private void setListener() {

        linRegis.setOnClickListener(this);
        linWxlogin.setOnClickListener(this);
        ibLogin.setOnClickListener(this);
        ivMobileDetele.setOnClickListener(this);
        ivPassDetele.setOnClickListener(this);
        tvForgot.setOnClickListener(this);

        ckPreview.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

                } else {
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    public void initVideoViews() {
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            videoView.setBackgroundColor(Color.TRANSPARENT);
                        return true;
                    }
                });
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                            videoView.setBackgroundColor(Color.TRANSPARENT);
                        }

                        return true;
                    }
                });
            }
        });

    }

    //返回重启加载
    @Override
    protected void onRestart() {
        super.onRestart();
        initVideoViews();

    }

    //防止锁屏或者切出的时候，音乐在播放
    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.lin_regis:
                intent.setClass(LoginActivity.this, RegisActivity.class);
                startActivity(intent);
                break;
            case R.id.lin_wxlogin:
                if (WechatHelper.getInstance(this).isWXAppInstalled()) {

                    WechatHelper.getInstance(this).onWechatLogin();
                } else {
                    Toast.makeText(LoginActivity.this, "请安装微信", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.ib_login:
                setUserLogin();

                break;
            case R.id.iv_mobileDetele:
                etMobile.setText("");
                break;
            case R.id.iv_passDetele:
                etPassword.setText("");
                break;
            case R.id.tv_forgot:
                intent.setClass(LoginActivity.this, ForgotActivity.class);
                startActivity(intent);
                break;

        }

    }

    /**
     * 登录
     */
    public void setUserLogin() {

        SiginModel siginModel = new SiginModel();
        siginModel.setMobile(etMobile.getText().toString());
        siginModel.setPassword(etPassword.getText().toString());

        RetrofitUtils.getInstance(this).setUserSignin(siginModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                UserInfoModel infoModel = APIUtils.gson.fromJson(o.toString(), UserInfoModel.class);
                if (infoModel.getToken() != null || !infoModel.getToken().equals("")) {
                    douBuyCache.saveUserToken(infoModel.getToken());
                    douBuyCache.saveUserId(infoModel.getUser().getId() + "");
                    douBuyCache.saveStoreId(infoModel.getUser().getShop().getId() + "");

                    DouBuyApplication.getInstance().setUserToken(infoModel.getToken());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }

        }, this));

    }
}
