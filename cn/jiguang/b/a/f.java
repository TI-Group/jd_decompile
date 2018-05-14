package cn.jiguang.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

public final class f {
    private static SharedPreferences a;
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "NS\b]\u0018XNN\u0019\u0018_X@R\u001aHSER\u001b\u0003K\u0014\u0019\u001aDY";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0057;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r2;
        r10 = r8;
        r13 = r7;
        r7 = r2;
        r2 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x004b;
            case 1: goto L_0x004e;
            case 2: goto L_0x0051;
            case 3: goto L_0x0054;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002d:
        r7 = r2;
        r2 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r3] = r2;
        r0 = "CX^C7_TB";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r3] = r2;
        z = r6;
        return;
    L_0x004b:
        r11 = 45;
        goto L_0x0021;
    L_0x004e:
        r11 = 61;
        goto L_0x0021;
    L_0x0051:
        r11 = 38;
        goto L_0x0021;
    L_0x0054:
        r11 = 55;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.a.f.<clinit>():void");
    }

    public static synchronized long a() {
        long j;
        synchronized (f.class) {
            if (a == null) {
                j = -1;
            } else {
                j = a.getLong(z[1], -1);
                if (j != -1) {
                    j = a(j);
                    a.edit().putLong(z[1], j).commit();
                }
            }
            if (j == -1) {
                j = a((long) Math.abs(new Random().nextInt(32767)));
                if (a != null) {
                    a.edit().putLong(z[1], j).commit();
                }
            }
        }
        return j;
    }

    private static long a(long j) {
        return (j % 2 == 0 ? 1 + j : j + 2) % 32767;
    }

    public static void a(Context context) {
        if (a == null) {
            a = context.getSharedPreferences(z[0], 0);
        }
    }
}
