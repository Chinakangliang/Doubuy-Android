package com.tv.doubuy.ui.store.shop.adds;

import android.content.Context;

import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/26.
 */

public class AddShopPresenter {


    private Context mcontext;

    private AddShopView addShopView;

    private DouBuyCache douBuyCache;

    public AddShopPresenter(Context context, AddShopView addShopView) {

        this.mcontext = context;
        this.addShopView = addShopView;

        douBuyCache = new DouBuyCache(context);

    }


    public void createProducts(CreateProductModel productModel) {

        RetrofitUtils.getInstance(mcontext).setCreateProduct(douBuyCache.getStoreId(), productModel, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                CreateProductModel createProductModel = APIUtils.gson.fromJson(o.toString(), CreateProductModel.class);
                if (createProductModel != null) {
                    addShopView.onReleaseProducts(createProductModel);
                }

            }
        }, mcontext));

    }


}
