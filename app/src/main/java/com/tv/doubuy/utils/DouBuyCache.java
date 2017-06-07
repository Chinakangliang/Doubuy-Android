package com.tv.doubuy.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by apple on 2017/6/6.
 */
public class DouBuyCache {
    private final String SHARE_NAME = "DOUBUY_USERS";
    private final int SHARE_MODE = 0;
    private SharedPreferences shared;

    private String KEY_USER_TOKEN = "KEY_USER_TOKEN";


    public DouBuyCache(Context context) {
        shared = context.getSharedPreferences(SHARE_NAME, SHARE_MODE);
    }


    public void saveUserToken(String token) {
        shared.edit().putString(KEY_USER_TOKEN, token)
                .commit();
    }

    public String getUserToken() {
        return shared.getString(KEY_USER_TOKEN, "");
    }

}
