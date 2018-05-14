package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FoodsAlarmBaseBean extends BaseJsonBean {
    private String alarm_date;
    private long alarm_id;
    private int category_id;
    private int goods_id;
    private String goods_name;
    private String img_url;

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int i) {
        this.goods_id = i;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(int i) {
        this.category_id = i;
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

    public long getAlarm_id() {
        return this.alarm_id;
    }

    public void setAlarm_id(long j) {
        this.alarm_id = j;
    }

    public String getAlarm_date() {
        return this.alarm_date;
    }

    public void setAlarm_date(String str) {
        this.alarm_date = str;
    }

    public String toString() {
        return "goods_id:" + this.goods_id + " category_id:" + this.category_id + " goods_name:" + this.goods_name + " img_url:" + this.img_url + " alarm_id:" + this.alarm_id + " alarm_date:" + this.alarm_date;
    }
}
