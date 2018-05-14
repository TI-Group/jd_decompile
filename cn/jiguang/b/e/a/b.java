package cn.jiguang.b.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.b.e.a.a.c;
import java.nio.ByteBuffer;

public final class b extends JResponse {
    private static final String[] z;
    long a;
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r13 = 48;
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = "#\u0010]Z\u0007L_^]\u0005aD\n";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000e:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006b;
    L_0x0015:
        r9 = r1;
    L_0x0016:
        r10 = r4;
        r11 = r9;
        r15 = r8;
        r8 = r4;
        r4 = r15;
    L_0x001b:
        r14 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x0061;
            case 1: goto L_0x0064;
            case 2: goto L_0x0066;
            case 3: goto L_0x0068;
            default: goto L_0x0022;
        };
    L_0x0022:
        r12 = 96;
    L_0x0024:
        r12 = r12 ^ r14;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x0030;
    L_0x002c:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x001b;
    L_0x0030:
        r8 = r4;
        r4 = r10;
    L_0x0032:
        if (r8 > r9) goto L_0x0016;
    L_0x0034:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0049;
            case 1: goto L_0x0052;
            case 2: goto L_0x005c;
            default: goto L_0x0040;
        };
    L_0x0040:
        r6[r5] = r4;
        r0 = "/\u001d\u0010";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000e;
    L_0x0049:
        r6[r5] = r4;
        r0 = "TsD[\f]UCY\u000faCUt@\"\u0010CL\u000ekUB`\u00045";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000e;
    L_0x0052:
        r6[r5] = r4;
        r4 = 3;
        r0 = "LDBE2jC@F\u000e|U";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000e;
    L_0x005c:
        r6[r5] = r4;
        z = r7;
        return;
    L_0x0061:
        r12 = 15;
        goto L_0x0024;
    L_0x0064:
        r12 = r13;
        goto L_0x0024;
    L_0x0066:
        r12 = r13;
        goto L_0x0024;
    L_0x0068:
        r12 = 41;
        goto L_0x0024;
    L_0x006b:
        r9 = r1;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.b.<clinit>():void");
    }

    public b(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String getName() {
        return z[3];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return false;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.getLong(byteBuffer, this);
        this.b = ProtocolUtil.getTlv2(byteBuffer, this);
    }

    public final String toString() {
        return new StringBuilder(z[2]).append(this.a).append(z[0]).append(this.b).append(z[1]).append(super.toString()).toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
    }
}
