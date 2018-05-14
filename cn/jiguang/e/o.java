package cn.jiguang.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import cn.jiguang.b.a;
import cn.jiguang.b.a.d;
import cn.jiguang.b.d.e;
import java.util.List;

final class o implements Runnable {
    private static final String[] z;
    final /* synthetic */ Context a;
    final /* synthetic */ long b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0011\"1=x-\"8*~#& \u001ci\u0010 9,iB01&`\u00072|,m\f\u001a1:b\u0001>5+_\u00169 ?i\u0006\u00055=z\u000b55oe\u0011v6.`\u00113";
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
            case 0: goto L_0x008c;
            case 1: goto L_0x008f;
            case 2: goto L_0x0092;
            case 3: goto L_0x0095;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 12;
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
        r1 = "\u0016?=*,\f9'u";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "(\u0017'.g\u0007\u0017\u0000\u001fY\u0016?<<,\u0003!1$iB01&`\u00072j";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "!7>hxB%$.~\u0016v?;d\u0007$p?y\u0011>p<i\u0010 9,i\u0011v4:cB\"?oi\u001a55?x\u000b9>u";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "!7>hxB%$.~\u0016v?;d\u0007$p?y\u0011>p<i\u0010 9,i\u0011v4:cB\"?o\u00075%=e\u0016/q";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "57;*Y\u0012\u001c9\by\u000387";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "!9=?c\f3>;B\u0003;5ｕ６";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "!9=?c\f3>;B\u0003;5";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Nv<.\u0016v<.y\f58*hB\"9\"iX";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u000e93.`6?=*,Ov<.\u0016\u001a1:b\u0001>\u0004&a\u0007vmo";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 98;
        goto L_0x0020;
    L_0x008f:
        r9 = 86;
        goto L_0x0020;
    L_0x0092:
        r9 = 80;
        goto L_0x0020;
    L_0x0095:
        r9 = 79;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.o.<clinit>():void");
    }

    o(Context context, long j) {
        this.a = context;
        this.b = j;
    }

    public final void run() {
        int i = 0;
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long l = d.l(this.a);
            cn.jiguang.c.d.c(z[5], new StringBuilder(z[1]).append(currentTimeMillis).append(z[8]).append(l).toString());
            if (-1 == l || Math.abs(currentTimeMillis - l) > this.b) {
                d.a(this.a, currentTimeMillis);
                try {
                    e a = e.a();
                    a.a(this.a);
                    a.b();
                } catch (Exception e) {
                    cn.jiguang.c.d.i(z[5], new StringBuilder(z[2]).append(e).toString());
                }
                if (a.j) {
                    List a2 = n.b(this.a);
                    int size = a2 != null ? a2.size() : 0;
                    while (i < size) {
                        Intent intent = new Intent();
                        intent.setComponent((ComponentName) a2.get(i));
                        if (VERSION.SDK_INT >= 12) {
                            intent.setFlags(32);
                        }
                        ComponentName startService = this.a.startService(intent);
                        if (startService != null) {
                            cn.jiguang.c.d.c(z[7], new StringBuilder(z[6]).append(startService).toString());
                        }
                        i++;
                    }
                    return;
                }
                cn.jiguang.c.d.c(z[5], z[0]);
                return;
            }
            cn.jiguang.c.d.a(z[5], new StringBuilder(z[9]).append(currentTimeMillis - l).toString());
        } catch (SecurityException e2) {
            cn.jiguang.c.d.h(z[5], z[4]);
        } catch (Throwable th) {
            cn.jiguang.c.d.h(z[5], new StringBuilder(z[3]).append(th.getMessage()).toString());
        }
    }
}
