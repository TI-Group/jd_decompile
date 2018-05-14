package cn.jiguang.a.a.d.a.a;

import android.os.Handler;
import android.os.Looper;
import cn.jiguang.d.c;

public final class a {
    private static Object a;
    private static Class b = null;
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
        r12 = 82;
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "1\u0015BE7<\u0014qT&;\u0016YC+\u0006\bBR36";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000d:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x005a;
    L_0x0014:
        r8 = r1;
    L_0x0015:
        r9 = r2;
        r10 = r8;
        r14 = r7;
        r7 = r2;
        r2 = r14;
    L_0x001a:
        r13 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x004f;
            case 1: goto L_0x0051;
            case 2: goto L_0x0054;
            case 3: goto L_0x0057;
            default: goto L_0x0021;
        };
    L_0x0021:
        r11 = r12;
    L_0x0022:
        r11 = r11 ^ r13;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002e;
    L_0x002a:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x001a;
    L_0x002e:
        r7 = r2;
        r2 = r9;
    L_0x0030:
        if (r7 > r8) goto L_0x0015;
    L_0x0032:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            default: goto L_0x003e;
        };
    L_0x003e:
        r5[r3] = r2;
        r0 = "3\u000eTE=;\u0004\u001eV\"\"NqT&;\u0016YC+\u0006\bBR36";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000d;
    L_0x0047:
        r5[r3] = r2;
        z = r6;
        r0 = 0;
        b = r0;
        return;
    L_0x004f:
        r11 = r12;
        goto L_0x0022;
    L_0x0051:
        r11 = 96;
        goto L_0x0022;
    L_0x0054:
        r11 = 48;
        goto L_0x0022;
    L_0x0057:
        r11 = 55;
        goto L_0x0022;
    L_0x005a:
        r8 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.a.a.a.<clinit>():void");
    }

    public static final synchronized Object a() {
        Object a;
        synchronized (a.class) {
            if (a == null) {
                a = c.a(b(), z[0], new Object[0]);
                a = a;
                if (a == null) {
                    a = c();
                }
            }
            a = a;
        }
        return a;
    }

    public static final Class b() {
        if (b == null) {
            b = Class.forName(z[1]);
        }
        return b;
    }

    private static Object c() {
        Handler handler = new Handler(Looper.getMainLooper());
        Object obj = new Object();
        handler.post(new b(obj));
        if (a == null && Looper.getMainLooper() != Looper.myLooper()) {
            synchronized (obj) {
                try {
                    obj.wait(300);
                } catch (InterruptedException e) {
                }
            }
        }
        return null;
    }
}
