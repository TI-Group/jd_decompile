package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class PicHistory {
    private int count;
    private long feed_id;
    private long start_time;

    public PicHistory(long j, long j2, int i) {
        this.feed_id = j;
        this.start_time = j2;
        this.count = i;
    }
}
