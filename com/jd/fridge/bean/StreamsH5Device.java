package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class StreamsH5Device implements Serializable {
    private String access_key;
    private String active_time;
    private String device_id;
    private String device_name;
    private String feed_id;
    private int main_sub_type;
    private String status;

    public String getActive_time() {
        return this.active_time;
    }

    public void setActive_time(String str) {
        this.active_time = str;
    }

    public String getDevice_name() {
        return this.device_name;
    }

    public void setDevice_name(String str) {
        this.device_name = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(String str) {
        this.device_id = str;
    }

    public String getAccess_key() {
        return this.access_key;
    }

    public void setAccess_key(String str) {
        this.access_key = str;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public int getMain_sub_type() {
        return this.main_sub_type;
    }

    public void setMain_sub_type(int i) {
        this.main_sub_type = i;
    }
}
