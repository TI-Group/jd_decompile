package jd.wjlogin_sdk.util;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class DecryptorJni {
    private static final int RETRY_TIMES = 3;
    private static boolean isFuncAvailable = false;

    public static native byte[] jniDecrypt(byte[] bArr, int i, String str);

    public static native byte[] jniDecryptMsg(byte[] bArr, int i, String str);

    public static native String jniDeviceKey(Context context);

    public static native byte[] jniEncrypt(byte[] bArr, int i, String str);

    public static native byte[] jniEncryptMsg(byte[] bArr, int i, String str);

    public static native String jniRandomKey();

    public static native String jniTokenFilename(Context context);

    public static native String jniUserFilename(Context context);

    static {
        loadSo();
    }

    public static void loadSo() {
        if (!isFuncAvailable) {
            int i = 0;
            while (i < 3) {
                try {
                    System.loadLibrary("DecryptorJni");
                    isFuncAvailable = true;
                    return;
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                    isFuncAvailable = false;
                    i++;
                }
            }
        }
    }
}
