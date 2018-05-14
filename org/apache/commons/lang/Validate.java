package org.apache.commons.lang;

import java.util.Collection;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class Validate {
    public static void isTrue(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(new StringBuffer().append(str).append(obj).toString());
        }
    }

    public static void isTrue(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(new StringBuffer().append(str).append(j).toString());
        }
    }

    public static void isTrue(boolean z, String str, double d) {
        if (!z) {
            throw new IllegalArgumentException(new StringBuffer().append(str).append(d).toString());
        }
    }

    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The validated object is null");
        }
    }

    public static void notEmpty(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException("The validated array is empty");
        }
    }

    public static void notEmpty(Collection collection, String str) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("The validated collection is empty");
        }
    }

    public static void notEmpty(Map map, String str) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map map) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException("The validated map is empty");
        }
    }

    public static void notEmpty(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The validated string is empty");
        }
    }

    public static void noNullElements(Object[] objArr, String str) {
        notNull(objArr);
        for (Object obj : objArr) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void noNullElements(Object[] objArr) {
        notNull(objArr);
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The validated array contains null element at index: ").append(i).toString());
            }
        }
    }

    public static void noNullElements(Collection collection, String str) {
        notNull(collection);
        int i = 0;
        for (Object obj : collection) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
            i++;
        }
    }

    public static void noNullElements(Collection collection) {
        notNull(collection);
        int i = 0;
        for (Object obj : collection) {
            if (obj == null) {
                throw new IllegalArgumentException(new StringBuffer().append("The validated collection contains null element at index: ").append(i).toString());
            }
            i++;
        }
    }
}
