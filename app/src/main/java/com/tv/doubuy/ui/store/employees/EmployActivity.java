package com.tv.doubuy.ui.store.employees;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.adapter.EmployAdapter;
import com.tv.doubuy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/16.
 */

public class EmployActivity extends BaseActivity implements EmployAdapter.EmployAdapteCallBack, View.OnClickListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_right)
    Button btRight;
    @BindView(R.id.recyler)
    RecyclerView recyler;

    private List<String> list;
    private EmployAdapter employAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employ);
        ButterKnife.bind(this);
        initviews();
        setListener();
    }


    public void initviews() {
        tvTitle.setText("员工管理");
        list = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            list.add("员工管理ITEM" + i);
        }
        recyler.setLayoutManager(new LinearLayoutManager(this));
        employAdapter = new EmployAdapter(this);
        employAdapter.setData(list);
        recyler.setAdapter(employAdapter);
    }

    public void setListener() {
        employAdapter.setAdapterClick(this);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void setItemClick(int position) {

        Toast.makeText(this, "gg" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItemShowPopWindowShow(int position, View view) {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
