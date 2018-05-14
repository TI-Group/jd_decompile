package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FridgeDevice implements Serializable {
    private static final long serialVersionUID = -8763026733283875921L;
    private String device_id;
    private String device_name;
    private String feed_id;
    private boolean isSelected;
    private String p_description;
    private String p_img_url;
    private String product_id;
    private String product_uuid;
    private String status;

    public String getDevice_id() {
        return this.device_id;
    }

    public void setDevice_id(String str) {
        this.device_id = str;
    }

    public String getDevice_name() {
        return this.device_name;
    }

    public void setDevice_name(String str) {
        this.device_name = str;
    }

    public String getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public String getP_description() {
        return this.p_description;
    }

    public void setP_description(String str) {
        this.p_description = str;
    }

    public String getP_img_url() {
        return this.p_img_url;
    }

    public void setP_img_url(String str) {
        this.p_img_url = str;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String str) {
        this.product_id = str;
    }

    public String getProduct_uuid() {
        return this.product_uuid;
    }

    public void setProduct_uuid(String str) {
        this.product_uuid = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
