package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class GetRMenusByGoodsIds {
    private int count;
    private long feed_id;
    private String goods_ids;

    public long getFeed_id() {
        return this.feed_id;
    }

    public void setFeed_id(long j) {
        this.feed_id = j;
    }

    public String getGoods_ids() {
        return this.goods_ids;
    }

    public void setGoods_ids(String str) {
        this.goods_ids = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }
}
