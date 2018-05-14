package org.apache.http.util;

import java.lang.reflect.Method;

@Deprecated
/* compiled from: TbsSdkJava */
public final class ExceptionUtils {
    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();

    private static Method getInitCauseMethod() {
        try {
            return Throwable.class.getMethod("initCause", new Class[]{Throwable.class});
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static void initCause(Throwable th, Throwable th2) {
        if (INIT_CAUSE_METHOD != null) {
            try {
                INIT_CAUSE_METHOD.invoke(th, new Object[]{th2});
            } catch (Exception e) {
            }
        }
    }

    private ExceptionUtils() {
    }
}
