package com.tencent.a.a.a.a;

import android.util.Log;
import com.tencent.stat.DeviceInfo;
import org.json.JSONObject;

public final class c {
    long T = 0;
    String a = null;
    String b = null;
    String c = "0";

    static c e(String str) {
        c cVar = new c();
        if (h.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(DeviceInfo.TAG_IMEI)) {
                    cVar.a = jSONObject.getString(DeviceInfo.TAG_IMEI);
                }
                if (!jSONObject.isNull(DeviceInfo.TAG_MAC)) {
                    cVar.b = jSONObject.getString(DeviceInfo.TAG_MAC);
                }
                if (!jSONObject.isNull(DeviceInfo.TAG_MID)) {
                    cVar.c = jSONObject.getString(DeviceInfo.TAG_MID);
                }
                if (!jSONObject.isNull(DeviceInfo.TAG_TIMESTAMPS)) {
                    cVar.T = jSONObject.getLong(DeviceInfo.TAG_TIMESTAMPS);
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return cVar;
    }

    private JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            h.a(jSONObject, DeviceInfo.TAG_IMEI, this.a);
            h.a(jSONObject, DeviceInfo.TAG_MAC, this.b);
            h.a(jSONObject, DeviceInfo.TAG_MID, this.c);
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.T);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    public final String a() {
        return this.c;
    }

    public final String toString() {
        return n().toString();
    }
}
