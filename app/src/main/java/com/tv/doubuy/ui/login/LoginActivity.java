package com.tv.doubuy.ui.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.view.CustomVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/6.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.video_view)
    CustomVideoView videoView;
    @BindView(R.id.lin_wxlogin)
    LinearLayout linWxlogin;
    @BindView(R.id.lin_regis)
    LinearLayout linRegis;

//    @BindView(R.id.iv_apply)
//    SimpleDraweeView ivApply;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        initVideoViews();
//

        setListener();
//        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
//                .setAutoPlayAnimations(true)
//                .setUri(Uri.parse("res://" + getPackageName() + "/" + R.drawable.aaaa))//设置uri
//                .build();
//        ivApply.setController(mDraweeController);
    }


    private void setListener() {

        linRegis.setOnClickListener(this);
        linWxlogin.setOnClickListener(this);


//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

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
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            videoView.setBackgroundColor(Color.TRANSPARENT);
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

        }

    }

    public void getWXLoginToken(String code) {

        RetrofitUtils.getInstance(this).setUserWXCode(code, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                Log.i("111", "-------o----" + o.toString());

            }
        }, this));
    }


}
