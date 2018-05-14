package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class CreateMessage {
    private long feed_id;
    private String message;
    private String pin;

    public CreateMessage(String str, long j, String str2) {
        this.pin = str;
        this.feed_id = j;
        this.message = str2;
    }
}
