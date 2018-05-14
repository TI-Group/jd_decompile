package com.jingdong.jdma.common.a;

import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: TbsSdkJava */
public class d {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            try {
                instance.update(str.getBytes(CommonUtil.UTF8));
                return new String(a(instance.digest()));
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException("System doesn't support your  EncodingException.");
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("System doesn't support MD5 algorithm.");
        }
    }

    public static char[] a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = a[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = a[bArr[i2] & 15];
        }
        return cArr;
    }
}
