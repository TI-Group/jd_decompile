package cn.jiguang.b.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.PushReceiver;
import java.io.File;

public final class b {
    public static int a = -1;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 11;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "?X\u0007`\rH\u0019q\u0010x\rD%\u0012yY*p\u0007L_\u0006f\u0010o^'d\u0018y\r\u000fd\u001cpH\r?";
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
            case 0: goto L_0x009a;
            case 1: goto L_0x009d;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00a4;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "Vn\u0006w\u0010OH\u001bs\u001cH<q\u001cp^";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "}N\u001dl\u0003uY\u0010";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "oH\u001d%%i^\u0001*4pL\u001bhUNH\n`\u001cjH\u001b%\u0011u^\bg\u0019yI";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "oH\u001d%%i^\u0001*4pL\u001bhUNH\n`\u001cjH\u001b%\u0010rL\u000bi\u0010x";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "oH\u001dU\u0000oE;`\u0016yD\u001f`\u0007YC\bg\u0019y\r\fw\u0007s_S";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "E\ff\u001eOH\u001bs\u001cH/l\u0019y\r\u001dl\u0018yB\u001cqU!\r";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "2^\fw\u0003uN\fv\u0014jH/l\u0019y";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "E\ff\u001eOH\u001bs\u001cH/l\u0019y\r\f}\u0016y]\u001dl\u001ar\u0003G+";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "V}\u001cv\u001d<D\u0007l\u0001<N\bk'iC9p\u0006t~\fw\u0003uN\f%O";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "_\fd\u0001y\r\nm\u0010FIc\u001cpHIc\u0014uA\faY<H\u001bw\u001an\u0017";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        z = r4;
        r0 = -1;
        a = r0;
        return;
    L_0x009a:
        r9 = 28;
        goto L_0x0020;
    L_0x009d:
        r9 = 45;
        goto L_0x0020;
    L_0x00a0:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
    L_0x00a4:
        r9 = 5;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.b.<clinit>():void");
    }

    public static void a(Context context) {
        try {
            new d(context).start();
        } catch (Throwable th) {
            d.i(z[1], new StringBuilder(z[10]).append(th).toString());
        }
    }

    public static void a(Context context, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context.getApplicationContext(), PushReceiver.class);
            ComponentName componentName2 = new ComponentName(context.getApplicationContext(), AlarmReceiver.class);
            if (z) {
                d.d(z[1], z[4]);
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                packageManager.setComponentEnabledSetting(componentName2, 1, 1);
                a.h(context.getApplicationContext());
                return;
            }
            d.d(z[1], z[3]);
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
            packageManager.setComponentEnabledSetting(componentName2, 2, 1);
            a.i(context.getApplicationContext());
            a.r(context);
        } catch (Throwable th) {
            d.g(z[1], new StringBuilder(z[5]).append(th.getMessage()).toString());
        }
    }

    public static boolean a() {
        return a == 0;
    }

    public static String b(Context context) {
        try {
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(z[2])).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
            d.c(z[1], new StringBuilder(z[0]).append(th.getMessage()).toString());
        }
        return "";
    }

    public static void b() {
        cn.jiguang.b.f.d.a().a(new c());
    }

    static /* synthetic */ void c(Context context) {
        if (a.p(context)) {
            int i = 10;
            while (i > 0) {
                try {
                    File file = new File(context.getFilesDir(), z[7]);
                    d.a(z[1], new StringBuilder(z[6]).append(i).toString());
                    if (file.exists()) {
                        a = 1;
                        break;
                    } else {
                        i--;
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    a = 1;
                } catch (Exception e2) {
                    d.c(z[1], z[8]);
                    a = 1;
                }
            }
            if (a == -1) {
                a = 0;
            }
            d.a(z[1], new StringBuilder(z[9]).append(a).toString());
            return;
        }
        a = 0;
    }

    public static boolean c() {
        return a == 1;
    }
}
