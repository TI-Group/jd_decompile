package cn.jiguang.b.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.b.e.a.a.c;
import java.nio.ByteBuffer;

public final class a extends JResponse {
    private static final String[] z;
    int a;
    int b;
    int c;
    long d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "8s\u0016D\u0016\f@\u0018N4>\u0012X\u000f*\u0006C\u0000J+\u0017q\u001aB5\u0002\\\u0011\u0015";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0068;
            case 1: goto L_0x006b;
            case 2: goto L_0x006e;
            case 3: goto L_0x0071;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 88;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "O\u0012\u0006[1\u000eWO";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "O\u0012\u0006[9\u0017G\u0006\u0015";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "C\u001fU";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "O\u0012\u0006[=\u0013\b";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\"q>\u000f\n\u0006A\u0005@6\u0010W";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0068:
        r9 = 99;
        goto L_0x001f;
    L_0x006b:
        r9 = 50;
        goto L_0x001f;
    L_0x006e:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x001f;
    L_0x0071:
        r9 = 47;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.a.<clinit>():void");
    }

    public a(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final int a() {
        return this.a;
    }

    public final String getName() {
        return z[5];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return false;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.get(byteBuffer, this).byteValue();
        this.b = ByteBufferUtils.get(byteBuffer, this).byteValue();
        this.c = ByteBufferUtils.get(byteBuffer, this).byteValue();
        this.d = ByteBufferUtils.getLong(byteBuffer, this);
    }

    public final String toString() {
        return new StringBuilder(z[0]).append(this.a).append(z[4]).append(this.b).append(z[2]).append(this.c).append(z[1]).append(this.d).append(z[3]).append(super.toString()).toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeInt1(this.a);
        writeInt1(this.b);
        writeInt1(this.c);
        writeLong8(this.d);
    }
}
