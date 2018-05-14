package com.jd.fridge.bean.requestBody;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class RegisterAudienceByUser implements Serializable {
    private static final long serialVersionUID = 1298546541471077199L;
    private String audience_id;
    private String audience_ip;
    private String device_uuid;
    private long feed_id;
    private String os;
    private String platform;

    public long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getDevice_uuid() {
        return this.device_uuid;
    }

    public void setDevice_uuid(String str) {
        this.device_uuid = str;
    }

    public String getAudience_id() {
        return this.audience_id;
    }

    public void setAudience_id(String str) {
        this.audience_id = str;
    }

    public String getAudience_ip() {
        return this.audience_ip;
    }

    public void setAudience_ip(String str) {
        this.audience_ip = str;
    }
}
