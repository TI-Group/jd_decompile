package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FridgeInfoBean {
    private long bind_date;
    private String brand;
    private int bug_report;
    private int control_page;
    private String device_id;
    private String feed_id;
    private int front_camera;
    private boolean isSelected;
    private String model;
    private String product_uuid;
    private int rear_camera;
    private String sn;

    public long getBindDate() {
        return this.bind_date;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getDeviceId() {
        return this.device_id;
    }

    public String getSn() {
        return this.sn;
    }

    public String getFeedId() {
        return this.feed_id;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public int getRear_camera() {
        return this.rear_camera;
    }

    public void setRear_camera(int i) {
        this.rear_camera = i;
    }

    public int getFront_camera() {
        return this.front_camera;
    }

    public void setFront_camera(int i) {
        this.front_camera = i;
    }

    public String getProduct_uuid() {
        return this.product_uuid;
    }

    public void setProduct_uuid(String str) {
        this.product_uuid = str;
    }

    public void setControl_page(int i) {
        this.control_page = i;
    }

    public int getControl_page() {
        return this.control_page;
    }

    public void setBug_report(int i) {
        this.bug_report = i;
    }

    public int getBug_report() {
        return this.bug_report;
    }
}
