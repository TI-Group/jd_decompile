package com.jingdong.jdma.h;

import android.content.Context;
import android.text.TextUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.b;
import java.util.HashMap;
import java.util.Map.Entry;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class c {
    public boolean a;
    public Long b;
    public Long c;
    private String d;
    private HashMap<String, Long> e;
    private HashMap<String, Long> f;
    private boolean g;
    private long h;
    private String i;
    private long j;
    private long k;
    private String l;
    private long m;
    private long n;
    private String o;
    private Context p;

    public c(Context context, String str) {
        this.a = true;
        this.d = "";
        this.g = true;
        this.h = 0;
        this.i = CommonUtil.STATISTIC_DEFULT_VERSION;
        this.j = 0;
        this.k = 0;
        this.l = "";
        this.m = 60;
        this.n = 10;
        this.b = CommonUtil.DEFULT_UNWIFI_INTER;
        this.c = CommonUtil.DEFULT_UNWIFIREPORT_SIZE;
        this.o = "";
        this.e = new HashMap();
        this.f = new HashMap();
        this.o = str;
        this.p = context.getApplicationContext();
        if (this.p == null) {
            this.p = context;
        }
        g();
        this.d = b.a(this.o, context);
        if (!"".equals(this.d)) {
            a(this.d, true);
        }
    }

    public c(Context context, String str, String str2) {
        this(context, str);
        if ("".equals(this.d)) {
            a(str2, true);
        }
    }

    private void g() {
        this.e.put(NetworkType.WIFI_STRING, CommonUtil.DEFULT_WIFI_INTER);
        this.f.put(NetworkType.WIFI_STRING, CommonUtil.DEFULT_WIFI_REPORT_SIZE);
        this.e.put("4g", CommonUtil.DEFULT_UNWIFI_INTER);
        this.f.put("4g", CommonUtil.DEFULT_UNWIFIREPORT_SIZE);
        this.e.put(NetworkType.NET2G_STRING, CommonUtil.DEFULT_UNWIFI_INTER);
        this.f.put(NetworkType.NET2G_STRING, CommonUtil.DEFULT_UNWIFIREPORT_SIZE);
        this.e.put(NetworkType.NET3G_STRING, CommonUtil.DEFULT_UNWIFI_INTER);
        this.f.put(NetworkType.NET3G_STRING, CommonUtil.DEFULT_UNWIFIREPORT_SIZE);
        this.b = CommonUtil.DEFULT_UNWIFI_INTER;
        this.c = CommonUtil.DEFULT_UNWIFIREPORT_SIZE;
    }

    private boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!z) {
                switch (jSONObject.optInt("code", 9)) {
                    case 0:
                        break;
                    case 1:
                        return true;
                    default:
                        return false;
                }
            }
            boolean a = a(str, jSONObject);
            if (z || !a) {
                return a;
            }
            b.a(this.o, str, this.p);
            return a;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(String str) {
        return a(str, false);
    }

    private synchronized boolean a(String str, JSONObject jSONObject) {
        boolean z = true;
        synchronized (this) {
            if (!(str == null || jSONObject == null)) {
                if (jSONObject.has("ret")) {
                    if (jSONObject.optInt("ret") == 1) {
                        a(true);
                    } else {
                        a(false);
                    }
                    if (this.e == null) {
                        this.e = new HashMap();
                    }
                    Long parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("wifiInt")) ? "0" : jSONObject.optString("wifiInt"));
                    if (parseLongPositive.longValue() != 0) {
                        this.e.put(NetworkType.WIFI_STRING, parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g3Int")) ? "0" : jSONObject.optString("g3Int"));
                    if (parseLongPositive.longValue() != 0) {
                        this.e.put(NetworkType.NET2G_STRING, parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g4Int")) ? "0" : jSONObject.optString("g4Int"));
                    if (parseLongPositive.longValue() != 0) {
                        this.e.put("4g", parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g2Int")) ? "0" : jSONObject.optString("g2Int"));
                    if (parseLongPositive.longValue() != 0) {
                        this.e.put(NetworkType.NET3G_STRING, parseLongPositive);
                    }
                    if (this.f == null) {
                        this.f = new HashMap();
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("wifiSz")) ? "0" : jSONObject.optString("wifiSz"));
                    if (parseLongPositive.longValue() != 0) {
                        this.f.put(NetworkType.WIFI_STRING, parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g4Sz")) ? "0" : jSONObject.optString("g4Sz"));
                    if (parseLongPositive.longValue() != 0) {
                        this.f.put("4g", parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g3Sz")) ? "0" : jSONObject.optString("g3Sz"));
                    if (parseLongPositive.longValue() != 0) {
                        this.f.put(NetworkType.NET2G_STRING, parseLongPositive);
                    }
                    parseLongPositive = CommonUtil.parseLongPositive("".equals(jSONObject.optString("g2Sz")) ? "0" : jSONObject.optString("g2Sz"));
                    if (parseLongPositive.longValue() != 0) {
                        this.f.put(NetworkType.NET3G_STRING, parseLongPositive);
                    }
                    h();
                    this.h = jSONObject.optLong("cyc", 0);
                    this.i = jSONObject.optString("v", CommonUtil.STATISTIC_DEFULT_VERSION);
                    this.j = jSONObject.optLong("spd", 0);
                    this.k = jSONObject.optLong("loopbtw", 2);
                    this.l = jSONObject.optString(ClientCookie.DOMAIN_ATTR, this.l);
                }
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean a(String str, long j) {
        boolean z;
        if (str == null) {
            z = false;
        } else if (this.f == null) {
            z = false;
        } else {
            long longValue;
            if (this.f.containsKey(str)) {
                longValue = ((Long) this.f.get(str)).longValue();
            } else {
                longValue = this.n;
            }
            if (longValue <= 0 || j < longValue) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    public synchronized long b(String str) {
        long longValue;
        if (this.f.containsKey(str)) {
            longValue = ((Long) this.f.get(str)).longValue();
        } else {
            longValue = this.n;
        }
        return longValue;
    }

    public synchronized long c(String str) {
        long longValue;
        if (this.e.containsKey(str)) {
            longValue = ((Long) this.e.get(str)).longValue();
        } else {
            longValue = this.m;
        }
        return longValue;
    }

    public boolean a() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public long b() {
        return this.h;
    }

    public String c() {
        return this.i;
    }

    public long d() {
        return this.j;
    }

    public long e() {
        return this.k;
    }

    public String f() {
        return this.l;
    }

    private void h() {
        if (this.g) {
            this.c = Long.valueOf(-1);
            for (Entry entry : this.f.entrySet()) {
                if (this.c.longValue() == -1) {
                    this.c = (Long) entry.getValue();
                } else if (((Long) entry.getValue()).longValue() < this.c.longValue()) {
                    this.c = (Long) entry.getValue();
                }
            }
            this.b = Long.valueOf(-1);
            for (Entry entry2 : this.e.entrySet()) {
                if (this.b.longValue() == -1) {
                    this.b = (Long) entry2.getValue();
                } else if (((Long) entry2.getValue()).longValue() < this.b.longValue()) {
                    this.b = (Long) entry2.getValue();
                }
            }
        }
    }

    public static String a(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, long j9, String str, long j10, long j11, String str2) {
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wifiInt", j);
            jSONObject.put("wifiSz", j2);
            jSONObject.put("g4Int", j3);
            jSONObject.put("g4Sz", j4);
            jSONObject.put("g3Int", j5);
            jSONObject.put("g3Sz", j6);
            jSONObject.put("g2Int", j7);
            jSONObject.put("g2Sz", j8);
            jSONObject.put("ret", i);
            jSONObject.put("cyc", j9);
            jSONObject.put("v", str);
            jSONObject.put("spd", j10);
            jSONObject.put("loopbtw", j11);
            jSONObject.put(ClientCookie.DOMAIN_ATTR, str2);
            str3 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str3;
    }
}
