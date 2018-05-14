package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class ErrorBean implements Serializable {
    private static final long serialVersionUID = 4691884164958836849L;
    private String debugInfo = "";
    private String debugMe = "";
    private int errorCode;
    private String errorInfo = "";

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    public String getDebugInfo() {
        return this.debugInfo;
    }

    public void setDebugInfo(String str) {
        this.debugInfo = str;
    }

    public String getDebugMe() {
        return this.debugMe;
    }

    public void setDebugMe(String str) {
        this.debugMe = str;
    }
}
