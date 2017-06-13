package com.tv.doubuy.network;


import com.tv.doubuy.base.BaseResponse;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.model.requestModel.BindRequestModel;
import com.tv.doubuy.model.requestModel.CreateShposModel;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.requestModel.ProfileModel;
import com.tv.doubuy.model.requestModel.SiginModel;
import com.tv.doubuy.model.requestModel.SignupModel;
import com.tv.doubuy.model.requestModel.UpStoreInfoModel;
import com.tv.doubuy.utils.DouBuyApplication;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by apple on 2017/6/2.
 */
public interface APIService {


    String APP_PATH = "http://" + APIUtils.getInstance(DouBuyApplication.getInstance()).getApiPath() + "/";

    String APP_ID = "wx7f3402bea1f282ce";

    String ALIYUN_ACCESS_KEY_ID = "NXKLh9N8k4pMFNxS";
    String ALIYUN_SECRET_ACCESS_KEY = "N6LvCE3U23Rgxz5XItLVzZLlBNpbGW";
    String ALIYUN_STORAGE_BUCKET_NAME = "soundlife-app";
    String ALIYUN_OSS_HOST = "http://oss-cn-hangzhou.aliyuncs.com/";
    String ALIYUN_OSS_IMAGE_PATH = "http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/";


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

    @POST("auth/resetPassword")
    Observable<BaseResponse> userReset(@Body SiginModel siginModel);

    @POST("shops")
    Observable<BaseResponse> userCreateShpos(@Body CreateShposModel createShpsModel);

    @GET("users/{store_id}/zmCertifyUrl")
    Observable<BaseResponse> zmCertify(@Path("store_id") String id);

    @PUT("shops/{store_id}/profile")
    Observable<BaseResponse> userCreateStore(@Path("store_id") String id, @Body ProfileModel profileModel);

    @GET("admin/shops/{store_id}")
    Observable<BaseResponse> getShopInfo(@Path("store_id") String id);

    @PUT("shops/{store_id}")
    Observable<BaseResponse> putStoreInfo(@Path("store_id") String id, @Body UpStoreInfoModel upStoreInfoModel);

}
