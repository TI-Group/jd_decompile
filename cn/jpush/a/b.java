package cn.jpush.a;

import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

/* compiled from: TbsSdkJava */
public final class b extends JRequest {
    private static final String[] A;
    String a;
    String b;

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
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = "\u0006>$\u000ef;>0=o#*&\u001c~";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006b;
    L_0x0013:
        r9 = r1;
    L_0x0014:
        r10 = r4;
        r11 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x005f;
            case 1: goto L_0x0062;
            case 2: goto L_0x0065;
            case 3: goto L_0x0068;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 10;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x002e;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x0019;
    L_0x002e:
        r8 = r4;
        r4 = r10;
    L_0x0030:
        if (r8 > r9) goto L_0x0014;
    L_0x0032:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0050;
            case 2: goto L_0x005a;
            default: goto L_0x003e;
        };
    L_0x003e:
        r6[r5] = r4;
        r0 = "~\"\f~;0-U";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "\t\u000b\"\bk>6\"\u001cX7.6\ny&\u0002cB*3/3$o+e";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "rrc";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000c;
    L_0x005a:
        r6[r5] = r4;
        A = r7;
        return;
    L_0x005f:
        r12 = 82;
        goto L_0x0022;
    L_0x0062:
        r12 = 95;
        goto L_0x0022;
    L_0x0065:
        r12 = 67;
        goto L_0x0022;
    L_0x0068:
        r12 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x0022;
    L_0x006b:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.a.b.<clinit>():void");
    }

    public b(int i, int i2, long j, String str, String str2) {
        super(i, i2, j);
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String getName() {
        return A[0];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        ByteBuffer byteBuffer = this.body;
        this.a = ProtocolUtil.getTlv2(byteBuffer);
        this.b = ProtocolUtil.getTlv2(byteBuffer);
    }

    public final String toString() {
        return new StringBuilder(A[2]).append(this.a).append(A[1]).append(this.b).append(A[3]).append(super.toString()).toString();
    }

    public final void writeBody() {
        writeTlv2(this.a);
        writeTlv2(this.b);
    }
}
