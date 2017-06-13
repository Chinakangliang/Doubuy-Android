package com.tv.doubuy.ui.store;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;
import com.tv.doubuy.model.requestModel.ProfileModel;
import com.tv.doubuy.model.responseModel.RealStoreModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/13.
 */

public class ContinueStoreActivity extends BaseActivity {

    @BindView(R.id.bt_Continue)
    Button btContinue;
    @BindView(R.id.et_companyName)
    EditText etCompanyName;
    @BindView(R.id.et_businessPhone)
    EditText etBusinessPhone;
    @BindView(R.id.et_businessAddress)
    EditText etBusinessAddress;
    @BindView(R.id.et_legalPerson)
    EditText etLegalPerson;
    @BindView(R.id.et_bankAccount)
    EditText etBankAccount;
    @BindView(R.id.et_bankOfDeposit)
    EditText etBankOfDeposit;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        ButterKnife.bind(this);

        initViews();
        setListener();
    }

    public void initViews() {
        tvTitle.setText("实体店认证");

    }


    public void setListener() {
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putAccessData();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void putAccessData() {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setCompanyName(etCompanyName.getText().toString());
        profileModel.setBusinessPhone(etBusinessPhone.getText().toString());
        profileModel.setBusinessAddress(etBusinessAddress.getText().toString());
        profileModel.setLegalPerson(etLegalPerson.getText().toString());
        profileModel.setBankAccount(etBankAccount.getText().toString());
        profileModel.setBankOfDeposit(etBankOfDeposit.getText().toString());
        profileModel.setLicenseImage("www.baid.com");

        RetrofitUtils.getInstance(this).putUserCreateStore(APIUtils.getInstance(this).getStoreId(), profileModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                RealStoreModel storeModel = APIUtils.gson.fromJson(o.toString(), RealStoreModel.class);
                if (storeModel != null) {

                    Toast.makeText(ContinueStoreActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContinueStoreActivity.this, "请填写完整", Toast.LENGTH_SHORT).show();
                }

            }
        }, this));
    }

//    putUserCreateStore
}
