package cn.jiguang.a.a.c;

import android.content.Context;
import cn.jiguang.b.a.d;
import cn.jiguang.b.d.p;

final class c implements p {
    private static final String z;
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "\u0010$,PN\u000e /Kc\b\u001a;Ag\u0015&:{x\u0012#0";
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
        r5 = 17;
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
        r5 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        goto L_0x0019;
    L_0x0038:
        r5 = 69;
        goto L_0x0019;
    L_0x003b:
        r5 = 95;
        goto L_0x0019;
    L_0x003e:
        r5 = 36;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.c.<clinit>():void");
    }

    c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void a(int i) {
        if (i == 0) {
            b.b(this.a, this.b);
            d.a(this.a, z, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
