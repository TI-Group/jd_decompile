package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class ShareDataBean implements Serializable {
    private static final long serialVersionUID = -2338496922095890517L;
    private String imgurl = "";
    private String sharecontent = "";
    private String sharetitle = "";
    private int type;
    private String url = "";

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getShareUrl() {
        return this.url;
    }

    public void setShareUrl(String str) {
        this.url = str;
    }

    public String getSharePicUrl() {
        return this.imgurl;
    }

    public void setSharePicUrl(String str) {
        this.imgurl = str;
    }

    public String getShareText() {
        return this.sharecontent;
    }

    public void setShareText(String str) {
        this.sharecontent = str;
    }

    public String getShareTitle() {
        return this.sharetitle;
    }

    public void setShareTitle(String str) {
        this.sharetitle = str;
    }
}
