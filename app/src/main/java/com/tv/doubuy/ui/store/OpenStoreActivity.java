package com.tv.doubuy.ui.store;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.dialog.ActionSheetDialog;
import com.tv.doubuy.model.requestModel.CreateShposModel;
import com.tv.doubuy.model.responseModel.UserShopModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.DouBuyCache;
import com.tv.doubuy.utils.PicassoHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by apple on 2017/6/9.
 */

public class OpenStoreActivity extends BaseActivity implements View.OnClickListener, TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.et_storeName)
    EditText etStoreName;
    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_idcart)
    EditText etIdcart;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    private String photoPath;

    private DouBuyCache douBuyCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_open);
        ButterKnife.bind(this);
        initViews();
        setListener();
    }

    public void initViews() {

        douBuyCache = new DouBuyCache(this);
        tvTitle.setText("一键开店");
    }

    public void setListener() {
        ivBack.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
        btNext.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_photo:
                rootApply();
                break;
            case R.id.bt_next:

                setUserCreate();
                break;
        }

    }


    public void setUserCreate() {

        boolean store = TextUtils.isEmpty(etStoreName.getText().toString());

        boolean name = TextUtils.isEmpty(etUserName.getText().toString());

        boolean iDcart = TextUtils.isEmpty(etIdcart.getText().toString());

        if (!store && !name && !iDcart) {
            final CreateShposModel shpsModel = new CreateShposModel();
            shpsModel.setName(etStoreName.getText().toString());
            shpsModel.setRealName(etUserName.getText().toString());
            shpsModel.setPersonNO(etIdcart.getText().toString());
            shpsModel.setLogo(APIService.ALIYUN_OSS_IMAGE_PATH + photoPath);
            RetrofitUtils utils = new RetrofitUtils(this);
            utils.setCreateShop(shpsModel, new ProgressSubscriber(new SubscriberOnNextListener() {
                @Override
                public void onNext(Object o) {

                    UserShopModel userShopModel = APIUtils.gson.fromJson(o.toString(), UserShopModel.class);

                    if (userShopModel != null) {
                        douBuyCache.saveStoreId(userShopModel.getId() + "");
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent(OpenStoreActivity.this, RealActivity.class);
                        bundle.putSerializable("shpsModel", shpsModel);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }

                }
            }, this));

        }
    }


    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(
                    new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }


    private void showHeadportraitDialog() {


        new ActionSheetDialog(this).builder().onClickSheetItem(new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onPicturesClick() {
                CustomHelper.getInstace().onPhotoGraph(getTakePhoto());
            }

            @Override
            public void onAlbumClick() {
                CustomHelper.getInstace().onAlbumChoice(getTakePhoto());

            }
        }).dialogshow();
    }


    @Override
    public void takeSuccess(TResult result) {

        AliyunUtils aliyunUtils = new AliyunUtils();
        aliyunUtils.upFile(result.getImage().getPath(), this);
        aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
            @Override
            public void onSuccess(String fileUrl) {
                photoPath = fileUrl;
                PicassoHelper.getInstance().setAvatar(OpenStoreActivity.this, fileUrl, ivPhoto);

            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(OpenStoreActivity.this, "上传失败请尝试重新上传！", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }


    private void rootApply() {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(this,
                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                , new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        showHeadportraitDialog();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(OpenStoreActivity.this, "没有使用相机和相册的权限，请在权限管理中开启", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this),
                invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode,
                permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

}
