package org.apache.commons.lang;

import org.apache.commons.lang.math.NumberUtils;

/* compiled from: TbsSdkJava */
public class BooleanUtils {
    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean toBoolean(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z) {
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public static boolean toBoolean(int i) {
        return i != 0;
    }

    public static Boolean toBooleanObject(int i) {
        return i == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean toBoolean(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        if (i == i3) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else if (num.equals(num2)) {
            return true;
        } else {
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(int i, int i2, int i3, int i4) {
        if (i == i2) {
            return Boolean.TRUE;
        }
        if (i == i3) {
            return Boolean.FALSE;
        }
        if (i == i4) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else if (num.equals(num2)) {
            return Boolean.TRUE;
        } else {
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static int toInteger(boolean z) {
        return z ? 1 : 0;
    }

    public static Integer toIntegerObject(boolean z) {
        return z ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static int toInteger(boolean z, int i, int i2) {
        return z ? i : i2;
    }

    public static int toInteger(Boolean bool, int i, int i2, int i3) {
        if (bool == null) {
            return i3;
        }
        if (!bool.booleanValue()) {
            i = i2;
        }
        return i;
    }

    public static Integer toIntegerObject(boolean z, Integer num, Integer num2) {
        return z ? num : num2;
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        if (bool == null) {
            return num3;
        }
        if (!bool.booleanValue()) {
            num = num2;
        }
        return num;
    }

    public static Boolean toBooleanObject(String str) {
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("on".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("off".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        if ("yes".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("no".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else if (str.equals(str2)) {
            return Boolean.TRUE;
        } else {
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }

    public static boolean toBoolean(String str) {
        if ("true".equalsIgnoreCase(str) || "on".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            if (str3 == null) {
                return false;
            }
        } else if (str.equals(str2)) {
            return true;
        } else {
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, "true", "false", null);
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, "on", "off", null);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, "yes", "no", null);
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        if (bool == null) {
            return str3;
        }
        if (!bool.booleanValue()) {
            str = str2;
        }
        return str;
    }

    public static String toStringTrueFalse(boolean z) {
        return toString(z, "true", "false");
    }

    public static String toStringOnOff(boolean z) {
        return toString(z, "on", "off");
    }

    public static String toStringYesNo(boolean z) {
        return toString(z, "yes", "no");
    }

    public static String toString(boolean z, String str, String str2) {
        return z ? str : str2;
    }

    public static boolean xor(boolean[] zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            int i = 0;
            for (boolean z : zArr) {
                if (z) {
                    if (i >= 1) {
                        return false;
                    }
                    i++;
                }
            }
            if (i == 1) {
                return true;
            }
            return false;
        }
    }

    public static Boolean xor(Boolean[] boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            try {
                return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("The array must not conatin any null elements");
            }
        }
    }
}
