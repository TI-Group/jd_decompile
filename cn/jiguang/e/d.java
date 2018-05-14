package cn.jiguang.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.a.a.c.g;
import cn.jiguang.a.a.c.j;
import cn.jiguang.b.a.a;
import cn.jiguang.b.d.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 18;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "=A)h\u00155V$";
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
            case 0: goto L_0x00e4;
            case 1: goto L_0x00e8;
            case 2: goto L_0x00ec;
            case 3: goto L_0x00f0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 99;
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
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = ";G)Q\u0002?I<f\u0006\u0015L;nC9P/n\u0011|\u0018}";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001dR-R\u0017=V\bu\n0Q";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = ",Q";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "2C0d";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "5L.u\u00020N\u0002u\u001a,G";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "*G/^\u00003F8";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = ",W)!\",R}K0\u0013l}D\u0011.M/;";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = ",I:";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "*G/^\r=O8";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "sQ$r\u00179Or";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = ";G)H\r/V<m\u000f\b[-dC9P/n\u0011f";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "5V4l\u0006";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "([-d";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "=R-^\u0011)L3h\r;";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = ".G-n\u0011(\u0002\u0017R,\u0012\u0002\u0018s\u00113P};C";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = ",P2b\u0006/Q";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "=R-";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00e4:
        r9 = 92;
        goto L_0x0020;
    L_0x00e8:
        r9 = 34;
        goto L_0x0020;
    L_0x00ec:
        r9 = 93;
        goto L_0x0020;
    L_0x00f0:
        r9 = 1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.d.<clinit>():void");
    }

    public static int a(ApplicationInfo applicationInfo) {
        Object obj = null;
        if (applicationInfo == null) {
            return -1;
        }
        try {
            if (((applicationInfo.flags & 1) != 0 ? 1 : null) != null) {
                if ((applicationInfo.flags & 128) != 0) {
                    obj = 1;
                }
                return obj != null ? 2 : 1;
            } else {
                Object obj2 = applicationInfo.sourceDir;
                return !TextUtils.isEmpty(obj2) ? obj2.startsWith(z[10]) ? 3 : !applicationInfo.sourceDir.contains(applicationInfo.packageName) ? 3 : 0 : -1;
            }
        } catch (Throwable th) {
            cn.jiguang.c.d.a(z[2], new StringBuilder(z[11]).append(th.getMessage()).toString());
            return -1;
        }
    }

    public static ApplicationInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            return null;
        }
    }

    private static List<e> a(int i) {
        List<String> a = a.a(new String[]{z[3]});
        List<e> arrayList = new ArrayList();
        if (a == null || a.isEmpty()) {
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        Map a2 = e.a((String) a.remove(0));
        for (String a3 : a) {
            e a4 = e.a(a3, a2);
            if (a4 != null) {
                if (i == 3 || !a4.a()) {
                    if (!z[3].equals(a4.a)) {
                        arrayList.add(a4);
                    }
                } else if (a4.b()) {
                    hashSet.add(a4.c);
                }
            }
        }
        if (i != 1 || hashSet.isEmpty()) {
            return arrayList;
        }
        List<e> arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 == 0) {
            Iterator it = arrayList.iterator();
            i2 = 1;
            while (it.hasNext()) {
                int i3;
                a4 = (e) it.next();
                if (hashSet.contains(a4.d)) {
                    arrayList2.add(a4);
                    hashSet.add(a4.c);
                    it.remove();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                i2 = i3;
            }
        }
        return arrayList2;
    }

    private static List<g> a(Context context) {
        Map hashMap = new HashMap();
        for (e eVar : a(1)) {
            g b = b(context, eVar.a);
            if (b != null) {
                hashMap.put(b.b, b);
            }
        }
        return new ArrayList(hashMap.values());
    }

    private static JSONArray a(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        for (g gVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(z[4], gVar.a);
                jSONObject.put(z[8], j.a(gVar.b, 128));
                jSONObject.put(z[9], gVar.c);
                jSONObject.put(z[6], gVar.d);
                jSONObject.put(z[5], gVar.e);
                jSONArray.put(jSONObject);
            } catch (Throwable th) {
                cn.jiguang.c.d.e(z[2], new StringBuilder(z[7]).append(th.getMessage()).toString());
            }
        }
        return jSONArray;
    }

    public static void a(Context context, int i, int i2) {
        JSONArray a;
        JSONArray jSONArray;
        if (i2 > 0) {
            try {
                List<e> a2 = a(i2);
                jSONArray = new JSONArray();
                for (e a3 : a2) {
                    JSONObject a4 = a3.a(128);
                    if (a4 != null) {
                        jSONArray.put(a4);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.c.d.e(z[2], new StringBuilder(z[15]).append(th.getMessage()).toString());
                return;
            }
        }
        jSONArray = null;
        if (i > 0) {
            a = a(VERSION.SDK_INT < 21 ? b(context) : a(context));
        } else {
            a = null;
        }
        JSONObject jSONObject = new JSONObject();
        if (a != null && a.length() > 0) {
            jSONObject.put(z[17], a);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObject.put(z[16], jSONArray);
        }
        if (jSONObject.length() > 0) {
            jSONObject.put(z[12], a.q());
            jSONObject.put(z[13], z[14]);
            o.a(context, jSONObject);
        }
    }

    private static g b(Context context, String str) {
        try {
            PackageInfo c = c(context, str);
            if (c == null) {
                return null;
            }
            String charSequence = c.applicationInfo.loadLabel(context.getPackageManager()).toString();
            g gVar = new g();
            gVar.a = j.a(charSequence, 30);
            gVar.b = c.packageName;
            gVar.d = c.versionCode;
            gVar.c = c.versionName;
            gVar.e = a(c.applicationInfo);
            return gVar;
        } catch (Throwable th) {
            cn.jiguang.c.d.e(z[2], new StringBuilder(z[1]).append(th.getMessage()).toString());
            return null;
        }
    }

    private static List<g> b(Context context) {
        List<g> arrayList = new ArrayList();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(z[0])).getRunningAppProcesses();
        Object hashSet = new HashSet();
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            String[] strArr = runningAppProcessInfo.pkgList;
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(hashSet, strArr);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            g b = b(context, (String) it.next());
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private static PackageInfo c(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable th) {
        }
        return packageInfo;
    }
}
