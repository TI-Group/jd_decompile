package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class Stock {
    private long feed_id;
    private int[] goods_ids;

    public Stock(long j, int[] iArr) {
        this.feed_id = j;
        this.goods_ids = iArr;
    }
}
