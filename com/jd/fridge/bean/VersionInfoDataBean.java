package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class VersionInfoDataBean implements Serializable {
    private static final long serialVersionUID = 676341798737995707L;
    private boolean force;
    private boolean needupdate;
    private String url = "";
    private String version = "";

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public boolean isNeedupdate() {
        return this.needupdate;
    }

    public void setNeedupdate(boolean z) {
        this.needupdate = z;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isForce() {
        return this.force;
    }

    public void setForce(boolean z) {
        this.force = z;
    }
}
