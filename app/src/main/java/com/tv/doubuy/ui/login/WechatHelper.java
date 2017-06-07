package com.tv.doubuy.ui.login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tv.doubuy.network.APIService;

/**
 * Created by apple on 2017/6/7.
 */
public class WechatHelper {

    private static IWXAPI wxApi;
    private static WechatHelper helper;


    public static WechatHelper getInstance(Context mContext) {
        wxApi = WXAPIFactory.createWXAPI(mContext, APIService.APP_ID, true);
        wxApi.registerApp(APIService.APP_ID);
        if (helper == null) {
            helper = new WechatHelper();
        }
        return helper;
    }

    /**
     * 判断是否安装了微信
     */
    public boolean isWXAppInstalled() {
        return wxApi.isWXAppInstalled();
    }


    /**
     * 调起微信登录
     */
    public void onWechatLogin() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = String.valueOf(System.currentTimeMillis());
        wxApi.sendReq(req);
    }

}
