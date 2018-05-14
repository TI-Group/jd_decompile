package cn.jiguang.a.a.d.a.a;

import android.app.Instrumentation;
import android.content.Context;
import cn.jiguang.c.d;
import cn.jiguang.d.a;
import java.lang.reflect.Field;

public final class c {
    public static boolean a = true;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "3Uy%f,iz3|*}c?}0";
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
            case 0: goto L_0x006b;
            case 1: goto L_0x006e;
            case 2: goto L_0x0071;
            case 3: goto L_0x0074;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 18;
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
        r1 = "\u0017rd\"`+qr8f?h~9|\u0016sx=28}~:w:&";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "rrr!/";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0017rd\"s2p7\u001f|-he#;rc7f7syvZ1s|v}2x*";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0017rd\"`+qr8f?h~9|\u0016sx=";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0017rd\"`+qr8f?h~9|~tv%27rd\"s2pr2>-w~&";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        r0 = 1;
        a = r0;
        return;
    L_0x006b:
        r9 = 94;
        goto L_0x001f;
    L_0x006e:
        r9 = 28;
        goto L_0x001f;
    L_0x0071:
        r9 = 23;
        goto L_0x001f;
    L_0x0074:
        r9 = 86;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.a.a.c.<clinit>():void");
    }

    public static void a(Context context) {
        try {
            Object a = a.a();
            Field a2 = a.a(a.b(), z[0]);
            Instrumentation instrumentation = (Instrumentation) a.a(a2, a);
            if (d.class.isInstance(instrumentation)) {
                d.c(z[4], z[5]);
                a = false;
                return;
            }
            Object dVar = new d(instrumentation);
            dVar.a(true);
            a.a(a2, a, dVar);
            d.c(z[4], new StringBuilder(z[3]).append(a2).append(z[2]).append(dVar).toString());
            a = false;
        } catch (Exception e) {
            a = true;
            d.a(z[4], new StringBuilder(z[1]).append(e).toString());
        }
    }
}
