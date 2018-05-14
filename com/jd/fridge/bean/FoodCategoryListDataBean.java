package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FoodCategoryListDataBean implements Serializable {
    private int category_id;
    private String category_name;
    private int count;
    private String image;

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int i) {
        this.category_id = i;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public void setCategory_name(String str) {
        this.category_name = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }
}
