package com.tv.doubuy.network;

/**
 * api请求工具类
 */
public class APIUtils {

    private static APIUtils mInstance;

    public static APIUtils getInstance() {
        if (mInstance == null) {
            synchronized (APIUtils.class) {
                mInstance = new APIUtils();
            }
        }
        return mInstance;
    }

    public String getUserToken() {

        return "";
    }

    public String getApiPath() {

        String path = true ? "api-dev.doubuy.tv" : "121.40.217.6:5000";

        return path;

    }

}
