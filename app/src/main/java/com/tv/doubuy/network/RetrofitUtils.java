package com.tv.doubuy.network;

import android.content.Context;
import android.util.Log;

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

    public static String strToken = null;


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


        Log.i("111", "---getUserToken--" + strToken);

        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("Content-Type", "application/x-www-form-urlencoded")
                .addHeaderParams("Authorization", "JWT " + APIUtils.getInstance(context).getUserToken())
//                .addHeaderParams("Content-Type", "application/x-www-form-urlencoded")
                .build();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.connectTimeout(5, TimeUnit.SECONDS)
                .cookieJar(new JavaNetCookieJar(cookieHandler))
                .addInterceptor(commonInterceptor)
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

    /**
     * 验证码
     */

    public void setUserCode(LoginRequestModel loginRequestModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.setUserSendCode(loginRequestModel), subscriber);

    }

    public void setUseBindrCode(BindRequestModel bindRequestModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.setUserBindSendCode(bindRequestModel), subscriber);

    }

    /**
     * 手机号注册
     */
    public void setUserSigin(SignupModel signupModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.setUserSigin(signupModel), subscriber);

    }

    /**
     * 微信登录返回的CODE传给后台
     */
    public void setUserWXCode(String wxCode, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.setWechatCode(wxCode), subscriber);

    }


    /**
     * 微信登录绑定手机
     */
    public void setBindMobile(BindMobileModel bindMobile, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.bindMobile(bindMobile), subscriber);
    }


    /**
     * 账号密码登录
     */
    public void setUserSignin(SiginModel signin, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.userSignin(signin), subscriber);
    }

    /**
     * 重置密码
     */
    public void setUserReste(SiginModel siginModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.userReset(siginModel), subscriber);

    }

    /**
     * 一键开店将数据传给服务器
     */
    public void setCreateShop(CreateShposModel shop, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.userCreateShpos(shop), subscriber);
    }

    /**
     * 请求服务器返回芝麻信用的URL
     */
    public void getCreateZM(String id, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.zmCertify(id), subscriber);
    }

    /**
     * 获取店铺信息
     */

    public void getStoreInfo(String id, ProgressSubscriber subscriber) {


        toSubscribe(mApiService.getShopInfo(id), subscriber);
    }


    /**
     * 实体店认证
     */

    public void putUserCreateStore(String storeId, ProfileModel profileModel, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.userCreateStore(storeId, profileModel), subscriber);

    }

    /**
     * 上传店铺信息
     */
    public void putStoreInfo(String storeId, ShopIdCardModel storeInfoModel, ProgressSubscriber subscriber) {

//        toSubscribe(mApiService.putStoreInfo(storeId, storeInfoModel), subscriber);

        toSubscribe(mApiService.setStoreInfoCard(storeId, storeInfoModel), subscriber);

    }

    /**
     * 修改店铺信息
     */
    public void putModifyStoreInfo(String storeid, PutStoreInfoModel storeInfoModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.putStoreInfo(storeid, storeInfoModel), subscriber);

    }

    /**
     * 搜索
     */
    public void getSearchShop(String storeid, String str, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.searchshop(storeid, str), subscriber);
    }


    /**
     * 商品列表
     */
    public void getProductList(String storeid, String onSale, String order, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.getListProducts(storeid, onSale, order), subscriber);

    }

    /**
     * 发布商品
     */
    public void setCreateProduct(String id, CreateProductModel createProduct, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.createProduct(id, createProduct), subscriber);
    }

    /**
     * 删除商品
     */
    public void deteleProducts(String storeid, String productid, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.deteleProduct(storeid, productid), subscriber);
    }

    /**
     * 分类
     */
    public void getCalssList(String storeid, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.getClassList(storeid), subscriber);
    }

    /**
     * 添加分类
     */
    public void addclassProduct(String stroeid, AddCalssModel addCalssModel, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.addClassProduct(stroeid, addCalssModel), subscriber);

    }

    /**
     * 删除分类
     */

    public void deteleClassProduct(String stroeid, String classid, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.deteleClass(stroeid, classid), subscriber);
    }


    /**
     * 修改分类
     */
    public void setModfiyProducts(String stroeid, String classid, AddCalssModel addCalssModel, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.setmodfiyProduct(stroeid, classid, addCalssModel), subscriber);

    }

    /**
     * 商品详情
     */
    public void getProductsDetials(String stroeid, String productsid, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.getProductsDetials(stroeid, productsid), subscriber);

    }

    /**
     * 客户列表
     */

    public void getCustomerList(String stroeid, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.getCustomerList(stroeid), subscriber);

    }

    /**
     * 下架
     */
    public void putProductsDown(String storeid, String productsid, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.putProductsDown(storeid, productsid), subscriber);

    }

    /**
     * 上架
     */
    public void putProductsUp(String storeid, String productsid, ProgressSubscriber subscriber) {

        toSubscribe(mApiService.putProductsUp(storeid, productsid), subscriber);
    }

    /**
     * 修改商品
     */
    public void putModifyProducts(String storeid, String productsid, CreateProductModel productModel, ProgressSubscriber subscriber) {
        toSubscribe(mApiService.modifyProducts(storeid, productsid, productModel), subscriber);

    }


    private <T> void toSubscribe(Observable<T> o, Subscriber s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
