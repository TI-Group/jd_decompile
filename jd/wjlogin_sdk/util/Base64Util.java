package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class Base64Util {
    public static String encodeBase64String(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decoderBase64String(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decode(String str) throws Exception {
        return Base64.decode(str.getBytes(), 2);
    }

    public static String encode(byte[] bArr) throws Exception {
        return new String(Base64.encode(bArr, 2));
    }

    public static byte[] decodeUrl(String str) throws Exception {
        return Base64.decode(str.getBytes(), 11);
    }

    public static String encodeUrl(byte[] bArr) throws Exception {
        return new String(Base64.encode(bArr, 11));
    }
}
