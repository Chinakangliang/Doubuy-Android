package com.tv.doubuy.ui.store.shop.editor;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.tv.doubuy.dialog.ProductCheckDialog;
import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.ProductSKUsBean;
import com.tv.doubuy.model.responseModel.CreateProductSKUs;
import com.tv.doubuy.model.responseModel.ModifyProductsModel;
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
    @BindView(R.id.tv_StoreClass)
    TextView tvStoreClass;

    @BindView(R.id.et_spec)
    EditText etSpec;
    @BindView(R.id.et_price)
    EditText et_price;
    @BindView(R.id.et_inventory)
    EditText etInventory;

    private ProductsListModel.ResultsBean resultsBean;
    private String title;
    private EditorAdapter editorAdapter;
    private ImageAdapter imageAdapter;

    private List<String> pathList;

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private int position;

    private List<CreateProductSKUs> skUsList = new ArrayList<>();

    private List<ProductSKUsBean> listbean = new ArrayList<>();
    AliyunUtils aliyunUtils = new AliyunUtils();
    private AddShopPresenter addShopPresenter;
    private String productid;
    List<ProductSKUsBean> skuben;

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
        addShopPresenter = new AddShopPresenter(EditorProductActivity.this, EditorProductActivity.this);

        title = getIntent().getStringExtra("title");

        btRight.setText("发布");
        resultsBean = (ProductsListModel.ResultsBean) getIntent().getSerializableExtra("ResultsBean");

        tvTitle.setText(title);
        recylerEditor.setLayoutManager(new LinearLayoutManager(this));
        editorAdapter = new EditorAdapter(this);


        recyclerShopImage.setLayoutManager(new GridLayoutManager(this, 3));

        pathList = new ArrayList<>();


        imageAdapter = new ImageAdapter(this);
        if (resultsBean != null) {
            etName.setText(resultsBean.getName());
            editorAdapter.setData(resultsBean.getProductSKUs());
            productid = resultsBean.getId() + "";
            for (ProductGalleriesBean bean : resultsBean.getGalleries()) {
                if (bean.getImage() != null && !bean.getImage().equals("选择")) {
                    pathList.add(bean.getImage());
                }

            }
            imageAdapter.setData(pathList);
            pathList.add("选择");

            if (resultsBean.getProductSKUs().size() > 1) {
                skUsList = resultsBean.getProductSKUs();
                etSpec.setText(resultsBean.getProductSKUs().get(0).getSpec());
                et_price.setText(resultsBean.getProductSKUs().get(0).getPrice() + "");
                etInventory.setText(resultsBean.getProductSKUs().get(0).getCount() + "");
            } else if (resultsBean.getProductSKUs().size() == 1) {
                etSpec.setText(resultsBean.getProductSKUs().get(0).getSpec());
                et_price.setText(resultsBean.getProductSKUs().get(0).getPrice() + "");
                etInventory.setText(resultsBean.getProductSKUs().get(0).getCount() + "");
            }

        }

        recyclerShopImage.setAdapter(imageAdapter);
        imageAdapter.setAdapterCallBack(this);


        recylerEditor.setAdapter(editorAdapter);
        editorAdapter.setData(skUsList);
        editorAdapter.setSpecClick(this);
        final CreateProductSKUs createProductSKUs = new CreateProductSKUs();
        tvAddSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProductSKUs.setPrice("");
                createProductSKUs.setSpec("");
                createProductSKUs.setCount("");
                skUsList.add(createProductSKUs);
                editorAdapter.setData(skUsList);
            }
        });

        final List<String> str = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            str.add("item" + i);
        }

        tvStoreClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProductCheckDialog productCheckDialog = new ProductCheckDialog(EditorProductActivity.this);
                productCheckDialog.setListData(str);
                productCheckDialog.show();
                productCheckDialog.setSelectListener(new ProductCheckDialog.ProductChecCallback() {
                    @Override
                    public void ProductCheckCallBack(int posotion, String newValue) {
                        tvStoreClass.setText(newValue);
                        productCheckDialog.dismiss();
                    }
                });

            }
        });
    }


    public void setLisenter() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String count = etInventory.getText().toString().trim();
                String price = et_price.getText().toString().trim();
                String spec = etSpec.getText().toString().trim();
                ProductSKUsBean productSKUsBean = new ProductSKUsBean();
                if (!TextUtils.isEmpty(count) && !TextUtils.isEmpty(price) && !TextUtils.isEmpty(spec)) {
                    productSKUsBean.setCount(count);
                    productSKUsBean.setPrice(price);
                    productSKUsBean.setSpec(spec);
                    listbean.add(productSKUsBean);
                    if (skuben != null) {
                        listbean.addAll(skuben);
                    }

                    addShopPresenter.modifyProucts(resultsBean.getId() + "", ReleaseHelep.getInstance().ModifyProduct(listbean, etName.getText().toString(), etUnit.getText().toString(), pathList));

                } else {
                    ToastUtils.getInstance().showToast(EditorProductActivity.this, "请至少填写一个规格");
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

        if (result.getImage() != null) {
            pathList.remove(position);
            aliyunUtils.upFile(result.getImage().getPath(), this);
            aliyunUtils.AliyunUploadCal(new AliyunUtils.AliyunUploadCallback() {
                @Override
                public void onSuccess(String fileUrl) {

                    if (pathList.size() > 0) {

                        for (int i = 0; i < pathList.size(); i++) {
                            if (pathList.get(i).equals("选择")) {
                                pathList.remove(i);
                            } else {
                                pathList.add(APIService.ALIYUN_OSS_IMAGE_PATH + fileUrl);
                            }
                        }
                        pathList.add("选择");
                        imageAdapter.setData(pathList);

                    }

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
        this.skuben = listbean;
    }

    @Override
    public void itemDetele(int position) {
        skUsList.remove(position);
        editorAdapter.setData(skUsList);
    }

    @Override
    public void onReleaseProducts(CreateProductModel productModel) {


    }

    @Override
    public void onModifyProducts(ModifyProductsModel modifyProductsModel) {
        ToastUtils.getInstance().showToast(this, "发布成功");
        finish();
    }

}
