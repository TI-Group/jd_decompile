package org.apache.commons.lang;

import com.jingdong.jdma.JDMaInterface;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: TbsSdkJava */
public final class NumberUtils {
    public static int stringToInt(String str) {
        return stringToInt(str, 0);
    }

    public static int stringToInt(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        return i;
    }

    public static Number createNumber(String str) throws NumberFormatException {
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            throw new NumberFormatException("\"\" is not a valid number.");
        } else if (str.startsWith("--")) {
            return null;
        } else {
            if (str.startsWith("0x") || str.startsWith("-0x")) {
                return createInteger(str);
            }
            String substring;
            String substring2;
            char charAt = str.charAt(str.length() - 1);
            int indexOf = str.indexOf(46);
            int indexOf2 = (str.indexOf(101) + str.indexOf(69)) + 1;
            if (indexOf > -1) {
                if (indexOf2 <= -1) {
                    substring = str.substring(indexOf + 1);
                } else if (indexOf2 < indexOf) {
                    throw new NumberFormatException(new StringBuffer().append(str).append(" is not a valid number.").toString());
                } else {
                    substring = str.substring(indexOf + 1, indexOf2);
                }
                substring2 = str.substring(0, indexOf);
            } else {
                if (indexOf2 > -1) {
                    substring = str.substring(0, indexOf2);
                } else {
                    substring = str;
                }
                substring2 = substring;
                substring = null;
            }
            Number createFloat;
            if (Character.isDigit(charAt)) {
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str2 = str.substring(indexOf2 + 1, str.length());
                }
                if (substring == null && str2 == null) {
                    try {
                        return createInteger(str);
                    } catch (NumberFormatException e) {
                        try {
                            return createLong(str);
                        } catch (NumberFormatException e2) {
                            return createBigInteger(str);
                        }
                    }
                }
                int i = (isAllZeros(substring2) && isAllZeros(str2)) ? 1 : 0;
                try {
                    createFloat = createFloat(str);
                    if (!(createFloat.isInfinite() || (createFloat.floatValue() == 0.0f && i == 0))) {
                        return createFloat;
                    }
                } catch (NumberFormatException e3) {
                }
                try {
                    createFloat = createDouble(str);
                    if (!(createFloat.isInfinite() || (createFloat.doubleValue() == JDMaInterface.PV_UPPERLIMIT && i == 0))) {
                        return createFloat;
                    }
                } catch (NumberFormatException e4) {
                }
                return createBigDecimal(str);
            }
            if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                str2 = str.substring(indexOf2 + 1, str.length() - 1);
            }
            String substring3 = str.substring(0, str.length() - 1);
            indexOf = (isAllZeros(substring2) && isAllZeros(str2)) ? 1 : 0;
            switch (charAt) {
                case 'D':
                case 'd':
                    break;
                case 'F':
                case 'f':
                    try {
                        createFloat = createFloat(substring3);
                        if (!(createFloat.isInfinite() || (createFloat.floatValue() == 0.0f && indexOf == 0))) {
                            return createFloat;
                        }
                    } catch (NumberFormatException e5) {
                        break;
                    }
                case 'L':
                case 'l':
                    if (substring == null && str2 == null && isDigits(substring3.substring(1)) && (substring3.charAt(0) == '-' || Character.isDigit(substring3.charAt(0)))) {
                        try {
                            return createLong(substring3);
                        } catch (NumberFormatException e6) {
                            return createBigInteger(substring3);
                        }
                    }
                    throw new NumberFormatException(new StringBuffer().append(str).append(" is not a valid number.").toString());
            }
            try {
                createFloat = createDouble(substring3);
                if (!(createFloat.isInfinite() || (((double) createFloat.floatValue()) == JDMaInterface.PV_UPPERLIMIT && indexOf == 0))) {
                    return createFloat;
                }
            } catch (NumberFormatException e7) {
            }
            try {
                return createBigDecimal(substring3);
            } catch (NumberFormatException e8) {
                throw new NumberFormatException(new StringBuffer().append(str).append(" is not a valid number.").toString());
            }
        }
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() <= 0) {
            return false;
        }
        return true;
    }

    public static Float createFloat(String str) {
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        return Long.valueOf(str);
    }

    public static BigInteger createBigInteger(String str) {
        return new BigInteger(str);
    }

    public static BigDecimal createBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static long minimum(long j, long j2, long j3) {
        long j4;
        if (j2 < j) {
            j4 = j2;
        } else {
            j4 = j;
        }
        return j3 < j4 ? j3 : j4;
    }

    public static int minimum(int i, int i2, int i3) {
        int i4;
        if (i2 < i) {
            i4 = i2;
        } else {
            i4 = i;
        }
        return i3 < i4 ? i3 : i4;
    }

    public static long maximum(long j, long j2, long j3) {
        long j4;
        if (j2 > j) {
            j4 = j2;
        } else {
            j4 = j;
        }
        return j3 > j4 ? j3 : j4;
    }

    public static int maximum(int i, int i2, int i3) {
        int i4;
        if (i2 > i) {
            i4 = i2;
        } else {
            i4 = i;
        }
        return i3 > i4 ? i3 : i4;
    }

    public static int compare(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        long doubleToLongBits2 = Double.doubleToLongBits(d2);
        if (doubleToLongBits == doubleToLongBits2) {
            return 0;
        }
        if (doubleToLongBits >= doubleToLongBits2) {
            return 1;
        }
        return -1;
    }

    public static int compare(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        int floatToIntBits = Float.floatToIntBits(f);
        int floatToIntBits2 = Float.floatToIntBits(f2);
        if (floatToIntBits == floatToIntBits2) {
            return 0;
        }
        if (floatToIntBits >= floatToIntBits2) {
            return 1;
        }
        return -1;
    }

    public static boolean isDigits(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        boolean z = true;
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i = toCharArray[0] == '-' ? 1 : 0;
        if (length > i + 1 && toCharArray[i] == '0' && toCharArray[i + 1] == 'x') {
            i += 2;
            if (i == length) {
                return false;
            }
            while (i < toCharArray.length) {
                if ((toCharArray[i] < '0' || toCharArray[i] > '9') && ((toCharArray[i] < 'a' || toCharArray[i] > 'f') && (toCharArray[i] < 'A' || toCharArray[i] > 'F'))) {
                    return false;
                }
                i++;
            }
            return true;
        }
        int i2 = length - 1;
        int i3 = i;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (i3 < i2 || (i3 < i2 + 1 && z2 && !z5)) {
                if (toCharArray[i3] >= '0' && toCharArray[i3] <= '9') {
                    z5 = true;
                    z2 = false;
                } else if (toCharArray[i3] == ClassUtils.PACKAGE_SEPARATOR_CHAR) {
                    if (z3 || z4) {
                        return false;
                    }
                    z3 = true;
                } else if (toCharArray[i3] == 'e' || toCharArray[i3] == 'E') {
                    if (z4 || !z5) {
                        return false;
                    }
                    z2 = true;
                    z4 = true;
                } else if ((toCharArray[i3] != '+' && toCharArray[i3] != '-') || !z2) {
                    return false;
                } else {
                    z5 = false;
                    z2 = false;
                }
                i3++;
            }
        }
        if (i3 >= toCharArray.length) {
            if (z2 || !z5) {
                z = false;
            }
            return z;
        } else if (toCharArray[i3] >= '0' && toCharArray[i3] <= '9') {
            return true;
        } else {
            if (toCharArray[i3] == 'e' || toCharArray[i3] == 'E') {
                return false;
            }
            if (!z2 && (toCharArray[i3] == 'd' || toCharArray[i3] == 'D' || toCharArray[i3] == 'f' || toCharArray[i3] == 'F')) {
                return z5;
            }
            if (toCharArray[i3] != 'l' && toCharArray[i3] != 'L') {
                return false;
            }
            if (!z5 || z4) {
                z = false;
            }
            return z;
        }
    }
}
