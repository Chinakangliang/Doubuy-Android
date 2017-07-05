package com.tv.doubuy.ui.login;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.tv.doubuy.MainActivity;
import com.tv.doubuy.dialog.Progresloading;
import com.tv.doubuy.model.requestModel.LoginRequestModel;
import com.tv.doubuy.model.requestModel.SignupModel;
import com.tv.doubuy.model.responseModel.LoginModel;
import com.tv.doubuy.model.responseModel.RegisModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;
import com.tv.doubuy.utils.VerificationUtils;

/**
 * Created by apple on 2017/6/6.
 */
public class RegisPresenter {

    private Context mcontext;

    private DouBuyCache dbCache;


    public RegisPresenter(Context context) {

        this.mcontext = context;

        dbCache = new DouBuyCache(context);
    }

    /**
     * 发送验证码 有TYPE
     */
    public void setUserCode(LoginRequestModel loginRequestModel) {

        RetrofitUtils retrofitUtils = new RetrofitUtils(mcontext);
        retrofitUtils.setUserCode(loginRequestModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                Toast.makeText(mcontext, "" + o.toString(), Toast.LENGTH_SHORT).show();
            }
        }, mcontext));
    }

//    public void setUserBindogCode(BindRequestModel bindogCode) {
//
//        RetrofitUtils.getInstance(mcontext).setUseBindrCode(bindogCode, new ProgressSubscriber(new SubscriberOnNextListener() {
//            @Override
//            public void onNext(Object o) {
//
//                Toast.makeText(mcontext, "" + o.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }, mcontext));
//    }


    /**
     * 判断输入格式  CODE不用判断
     */
    public void isStringUp(String modile, String code, String passwrod) {

        boolean isPassword = VerificationUtils.isPasswordLegal(passwrod);
        boolean isPhone = VerificationUtils.isPhoneLegal(modile);

        if (isPassword || isPhone) {
            SignupModel sigModel = new SignupModel();
            sigModel.setMobile(modile);
            sigModel.setCode(code);
            sigModel.setPassword(passwrod);
            setUserRegis(sigModel);
        } else {

            Toast.makeText(mcontext, "账号或密码格式错误", Toast.LENGTH_SHORT).show();
        }


    }


    /**
     * 注册
     */
    public void setUserRegis(SignupModel signmodel) {

        final Progresloading progresloading = new Progresloading(mcontext);
        progresloading.loadShow();
        RetrofitUtils utils = new RetrofitUtils(mcontext);

        utils.setUserSigin(signmodel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                RegisModel infoModel = APIUtils.gson.fromJson(o.toString(), RegisModel.class);
                if (!TextUtils.isEmpty(infoModel.getToken())) {
                    dbCache.saveUserToken(infoModel.getToken());
                    dbCache.saveUserId(infoModel.getUser().getId() + "");
                    Intent intent = new Intent(mcontext, LoginActivity.class);
                    mcontext.startActivity(intent);
                    progresloading.cleanload();
                }


            }
        }, mcontext));


    }

}
