package com.tv.doubuy.ui.store.shop.shopclass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/27.
 */

public class AddClassActivity extends BaseActivity implements View.OnClickListener, AddClassView {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_classname)
    EditText etClassname;
    @BindView(R.id.et_classdesc)
    EditText etClassdesc;


    private AddClassPresenter addClassPresenter;
    private String classid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_class);
        ButterKnife.bind(this);
        initviews();
        setListener();
    }

    public void initviews() {

        String title = getIntent().getStringExtra("title");

        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(desc)) {
            etClassname.setText(name);
            etClassdesc.setText(desc);
        }
        classid = getIntent().getStringExtra("classid");

        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }

        addClassPresenter = new AddClassPresenter(this, this);
    }

    private void setListener() {
        ivBack.setOnClickListener(this);
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_submit:

                if (tvTitle.getText().equals("添加分类")) {
                    addClassPresenter.putClassData(etClassname.getText().toString(), etClassdesc.getText().toString());
                } else {
                    addClassPresenter.setModfiy(etClassname.getText().toString(), etClassdesc.getText().toString(), classid);
                }
                break;
        }

    }

    @Override
    public void createdata(String message) {
        ToastUtils.getInstance().showToast(this, message);
        finish();
    }

}
