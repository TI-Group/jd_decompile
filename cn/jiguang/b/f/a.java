package cn.jiguang.b.f;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a {
    public static String a;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "CB|Tawv(I(esM\u0017!W\u0001v^";
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
            case 0: goto L_0x006c;
            case 1: goto L_0x006f;
            case 2: goto L_0x0072;
            case 3: goto L_0x0074;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 76;
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
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "CB|T\u0001w_ae\u0004WVv^";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        z = r4;
        r0 = "CB|T\u0001w_ar\u0004rVh";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0084;
    L_0x0052:
        r3 = r0;
        r4 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x0057:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0077;
            case 1: goto L_0x007a;
            case 2: goto L_0x007d;
            case 3: goto L_0x007f;
            default: goto L_0x005e;
        };
    L_0x005e:
        r5 = 76;
    L_0x0060:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0082;
    L_0x0068:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0057;
    L_0x006c:
        r9 = 58;
        goto L_0x001f;
    L_0x006f:
        r9 = 59;
        goto L_0x001f;
    L_0x0072:
        r9 = 5;
        goto L_0x001f;
    L_0x0074:
        r9 = 45;
        goto L_0x001f;
    L_0x0077:
        r5 = 58;
        goto L_0x0060;
    L_0x007a:
        r5 = 59;
        goto L_0x0060;
    L_0x007d:
        r5 = 5;
        goto L_0x0060;
    L_0x007f:
        r5 = 45;
        goto L_0x0060;
    L_0x0082:
        r1 = r0;
        r0 = r3;
    L_0x0084:
        if (r1 > r2) goto L_0x0052;
    L_0x0086:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.f.a.<clinit>():void");
    }

    public static String a() {
        return new SimpleDateFormat(z[0], Locale.ENGLISH).format(new Date());
    }

    public static String b() {
        return new SimpleDateFormat(z[1], Locale.ENGLISH).format(new Date());
    }
}
