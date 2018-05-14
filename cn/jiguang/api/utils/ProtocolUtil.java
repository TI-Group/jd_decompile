package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ProtocolUtil {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "g2I\\ZP#\u001eu.\u0011unQzY\u0017YNhY'\fM|N:^\u0006";
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
        r9 = 14;
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
        r1 = "l'C\\a_:@}zU9";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "i\u0001j\u00056";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "]7";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "g2I\\LE!I[MS;_]cY1q\b#\u001c\u0017U\\k~ JNkNuIZ|S'\u0002";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "g2I\\LE!I[S\u001cx\fjwH0n]hZ0^\bkN'CZ ";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0068:
        r9 = 60;
        goto L_0x001f;
    L_0x006b:
        r9 = 85;
        goto L_0x001f;
    L_0x006e:
        r9 = 44;
        goto L_0x001f;
    L_0x0071:
        r9 = 40;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ProtocolUtil.<clinit>():void");
    }

    public static void fillIntData(byte[] bArr, int i, int i2) {
        System.arraycopy(int2ByteArray(i), 0, bArr, i2, 4);
    }

    public static void fillStringData(byte[] bArr, String str, int i) {
        Object bytes = str.getBytes();
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static byte[] fixedStringToBytes(String str, int i) {
        if (str == null || "".equals(str)) {
            return new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        }
        Object bytes;
        Object obj = null;
        try {
            bytes = str.getBytes(z[2]);
        } catch (UnsupportedEncodingException e) {
            bytes = obj;
        }
        if (bytes == null) {
            return new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0};
        }
        obj = getDefaultByte(i);
        if (bytes.length <= i) {
            i = bytes.length;
        }
        System.arraycopy(bytes, 0, obj, 0, i);
        return obj;
    }

    public static byte[] getBytes(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.asReadOnlyBuffer().flip();
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException e) {
            d.g(z[1], z[5]);
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getBytesConsumed(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bArr;
        } catch (NegativeArraySizeException e) {
            d.g(z[1], z[4]);
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getDefaultByte(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[0] = (byte) 0;
        }
        return bArr;
    }

    public static String getString(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, z[2]);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String getTlv2(ByteBuffer byteBuffer) {
        try {
            byte[] bArr = new byte[byteBuffer.getShort()];
            byteBuffer.get(bArr);
            return new String(bArr, z[2]);
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public static String getTlv2(ByteBuffer byteBuffer, JResponse jResponse) {
        short s = ByteBufferUtils.getShort(byteBuffer, jResponse);
        if (s < (short) 0) {
            d.g(z[1], z[0]);
            return null;
        }
        byte[] bArr = new byte[s];
        ByteBufferUtils.get(byteBuffer, bArr, jResponse);
        try {
            return new String(bArr, z[2]);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static byte[] int2ByteArray(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    public static byte[] long2ByteArray(long j) {
        return new byte[]{(byte) ((int) (j >>> 56)), (byte) ((int) (j >>> 48)), (byte) ((int) (j >>> 40)), (byte) ((int) (j >>> 32)), (byte) ((int) (j >>> 24)), (byte) ((int) (j >>> 16)), (byte) ((int) (j >>> 8)), (byte) ((int) j)};
    }

    public static void main(String[] strArr) {
        d.c(z[1], j.a(fixedStringToBytes(z[3], 4)));
    }

    public static byte[] short2ByteArray(short s) {
        return new byte[]{(byte) (s >>> 8), (byte) s};
    }

    public static byte[] tlv2ToByteArray(String str) {
        if (str == null || "".equals(str)) {
            return new byte[]{(byte) 0, (byte) 0};
        }
        Object bytes;
        Object obj = null;
        try {
            bytes = str.getBytes(z[2]);
        } catch (UnsupportedEncodingException e) {
            bytes = obj;
        }
        if (bytes == null) {
            return new byte[]{(byte) 0, (byte) 0};
        }
        short length = (short) bytes.length;
        obj = new byte[(length + 2)];
        System.arraycopy(short2ByteArray(length), 0, obj, 0, 2);
        System.arraycopy(bytes, 0, obj, 2, length);
        return obj;
    }
}
