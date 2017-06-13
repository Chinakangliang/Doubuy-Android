package com.tv.doubuy.network;

import android.content.Context;
import android.util.Log;

/**
 * Created by apple on 2017/6/2.
 */
public class HttpCommonUtils {


    private static HttpCommonUtils mInstance;

    private static Context mcontext;

    public static HttpCommonUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (HttpCommonUtils.class) {
                mInstance = new HttpCommonUtils();
                mcontext = context;
            }
        }
        return mInstance;
    }


    public HttpCommonInterceptor addOkHttpHeadptor() {
        HttpCommonInterceptor httpCommonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("Content-Type", "application/x-www-form-urlencoded")
                .addHeaderParams("Authorization", "JWT " + APIUtils.getInstance(mcontext).getUserToken())
                .build();

        Log.i("111", "----APIUtils------" + APIUtils.getInstance(mcontext).getUserToken());
        return httpCommonInterceptor;
    }


}
