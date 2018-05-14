package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class WxPayDataBean implements Serializable {
    private static final long serialVersionUID = 2286907910654666758L;
    private String createtime = "";
    private String noncestr = "";
    private String prepay_id = "";

    public String getPrepay_id() {
        return this.prepay_id;
    }

    public void setPrepay_id(String str) {
        this.prepay_id = str;
    }

    public String getNoncestr() {
        return this.noncestr;
    }

    public void setNoncestr(String str) {
        this.noncestr = str;
    }

    public String getTimestamp() {
        return this.createtime;
    }

    public void setTimestamp(String str) {
        this.createtime = str;
    }
}
