package com.tv.doubuy.model.requestModel;

import java.util.List;

/**
 * Created by apple on 2017/6/26.
 */

public class CreateProductModel {


    private String description;
    private String name;
    private List<GalleriesBean> galleries;
    private List<ProductSKUsBean> productSKUs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GalleriesBean> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<GalleriesBean> galleries) {
        this.galleries = galleries;
    }

    public List<ProductSKUsBean> getProductSKUs() {
        return productSKUs;
    }

    public void setProductSKUs(List<ProductSKUsBean> productSKUs) {
        this.productSKUs = productSKUs;
    }




    public static class GalleriesBean {

        private String image;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class ProductSKUsBean {

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
}
