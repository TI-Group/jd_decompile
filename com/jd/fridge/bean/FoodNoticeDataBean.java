package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class FoodNoticeDataBean implements Serializable {
    private static final long serialVersionUID = 3485296983150590109L;
    private String feedId;
    private JPushReceiverMsgDataBean msg_content;
    private String noticeId;
    private String pin;
    private String title = "";

    public String getNoticeId() {
        return this.noticeId;
    }

    public void setNoticeId(String str) {
        this.noticeId = str;
    }

    public JPushReceiverMsgDataBean getMsg_content() {
        return this.msg_content;
    }

    public void setMsg_content(JPushReceiverMsgDataBean jPushReceiverMsgDataBean) {
        this.msg_content = jPushReceiverMsgDataBean;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }
}
