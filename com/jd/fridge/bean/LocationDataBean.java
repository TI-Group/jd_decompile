package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class LocationDataBean implements Serializable {
    private static final long serialVersionUID = -1653449623080091325L;
    private int cid;
    private String cname = "";
    private int isprovince;
    private int pid;
    private String pname = "";

    public int getPid() {
        return this.pid;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public int getCid() {
        return this.cid;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public String getPname() {
        return this.pname;
    }

    public void setPname(String str) {
        this.pname = str;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String str) {
        this.cname = str;
    }

    public int getIsprovince() {
        return this.isprovince;
    }

    public void setIsprovince(int i) {
        this.isprovince = i;
    }
}
