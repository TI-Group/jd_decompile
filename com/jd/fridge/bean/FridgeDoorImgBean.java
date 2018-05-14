package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FridgeDoorImgBean implements Serializable {
    private static final long serialVersionUID = 8294926613180446225L;
    private int pic_pixel_h;
    private int pic_pixel_w;
    private String pic_url;
    private int position_type;
    private long timestamp;

    public int getPosition_type() {
        return this.position_type;
    }

    public void setPosition_type(int i) {
        this.position_type = i;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public void setPic_url(String str) {
        this.pic_url = str;
    }

    public int getPic_pixel_w() {
        return this.pic_pixel_w;
    }

    public void setPic_pixel_w(int i) {
        this.pic_pixel_w = i;
    }

    public int getPic_pixel_h() {
        return this.pic_pixel_h;
    }

    public void setPic_pixel_h(int i) {
        this.pic_pixel_h = i;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
