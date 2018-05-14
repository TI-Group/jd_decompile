package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FriendInfo {
    private String avartar;
    private long feed_id;
    private String nickname;
    private String pin;

    public FriendInfo(String str, String str2, String str3, long j) {
        this.pin = str;
        this.nickname = str2;
        this.avartar = str3;
        this.feed_id = j;
    }

    public String getPin() {
        return this.pin;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getAvatarUrl() {
        return this.avartar;
    }

    public long getFeedId() {
        return this.feed_id;
    }
}
