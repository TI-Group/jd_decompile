package com.kepler.jd.sdk.bean;

import com.kepler.sdk.aa;

/* compiled from: TbsSdkJava */
public class KelperTask {
    private boolean isCancel;
    private aa netLinker;

    public boolean isCancel() {
        return this.isCancel;
    }

    public void setCancel(boolean z) {
        this.isCancel = z;
        if (this.netLinker != null) {
            this.netLinker.b();
        }
    }

    public void setNetLinker(aa aaVar) {
        this.netLinker = aaVar;
    }
}
