package com.tv.doubuy.model.responseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017/7/4.
 */

public class RegisModel  implements Serializable {


    /**
     * user : {"totalScore":0,"level":1,"score":0,"totalReceiveGold":0,"totalSendGold":0,"totalChargeGold":0,"gold":0,"totalIncome":0,"balance":0,"totalBoughtAmount":0,"anchorAvaliable":true,"status":true,"id":102,"userNO":"1499137883554102","mobile":"13166217355","updated_at":"2017-07-04T03:11:23.556Z","created_at":"2017-07-04T03:11:23.418Z","name":null,"openid":null,"avatar":null,"gender":null,"birthday":null,"email":null,"realName":null,"isAnchor":null,"isStaff":null,"isAdmin":null,"watchingLiveId":null,"phone":null,"city":null,"country":null,"province":null,"subscribe":null,"subscribeTime":null,"unionid":null,"wechatAppOpenid":null,"appOpenid":null}
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAyLCJuYW1lIjpudWxsLCJpYXQiOjE0OTkxMzc4ODMsImV4cCI6MTQ5OTc0MjY4M30.3VXYK-eB0VO380D2KRKlVc1CV2DT3j-k60I7LNLuCCs
     */

    private UserBean user;
    private String token;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class UserBean {
        /**
         * totalScore : 0
         * level : 1
         * score : 0
         * totalReceiveGold : 0
         * totalSendGold : 0
         * totalChargeGold : 0
         * gold : 0
         * totalIncome : 0
         * balance : 0
         * totalBoughtAmount : 0
         * anchorAvaliable : true
         * status : true
         * id : 102
         * userNO : 1499137883554102
         * mobile : 13166217355
         * updated_at : 2017-07-04T03:11:23.556Z
         * created_at : 2017-07-04T03:11:23.418Z
         * name : null
         * openid : null
         * avatar : null
         * gender : null
         * birthday : null
         * email : null
         * realName : null
         * isAnchor : null
         * isStaff : null
         * isAdmin : null
         * watchingLiveId : null
         * phone : null
         * city : null
         * country : null
         * province : null
         * subscribe : null
         * subscribeTime : null
         * unionid : null
         * wechatAppOpenid : null
         * appOpenid : null
         */

        private int totalScore;
        private int level;
        private int score;
        private int totalReceiveGold;
        private int totalSendGold;
        private int totalChargeGold;
        private int gold;
        private int totalIncome;
        private int balance;
        private int totalBoughtAmount;
        private boolean anchorAvaliable;
        private boolean status;
        private int id;
        private String userNO;
        private String mobile;
        private String updated_at;
        private String created_at;
        private Object name;
        private Object openid;
        private Object avatar;
        private Object gender;
        private Object birthday;
        private Object email;
        private Object realName;
        private Object isAnchor;
        private Object isStaff;
        private Object isAdmin;
        private Object watchingLiveId;
        private Object phone;
        private Object city;
        private Object country;
        private Object province;
        private Object subscribe;
        private Object subscribeTime;
        private Object unionid;
        private Object wechatAppOpenid;
        private Object appOpenid;

        public int getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getTotalReceiveGold() {
            return totalReceiveGold;
        }

        public void setTotalReceiveGold(int totalReceiveGold) {
            this.totalReceiveGold = totalReceiveGold;
        }

        public int getTotalSendGold() {
            return totalSendGold;
        }

        public void setTotalSendGold(int totalSendGold) {
            this.totalSendGold = totalSendGold;
        }

        public int getTotalChargeGold() {
            return totalChargeGold;
        }

        public void setTotalChargeGold(int totalChargeGold) {
            this.totalChargeGold = totalChargeGold;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(int totalIncome) {
            this.totalIncome = totalIncome;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getTotalBoughtAmount() {
            return totalBoughtAmount;
        }

        public void setTotalBoughtAmount(int totalBoughtAmount) {
            this.totalBoughtAmount = totalBoughtAmount;
        }

        public boolean isAnchorAvaliable() {
            return anchorAvaliable;
        }

        public void setAnchorAvaliable(boolean anchorAvaliable) {
            this.anchorAvaliable = anchorAvaliable;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserNO() {
            return userNO;
        }

        public void setUserNO(String userNO) {
            this.userNO = userNO;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }

        public Object getIsAnchor() {
            return isAnchor;
        }

        public void setIsAnchor(Object isAnchor) {
            this.isAnchor = isAnchor;
        }

        public Object getIsStaff() {
            return isStaff;
        }

        public void setIsStaff(Object isStaff) {
            this.isStaff = isStaff;
        }

        public Object getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(Object isAdmin) {
            this.isAdmin = isAdmin;
        }

        public Object getWatchingLiveId() {
            return watchingLiveId;
        }

        public void setWatchingLiveId(Object watchingLiveId) {
            this.watchingLiveId = watchingLiveId;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(Object subscribe) {
            this.subscribe = subscribe;
        }

        public Object getSubscribeTime() {
            return subscribeTime;
        }

        public void setSubscribeTime(Object subscribeTime) {
            this.subscribeTime = subscribeTime;
        }

        public Object getUnionid() {
            return unionid;
        }

        public void setUnionid(Object unionid) {
            this.unionid = unionid;
        }

        public Object getWechatAppOpenid() {
            return wechatAppOpenid;
        }

        public void setWechatAppOpenid(Object wechatAppOpenid) {
            this.wechatAppOpenid = wechatAppOpenid;
        }

        public Object getAppOpenid() {
            return appOpenid;
        }

        public void setAppOpenid(Object appOpenid) {
            this.appOpenid = appOpenid;
        }
    }
}
