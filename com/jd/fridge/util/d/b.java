package com.jd.fridge.util.d;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class b {
    private static a a = null;
    private static final List<String> b = new ArrayList();
    private static boolean c = false;

    public static void a(Context context, String str, a aVar) {
        a(context, new String[]{str}, aVar);
    }

    public static void a(Context context, String[] strArr, a aVar) {
        if (!c) {
            c = true;
            a = aVar;
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    b.add(str);
                }
            }
            if (b.isEmpty()) {
                aVar.a();
                b();
                return;
            }
            ActivityCompat.requestPermissions((Activity) context, (String[]) b.toArray(new String[b.size()]), 0);
        }
    }

    public static a a() {
        return a;
    }

    public static void b() {
        a = null;
        b.clear();
        c = false;
    }
}
