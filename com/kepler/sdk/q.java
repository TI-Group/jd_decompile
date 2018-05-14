package com.kepler.sdk;

import java.util.Date;

/* compiled from: TbsSdkJava */
public class q {
    String a;
    long b;

    public q(String str) {
        if (o.g) {
            this.a = str;
            this.b = new Date().getTime();
        }
    }

    public void a(String str) {
        if (o.g) {
            p.b("suwg", this.a + "消耗" + (new Date().getTime() - this.b) + "  " + str);
        }
    }
}
