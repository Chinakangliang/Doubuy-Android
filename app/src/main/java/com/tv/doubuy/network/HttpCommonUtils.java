package com.tv.doubuy.network;

import android.content.Context;
import android.util.Log;

import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/2.
 */
public class HttpCommonUtils {


    private static HttpCommonUtils mInstance;

    private static Context mcontext;

    private static DouBuyCache douBuyCache;

    public static HttpCommonUtils getInstance(Context context) {
        douBuyCache = new DouBuyCache(context);

        if (context == null) {
            Log.i("111", "----null--");
        } else {
            Log.i("111", "----NOnull--");

        }
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
                .addHeaderParams("Authorization", "JWT " + douBuyCache.getUserToken())
                .build();

        Log.i("111", "----APIUtils------" + douBuyCache.getUserToken());
        return httpCommonInterceptor;
    }


}
