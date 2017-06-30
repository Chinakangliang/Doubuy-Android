package com.tv.doubuy.ui.store.shop.editor;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.tv.doubuy.R;
import com.tv.doubuy.adapter.EditorAdapter;
import com.tv.doubuy.adapter.ImageAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.dialog.ActionSheetDialog;
import com.tv.doubuy.dialog.Progresloading;
import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.model.responseModel.CreateProductSKUs;
import com.tv.doubuy.model.responseModel.ProductGalleriesBean;
import com.tv.doubuy.model.responseModel.ProductsListModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.ui.store.shop.adds.AddShopPresenter;
import com.tv.doubuy.ui.store.shop.adds.AddShopView;
import com.tv.doubuy.ui.store.shop.adds.ReleaseHelep;
import com.tv.doubuy.utils.AliyunUtils;
import com.tv.doubuy.utils.CustomHelper;
import com.tv.doubuy.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */
//TODO  编辑特意和添加分开来处理 ，以此来希望不引起代码混乱， 保存SKU的地方 还需要处理，编辑后发布的接口未调用
public class EditorProductActivity extends BaseActivity implements ImageAdapter.ImageAdapterCallBack, TakePhoto.TakeResultListener, InvokeListener, EditorAdapter.SpecAdapterCallback, AddShopView {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_right)
    Button btRight;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_category)
    EditText etCategory;
    @BindView(R.id.et_unit)
    EditText etUnit;
    @BindView(R.id.liner_shop_message)
    LinearLayout linerShopMessage;
    @BindView(R.id.recyler_editor)
    RecyclerView recylerEditor;
    @BindView(R.id.recyler_shopimage)
    RecyclerView recyclerShopImage;
    @BindView(R.id.tv_add_spec)
    TextView tvAddSpec;

    private ProductsListModel.ResultsBean resultsBean;
    private String title;
    private EditorAdapter editorAdapter;
    private ImageAdapter imageAdapter;

    private List<String> pathList;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private int position;
    private Progresloading progresloading;

    private List<CreateProductSKUs> skUsList;

    private List<ProductSKUsBean> listbean;
    AliyunUtils aliyunUtils = new AliyunUtils();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_products);
        ButterKnife.bind(this);
        initviews();
        setLisenter();
    }


    public void initviews() {

        title = getIntent().getStringExtra("title");

        btRight.setText("发布");
        resultsBean = (ProductsListModel.ResultsBean) getIntent().getSerializableExtra("ResultsBean");


        tvTitle.setText(title);
        recylerEditor.setLayoutManager(new LinearLayoutManager(this));
        editorAdapter = new EditorAdapter(this);


        recyclerShopImage.setLayoutManager(new GridLayoutManager(this, 3));

        imageAdapter = new ImageAdapter(this);
        if (resultsBean != null) {
            etName.setText(resultsBean.getName());
            etCategory.setText(resultsBean.getDescription());
            editorAdapter.setData(resultsBean.getProductSKUs());


            pathList = new ArrayList<>();
            for (ProductGalleriesBean bean : resultsBean.getGalleries()) {
                pathList.add(bean.getImage());
            }
            pathList.add("选择");

            imageAdapter.setData(pathList);


            if (resultsBean.getProductSKUs().size() > 0) {
                skUsList = resultsBean.getProductSKUs();
            }

        }

        recyclerShopImage.setAdapter(imageAdapter);
        imageAdapter.setAdapterCallBack(this);


        recylerEditor.setAdapter(editorAdapter);
        editorAdapter.setData(skUsList);
        editorAdapter.setSpecClick(this);

        tvAddSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateProductSKUs createProductSKUs = new CreateProductSKUs();
                skUsList.add(createProductSKUs);
                editorAdapter.setData(skUsList);
            }
        });


        progresloading = new Progresloading(this);
    }


    public void setLisenter() {
        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(500);
                    AddShopPresenter addShopPresenter = new AddShopPresenter(EditorProductActivity.this, EditorProductActivity.this);
                    addShopPresenter.createProducts(ReleaseHelep.getInstance().createProduct(listbean, etName.getText().toString(), etUnit.getText().toString(), pathList));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void addImage(int position) {
        this.position = position;
        rootApply();
    }

    @Override
    public void takeSuccess(TResult result) {

        if (result.getImages().size() > 0) {
            pathList.remove(position);
            aliyunUtils.upFile(result.getImage().getPath(), this);
            aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
                @Override
                public void onSuccess(String fileUrl) {
                    pathList.add(APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl);
                    pathList.add("选择");
                    recyclerShopImage.setAdapter(imageAdapter);
                    imageAdapter.setData(pathList);

                }

                @Override
                public void onFailure(Exception e) {

                }
            });


        }

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
                        ToastUtils.getInstance().showToast(EditorProductActivity.this, "没有使用相机和相册的权限，请在权限管理中开启!");


                    }
                });
    }

    private void showHeadportraitDialog() {

        new ActionSheetDialog(this).builder().onClickSheetItem(new ActionSheetDialog.OnSheetItemClickListener() {
            @Override
            public void onPicturesClick() {

                CustomHelper customHelper = CustomHelper.getInstace();
                customHelper.onPhotoGraph(getTakePhoto(), false);

            }

            @Override
            public void onAlbumClick() {
                CustomHelper customHelper = CustomHelper.getInstace();
                customHelper.onAlbumChoice(getTakePhoto(), false);

            }
        }).dialogshow();
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

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(
                    new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }


    @Override
    public void itemonClick(int position, List<ProductSKUsBean> listbean) {
        this.listbean = listbean;
    }

    @Override
    public void itemDetele(int position) {
        editorAdapter.removeitem(position);
    }

    @Override
    public void onReleaseProducts(CreateProductModel productModel) {
        ToastUtils.getInstance().showToast(this, "发布成功");
        finish();

    }
}
