package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class StreamsH5SharedInfo implements Serializable {
    private String isShared;
    private String shared_count;

    public String getShared_count() {
        return this.shared_count;
    }

    public void setShared_count(String str) {
        this.shared_count = str;
    }

    public String getIsShared() {
        return this.isShared;
    }

    public void setIsShared(String str) {
        this.isShared = str;
    }
}
