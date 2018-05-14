package com.jingdong.crash.inner;

import android.os.Build;
import android.os.Process;
import com.sina.weibo.sdk.c.a;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class v implements Serializable {
    public String a;
    public String b;
    public String c;
    public LinkedHashMap d;
    public String e;
    public String f = "default";
    public String g = "1";
    public String h;
    public String i;
    public LinkedHashMap j;
    public LinkedHashMap k;
    public LinkedHashMap l;

    public v() {
        try {
            this.e = ae.a(new Date());
            this.c = q.a();
            this.h = "";
            this.i = "";
            this.j = new LinkedHashMap();
            this.j.put("name", p.f);
            this.j.put("version", p.g);
            this.k = new LinkedHashMap();
            this.k.put("name", "crsdkandr");
            this.k.put("version", "1.0.1");
            this.l = new LinkedHashMap();
            this.l.put("name", p.d);
            this.l.put("version", p.e);
        } catch (Throwable th) {
            if (ah.b) {
                th.printStackTrace();
            }
        }
        try {
            a();
        } catch (Throwable th2) {
            if (ah.b) {
                th2.printStackTrace();
            }
        }
    }

    public static String a(LinkedHashMap linkedHashMap) {
        String str = "{";
        for (Entry entry : linkedHashMap.entrySet()) {
            str = (str + "'" + entry.getKey() + "':") + "'" + entry.getValue() + "',";
        }
        return str.substring(0, str.lastIndexOf(",")) + "}";
    }

    private void a() {
        this.d = new LinkedHashMap();
        this.d.put("submit", a.DEFAULT_AUTH_ERROR_CODE);
        this.d.put("feedback", "");
        this.d.put("processName", d.a(Process.myPid()));
        this.d.put("processId", Process.myPid() + "");
        this.d.put("current free disk size", ad.a() + "M");
        this.d.put("cpu", Build.CPU_ABI);
        this.d.put("romVersion", Build.DISPLAY);
        if (q.d() != null) {
            this.d.put("phoneNumber", q.b(q.d()));
            this.d.put("memInfo", ai.a(q.d()));
            this.d.put("crashTimes", ab.a(q.d()).getInt("shared_crash_times", 0) + "");
        }
        this.d.put("runTime", q.b());
        this.d.put("battery", "");
        this.d.put("bundles", "");
    }

    public static JSONObject b(LinkedHashMap linkedHashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : linkedHashMap.entrySet()) {
            try {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    jSONObject.put(entry.getKey().toString(), entry.getValue().toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashStack", this.a);
            jSONObject.put("exceptionCode", this.b);
            jSONObject.put("currentPageInfo", this.c);
            jSONObject.put("crashTime", this.e);
            jSONObject.put("crashType", this.f);
            jSONObject.put("sysInfo", a(this.d));
            jSONObject.put("reserved", this.h);
            jSONObject.put("tag", this.i);
            jSONObject.put("keplerInfo", b(this.j));
            jSONObject.put("sdkInfo", b(this.k));
            jSONObject.put("appInfo", b(this.l));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
