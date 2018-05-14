package com.jd.fridge.util;

import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: TbsSdkJava */
public class s {
    private static char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* compiled from: TbsSdkJava */
    public enum a {
        Length16,
        Length32
    }

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

    private static char[] a(byte[] bArr) {
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

    public static String a(String str, a aVar) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            if (aVar == a.Length16) {
                return a(instance).substring(8, 24);
            }
            return a(instance);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(MessageDigest messageDigest) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString(b & 15));
        }
        return stringBuilder.toString();
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                } catch (Exception e2) {
                    e = e2;
                }
            }
            fileInputStream.close();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            try {
                e.printStackTrace();
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e52) {
                        e52.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static String b(String str) {
        return a(new File(str));
    }
}
