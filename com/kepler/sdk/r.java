package com.kepler.sdk;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class r {
    private static volatile r b;
    Map<String, Integer> a = new HashMap();

    public static r a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new r();
                }
            }
        }
        return b;
    }

    public void a(String str) {
        try {
            String path = new URL(str).getPath();
            this.a.put(path, b(path));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Integer b(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null) {
            return Integer.valueOf(0);
        }
        Integer.valueOf(num.intValue() + 1);
        return num;
    }
}
