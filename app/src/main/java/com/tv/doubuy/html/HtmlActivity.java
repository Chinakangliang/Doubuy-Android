package com.tv.doubuy.html;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.moblie.zmxy.antgroup.creditsdk.app.CreditApp;
import com.android.moblie.zmxy.antgroup.creditsdk.app.ICreditListener;
import com.tv.doubuy.R;
import com.tv.doubuy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 2017/6/12.
 */

public class HtmlActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        ButterKnife.bind(this);

        initViews();
    }

    public void initViews() {

        tvTitle.setText("芝麻验证");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        String url = getIntent().getStringExtra("path");

        webView.loadUrl(url);

        webView.setWebViewClient(new MyWebViewClient());

//        ICreditListener iCreditListener = new ICreditListener() {
//            @Override
//            public void onComplete(Bundle bundle) {
//                Toast.makeText(HtmlActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onError(Bundle bundle) {
//                Toast.makeText(HtmlActivity.this, "onError", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancel() {
//
//                Toast.makeText(HtmlActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
//            }
//        };
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onPageCommitVisible(WebView view, String url) {

            super.onPageCommitVisible(view, url);

        }
    }



}
