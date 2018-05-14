package cn.jiguang.b.d;

import android.content.Context;
import cn.jiguang.c.d;

public final class r {
    private static final String[] z;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = 77;
        r1 = 0;
        r2 = 1;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "T:&O\"v:";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000d:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0060;
    L_0x0014:
        r8 = r1;
    L_0x0015:
        r9 = r3;
        r10 = r8;
        r14 = r7;
        r7 = r3;
        r3 = r14;
    L_0x001a:
        r13 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0056;
            case 1: goto L_0x0058;
            case 2: goto L_0x005b;
            case 3: goto L_0x005d;
            default: goto L_0x0021;
        };
    L_0x0021:
        r11 = r12;
    L_0x0022:
        r11 = r11 ^ r13;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002e;
    L_0x002a:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x001a;
    L_0x002e:
        r7 = r3;
        r3 = r9;
    L_0x0030:
        if (r7 > r8) goto L_0x0015;
    L_0x0032:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0051;
            default: goto L_0x003e;
        };
    L_0x003e:
        r5[r4] = r3;
        r0 = "U<(\u0001;d&>H\"o\u001a,L(!=>\u0001#n mW,m=)\rmQ8(@>dt.I(b?mX\"t&m`#e&\"H)L5#H+d'9\u000f5l8";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000d;
    L_0x0047:
        r5[r4] = r3;
        r3 = 2;
        r0 = "R1?W$b1\u0005D!q1?";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r5[r4] = r3;
        z = r6;
        return;
    L_0x0056:
        r11 = r2;
        goto L_0x0022;
    L_0x0058:
        r11 = 84;
        goto L_0x0022;
    L_0x005b:
        r11 = r12;
        goto L_0x0022;
    L_0x005d:
        r11 = 33;
        goto L_0x0022;
    L_0x0060:
        r8 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.r.<clinit>():void");
    }

    public static String a(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str.length() <= 30) {
                return str;
            }
            d.j(z[2], z[1]);
            return str.substring(0, 30);
        } catch (Throwable th) {
            return z[0];
        }
    }
}
