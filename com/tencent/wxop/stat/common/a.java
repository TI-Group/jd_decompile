package com.tencent.wxop.stat.common;

import com.tencent.stat.DeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = "0";
    private int e;
    private int f = 0;
    private long g = 0;

    public a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.e = i;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            r.a(jSONObject, DeviceInfo.TAG_IMEI, this.a);
            r.a(jSONObject, DeviceInfo.TAG_MAC, this.b);
            r.a(jSONObject, DeviceInfo.TAG_MID, this.d);
            r.a(jSONObject, DeviceInfo.TAG_ANDROID_ID, this.c);
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.g);
            jSONObject.put(DeviceInfo.TAG_VERSION, this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(int i) {
        this.e = i;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String toString() {
        return a().toString();
    }
}
