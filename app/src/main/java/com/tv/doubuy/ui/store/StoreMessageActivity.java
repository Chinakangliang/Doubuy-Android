package com.tv.doubuy.ui.store;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tv.doubuy.model.requestModel.PutStoreInfoModel;
import com.tv.doubuy.model.responseModel.StoreMessageModel;
import com.tv.doubuy.model.responseModel.StoreModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.PicassoHelper;
import com.tv.doubuy.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/15.
 */

public class StoreMessageActivity extends BaseActivity implements View.OnClickListener, TakePhoto.TakeResultListener, InvokeListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_right)
    Button btRight;
    @BindView(R.id.iv_store_head)
    ImageView ivStoreHead;
    @BindView(R.id.et_storename)
    EditText etStoreName;
    @BindView(R.id.et_shop_owner)
    EditText etShopOwner;
    @BindView(R.id.et_contact)
    TextView etConatct;
    @BindView(R.id.tv_storeurl)
    TextView tvStoreurl;
    @BindView(R.id.tv_urlCopy)
    TextView tvUrlCopy;
    @BindView(R.id.et_description)
    EditText etDescription;
    @BindView(R.id.tv_wxcode)
    TextView tvWxCode;
    @BindView(R.id.iv_store_NameDelete)
    ImageView ivStoreNameDelete;
    @BindView(R.id.iv_user_NameDelete)
    ImageView ivUserNameDelete;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private String photoPath;
    private StoreModel storemodel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_message);
        ButterKnife.bind(this);
        initViews();
        setListener();
    }

    public void initViews() {
        tvTitle.setText("店铺资料");
        btRight.setText("编辑");
        storemodel = (StoreModel) getIntent().getSerializableExtra("storeModel");

        if (storemodel != null) {
            etStoreName.setText(storemodel.getName());
            PicassoHelper.getInstance().setAvatar(this, storemodel.getLogo(), ivStoreHead);
            etDescription.setText(storemodel.getDescription());
            etShopOwner.setText(storemodel.getOwner().getName());
            etConatct.setText(storemodel.getOwner().getMobile());
            tvWxCode.setText("//TODO 暂时未获取");
        }
    }

    public void setListener() {
        ivBack.setOnClickListener(this);
        btRight.setOnClickListener(this);
        ivStoreHead.setOnClickListener(this);
        tvUrlCopy.setOnClickListener(this);
        ivStoreNameDelete.setOnClickListener(this);
        ivUserNameDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_right:
                if ("完成".equals(btRight.getText())) {
                    btRight.setText("编辑");
                    etStoreName.setEnabled(true);
                    etDescription.setEnabled(true);
                    etShopOwner.setEnabled(true);
                } else {
                    btRight.setText("完成");
                    etStoreName.setEnabled(false);
                    etDescription.setEnabled(false);
                    etShopOwner.setEnabled(false);
                    putStoreInfo();
                }

                break;
            case R.id.iv_store_head:
                rootApply();
                break;
            case R.id.tv_urlCopy:
                StringUtils.StrCopy(this, tvStoreurl.getText().toString());
                Toast.makeText(this, "复制成功！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_store_NameDelete:
                if ("编辑".equals(btRight.getText())) {
                    etStoreName.setText("");
                }
                break;
            case R.id.iv_user_NameDelete:
                if ("编辑".equals(btRight.getText())) {
                    etShopOwner.setText("");
                }
                break;
        }

    }

    public void putStoreInfo() {
        PutStoreInfoModel infomodel = new PutStoreInfoModel();
        infomodel.setLogo(photoPath);
        infomodel.setCover("aaaaa");
        infomodel.setDescription(etDescription.getText().toString());
        infomodel.setName(etStoreName.getText().toString());
        infomodel.setServieAviable(true);

        RetrofitUtils utils = new RetrofitUtils(this);
        utils.putModifyStoreInfo(APIUtils.getInstance(this).getStoreId(), infomodel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                StoreMessageModel storemodel = APIUtils.gson.fromJson(o.toString(), StoreMessageModel.class);
                if (storemodel != null) {

                    Toast.makeText(StoreMessageActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                }

            }
        }, this));
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
                        Toast.makeText(StoreMessageActivity.this, "没有使用相机和相册的权限，请在权限管理中开启", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showHeadportraitDialog() {


        new ActionSheetDialog(this).builder().onClickSheetItem(new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onPicturesClick() {

                CustomHelper.getInstace().onPhotoGraph(getTakePhoto(), true);
            }

            @Override
            public void onAlbumClick() {
                CustomHelper.getInstace().onAlbumChoice(getTakePhoto(), true);

            }
        }).dialogshow();
    }

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(
                    new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void takeSuccess(final TResult result) {

        AliyunUtils aliyunUtils = new AliyunUtils();
        aliyunUtils.upFile(result.getImage().getPath(), this);
        aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
            @Override
            public void onSuccess(String fileUrl) {

                photoPath = APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl;
                PicassoHelper.getInstance().setAvatar(StoreMessageActivity.this, photoPath, ivStoreHead);


            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(StoreMessageActivity.this, "上传失败请尝试重新上传！", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void takeFail(TResult result, String msg) {

    }

    @Override
    public void takeCancel() {

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
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this),
                invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

}
