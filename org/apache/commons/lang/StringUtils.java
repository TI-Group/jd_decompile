package org.apache.commons.lang;

import android.support.v4.internal.view.SupportMenu;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TbsSdkJava */
public class StringUtils {
    public static final String EMPTY = "";
    private static final String[] PADDING = new String[SupportMenu.USER_MASK];
    private static final int PAD_LIMIT = 8192;

    static {
        PADDING[32] = "                                                                ";
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isBlank(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String clean(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        return (trim == null || trim.length() == 0) ? null : trim;
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, null);
        if (strip.length() != 0) {
            return strip;
        }
        return null;
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String strip(String str, String str2) {
        return (str == null || str.length() == 0) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String stripStart(String str, String str2) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String stripEnd(String str, String str2) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.length() == 0) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String[] stripAll(String[] strArr) {
        return stripAll(strArr, null);
    }

    public static String[] stripAll(String[] strArr, String str) {
        if (strArr == null) {
            return strArr;
        }
        int length = strArr.length;
        if (length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = strip(strArr[i], str);
        }
        return strArr2;
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static int indexOf(String str, char c) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.indexOf(c);
    }

    public static int indexOf(String str, char c, int i) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.indexOf(c, i);
    }

    public static int indexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.indexOf(str2);
    }

    public static int indexOf(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return -1;
        }
        if (str2.length() != 0 || i < str.length()) {
            return str.indexOf(str2, i);
        }
        return str.length();
    }

    public static int lastIndexOf(String str, char c) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.lastIndexOf(c);
    }

    public static int lastIndexOf(String str, char c, int i) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        return str.lastIndexOf(c, i);
    }

    public static int lastIndexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2);
    }

    public static int lastIndexOf(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2, i);
    }

    public static boolean contains(String str, char c) {
        if (str == null || str.length() == 0 || str.indexOf(c) < 0) {
            return false;
        }
        return true;
    }

    public static boolean contains(String str, String str2) {
        if (str == null || str2 == null || str.indexOf(str2) < 0) {
            return false;
        }
        return true;
    }

    public static int indexOfAny(String str, char[] cArr) {
        if (str == null || str.length() == 0 || cArr == null || cArr.length == 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            for (char c : cArr) {
                if (c == charAt) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int indexOfAny(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        return indexOfAny(str, str2.toCharArray());
    }

    public static int indexOfAnyBut(String str, char[] cArr) {
        if (str == null || str.length() == 0 || cArr == null || cArr.length == 0) {
            return -1;
        }
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i2 = 0;
            while (i2 < cArr.length) {
                if (cArr[i2] == charAt) {
                    i++;
                } else {
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int indexOfAnyBut(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str2.indexOf(str.charAt(i)) < 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean containsOnly(String str, char[] cArr) {
        if (cArr == null || str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        if (cArr.length == 0) {
            return false;
        }
        if (indexOfAnyBut(str, cArr) != -1) {
            return false;
        }
        return true;
    }

    public static boolean containsOnly(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return containsOnly(str, str2.toCharArray());
    }

    public static boolean containsNone(String str, char[] cArr) {
        if (str == null || cArr == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            for (char c : cArr) {
                if (c == charAt) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean containsNone(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return containsNone(str, str2.toCharArray());
    }

    public static int indexOfAny(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return -1;
        }
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (String str2 : strArr) {
            if (str2 != null) {
                int indexOf = str.indexOf(str2);
                if (indexOf != -1 && indexOf < i) {
                    i = indexOf;
                }
            }
        }
        return i == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : i;
    }

    public static int lastIndexOfAny(String str, String[] strArr) {
        int i = -1;
        if (!(str == null || strArr == null)) {
            for (String str2 : strArr) {
                if (str2 != null) {
                    int lastIndexOf = str.lastIndexOf(str2);
                    if (lastIndexOf > i) {
                        i = lastIndexOf;
                    }
                }
            }
        }
        return i;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        int length;
        if (i < 0) {
            length = str.length() + i;
        } else {
            length = i;
        }
        if (length < 0) {
            length = 0;
        }
        if (length > str.length()) {
            return "";
        }
        return str.substring(length);
    }

    public static String substring(String str, int i, int i2) {
        int i3 = 0;
        if (str == null) {
            return null;
        }
        int length;
        if (i2 < 0) {
            length = str.length() + i2;
        } else {
            length = i2;
        }
        if (i < 0) {
            i += str.length();
        }
        if (length > str.length()) {
            length = str.length();
        }
        if (i > length) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (length >= 0) {
            i3 = length;
        }
        return str.substring(i, i3);
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        return str.length() > i ? str.substring(str.length() - i) : str;
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (str.length() <= i + i2) {
            return str.substring(i);
        }
        return str.substring(i, i + i2);
    }

    public static String substringBefore(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0) {
            return str;
        }
        if (str2.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    public static String substringAfter(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str2 == null) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String substringBeforeLast(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(str2);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public static String substringAfterLast(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String substringBetween(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(str3, str2.length() + indexOf);
        if (indexOf2 != -1) {
            return str.substring(str2.length() + indexOf, indexOf2);
        }
        return null;
    }

    public static String getNestedString(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String getNestedString(String str, String str2, String str3) {
        return substringBetween(str, str2, str3);
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] split(String str, char c) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        List arrayList = new ArrayList();
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == c) {
                if (obj != null) {
                    arrayList.add(str.substring(i, i2));
                    obj = null;
                }
                i = i2 + 1;
                i2 = i;
            } else {
                obj = 1;
                i2++;
            }
        }
        if (obj != null) {
            arrayList.add(str.substring(i, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] split(String str, String str2) {
        return split(str, str2, -1);
    }

    public static String[] split(String str, String str2, int i) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int i2;
        int i3;
        List arrayList = new ArrayList();
        int i4;
        int i5;
        int i6;
        if (str2 == null) {
            i2 = 0;
            i4 = 0;
            i3 = 0;
            i5 = 1;
            while (i3 < length) {
                if (Character.isWhitespace(str.charAt(i3))) {
                    if (i2 != 0) {
                        i2 = i5 + 1;
                        if (i5 == i) {
                            i3 = length;
                        }
                        arrayList.add(str.substring(i4, i3));
                        i5 = i2;
                        i2 = i3;
                        i3 = 0;
                    } else {
                        i6 = i2;
                        i2 = i3;
                        i3 = i6;
                    }
                    i4 = i2 + 1;
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3++;
                    i2 = 1;
                }
            }
            length = i3;
            i3 = i4;
        } else if (str2.length() == 1) {
            char charAt = str2.charAt(0);
            i2 = 0;
            i4 = 0;
            i3 = 0;
            i5 = 1;
            while (i3 < length) {
                if (str.charAt(i3) == charAt) {
                    if (i2 != 0) {
                        i2 = i5 + 1;
                        if (i5 == i) {
                            i3 = length;
                        }
                        arrayList.add(str.substring(i4, i3));
                        i5 = i2;
                        i2 = i3;
                        i3 = 0;
                    } else {
                        i6 = i2;
                        i2 = i3;
                        i3 = i6;
                    }
                    i4 = i2 + 1;
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3++;
                    i2 = 1;
                }
            }
            length = i3;
            i3 = i4;
        } else {
            i2 = 0;
            i4 = 0;
            i3 = 0;
            i5 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (i2 != 0) {
                        i2 = i5 + 1;
                        if (i5 == i) {
                            i3 = length;
                        }
                        arrayList.add(str.substring(i4, i3));
                        i5 = i2;
                        i2 = i3;
                        i3 = 0;
                    } else {
                        i6 = i2;
                        i2 = i3;
                        i3 = i6;
                    }
                    i4 = i2 + 1;
                    i2 = i3;
                    i3 = i4;
                } else {
                    i3++;
                    i2 = 1;
                }
            }
            length = i3;
            i3 = i4;
        }
        if (i2 != 0) {
            arrayList.add(str.substring(i3, length));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String concatenate(Object[] objArr) {
        return join(objArr, null);
    }

    public static String join(Object[] objArr) {
        return join(objArr, null);
    }

    public static String join(Object[] objArr, char c) {
        int i = 0;
        if (objArr == null) {
            return null;
        }
        int i2;
        int length = objArr.length;
        if (length == 0) {
            i2 = 0;
        } else {
            i2 = ((objArr[0] == null ? 16 : objArr[0].toString().length()) + 1) * length;
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        while (i < length) {
            if (i > 0) {
                stringBuffer.append(c);
            }
            if (objArr[i] != null) {
                stringBuffer.append(objArr[i]);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String join(Object[] objArr, String str) {
        int i = 0;
        if (objArr == null) {
            return null;
        }
        int i2;
        if (str == null) {
            str = "";
        }
        int length = objArr.length;
        if (length == 0) {
            i2 = 0;
        } else {
            i2 = ((str != null ? str.length() : 0) + (objArr[0] == null ? 16 : objArr[0].toString().length())) * length;
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        while (i < length) {
            if (str != null && i > 0) {
                stringBuffer.append(str);
            }
            if (objArr[i] != null) {
                stringBuffer.append(objArr[i]);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    public static String join(Iterator it, char c) {
        if (it == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                stringBuffer.append(next);
            }
            if (it.hasNext()) {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static String join(Iterator it, String str) {
        if (it == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                stringBuffer.append(next);
            }
            if (str != null && it.hasNext()) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    public static String deleteSpaces(String str) {
        if (str == null) {
            return null;
        }
        return CharSetUtils.delete(str, " \t\r\n\b");
    }

    public static String deleteWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replace(String str, String str2, String str3, int i) {
        if (str == null || str2 == null || str3 == null || str2.length() == 0 || i == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        int i2 = 0;
        do {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf == -1) {
                break;
            }
            stringBuffer.append(str.substring(i2, indexOf)).append(str3);
            i2 = str2.length() + indexOf;
            i--;
        } while (i != 0);
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return str;
        }
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int length2 = str2.length();
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3;
            char charAt = str2.charAt(i);
            if (str3 == null || i >= str3.length()) {
                int i4 = 0;
                i3 = 0;
                int i5 = i2;
                while (i4 < length) {
                    if (toCharArray[i4] != charAt) {
                        i2 = i3 + 1;
                        toCharArray[i3] = toCharArray[i4];
                        i3 = i5;
                    } else {
                        i2 = i3;
                        i3 = 1;
                    }
                    i4++;
                    i5 = i3;
                    i3 = i2;
                }
                i2 = i5;
            } else {
                for (i3 = 0; i3 < length; i3++) {
                    if (toCharArray[i3] == charAt) {
                        toCharArray[i3] = str3.charAt(i);
                        i2 = 1;
                    }
                }
                i3 = length;
            }
            i++;
            length = i3;
        }
        return i2 != 0 ? new String(toCharArray, 0, length) : str;
    }

    public static String overlayString(String str, String str2, int i, int i2) {
        return new StringBuffer((((str2.length() + i) + str.length()) - i2) + 1).append(str.substring(0, i)).append(str2).append(str.substring(i2)).toString();
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        int i3;
        int i4;
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if (i3 > length) {
            i3 = length;
        }
        if (i2 < 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        if (i4 > length) {
            i4 = length;
        }
        if (i3 <= i4) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        return new StringBuffer((((length + i4) - i3) + str2.length()) + 1).append(str.substring(0, i4)).append(str2).append(str.substring(i3)).toString();
    }

    public static String chomp(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (charAt == '\r' || charAt == '\n') {
                return "";
            }
            return str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == '\n') {
            if (str.charAt(length - 1) == '\r') {
                length--;
            }
        } else if (charAt2 != '\r') {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chomp(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    public static String chompLast(String str, String str2) {
        if (str.length() != 0 && str2.equals(str.substring(str.length() - str2.length()))) {
            return str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static String getChomp(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == str.length() - str2.length()) {
            return str2;
        }
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf);
        }
        return "";
    }

    public static String prechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            return str.substring(indexOf + str2.length());
        }
        return str;
    }

    public static String getPrechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            return str.substring(0, indexOf + str2.length());
        }
        return "";
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == '\n' && substring.charAt(i - 1) == '\r') {
            return substring.substring(0, i - 1);
        }
        return substring;
    }

    public static String chopNewline(String str) {
        int length = str.length() - 1;
        if (length <= 0) {
            return "";
        }
        if (str.charAt(length) != '\n') {
            length++;
        } else if (str.charAt(length - 1) == '\r') {
            length--;
        }
        return str.substring(0, length);
    }

    public static String escape(String str) {
        return StringEscapeUtils.escapeJava(str);
    }

    public static String repeat(String str, int i) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return padding(i, str.charAt(0));
        }
        int i3 = length * i;
        char charAt;
        char[] cArr;
        switch (length) {
            case 1:
                charAt = str.charAt(0);
                cArr = new char[i3];
                for (i2 = i - 1; i2 >= 0; i2--) {
                    cArr[i2] = charAt;
                }
                return new String(cArr);
            case 2:
                charAt = str.charAt(0);
                char charAt2 = str.charAt(1);
                cArr = new char[i3];
                for (i2 = (i * 2) - 2; i2 >= 0; i2 = (i2 - 1) - 1) {
                    cArr[i2] = charAt;
                    cArr[i2 + 1] = charAt2;
                }
                return new String(cArr);
            default:
                StringBuffer stringBuffer = new StringBuffer(i3);
                while (i2 < i) {
                    stringBuffer.append(str);
                    i2++;
                }
                return stringBuffer.toString();
        }
    }

    private static String padding(int i, char c) {
        String str = PADDING[c];
        if (str == null) {
            str = String.valueOf(c);
        }
        while (str.length() < i) {
            str = str.concat(str);
        }
        PADDING[c] = str;
        return str.substring(0, i);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rightPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c));
        }
        return str.concat(padding(length, c));
    }

    public static String rightPad(String str, int i, String str2) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] toCharArray = str2.toCharArray();
        while (i2 < length2) {
            cArr[i2] = toCharArray[i2 % length];
            i2++;
        }
        return str.concat(new String(cArr));
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return padding(length, c).concat(str);
    }

    public static String leftPad(String str, int i, String str2) {
        int i2 = 0;
        if (str == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] toCharArray = str2.toCharArray();
        while (i2 < length2) {
            cArr[i2] = toCharArray[i2 % length];
            i2++;
        }
        return new String(cArr).concat(str);
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    public static String center(String str, int i, char c) {
        if (str == null || i <= 0) {
            return str;
        }
        int length = str.length();
        int i2 = i - length;
        if (i2 > 0) {
            return rightPad(leftPad(str, length + (i2 / 2), c), i, c);
        }
        return str;
    }

    public static String center(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return str;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = " ";
        }
        int length = str.length();
        int i2 = i - length;
        if (i2 > 0) {
            return rightPad(leftPad(str, length + (i2 / 2), str2), i, str2);
        }
        return str;
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String capitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        return length == 0 ? str : new StringBuffer(length).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String capitalise(String str) {
        return capitalize(str);
    }

    public static String uncapitalize(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        return length == 0 ? str : new StringBuffer(length).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
    }

    public static String uncapitalise(String str) {
        return uncapitalize(str);
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
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                charAt = Character.toLowerCase(charAt);
            } else if (Character.isTitleCase(charAt)) {
                charAt = Character.toLowerCase(charAt);
            } else if (Character.isLowerCase(charAt)) {
                charAt = Character.toUpperCase(charAt);
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static String capitaliseAllWords(String str) {
        return WordUtils.capitalize(str);
    }

    public static int countMatches(String str, String str2) {
        int i = 0;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            i = str.indexOf(str2, i);
            if (i == -1) {
                return i2;
            }
            i2++;
            i += str2.length();
        }
    }

    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' ') {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        if (str == null) {
            return null;
        }
        Object[] split = split(str, c);
        ArrayUtils.reverse(split);
        return join(split, c);
    }

    public static String reverseDelimitedString(String str, String str2) {
        if (str == null) {
            return null;
        }
        Object[] split = split(str, str2);
        ArrayUtils.reverse(split);
        if (str2 == null) {
            return join(split, ' ');
        }
        return join(split, str2);
    }

    public static String abbreviate(String str, int i) {
        return abbreviate(str, 0, i);
    }

    public static String abbreviate(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        } else if (str.length() <= i2) {
            return str;
        } else {
            if (i > str.length()) {
                i = str.length();
            }
            if (str.length() - i < i2 - 3) {
                i = str.length() - (i2 - 3);
            }
            if (i <= 4) {
                return new StringBuffer().append(str.substring(0, i2 - 3)).append("...").toString();
            }
            if (i2 < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            } else if ((i2 - 3) + i < str.length()) {
                return new StringBuffer().append("...").append(abbreviate(str.substring(i), i2 - 3)).toString();
            } else {
                return new StringBuffer().append("...").append(str.substring(str.length() - (i2 - 3))).toString();
            }
        }
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static int indexOfDifference(String str, String str2) {
        int i = 0;
        if (str == str2) {
            return -1;
        }
        if (str == null || str2 == null) {
            return 0;
        }
        while (i < str.length() && i < str2.length() && str.charAt(i) == str2.charAt(i)) {
            i++;
        }
        if (i < str2.length() || i < str.length()) {
            return i;
        }
        return -1;
    }

    public static int getLevenshteinDistance(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        int i;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{length + 1, length2 + 1});
        for (i = 0; i <= length; i++) {
            iArr[i][0] = i;
        }
        for (i = 0; i <= length2; i++) {
            iArr[0][i] = i;
        }
        for (int i2 = 1; i2 <= length; i2++) {
            char charAt = str.charAt(i2 - 1);
            for (int i3 = 1; i3 <= length2; i3++) {
                if (charAt == str2.charAt(i3 - 1)) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[i2][i3] = min(iArr[i2 - 1][i3] + 1, iArr[i2][i3 - 1] + 1, i + iArr[i2 - 1][i3 - 1]);
            }
        }
        return iArr[length][length2];
    }

    private static int min(int i, int i2, int i3) {
        int i4;
        if (i2 < i) {
            i4 = i2;
        } else {
            i4 = i;
        }
        return i3 < i4 ? i3 : i4;
    }
}
