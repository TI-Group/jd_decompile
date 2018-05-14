package com.jd.fridge.util.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.f;
import java.util.HashMap;
import java.util.UUID;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.model.ClientInfo;

/* compiled from: TbsSdkJava */
public class a {
    private static ClientInfo a;
    private static WJLoginHelper b;

    public static synchronized ClientInfo a() {
        ClientInfo clientInfo;
        synchronized (a.class) {
            a = new ClientInfo();
            a.setDwAppID((short) 194);
            a.setClientType("Android");
            a.setOsVer(VERSION.RELEASE);
            a.setDwAppClientVer(f.a(GlobalVariable.B().getApplicationContext()));
            a.setScreen("800*600");
            a.setAppName("JdFridge");
            a.setArea("SHA");
            a.setUuid(c());
            a.setDwGetSig(1);
            Object a = a(Build.MANUFACTURER, 12);
            Object a2 = a(Build.MODEL, 12);
            Object a3 = a(Build.PRODUCT, 12);
            if (!TextUtils.isEmpty(a)) {
                a.setDeviceBrand(a.replaceAll(" ", ""));
            }
            if (!TextUtils.isEmpty(a2)) {
                a.setDeviceModel(a2.replaceAll(" ", ""));
            }
            if (!TextUtils.isEmpty(a3)) {
                a.setDeviceName(a3.replaceAll(" ", ""));
            }
            a.setReserve("");
            clientInfo = a;
        }
        return clientInfo;
    }

    private static String c() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalVariable.B().getSystemService("phone");
        String str = "" + telephonyManager.getDeviceId();
        return new UUID((long) ("" + Secure.getString(GlobalVariable.B().getContentResolver(), "android_id")).hashCode(), ((long) ("" + telephonyManager.getSimSerialNumber()).hashCode()) | (((long) str.hashCode()) << 32)).toString();
    }

    private static String a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() > i) {
                str = str.substring(0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static synchronized WJLoginHelper b() {
        WJLoginHelper wJLoginHelper;
        synchronized (a.class) {
            if (b == null) {
                b = new WJLoginHelper(GlobalVariable.B(), a());
                b.SetDevleop(false);
                b.createGuid();
            }
            wJLoginHelper = b;
        }
        return wJLoginHelper;
    }

    public static void a(Handler handler) {
        com.jd.fridge.a.a().a(handler, new HashMap());
    }
}
