package jd.wjlogin_sdk.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.util.UUID;

/* compiled from: TbsSdkJava */
public class AES128 {
    private static String key;

    public static void getKey(Context context) {
        if (key == null || key.equals("") || key.length() < 16) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = telephonyManager.getDeviceId();
            long hashCode = (long) (Secure.getString(context.getContentResolver(), "android_id")).hashCode();
            long hashCode2 = ((long) str.hashCode()) << 32;
            key = MD5.encrypt16(new UUID(hashCode, ((long) (telephonyManager.getSimSerialNumber()).hashCode()) | hashCode2).toString());
        }
    }

    public static String encrypt(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    str = ByteUtil.parseByte2HexStr(OpenSSLDecryptor.encrypt(str.getBytes(), key));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String decrypt(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (str.equals("")) {
                return str;
            }
            return new String(OpenSSLDecryptor.decrypt(ByteUtil.parseHexStr2Byte(str), key));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
