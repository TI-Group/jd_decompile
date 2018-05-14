package com.tencent.map.a.a;

import com.jingdong.jdma.JDMaInterface;

public class c {
    public String a = null;
    public String b = null;
    public String c = null;
    public double d = JDMaInterface.PV_UPPERLIMIT;
    public double e = JDMaInterface.PV_UPPERLIMIT;
    public double f = JDMaInterface.PV_UPPERLIMIT;

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
    }

    public c(String str, String str2, String str3, double d, double d2, double d3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
        this.e = d2;
        this.f = d3;
    }
}
