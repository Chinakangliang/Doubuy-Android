package com.tv.doubuy.model.responseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/6/13.
 */

public class StoreInfoModel implements Serializable {


    /**
     * id : 78
     * shopNO : 149759660333278
     * name : 我的小店
     * description : 尽可能莫时间默默
     * cover : aaaaa
     * logo : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/93/img/14975974987757059.jpg
     * QRCode : null
     * followCount : 0
     * serviceAviable : true
     * serviceEndDate : null
     * totalSaledAmount : 0
     * score : 0
     * isFreeShip : true
     * shipFee : 0
     * levelScore : 0
     * level : 1
     * isRecommend : false
     * created_at : 2017-06-16T07:03:23.318Z
     * updated_at : 2017-06-16T07:20:29.093Z
     * areaId : null
     * ownerId : 93
     * owner : {"id":93,"userNO":"149759645281293","name":null,"openid":null,"avatar":null,"gender":null,"birthday":null,"email":null,"mobile":"13166217355","phone":null,"totalScore":0,"level":1,"score":0,"totalReceiveGold":0,"totalSendGold":0,"totalChargeGold":0,"gold":0,"totalIncome":0,"balance":0,"realName":null,"totalBoughtAmount":0,"passwordDigest":"$2a$10$apjBAaKPU0M56nFjFtLVBeWSWTvO.6i4KV3fo9PN5IjBfRLO9AbI2","isAnchor":null,"anchorAvaliable":true,"isStaff":null,"isAdmin":null,"status":true,"city":null,"province":null,"country":null,"subscribe":null,"subscribeTime":null,"unionid":null,"wechatAppOpenid":null,"appOpenid":null,"created_at":"2017-06-16T07:00:52.676Z","updated_at":"2017-06-16T08:24:42.666Z","watchingLiveId":null,"profile":{"id":24,"bankAccount":null,"payeeName":null,"bankOfDeposit":null,"openid":null,"wechatName":null,"alipayAccount":null,"realName":"看了看","idCardNO":"6699","idCardImage1":null,"idCardImage2":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/93/img/14975972776672818.jpg","realNameStatus":"pending","verifyType":"zhima","created_at":"2017-06-16T07:03:23.410Z","updated_at":"2017-06-16T07:14:38.569Z","userId":93}}
     * staffs : [{"id":93,"userNO":"149759645281293","name":null,"openid":null,"avatar":null,"gender":null,"birthday":null,"email":null,"mobile":"13166217355","phone":null,"totalScore":0,"level":1,"score":0,"totalReceiveGold":0,"totalSendGold":0,"totalChargeGold":0,"gold":0,"totalIncome":0,"balance":0,"realName":null,"totalBoughtAmount":0,"passwordDigest":"$2a$10$apjBAaKPU0M56nFjFtLVBeWSWTvO.6i4KV3fo9PN5IjBfRLO9AbI2","isAnchor":null,"anchorAvaliable":true,"isStaff":null,"isAdmin":null,"status":true,"city":null,"province":null,"country":null,"subscribe":null,"subscribeTime":null,"unionid":null,"wechatAppOpenid":null,"appOpenid":null,"created_at":"2017-06-16T07:00:52.676Z","updated_at":"2017-06-16T08:24:42.666Z","watchingLiveId":null,"shopStaffs":{"description":null}}]
     * customers : []
     * profile : {"id":68,"companyName":null,"businessAddress":null,"businessPhone":null,"shippingAddress":null,"bankAccount":null,"bankOfDeposit":null,"wechatSubscriptionId":null,"wechatSubscriptionKeyt":null,"legalPerson":null,"legalPersonNO":null,"legalPersonLicenceImage1":null,"legalPersonLicenceImage2":null,"licenseNO":null,"licenseImage":null,"taxLicenseImage":null,"realNameStatus":"pending","realShopStatus":"notApply","created_at":"2017-06-16T07:03:23.372Z","updated_at":"2017-06-16T07:14:38.605Z","shopId":78}
     * isFollowed : false
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
    private OwnerBean owner;
    private ProfileBeanX profile;
    private boolean isFollowed;
    private List<StaffsBean> staffs;
    private List<?> customers;

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

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public ProfileBeanX getProfile() {
        return profile;
    }

    public void setProfile(ProfileBeanX profile) {
        this.profile = profile;
    }

    public boolean isIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

    public List<StaffsBean> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<StaffsBean> staffs) {
        this.staffs = staffs;
    }

    public List<?> getCustomers() {
        return customers;
    }

    public void setCustomers(List<?> customers) {
        this.customers = customers;
    }

    public static class OwnerBean {
        /**
         * id : 93
         * userNO : 149759645281293
         * name : null
         * openid : null
         * avatar : null
         * gender : null
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
         * passwordDigest : $2a$10$apjBAaKPU0M56nFjFtLVBeWSWTvO.6i4KV3fo9PN5IjBfRLO9AbI2
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
         * created_at : 2017-06-16T07:00:52.676Z
         * updated_at : 2017-06-16T08:24:42.666Z
         * watchingLiveId : null
         * profile : {"id":24,"bankAccount":null,"payeeName":null,"bankOfDeposit":null,"openid":null,"wechatName":null,"alipayAccount":null,"realName":"看了看","idCardNO":"6699","idCardImage1":null,"idCardImage2":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/93/img/14975972776672818.jpg","realNameStatus":"pending","verifyType":"zhima","created_at":"2017-06-16T07:03:23.410Z","updated_at":"2017-06-16T07:14:38.569Z","userId":93}
         */

