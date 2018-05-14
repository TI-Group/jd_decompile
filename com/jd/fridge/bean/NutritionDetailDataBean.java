package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NutritionDetailDataBean implements Serializable {
    private static final long serialVersionUID = -3501526390584427379L;
    private List<NutritionFoodDataBean> result = new ArrayList();
    private int total;

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public List<NutritionFoodDataBean> getResult() {
        return this.result;
    }

    public void setResult(List<NutritionFoodDataBean> list) {
        this.result = list;
    }
}
