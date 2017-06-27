package com.tv.doubuy.ui.store.shop.shopclass;

import android.content.Context;

import com.tv.doubuy.model.responseModel.DeteleModel;
import com.tv.doubuy.model.responseModel.ShopClassListModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/27.
 */

public class ShopClassPresenter {


    private Context mcontext;
    private ShopClassView shopClassView;

    private DouBuyCache douBuyCache;

    public ShopClassPresenter(Context context, ShopClassView shopClassView) {

        this.mcontext = context;
        this.shopClassView = shopClassView;

        douBuyCache = new DouBuyCache(mcontext);
    }

    public void getCalssList() {
        RetrofitUtils.getInstance(mcontext).getCalssList(douBuyCache.getStoreId(), new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                ShopClassListModel shopClassListModel = APIUtils.gson.fromJson(o.toString(), ShopClassListModel.class);
                if (shopClassListModel != null) {
                    shopClassView.getListClassData(shopClassListModel);
                }

            }
        }, mcontext));
    }


    public void detleClassProducts(String classid) {

        RetrofitUtils.getInstance(mcontext).deteleClassProduct(douBuyCache.getStoreId(), classid, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                DeteleModel deteleModel = APIUtils.gson.fromJson(o.toString(), DeteleModel.class);
                if (deteleModel != null) {
                    shopClassView.deteleCategories(deteleModel.isSuccess());

                }

            }
        }, mcontext));
    }
}
