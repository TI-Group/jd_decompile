package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NutritionDistributionDataBean implements Serializable {
    private static final long serialVersionUID = 3894995932139704646L;
    private List<NutritionFoodDataBean> fruits;
    private List<NutritionFoodDataBean> grains;
    private List<NutritionFoodDataBean> proteins;
    private String type = "";
    private List<NutritionFoodDataBean> vegetables;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public List<NutritionFoodDataBean> getFruits() {
        return this.fruits;
    }

    public void setFruits(List<NutritionFoodDataBean> list) {
        this.fruits = list;
    }

    public List<NutritionFoodDataBean> getGrains() {
        return this.grains;
    }

    public void setGrains(List<NutritionFoodDataBean> list) {
        this.grains = list;
    }

    public List<NutritionFoodDataBean> getVegetables() {
        return this.vegetables;
    }

    public void setVegetables(List<NutritionFoodDataBean> list) {
        this.vegetables = list;
    }

    public List<NutritionFoodDataBean> getProteins() {
        return this.proteins;
    }

    public void setProteins(List<NutritionFoodDataBean> list) {
        this.proteins = list;
    }
}
