package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class JPushDataMessageBean extends JPushDataBaseBean {
    private MessageBean data;

    /* compiled from: TbsSdkJava */
    class MessageBean {
        MessageBean() {
        }
    }

    public MessageBean getData() {
        return this.data;
    }

    public void setData(MessageBean messageBean) {
        this.data = messageBean;
    }
}
