package com.jd.fridge.bean;

import java.util.List;

/* compiled from: TbsSdkJava */
public class GetPictureHistoryResult {
    private int count;
    private List<FridgeSnapshot> data;

    public GetPictureHistoryResult(List<FridgeSnapshot> list) {
        this.data = list;
        this.count = list.size();
    }

    public List<FridgeSnapshot> getData() {
        return this.data;
    }

    public int getCount() {
        return this.count;
    }
}
