package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FridgeControlStreamBean implements Serializable {
    private static final long serialVersionUID = -2512009820986015425L;
    private String at;
    private String current_value;
    private String master_flag;
    private String stream_id;
    private String stream_name;
    private String stream_type;
    private String units;
    private String value_des;

    public FridgeControlStreamBean(String str, String str2) {
        this.current_value = str2;
        this.stream_id = str;
    }

    public String getAt() {
        return this.at;
    }

    public void setAt(String str) {
        this.at = str;
    }

    public String getCurrent_value() {
        return this.current_value;
    }

    public void setCurrent_value(String str) {
        this.current_value = str;
    }

    public String getMaster_flag() {
        return this.master_flag;
    }

    public void setMaster_flag(String str) {
        this.master_flag = str;
    }

    public String getStream_id() {
        return this.stream_id;
    }

    public void setStream_id(String str) {
        this.stream_id = str;
    }

    public String getStream_name() {
        return this.stream_name;
    }

    public void setStream_name(String str) {
        this.stream_name = str;
    }

    public String getStream_type() {
        return this.stream_type;
    }

    public void setStream_type(String str) {
        this.stream_type = str;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String str) {
        this.units = str;
    }

    public String getValue_des() {
        return this.value_des;
    }

    public void setValue_des(String str) {
        this.value_des = str;
    }
}
