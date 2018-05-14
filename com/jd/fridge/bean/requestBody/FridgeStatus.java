package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class FridgeStatus {
    private String digest = "";
    private long feed_id;

    public FridgeStatus(long j, String str) {
        this.feed_id = j;
        this.digest = str;
    }
}
