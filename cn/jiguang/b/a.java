package cn.jiguang.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jiguang.a.a.c.e;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jiguang.b.b.b;
import cn.jiguang.b.d.c;
import cn.jiguang.b.d.h;
import cn.jiguang.b.d.o;
import cn.jiguang.b.d.s;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import cn.jiguang.service.Protocol;
import cn.jpush.android.service.PushService;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    public static final String a = SdkType.JCORE.name();
    public static boolean b = false;
    public static String c;
    public static String d;
    public static Context e;
    public static String f;
    public static int g;
    public static String h;
    public static boolean i = false;
    public static boolean j = false;
    private static AtomicBoolean k = new AtomicBoolean(false);
    private static ServiceConnection l = new b();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 36;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "&n\n~T&h3u\u001c";
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
            case 0: goto L_0x01ca;
            case 1: goto L_0x01ce;
            case 2: goto L_0x01d1;
            case 3: goto L_0x01d5;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 38;
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
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            case 34: goto L_0x01a5;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u001fB3iC\u0012m3yG9";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0012d(;U1j|mC'r5tHug=rJtZ菫反U1j爔朷夗走 \u0001";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0000o9cV0b(~Bo!:zO9d8;R:!;~Rub)iT0o(;G%q0rE4u5tHuh2}I";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u001bN|vC!`|G!`|C3h2~Buh2;K4o5}C&ur";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "0s.tT6n8~\u001cd1l#\n\u001co*zJ<e|zV%J9b\u0006o!";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "8d(zB4u=!\u00066i=uH0m|6\u0006";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001fQ\tHn\nB\u0014Zh\u001bD\u0010";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "y!\fwC4r9;A0u|bI s|ZV%j9b\u00063s3v\u0006\u001fH\u001bNg\u001bF|lC7!?tH&n0~\u0007";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "8d(zB4u=!\u0006\u001fB3iCu`,km0x|6\u0006;n(;B0g5uC1!5u\u00068`2r@0r(";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "8d(zB4u=!\u00064q,PC,!q;";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "8d(zB4u=!\u0006\u0016`2;H:u||C!!1~R4E=oGug.tKu@,kJ<b=oO:o\u0015u@:";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "8d(zB4u=!\u00066i=uH0m|6\u0006;n(;B0g5uC1!5u\u00068`2r@0r(";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u001fQ\tHn\n@\fKm\u0010X";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "6s=hN\nm3|";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u001fB3iCu//t\u00063h0~\u00061n|uI!!1zR6i|Qe:s9;\b?`.;@<m9;O;!(sCuq.tL0b(7\u0006\u0013`5wC1!(t\u0006<o5o\u0006\u001fB3iC";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "3`0hC";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u0007d1tR0!\u000f~T#h?~\u0006:o|yO;e5uA{/r";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u001fB3iCub=uH:u|yCuh2rR<`0r\\0e|xI8q0~R0m%;B d|oIuO\tWju`,ko;g35";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "2d(;K\u0014q,wO6`(rI;O=vCud.iI';";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0006d.mO6d\u0014~J%d.";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "4b(rI;;5uO!!q;U1j\n~T&h3u\u001cd/m5\u0010y!>nO9e\u0015\u001cd4n";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "!s)~";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = ";t0w";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "?`*z\b;d(5V'd:~T\u001cQ*/u!`?p";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "'d,tT!/9cR'`rrH3n";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "6orqV r45G;e.tO1/5uR0o(5t\u0010Q\u0013Ir";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "\u0002d|}I o8;R=d|zV%J9b\u0006<r|xN4o;~B{!\u000brJ9!.~\u000b'd;rU!d.5";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u0007d1tR0!\u000f~T#h?~\u00067h2\u00063`5wC1";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "4b(rI;";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u0007d1tR0!\u000f~T#h?~\u00067h2\u00063`5wC1!?zS&d8;D,!\u000f~E s5o_\u0010y?~V!h3u\u0007";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "4b(rI;;5uO!!q;u0s*rE0";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u001bN|mC'r5tH\u0016n8~\u0006:s|mC'r5tH\u001b`1~\u00061d:rH0e|rHul=uO3d/o\b";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "'d,tT!";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "?`*z\b;d(5V'd:~T\u001cQ*-g1e.~U&d/";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u0005t/su0s*rE0!4zUuc9~Huc5uBy!;rP0!)k\u0006;n+";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        z = r4;
        r0 = cn.jiguang.api.SdkType.JCORE;
        r0 = r0.name();
        a = r0;
        r0 = 0;
        b = r0;
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r1 = 0;
        r0.<init>(r1);
        k = r0;
        r0 = 0;
        i = r0;
        r0 = 0;
        j = r0;
        r0 = new cn.jiguang.b.b;
        r0.<init>();
        l = r0;
        return;
    L_0x01ca:
        r9 = 85;
        goto L_0x0020;
    L_0x01ce:
        r9 = 1;
        goto L_0x0020;
    L_0x01d1:
        r9 = 92;
        goto L_0x0020;
    L_0x01d5:
        r9 = 27;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.a.<clinit>():void");
    }

    private static boolean a() {
        int GetSdkVersion;
        UnsatisfiedLinkError e;
        try {
            GetSdkVersion = Protocol.GetSdkVersion();
            try {
                d.a(z[1], new StringBuilder(z[0]).append(GetSdkVersion).toString());
            } catch (UnsatisfiedLinkError e2) {
                e = e2;
                d.j(z[1], z[2]);
                e.printStackTrace();
                return GetSdkVersion >= 100;
            }
        } catch (UnsatisfiedLinkError e3) {
            e = e3;
            GetSdkVersion = 0;
            d.j(z[1], z[2]);
            e.printStackTrace();
            if (GetSdkVersion >= 100) {
            }
        }
        if (GetSdkVersion >= 100) {
        }
    }

    public static synchronized boolean a(Context context) {
        boolean z = true;
        synchronized (a.class) {
            if (!k.get()) {
                d.c(z[1], z[31]);
                Context applicationContext = context.getApplicationContext();
                e = applicationContext;
                BasePreferenceManager.init(applicationContext);
                cn.jiguang.b.a.d.a(e);
                if (cn.jiguang.e.a.q(e)) {
                    h.a();
                    e.a().a(context.getApplicationContext());
                    BasePreferenceManager.init(context.getApplicationContext());
                    s.a(context);
                    d.d(z[1], z[21]);
                    if (a()) {
                        c = context.getPackageName();
                        ApplicationInfo c = c(context);
                        if (c == null) {
                            d.j(z[1], z[18]);
                            z = false;
                        } else {
                            String str;
                            try {
                                d = context.getPackageManager().getApplicationLabel(c).toString();
                            } catch (Throwable th) {
                                d.d(z[1], new StringBuilder(z[19]).append(th.getMessage()).toString());
                            }
                            try {
                                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                                g = packageInfo.versionCode;
                                str = packageInfo.versionName;
                                h = str;
                                if (str.length() > 30) {
                                    h = h.substring(0, 30);
                                }
                            } catch (Throwable th2) {
                                d.d(z[1], z[32]);
                            }
                            if (b(context)) {
                                Context context2;
                                String s = cn.jiguang.b.a.a.s();
                                if (!(j.a(s) || z[23].equals(s) || s.equalsIgnoreCase(cn.jiguang.b.a.d.i(context)))) {
                                    d.d(z[20], z[27]);
                                    cn.jiguang.b.a.d.h(context);
                                    o.a(context);
                                }
                                if (VERSION.SDK_INT == 8) {
                                    System.setProperty(z[24], z[22]);
                                    System.setProperty(z[34], z[16]);
                                }
                                k.set(true);
                                b.b();
                                if (cn.jiguang.e.a.p(e)) {
                                    context2 = e;
                                    if (cn.jiguang.e.a.a.c()) {
                                        d.c(z[1], z[35]);
                                    } else {
                                        Intent intent = new Intent();
                                        intent.setClass(context2, PushService.class);
                                        try {
                                            if (context2.bindService(intent, l, 1)) {
                                                d.a(z[1], z[17]);
                                            } else {
                                                d.a(z[1], z[28]);
                                            }
                                        } catch (SecurityException e) {
                                            d.h(z[1], z[30]);
                                        }
                                    }
                                }
                                context2 = context.getApplicationContext();
                                str = z[14];
                                Bundle bundle = new Bundle();
                                bundle.putString(z[29], z[26]);
                                bundle.putString(z[33], str);
                                bundle.putString(z[25], "");
                                JCoreInterface.sendAction(context2, a, bundle);
                            } else {
                                z = false;
                            }
                        }
                    } else {
                        d.j(z[1], z[15]);
                        z = false;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    private static boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    String string = bundle.getString(z[13]);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(f) && f.equals(string)) {
                        return f.length() == 24;
                    } else {
                        f = string;
                        f = string.toLowerCase(Locale.getDefault());
                        cn.jiguang.b.a.d.b(context, f);
                        d.d(z[1], new StringBuilder(z[10]).append(f).toString());
                        String c = j.c(bundle.getString(z[7]));
                        if (j.a(c)) {
                            d.d(z[1], z[12]);
                        } else {
                            d.d(z[1], new StringBuilder(z[6]).append(c).toString());
                            cn.jiguang.b.a.a.e(c);
                        }
                        if (j.a(f)) {
                            d.j(z[1], z[9]);
                            c.a(e, 10001, false);
                            cn.jiguang.b.a.a.a(context, 10001);
                            return false;
                        } else if (f.length() == 24) {
                            return true;
                        } else {
                            d.j(z[1], new StringBuilder(z[5]).append(f).append(z[8]).toString());
                            c.a(e, (int) PointerIconCompat.TYPE_TEXT, false);
                            cn.jiguang.b.a.a.a(context, (int) PointerIconCompat.TYPE_TEXT);
                            return false;
                        }
                    }
                }
                d.d(z[1], z[4]);
                return false;
            }
            d.d(z[1], z[11]);
            return false;
        } catch (Throwable th) {
            d.d(z[1], z[3], th);
            return false;
        }
    }

    private static ApplicationInfo c(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            d.f(z[1], z[3], th);
            return null;
        }
    }
}
