package com.tv.doubuy.network;


import com.tv.doubuy.base.BaseResponse;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.model.requestModel.BindRequestModel;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.requestModel.SiginModel;
import com.tv.doubuy.model.requestModel.SignupModel;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by apple on 2017/6/2.
 */
public interface APIService {


    String APP_PATH = "http://" + APIUtils.getInstance().getApiPath() + "/";

    String APP_ID = "wx7f3402bea1f282ce";

    @POST("auth/sendCode")
    Observable<BaseResponse> setUserSendCode(@Body LoginRequestModel loginRequestModel);

    @POST("auth/sendCode")
    Observable<BaseResponse> setUserBindSendCode(@Body BindRequestModel bindRequestModel);


    @POST("auth/signup")
    Observable<BaseResponse> setUserSigin(@Body SignupModel signupModel);


    @POST("auth/appWechatLogin")
    Observable<BaseResponse> setWechatCode(@Query("code") String code);

    @POST("auth/appWechatBindMobile")
    Observable<BaseResponse> bindMobile(@Body BindMobileModel bindMobileModel);

    @POST("auth/signin")
    Observable<BaseResponse> userSignin(@Body SiginModel siginModel);

}
