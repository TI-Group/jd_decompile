package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class CurrentGoodsListByUser {
    private long feed_id;
    private String pin;

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public long getFeed_id() {
        return this.feed_id;
    }

    public String getPin() {
        return this.pin;
    }
}
