package jd.wjlogin_sdk.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: TbsSdkJava */
public class OpenSSLDecryptor {
    private static final String CIPHER_TYPE_STRING = "AES/CBC/PKCS5Padding";
    private static final int INDEX_IV = 1;
    private static final int INDEX_KEY = 0;
    private static final int ITERATIONS = 5;
    private static final int KEY_SIZE_BITS = 128;
    private static final String MESSAGEDIGES_TTYPE_STRING = "SHA-1";
    private static final String SALT_STRING = "2305843009213693951";
    private static final String SECRETKEY_TYPE_STRING = "AES";
    private static Cipher cipher;
    private static IvParameterSpec iv;
    private static SecretKeySpec key;

    public static byte[][] EVP_BytesToKey(int i, int i2, MessageDigest messageDigest, byte[] bArr, byte[] bArr2, int i3) {
        byte[][] bArr3 = new byte[2][];
        byte[] bArr4 = new byte[i];
        byte[] bArr5 = new byte[i2];
        bArr3[0] = bArr4;
        bArr3[1] = bArr5;
        if (bArr2 == null) {
            return bArr3;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        byte[] bArr6 = null;
        while (true) {
            messageDigest.reset();
            int i7 = i4 + 1;
            if (i4 > 0) {
                messageDigest.update(bArr6);
            }
            messageDigest.update(bArr2);
            if (bArr != null) {
                messageDigest.update(bArr, 0, 8);
            }
            byte[] digest = messageDigest.digest();
            int i8 = 1;
            while (i8 < i3) {
                messageDigest.reset();
                messageDigest.update(digest);
                i8++;
                digest = messageDigest.digest();
            }
            i8 = 0;
            if (i > 0) {
                while (i != 0 && i8 != digest.length) {
                    int i9 = i5 + 1;
                    bArr4[i5] = digest[i8];
                    i--;
                    i8++;
                    i5 = i9;
                }
            }
            if (i2 <= 0 || r3 == digest.length) {
                i8 = i6;
            } else {
                while (i2 != 0) {
                    if (i8 == digest.length) {
                        i8 = i6;
                        break;
                    }
                    i9 = i6 + 1;
                    bArr5[i6] = digest[i8];
                    i2--;
                    i8++;
                    i6 = i9;
                }
                i8 = i6;
            }
            if (i == 0 && r13 == 0) {
                break;
            }
            i6 = i8;
            bArr6 = digest;
            i4 = i7;
        }
        for (i7 = 0; i7 < digest.length; i7++) {
            digest[i7] = (byte) 0;
        }
        return bArr3;
    }

    public static byte[] encrypt(byte[] bArr, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        getCipherAndKeyIV(bArr, str);
        cipher.init(1, key, iv);
        return cipher.doFinal(bArr);
    }

    public static byte[] decrypt(byte[] bArr, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        getCipherAndKeyIV(bArr, str);
        cipher.init(2, key, iv);
        return cipher.doFinal(bArr);
    }

    private static byte[] getSlat() {
        return ByteUtil.longToByte(Long.parseLong(SALT_STRING));
    }

    private static void getCipherAndKeyIV(byte[] bArr, String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] slat = getSlat();
        cipher = Cipher.getInstance(CIPHER_TYPE_STRING);
        byte[][] EVP_BytesToKey = EVP_BytesToKey(16, cipher.getBlockSize(), MessageDigest.getInstance(MESSAGEDIGES_TTYPE_STRING), slat, str.getBytes(), 5);
        key = new SecretKeySpec(EVP_BytesToKey[0], SECRETKEY_TYPE_STRING);
        iv = new IvParameterSpec(EVP_BytesToKey[1]);
    }
}
