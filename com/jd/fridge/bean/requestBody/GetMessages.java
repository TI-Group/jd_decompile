package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class GetMessages {
    private int count;
    private long feed_id;
    private String pin;
    private int start_index;

    public GetMessages(String str, long j, int i, int i2) {
        this.pin = str;
        this.feed_id = j;
        this.start_index = i;
        this.count = i2;
    }
}
