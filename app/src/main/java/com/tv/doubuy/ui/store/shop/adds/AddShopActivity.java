package com.tv.doubuy.ui.store.shop.adds;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.tv.doubuy.R;
import com.tv.doubuy.adapter.AddImageAdapter;
import com.tv.doubuy.adapter.SpecAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.dialog.ActionSheetDialog;
import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.ui.store.shop.DescribeActivity;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.ToastUtils;
import com.tv.doubuy.view.CustomLinearLayoutManager;
import com.tv.doubuy.view.GridManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/21.
 */

public class AddShopActivity extends BaseActivity implements SpecAdapter.SpecAdapterCallback, OnClickListener, TakePhoto.TakeResultListener, InvokeListener, AddImageAdapter.addImageViewListenr, AddShopView {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.liner_shop_message)
    LinearLayout linerShopMessage;
    @BindView(R.id.tv_add_spec)
    TextView tvAddSpec;

    @BindView(R.id.recyler_spec)
    RecyclerView recyclerView;

    @BindView(R.id.tv_instructions)
    TextView tvInstructions;

    @BindView(R.id.recyler_shopimage)
    RecyclerView recyclerShopImage;
    @BindView(R.id.bt_right)
    Button btRight;

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_category)
    EditText etCategory;
    @BindView(R.id.et_unit)
    EditText etUnit;

    private SpecAdapter specAdapter;
    private List<String> mlist;

    private AddImageAdapter addImageAdapter;
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private List<String> imgUrls = new ArrayList<>();

    private List<String> photourl = new ArrayList<>();

    private List<ProductSKUsBean> listbean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshop);
        ButterKnife.bind(this);
        initviews();
    }


    public void initviews() {
        tvTitle.setText("添加商品");
        mlist = new ArrayList<>();
        btRight.setText("发布");

        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        linearLayoutManager.setScrollEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        specAdapter = new SpecAdapter(this);
        specAdapter.setData(mlist);
        specAdapter.setSpecClick(this);
        recyclerView.setAdapter(specAdapter);

        if (imgUrls.size() == 0) {
            imgUrls.add("选择");
        }


        /**
         * 选择照片
         */

        GridManager gridManager = new GridManager(this, 3);
        recyclerShopImage.setLayoutManager(gridManager);
        gridManager.setSmoothScrollbarEnabled(false);
        addImageAdapter = new AddImageAdapter(this, imgUrls);
        addImageAdapter.AddImageCallback(this);
        recyclerShopImage.setAdapter(addImageAdapter);


        tvAddSpec.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mlist.add("item");
                specAdapter.setData(mlist);


            }
        });

        tvInstructions.setOnClickListener(this);

        btRight.setOnClickListener(this);
    }


    @Override
    public void itemonClick(int position, List<ProductSKUsBean> listbean) {

        this.listbean = listbean;

    }

    @Override
    public void itemDetele(int position) {

        specAdapter.removeitem(position);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_instructions:
                intent.setClass(AddShopActivity.this, DescribeActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_right:
                avatarUpload(imgUrls);
                AddShopPresenter addShopPresenter = new AddShopPresenter(this, this);
                addShopPresenter.createProducts(ReleaseHelep.getInstance().createRelease(listbean, etName.getText().toString(), etUnit.getText().toString()));

                break;

        }
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
                        ToastUtils.getInstance().showToast(AddShopActivity.this, "没有使用相机和相册的权限，请在权限管理中开启!");


                    }
                });
    }


    private void showHeadportraitDialog() {

        new ActionSheetDialog(this).builder().onClickSheetItem(new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onPicturesClick() {


                CustomHelper customHelper = CustomHelper.getInstace();
                customHelper.setMaxSelectCount(9);
                customHelper.onPhotoGraph(getTakePhoto(), false);

            }

            @Override
            public void onAlbumClick() {
                CustomHelper customHelper = CustomHelper.getInstace();
                customHelper.setMaxSelectCount(8);
                customHelper.onAlbumChoice(getTakePhoto(), false);

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


        List<String> photoUrls = getPhotoUrls(result.getImages());
        photoUrls.add("选择");
        imgUrls.addAll(photoUrls);
        addImageAdapter.setData(imgUrls);

    }

    public List<String> getPhotoUrls(ArrayList<TImage> tImages) {

        for (int i = 0; i < imgUrls.size(); i++) {
            if (imgUrls.get(i).equals("选择")) {
                imgUrls.remove(i);
                photourl.addAll(imgUrls);
            }
        }

        List<String> urls = new ArrayList<>();
        for (TImage image : tImages) {
            urls.add(image.getPath());
        }


        return urls;
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode,
                permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setAddImage() {
        rootApply();
    }

    @Override
    public void saveImage() {

    }


    public void avatarUpload(List<String> photoUrls) {
        ServerUpFile serverUpFile = new ServerUpFile();
        Intent intent = new Intent(AddShopActivity.this, ServerUpFile.class);
        intent.putStringArrayListExtra("imgUrls", (ArrayList<String>) photoUrls);
        serverUpFile.onBind(intent);
        startService(intent);
    }


    @Override
    public void onReleaseProducts(CreateProductModel productModel) {


    }
}
