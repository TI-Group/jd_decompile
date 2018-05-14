package cn.jiguang.b.a;

import android.content.Context;
import cn.jiguang.android.ShareValues;
import cn.jiguang.b.b.a;
import cn.jiguang.b.b.g;
import cn.jiguang.e.a.b;
import cn.jiguang.e.j;
import java.io.Serializable;

public final class d extends b {
    private static volatile d b;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 15;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "kk.nZjQ9wIdk!";
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
            case 0: goto L_0x00c3;
            case 1: goto L_0x00c7;
            case 2: goto L_0x00cb;
            case 3: goto L_0x00cf;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 57;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "|j3XOj|+nVaQ";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "f}\u0007sZQ;kV|k";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "la6i\\lz1i^P},fMj";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "z~4hXkQ;uX|f";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "kk.dPjQ1cfhk6bKnz=c";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "kk.nZjQ(fJ|y7u]";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "kk.nZjQ*b^f},uX{g7iffj";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "mo;lLQ*bI`|,XXkj*";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "|k+tP``\u0007n]";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "|k*qPlk+XUn{6dQjj\u0007sPbk";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "B{4sPLa5jz``>n^|";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "l|=fMj.1iJ{o6d\\/h9nUjjxdXz}=c\u0019mwx=\u0019la6s\\wzxnJ/`-kU";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "l`vmIz}0)Xaj*hPk -t\\} (uVig4b";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "kk.nZjQ-n]";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00c3:
        r9 = 15;
        goto L_0x0020;
    L_0x00c7:
        r9 = 14;
        goto L_0x0020;
    L_0x00cb:
        r9 = 88;
        goto L_0x0020;
    L_0x00cf:
        r9 = 7;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.a.d.<clinit>():void");
    }

    private d(Context context) {
        super(context, z[13]);
    }

    public static int a() {
        return n(null) ? ((Integer) b.b(z[9], Integer.valueOf(0), 3)).intValue() : 0;
    }

    public static void a(Context context) {
        b dVar = new d(context);
        b = dVar;
        b.a(dVar);
    }

    public static void a(Context context, int i) {
        if (n(context)) {
            b.a(z[9], Integer.valueOf(i), 3);
        }
    }

    public static void a(Context context, long j) {
        if (n(context)) {
            b.a(z[10], Long.valueOf(j), 2);
        }
    }

    public static void a(Context context, long j, String str) {
        if (n(context)) {
            b.b(new ShareValues().b(z[14], Long.valueOf(j)).a(z[6], str), 3);
            a.g(i(context));
        }
    }

    public static void a(Context context, long j, String str, String str2, String str3) {
        if (n(context)) {
            ShareValues a = new ShareValues().b(z[14], Long.valueOf(j)).a(z[6], str).a(z[7], str2);
            if (!j.a(str3)) {
                a.a(z[5], str3);
            }
            b.b(a, 3);
            a.g(i(context));
        }
    }

    public static void a(Context context, ShareValues shareValues) {
        if (n(context)) {
            b.b(shareValues, 2);
        }
    }

    public static void a(Context context, a aVar) {
        if (n(context)) {
            b.a(z[3], aVar.name(), 2);
        }
    }

    public static <T extends Serializable> void a(Context context, String str, T t) {
        if (n(context)) {
            b.a(str, t, 2);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (n(context)) {
            b.a(new StringBuilder(z[1]).append(str).toString(), str2, 2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (n(context)) {
            b.b(new ShareValues().b(z[7], str).b(z[5], str2).b(z[0], str3).b(z[8], str4).b(z[3], str5), 3);
        }
    }

    public static void a(Context context, boolean z) {
        if (n(context)) {
            b.a(z[4], Boolean.valueOf(z), 2);
        }
    }

    public static void a(String str) {
        if (n(null)) {
            b.a(z[8], str, 2);
        }
    }

    public static boolean a(Context context, String str) {
        return n(context) ? b.a(z[5], str, 3) : false;
    }

    public static ShareValues b(Context context, ShareValues shareValues) {
        return n(context) ? b.d(shareValues, 2) : shareValues;
    }

    public static <T extends Serializable> T b(Context context, String str, T t) {
        return n(context) ? b.b(str, t, 2) : t;
    }

    public static void b(Context context) {
        if (n(context)) {
            b.m(context);
        }
    }

    public static void b(Context context, String str) {
        if (n(context)) {
            b.a(z[0], str, 3);
        }
    }

    public static void b(Context context, boolean z) {
        if (n(context)) {
            b.a(z[2], Boolean.valueOf(z), 3);
        }
    }

    public static boolean b() {
        return n(null) ? ((Boolean) b.b(z[4], Boolean.valueOf(true), 2)).booleanValue() : false;
    }

    public static String c() {
        return n(null) ? (String) b.b(z[8], "", 2) : "";
    }

    public static String c(Context context) {
        return n(context) ? (String) b.b(z[7], "", 3) : "";
    }

    public static String c(Context context, String str) {
        return n(context) ? (String) b.b(new StringBuilder(z[1]).append(str).toString(), "", 2) : "";
    }

    public static String d(Context context) {
        return n(context) ? (String) b.b(z[5], "", 3) : "";
    }

    public static boolean d() {
        if (cn.jiguang.e.a.a.b() != null) {
            try {
                return cn.jiguang.e.a.a.b().a();
            } catch (Exception e) {
            }
        }
        return g.a.get() != 0;
    }

    public static long e(Context context) {
        return n(context) ? ((Long) b.b(z[14], Long.valueOf(0), 3)).longValue() : 0;
    }

    public static boolean f(Context context) {
        return e(context) > 0 && !j.a(c(context));
    }

    public static String g(Context context) {
        return n(context) ? (String) b.b(z[6], "", 3) : "";
    }

    public static void h(Context context) {
        if (n(context)) {
            b.b(new ShareValues().b(z[14], Long.valueOf(0)).a(z[6], "").a(z[7], "").a(z[5], ""), 3);
            a.g(null);
        }
    }

    public static String i(Context context) {
        return n(context) ? (String) b.b(z[0], "", 3) : "";
    }

    public static a j(Context context) {
        return n(context) ? a.valueOf((String) b.b(z[3], a.b.name(), 2)) : a.b;
    }

    public static boolean k(Context context) {
        return n(context) ? ((Boolean) b.b(z[2], Boolean.valueOf(false), 3)).booleanValue() : false;
    }

    public static long l(Context context) {
        return n(context) ? ((Long) b.b(z[10], Long.valueOf(-1), 2)).longValue() : -1;
    }

    private static boolean n(Context context) {
        if (b != null) {
            return true;
        }
        Context applicationContext = context != null ? context.getApplicationContext() : cn.jiguang.b.a.e;
        if (context != null) {
            a(applicationContext);
        }
        if (b != null) {
            return true;
        }
        cn.jiguang.c.d.h(z[11], z[12]);
        return false;
    }
}
