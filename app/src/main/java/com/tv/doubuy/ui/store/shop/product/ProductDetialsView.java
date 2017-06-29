package com.tv.doubuy.ui.store.shop.product;

import android.content.Context;

import com.tv.doubuy.model.responseModel.DetialsProductModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/28.
 */

public class ProductDetialsView {

    private Context mcontext;
    private ProductDetialsPresenter detialsPresenter;
    private DouBuyCache douBuyCache;

    public ProductDetialsView(Context context, ProductDetialsPresenter detialsPresenter) {
        this.mcontext = context;
        this.detialsPresenter = detialsPresenter;

        douBuyCache = new DouBuyCache(context);
    }

    public void getProductsDetails(String productsid) {

        RetrofitUtils.getInstance(mcontext).getProductsDetials(douBuyCache.getStoreId(), productsid, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                DetialsProductModel detialsProductModel = APIUtils.gson.fromJson(o.toString(), DetialsProductModel.class);
                if (detialsProductModel != null) {
                    detialsPresenter.geItemProductDetals(detialsProductModel);
                }

            }
        }, mcontext));


    }
}
