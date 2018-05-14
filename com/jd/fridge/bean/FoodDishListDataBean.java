package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FoodDishListDataBean implements Serializable {
    private int add_source;
    private FoodCategoryListDataBean categoryBean;
    private int category_id;
    private int custom_flag;
    private String customized_name;
    private int default_expire;
    private String default_expire_condition;
    private int default_expire_unit;
    private int default_expired;
    private int easy_expire;
    private String expire_date;
    private String expired;
    private int goods_id;
    private String goods_name;
    private boolean has_alarm;
    private String icon_url;
    private String img_url;
    private int is_read;
    private String position;
    private int temp_category_id;
    private int zone;

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int i) {
        this.category_id = i;
    }

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

    public int getDefault_expired() {
        return this.default_expired;
    }

    public void setDefault_expired(int i) {
        this.default_expired = i;
    }

    public int getDefault_expire_unit() {
        return this.default_expire_unit;
    }

    public void setDefault_expire_unit(int i) {
        this.default_expire_unit = i;
    }

    public String getDefault_expire_condition() {
        return this.default_expire_condition;
    }

    public void setDefault_expire_condition(String str) {
        this.default_expire_condition = str;
    }

    public boolean isHas_alarm() {
        return this.has_alarm;
    }

    public void setHas_alarm(boolean z) {
        this.has_alarm = z;
    }

    public String getExpired() {
        return this.expired;
    }

    public void setExpired(String str) {
        this.expired = str;
    }

    public int getCustom_flag() {
        return this.custom_flag;
    }

    public void setCustom_flag(int i) {
        this.custom_flag = i;
    }

    public int getEasy_expire() {
        return this.easy_expire;
    }

    public void setEasy_expire(int i) {
        this.easy_expire = i;
    }

    public FoodCategoryListDataBean getCategoryBean() {
        return this.categoryBean;
    }

    public void setCategoryBean(FoodCategoryListDataBean foodCategoryListDataBean) {
        this.categoryBean = foodCategoryListDataBean;
    }

    public int getTemp_category_id() {
        return this.temp_category_id;
    }

    public void setTemp_category_id(int i) {
        this.temp_category_id = i;
    }

    public int getDefault_expire() {
        return this.default_expire;
    }

    public void setDefault_expire(int i) {
        this.default_expire = i;
    }

    public String getExpire_date() {
        return this.expire_date;
    }

    public void setExpire_date(String str) {
        this.expire_date = str;
    }

    public String getCustomized_name() {
        return this.customized_name;
    }

    public void setCustomized_name(String str) {
        this.customized_name = str;
    }

    public int getIs_read() {
        return this.is_read;
    }

    public void setIs_read(int i) {
        this.is_read = i;
    }

    public int getAdd_source() {
        return this.add_source;
    }

    public void setAdd_source(int i) {
        this.add_source = i;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public int getZone() {
        return this.zone;
    }

    public void setZone(int i) {
        this.zone = i;
    }
}
