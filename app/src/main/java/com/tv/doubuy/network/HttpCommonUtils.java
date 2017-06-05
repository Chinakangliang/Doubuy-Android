package com.tv.doubuy.network;

import android.content.Context;

/**
 * Created by apple on 2017/6/2.
 */
public class HttpCommonUtils {


    private static HttpCommonUtils mInstance;

    public static HttpCommonUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (HttpCommonUtils.class) {
                mInstance = new HttpCommonUtils();
            }
        }
        return mInstance;
    }


    public HttpCommonInterceptor addOkHttpHeadptor() {
        HttpCommonInterceptor httpCommonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("Content-Type", "application/x-www-form-urlencoded")
                .addHeaderParams("Authorization", "JWT {" + APIUtils.getInstance().getUserToken() + "}")
                .build();

        return httpCommonInterceptor;
    }


}
