package org.apache.commons.lang;

/* compiled from: TbsSdkJava */
public class WordUtils {
    public static String wrap(String str, int i) {
        return wrap(str, i, null, false);
    }

    public static String wrap(String str, int i, String str2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = SystemUtils.LINE_SEPARATOR;
        }
        if (i < 1) {
            i = 1;
        }
        int length = str.length();
        int i2 = 0;
        StringBuffer stringBuffer = new StringBuffer(length + 32);
        while (length - i2 > i) {
            if (str.charAt(i2) == ' ') {
                i2++;
            } else {
                int lastIndexOf = str.lastIndexOf(32, i + i2);
                if (lastIndexOf >= i2) {
                    stringBuffer.append(str.substring(i2, lastIndexOf));
                    stringBuffer.append(str2);
                    i2 = lastIndexOf + 1;
                } else if (z) {
                    stringBuffer.append(str.substring(i2, i + i2));
                    stringBuffer.append(str2);
                    i2 += i;
                } else {
                    lastIndexOf = str.indexOf(32, i + i2);
                    if (lastIndexOf >= 0) {
                        stringBuffer.append(str.substring(i2, lastIndexOf));
                        stringBuffer.append(str2);
                        i2 = lastIndexOf + 1;
                    } else {
                        stringBuffer.append(str.substring(i2));
                        i2 = length;
                    }
                }
            }
        }
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static String capitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isWhitespace(charAt)) {
                stringBuffer.append(charAt);
                obj = 1;
            } else if (obj != null) {
                stringBuffer.append(Character.toTitleCase(charAt));
                obj = null;
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String capitalizeFully(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isWhitespace(charAt)) {
                stringBuffer.append(charAt);
                obj = 1;
            } else if (obj != null) {
                stringBuffer.append(Character.toTitleCase(charAt));
                obj = null;
            } else {
                stringBuffer.append(Character.toLowerCase(charAt));
            }
        }
        return stringBuffer.toString();
    }

    public static String uncapitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = 1;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isWhitespace(charAt)) {
                stringBuffer.append(charAt);
                obj = 1;
            } else if (obj != null) {
                stringBuffer.append(Character.toLowerCase(charAt));
                obj = null;
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String swapCase(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        boolean z = true;
        while (i < length) {
            char charAt = str.charAt(i);
            char toLowerCase = Character.isUpperCase(charAt) ? Character.toLowerCase(charAt) : Character.isTitleCase(charAt) ? Character.toLowerCase(charAt) : Character.isLowerCase(charAt) ? z ? Character.toTitleCase(charAt) : Character.toUpperCase(charAt) : charAt;
            stringBuffer.append(toLowerCase);
            i++;
            z = Character.isWhitespace(charAt);
        }
        return stringBuffer.toString();
    }
}
