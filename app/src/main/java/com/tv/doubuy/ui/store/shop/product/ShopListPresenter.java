package com.tv.doubuy.ui.store.shop.product;

import com.tv.doubuy.model.responseModel.ProductsListModel;

/**
 * Created by apple on 2017/6/26.
 */

public interface ShopListPresenter {

    void productlistdata(ProductsListModel productsListModel);

    void deteleProduct(boolean isdetele);

    void onSale(boolean isSale);
}
