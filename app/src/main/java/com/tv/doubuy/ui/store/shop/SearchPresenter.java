package com.tv.doubuy.ui.store.shop;

import android.content.Context;

import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/23.
 */

public class SearchPresenter {

    private Context mcontext;
    private SearchView searchView;

    public SearchPresenter(SearchView searchView, Context context) {

        this.mcontext = context;
        this.searchView = searchView;
    }

    public void setSearchProduct(String str) {

        DouBuyCache douBuyCache = new DouBuyCache(mcontext);

        RetrofitUtils.getInstance(mcontext).getSearchShop(douBuyCache.getStoreId(), str, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                searchView.searchData();
            }
        }, mcontext));
    }
}
