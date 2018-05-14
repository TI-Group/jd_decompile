package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FoodNoticeStatusDataBean implements Serializable {
    private static final long serialVersionUID = 9110114634910286341L;
    private boolean isDeleted;
    private boolean isReaded;

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public boolean isReaded() {
        return this.isReaded;
    }

    public void setReaded(boolean z) {
        this.isReaded = z;
    }
}
