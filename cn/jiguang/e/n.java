package cn.jiguang.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.a;
import cn.jiguang.c.d;
import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.List;

public final class n {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 17;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0010\fH\u000f.$\fH\u0018-\u0016\u0016y\u0003\u0016\u0007\u0005_\u0018e\u0016\u0016_\u00037I";
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
            case 0: goto L_0x00d9;
            case 1: goto L_0x00dd;
            case 2: goto L_0x00e1;
            case 3: goto L_0x00e5;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 69;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0010\n\u0003\u00065\u0006\u0017EB$\u001d\u0000_\u0003,\u0017J^\t7\u0005\rN\tk#\u0011^\u0004\u0016\u0016\u0016[\u0005&\u0016";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "]D}\u00196\u001b7H\u001e3\u001a\u0007HV";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "]\u0014H\u001e(\u001a\u0017^\u0005*\u001dJg<\u0010 ,r!\u0000 7l+\u0000";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0003\u000fJ!$\u001d\u0005J\t7S\r^L+\u0006\bAL*\u0001D]\r&\u0018\u0005J\t\u000b\u0012\tHL2\u0012\u0017\r\t(\u0003\u0010T";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "(\u0007E\t&\u00183E\t1\u001b\u0001_8* \u0010L\u001e1.D\u0000L5\u0016\u0016@\u00056\u0000\rB\u0002";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "0\u0005CL+\u001c\u0010\r\u000b \u0007DL\u001c5\u001f\rN\r1\u001a\u000bCL,\u001d\u0002BL2\u001a\u0010EL5\u0012\u0007F\r\"\u0016DC\r(\u0016D\u0017L";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "94x?\r,%}<\u000e6=";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001d\u0011A\u0000";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "$\u0005F\t\u0010\u0003.D+0\u0012\nJ";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "]DL\u001c5\u0018\u0001TV";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0015\rA\u0018 \u0001%A\u0000\u0001\u0012\u0001@\u0003+ \u0001_\u001a,\u0010\u0001\rAe\u0010\u000bC\u0018 \u000b\u0010\r\u001b$\u0000DC\u0019)\u001f";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0012\u0007Y\u0005*\u001dD\u0000L#\u001a\bY\t7S\u0005A\u0000e7\u0005H\u0001*\u001d7H\u001e3\u001a\u0007H";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "'\u000b\r\u001f1\u0012\u0016YL\u0006\u001c\t]\u0003+\u0016\nYVe";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0015\rA\u0018 \u0001%A\u0000\u0001\u0012\u0001@\u0003+ \u0001_\u001a,\u0010\u0001\r\t7\u0001\u000b_V";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "5\u0005D\u0000e\u0007\u000b\r\u001f1\u0012\u0016YL*\u0007\fH\u001ee\u0012\u0014]L&\u0012\u0011^\t!S\u0006TL\n\u0006\u0010b\n\b\u0016\tB\u001e<]";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "2\u0007Y\u0005*\u001dD\u0000L6\u0007\u0005_\u0018\n\u0007\fH\u001e\u0004\u0003\u0014~\t7\u0005\rN\t";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00d9:
        r9 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x0020;
    L_0x00dd:
        r9 = 100;
        goto L_0x0020;
    L_0x00e1:
        r9 = 45;
        goto L_0x0020;
    L_0x00e5:
        r9 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.n.<clinit>():void");
    }

    public static void a(Context context, long j) {
        try {
            d.c(z[9], z[16]);
            new Thread(new o(context, j)).start();
        } catch (OutOfMemoryError e) {
            d.g(z[9], z[15]);
        }
    }

    private static boolean a(PackageManager packageManager, String str) {
        if (packageManager == null || TextUtils.isEmpty(str)) {
            d.c(z[9], z[4]);
            return false;
        }
        try {
            int checkPermission = packageManager.checkPermission(str + z[3], str);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object string = applicationInfo.metaData.getString(z[7]);
                Intent intent = new Intent();
                intent.setClassName(str, z[1]);
                List queryIntentServices = packageManager.queryIntentServices(intent, 0);
                d.e(z[9], new StringBuilder(z[5]).append(checkPermission).append(z[10]).append(string).append(z[2]).append(queryIntentServices == null ? z[8] : Integer.valueOf(queryIntentServices.size())).toString());
                if (!(checkPermission != 0 || queryIntentServices == null || queryIntentServices.size() == 0 || TextUtils.isEmpty(string) || string.length() != 24)) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            d.g(z[9], new StringBuilder(z[6]).append(str).toString());
            return false;
        } catch (Throwable th) {
            d.g(z[9], new StringBuilder(z[0]).append(th).toString());
            return false;
        }
    }

    private static List<ComponentName> b(Context context) {
        d.c(z[9], z[12]);
        if (context == null) {
            d.g(z[9], z[11]);
            return null;
        }
        List<ComponentName> arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(JCoreInterface.a);
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() == 0) {
                return null;
            }
            for (int i = 0; i < queryIntentServices.size(); i++) {
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(i)).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!(str == null || str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !serviceInfo.exported || !serviceInfo.enabled || a.c.equals(str2) || !a(packageManager, str2))) {
                    d.c(z[9], new StringBuilder(z[13]).append(str2).append(HttpUtils.PATHS_SEPARATOR).append(str).append("}").toString());
                    arrayList.add(new ComponentName(str2, str));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            d.d(z[9], new StringBuilder(z[14]).append(th.getMessage()).toString());
        }
    }
}
