package com.jingdong.crash.inner;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;

class ai {
    private static String a(long j) {
        if (j <= 0) {
            return "0byte";
        }
        if (j < 1048576) {
            return String.format("%.1fKB", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
        }
        return String.format("%.1fMB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
    }

    public static String a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        StringBuilder stringBuilder = new StringBuilder();
        String a = a(Runtime.getRuntime().maxMemory());
        String a2 = a(Runtime.getRuntime().totalMemory());
        String a3 = a(Runtime.getRuntime().freeMemory());
        stringBuilder.append("Runtime memory( ");
        stringBuilder.append("maxMemory = " + a + ", ");
        stringBuilder.append("totalMemory = " + a2 + ", ");
        stringBuilder.append("freeMemory = " + a3 + " ) ; ");
        MemoryInfo memoryInfo = new MemoryInfo();
        stringBuilder.append("MemoryInfo (");
        activityManager.getMemoryInfo(memoryInfo);
        if (VERSION.SDK_INT >= 16) {
            stringBuilder.append("总内存：" + a(memoryInfo.totalMem) + ", ");
        }
        stringBuilder.append("总可用内存：" + a(memoryInfo.availMem) + " , ");
        stringBuilder.append("lowMemory：" + memoryInfo.lowMemory + " ) ");
        if (ah.b) {
            ah.a("MemInfo", stringBuilder.toString());
        }
        return stringBuilder.toString();
    }
}
