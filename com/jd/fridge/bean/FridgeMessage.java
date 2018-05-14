package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FridgeMessage {
    private String date_time;
    private int id;
    private int is_read;
    private String pic_url;
    private int source_type;
    private String text;

    public int getId() {
        return this.id;
    }

    public int getSourceType() {
        return this.source_type;
    }

    public String getText() {
        return this.text;
    }

    public int isRead() {
        return this.is_read;
    }

    public String getDateTime() {
        return this.date_time;
    }

    public String getPicUrl() {
        return this.pic_url;
    }
}
