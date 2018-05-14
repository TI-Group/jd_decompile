package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* compiled from: TbsSdkJava */
public final class a extends JResponse {
    private static final String[] A;
    int a;
    long b;
    String c;

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
        r1 = 0;
        r2 = 1;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = "[!#M;4n J9\u0019ut";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x0074;
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
            case 2: goto L_0x006e;
            case 3: goto L_0x0071;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 92;
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
        r0 = ",L+M/\u0016f+n)\u0004i\u0013\u001eqWl=Y\b\u000eq+\u0004";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = "W,n";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "[!#M;>et";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = ":d=M=\u0010d\u001eK/\u001f";
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
        r13 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0023;
    L_0x006c:
        r13 = r2;
        goto L_0x0023;
    L_0x006e:
        r13 = 78;
        goto L_0x0023;
    L_0x0071:
        r13 = 62;
        goto L_0x0023;
    L_0x0074:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.a.a.<clinit>():void");
    }

    public a(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String getName() {
        return A[4];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return false;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.get(byteBuffer, this).byteValue();
        this.b = ByteBufferUtils.getLong(byteBuffer, this);
        this.c = ProtocolUtil.getTlv2(byteBuffer, this);
    }

    public final String toString() {
        return new StringBuilder(A[1]).append(this.a).append(A[3]).append(this.b).append(A[0]).append(this.c).append(A[2]).append(super.toString()).toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeInt1(this.a);
        writeLong8(this.b);
        writeTlv2(this.c);
    }
}
