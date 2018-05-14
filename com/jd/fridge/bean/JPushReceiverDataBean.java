package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class JPushReceiverDataBean implements Serializable {
    private static final long serialVersionUID = -2795320757939164181L;
    private String msg_content;
    private String title;

    public String getMsg_content() {
        return this.msg_content;
    }

    public void setMsg_content(String str) {
        this.msg_content = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
