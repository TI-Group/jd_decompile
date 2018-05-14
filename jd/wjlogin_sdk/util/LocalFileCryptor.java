package jd.wjlogin_sdk.util;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class LocalFileCryptor {
    private static String key = null;

    public static void getKey(Context context) {
        DecryptorJni.loadSo();
        if (key == null || key.equals("") || key.length() < 16) {
            key = DecryptorJni.jniDeviceKey(context);
        }
    }

    public static String encrypt(String str) {
        DecryptorJni.loadSo();
        if (str != null) {
            try {
                if (!str.equals("")) {
                    byte[] bytes = str.getBytes();
                    str = ByteUtil.parseByte2HexStr(DecryptorJni.jniEncrypt(bytes, bytes.length, key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String decrypt(String str) {
        DecryptorJni.loadSo();
        if (str == null) {
            return str;
        }
        try {
            if (str.equals("")) {
                return str;
            }
            byte[] parseHexStr2Byte = ByteUtil.parseHexStr2Byte(str);
            return new String(DecryptorJni.jniDecrypt(parseHexStr2Byte, parseHexStr2Byte.length, key));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
