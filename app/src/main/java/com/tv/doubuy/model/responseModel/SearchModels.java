package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/7/3.
 */

public class SearchModels implements Serializable {


    /**
     * pageSize : 10
     * page : 1
     * count : 1
     * results : [{"id":58,"userNO":"04725002","name":"测试cc","openid":null,"avatar":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/58/img14881743481888.jpg","gender":"female","birthday":null,"email":null,"mobile":"13817375013","phone":null,"totalScore":0,"level":1,"score":1000,"totalReceiveGold":0,"totalSendGold":0,"totalChargeGold":0,"gold":1000,"totalIncome":0,"balance":0,"realName":null,"totalBoughtAmount":0,"isAnchor":null,"anchorAvaliable":true,"isStaff":null,"isAdmin":null,"status":true,"city":null,"province":null,"country":null,"subscribe":null,"subscribeTime":null,"unionid":null,"wechatAppOpenid":null,"appOpenid":null,"created_at":"2017-02-27T05:44:40.165Z","updated_at":"2017-02-27T08:52:07.688Z","watchingLiveId":null}]
     */

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

    public static class ResultsBean implements Serializable {
        /**
         * id : 58
         * userNO : 04725002
         * name : 测试cc
         * openid : null
         * avatar : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/58/img14881743481888.jpg
         * gender : female
         * birthday : null
         * email : null
         * mobile : 13817375013
         * phone : null
         * totalScore : 0
         * level : 1
         * score : 1000
         * totalReceiveGold : 0
         * totalSendGold : 0
         * totalChargeGold : 0
         * gold : 1000
         * totalIncome : 0
         * balance : 0
         * realName : null
         * totalBoughtAmount : 0
         * isAnchor : null
         * anchorAvaliable : true
         * isStaff : null
         * isAdmin : null
         * status : true
         * city : null
         * province : null
         * country : null
         * subscribe : null
         * subscribeTime : null
         * unionid : null
         * wechatAppOpenid : null
         * appOpenid : null
         * created_at : 2017-02-27T05:44:40.165Z
         * updated_at : 2017-02-27T08:52:07.688Z
         * watchingLiveId : null
         */

        private int id;
        private String userNO;
        private String name;
        private Object openid;
        private String avatar;
        private String gender;
        private Object birthday;
        private Object email;
        private String mobile;
        private Object phone;
        private int totalScore;
        private int level;
        private int score;
        private int totalReceiveGold;
        private int totalSendGold;
        private int totalChargeGold;
        private int gold;
        private int totalIncome;
        private int balance;
        private Object realName;
        private int totalBoughtAmount;
        private Object isAnchor;
        private boolean anchorAvaliable;
        private Object isStaff;
        private Object isAdmin;
        private boolean status;
        private Object city;
        private Object province;
        private Object country;
        private Object subscribe;
        private Object subscribeTime;
        private Object unionid;
        private Object wechatAppOpenid;
        private Object appOpenid;
        private String created_at;
        private String updated_at;
        private Object watchingLiveId;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

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

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }

        public int getTotalBoughtAmount() {
            return totalBoughtAmount;
        }

        public void setTotalBoughtAmount(int totalBoughtAmount) {
            this.totalBoughtAmount = totalBoughtAmount;
        }

        public Object getIsAnchor() {
            return isAnchor;
        }

        public void setIsAnchor(Object isAnchor) {
            this.isAnchor = isAnchor;
        }

        public boolean isAnchorAvaliable() {
            return anchorAvaliable;
        }

        public void setAnchorAvaliable(boolean anchorAvaliable) {
            this.anchorAvaliable = anchorAvaliable;
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

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
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

        public Object getWatchingLiveId() {
            return watchingLiveId;
        }

        public void setWatchingLiveId(Object watchingLiveId) {
            this.watchingLiveId = watchingLiveId;
        }
    }
}
