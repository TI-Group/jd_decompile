package com.tencent.wxop.stat.common;

import android.util.Log;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.g;

public final class StatLogger {
    private String a = "default";
    private boolean b = true;
    private int c = 2;

    public StatLogger(String str) {
        this.a = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public final void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.c <= 3) {
            String a = a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.d(this.a, a);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.e(a);
            }
        }
    }

    public final void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public final void e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public final void error(Object obj) {
        if (this.c <= 6) {
            String a = a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.e(this.a, a);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.d(a);
            }
        }
    }

    public final void error(Throwable th) {
        if (this.c <= 6) {
            Log.e(this.a, "", th);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.d(th);
            }
        }
    }

    public final int getLogLevel() {
        return this.c;
    }

    public final void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public final void info(Object obj) {
        if (this.c <= 4) {
            String a = a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.i(this.a, a);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.a(a);
            }
        }
    }

    public final boolean isDebugEnable() {
        return this.b;
    }

    public final void setDebugEnable(boolean z) {
        this.b = z;
    }

    public final void setLogLevel(int i) {
        this.c = i;
    }

    public final void setTag(String str) {
        this.a = str;
    }

    public final void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public final void verbose(Object obj) {
        if (this.c <= 2) {
            String a = a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.v(this.a, a);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.b(a);
            }
        }
    }

    public final void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public final void warn(Object obj) {
        if (this.c <= 5) {
            String a = a();
            a = a == null ? obj.toString() : a + " - " + obj;
            Log.w(this.a, a);
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.c(a);
            }
        }
    }
}
