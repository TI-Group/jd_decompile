package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class AdInfoDataBean implements Serializable {
    private static final long serialVersionUID = 8294926613180446225L;
    private String adurl = "";
    private long overtime;
    private int showtime;

    public String getAdurl() {
        return this.adurl;
    }

    public void setAdurl(String str) {
        this.adurl = str;
    }

    public long getOvertime() {
        return this.overtime;
    }

    public void setOvertime(long j) {
        this.overtime = j;
    }

    public int getShowtime() {
        return this.showtime;
    }

    public void setShowtime(int i) {
        this.showtime = i;
    }
}
