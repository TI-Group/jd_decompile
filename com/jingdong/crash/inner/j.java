package com.jingdong.crash.inner;

import com.jingdong.jdma.common.utils.CommonUtil;
import java.nio.charset.Charset;
import java.security.MessageDigest;

class j {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str, String str2) {
        return a(b(str + str2, CommonUtil.UTF8));
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(a[(bArr[i] >>> 4) & 15]);
            stringBuffer.append(a[bArr[i] & 15]);
        }
        return stringBuffer.toString();
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] b(String str, String str2) {
        return a().digest(str.getBytes(Charset.forName(str2)));
    }
}
