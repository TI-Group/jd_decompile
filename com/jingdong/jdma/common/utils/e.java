package com.jingdong.jdma.common.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import java.io.File;
import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public class e {
    private static ArrayList<String> a = new ArrayList();

    /* compiled from: TbsSdkJava */
    public interface b {
        Object a();
    }

    /* compiled from: TbsSdkJava */
    public interface a {
        Object a();
    }

    static {
        a.add("android.permission.READ_PHONE_STATE");
    }

    public static boolean a() {
        return VERSION.SDK_INT > 22;
    }

    public static Object a(Context context, String str, b bVar, a aVar) {
        if (context == null || !a()) {
            if (bVar != null) {
                return bVar.a();
            }
        } else if (ContextCompat.checkSelfPermission(context, str) == 0) {
            if (bVar != null) {
                return bVar.a();
            }
        } else if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public static File a(Context context) {
        if (context == null) {
            return new File("sdcard/jingdong");
        }
        return context.getExternalCacheDir();
    }

    public static boolean b(Context context) {
        if (context == null || a(context) == null || !a(context).exists()) {
            return false;
        }
        return true;
    }
}
