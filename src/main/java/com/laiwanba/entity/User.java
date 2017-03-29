package com.laiwanba.entity;

import java.util.Date;

/**
 * Created by chunmiao on 17-3-5.
 */
public class User {
    //用户id
    long userId;
    //用户名
    String userName;
    //密码
    String password;
    //用户手机号
    Long userPhone;
    //用户邮箱
    String userEmail;
    //最近一次登录时间
    Date loginInTime;
    //最近一次登出时间
    Date loginOutTime;
    //用户创建时间
    Date createTime;
    //用户性别
    String userSex;
    //用户年龄
    int userAge;
    //用户头像图片url
    String userPicUrl;

    int status;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getLoginInTime() {
        return loginInTime;
    }

    public void setLoginInTime(Date loginInTime) {
        this.loginInTime = loginInTime;
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userPhone=" + userPhone +
                ", userEmail='" + userEmail + '\'' +
                ", loginInTime=" + loginInTime +
                ", loginOutTime=" + loginOutTime +
                ", createTime=" + createTime +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userPicUrl='" + userPicUrl + '\'' +
                '}';
    }
}
