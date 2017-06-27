package com.tv.doubuy.ui.store.shop.shopclass;

import android.content.Context;

import com.tv.doubuy.model.requestModel.AddCalssModel;
import com.tv.doubuy.model.responseModel.CreateClassModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/27.
 */

public class AddClassPresenter {


    private Context mcontext;

    private AddClassView addclassview;
    private DouBuyCache douBuyCache;

    public AddClassPresenter(Context context, AddClassView addclassview) {

        this.mcontext = context;
        this.addclassview = addclassview;

        douBuyCache = new DouBuyCache(context);
    }

    public void putClassData(String classname, String description) {

        final AddCalssModel addCalssModel = new AddCalssModel();
        addCalssModel.setName(classname);
        addCalssModel.setDescription(description);

        RetrofitUtils.getInstance(mcontext).addclassProduct(douBuyCache.getStoreId(), addCalssModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                CreateClassModel createClassModel = APIUtils.gson.fromJson(o.toString(), CreateClassModel.class);
                if (createClassModel != null) {
                    addclassview.createdata("创建成功");

                }

            }
        }, mcontext));
    }

    public void setModfiy(String classname, String description, String calssid) {

        final AddCalssModel addCalssModel = new AddCalssModel();
        addCalssModel.setName(classname);
        addCalssModel.setDescription(description);

        RetrofitUtils.getInstance(mcontext).setModfiyProducts(douBuyCache.getStoreId(), calssid, addCalssModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                CreateClassModel createClassModel = APIUtils.gson.fromJson(o.toString(), CreateClassModel.class);
                if (createClassModel != null) {
                    addclassview.createdata("修改成功");

                }

            }
        }, mcontext));

    }
}
