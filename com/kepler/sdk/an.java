package com.kepler.sdk;

import java.security.MessageDigest;

/* compiled from: TbsSdkJava */
public class an {
    public String a(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            char[] cArr2 = new char[(r4 * 2)];
            for (byte b : instance.digest()) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            return "";
        }
    }

    String b(byte[] bArr) {
        String str = "";
        str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                str = str + "0" + toHexString;
            } else {
                str = str + toHexString;
            }
        }
        return str;
    }

    public String c(byte[] bArr) {
        String str = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            str = b(instance.digest());
        } catch (Exception e) {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
