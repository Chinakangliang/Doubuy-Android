package com.tv.doubuy.model.responseModel;

/**
 * Created by apple on 2017/6/6.
 */
public class UserInfoModel {


    /**
     * user : {"id":1,"userNO":null,"name":"东山猕猴桃","openid":null,"avatar":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14926825441434.jpg","gender":"male","birthday":null,"email":"tonyq@163.com","mobile":"13671679562","phone":null,"totalScore":11652,"level":1,"score":10011212,"totalReceiveGold":86,"totalSendGold":1121,"totalChargeGold":0,"gold":9998879,"totalIncome":64.02,"balance":10000005,"realName":null,"totalBoughtAmount":0,"isAnchor":null,"anchorAvaliable":true,"isStaff":null,"isAdmin":true,"status":true,"city":null,"province":null,"country":null,"subscribe":null,"subscribeTime":null,"unionid":null,"wechatAppOpenid":null,"appOpenid":null,"created_at":"2016-12-18T09:52:09.014Z","updated_at":"2017-05-31T05:51:42.203Z","watchingLiveId":1063,"shop":{"id":1,"shopNO":"1","name":"豆佰直播","description":"the first shop of doubuy.","cover":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy_common/store%20bg%20default%403x.png","logo":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14924249251801.jpg","QRCode":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/1/img14914629567753.jpg","followCount":13,"serviceAviable":true,"serviceEndDate":null,"totalSaledAmount":4023,"score":4,"isFreeShip":false,"shipFee":10,"levelScore":23,"level":1,"isRecommend":true,"created_at":"2016-12-18T09:52:15.663Z","updated_at":"2017-06-21T09:33:18.590Z","areaId":null,"ownerId":1}}
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwibmFtZSI6IuS4nOWxseeMleeMtOahgyIsImlhdCI6MTQ5ODcwMzU4MCwiZXhwIjoxNDk5MzA4MzgwfQ.IaJM-GzehSgIsvcainBt20ARHm-KKmQalXxD2iOoGQA
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
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getUserNO() {
            return userNO;
        }

        public void setUserNO(Object userNO) {
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

        public double getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(double totalIncome) {
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

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
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

        public int getWatchingLiveId() {
            return watchingLiveId;
        }

        public void setWatchingLiveId(int watchingLiveId) {
            this.watchingLiveId = watchingLiveId;
        }

        public ShopInfoModel getShop() {
            return shop;
        }

        public void setShop(ShopInfoModel shop) {
            this.shop = shop;
        }

        private int id;
        private Object userNO;
        private String name;
        private Object openid;
        private String avatar;
        private String gender;
        private Object birthday;
        private String email;
        private String mobile;
        private Object phone;
        private int totalScore;
        private int level;
        private int score;
        private int totalReceiveGold;
        private int totalSendGold;
        private int totalChargeGold;
        private int gold;
        private double totalIncome;
        private int balance;
        private Object realName;
        private int totalBoughtAmount;
        private Object isAnchor;
        private boolean anchorAvaliable;
        private Object isStaff;
        private boolean isAdmin;
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
        private int watchingLiveId;
        private ShopInfoModel shop;

    }

}
