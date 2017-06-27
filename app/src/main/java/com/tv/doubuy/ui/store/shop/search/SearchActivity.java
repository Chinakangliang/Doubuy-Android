package com.tv.doubuy.ui.store.shop.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/23.
 */

public class SearchActivity extends BaseActivity implements SearchView {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_search)
    TextView tvSearch;

    private SearchPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initviews();
            }
        });

    }

    public void initviews() {

        presenter = new SearchPresenter(this, this);
        presenter.setSearchProduct("aaaaa");
    }

    @Override
    public void searchData() {

        Toast.makeText(this, "PY成功", Toast.LENGTH_SHORT).show();
    }
}
