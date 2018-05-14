package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class NotMoveByRecognitionBody implements Serializable {
    private long feed_id;
    private String pin;
    private String recognition_date;

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

    public String getRecognition_date() {
        return this.recognition_date;
    }

    public void setRecognition_date(String str) {
        this.recognition_date = str;
    }
}
