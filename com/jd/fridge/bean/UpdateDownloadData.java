package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class UpdateDownloadData implements Serializable {
    private long id;
    private boolean isDownloading;

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public void setDownloading(boolean z) {
        this.isDownloading = z;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }
}
