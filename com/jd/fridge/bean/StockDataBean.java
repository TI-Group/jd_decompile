package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class StockDataBean implements Serializable {
    private static final long serialVersionUID = -1531367643989934793L;
    private int category_id;
    private int curr_count;
    private int goods_id;
    private String goods_name = "";
    private String icon_url = "";
    private String img_url = "";
    private int out_of_stock;

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

    public int getCurr_count() {
        return this.curr_count;
    }

    public void setCurr_count(int i) {
        this.curr_count = i;
    }

    public int getOut_of_stock() {
        return this.out_of_stock;
    }

    public void setOut_of_stock(int i) {
        this.out_of_stock = i;
    }
}
