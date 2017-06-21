package com.tv.doubuy.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;


/**
 * Created by apple on 2017/6/7.
 */
public class DouBuyApplication extends Application {

    private static DouBuyApplication instance;

    private Context mcontext;

    private String userToken;

    @Override
    public void onCreate() {
        super.onCreate();

        this.instance = this;
    }


    public static DouBuyApplication getInstance() {
        if (instance == null) {
            synchronized (DouBuyApplication.class) {
                instance = new DouBuyApplication();
            }
        }
        return instance;
    }

    public Context getContext() {

        if (mcontext == null) {
            mcontext = instance.getApplicationContext();
        }
        return mcontext;
    }

    //TODO  用户Token  全局变量储存一次  本地文件储存一次  ，

    public void setUserToken(String userToken) {

        this.userToken = userToken;

    }

    public String getUserToken() {

        return userToken;
    }


    public void removeToken() {
        setUserToken("");
    }

}
