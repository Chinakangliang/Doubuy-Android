package com.tv.doubuy.model.responseModel;

import java.io.Serializable;

/**
 * Created by lxy on 2017/6/28.
 */

public class CustomerModel implements Serializable {

    private int id;
    private String name;
    private int openid;
    private String avatar;
    private String email;
    private String mobile;
    private String birthday;
    private int score;
    private int gold;
    private int balance;
    private String realName;
    private String passwordDigest;
    private String gender;
    private Boolean isStaff;
    private Boolean isAnchor;
    private Boolean isAdmin;
    private Boolean status;
    private Boolean anchorAvaliable;
    private String created_at;
    private String updated_at;
    private String watchingLiveId;
    private Float totalBoughtAmount;

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

    public int getOpenid() {
        return openid;
    }

    public void setOpenid(int openid) {
        this.openid = openid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    public Boolean getAnchor() {
        return isAnchor;
    }

    public void setAnchor(Boolean anchor) {
        isAnchor = anchor;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAnchorAvaliable() {
        return anchorAvaliable;
    }

    public void setAnchorAvaliable(Boolean anchorAvaliable) {
        this.anchorAvaliable = anchorAvaliable;
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

    public String getWatchingLiveId() {
        return watchingLiveId;
    }

    public void setWatchingLiveId(String watchingLiveId) {
        this.watchingLiveId = watchingLiveId;
    }

    public Float getTotalBoughtAmount() {
        return totalBoughtAmount;
    }

    public void setTotalBoughtAmount(Float totalBoughtAmount) {
        this.totalBoughtAmount = totalBoughtAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPasswordDigest() {
        return passwordDigest;
    }

    public void setPasswordDigest(String passwordDigest) {
        this.passwordDigest = passwordDigest;
    }
}
