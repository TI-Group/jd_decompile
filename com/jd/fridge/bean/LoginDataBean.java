package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class LoginDataBean implements Serializable {
    private static final long serialVersionUID = -8046579887192364468L;
    private AdInfoDataBean adinfo;
    private boolean login;
    private String token = "";
    private UserInfoDataBean user_info;
    private VersionInfoDataBean versioninfo;

    public VersionInfoDataBean getVersioninfo() {
        return this.versioninfo;
    }

    public void setVersioninfo(VersionInfoDataBean versionInfoDataBean) {
        this.versioninfo = versionInfoDataBean;
    }

    public AdInfoDataBean getAdinfo() {
        return this.adinfo;
    }

    public void setAdinfo(AdInfoDataBean adInfoDataBean) {
        this.adinfo = adInfoDataBean;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public boolean isLogin() {
        return this.login;
    }

    public void setLogin(boolean z) {
        this.login = z;
    }

    public UserInfoDataBean getUser_info() {
        return this.user_info;
    }

    public void setUser_info(UserInfoDataBean userInfoDataBean) {
        this.user_info = userInfoDataBean;
    }
}
