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

    public static class ResultsBean  implements  Serializable {
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
        private ShopBean shop;

        public boolean isFollowed() {
            return isFollowed;
        }

        public void setFollowed(boolean followed) {
            isFollowed = followed;
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

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
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

        public static class ShopBean  implements  Serializable{
            /**
             * id : 30
             * shopNO : 30
             * name : 小松鼠旗舰店
             * description : 这是一家奇妙的超能力旗舰店呜拉巴哈，耶嘿！
             * cover : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/39/img14870400369704.jpg
             * logo : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/39/img14870397054205.jpg
             * QRCode : null
             * followCount : 0
             * serviceAviable : true
             * serviceEndDate : null
             * totalSaledAmount : 980
             * score : 0
             * isFreeShip : true
             * shipFee : 0
             * levelScore : 980
             * level : 1
             * isRecommend : false
             * created_at : 2017-02-14T02:36:47.417Z
             * updated_at : 2017-06-30T08:20:13.309Z
             * areaId : null
             * ownerId : 39
             */

            private int id;
            private String shopNO;
            private String name;
            private String description;
            private String cover;
            private String logo;
            private Object QRCode;
            private int followCount;
            private boolean serviceAviable;
            private Object serviceEndDate;
            private int totalSaledAmount;
            private int score;
            private boolean isFreeShip;
            private int shipFee;
            private int levelScore;
            private int level;
            private boolean isRecommend;
            private String created_at;
            private String updated_at;
            private Object areaId;
            private int ownerId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShopNO() {
                return shopNO;
            }

            public void setShopNO(String shopNO) {
                this.shopNO = shopNO;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Object getQRCode() {
                return QRCode;
            }

            public void setQRCode(Object QRCode) {
                this.QRCode = QRCode;
            }

            public int getFollowCount() {
                return followCount;
            }

            public void setFollowCount(int followCount) {
                this.followCount = followCount;
            }

            public boolean isServiceAviable() {
                return serviceAviable;
            }

            public void setServiceAviable(boolean serviceAviable) {
                this.serviceAviable = serviceAviable;
            }

            public Object getServiceEndDate() {
                return serviceEndDate;
            }

            public void setServiceEndDate(Object serviceEndDate) {
                this.serviceEndDate = serviceEndDate;
            }

            public int getTotalSaledAmount() {
                return totalSaledAmount;
            }

            public void setTotalSaledAmount(int totalSaledAmount) {
                this.totalSaledAmount = totalSaledAmount;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public boolean isIsFreeShip() {
                return isFreeShip;
            }

            public void setIsFreeShip(boolean isFreeShip) {
                this.isFreeShip = isFreeShip;
            }

            public int getShipFee() {
                return shipFee;
            }

            public void setShipFee(int shipFee) {
                this.shipFee = shipFee;
            }

            public int getLevelScore() {
                return levelScore;
            }

            public void setLevelScore(int levelScore) {
                this.levelScore = levelScore;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public boolean isIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(boolean isRecommend) {
                this.isRecommend = isRecommend;
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

            public Object getAreaId() {
                return areaId;
            }

            public void setAreaId(Object areaId) {
                this.areaId = areaId;
            }

            public int getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(int ownerId) {
                this.ownerId = ownerId;
            }
        }

        public static class ProductSKUsBean  implements  Serializable{
            /**
             * promotionPrice : 669
             * id : 418
             * count : 888
             * price : 669
             * spec : 888
             * description : null
             * disabled : false
             * saleCount : null
             * created_at : 2017-07-03T02:39:03.115Z
             * updated_at : 2017-07-03T02:39:03.115Z
             * productId : 174
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

        public static class GalleriesBean  implements  Serializable {
            /**
             * id : 730
             * name : null
             * image : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/39/img/1499049537640130.jpg
             * description : null
             * sort : null
             * created_at : 2017-07-03T02:39:03.159Z
             * updated_at : 2017-07-03T02:39:03.159Z
             * productId : 174
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
    }
}
