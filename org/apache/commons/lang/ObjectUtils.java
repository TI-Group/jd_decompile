package org.apache.commons.lang;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class ObjectUtils {
    public static final Null NULL = new Null();

    /* compiled from: TbsSdkJava */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static Object defaultIfNull(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return appendIdentityToString(null, obj).toString();
    }

    public static StringBuffer appendIdentityToString(StringBuffer stringBuffer, Object obj) {
        if (obj == null) {
            return null;
        }
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer();
        }
        return stringBuffer.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }
}
