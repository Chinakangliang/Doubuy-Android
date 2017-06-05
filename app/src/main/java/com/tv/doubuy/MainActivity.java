package com.tv.doubuy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tv.doubuy.requestModel.LoginRequestModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonPanel)
    Button buttonPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        buttonPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initViews();
                Log.i("111", "-------" + APIService.APP_PATH);

            }
        });
    }

    public void initViews() {

        LoginRequestModel requestModel = new LoginRequestModel();
        requestModel.setMobile("13166217355");
        requestModel.setType("resetPassword");

        RetrofitUtils.getInstance(this).setUserCode(requestModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                Toast.makeText(MainActivity.this, "" + o.toString(), Toast.LENGTH_SHORT).show();
            }
        }, this));
    }
}
