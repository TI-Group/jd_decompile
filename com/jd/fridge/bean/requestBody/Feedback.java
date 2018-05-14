package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class Feedback {
    private String content;
    private long feed_id;

    public Feedback(long j, String str) {
        this.feed_id = j;
        this.content = str;
    }
}
