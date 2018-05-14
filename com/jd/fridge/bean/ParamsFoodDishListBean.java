package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class ParamsFoodDishListBean implements Serializable {
    private int category_id;
    private long feed_id;
    private String pin;
    private int zone;

    public ParamsFoodDishListBean(int i, int i2, long j, String str) {
        this.zone = i;
        this.category_id = i2;
        this.feed_id = j;
        this.pin = str;
    }
}
