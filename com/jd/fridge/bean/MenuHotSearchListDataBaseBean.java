package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class MenuHotSearchListDataBaseBean implements Serializable {
    private int code;
    private String[] data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String[] getData() {
        return this.data;
    }

    public void setData(String[] strArr) {
        this.data = strArr;
    }
}
