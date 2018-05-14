package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class RandomKeyDecryptor {
    public static String encode(byte[] bArr, String str) throws Exception {
        return Base64Util.encode(DecryptorJni.jniEncryptMsg(bArr, bArr.length, str));
    }

    public static byte[] decode(String str, String str2) throws Exception {
        byte[] decode = Base64Util.decode(str);
        return DecryptorJni.jniDecryptMsg(decode, decode.length, str2);
    }

    public static String getRandomKey() {
        return DecryptorJni.jniRandomKey();
    }
}
