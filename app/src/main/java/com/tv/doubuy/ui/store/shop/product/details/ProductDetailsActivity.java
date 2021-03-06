package com.tv.doubuy.ui.store.shop.product.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.responseModel.DetialsProductModel;
import com.tv.doubuy.model.responseModel.ProductsListModel;
import com.tv.doubuy.ui.store.shop.editor.EditorProductActivity;
import com.tv.doubuy.view.products.DragLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */

public class ProductDetailsActivity extends BaseActivity implements ProductDetialsPresenter, View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_right)
    Button btRight;
    @BindView(R.id.topFrame)
    FrameLayout topFrame;
    @BindView(R.id.bottomFrame)
    FrameLayout bottomFrame;
    @BindView(R.id.draglayout)
    DragLayout draglayout;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.rela_editor)
    RelativeLayout relaEditor;
    @BindView(R.id.rela_shaelves)
    RelativeLayout relaShaelves;

    private ProductDetialsView detialsView;

    private ProductDetialsTopFragment topFragment;
    private DetialsBottomFragment bottomFragmen;

    private DetialsProductModel detialsProductModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);
        initviews();
        setListener();
    }


    public void setListener() {
        relaEditor.setOnClickListener(this);
        relaShaelves.setOnClickListener(this);
        ivBack.setOnClickListener(this);
    }

    public void initviews() {
        tvTitle.setText("商品详情");
        detialsView = new ProductDetialsView(this, this);
        String productid = getIntent().getStringExtra("productid");
        detialsView.getProductsDetails(productid);

        // 上半部分
        topFragment = new ProductDetialsTopFragment();


        // 下半部分
        bottomFragmen = new DetialsBottomFragment();


    }

    @Override
    public void geItemProductDetals(DetialsProductModel productModel) {

        this.detialsProductModel = productModel;

        Bundle bundle = new Bundle();
        bundle.putSerializable("productModel", productModel);
        topFragment.setArguments(bundle);
        bottomFragmen.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.topFrame, topFragment)
                .add(R.id.bottomFrame, bottomFragmen)
                .commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {

        Bundle bundel = new Bundle();

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.rela_editor:
                ProductsListModel.ResultsBean bean = new ProductsListModel.ResultsBean();
                if (detialsProductModel != null) {
                    bean.setGalleries(detialsProductModel.getGalleries());
                    bean.setProductSKUs(detialsProductModel.getProductSKUs());

                    bean.setName(detialsProductModel.getName());
                    bean.setPrice(detialsProductModel.getPrice());
                    bean.setId(detialsProductModel.getId());
                    bean.setDescription(detialsProductModel.getDescription());
                }
                intent.setClass(ProductDetailsActivity.this, EditorProductActivity.class);
                bundel.putSerializable("ResultsBean", bean);
                intent.putExtra("title", "编辑商品");
                intent.putExtras(bundel);
                startActivity(intent);

                break;
            case R.id.rela_shaelves:
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
