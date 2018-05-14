package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class AddGoodsListBean extends BaseJsonBean {
    private int add_source;
    private String customized_name;
    private String expire_date;
    private long feed_id;
    private int goods_id;
    private String img_url;
    private int is_read;
    private String position;
    private int zone;

    public long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public int getZone() {
        return this.zone;
    }

    public void setZone(int i) {
        this.zone = i;
    }

    public int getAdd_source() {
        return this.add_source;
    }

    public void setAdd_source(int i) {
        this.add_source = i;
    }

    public int getIs_read() {
        return this.is_read;
    }

    public void setIs_read(int i) {
        this.is_read = i;
    }

    public String getExpire_date() {
        return this.expire_date;
    }

    public void setExpire_date(String str) {
        this.expire_date = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String str) {
        this.img_url = str;
    }

    public String getCustomized_name() {
        return this.customized_name;
    }

    public void setCustomized_name(String str) {
        this.customized_name = str;
    }

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int i) {
        this.goods_id = i;
    }
}
