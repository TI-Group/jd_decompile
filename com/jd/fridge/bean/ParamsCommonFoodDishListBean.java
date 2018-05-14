package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class ParamsCommonFoodDishListBean implements Serializable {
    private long feed_id;
    private String pin;

    public ParamsCommonFoodDishListBean(long j, String str) {
        this.feed_id = j;
        this.pin = str;
    }
}