        private int id;
        private String userNO;
        private String name;
        private Object openid;
        private Object avatar;
        private Object gender;
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
        private String passwordDigest;
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
        private ProfileBean profile;

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

        public String getPasswordDigest() {
            return passwordDigest;
        }

        public void setPasswordDigest(String passwordDigest) {
            this.passwordDigest = passwordDigest;
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

        public ProfileBean getProfile() {
            return profile;
        }

        public void setProfile(ProfileBean profile) {
            this.profile = profile;
        }

        public static class ProfileBean {
            /**
             * id : 24
             * bankAccount : null
             * payeeName : null
             * bankOfDeposit : null
             * openid : null
             * wechatName : null
             * alipayAccount : null
             * realName : 看了看
             * idCardNO : 6699
             * idCardImage1 : null
             * idCardImage2 : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy/93/img/14975972776672818.jpg
             * realNameStatus : pending
             * verifyType : zhima
             * created_at : 2017-06-16T07:03:23.410Z
             * updated_at : 2017-06-16T07:14:38.569Z
             * userId : 93
             */

            private int id;
            private Object bankAccount;
            private Object payeeName;
            private Object bankOfDeposit;
            private Object openid;
            private Object wechatName;
            private Object alipayAccount;
            private String realName;
            private String idCardNO;
            private Object idCardImage1;
            private String idCardImage2;
            private String realNameStatus;
            private String verifyType;
            private String created_at;
            private String updated_at;
            private int userId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getBankAccount() {
                return bankAccount;
            }

            public void setBankAccount(Object bankAccount) {
                this.bankAccount = bankAccount;
            }

            public Object getPayeeName() {
                return payeeName;
            }

            public void setPayeeName(Object payeeName) {
                this.payeeName = payeeName;
            }

            public Object getBankOfDeposit() {
                return bankOfDeposit;
            }

            public void setBankOfDeposit(Object bankOfDeposit) {
                this.bankOfDeposit = bankOfDeposit;
            }

            public Object getOpenid() {
                return openid;
            }

            public void setOpenid(Object openid) {
                this.openid = openid;
            }

            public Object getWechatName() {
                return wechatName;
            }

            public void setWechatName(Object wechatName) {
                this.wechatName = wechatName;
            }

            public Object getAlipayAccount() {
                return alipayAccount;
            }

            public void setAlipayAccount(Object alipayAccount) {
                this.alipayAccount = alipayAccount;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getIdCardNO() {
                return idCardNO;
            }

            public void setIdCardNO(String idCardNO) {
                this.idCardNO = idCardNO;
            }

            public Object getIdCardImage1() {
                return idCardImage1;
            }

            public void setIdCardImage1(Object idCardImage1) {
                this.idCardImage1 = idCardImage1;
            }

            public String getIdCardImage2() {
                return idCardImage2;
            }

            public void setIdCardImage2(String idCardImage2) {
                this.idCardImage2 = idCardImage2;
            }

            public String getRealNameStatus() {
                return realNameStatus;
            }

            public void setRealNameStatus(String realNameStatus) {
                this.realNameStatus = realNameStatus;
            }

            public String getVerifyType() {
                return verifyType;
            }

            public void setVerifyType(String verifyType) {
                this.verifyType = verifyType;
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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }

    public static class ProfileBeanX {
        /**
         * id : 68
         * companyName : null
         * businessAddress : null
         * businessPhone : null
         * shippingAddress : null
         * bankAccount : null
         * bankOfDeposit : null
         * wechatSubscriptionId : null
         * wechatSubscriptionKeyt : null
         * legalPerson : null
         * legalPersonNO : null
         * legalPersonLicenceImage1 : null
         * legalPersonLicenceImage2 : null
         * licenseNO : null
         * licenseImage : null
         * taxLicenseImage : null
         * realNameStatus : pending
         * realShopStatus : notApply
         * created_at : 2017-06-16T07:03:23.372Z
         * updated_at : 2017-06-16T07:14:38.605Z
         * shopId : 78
         */

        private int id;
        private Object companyName;
        private Object businessAddress;
        private Object businessPhone;
        private Object shippingAddress;
        private Object bankAccount;
        private Object bankOfDeposit;
        private Object wechatSubscriptionId;
        private Object wechatSubscriptionKeyt;
        private Object legalPerson;
        private Object legalPersonNO;
        private Object legalPersonLicenceImage1;
        private Object legalPersonLicenceImage2;
        private Object licenseNO;
        private Object licenseImage;
        private Object taxLicenseImage;
        private String realNameStatus;
        private String realShopStatus;
        private String created_at;
        private String updated_at;
        private int shopId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getCompanyName() {
            return companyName;
        }

        public void setCompanyName(Object companyName) {
            this.companyName = companyName;
        }

        public Object getBusinessAddress() {
            return businessAddress;
        }

        public void setBusinessAddress(Object businessAddress) {
            this.businessAddress = businessAddress;
        }

        public Object getBusinessPhone() {
            return businessPhone;
        }

        public void setBusinessPhone(Object businessPhone) {
            this.businessPhone = businessPhone;
        }

        public Object getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(Object shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Object getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(Object bankAccount) {
            this.bankAccount = bankAccount;
        }

        public Object getBankOfDeposit() {
            return bankOfDeposit;
        }

        public void setBankOfDeposit(Object bankOfDeposit) {
            this.bankOfDeposit = bankOfDeposit;
        }

        public Object getWechatSubscriptionId() {
            return wechatSubscriptionId;
        }

        public void setWechatSubscriptionId(Object wechatSubscriptionId) {
            this.wechatSubscriptionId = wechatSubscriptionId;
        }

        public Object getWechatSubscriptionKeyt() {
            return wechatSubscriptionKeyt;
        }

        public void setWechatSubscriptionKeyt(Object wechatSubscriptionKeyt) {
            this.wechatSubscriptionKeyt = wechatSubscriptionKeyt;
        }

        public Object getLegalPerson() {
            return legalPerson;
        }

        public void setLegalPerson(Object legalPerson) {
            this.legalPerson = legalPerson;
        }

        public Object getLegalPersonNO() {
            return legalPersonNO;
        }

        public void setLegalPersonNO(Object legalPersonNO) {
            this.legalPersonNO = legalPersonNO;
        }

        public Object getLegalPersonLicenceImage1() {
            return legalPersonLicenceImage1;
        }

        public void setLegalPersonLicenceImage1(Object legalPersonLicenceImage1) {
            this.legalPersonLicenceImage1 = legalPersonLicenceImage1;
        }

        public Object getLegalPersonLicenceImage2() {
            return legalPersonLicenceImage2;
        }

        public void setLegalPersonLicenceImage2(Object legalPersonLicenceImage2) {
            this.legalPersonLicenceImage2 = legalPersonLicenceImage2;
        }

        public Object getLicenseNO() {
            return licenseNO;
        }

        public void setLicenseNO(Object licenseNO) {
            this.licenseNO = licenseNO;
        }

        public Object getLicenseImage() {
            return licenseImage;
        }

        public void setLicenseImage(Object licenseImage) {
            this.licenseImage = licenseImage;
        }

        public Object getTaxLicenseImage() {
            return taxLicenseImage;
        }

        public void setTaxLicenseImage(Object taxLicenseImage) {
            this.taxLicenseImage = taxLicenseImage;
        }

        public String getRealNameStatus() {
            return realNameStatus;
        }

        public void setRealNameStatus(String realNameStatus) {
            this.realNameStatus = realNameStatus;
        }

        public String getRealShopStatus() {
            return realShopStatus;
        }

        public void setRealShopStatus(String realShopStatus) {
            this.realShopStatus = realShopStatus;
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
    }

    public static class StaffsBean {
        /**
         * id : 93
         * userNO : 149759645281293
         * name : null
         * openid : null
         * avatar : null
         * gender : null
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
         * passwordDigest : $2a$10$apjBAaKPU0M56nFjFtLVBeWSWTvO.6i4KV3fo9PN5IjBfRLO9AbI2
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
         * created_at : 2017-06-16T07:00:52.676Z
         * updated_at : 2017-06-16T08:24:42.666Z
         * watchingLiveId : null
         * shopStaffs : {"description":null}
         */

        private int id;
        private String userNO;
        private Object name;
        private Object openid;
        private Object avatar;
        private Object gender;
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
        private String passwordDigest;
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
        private ShopStaffsBean shopStaffs;

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

        public String getPasswordDigest() {
            return passwordDigest;
        }

        public void setPasswordDigest(String passwordDigest) {
            this.passwordDigest = passwordDigest;
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

        public ShopStaffsBean getShopStaffs() {
            return shopStaffs;
        }

        public void setShopStaffs(ShopStaffsBean shopStaffs) {
            this.shopStaffs = shopStaffs;
        }

        public static class ShopStaffsBean {
            /**
             * description : null
             */

            private Object description;

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }
        }
    }
}