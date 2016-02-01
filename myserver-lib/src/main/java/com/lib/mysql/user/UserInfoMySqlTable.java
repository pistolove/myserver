package com.lib.mysql.user;

import java.io.Serializable;

public class UserInfoMySqlTable implements Serializable {

    private static final long serialVersionUID = 8994947731194398118L;

    private String username;

    private String password;

    private String userInfo;

    private Long telePhone;

    private String email;

    private String id;

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public Long getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(Long telePhone) {
        this.telePhone = telePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
    }

}
