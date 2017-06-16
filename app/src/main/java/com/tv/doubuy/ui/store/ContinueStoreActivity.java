package com.tv.doubuy.ui.store;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
import com.tv.doubuy.model.requestModel.ProfileModel;
import com.tv.doubuy.model.responseModel.RealStoreModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.PicassoHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/13.
 */

public class ContinueStoreActivity extends BaseActivity implements TakePhoto.TakeResultListener, InvokeListener {

    @BindView(R.id.bt_Continue)
    Button btContinue;
    @BindView(R.id.et_companyName)
    EditText etCompanyName;
    @BindView(R.id.et_businessPhone)
    EditText etBusinessPhone;
    @BindView(R.id.et_businessAddress)
    EditText etBusinessAddress;
    @BindView(R.id.et_legalPerson)
    EditText etLegalPerson;
    @BindView(R.id.et_bankAccount)
    EditText etBankAccount;
    @BindView(R.id.et_bankOfDeposit)
    EditText etBankOfDeposit;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_shoplicense)
    ImageView ivShoplicense;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private String photoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        ButterKnife.bind(this);

        initViews();
        setListener();
    }

    public void initViews() {
        tvTitle.setText("实体店认证");

    }


    public void setListener() {
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (photoPath != null && !photoPath.equals("")) {
                    putAccessData();
                } else {

                    Toast.makeText(ContinueStoreActivity.this, "请上传营业执照！", Toast.LENGTH_SHORT).show();
                }


            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivShoplicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootApply();
            }
        });
    }

    public void putAccessData() {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setCompanyName(etCompanyName.getText().toString());
        profileModel.setBusinessPhone(etBusinessPhone.getText().toString());
        profileModel.setBusinessAddress(etBusinessAddress.getText().toString());
        profileModel.setLegalPerson(etLegalPerson.getText().toString());
        profileModel.setBankAccount(etBankAccount.getText().toString());
        profileModel.setBankOfDeposit(etBankOfDeposit.getText().toString());
        profileModel.setLicenseImage(photoPath);

        RetrofitUtils utils = new RetrofitUtils(this);
        utils.putUserCreateStore(APIUtils.getInstance(this).getStoreId(), profileModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                RealStoreModel storeModel = APIUtils.gson.fromJson(o.toString(), RealStoreModel.class);
                if (storeModel != null) {

                    Toast.makeText(ContinueStoreActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContinueStoreActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(ContinueStoreActivity.this, "没有使用相机和相册的权限，请在权限管理中开启", Toast.LENGTH_SHORT).show();
                    }
                });
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


    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(
                    new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }


    @Override
    public void takeSuccess(TResult result) {

        PicassoHelper.getInstance().setLocalImage(ContinueStoreActivity.this, result.getImage().getPath(), ivShoplicense);
        AliyunUtils aliyunUtils = new AliyunUtils();
        aliyunUtils.upFile(result.getImage().getPath(), this);
        aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
            @Override
            public void onSuccess(String fileUrl) {
                photoPath = APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl;

                Log.i("111", "-------" + photoPath);

            }
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(ContinueStoreActivity.this, "上传失败请尝试重新上传！", Toast.LENGTH_SHORT).show();

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
