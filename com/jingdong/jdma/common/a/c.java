package com.jingdong.jdma.common.a;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: TbsSdkJava */
public class c {
    private static final char[] a = new char[]{'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = new byte[128];

    public static String a(byte[] bArr) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= bArr.length - 1; i += 3) {
            byte[] bArr2 = new byte[4];
            byte b = (byte) 0;
            for (int i2 = 0; i2 <= 2; i2++) {
                if (i + i2 <= bArr.length - 1) {
                    bArr2[i2] = (byte) (b | ((bArr[i + i2] & 255) >>> ((i2 * 2) + 2)));
                    b = (byte) ((((bArr[i + i2] & 255) << (((2 - i2) * 2) + 2)) & 255) >>> 2);
                } else {
                    bArr2[i2] = b;
                    b = (byte) 64;
                }
            }
            bArr2[3] = b;
            for (int i3 = 0; i3 <= 3; i3++) {
                if (bArr2[i3] <= (byte) 63) {
                    stringBuilder.append(a[bArr2[i3]]);
                } else {
                    stringBuilder.append('=');
                }
            }
        }
        return stringBuilder.toString();
    }

    public static byte[] b(byte[] bArr) {
        byte[] toByteArray;
        Exception e;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return toByteArray;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            toByteArray = null;
            e = exception;
            e.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }
}
