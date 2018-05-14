package com.kepler.jd.sdk.bean;

import com.kepler.sdk.aq;
import com.kepler.sdk.k;

/* compiled from: TbsSdkJava */
public class KeplerGlobalParameter {
    private static volatile KeplerGlobalParameter singleton;
    private String JDappBackTagID;
    private String actId;
    private String ext;
    private String[] goBackIgnoredUrl;
    private boolean isUserSetOpenByH5 = true;
    int openAPPTimeOut = 10;
    private String virtualAppkey;

    private KeplerGlobalParameter() {
    }

    public static KeplerGlobalParameter getSingleton() {
        if (singleton == null) {
            synchronized (KeplerGlobalParameter.class) {
                if (singleton == null) {
                    singleton = new KeplerGlobalParameter();
                }
            }
        }
        return singleton;
    }

    public String getVirtualAppkey() {
        if (aq.b(this.virtualAppkey)) {
            return "null";
        }
        return this.virtualAppkey;
    }

    public void setVirtualAppkey(String str) {
        this.virtualAppkey = str;
    }

    public boolean isOpenByH5Mode() {
        if (k.b().c) {
            return this.isUserSetOpenByH5;
        }
        return true;
    }

    public void setIsOpenByH5Mode(boolean z) {
        this.isUserSetOpenByH5 = z;
    }

    public String getJDappBackTagID() {
        if (aq.b(this.JDappBackTagID)) {
            return "null";
        }
        return this.JDappBackTagID;
    }

    public void setJDappBackTagID(String str) {
        this.JDappBackTagID = str;
    }

    public String getActId() {
        if (aq.a(this.actId)) {
            return "null";
        }
        return this.actId;
    }

    public void setActId(String str) {
        this.actId = str;
    }

    public String getExt() {
        if (aq.a(this.ext)) {
            return "null";
        }
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public String[] getGoBackIgnoredUrl() {
        return this.goBackIgnoredUrl;
    }

    public void setGoBackIgnoredUrl(String[] strArr) {
        this.goBackIgnoredUrl = strArr;
    }

    public int getOpenAPPTimeOut() {
        return this.openAPPTimeOut;
    }

    public void setOpenAPPTimeOut(int i) {
        this.openAPPTimeOut = i;
    }
}
