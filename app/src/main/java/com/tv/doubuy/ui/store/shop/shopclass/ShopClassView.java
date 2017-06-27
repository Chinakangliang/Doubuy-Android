package com.tv.doubuy.ui.store.shop.shopclass;

import com.tv.doubuy.model.responseModel.ShopClassListModel;

/**
 * Created by apple on 2017/6/27.
 */

public interface ShopClassView {

    void getListClassData(ShopClassListModel shopClassListModel);

    void deteleCategories(boolean ifsuccess);

}
