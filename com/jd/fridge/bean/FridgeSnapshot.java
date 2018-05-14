package com.jd.fridge.bean;

import java.util.List;

/* compiled from: TbsSdkJava */
public class FridgeSnapshot {
    private List<FridgePicture> details;
    private long time;

    public FridgeSnapshot(List<FridgePicture> list, long j) {
        this.details = list;
        this.time = j;
    }

    public List<FridgePicture> getDetails() {
        return this.details;
    }

    public long getTime() {
        return this.time;
    }
}
