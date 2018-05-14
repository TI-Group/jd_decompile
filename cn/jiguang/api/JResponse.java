package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

public abstract class JResponse extends JProtocol {
    private static final String z;
    public int code;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r6 = 1;
        r0 = "~ed\bn[Yr\u001eeWXe\u001e#";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        if (r1 > r6) goto L_0x0027;
    L_0x000b:
        r3 = r0;
        r4 = r2;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0010:
        r7 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            case 3: goto L_0x003d;
            default: goto L_0x0017;
        };
    L_0x0017:
        r5 = 30;
    L_0x0019:
        r5 = r5 ^ r7;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0010;
    L_0x0025:
        r1 = r0;
        r0 = r3;
    L_0x0027:
        if (r1 > r2) goto L_0x000b;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        return;
    L_0x0035:
        r5 = 52;
        goto L_0x0019;
    L_0x0038:
        r5 = 55;
        goto L_0x0019;
    L_0x003b:
        r5 = r6;
        goto L_0x0019;
    L_0x003d:
        r5 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JResponse.<clinit>():void");
    }

    public JResponse(int i, int i2, long j, long j2, int i3, String str) {
        super(false, i, i2, j, -1, j2);
        this.code = i3;
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }

    protected void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = ByteBufferUtils.getShort(this.body, this);
        }
    }

    public String toString() {
        return new StringBuilder(z).append(this.code).append('}').toString();
    }

    protected void writeBody() {
        if (this.code >= 0) {
            writeInt2(this.code);
        }
    }
}
