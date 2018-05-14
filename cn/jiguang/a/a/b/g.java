package cn.jiguang.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.c.d;

final class g extends Handler {
    private static final String[] z;
    final /* synthetic */ f a;

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
        r1 = 0;
        r2 = 1;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "H%R\u0007nJkT\u001af";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000b:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0060;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r3;
        r10 = r8;
        r13 = r7;
        r7 = r3;
        r3 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0054;
            case 1: goto L_0x0057;
            case 2: goto L_0x005a;
            case 3: goto L_0x005d;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = r2;
    L_0x0020:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002c;
    L_0x0028:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x0018;
    L_0x002c:
        r7 = r3;
        r3 = r9;
    L_0x002e:
        if (r7 > r8) goto L_0x0013;
    L_0x0030:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0045;
            case 1: goto L_0x004f;
            default: goto L_0x003c;
        };
    L_0x003c:
        r5[r4] = r3;
        r0 = "Z;J o[$t\bo\\,\\\u001b!J*JIoH'U";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0045:
        r5[r4] = r3;
        r3 = 2;
        r0 = "p2u\u0006b\\?P\u0006op*W\bfX9";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000b;
    L_0x004f:
        r5[r4] = r3;
        z = r6;
        return;
    L_0x0054:
        r11 = 61;
        goto L_0x0020;
    L_0x0057:
        r11 = 75;
        goto L_0x0020;
    L_0x005a:
        r11 = 57;
        goto L_0x0020;
    L_0x005d:
        r11 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
    L_0x0060:
        r8 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.g.<clinit>():void");
    }

    public g(f fVar, Looper looper) {
        this.a = fVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (!this.a.j) {
                    this.a.j = true;
                    f.b(this.a);
                    f.c(this.a);
                    return;
                }
                return;
            case 1001:
            case PointerIconCompat.TYPE_HAND /*1002*/:
                if (this.a.l != null) {
                    this.a.l.a(message);
                    return;
                } else {
                    d.g(z[2], z[1]);
                    return;
                }
            default:
                d.a(z[2], z[0]);
                return;
        }
    }
}
