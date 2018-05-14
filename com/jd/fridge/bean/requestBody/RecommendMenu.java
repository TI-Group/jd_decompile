package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class RecommendMenu {
    private int count;
    private long feed_id;
    private int[] goods_ids;

    public RecommendMenu(long j, int[] iArr, int i) {
        this.feed_id = j;
        this.goods_ids = iArr;
        this.count = i;
    }
}
