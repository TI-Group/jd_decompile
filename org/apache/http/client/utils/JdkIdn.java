package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() throws ClassNotFoundException {
        try {
            this.toUnicode = Class.forName("java.net.IDN").getMethod("toUnicode", new Class[]{String.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    public String toUnicode(String str) {
        Throwable e;
        try {
            return (String) this.toUnicode.invoke(null, new Object[]{str});
        } catch (Throwable e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }
}
