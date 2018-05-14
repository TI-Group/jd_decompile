package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class UpdateDataBean implements Serializable {
    private static final long serialVersionUID = -2665400157723595615L;
    private String desc;
    private int has_new;
    private int is_forced_upgrade;
    private String md5;
    private String url;
    private String version;

    public int getHas_new() {
        return this.has_new;
    }

    public void setHas_new(int i) {
        this.has_new = i;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public int getIs_forced_upgrade() {
        return this.is_forced_upgrade;
    }

    public void setIs_forced_upgrade(int i) {
        this.is_forced_upgrade = i;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }
}
