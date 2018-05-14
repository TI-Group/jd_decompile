package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class NutritionFoodDataBean implements Serializable {
    private static final long serialVersionUID = -4994664281331006932L;
    private int defaultRes;
    private float df;
    private float fat;
    private int goods_id;
    private String goods_name;
    private float heat;
    private int high_calorie;
    private int high_glucose;
    private String icon_url;
    private String img_url;
    private boolean isDefault;
    private float protein;

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int i) {
        this.goods_id = i;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String str) {
        this.goods_name = str;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }

    public int getHigh_calorie() {
        return this.high_calorie;
    }

    public void setHigh_calorie(int i) {
        this.high_calorie = i;
    }

    public int getHigh_glucose() {
        return this.high_glucose;
    }

    public void setHigh_glucose(int i) {
        this.high_glucose = i;
    }

    public float getHeat() {
        return this.heat;
    }

    public void setHeat(float f) {
        this.heat = f;
    }

    public float getProtein() {
        return this.protein;
    }

    public void setProtein(float f) {
        this.protein = f;
    }

    public float getFat() {
        return this.fat;
    }

    public void setFat(float f) {
        this.fat = f;
    }

    public float getDf() {
        return this.df;
    }

    public void setDf(float f) {
        this.df = f;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public int getDefaultRes() {
        return this.defaultRes;
    }

    public void setDefaultRes(int i) {
        this.defaultRes = i;
    }
}
