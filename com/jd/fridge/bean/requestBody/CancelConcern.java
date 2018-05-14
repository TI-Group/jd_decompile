package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class CancelConcern {
    private long feed_id;
    private String friends;
    private String owner;

    public CancelConcern(String str, String str2, long j) {
        this.friends = str;
        this.owner = str2;
        this.feed_id = j;
    }
}
