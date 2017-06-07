package com.tv.doubuy.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by apple on 2017/6/7.
 */
public class DouBuyApplication extends Application {

    private static DouBuyApplication app;


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
