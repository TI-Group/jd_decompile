package com.jd.fridge;

import com.jd.fridge.util.c.a;
import com.jd.fridge.util.k;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class b {
    public static String a = "foodNoticeStatusList.cac";
    public static String b = "foodNoticeList.cac";
    public static String c = "foodNoticeMenuList.cac";
    public static String d = "foodNotMove.cac";
    public static final String[] e = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final Map f = new HashMap();

    static {
        f.put("android.permission.WRITE_EXTERNAL_STORAGE", "Storage");
        f.put("android.permission.CAMERA", "Camera");
    }

    public static String a() {
        return a.b().getPin() + GlobalVariable.C() + a;
    }

    public static String b() {
        k.a("getCacheFoodNoticeList.feedid====" + GlobalVariable.C() + "===pin==" + a.b().getPin() + "==glo_pin==" + GlobalVariable.I());
        return a.b().getPin() + GlobalVariable.C() + b;
    }

    public static String c() {
        return "0" + b;
    }

    public static String d() {
        k.a("getCacheFoodNoticeMenuList.feedid====" + GlobalVariable.C() + "===pin==" + a.b().getPin() + "==glo_pin==" + GlobalVariable.I());
        return a.b().getPin() + GlobalVariable.C() + c;
    }
}
