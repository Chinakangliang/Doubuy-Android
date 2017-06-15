package com.tv.doubuy.model.responseModel;

/**
 * Created by apple on 2017/6/6.
 */
public class UserInfoModel {




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
         * id : 91
         * userNO : 149674292099491
         * name : 孜孜不倦、
         * openid : null
         * avatar : http://wx.qlogo.cn/mmopen/XrRCZV9A1A9z7DuZmJAeT2eM4xcwl2M6moeHr8VHtcRlMBy5VjWgKzuIIepQ0FPKwNZ5cgWWFlSUBibayaj58z7x7kIe13fT9/0
         * gender : male
         * birthday : null
         * email : null
         * mobile : 13166217355
         * phone : null
         * totalScore : 0
         * level : 1
         * score : 0
         * totalReceiveGold : 0
         * totalSendGold : 0
         * totalChargeGold : 0
         * gold : 0
         * totalIncome : 0
         * balance : 0
         * realName : null
         * totalBoughtAmount : 0
         * isAnchor : null
         * anchorAvaliable : true
         * isStaff : null
         * isAdmin : null
         * status : true
         * city :
         * province :
         * country : China
         * subscribe : false
         * subscribeTime : null
         * unionid : o5uzVw5KD63jlkdwTQg9ZUHr0zOk
         * wechatAppOpenid : null
         * appOpenid : oOetIwQ-w41oZeO4OI-bbwE1kwHI
         * created_at : 2017-06-06T09:55:20.872Z
         * updated_at : 2017-06-08T08:52:09.996Z
         * watchingLiveId : null
         * shop : {"id":76,"shopNO":"149723485889876","name":"豆佰直播","description":"the first shop of doubuy.","cover":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy5/img14812537204763.jpg","logo":"http://logo.image","QRCode":null,"followCount":0,"serviceAviable":false,"serviceEndDate":null,"totalSaledAmount":0,"score":0,"isFreeShip":true,"shipFee":0,"levelScore":0,"level":1,"isRecommend":false,"created_at":"2017-06-12T02:34:18.868Z","updated_at":"2017-06-14T03:33:49.776Z","areaId":null,"ownerId":91}
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
        private String city;
        private String province;
        private String country;
        private boolean subscribe;
        private Object subscribeTime;
        private String unionid;
        private Object wechatAppOpenid;
        private String appOpenid;
        private String created_at;
        private String updated_at;
        private Object watchingLiveId;
        private ShopBean shop;

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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public boolean isSubscribe() {
            return subscribe;
        }

        public void setSubscribe(boolean subscribe) {
            this.subscribe = subscribe;
        }

        public Object getSubscribeTime() {
            return subscribeTime;
        }

        public void setSubscribeTime(Object subscribeTime) {
            this.subscribeTime = subscribeTime;
        }

        public String getUnionid() {
            return unionid;
        }

        public void setUnionid(String unionid) {
            this.unionid = unionid;
        }

        public Object getWechatAppOpenid() {
            return wechatAppOpenid;
        }

        public void setWechatAppOpenid(Object wechatAppOpenid) {
            this.wechatAppOpenid = wechatAppOpenid;
        }

        public String getAppOpenid() {
            return appOpenid;
        }

        public void setAppOpenid(String appOpenid) {
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

        public ShopBean getShop() {
            return shop;
        }

        public void setShop(ShopBean shop) {
            this.shop = shop;
        }

        public static class ShopBean {
            /**
             * id : 76
             * shopNO : 149723485889876
             * name : 豆佰直播
             * description : the first shop of doubuy.
             * cover : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy5/img14812537204763.jpg
             * logo : http://logo.image
             * QRCode : null
             * followCount : 0
             * serviceAviable : false
             * serviceEndDate : null
             * totalSaledAmount : 0
             * score : 0
             * isFreeShip : true
             * shipFee : 0
             * levelScore : 0
             * level : 1
             * isRecommend : false
             * created_at : 2017-06-12T02:34:18.868Z
             * updated_at : 2017-06-14T03:33:49.776Z
             * areaId : null
             * ownerId : 91
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
    }
}
