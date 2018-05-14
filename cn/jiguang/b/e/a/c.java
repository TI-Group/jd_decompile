package cn.jiguang.b.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.d;
import java.nio.ByteBuffer;

public final class c extends JResponse {
    private static final String[] z;
    int a;
    int b;
    String c;
    int d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "!\u0004u\u0006w?\u000ea\u001fv\u0003\u0018w";
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
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0079;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 25;
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
            case 5: goto L_0x006b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "?\u000ea\u001fv\u0003\u0018wO|\u001f\u0019}\u001d9@Kq\u0000}\bQ";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "AKa\nj\u001e\u0002}\u0001R\b\u0012(";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "AKa\nk\u001b\u000e`;p\u0000\u000e(";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "AKa\nk\u001b\u000e`9|\u001f\u0018{\u0000wW";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "MF2";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "6'}\bp\u00039w\u001ci\u0002\u0005a\nDMF2\u001cp\tQ";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        goto L_0x001f;
    L_0x0073:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x001f;
    L_0x0076:
        r9 = 18;
        goto L_0x001f;
    L_0x0079:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.c.<clinit>():void");
    }

    public c(cn.jiguang.b.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final int a() {
        return this.d;
    }

    public final String getName() {
        return z[0];
    }

    public final int getSid() {
        return this.a;
    }

    protected final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        super.parseBody();
        if (this.code > 0) {
            d.i(z[0], new StringBuilder(z[1]).append(this.code).toString());
            return;
        }
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.getInt(byteBuffer, this);
        this.b = ByteBufferUtils.getShort(byteBuffer, this);
        this.c = ProtocolUtil.getTlv2(byteBuffer, this);
        this.d = ByteBufferUtils.getInt(byteBuffer, this);
    }

    public final String toString() {
        return new StringBuilder(z[6]).append(this.a).append(z[4]).append(this.b).append(z[2]).append(this.c).append(z[3]).append(this.d).append(z[5]).append(super.toString()).toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeInt4(this.a);
        writeInt2(this.b);
        writeTlv2(this.c);
        writeInt4(this.d);
    }
}
