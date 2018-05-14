package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class LoginServerDataBean implements Serializable {
    private static final long serialVersionUID = -337991384910000800L;
    private String accessToken = "";
    private int action;
    private boolean bindStatus = false;
    private boolean isSkipBind = false;
    private boolean login;
    private String openid = "";
    private String uid = "";

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public boolean isLogin() {
        return this.login;
    }

    public void setLogin(boolean z) {
        this.login = z;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public boolean isBindStatus() {
        return this.bindStatus;
    }

    public void setBindStatus(boolean z) {
        this.bindStatus = z;
    }

    public boolean isSkipBind() {
        return this.isSkipBind;
    }

    public void setSkipBind(boolean z) {
        this.isSkipBind = z;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }
}
