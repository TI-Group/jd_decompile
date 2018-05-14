package com.jd.fridge.bean;

import com.jd.fridge.GlobalVariable;

/* compiled from: TbsSdkJava */
public class ShareContent {
    private long feed_id;
    private String msg_groupId;
    private int r;
    private String share_des;
    private String share_img;
    private String share_title;
    private String user_pin;

    public int getR() {
        return this.r;
    }

    public String getShareImg() {
        return this.share_img;
    }

    public String getUserPin() {
        return this.user_pin;
    }

    public String getShareDes() {
        return this.share_des;
    }

    public String getMsgGroupId() {
        return this.msg_groupId;
    }

    public long getFeedId() {
        return this.feed_id;
    }

    public String getShareTitle() {
        return this.share_title;
    }

    public String getShareLink() {
        return GlobalVariable.B().f() + "/friendswxh5/showFocus?ffId=" + this.feed_id + "&msgGroupId=" + this.msg_groupId + "&userPin=" + this.user_pin + "&r=" + this.r;
    }
}
