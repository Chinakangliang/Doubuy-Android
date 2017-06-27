package com.tv.doubuy.model.responseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017/6/26.
 */

public class ShopInfoModel implements Serializable {

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

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
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

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
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
