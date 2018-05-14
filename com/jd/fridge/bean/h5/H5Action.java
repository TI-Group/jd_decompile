package com.jd.fridge.bean.h5;

/* compiled from: TbsSdkJava */
public class H5Action {
    private String action;
    private String protocol;
    private String url;

    public H5Action(String str, String str2, String str3) {
        this.protocol = str;
        this.action = str2;
        this.url = str3;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getAction() {
        return this.action;
    }

    public String getUrl() {
        return this.url;
    }
}
