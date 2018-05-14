package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.JDMaInterface;
import com.tencent.stat.DeviceInfo;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.au;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

class d {
    String a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    Context o;
    private String p;
    private String q;
    private String r;
    private String s;

    private d(Context context) {
        this.b = StatConstants.VERSION;
        this.d = VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = context.getApplicationContext();
        this.c = l.d(this.o);
        this.a = l.h(this.o);
        this.h = StatConfig.getInstallChannel(this.o);
        this.i = l.g(this.o);
        this.j = TimeZone.getDefault().getID();
        this.l = l.m(this.o);
        this.k = l.n(this.o);
        this.m = this.o.getPackageName();
        if (this.d >= 14) {
            this.p = l.t(this.o);
        }
        this.q = l.s(this.o).toString();
        this.r = l.r(this.o);
        this.s = l.d();
        this.n = l.A(this.o);
    }

    void a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.c != null) {
                jSONObject.put(JDMaInterface.UNION_TYPE_SERVER, this.c.widthPixels + "*" + this.c.heightPixels);
                jSONObject.put("dpi", this.c.xdpi + "*" + this.c.ydpi);
            }
            if (a.a(this.o).e()) {
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, "bs", r.d(this.o));
                r.a(jSONObject2, "ss", r.e(this.o));
                if (jSONObject2.length() > 0) {
                    r.a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray a = r.a(this.o, 10);
            if (a != null && a.length() > 0) {
                r.a(jSONObject, "wflist", a.toString());
            }
            r.a(jSONObject, "sen", this.p);
        } else {
            r.a(jSONObject, "thn", thread.getName());
            r.a(jSONObject, "qq", StatConfig.getQQ(this.o));
            r.a(jSONObject, "cui", StatConfig.getCustomUserId(this.o));
            if (l.c(this.r) && this.r.split(HttpUtils.PATHS_SEPARATOR).length == 2) {
                r.a(jSONObject, "fram", this.r.split(HttpUtils.PATHS_SEPARATOR)[0]);
            }
            if (l.c(this.s) && this.s.split(HttpUtils.PATHS_SEPARATOR).length == 2) {
                r.a(jSONObject, "from", this.s.split(HttpUtils.PATHS_SEPARATOR)[0]);
            }
            if (au.a(this.o).b(this.o) != null) {
                jSONObject.put(DeviceInfo.TAG_IMEI, au.a(this.o).b(this.o).b());
            }
            r.a(jSONObject, DeviceInfo.TAG_MID, StatConfig.getLocalMidOnly(this.o));
        }
        r.a(jSONObject, "pcn", l.o(this.o));
        r.a(jSONObject, "osn", VERSION.RELEASE);
        r.a(jSONObject, "av", this.a);
        r.a(jSONObject, "ch", this.h);
        r.a(jSONObject, "mf", this.f);
        r.a(jSONObject, "sv", this.b);
        r.a(jSONObject, "osd", Build.DISPLAY);
        r.a(jSONObject, "prod", Build.PRODUCT);
        r.a(jSONObject, "tags", Build.TAGS);
        r.a(jSONObject, "id", Build.ID);
        r.a(jSONObject, "fng", Build.FINGERPRINT);
        r.a(jSONObject, "lch", this.n);
        r.a(jSONObject, "ov", Integer.toString(this.d));
        jSONObject.put("os", 1);
        r.a(jSONObject, "op", this.i);
        r.a(jSONObject, "lg", this.g);
        r.a(jSONObject, "md", this.e);
        r.a(jSONObject, "tz", this.j);
        if (this.l != 0) {
            jSONObject.put("jb", this.l);
        }
        r.a(jSONObject, "sd", this.k);
        r.a(jSONObject, "apn", this.m);
        r.a(jSONObject, "cpu", this.q);
        r.a(jSONObject, "abi", Build.CPU_ABI);
        r.a(jSONObject, "abi2", Build.CPU_ABI2);
        r.a(jSONObject, "ram", this.r);
        r.a(jSONObject, "rom", this.s);
    }
}
