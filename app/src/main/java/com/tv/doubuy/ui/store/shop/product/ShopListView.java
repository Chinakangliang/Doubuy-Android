package com.tv.doubuy.ui.store.shop.product;

import android.content.Context;

import com.tv.doubuy.model.responseModel.DeteleModel;
import com.tv.doubuy.model.responseModel.ProductsListModel;
import com.tv.doubuy.model.responseModel.SaleModel;
import com.tv.doubuy.network.APIUtils;
import com.tv.doubuy.network.ProgressSubscriber;
import com.tv.doubuy.network.RetrofitUtils;
import com.tv.doubuy.network.SubscriberOnNextListener;
import com.tv.doubuy.utils.DouBuyCache;

/**
 * Created by apple on 2017/6/26.
 */

public class ShopListView {

    private ShopListPresenter presenter;

    private Context mcontext;
    private DouBuyCache douBuyCache;

    public ShopListView(Context context, ShopListPresenter presenter) {

        this.presenter = presenter;
        this.mcontext = context;
        douBuyCache = new DouBuyCache(context);

    }


    /**
     * 获取商品列表
     */
    public void getShopList(String onsalse) {
        RetrofitUtils.getInstance(mcontext).getProductList(douBuyCache.getStoreId(), onsalse, "saleDown", new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                ProductsListModel listmode = APIUtils.gson.fromJson(o.toString(), ProductsListModel.class);
                if (listmode != null) {
                    presenter.productlistdata(listmode);
                }

            }
        }, mcontext));

    }

    /**
     * 删除
     */
    public void deteleProduct(String productid) {

        RetrofitUtils.getInstance(mcontext).deteleProducts(douBuyCache.getStoreId(), productid, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                DeteleModel deteleModel = APIUtils.gson.fromJson(o.toString(), DeteleModel.class);
                if (deteleModel != null) {

                    presenter.deteleProduct(deteleModel.isSuccess());
                }

            }
        }, mcontext));
    }

    /**
     * 下架
     */
    public void putNoSale(String productId) {

        RetrofitUtils.getInstance(mcontext).putProductsDown(douBuyCache.getStoreId(), productId, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {

                SaleModel saleModel = APIUtils.gson.fromJson(o.toString(), SaleModel.class);
                if (saleModel != null) {
                    presenter.noSale(true);
                } else {
                    presenter.noSale(false);
                }

            }
        }, mcontext));
    }

    /**
     * 上架
     */

    public void putOnSale(String productId) {
        RetrofitUtils.getInstance(mcontext).putProductsUp(douBuyCache.getStoreId(), productId, new ProgressSubscriber(new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                SaleModel saleModel = APIUtils.gson.fromJson(o.toString(), SaleModel.class);
                if (saleModel != null) {
                    presenter.onSale(true);
                } else {
                    presenter.onSale(false);
                }

            }
        }, mcontext));

    }


}
