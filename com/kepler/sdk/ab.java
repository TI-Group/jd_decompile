package com.kepler.sdk;

import cn.jiguang.net.HttpUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class ab {
    protected String a;
    protected String b = "get";
    protected byte[] c;
    protected String d;
    protected HashMap<String, String> e;
    int f;

    public ab(String str, Map<String, String> map, String str2) {
        this.b = str2;
        if (aq.a((Map) map)) {
            this.a = str;
            return;
        }
        String a = ar.a((Map) map);
        if (!aq.a(a)) {
            if ("post".equalsIgnoreCase(str2)) {
                this.a = str;
                this.c = a.getBytes();
                return;
            }
            this.a = str + HttpUtils.URL_AND_PARA_SEPARATOR + a;
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }

    public void a(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public HashMap<String, String> e() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }
}
