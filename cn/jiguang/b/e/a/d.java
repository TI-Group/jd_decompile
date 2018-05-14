package cn.jiguang.b.e.a;

import android.support.v4.view.PointerIconCompat;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.b.e.a.a.c;
import java.nio.ByteBuffer;

public final class d extends JResponse {
    private static final String[] z;
    long a;
    String b;
    String c;
    String d;
    String e;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "0aad6\u0016at_ \u0011tic6\u0007";
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
            case 2: goto L_0x0075;
            case 3: goto L_0x0077;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 69;
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
        r1 = "N$bh3\u000bgcD!X";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "9Vcj,\u0011pc\u0017\u0007wvb+\u0011a[-hBnsd!X";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "N$vl6\u0011si!X";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "B)&";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "N$th\"+`<";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "0au}*\fwc- \u0010vieO$eb!\u0007>";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 98;
        goto L_0x001f;
    L_0x0073:
        r9 = 4;
        goto L_0x001f;
    L_0x0075:
        r9 = 6;
        goto L_0x001f;
    L_0x0077:
        r9 = 13;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.d.<clinit>():void");
    }

    public d(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long getJuid() {
        return this.a;
    }

    public final String getName() {
        return z[0];
    }

    protected final boolean isNeedParseeErrorMsg() {
        return true;
    }

    protected final void parseBody() {
        super.parseBody();
        if (this.code > 0) {
            cn.jiguang.c.d.i(z[0], new StringBuilder(z[6]).append(this.code).toString());
            return;
        }
        ByteBuffer byteBuffer = this.body;
        if (this.code == 0) {
            this.a = ByteBufferUtils.getLong(byteBuffer, this);
            this.b = ProtocolUtil.getTlv2(byteBuffer, this);
            this.c = ProtocolUtil.getTlv2(byteBuffer, this);
        } else if (this.code == PointerIconCompat.TYPE_CROSSHAIR) {
            this.e = ProtocolUtil.getTlv2(byteBuffer, this);
        }
    }

    public final String toString() {
        return new StringBuilder(z[2]).append(this.a).append(z[3]).append(this.b).append(z[5]).append(this.c).append(z[1]).append(this.d).append(z[4]).append(super.toString()).toString();
    }

    protected final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
        writeTlv2(this.c);
        writeTlv2(this.d);
    }
}
