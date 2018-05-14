package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class LoginErrBean implements Serializable {
    private static final long serialVersionUID = 5290242545640048027L;
    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }
}
