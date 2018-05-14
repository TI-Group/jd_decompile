package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class StreamsH5Streams implements Serializable {
    private String at;
    private String current_value;
    private String ptype;
    private String stream_id;
    private int stream_type;
    private int tag_id;
    private String units;
    private String value_des;

    public String getCurrent_value() {
        return this.current_value;
    }

    public void setCurrent_value(String str) {
        this.current_value = str;
    }

    public int getStream_type() {
        return this.stream_type;
    }

    public void setStream_type(int i) {
        this.stream_type = i;
    }

    public String getAt() {
        return this.at;
    }

    public void setAt(String str) {
        this.at = str;
    }

    public String getValue_des() {
        return this.value_des;
    }

    public void setValue_des(String str) {
        this.value_des = str;
    }

    public String getStream_id() {
        return this.stream_id;
    }

    public void setStream_id(String str) {
        this.stream_id = str;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String str) {
        this.units = str;
    }

    public String getPtype() {
        return this.ptype;
    }

    public void setPtype(String str) {
        this.ptype = str;
    }

    public int getTag_id() {
        return this.tag_id;
    }

    public void setTag_id(int i) {
        this.tag_id = i;
    }
}
