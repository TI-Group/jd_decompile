package c.a;

import android.util.Log;
import java.util.Formatter;

/* compiled from: TbsSdkJava */
public class as {
    public static boolean a = false;
    private static String b = "MobclickAgent";

    public static void a(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                b(b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            b(str, str2, null);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void b(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                d(b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            d(str, str2, null);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void c(String str, Object... objArr) {
        try {
            String str2 = "";
            if (str.contains("%")) {
                c(b, new Formatter().format(str, objArr).toString(), null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            c(str, str2, null);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Throwable th) {
        d(b, null, th);
    }

    public static void a(String str, Throwable th) {
        b(b, str, th);
    }

    public static void b(String str, Throwable th) {
        d(b, str, th);
    }

    public static void a(String str) {
        a(b, str, null);
    }

    public static void b(String str) {
        b(b, str, null);
    }

    public static void c(String str) {
        c(b, str, null);
    }

    public static void d(String str) {
        d(b, str, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!a) {
            return;
        }
        if (th != null) {
            if (str2 != null) {
                Log.d(str, th.toString() + ":  [" + str2 + "]");
            } else {
                Log.d(str, th.toString());
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                Log.d(str, "        at  " + stackTraceElement.toString());
            }
        } else if (str2 == null) {
            try {
                Log.w(str, "the msg is null!");
            } catch (Throwable th2) {
            }
        } else {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (!a) {
            return;
        }
        if (th != null) {
            if (str2 != null) {
                Log.i(str, th.toString() + ":  [" + str2 + "]");
            } else {
                Log.i(str, th.toString());
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                Log.i(str, "        at  " + stackTraceElement.toString());
            }
        } else if (str2 == null) {
            try {
                Log.w(str, "the msg is null!");
            } catch (Throwable th2) {
            }
        } else {
            Log.i(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (!a) {
            return;
        }
        if (th != null) {
            if (str2 != null) {
                Log.w(str, th.toString() + ":  [" + str2 + "]");
            } else {
                Log.w(str, th.toString());
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                Log.w(str, "        at  " + stackTraceElement.toString());
            }
        } else if (str2 == null) {
            try {
                Log.w(str, "the msg is null!");
            } catch (Throwable th2) {
            }
        } else {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (!a) {
            return;
        }
        if (th != null) {
            if (str2 != null) {
                Log.e(str, th.toString() + ":  [" + str2 + "]");
            } else {
                Log.e(str, th.toString());
            }
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                Log.e(str, "        at  " + stackTraceElement.toString());
            }
        } else if (str2 == null) {
            try {
                Log.w(str, "the msg is null!");
            } catch (Throwable th2) {
            }
        } else {
            Log.e(str, str2);
        }
    }
}
