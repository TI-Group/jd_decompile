package com.kepler.sdk;

import com.kepler.jd.login.KeplerApiManager;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class ac {
    private Map<String, List<String>> a;
    private int b = KeplerApiManager.NetLinker_Err_Not_200;
    private String c;

    public ac(String str, Map<String, List<String>> map, int i) {
        this.c = str;
        this.a = map;
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<String> a(String str) {
        if (this.a != null) {
            return (List) this.a.get(str);
        }
        return null;
    }
}
