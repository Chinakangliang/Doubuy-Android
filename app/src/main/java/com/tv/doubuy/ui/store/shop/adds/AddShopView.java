package com.tv.doubuy.ui.store.shop.adds;

import com.tv.doubuy.model.requestModel.CreateProductModel;
import com.tv.doubuy.model.responseModel.ModifyProductsModel;

/**
 * Created by apple on 2017/6/26.
 */

public interface AddShopView {
    void onReleaseProducts(CreateProductModel productModel);

    void  onModifyProducts(ModifyProductsModel modifyProductsModel);
}
