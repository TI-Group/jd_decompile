package com.jd.fridge.bean.requestBody;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class CancelRegisterAudienceByUser implements Serializable {
    private static final long serialVersionUID = 1298546541471077199L;
    private String audience_id;
    private long feed_id;
    private String pin;

    public CancelRegisterAudienceByUser(String str, long j, String str2) {
        this.pin = str;
        this.feed_id = j;
        this.audience_id = str2;
    }

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

    public String getAudience_id() {
        return this.audience_id;
    }

    public void setAudience_id(String str) {
        this.audience_id = str;
    }
}
