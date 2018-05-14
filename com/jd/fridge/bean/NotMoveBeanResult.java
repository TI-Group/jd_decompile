package com.jd.fridge.bean;

import java.util.List;

/* compiled from: TbsSdkJava */
public class NotMoveBeanResult extends BaseJsonBean {
    private long feed_id;
    private List<NotMoveGoodsBean> goods;
    private int pic_pixel_h;
    private int pic_pixel_w;
    private String pic_url;
    private int position_type;
    private String recognition_date;

    public long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public String getRecognition_date() {
        return this.recognition_date;
    }

    public void setRecognition_date(String str) {
        this.recognition_date = str;
    }

    public int getPosition_type() {
        return this.position_type;
    }

    public void setPosition_type(int i) {
        this.position_type = i;
    }

    public String getPic_url() {
        return this.pic_url;
    }

    public void setPic_url(String str) {
        this.pic_url = str;
    }

    public int getPic_pixel_w() {
        return this.pic_pixel_w;
    }

    public void setPic_pixel_w(int i) {
        this.pic_pixel_w = i;
    }

    public int getPic_pixel_h() {
        return this.pic_pixel_h;
    }

    public void setPic_pixel_h(int i) {
        this.pic_pixel_h = i;
    }

    public List<NotMoveGoodsBean> getGoods() {
        return this.goods;
    }

    public void setGoods(List<NotMoveGoodsBean> list) {
        this.goods = list;
    }
}
