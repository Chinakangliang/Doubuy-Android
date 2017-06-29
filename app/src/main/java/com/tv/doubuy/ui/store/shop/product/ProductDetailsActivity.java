package com.tv.doubuy.ui.store.shop.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.responseModel.DetialsProductModel;
import com.tv.doubuy.view.products.DragLayout;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/28.
 */

public class ProductDetailsActivity extends BaseActivity implements ProductDetialsPresenter {


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

    private ProductDetialsView detialsView;

    private ProductDetialsTopFragment topFragment;
    private DetialsBottomFragment bottomFragmen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        ButterKnife.bind(this);
        initviews();
    }


    public void initviews() {

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

        Bundle bundle = new Bundle();
        bundle.putSerializable("productModel", productModel);
        topFragment.setArguments(bundle);
        bottomFragmen.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.topFrame, topFragment)
                .add(R.id.bottomFrame, bottomFragmen)
                .commitAllowingStateLoss();
    }
}
