package com.tv.doubuy.ui.store.shop.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.DownProductAdapter;
import com.tv.doubuy.base.BaseExtendFragment;
import com.tv.doubuy.dialog.ModifyPopWindow;
import com.tv.doubuy.model.responseModel.ProductsListModel;
import com.tv.doubuy.ui.store.shop.adds.AddShopActivity;
import com.tv.doubuy.ui.store.shop.product.details.ProductDetailsActivity;
import com.tv.doubuy.utils.ToastUtils;
import com.tv.doubuy.view.refresh.RefresHelper;
import com.tv.doubuy.view.refresh.RefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/19.
 */

public class DownFragment extends BaseExtendFragment implements ShopListPresenter, DownProductAdapter.EmployAdapteCallBack, View.OnClickListener {

    private static final String ARG_PARAM = "param";
    private String mParam;
    List<String> str = new ArrayList<>();

    @BindView(R.id.recyler)
    RefreshRecyclerView recyler;
    @BindView(R.id.swipelauout)
    SwipeRefreshLayout swipelauout;
    @BindView(R.id.tv_addProduct)
    TextView tvAddProduct;

    private ProductsListModel lismodelProduct;

    private DownProductAdapter productAdapter;
    private ModifyPopWindow window;

    private DownPresenter presenter;

    private ShopListView shopListView;


    public static DownFragment newInstance(String param) {
        DownFragment fragment = new DownFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public void onCreateViewExtend(Bundle savedInstanceState) {
        super.onCreateViewExtend(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_sell, null);
        ButterKnife.bind(this, view);
        setContentView(view);

    }

    @Override
    public void onResumeExtend() {
        super.onResumeExtend();
        initviews();
        setListener();
    }

    private void initviews() {
        swipelauout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light);
        recyler.setLoadMoreEnable(true);//允许加载更多
        recyler.setFooterResource(R.layout.item_footer);//设置脚布局

        recyler.setLayoutManager(new LinearLayoutManager(getActivity()));
        productAdapter = new DownProductAdapter(getActivity());
        shopListView = new ShopListView(getActivity(), this);
        shopListView.getShopList("false");
    }

    public void setListener() {

        productAdapter.setAdapterClick(this);
        tvAddProduct.setOnClickListener(this);

        recyler.setOnLoadMoreListener(new RefreshRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMoreListener() {
                RefresHelper.getInstance().OnLoadMoreListener(recyler, swipelauout, str);
            }
        });

        swipelauout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                str = RefresHelper.getInstance().OnRefreshListener(recyler, swipelauout, str);
            }
        });
    }


    @Override
    public void setItemClick(String productsid) {
        Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
        intent.putExtra("productid", productsid);
        startActivity(intent);
    }


    @Override
    public void setItemShowPopWindowShow(final int position, final View view, final String productid) {
        window = new ModifyPopWindow(getActivity(), view, mParam);
        presenter = new DownPresenter(getActivity(), window, str);

        window.builder().setOnPopWindowClick(new ModifyPopWindow.onPopwindwCallback() {
            @Override
            public void onItemPopWinowShare() {
                ToastUtils.getInstance().showToast(getActivity(), "share");

            }

            @Override
            public void onItemPopWindowOutof() {
                presenter.setNeedData(position, productAdapter, recyler, shopListView, productid);
                presenter.shouDialog("确定上架该商品?", "outof");
            }
            @Override
            public void onItemPopWindowEdit() {

                if (lismodelProduct != null) {
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(getActivity(), AddShopActivity.class);
                    bundle.putSerializable("ResultsBean", lismodelProduct.getResults().get(position));
                    intent.putExtra("title", "编辑商品");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
            @Override
            public void onItemPopWinowDetele() {
                presenter.setNeedData(position, productAdapter, recyler, shopListView, productid);
                presenter.shouDialog("确定删除该商品?", "down");
            }
        });
    }

    @Override
    public void onDestroyViewExtend() {
        if (window != null) {
            window.dismiss();
            window = null;
        }

        super.onDestroyViewExtend();
    }


    @Override
    public void productlistdata(ProductsListModel productsListModel) {

        this.lismodelProduct = productsListModel;

        productAdapter.setData(productsListModel.getResults());
        recyler.setAdapter(productAdapter);

    }

    @Override
    public void deteleProduct(boolean isdetele) {
        shopListView.getShopList("false");
        productAdapter.notifyDataSetChanged();

    }


    @Override
    public void onSale(boolean isSale) {
        shopListView.getShopList("false");
        productAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (v.getId()) {

            case R.id.tv_addProduct:
                intent.setClass(getActivity(), AddShopActivity.class);
                intent.putExtra("title", "添加商品");
                startActivity(intent);
                break;
        }

    }
}
