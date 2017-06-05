package com.tv.doubuy.network;

import android.content.Context;


import com.tv.doubuy.requestModel.LoginRequestModel;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 2017/6/2.
 */
public class RetrofitUtils {

    private static RetrofitUtils mInstance;
    public static final int DEFAULT_TIMEOUT = 5;
    private static Retrofit mRetrofit;
    private static APIService mApiService;

    public static RetrofitUtils getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                mInstance = new RetrofitUtils(context);
            }
        }
        return mInstance;
    }

    public RetrofitUtils(Context context) {

        CookieHandler cookieHandler = new CookieManager(new PersistentCookieStore(context), CookiePolicy.ACCEPT_ALL);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);


        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client = builder.connectTimeout(5, TimeUnit.SECONDS)
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                .addInterceptor(HttpCommonUtils.getInstance(context).addOkHttpHeadptor())
                .addInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(false)
                .build();


//        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);


        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(APIService.APP_PATH)
                .addConverterFactory(ResponseConvertFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = mRetrofit.create(APIService.class);
    }

//
//    public void setUserLogin(ProgressSubscriber subscriber) {
//
//        toSubscribe(mApiService.setUserLogin(0,10), subscriber);
//    }


    public void setUserCode(LoginRequestModel loginRequestModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.setUserSendCode(loginRequestModel), subscriber);

    }

    private <T> void toSubscribe(Observable<T> o, Subscriber s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
