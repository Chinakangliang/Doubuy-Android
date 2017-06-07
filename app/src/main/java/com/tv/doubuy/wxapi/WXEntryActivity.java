package com.tv.doubuy.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tv.doubuy.model.responseModel.WXloginModel;
import com.tv.doubuy.network.APIService;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.ui.login.BindMobileActivity;

/**
 * Created by kang on 2017/5/29.
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, APIService.APP_ID, false);
        api.handleIntent(getIntent(), this);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        api.handleIntent(getIntent(), this);
    }


    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {


        int errCode = baseResp.errCode;
        switch (errCode) {
            case BaseResp.ErrCode.ERR_OK:
                switch (baseResp.getType()) {
                    //来自分享
                    case ConstantsAPI.COMMAND_SENDMESSAGE_TO_WX:
                        finish();
                        break;
                    //来自登陆
                    case ConstantsAPI.COMMAND_SENDAUTH:

                        String code = ((SendAuth.Resp) baseResp).code; //即为所需的code
                        Log.i("111", "----CODE---" + code);

                        getWXLoginToken(code);
                        break;
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                finish();
                break;
        }


    }

    public void getWXLoginToken(String code) {

        RetrofitUtils.getInstance(this).setUserWXCode(code, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {


                WXloginModel loginmodel = APIUtils.gson.fromJson(o.toString(), WXloginModel.class);
                if (loginmodel != null) {

                    Intent intent = new Intent(WXEntryActivity.this, BindMobileActivity.class);
                    intent.putExtra("openid", loginmodel.getOpenid());
                    startActivity(intent);


                }


            }
        }, this));
    }


//    public interface WxLoginCallback {
//
//        void successful(String openid);
//    }
//
//    public void WXChatLoginLinstener(WxLoginCallback callback) {
//
//
//        this.callback = callback;
//    }


}
