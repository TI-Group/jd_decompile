package cn.jiguang.b.b;

import cn.jiguang.c.d;
import cn.jiguang.e.a;

public final class i {
    private static final String[] z;
    int a;
    int b = 0;
    long c;
    byte[] d;
    int e;
    String f;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "[7\u0016W\u0001Z&\u000eL\u0003\t1\bO\tH<\u0003\u0018";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x008c;
            case 1: goto L_0x008f;
            case 2: goto L_0x0092;
            case 3: goto L_0x0095;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 100;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0005 \u000eF^";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "{7\u0016W\u0001Z&$C\u0007A7*C\nH5\u0002P";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0005!\u0003I\u0010P\"\u0002\u0018";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Y3\u0015Q\u0001\t \u0002S\u0011L!\u0013K\nNr\u0001C\rE7\u0003";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0005r\u0015K\u0000\u0014";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0005r\u0004M\tD3\tFY";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0005r\u0014F\u000f}+\u0017GY\u000e";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0005r\u0013K\tL!Z";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "{7\u0016W\u0001Z&\u000eL\u0003R&\u000eO\u0001F'\u0013\u001f";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 41;
        goto L_0x0020;
    L_0x008f:
        r9 = 82;
        goto L_0x0020;
    L_0x0092:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x0095:
        r9 = 34;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.i.<clinit>():void");
    }

    public i(byte[] bArr, String str, int i) {
        this.d = bArr;
        this.a = i;
        this.f = str;
        if (bArr == null || bArr.length < 24) {
            d.h(z[2], z[4]);
            return;
        }
        this.e = a.a(bArr[3]);
        this.c = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            this.c = (this.c << 8) + ((long) (bArr[i2 + 4] & 255));
        }
        d.a(z[2], new StringBuilder(z[0]).append(this.e).append(z[1]).append(this.c).append(z[3]).append(str).toString());
    }

    public final String a() {
        return h.b(this.c, this.f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.c != iVar.c ? false : this.e != iVar.e ? false : this.f != null ? this.f.equals(iVar.f) : iVar.f == null;
    }

    public final int hashCode() {
        return (this.f != null ? this.f.hashCode() : 0) + ((((((int) (this.c ^ (this.c >>> 32))) + 31) * 31) + this.e) * 31);
    }

    public final String toString() {
        return new StringBuilder(z[9]).append(this.a).append(z[8]).append(this.b).append(z[5]).append(this.c).append(z[6]).append(this.e).append(z[7]).append(this.f).append('\'').append('}').toString();
    }
}
