package cn.jiguang.b.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.a.c.c;
import cn.jiguang.b.b.b;
import cn.jiguang.c.d;

final class k extends Handler {
    private static final String[] z;
    final /* synthetic */ j a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "&\u001720\u00113\u0007bs\u0015=\u0007'0\u001b+T7c\u001c ";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0068;
            case 1: goto L_0x006b;
            case 2: goto L_0x006e;
            case 3: goto L_0x0071;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "!\u0011,tY:\u0016br\u0000r\u001c#~\u001d>\u00110";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001a\u0011#b\r\u0010\u0011#d17\u00182u\u000b";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u001c!\u000e\\Y\u0011\u001b,d\u001c*\u0000";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = ";\u0007b~\u0016&T2e\n:T-bY;\u0019";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "!\u00110f\u00101\u0011bs\u0018<T0e\u0017~\u0003+|\u0015r\u00011uY3\u0018#b\u0014\u0000\u0011!u\u0010$\u001100\r=T1u\u00176T*r";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0068:
        r9 = 82;
        goto L_0x001f;
    L_0x006b:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x001f;
    L_0x006e:
        r9 = 66;
        goto L_0x001f;
    L_0x0071:
        r9 = 16;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.k.<clinit>():void");
    }

    k(j jVar, Looper looper) {
        this.a = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 8000:
                j jVar = this.a;
                Context a = this.a.c;
                if (a == null) {
                    d.g(z[2], z[3]);
                } else {
                    c.e(a);
                    if (!h.a().g()) {
                        d.c(z[2], z[4]);
                    } else if (cn.jiguang.b.a.d.k(a)) {
                        d.a(z[2], z[0]);
                    } else if (b.c()) {
                        d.a(z[2], z[5]);
                    } else {
                        d.c(z[2], z[1]);
                        j.b(a);
                    }
                }
                this.a.c.getApplicationContext();
                j.b();
                return;
            default:
                return;
        }
    }
}
