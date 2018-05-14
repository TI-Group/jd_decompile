package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class FavorMenu {
    private long feed_id;
    private int page_count = 1;
    private int page_order = 1;

    public FavorMenu(long j) {
        this.feed_id = j;
    }
}
