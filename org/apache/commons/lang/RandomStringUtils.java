package org.apache.commons.lang;

import android.support.v4.media.TransportMediator;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.Random;

/* compiled from: TbsSdkJava */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i) {
        return random(i, false, false);
    }

    public static String randomAscii(int i) {
        return random(i, 32, TransportMediator.KEYCODE_MEDIA_PAUSE, false, false);
    }

    public static String randomAlphabetic(int i) {
        return random(i, true, false);
    }

    public static String randomAlphanumeric(int i) {
        return random(i, true, true);
    }

    public static String randomNumeric(int i) {
        return random(i, false, true);
    }

    public static String random(int i, boolean z, boolean z2) {
        return random(i, 0, 0, z, z2);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2) {
        return random(i, i2, i3, z, z2, null, RANDOM);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr) {
        return random(i, i2, i3, z, z2, cArr, RANDOM);
    }

    public static String random(int i, int i2, int i3, boolean z, boolean z2, char[] cArr, Random random) {
        if (i == 0) {
            return "";
        }
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Requested random string length ").append(i).append(" is less than 0.").toString());
        }
        if (i2 == 0 && i3 == 0) {
            i3 = ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED;
            i2 = 32;
            if (!(z || z2)) {
                i2 = 0;
                i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = i3 - i2;
        while (true) {
            int i5 = i - 1;
            if (i == 0) {
                return stringBuffer.toString();
            }
            char nextInt;
            if (cArr == null) {
                nextInt = (char) (random.nextInt(i4) + i2);
            } else {
                nextInt = cArr[random.nextInt(i4) + i2];
            }
            if (!(z && z2 && Character.isLetterOrDigit(nextInt)) && (!(z && Character.isLetter(nextInt)) && (!(z2 && Character.isDigit(nextInt)) && (z || z2)))) {
                i5++;
            } else {
                stringBuffer.append(nextInt);
            }
            i = i5;
        }
    }

    public static String random(int i, String str) {
        if (str != null) {
            return random(i, str.toCharArray());
        }
        return random(i, 0, 0, false, false, null, RANDOM);
    }

    public static String random(int i, char[] cArr) {
        if (cArr == null) {
            return random(i, 0, 0, false, false, null, RANDOM);
        }
        return random(i, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
