package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class ControlCommand {
    private String current_value;
    private String stream_id;

    public ControlCommand(String str, String str2) {
        this.stream_id = str;
        this.current_value = str2;
    }

    public String getStream_id() {
        return this.stream_id;
    }

    public String getCurrent_value() {
        return this.current_value;
    }

    public void setStream_id(String str) {
        this.stream_id = str;
    }

    public void setCurrent_value(String str) {
        this.current_value = str;
    }
}
