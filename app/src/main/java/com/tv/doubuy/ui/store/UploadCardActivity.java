package com.tv.doubuy.ui.store;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.tv.doubuy.model.requestModel.ShopIdCardModel;
import com.tv.doubuy.model.responseModel.ShopInfoSubmitModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.PicassoHelper;
import com.tv.doubuy.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/9.
 */

public class UploadCardActivity extends BaseActivity implements View.OnClickListener, TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_photoFirst)
    ImageView ivPhotoFirst;
    @BindView(R.id.iv_photoTwo)
    ImageView ivPhotoTwo;
    @BindView(R.id.bt_submit)
    Button btSubmit;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private CreateShposModel shposModel;
    private String photoPath1;
    private String photoPath2;
    int i = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ButterKnife.bind(this);
        initViews();
        setListener();


    }


    private void initViews() {
        tvTitle.setText("上传身份证");
        shposModel = (CreateShposModel) getIntent().getSerializableExtra("shposModel");

    }

    private void setListener() {
        ivBack.setOnClickListener(this);
        ivPhotoFirst.setOnClickListener(this);
        ivPhotoTwo.setOnClickListener(this);
        btSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_photoFirst:
                rootApply();
                break;
            case R.id.iv_photoTwo:
                rootApply();
                break;
            case R.id.bt_submit:
//                Intent intent = new Intent(UploadCardActivity.this, RealSumbitActivity.class);
//                startActivity(intent);
                if (!TextUtils.isEmpty(photoPath1) || !TextUtils.isEmpty(photoPath2)) {
                    putIdCardInfo();
                }
                putIdCardInfo();

                break;
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

                CustomHelper.getInstace().onPhotoGraph(getTakePhoto(), false);
            }

            @Override
            public void onAlbumClick() {
                CustomHelper.getInstace().onAlbumChoice(getTakePhoto(), false);

            }
        }).dialogshow();
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
                        ToastUtils.getInstance().showToast(UploadCardActivity.this, "没有使用相机和相册的权限，请在权限管理中开启!");


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

    @Override
    public void takeSuccess(final TResult result) {


        if (i < 2) {
            String path = result.getImage().getPath();
            PicassoHelper.getInstance().setLocalImage(UploadCardActivity.this, path, ivPhotoFirst);
            i++;
        } else {
            PicassoHelper.getInstance().setLocalImage(UploadCardActivity.this, result.getImage().getPath(), ivPhotoTwo);
        }

        AliyunUtils aliyunUtils = new AliyunUtils();
        aliyunUtils.upFile(result.getImage().

                getPath(), this);
        aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback()

        {
            @Override
            public void onSuccess(String fileUrl) {
                if (i == 1) {
                    photoPath1 = APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl;
                } else {
                    photoPath2 = APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl;

                }
            }

            @Override
            public void onFailure(Exception e) {
                ToastUtils.getInstance().showToast(UploadCardActivity.this, "上传失败请尝试重新上传!");
            }
        });

    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

    }

    public void putIdCardInfo() {

        ShopIdCardModel idCardModel = new ShopIdCardModel();
        idCardModel.setIdCardImage1(photoPath1);
        idCardModel.setIdCardImage2(photoPath2);

        RetrofitUtils utils = new RetrofitUtils(this);

        utils.putStoreInfo(APIUtils.getInstance(this).getStoreId(), idCardModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                ShopInfoSubmitModel infoSubmitModel = APIUtils.gson.fromJson(o.toString(), ShopInfoSubmitModel.class);
                if (infoSubmitModel != null) {
                    Intent intent = new Intent(UploadCardActivity.this, RealSumbitActivity.class);
                    startActivity(intent);
                }

            }
        }, this));

    }
}
