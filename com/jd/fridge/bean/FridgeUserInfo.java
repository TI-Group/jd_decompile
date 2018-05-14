package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FridgeUserInfo {
    private String email;
    private String level;
    private String nickname;
    private String phone_number;
    private String photo_url;
    private String sex;

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public String getLevel() {
        return this.level;
    }

    public String getSex() {
        return this.sex;
    }

    public String getPhotoUrl() {
        return this.photo_url;
    }

    public void setPhotoUrl(String str) {
        this.photo_url = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getEmail() {
        return this.email;
    }
}
