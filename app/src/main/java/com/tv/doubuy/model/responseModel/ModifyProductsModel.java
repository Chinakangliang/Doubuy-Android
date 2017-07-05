package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/7/3.
 */

public class ModifyProductsModel implements Serializable {

    /**
     * promotionPrice : 565
     * isFollowed : false
     * id : 192
     * productNO : 1499092005270192
     * name : fghh
     * price : 565
     * amount : 0
     * brief : null
     * description :
     * allowSecKill : false
     * secKillPrice : 1
     * allowAuction : false
     * thumb : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg
     * onSale : true
     * viewCount : 8
     * saleCount : 0
     * followCount : 0
     * score : 0
     * richText : null
     * unit : null
     * disabled : false
     * allowDistribute : false
     * distributeRate : 0
     * created_at : 2017-07-03T14:26:45.247Z
     * updated_at : 2017-07-03T14:58:51.351Z
     * shopId : 79
     * brandId : null
     * taxonId : null
     * categoryId : null
     * promotionDiscountId : null
     * promotionSecKillId : null
     * galleries : [{"id":809,"name":null,"image":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg","description":null,"sort":null,"created_at":"2017-07-03T14:58:51.361Z","updated_at":"2017-07-03T14:58:51.361Z","productId":192},{"id":810,"name":null,"image":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg","description":null,"sort":null,"created_at":"2017-07-03T14:58:51.361Z","updated_at":"2017-07-03T14:58:51.361Z","productId":192},{"id":811,"name":null,"image":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg","description":null,"sort":null,"created_at":"2017-07-03T14:58:51.361Z","updated_at":"2017-07-03T14:58:51.361Z","productId":192},{"id":812,"name":null,"image":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg","description":null,"sort":null,"created_at":"2017-07-03T14:58:51.361Z","updated_at":"2017-07-03T14:58:51.361Z","productId":192},{"id":813,"name":null,"image":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg","description":null,"sort":null,"created_at":"2017-07-03T14:58:51.361Z","updated_at":"2017-07-03T14:58:51.361Z","productId":192}]
     * productSKUs : [{"promotionPrice":565,"id":468,"count":0,"price":565,"spec":"fjv","description":null,"disabled":false,"saleCount":null,"created_at":"2017-07-03T14:58:51.340Z","updated_at":"2017-07-03T14:58:51.340Z","productId":192},{"promotionPrice":565,"id":469,"count":0,"price":565,"spec":"fjv","description":null,"disabled":false,"saleCount":null,"created_at":"2017-07-03T14:58:51.346Z","updated_at":"2017-07-03T14:58:51.346Z","productId":192}]
     */

    private int promotionPrice;
    private boolean isFollowed;
    private int id;
    private String productNO;
    private String name;
    private int price;
    private int amount;
    private Object brief;
    private String description;
    private boolean allowSecKill;
    private int secKillPrice;
    private boolean allowAuction;
    private String thumb;
    private boolean onSale;
    private int viewCount;
    private int saleCount;
    private int followCount;
    private int score;
    private Object richText;
    private Object unit;
    private boolean disabled;
    private boolean allowDistribute;
    private int distributeRate;
    private String created_at;
    private String updated_at;
    private int shopId;
    private Object brandId;
    private Object taxonId;
    private Object categoryId;
    private Object promotionDiscountId;
    private Object promotionSecKillId;
    private List<GalleriesBean> galleries;
    private List<ProductSKUsBean> productSKUs;

    public int getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(int promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public boolean isIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNO() {
        return productNO;
    }

    public void setProductNO(String productNO) {
        this.productNO = productNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Object getBrief() {
        return brief;
    }

    public void setBrief(Object brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAllowSecKill() {
        return allowSecKill;
    }

    public void setAllowSecKill(boolean allowSecKill) {
        this.allowSecKill = allowSecKill;
    }

    public int getSecKillPrice() {
        return secKillPrice;
    }

    public void setSecKillPrice(int secKillPrice) {
        this.secKillPrice = secKillPrice;
    }

    public boolean isAllowAuction() {
        return allowAuction;
    }

    public void setAllowAuction(boolean allowAuction) {
        this.allowAuction = allowAuction;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Object getRichText() {
        return richText;
    }

    public void setRichText(Object richText) {
        this.richText = richText;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isAllowDistribute() {
        return allowDistribute;
    }

    public void setAllowDistribute(boolean allowDistribute) {
        this.allowDistribute = allowDistribute;
    }

    public int getDistributeRate() {
        return distributeRate;
    }

    public void setDistributeRate(int distributeRate) {
        this.distributeRate = distributeRate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public Object getBrandId() {
        return brandId;
    }

    public void setBrandId(Object brandId) {
        this.brandId = brandId;
    }

    public Object getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Object taxonId) {
        this.taxonId = taxonId;
    }

    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    public Object getPromotionDiscountId() {
        return promotionDiscountId;
    }

    public void setPromotionDiscountId(Object promotionDiscountId) {
        this.promotionDiscountId = promotionDiscountId;
    }

    public Object getPromotionSecKillId() {
        return promotionSecKillId;
    }

    public void setPromotionSecKillId(Object promotionSecKillId) {
        this.promotionSecKillId = promotionSecKillId;
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

    public static class GalleriesBean  implements  Serializable{
        /**
         * id : 809
         * name : null
         * image : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14865431644689.jpg
         * description : null
         * sort : null
         * created_at : 2017-07-03T14:58:51.361Z
         * updated_at : 2017-07-03T14:58:51.361Z
         * productId : 192
         */

        private int id;
        private Object name;
        private String image;
        private Object description;
        private Object sort;
        private String created_at;
        private String updated_at;
        private int productId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
    }

    public static class ProductSKUsBean  implements  Serializable{
        /**
         * promotionPrice : 565
         * id : 468
         * count : 0
         * price : 565
         * spec : fjv
         * description : null
         * disabled : false
         * saleCount : null
         * created_at : 2017-07-03T14:58:51.340Z
         * updated_at : 2017-07-03T14:58:51.340Z
         * productId : 192
         */

        private int promotionPrice;
        private int id;
        private int count;
        private int price;
        private String spec;
        private Object description;
        private boolean disabled;
        private Object saleCount;
        private String created_at;
        private String updated_at;
        private int productId;

        public int getPromotionPrice() {
            return promotionPrice;
        }

        public void setPromotionPrice(int promotionPrice) {
            this.promotionPrice = promotionPrice;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public Object getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(Object saleCount) {
            this.saleCount = saleCount;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
    }
}
