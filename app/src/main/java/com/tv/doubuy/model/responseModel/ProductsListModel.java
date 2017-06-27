package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/6/26.
 */

public class ProductsListModel implements Serializable {

    private int pageSize;
    private int page;
    private int count;
    private List<ResultsBean> results;


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

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }


    public static class ResultsBean {

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
        private Object promotionDiscount;
        private Object promotionSecKill;
        private ShopInfoModel shop;
        private List<CreateProductSKUs> productSKUs;
        private List<ProductGalleriesBean> galleries;
        private List<?> favoriteUser;
        private List<?> comments;

        public int getPromotionPrice() {
            return promotionPrice;
        }

        public void setPromotionPrice(int promotionPrice) {
            this.promotionPrice = promotionPrice;
        }

        public boolean isFollowed() {
            return isFollowed;
        }

        public void setFollowed(boolean followed) {
            isFollowed = followed;
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

        public Object getPromotionDiscount() {
            return promotionDiscount;
        }

        public void setPromotionDiscount(Object promotionDiscount) {
            this.promotionDiscount = promotionDiscount;
        }

        public Object getPromotionSecKill() {
            return promotionSecKill;
        }

        public void setPromotionSecKill(Object promotionSecKill) {
            this.promotionSecKill = promotionSecKill;
        }

        public ShopInfoModel getShop() {
            return shop;
        }

        public void setShop(ShopInfoModel shop) {
            this.shop = shop;
        }

        public List<CreateProductSKUs> getProductSKUs() {
            return productSKUs;
        }

        public void setProductSKUs(List<CreateProductSKUs> productSKUs) {
            this.productSKUs = productSKUs;
        }

        public List<ProductGalleriesBean> getGalleries() {
            return galleries;
        }

        public void setGalleries(List<ProductGalleriesBean> galleries) {
            this.galleries = galleries;
        }

        public List<?> getFavoriteUser() {
            return favoriteUser;
        }

        public void setFavoriteUser(List<?> favoriteUser) {
            this.favoriteUser = favoriteUser;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }
    }
}
