package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class ResetGoodsAlarm {
    private long alarm_id;
    private int expire;
    private int expire_unit;
    private long feed_id;
    private String foods_name;
    private String pin;

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public long getAlarm_id() {
        return this.alarm_id;
    }

    public void setAlarm_id(long j) {
        this.alarm_id = j;
    }

    public int getExpire() {
        return this.expire;
    }

    public void setExpire(int i) {
        this.expire = i;
    }

    public int getExpire_unit() {
        return this.expire_unit;
    }

    public void setExpire_unit(int i) {
        this.expire_unit = i;
    }

    public String getFoods_name() {
        return this.foods_name;
    }

    public void setFoods_name(String str) {
        this.foods_name = str;
    }
}
