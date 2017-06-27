package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/6/26.
 */

public class CreateProductsModel implements Serializable {

    private int promotionPrice;
    private boolean isFollowed;
    private boolean allowSecKill;
    private boolean allowAuction;
    private int viewCount;
    private int saleCount;
    private int followCount;
    private int score;
    private boolean disabled;
    private boolean allowDistribute;
    private int distributeRate;
    private int id;
    private String name;
    private int price;
    private Object brief;
    private Object thumb;
    private int secKillPrice;
    private String description;
    private Object richText;
    private boolean onSale;
    private Object unit;
    private Object taxonId;
    private int shopId;
    private String updated_at;
    private String created_at;
    private int amount;
    private Object brandId;
    private Object unitId;
    private Object categoryId;
    private Object promotionDiscountId;
    private Object promotionSecKillId;
    private String productNO;
    private List<CreateProductSKUs> productSKUs;

    private List<?> galleries;


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

    public boolean isAllowSecKill() {
        return allowSecKill;
    }

    public void setAllowSecKill(boolean allowSecKill) {
        this.allowSecKill = allowSecKill;
    }

    public boolean isAllowAuction() {
        return allowAuction;
    }

    public void setAllowAuction(boolean allowAuction) {
        this.allowAuction = allowAuction;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Object getBrief() {
        return brief;
    }

    public void setBrief(Object brief) {
        this.brief = brief;
    }

    public Object getThumb() {
        return thumb;
    }

    public void setThumb(Object thumb) {
        this.thumb = thumb;
    }

    public int getSecKillPrice() {
        return secKillPrice;
    }

    public void setSecKillPrice(int secKillPrice) {
        this.secKillPrice = secKillPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getRichText() {
        return richText;
    }

    public void setRichText(Object richText) {
        this.richText = richText;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public Object getUnit() {
        return unit;
    }

    public void setUnit(Object unit) {
        this.unit = unit;
    }

    public Object getTaxonId() {
        return taxonId;
    }

    public void setTaxonId(Object taxonId) {
        this.taxonId = taxonId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Object getBrandId() {
        return brandId;
    }

    public void setBrandId(Object brandId) {
        this.brandId = brandId;
    }

    public Object getUnitId() {
        return unitId;
    }

    public void setUnitId(Object unitId) {
        this.unitId = unitId;
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

    public String getProductNO() {
        return productNO;
    }

    public void setProductNO(String productNO) {
        this.productNO = productNO;
    }

    public List<CreateProductSKUs> getProductSKUs() {
        return productSKUs;
    }

    public void setProductSKUs(List<CreateProductSKUs> productSKUs) {
        this.productSKUs = productSKUs;
    }

    public List<?> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<?> galleries) {
        this.galleries = galleries;
    }


}
