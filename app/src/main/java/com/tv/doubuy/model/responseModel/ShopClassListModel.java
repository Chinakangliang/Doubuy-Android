package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/6/27.
 */

public class ShopClassListModel implements Serializable {

    private int pageSize;
    private int page;
    private int count;
    private List<ShopClassListChildrenBean> results;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ShopClassListChildrenBean> getResults() {
        return results;
    }

    public void setResults(List<ShopClassListChildrenBean> results) {
        this.results = results;
    }


}