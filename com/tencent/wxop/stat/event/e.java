package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.stat.DeviceInfo;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.au;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public abstract class e {
    protected static String j = null;
    private StatSpecifyReportedInfo a = null;
    protected String b = null;
    protected long c;
    protected int d;
    protected a e = null;
    protected int f;
    protected String g = null;
    protected String h = null;
    protected String i = null;
    protected boolean k = false;
    protected Context l;

    e(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.l = context;
        this.c = System.currentTimeMillis() / 1000;
        this.d = i;
        this.h = StatConfig.getInstallChannel(context);
        this.i = l.h(context);
        this.b = StatConfig.getAppKey(context);
        if (statSpecifyReportedInfo != null) {
            this.a = statSpecifyReportedInfo;
            if (l.c(statSpecifyReportedInfo.getAppKey())) {
                this.b = statSpecifyReportedInfo.getAppKey();
            }
            if (l.c(statSpecifyReportedInfo.getInstallChannel())) {
                this.h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (l.c(statSpecifyReportedInfo.getVersion())) {
                this.i = statSpecifyReportedInfo.getVersion();
            }
            this.k = statSpecifyReportedInfo.isImportant();
        }
        this.g = StatConfig.getCustomUserId(context);
        this.e = au.a(context).b(context);
        if (a() != EventType.NETWORK_DETECTOR) {
            this.f = l.q(context).intValue();
        } else {
            this.f = -EventType.NETWORK_DETECTOR.a();
        }
        if (!h.c(j)) {
            String localMidOnly = StatConfig.getLocalMidOnly(context);
            j = localMidOnly;
            if (!l.c(localMidOnly)) {
                j = "0";
            }
        }
    }

    public abstract EventType a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean b(JSONObject jSONObject) {
        boolean z = false;
        try {
            r.a(jSONObject, "ky", this.b);
            jSONObject.put("et", a().a());
            if (this.e != null) {
                jSONObject.put(DeviceInfo.TAG_IMEI, this.e.b());
                r.a(jSONObject, DeviceInfo.TAG_MAC, this.e.c());
                int d = this.e.d();
                jSONObject.put("ut", d);
                if (d == 0 && l.u(this.l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            r.a(jSONObject, "cui", this.g);
            if (a() != EventType.SESSION_ENV) {
                r.a(jSONObject, "av", this.i);
                r.a(jSONObject, "ch", this.h);
            }
            if (this.k) {
                jSONObject.put("impt", 1);
            }
            r.a(jSONObject, DeviceInfo.TAG_MID, j);
            jSONObject.put("cch", "wxop");
            jSONObject.put("idx", this.f);
            jSONObject.put("si", this.d);
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.c);
            jSONObject.put("dts", l.a(this.l, false));
            z = a(jSONObject);
        } catch (Throwable th) {
        }
        return z;
    }

    public long c() {
        return this.c;
    }

    public StatSpecifyReportedInfo d() {
        return this.a;
    }

    public Context e() {
        return this.l;
    }

    public boolean f() {
        return this.k;
    }

    public String g() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
