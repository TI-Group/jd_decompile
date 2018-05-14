package com.b.a;

import c.a.as;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class e {
    private static final byte[] a = new byte[]{(byte) 10, (byte) 1, ReplyCode.reply0xb, (byte) 5, (byte) 4, ReplyCode.reply0xf, (byte) 7, (byte) 9, ReplyCode.reply0x17, (byte) 3, (byte) 1, (byte) 6, (byte) 8, ReplyCode.reply0xc, ReplyCode.reply0xd, (byte) 91};

    public static byte[] a(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i + 2), 16).intValue();
                }
            }
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(a));
        return instance.doFinal(bArr);
    }

    public static int a(int i, String str) {
        int i2;
        if (((double) new Random().nextFloat()) < 0.001d) {
            if (str == null) {
                as.d("null signature..");
            }
            i2 = 0;
            try {
                i2 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception e) {
            }
            return (i2 | 128) * 1000;
        }
        i2 = new Random().nextInt(i);
        if (i2 > 255000 || i2 < 128000) {
            return i2;
        }
        return 127000;
    }
}
