package com.jingdong.jdma.common.a;

import com.jingdong.jdma.common.utils.CommonUtil;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: TbsSdkJava */
public class b {
    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
        instance.init(1, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }

    public static final String a(String str, String str2) {
        try {
            return a.a(a(str.getBytes(CommonUtil.UTF8), str2.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
