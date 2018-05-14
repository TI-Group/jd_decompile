package org.apache.http.client.utils;

import java.util.StringTokenizer;
import org.apache.commons.lang.ClassUtils;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 128;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    private int adapt(int i, int i2, boolean z) {
        int i3;
        if (z) {
            i3 = i / damp;
        } else {
            i3 = i / 2;
        }
        int i4 = (i3 / i2) + i3;
        i3 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i3 += 36;
        }
        return i3 + ((i4 * 36) / (i4 + 38));
    }

    private int digit(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 65;
        }
        if (c >= 'a' && c <= 'z') {
            return c - 97;
        }
        if (c >= '0' && c <= '9') {
            return (c - 48) + 26;
        }
        throw new IllegalArgumentException("illegal digit: " + c);
    }

    public String toUnicode(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            if (nextToken.startsWith(ACE_PREFIX)) {
                nextToken = decode(nextToken.substring(4));
            }
            stringBuilder.append(nextToken);
        }
        return stringBuilder.toString();
    }

    protected String decode(String str) {
        int i;
        int i2 = 72;
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf != -1) {
            stringBuilder.append(str.subSequence(0, lastIndexOf));
            str = str.substring(lastIndexOf + 1);
            lastIndexOf = 128;
            i = 0;
        } else {
            lastIndexOf = 128;
            i = 0;
        }
        while (str.length() > 0) {
            boolean z;
            int i3 = 36;
            int i4 = 1;
            int i5 = i;
            while (str.length() != 0) {
                int i6;
                char charAt = str.charAt(0);
                str = str.substring(1);
                int digit = digit(charAt);
                i5 += digit * i4;
                if (i3 <= i2 + 1) {
                    i6 = 1;
                } else if (i3 >= i2 + 26) {
                    i6 = 26;
                } else {
                    i6 = i3 - i2;
                }
                if (digit < i6) {
                    break;
                }
                i4 *= 36 - i6;
                i3 += 36;
            }
            i3 = i5 - i;
            i4 = stringBuilder.length() + 1;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            i2 = adapt(i3, i4, z);
            lastIndexOf += i5 / (stringBuilder.length() + 1);
            i = i5 % (stringBuilder.length() + 1);
            stringBuilder.insert(i, (char) lastIndexOf);
            i++;
        }
        return stringBuilder.toString();
    }
}
