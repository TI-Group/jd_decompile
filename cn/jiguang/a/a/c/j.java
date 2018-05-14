package cn.jiguang.a.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfo.DisplayNameComparator;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    private static final String a = j.class.getSimpleName();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "T;2vlT;5\u0007\u001dW";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0094;
            case 1: goto L_0x0097;
            case 2: goto L_0x009a;
            case 3: goto L_0x009d;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 97;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u000b\u0013y'Y";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "?$Kc\u000e0}Mo\u001115KX\u00140)Vd\u0006\u0017)Ye";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "?$Kc\u001773F";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "9\"KX\u00140)Vd\u0006\u001f7OyA;5Me\u0013d";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ".,XU\u000f?*Z";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "2.Io>-\"\\e\u000f:4";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "=+^y\u0012\u0001)^g\u0004";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "?7OU\u000f?*Z";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "-\"M|\b=\"`f\b-3";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        r0 = cn.jiguang.a.a.c.j.class;
        r0 = r0.getSimpleName();
        a = r0;
        return;
    L_0x0094:
        r9 = 94;
        goto L_0x0020;
    L_0x0097:
        r9 = 71;
        goto L_0x0020;
    L_0x009a:
        r9 = 63;
        goto L_0x0020;
    L_0x009d:
        r9 = 10;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.j.<clinit>():void");
    }

    public static String a(String str, int i) {
        if (str == null) {
            return str;
        }
        String replaceAll = Pattern.compile(z[0]).matcher(str).replaceAll("");
        try {
            byte[] bytes = replaceAll.getBytes();
            return bytes.length > 30 ? replaceAll.substring(0, new String(bytes, 0, 30, z[1]).length()) : replaceAll;
        } catch (UnsupportedEncodingException e) {
            d.i(a, e.getMessage());
            return replaceAll;
        }
    }

    private static Set<String> a(ActivityManager activityManager) {
        Set<String> hashSet = new HashSet();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            String[] strArr = runningAppProcessInfo.pkgList;
            for (Object add : strArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    private static JSONArray a(ActivityManager activityManager, PackageManager packageManager) {
        JSONArray jSONArray = new JSONArray();
        Set a = a(activityManager);
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(8192);
        List<RunningServiceInfo> runningServices = activityManager.getRunningServices(200);
        Collections.sort(installedApplications, new DisplayNameComparator(packageManager));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (ApplicationInfo applicationInfo : installedApplications) {
            String a2 = a(applicationInfo.loadLabel(packageManager).toString(), 30);
            if (a.contains(applicationInfo.packageName)) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.service.getPackageName().equals(applicationInfo.packageName)) {
                        JSONObject jSONObject2 = new JSONObject();
                        long round = (long) Math.round((float) ((elapsedRealtime - runningServiceInfo.activeSince) / 1000));
                        try {
                            jSONObject2.put(z[7], runningServiceInfo.service.getShortClassName());
                            jSONObject2.put(z[6], round);
                            jSONArray2.put(jSONObject2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (Throwable th) {
                            d.d(a, new StringBuilder(z[4]).append(th.getMessage()).toString());
                        }
                    }
                }
                try {
                    jSONObject.put(z[8], a2);
                    jSONObject.put(z[5], applicationInfo.packageName);
                    jSONObject.put(z[9], jSONArray2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    public static void a(Context context) {
        d.c(a, z[2]);
        JSONArray a = a((ActivityManager) context.getSystemService(z[3]), context.getPackageManager());
        if (a != null && a.length() != 0) {
            o.a(context, a);
        }
    }
}
