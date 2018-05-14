package com.jingdong.jdma.common.utils;

import android.content.Context;
import android.text.TextUtils;
import com.jingdong.jdma.d.a;
import com.jingdong.jdma.minterface.ClickInterfaceParam;
import com.jingdong.jdma.minterface.PvInterfaceParam;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class c {
    public static String a = "0|";
    public static c u;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = a;
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String t = "";
    private Context v;

    private c(Context context) {
        this.v = context.getApplicationContext();
        if (this.v == null) {
            this.v = context;
        }
        c();
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (u == null) {
                u = new c(context);
                u.d();
            }
            cVar = u;
        }
        return cVar;
    }

    private void c() {
        if (this.v != null) {
            a a = a.a(this.v);
            this.i = a.a("jda");
            this.j = a.a("jda_ts");
            this.h = a.a("jdv");
            this.g = a.a("unpl");
            this.n = a.a("usc");
            this.o = a.a("ucp");
            this.p = a.a("umd");
            this.q = a.a("utr");
            this.r = a.a("adk");
            this.s = a.a("ad_sc_value");
        }
    }

    public void a(Context context, String str) {
        if (str != null && context != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.k = jSONObject.optString("psn", "");
                this.l = jSONObject.optString("psq", "");
                Map hashMap = new HashMap();
                if (jSONObject.has("adk") && jSONObject.has("ads")) {
                    this.r = jSONObject.getString("adk");
                    this.s = jSONObject.getString("ads");
                    hashMap.put("adk", this.r);
                    hashMap.put("ad_sc_value", this.s);
                }
                if (jSONObject.has("usc") && jSONObject.has("ucp") && jSONObject.has("umd") && jSONObject.has("utr")) {
                    this.n = jSONObject.getString("usc");
                    this.o = jSONObject.getString("ucp");
                    this.p = jSONObject.getString("umd");
                    this.q = jSONObject.getString("utr");
                    if (!TextUtils.isEmpty(this.n)) {
                        hashMap.put("usc", this.n);
                    }
                    if (!TextUtils.isEmpty(this.o)) {
                        hashMap.put("ucp", this.o);
                    }
                    if (!TextUtils.isEmpty(this.p)) {
                        hashMap.put("umd", this.p);
                    }
                    if (!TextUtils.isEmpty(this.q)) {
                        hashMap.put("utr", this.q);
                    }
                }
                String str2 = Math.round((float) (System.currentTimeMillis() / 1000)) + "";
                if (jSONObject.has("jda")) {
                    this.i = jSONObject.getString("jda");
                    this.j = str2;
                    hashMap.put("jda", this.i);
                    hashMap.put("jda_ts", this.j);
                }
                if (jSONObject.has("jdv")) {
                    this.h = jSONObject.getString("jdv");
                    int indexOf = this.h.indexOf("|");
                    if (-1 != indexOf) {
                        this.h = "0" + this.h.substring(indexOf) + "|" + str2;
                    } else {
                        this.h += "|" + str2;
                    }
                    hashMap.put("jdv", this.h);
                }
                if (jSONObject.has("unpl")) {
                    this.g = jSONObject.getString("unpl");
                    hashMap.put("unpl", "unpl");
                }
                if (this.v != null) {
                    a.a(this.v).a(hashMap);
                }
                String optString = jSONObject.optString("mba_muid");
                if (!"".equals(optString)) {
                    this.b = optString;
                }
                optString = jSONObject.optString("mba_sid");
                if (!"".equals(optString)) {
                    this.c = optString;
                }
                optString = jSONObject.optString("m_source");
                if (!"".equals(optString)) {
                    this.d = optString;
                }
                this.m = jSONObject.optString("ref", "");
                a();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.k = jSONObject.optString("psn", "");
                this.l = jSONObject.optString("psq", "");
                String optString = jSONObject.optString("mba_muid");
                if (!"".equals(optString)) {
                    this.b = optString;
                }
                optString = jSONObject.optString("mba_sid");
                if (!"".equals(optString)) {
                    this.c = optString;
                }
                optString = jSONObject.optString("m_source");
                if (!"".equals(optString)) {
                    this.d = optString;
                }
                this.m = jSONObject.optString("ref");
                Map hashMap = new HashMap();
                if (jSONObject.has("adk") && jSONObject.has("ads")) {
                    this.r = jSONObject.getString("adk");
                    this.s = jSONObject.getString("ads");
                    hashMap.put("adk", this.r);
                    hashMap.put("ad_sc_value", this.s);
                }
                if (jSONObject.has("usc") && jSONObject.has("ucp") && jSONObject.has("umd") && jSONObject.has("utr")) {
                    this.n = jSONObject.getString("usc");
                    this.o = jSONObject.getString("ucp");
                    this.p = jSONObject.getString("umd");
                    this.q = jSONObject.getString("utr");
                    if (!TextUtils.isEmpty(this.n)) {
                        hashMap.put("usc", this.n);
                    }
                    if (!TextUtils.isEmpty(this.o)) {
                        hashMap.put("ucp", this.o);
                    }
                    if (!TextUtils.isEmpty(this.p)) {
                        hashMap.put("umd", this.p);
                    }
                    if (!TextUtils.isEmpty(this.q)) {
                        hashMap.put("utr", this.q);
                    }
                }
                String str2 = Math.round((float) (System.currentTimeMillis() / 1000)) + "";
                if (jSONObject.has("jdv")) {
                    this.h = jSONObject.getString("jdv");
                    int indexOf = this.h.indexOf("|");
                    if (-1 != indexOf) {
                        this.h = "0" + this.h.substring(indexOf) + "|" + str2;
                    } else {
                        this.h += "|" + str2;
                    }
                    hashMap.put("jdv", this.h);
                }
                if (jSONObject.has("unpl")) {
                    this.g = jSONObject.getString("unpl");
                    hashMap.put("unpl", "unpl");
                }
                if (this.v != null) {
                    a.a(this.v).a(hashMap);
                }
                b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        PvInterfaceParam.openAppIsNew = true;
        ClickInterfaceParam.openAppIsNew = true;
    }

    public void b() {
        PvInterfaceParam.innerAppisNew = true;
        ClickInterfaceParam.innerAppisNew = true;
    }

    private void d() {
        PvInterfaceParam.openAppIsNew = true;
        PvInterfaceParam.firstPv = true;
        PvInterfaceParam.innerAppisNew = true;
        ClickInterfaceParam.openAppIsNew = true;
        ClickInterfaceParam.firstClick = true;
        ClickInterfaceParam.innerAppisNew = true;
    }

    public void a(String str, String str2) {
        this.e = str;
        this.f = str2;
        PvInterfaceParam.sourceTagIsNew = true;
        ClickInterfaceParam.sourceTagIsNew = true;
    }
}
