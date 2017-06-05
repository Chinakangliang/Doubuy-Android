package com.tv.doubuy.network;



import com.tv.doubuy.requestModel.LoginRequestModel;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by apple on 2017/6/2.
 */
public interface APIService {


    String APP_PATH = "http://" + APIUtils.getInstance().getApiPath() + "/";
//  String APP_PATH="https://api.douban.com/v2/movie/";

//  http://{{dbuy_api_server}}/auth/sendCode

//  String APP_PATH="http://stardang.com:8000/";
//  @GET("/api-token-auth/")
//  Observable setUserLogin();

//    @GET("top250")
//    Observable<BaseResponse> setUserLogin(@Query("start") int start, @Query("count") int count);


    @POST("auth/sendCode")
    Observable<BaseResponse> setUserSendCode(@Body LoginRequestModel loginRequestModel);


}
