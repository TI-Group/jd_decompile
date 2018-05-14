package cn.jiguang.a.b;

import android.content.Context;
import android.content.SharedPreferences;

public class c {
    private static volatile c b;
    private static final String z;
    private SharedPreferences a = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "C-\f\u0018#Z<&($g\u001b\u0010\f";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0027;
    L_0x000b:
        r3 = r0;
        r4 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0010:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            case 3: goto L_0x003e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r5 = 75;
    L_0x0019:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0010;
    L_0x0025:
        r1 = r0;
        r0 = r3;
    L_0x0027:
        if (r1 > r2) goto L_0x000b;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        return;
    L_0x0035:
        r5 = 9;
        goto L_0x0019;
    L_0x0038:
        r5 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0019;
    L_0x003b:
        r5 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0019;
    L_0x003e:
        r5 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.b.c.<clinit>():void");
    }

    private SharedPreferences a(Context context) {
        if (this.a == null) {
            this.a = context.getSharedPreferences(z, 0);
        }
        return this.a;
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public final long a(Context context, String str, long j) {
        return a(context).getLong(str, j);
    }

    public final String a(Context context, String str, String str2) {
        return a(context).getString(str, null);
    }

    public final void b(Context context, String str, long j) {
        a(context).edit().putLong(str, j).commit();
    }

    public final void b(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).commit();
    }
}
