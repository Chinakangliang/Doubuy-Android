package com.tv.doubuy.model.responseModel;

import java.util.List;

/**
 * Created by apple on 2017/6/12.
 */

public class UserShopModel {


    /**
     * id : 76
     * shopNO : 149723485889876
     * name : 豆佰直播
     * description : null
     * cover : null
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
     * updated_at : 2017-06-12T02:34:18.899Z
     * areaId : null
     * ownerId : 91
     * liveRooms : [{"createdAt":"2017-06-12T02:34:18.951Z","id":66,"liveRoomNO":"149723485896366","title":"豆佰直播 的直播间","cover":"http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy_common/room_bg_default.png","description":"你可以在这里修改直播间的描述信息","isLiving":null,"avaliable":true,"pushStreamUrl":null,"rtmpPlayUrl":null,"hlsPlayUrl":null,"chatRoom":null,"created_at":"2017-06-12T02:34:18.951Z","updated_at":"2017-06-12T02:34:18.964Z","shopId":76,"mainProductId":null,"activeLiveRecordId":null}]
     * profile : {"id":66,"companyName":null,"businessAddress":null,"businessPhone":null,"shippingAddress":null,"bankAccount":null,"bankOfDeposit":null,"wechatSubscriptionId":null,"wechatSubscriptionKeyt":null,"legalPerson":null,"legalPersonNO":null,"legalPersonLicenceImage1":null,"legalPersonLicenceImage2":null,"licenseNO":null,"licenseImage":null,"taxLicenseImage":null,"realNameStatus":"notApply","realShopStatus":"notApply","created_at":"2017-06-12T02:34:18.933Z","updated_at":"2017-06-12T02:34:18.933Z","shopId":76}
     */

    private int id;
    private String shopNO;
    private String name;
    private Object description;
    private Object cover;
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
    private ProfileBean profile;
    private List<LiveRoomsBean> liveRooms;

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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getCover() {
        return cover;
    }

    public void setCover(Object cover) {
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

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<LiveRoomsBean> getLiveRooms() {
        return liveRooms;
    }

    public void setLiveRooms(List<LiveRoomsBean> liveRooms) {
        this.liveRooms = liveRooms;
    }

    public static class ProfileBean {
        /**
         * id : 66
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
         * realNameStatus : notApply
         * realShopStatus : notApply
         * created_at : 2017-06-12T02:34:18.933Z
         * updated_at : 2017-06-12T02:34:18.933Z
         * shopId : 76
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

    public static class LiveRoomsBean {
        /**
         * createdAt : 2017-06-12T02:34:18.951Z
         * id : 66
         * liveRoomNO : 149723485896366
         * title : 豆佰直播 的直播间
         * cover : http://soundlife-app.oss-cn-hangzhou.aliyuncs.com/doubuy_common/room_bg_default.png
         * description : 你可以在这里修改直播间的描述信息
         * isLiving : null
         * avaliable : true
         * pushStreamUrl : null
         * rtmpPlayUrl : null
         * hlsPlayUrl : null
         * chatRoom : null
         * created_at : 2017-06-12T02:34:18.951Z
         * updated_at : 2017-06-12T02:34:18.964Z
         * shopId : 76
         * mainProductId : null
         * activeLiveRecordId : null
         */

        private String createdAt;
        private int id;
        private String liveRoomNO;
        private String title;
        private String cover;
        private String description;
        private Object isLiving;
        private boolean avaliable;
        private Object pushStreamUrl;
        private Object rtmpPlayUrl;
        private Object hlsPlayUrl;
        private Object chatRoom;
        private String created_at;
        private String updated_at;
        private int shopId;
        private Object mainProductId;
        private Object activeLiveRecordId;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLiveRoomNO() {
            return liveRoomNO;
        }

        public void setLiveRoomNO(String liveRoomNO) {
            this.liveRoomNO = liveRoomNO;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getIsLiving() {
            return isLiving;
        }

        public void setIsLiving(Object isLiving) {
            this.isLiving = isLiving;
        }

        public boolean isAvaliable() {
            return avaliable;
        }

        public void setAvaliable(boolean avaliable) {
            this.avaliable = avaliable;
        }

        public Object getPushStreamUrl() {
            return pushStreamUrl;
        }

        public void setPushStreamUrl(Object pushStreamUrl) {
            this.pushStreamUrl = pushStreamUrl;
        }

        public Object getRtmpPlayUrl() {
            return rtmpPlayUrl;
        }

        public void setRtmpPlayUrl(Object rtmpPlayUrl) {
            this.rtmpPlayUrl = rtmpPlayUrl;
        }

        public Object getHlsPlayUrl() {
            return hlsPlayUrl;
        }

        public void setHlsPlayUrl(Object hlsPlayUrl) {
            this.hlsPlayUrl = hlsPlayUrl;
        }

        public Object getChatRoom() {
            return chatRoom;
        }

        public void setChatRoom(Object chatRoom) {
            this.chatRoom = chatRoom;
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

        public Object getMainProductId() {
            return mainProductId;
        }

        public void setMainProductId(Object mainProductId) {
            this.mainProductId = mainProductId;
        }

        public Object getActiveLiveRecordId() {
            return activeLiveRecordId;
        }

        public void setActiveLiveRecordId(Object activeLiveRecordId) {
            this.activeLiveRecordId = activeLiveRecordId;
        }
    }
}
