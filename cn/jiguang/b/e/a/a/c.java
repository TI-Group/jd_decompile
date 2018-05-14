package cn.jiguang.b.e.a.a;

import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class c {
    private static final String[] z;
    int a;
    int b;
    int c;
    Long d;
    int e;
    long f;
    private boolean g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = ">^E|j\u001fHw=";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002c;
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
            case 0: goto L_0x006f;
            case 1: goto L_0x0072;
            case 2: goto L_0x0075;
            case 3: goto L_0x0078;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 7;
    L_0x001e:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002a;
    L_0x0026:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002a:
        r5 = r1;
        r1 = r7;
    L_0x002c:
        if (r5 > r6) goto L_0x0011;
    L_0x002e:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0042;
            case 1: goto L_0x004a;
            case 2: goto L_0x0052;
            case 3: goto L_0x005a;
            case 4: goto L_0x0062;
            case 5: goto L_0x006a;
            default: goto L_0x003a;
        };
    L_0x003a:
        r3[r2] = r1;
        r2 = 1;
        r1 = ">^Pvua\u0017I}=";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0042:
        r3[r2] = r1;
        r2 = 2;
        r1 = ">^Uzc(";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004a:
        r3[r2] = r1;
        r2 = 3;
        r1 = ">^Tzc(";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0052:
        r3[r2] = r1;
        r2 = 4;
        r1 = ">^LfnvD";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005a:
        r3[r2] = r1;
        r2 = 5;
        r1 = "I4nvfv#\u0006>'~\u001bH)";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0062:
        r3[r2] = r1;
        r2 = 6;
        r1 = "F\u0016C3ow\u001fB3na^H|s2\u0017Hzs{\u001fJz}w\u001a\u0006jbfP";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006a:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x006f:
        r9 = 18;
        goto L_0x001e;
    L_0x0072:
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x001e;
    L_0x0075:
        r9 = 38;
        goto L_0x001e;
    L_0x0078:
        r9 = 19;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.a.c.<clinit>():void");
    }

    public c(boolean z, int i, int i2, int i3, long j, int i4, long j2) {
        this.g = false;
        this.g = z;
        this.a = 0;
        this.b = i2;
        this.c = i3;
        this.d = Long.valueOf(j);
        this.e = i4;
        this.f = j2;
    }

    public c(boolean z, int i, int i2, long j) {
        this(z, 0, i, i2, j, 0, 0);
    }

    public c(boolean z, byte[] bArr) {
        this.g = false;
        this.g = z;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.a = wrap.getShort();
        this.a &= 32767;
        this.b = wrap.get();
        this.c = wrap.get();
        this.d = Long.valueOf(wrap.getLong());
        if (z) {
            this.e = wrap.getInt();
        }
        this.f = wrap.getLong();
    }

    public final int a() {
        return this.c;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void a(long j) {
        this.f = j;
    }

    public final void a(Long l) {
        this.d = l;
    }

    public final Long b() {
        return this.d;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final long c() {
        return this.f;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.b;
    }

    public final byte[] f() {
        if (this.a == 0) {
            throw new IllegalStateException(z[6]);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.putShort((short) this.a);
        allocate.put((byte) this.b);
        allocate.put((byte) this.c);
        allocate.putLong(this.d.longValue());
        if (this.g) {
            allocate.putInt(this.e);
        }
        allocate.putLong(this.f);
        allocate.flip();
        return ProtocolUtil.getBytesConsumed(allocate);
    }

    public final String toString() {
        return new StringBuilder(z[5]).append(this.a).append(z[1]).append(this.b).append(z[0]).append(this.c).append(z[3]).append(this.d).append(this.g ? new StringBuilder(z[2]).append(this.e).toString() : "").append(z[4]).append(this.f).toString();
    }
}
