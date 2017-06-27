package com.tv.doubuy.model.requestModel;

import java.io.Serializable;

/**
 * Created by apple on 2017/6/26.
 */

public class ProductSKUsBean implements Serializable {

    private String count;
    private String price;
    private String spec;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }


}
