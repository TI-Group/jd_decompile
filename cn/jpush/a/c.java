package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jpush.android.d.e;
import java.nio.ByteBuffer;

/* compiled from: TbsSdkJava */
public final class c extends JResponse {
    private static final String[] A;
    String a;
    long b = -1;

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
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = "me9";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x0075;
    L_0x0014:
        r10 = r1;
    L_0x0015:
        r11 = r5;
        r12 = r10;
        r15 = r9;
        r9 = r5;
        r5 = r15;
    L_0x001a:
        r14 = r9[r10];
        r13 = r12 % 5;
        switch(r13) {
            case 0: goto L_0x0069;
            case 1: goto L_0x006c;
            case 2: goto L_0x006f;
            case 3: goto L_0x0072;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 86;
    L_0x0023:
        r13 = r13 ^ r14;
        r13 = (char) r13;
        r9[r10] = r13;
        r10 = r12 + 1;
        if (r5 != 0) goto L_0x002f;
    L_0x002b:
        r9 = r11;
        r12 = r10;
        r10 = r5;
        goto L_0x001a;
    L_0x002f:
        r9 = r5;
        r5 = r11;
    L_0x0031:
        if (r9 > r10) goto L_0x0015;
    L_0x0033:
        r9 = new java.lang.String;
        r9.<init>(r5);
        r5 = r9.intern();
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0051;
            case 2: goto L_0x005a;
            case 3: goto L_0x0064;
            default: goto L_0x003f;
        };
    L_0x003f:
        r7[r6] = r5;
        r0 = "\u0016\u001cx,7!!x8\u0004(;i$8>-Dk{m)z??\"&#";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = "\u000e'w?3#<O*:8-j";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "\u001f-j;9#;|k3?:v9v`hz$2(r";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = "\u0019)~*:$)j\u00193>8v%%(";
        r6 = r5;
        r7 = r8;
        r5 = r0;
        r0 = r4;
        goto L_0x000d;
    L_0x0064:
        r7[r6] = r5;
        A = r8;
        return;
    L_0x0069:
        r13 = 77;
        goto L_0x0023;
    L_0x006c:
        r13 = 72;
        goto L_0x0023;
    L_0x006f:
        r13 = 25;
        goto L_0x0023;
    L_0x0072:
        r13 = 75;
        goto L_0x0023;
    L_0x0075:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.a.c.<clinit>():void");
    }

    public c(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final String a() {
        return this.a;
    }

    public final String getName() {
        return A[4];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return getCommand() == 10;
    }

    public final void parseBody() {
        super.parseBody();
        if (this.code > 0) {
            e.i(A[2], new StringBuilder(A[3]).append(this.code).toString());
        } else {
            this.a = ProtocolUtil.getTlv2(this.body, this);
        }
    }

    public final String toString() {
        return new StringBuilder(A[1]).append(this.a).append(A[0]).append(super.toString()).toString();
    }

    public final void writeBody() {
        super.writeBody();
    }
}
