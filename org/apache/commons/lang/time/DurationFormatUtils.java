package org.apache.commons.lang.time;

import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
class DurationFormatUtils {
    public static final FastDateFormat ISO_EXTENDED_FORMAT = FastDateFormat.getInstance(ISO_EXTENDED_FORMAT_PATTERN);
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";

    public static String formatISO(long j) {
        int i = (int) (j / 3600000);
        long j2 = j - ((long) (DateUtils.MILLIS_IN_HOUR * i));
        int i2 = (int) (j2 / 60000);
        j2 -= (long) (DateUtils.MILLIS_IN_MINUTE * i2);
        int i3 = (int) (j2 / 1000);
        int i4 = (int) (j2 - ((long) (i3 * 1000)));
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append(i);
        stringBuffer.append(':');
        stringBuffer.append((char) ((i2 / 10) + 48));
        stringBuffer.append((char) ((i2 % 10) + 48));
        stringBuffer.append(':');
        stringBuffer.append((char) ((i3 / 10) + 48));
        stringBuffer.append((char) ((i3 % 10) + 48));
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        if (i4 < 10) {
            stringBuffer.append('0').append('0');
        } else if (i4 < 100) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i4);
        return stringBuffer.toString();
    }

    public static String formatWords(long j, boolean z, boolean z2) {
        long[] jArr = new long[]{j / 86400000, (j / 3600000) % 24, (j / 60000) % 60, (j / 1000) % 60};
        String[] strArr = new String[]{" day ", " hour ", " minute ", " second"};
        String[] strArr2 = new String[]{" days ", " hours ", " minutes ", " seconds"};
        StringBuffer stringBuffer = new StringBuffer(64);
        Object obj = null;
        for (int i = 0; i < 4; i++) {
            long j2 = jArr[i];
            if (j2 == 0) {
                if (obj != null) {
                    if (!z2) {
                        stringBuffer.append('0').append(strArr2[i]);
                    }
                } else if (!z) {
                    stringBuffer.append('0').append(strArr2[i]);
                }
            } else if (j2 == 1) {
                obj = 1;
                stringBuffer.append('1').append(strArr[i]);
            } else {
                obj = 1;
                stringBuffer.append(j2).append(strArr2[i]);
            }
        }
        return stringBuffer.toString().trim();
    }
}
