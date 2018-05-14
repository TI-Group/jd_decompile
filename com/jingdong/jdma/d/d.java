package com.jingdong.jdma.d;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.a;
import com.jingdong.jdma.common.utils.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
public class d {
    private Map<String, String> a;
    private Context b;
    private String c = "";
    private String d = "";

    public d(Context context, String str, String str2) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        this.c = str;
        this.d = str2;
        this.a = new HashMap();
        this.a = b(b());
    }

    private synchronized void a() {
        if (this.b != null) {
            String b = b(this.a);
            if (e.b(this.b)) {
                a.a(this.b, this.c, b);
            } else {
                a.b(this.b, this.d, b);
            }
        }
    }

    private String b() {
        if (this.b == null) {
            return "";
        }
        if (e.b(this.b)) {
            return a.a(this.b, this.c);
        }
        return a.b(this.b, this.d);
    }

    public void a(String str, String str2) {
        if (str != null && !"".equals(str) && str2 != null && !"".equals(str2)) {
            this.a.put(str, str2);
            a();
        }
    }

    public void a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            for (Entry entry : map.entrySet()) {
                this.a.put(entry.getKey(), entry.getValue());
            }
            a();
        }
    }

    public String a(String str) {
        String str2 = "";
        if (str == null || "".equals(str) || !this.a.containsKey(str)) {
            return str2;
        }
        return (String) this.a.get(str);
    }

    private static Map<String, String> b(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split(CommonUtil.huanhangSymbol)) {
            int indexOf = str2.indexOf(CommonUtil.keyValueSymbol);
            if (indexOf != -1) {
                hashMap.put(str2.substring(0, indexOf).trim(), str2.substring(indexOf + CommonUtil.keyValueSymbol.length()).trim());
            }
        }
        return hashMap;
    }

    private static synchronized String b(Map<String, String> map) {
        String substring;
        synchronized (d.class) {
            String str = "";
            for (Entry entry : map.entrySet()) {
                str = str + (((String) entry.getKey()) + CommonUtil.keyValueSymbol + ((String) entry.getValue()) + CommonUtil.huanhangSymbol);
            }
            substring = str.substring(0, str.lastIndexOf(CommonUtil.huanhangSymbol));
        }
        return substring;
    }
}
