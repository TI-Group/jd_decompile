package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class SharedInfoDataBean implements Serializable {
    private static final long serialVersionUID = 3450362323276412411L;
    private String redirect_url = "";
    private String share_word = "";
    private String sharepic_url = "";
    private String title = "";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getShare_word() {
        return this.share_word;
    }

    public void setShare_word(String str) {
        this.share_word = str;
    }

    public String getSharepic_url() {
        return this.sharepic_url;
    }

    public void setSharepic_url(String str) {
        this.sharepic_url = str;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setRedirect_url(String str) {
        this.redirect_url = str;
    }
}
