package cn.jiguang.b.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.b.b.b;
import cn.jiguang.c.d;

final class n implements Runnable {
    private static final String[] z;
    final /* synthetic */ m a;
    private String b;
    private Bundle c;
    private int d;
    private Context e;

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
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "c=V>5@\rV\u000f,D\u0003R\"'a\u000b_<&[";
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
        r11 = 67;
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
        r0 = "@\u001d\u0013!\"@\u0000\u0013<1F\rV?0\tC\u0013";
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
        r11 = 41;
        goto L_0x0021;
    L_0x004e:
        r11 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        goto L_0x0021;
    L_0x0051:
        r11 = 51;
        goto L_0x0021;
    L_0x0054:
        r11 = 76;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.n.<clinit>():void");
    }

    public n(m mVar, Context context, String str, Bundle bundle, int i) {
        this.a = mVar;
        this.b = str;
        this.c = bundle;
        this.e = context;
        this.d = i;
    }

    public final void run() {
        if (this.d == 1) {
            m.a(this.a, this.b, this.c);
        } else if (b.c()) {
            m.c(this.e, this.b, this.c);
        } else if (this.a.f) {
            m.a(this.a, this.b, this.c);
            j.a().a(this.e);
        } else {
            d.i(z[0], new StringBuilder(z[1]).append(this.a.f).toString());
        }
    }
}
