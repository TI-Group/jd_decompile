package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class MenuByIdItemDataBean implements Serializable {
    private static final long serialVersionUID = 4232068184967185471L;
    private String can_buy;
    private String exist;
    private long food_id;
    private String name;
    private String unit;
    private String weight;

    public long getFood_id() {
        return this.food_id;
    }

    public void setFood_id(long j) {
        this.food_id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String getCan_buy() {
        return this.can_buy;
    }

    public void setCan_buy(String str) {
        this.can_buy = str;
    }

    public String getExist() {
        return this.exist;
    }

    public void setExist(String str) {
        this.exist = str;
    }
}
