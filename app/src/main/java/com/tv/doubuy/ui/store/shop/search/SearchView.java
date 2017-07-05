package com.tv.doubuy.ui.store.shop.search;

import com.tv.doubuy.model.responseModel.SearchModels;

/**
 * Created by apple on 2017/6/23.
 */

public interface SearchView {

    /**
     * 返回请求的结果
     */
    void searchData(SearchModels searchModels);
}
