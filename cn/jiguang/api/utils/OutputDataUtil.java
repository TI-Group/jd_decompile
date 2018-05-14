package cn.jiguang.api.utils;

import java.math.BigInteger;

public class OutputDataUtil {
    private static final BigInteger d = BigInteger.ONE.shiftLeft(64);
    private static final String[] z;
    private byte[] a;
    private int b;
    private int c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "C:\u0012%\\T{\u000b9ZT>\\;RS/\\.]D{\u0013-\u0013D:\b*";
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
            case 0: goto L_0x0072;
            case 1: goto L_0x0075;
            case 2: goto L_0x0078;
            case 3: goto L_0x007b;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 51;
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
        r1 = "\u00004\t?\u0013O=\\9RN<\u0019kUO)\\";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u00009\u0015?\u0013V:\u0010>V\u00006\u001d3\t";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "N4\\;AE-\u0015$FS{\u000f?RT>";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "C:\u0012%\\T{\u0016>^P{\f*@T{\u0019%W\u00004\u001akWA/\u001d";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "i5\n*_I?\\(\\U5\b.W\u0000(\b9ZN<";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        r0 = java.math.BigInteger.ONE;
        r1 = 64;
        r0 = r0.shiftLeft(r1);
        d = r0;
        return;
    L_0x0072:
        r9 = 32;
        goto L_0x001f;
    L_0x0075:
        r9 = 91;
        goto L_0x001f;
    L_0x0078:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        goto L_0x001f;
    L_0x007b:
        r9 = 75;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.OutputDataUtil.<clinit>():void");
    }

    public OutputDataUtil() {
        this(32);
    }

    public OutputDataUtil(int i) {
        this.a = new byte[i];
        this.b = 0;
        this.c = -1;
    }

    private void a(int i) {
        if (this.a.length - this.b < i) {
            int length = this.a.length * 2;
            if (length < this.b + i) {
                length = this.b + i;
            }
            Object obj = new byte[length];
            System.arraycopy(this.a, 0, obj, 0, this.b);
            this.a = obj;
        }
    }

    private static void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + z[1] + i + z[2] + j2);
        }
    }

    public static int encodeZigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static long encodeZigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public int current() {
        return this.b;
    }

    public void jump(int i) {
        if (i > this.b) {
            throw new IllegalArgumentException(z[4]);
        }
        this.b = i;
    }

    public void restore() {
        if (this.c < 0) {
            throw new IllegalStateException(z[3]);
        }
        this.b = this.c;
        this.c = -1;
    }

    public void save() {
        this.c = this.b;
    }

    public byte[] toByteArray() {
        Object obj = new byte[this.b];
        System.arraycopy(this.a, 0, obj, 0, this.b);
        return obj;
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        a(i2);
        System.arraycopy(bArr, i, this.a, this.b, i2);
        this.b += i2;
    }

    public void writeByteArrayincludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException(z[5]);
        }
        a(bArr.length + 1);
        byte[] bArr2 = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr2[i] = (byte) (bArr.length & 255);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeRawLittleEndian16(int i) {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >> 8) & 255);
    }

    public void writeRawLittleEndian32(int i) {
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >> 16) & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) j) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 8)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 16)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 24)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 32)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 40)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 48)) & 255);
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) (((int) (j >> 56)) & 255);
    }

    public void writeU16(int i) {
        a((long) i, 16);
        a(2);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void writeU16At(int i, int i2) {
        a((long) i, 16);
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException(z[0]);
        }
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((i >>> 8) & 255);
        this.a[i3] = (byte) (i & 255);
    }

    public void writeU32(long j) {
        a(j, 32);
        a(4);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 16) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
    }

    public void writeU32At(long j, int i) {
        a(j, 32);
        if (i > this.b - 4) {
            throw new IllegalArgumentException(z[0]);
        }
        int i2 = i + 1;
        this.a[i] = (byte) ((int) ((j >>> 24) & 255));
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i3 + 1;
        this.a[i3] = (byte) ((int) ((j >>> 8) & 255));
        this.a[i2] = (byte) ((int) (j & 255));
    }

    public void writeU64(long j) {
        a(8);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 48) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 40) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 32) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 16) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
    }

    public void writeU64At(long j, int i) {
        int i2 = i + 1;
        this.a[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((int) ((j >>> 48) & 255));
        i2 = i3 + 1;
        this.a[i3] = (byte) ((int) ((j >>> 40) & 255));
        i3 = i2 + 1;
        this.a[i2] = (byte) ((int) ((j >>> 32) & 255));
        i2 = i3 + 1;
        this.a[i3] = (byte) ((int) ((j >>> 24) & 255));
        i3 = i2 + 1;
        this.a[i2] = (byte) ((int) ((j >>> 16) & 255));
        i2 = i3 + 1;
        this.a[i3] = (byte) ((int) ((j >>> 8) & 255));
        this.a[i2] = (byte) ((int) (j & 255));
    }

    public void writeU8(int i) {
        a((long) i, 8);
        a(1);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }
}
