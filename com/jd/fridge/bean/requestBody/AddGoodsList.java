package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class AddGoodsList {
    private String alarms;
    private long feed_id;
    private String pin;

    public AddGoodsList(String str, long j, String str2) {
        this.pin = str;
        this.feed_id = j;
        this.alarms = str2;
    }
}
