package com.tv.doubuy.utils;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;


/**
 * Created by apple on 2017/6/7.
 */
public class DouBuyApplication extends Application {

    private static DouBuyApplication instance;


    public static Handler handler;

    public static DouBuyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.instance = this;
    }

    private void initLeanCloud() {
        handler = new Handler(Looper.getMainLooper());

    }

}
