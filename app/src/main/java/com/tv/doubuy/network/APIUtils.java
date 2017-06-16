package com.tv.doubuy.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.tv.doubuy.utils.DouBuyApplication;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * api请求工具类
 */
public class APIUtils {

    private static APIUtils mInstance;


    private DouBuyCache douBuyCache;
    public static Gson gson = new Gson();

    private static Context mcontext;

    public static APIUtils getInstance(Context context) {
        if (mInstance == null) {
            mcontext = context;
            synchronized (APIUtils.class) {
                mInstance = new APIUtils();

            }
        }
        return mInstance;
    }


    public String getUserToken() {
        douBuyCache = new DouBuyCache(mcontext);
        String token = DouBuyApplication.getInstance().getUserToken();
        if (token != null && !token.equals("")) {

            Log.i("111", "---token-----");
            return token;
        } else {
            Log.i("111", "---douBuyCache-----");
            return douBuyCache.getUserToken();
        }
    }

    public String getStoreId() {
        douBuyCache = new DouBuyCache(mcontext);
        String storeId = douBuyCache.getStoreId();
        return storeId;
    }

    public String getApiPath() {

        String path = true ? "api-dev.doubuy.tv" : "121.40.217.6:5000";
        return path;

    }


}
