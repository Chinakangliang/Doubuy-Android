package com.tv.doubuy.model.responseModel;

/**
 * Created by apple on 2017/6/14.
 */

public class ShopInfoSubmitModel {


    private int id;
    private Object bankAccount;
    private Object payeeName;
    private Object bankOfDeposit;
    private Object openid;
    private Object wechatName;
    private Object alipayAccount;
    private String realName;
    private String idCardNO;
    private String idCardImage1;
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

    public String getIdCardImage1() {
        return idCardImage1;
    }

    public void setIdCardImage1(String idCardImage1) {
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
