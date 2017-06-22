package com.tv.doubuy.ui.store.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.SpecAdapter;
import com.tv.doubuy.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/21.
 */

public class AddShopActivity extends BaseActivity implements SpecAdapter.SpecAdapterCallback, View.OnClickListener {


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

    @BindView(R.id.iv_addProduct)
    ImageView ivAddProduct;

    @BindView(R.id.tv_instructions)
    TextView tvInstructions;

    private SpecAdapter specAdapter;
    private List<String> mlist;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshop);
        ButterKnife.bind(this);
        initviews();
    }


    public void initviews() {
        tvTitle.setText("添加商品");
        mlist = new ArrayList<>();
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        linearLayoutManager.setScrollEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        specAdapter = new SpecAdapter(this);
        specAdapter.setData(mlist);
        recyclerView.setAdapter(specAdapter);
        specAdapter.setSpecClick(this);


        tvAddSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mlist.add("item");
                specAdapter.setData(mlist);
                specAdapter.notifyDataSetChanged();
            }
        });

        tvInstructions.setOnClickListener(this);
        ivAddProduct.setOnClickListener(this);
    }


    @Override
    public void itemonClick(int position, List<HashMap> listmap) {
        Log.i("111", "----------listmap---" + listmap.size());
    }

    @Override
    public void itemDetele(int position) {

        specAdapter.removeitem(position);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.iv_addProduct:
                break;
            case R.id.tv_instructions:
                intent.setClass(AddShopActivity.this, DescribeActivity.class);
                startActivity(intent);
                break;

        }
    }
}
