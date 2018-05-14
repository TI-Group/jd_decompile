package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class Share {
    private long feed_id;
    private String msg = "";
    private String msg_groupId = "";
    private int msg_type = 0;
    private String pic0;
    private String pic1;
    private String pin;
    private String shot_time;

    public Share(String str, long j, String str2, String str3, String str4) {
        this.pin = str;
        this.feed_id = j;
        this.pic0 = str2;
        this.pic1 = str3;
        this.shot_time = str4;
    }
}
