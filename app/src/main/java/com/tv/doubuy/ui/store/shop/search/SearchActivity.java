package com.tv.doubuy.ui.store.shop.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.SearchAdapter;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.responseModel.SearchModels;
import com.tv.doubuy.ui.store.shop.product.details.ProductDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/23.
 */

public class SearchActivity extends BaseActivity implements SearchView, SearchAdapter.AdapteCallBack {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.recyler)
    RecyclerView recyler;

    private SearchPresenter presenter;
    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initviews();
        setListener();
    }

    public void initviews() {
        tvTitle.setText("搜索'");
        presenter = new SearchPresenter(this, this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new SearchAdapter(this);
        searchAdapter.setAdapterClick(this);
    }

    public void setListener() {
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setSearchProduct(etSearch.getText().toString().trim());
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void searchData(SearchModels searchModels) {
        searchAdapter.setData(searchModels.getResults());
        recyler.setAdapter(searchAdapter);
    }

    @Override
    public void setItemClick(int productsid) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("productid", productsid);
        startActivity(intent);
    }
}
