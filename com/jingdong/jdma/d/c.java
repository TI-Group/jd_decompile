package com.jingdong.jdma.d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.jingdong.jdma.common.a.d;
import com.jingdong.jdma.common.utils.e;
import com.jingdong.jdma.common.utils.e.a;
import com.jingdong.jdma.common.utils.e.b;
import com.jingdong.jdma.common.utils.f;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import com.tencent.stat.DeviceInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class c {
    private static c a = null;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "android";
    private String h = "3.0.3";
    private String i = "3.0";
    private String j = "";
    private String k = "app";
    private String l = "";
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private String q;
    private Context r;
    private MaInitCommonInfo s;

    private c(Context context, MaInitCommonInfo maInitCommonInfo) {
        this.s = maInitCommonInfo;
        this.b = f.a(context);
        this.c = Build.BRAND;
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        e.a(context, "android.permission.READ_PHONE_STATE", new b(this) {
            final /* synthetic */ c b;

            public Object a() {
                this.b.d = telephonyManager.getDeviceId();
                return null;
            }
        }, new a(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public Object a() {
                this.a.d = "";
                return null;
            }
        });
        this.e = Build.MODEL;
        this.f = maInitCommonInfo.getGuid();
        this.j = maInitCommonInfo.site_id;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.l = displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        this.m = VERSION.RELEASE;
        this.n = a(Build.MODEL, 12);
        this.o = maInitCommonInfo.app_device;
        this.p = maInitCommonInfo.channel;
        this.q = maInitCommonInfo.proj_id;
        this.r = context.getApplicationContext();
        if (this.r == null) {
            this.r = context;
        }
    }

    public static c a(Context context, MaInitCommonInfo maInitCommonInfo) {
        if (a == null) {
            a = new c(context, maInitCommonInfo);
        }
        return a;
    }

    public JSONObject a(final Context context, int i) {
        e.a(context, "android.permission.READ_PHONE_STATE", new b(this) {
            final /* synthetic */ c b;

            public Object a() {
                this.b.b = f.a(context);
                this.b.d = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                this.b.f = this.b.s.getGuid();
                return null;
            }
        }, null);
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "" + System.currentTimeMillis();
            String a = d.a(str + "5YT%aC89$22OI@pQ");
            if (i == 0) {
                jSONObject.put("jid", this.b);
                jSONObject.put("mct", this.c);
                jSONObject.put("net", com.jingdong.jdma.common.utils.d.b(this.r));
                jSONObject.put("imi", this.d);
                jSONObject.put("dvc", this.e);
                jSONObject.put("uid", this.f);
                jSONObject.put("osp", this.g);
                jSONObject.put("jvr", this.h);
                jSONObject.put(DeviceInfo.TAG_VERSION, this.i);
                jSONObject.put("std", this.j);
                jSONObject.put("clt", this.k);
                jSONObject.put("report_ts", str);
                jSONObject.put("scr", this.l);
                jSONObject.put("osv", this.m);
                jSONObject.put("machineType", this.n);
                jSONObject.put("token", a);
                jSONObject.put("app_device", this.o);
                jSONObject.put("chf", this.p);
                jSONObject.put("proj_id", this.q);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static String a(String str, int i) {
        if (str != null) {
            try {
                if (str.length() > i) {
                    str = str.substring(0, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.jingdong.jdma.common.a.b.a(str, "this is the pinaddress key apoaffffe");
    }
}
