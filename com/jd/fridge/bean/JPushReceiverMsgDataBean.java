package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class JPushReceiverMsgDataBean implements Serializable {
    private static final long serialVersionUID = -445279367951182646L;
    private String code = "";
    private FoodBean data;
    private long time;
    private String version = "";

    /* compiled from: TbsSdkJava */
    public class FoodBean implements Serializable {
        private static final long serialVersionUID = 6871255633430788406L;
        private int day_count;
        private String expired_date = "";
        private int goods_id;
        private String goods_name = "";
        private String img_url = "";
        private String orderFieldNextType = "";
        private String pic_url;
        private String recognition_date;

        public int getGoods_id() {
            return this.goods_id;
        }

        public void setGoods_id(int i) {
            this.goods_id = i;
        }

        public String getImg_url() {
            return this.img_url;
        }

        public void setImg_url(String str) {
            this.img_url = str;
        }

        public String getGoods_name() {
            return this.goods_name;
        }

        public void setGoods_name(String str) {
            this.goods_name = str;
        }

        public String getExpired_date() {
            return this.expired_date;
        }

        public void setExpired_date(String str) {
            this.expired_date = str;
        }

        public String getOrderFieldNextType() {
            return this.orderFieldNextType;
        }

        public void setOrderFieldNextType(String str) {
            this.orderFieldNextType = str;
        }

        public String getPic_url() {
            return this.pic_url;
        }

        public void setPic_url(String str) {
            this.pic_url = str;
        }

        public int getDay_count() {
            return this.day_count;
        }

        public void setDay_count(int i) {
            this.day_count = i;
        }

        public String getRecognition_date() {
            return this.recognition_date;
        }

        public void setRecognition_date(String str) {
            this.recognition_date = str;
        }
    }

    public FoodBean getData() {
        return this.data;
    }

    public void setData(FoodBean foodBean) {
        this.data = foodBean;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
