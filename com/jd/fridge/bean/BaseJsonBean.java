package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class BaseJsonBean implements Serializable {
    private static final long serialVersionUID = -1702907262739062893L;
    private ErrorBean error;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public ErrorBean getError() {
        return this.error;
    }
}
