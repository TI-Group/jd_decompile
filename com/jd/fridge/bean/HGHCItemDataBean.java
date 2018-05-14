package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class HGHCItemDataBean implements Serializable {
    private static final long serialVersionUID = 6101658807318363299L;
    private String date = "";
    private List<NutritionFoodDataBean> goods;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public List<NutritionFoodDataBean> getGoods() {
        return this.goods;
    }

    public void setGoods(List<NutritionFoodDataBean> list) {
        this.goods = list;
    }
}
