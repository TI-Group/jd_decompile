package cn.jiguang.e.a;

import android.os.IBinder;
import cn.jiguang.android.ShareValues;
import cn.jiguang.android.b;
import cn.jiguang.b.b.g;
import cn.jiguang.c.d;

public final class a extends b {
    private static cn.jiguang.android.a a;
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
        r2 = "\fF\u0001E\u0011 F\u0007A";
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
        r11 = 66;
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
        r0 = "8R\u0006L\u000e'@\u001cJb;S\u0014P7;\u0007\u0017]b)N\u0011Hx.F\u0019W'";
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
        r11 = 72;
        goto L_0x0021;
    L_0x004e:
        r11 = 39;
        goto L_0x0021;
    L_0x0051:
        r11 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x0021;
    L_0x0054:
        r11 = 36;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.a.<clinit>():void");
    }

    public static void a(cn.jiguang.android.a aVar) {
        a = aVar;
    }

    public static cn.jiguang.android.a b() {
        return a;
    }

    public static boolean c() {
        return a != null;
    }

    public static void d() {
        a = null;
    }

    public final IBinder a(String str, String str2) {
        cn.jiguang.b.d.b.a();
        return cn.jiguang.b.d.b.c(str, str2);
    }

    public final ShareValues a(String str, ShareValues shareValues, int i) {
        b b = b.b(str);
        return b != null ? b.c(shareValues, i) : shareValues;
    }

    public final boolean a() {
        d.a(z[0], z[1]);
        return g.a.get() != 0;
    }

    public final boolean a(String str, ShareValues shareValues, boolean z, int i) {
        b b = b.b(str);
        return b != null ? b.a(shareValues, i) : false;
    }
}
