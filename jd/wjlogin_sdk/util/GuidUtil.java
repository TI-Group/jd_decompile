package jd.wjlogin_sdk.util;

import android.content.Context;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: TbsSdkJava */
public class GuidUtil {
    private static final int PAD_BELOW = 16;
    private static final int TWO_BYTES = 255;
    private static Random myRand;
    private static SecureRandom mySecureRand;
    private Context context;
    private String valueAfterMD5 = "";
    private String valueBeforeMD5 = "";

    static {
        myRand = null;
        mySecureRand = null;
        mySecureRand = new SecureRandom();
        myRand = new Random(mySecureRand.nextLong());
    }

    public GuidUtil(Context context) {
        this.context = context;
        getRandomGUID(false);
    }

    public GuidUtil(boolean z, Context context) {
        this.context = context;
        getRandomGUID(z);
    }

    public void getRandomGUID(boolean z) {
        MessageDigest instance;
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            instance = null;
        }
        try {
            long nextLong;
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                nextLong = mySecureRand.nextLong();
            } else {
                nextLong = myRand.nextLong();
            }
            stringBuffer.append(new DeviceUuidFactory(this.context).getDeviceUuid().toString());
            stringBuffer.append(":");
            stringBuffer.append(Long.toString(currentTimeMillis));
            stringBuffer.append(":");
            stringBuffer.append(Long.toString(nextLong));
            this.valueBeforeMD5 = stringBuffer.toString();
            instance.update(this.valueBeforeMD5.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer2 = new StringBuffer(32);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer2.append('0');
                }
                stringBuffer2.append(Integer.toHexString(i));
            }
            this.valueAfterMD5 = stringBuffer2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String toString() {
        String toUpperCase = this.valueAfterMD5.toUpperCase();
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(toUpperCase.substring(0, 8));
        stringBuffer.append(toUpperCase.substring(8, 12));
        stringBuffer.append(toUpperCase.substring(12, 16));
        stringBuffer.append(toUpperCase.substring(16, 20));
        stringBuffer.append(toUpperCase.substring(20));
        return stringBuffer.toString();
    }
}
