package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class SearchGoodsListBean extends BaseJsonBean {
    private int category_id;
    private int goods_id;
    private String goods_name;

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

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int i) {
        this.category_id = i;
    }
}
