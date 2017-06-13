package com.tv.doubuy.ui.store;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.CreateShposModel;
import com.tv.doubuy.model.responseModel.CertifyModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;

import java.net.URLEncoder;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/9.
 */

public class RealActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rela_idcard)
    RelativeLayout relaIdcard;
    @BindView(R.id.rela_aliAuth)
    RelativeLayout relaAliAuth;

    private CreateShposModel shposModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    public void initView() {
        tvTitle.setText("上传身份证");

        shposModel = (CreateShposModel) getIntent().getSerializableExtra("shpsModel");
    }

    /**
     * 蚂蚁验证调用服务器接口
     */
    public void setUserMYReal() {

        RetrofitUtils.getInstance(this).getCreateZM(APIUtils.getInstance(this).getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                CertifyModel certifyModel = APIUtils.gson.fromJson(o.toString(), CertifyModel.class);
                if (certifyModel != null) {

                    doVerify(certifyModel.getCertifyUrl());

                }
            }
        }, this));

    }


    public void setListener() {

        ivBack.setOnClickListener(this);
        relaIdcard.setOnClickListener(this);
        relaAliAuth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;

            case R.id.rela_idcard:

                Intent intent = new Intent(this, UploadCardActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("shposModel", shposModel);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.rela_aliAuth:
                setUserMYReal();
                //TODO蚂蚁验证
                break;
        }

    }

    private void doVerify(String url) {
        if (hasApplication()) {
            Intent action = new Intent(Intent.ACTION_VIEW);
            StringBuilder builder = new StringBuilder();
            builder.append("alipays://platformapi/startapp?appId=20000067&url=");
            builder.append(URLEncoder.encode(url));
            action.setData(Uri.parse(builder.toString()));
            startActivity(action);
        } else {
            //处理没有安装支付宝的情况
            new AlertDialog.Builder(this)
                    .setMessage("是否下载并安装支付宝完成认证?")
                    .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent action = new Intent(Intent.ACTION_VIEW);
                            action.setData(Uri.parse("https://m.alipay.com"));
                            startActivity(action);
                        }
                    }).setNegativeButton("算了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    }

    /**
     * 判断是否安装了支付宝
     *
     * @return true 为已经安装
     */
    private boolean hasApplication() {
        PackageManager manager = getPackageManager();
        Intent action = new Intent(Intent.ACTION_VIEW);
        action.setData(Uri.parse("alipays://"));
        List<ResolveInfo> list = manager.queryIntentActivities(action, PackageManager.GET_RESOLVED_FILTER);
        return list != null && list.size() > 0;
    }


}
