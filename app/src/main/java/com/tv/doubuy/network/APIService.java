package com.tv.doubuy.network;


import com.tv.doubuy.base.BaseResponse;
import com.tv.doubuy.model.requestModel.AddCalssModel;
import com.tv.doubuy.model.requestModel.BindMobileModel;
import com.tv.doubuy.model.requestModel.BindRequestModel;
import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.requestModel.CreateShposModel;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.requestModel.ProfileModel;
import com.tv.doubuy.model.requestModel.PutStoreInfoModel;
import com.tv.doubuy.model.requestModel.ShopIdCardModel;
import com.tv.doubuy.model.requestModel.SiginModel;
import com.tv.doubuy.model.requestModel.SignupModel;
import com.tv.doubuy.utils.DouBuyApplication;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
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

    public static String FUHAO = "¥";

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

//    @PUT("shops/{store_id}")
//    Observable<BaseResponse> putStoreInfo(@Path("store_id") String id, @Body UpStoreInfoModel upStoreInfoModel);

    @POST("users/{store_id}/createOrUpdateProfile")
    Observable<BaseResponse> setStoreInfoCard(@Path("store_id") String id, @Body ShopIdCardModel shopIdCardModel);

    @PUT("shops/{store_id}/info")
    Observable<BaseResponse> putStoreInfo(@Path("store_id") String id, @Body PutStoreInfoModel putStoreInfoModel);

    //    http://{{dbuy_api_server}}/shops/1/searchUser?searchStr=豆
    @GET("shops/{store_id}/searchUser")
    Observable<BaseResponse> searchshop(@Path("store_id") String id, @Query("searchStr") String str);


    @GET("shop/{store_id}/products")
    Observable<BaseResponse> getListProducts(@Path("store_id") String id, @Query("onSale") String onSale, @Query("order") String order);


    @POST("shop/{store_id}/products")
    Observable<BaseResponse> createProduct(@Path("store_id") String id, @Body CreateProductModel createProductModel);


    @DELETE("/shop/{store_id}/products/{productid}")
    Observable<BaseResponse> deteleProduct(@Path("store_id") String id, @Path("productid") String productid);


    @GET("shop/{store_id}/categories")
    Observable<BaseResponse> getClassList(@Path("store_id") String id);


    @POST("shop/{store_id}/categories")
    Observable<BaseResponse> addClassProduct(@Path("store_id") String id, @Body AddCalssModel addCalssModel);


    @DELETE("shop/{store_id}/categories/{class_id}")
    Observable<BaseResponse> deteleClass(@Path("store_id") String id, @Path("class_id") String classid);


    @PUT("shop/{store_id}/categories/{class_id}")
    Observable<BaseResponse> setmodfiyProduct(@Path("store_id") String id, @Path("class_id") String classid, @Body AddCalssModel addCalssModel);


}
