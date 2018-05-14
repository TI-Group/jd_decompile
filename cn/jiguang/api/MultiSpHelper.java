package cn.jiguang.api;

import android.content.Context;
import cn.jiguang.b.a.d;
import java.io.Serializable;

public class MultiSpHelper {
    public static void commitBoolean(Context context, String str, boolean z) {
        d.a(context, str, Boolean.valueOf(z));
    }

    public static void commitInt(Context context, String str, int i) {
        d.a(context, str, Integer.valueOf(i));
    }

    public static void commitLong(Context context, String str, long j) {
        d.a(context, str, Long.valueOf(j));
    }

    public static void commitString(Context context, String str, String str2) {
        d.a(context, str, (Serializable) str2);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return ((Boolean) d.b(context, str, Boolean.valueOf(z))).booleanValue();
    }

    public static int getInt(Context context, String str, int i) {
        return ((Integer) d.b(context, str, Integer.valueOf(i))).intValue();
    }

    public static long getLong(Context context, String str, long j) {
        return ((Long) d.b(context, str, Long.valueOf(j))).longValue();
    }

    public static String getString(Context context, String str, String str2) {
        return (String) d.b(context, str, str2);
    }
}
