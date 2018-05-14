package jd.wjlogin_sdk.util;

import java.security.MessageDigest;

/* compiled from: TbsSdkJava */
public class MD5 {
    public static String encrypt32(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] toCharArray = str.toCharArray();
            byte[] bArr = new byte[toCharArray.length];
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                bArr[i2] = (byte) toCharArray[i2];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                int i3 = digest[i] & 255;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
                i++;
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encrypt16(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] toCharArray = str.toCharArray();
            byte[] bArr = new byte[toCharArray.length];
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                bArr[i2] = (byte) toCharArray[i2];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                int i3 = digest[i] & 255;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
                i++;
            }
            return stringBuffer.toString().substring(8, 24);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt32(String str) {
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            toCharArray[i] = (char) (toCharArray[i] ^ 116);
        }
        return new String(toCharArray);
    }
}
