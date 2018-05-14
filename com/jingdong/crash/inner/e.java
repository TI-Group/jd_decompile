package com.jingdong.crash.inner;

import android.text.TextUtils;
import com.jingdong.crash.a.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Pattern;

class e {
    private static String a = "ResolveException";
    private static int b = 7;
    private static String c = "com.jingdong";

    public static f a(Throwable th) {
        try {
            f fVar = new f();
            a(th, fVar, true);
            return fVar;
        } catch (Exception e) {
            Writer stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            return new f(new StringBuffer(stringWriter.toString()), "");
        }
    }

    private static void a(int i, StackTraceElement[] stackTraceElementArr, f fVar) {
        String str = stackTraceElementArr[i].getClassName() + "." + stackTraceElementArr[i].getMethodName() + "(" + stackTraceElementArr[i].getLineNumber() + ")" + "\n";
        fVar.a.append(str);
        if (TextUtils.isEmpty(fVar.b) && a(str)) {
            fVar.b = str;
        }
    }

    private static void a(Throwable th, f fVar, boolean z) {
        int i = 0;
        if (th != null && fVar != null) {
            fVar.a.append("\n---" + th.toString() + "\n");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (th.getCause() == null) {
                while (i < stackTrace.length) {
                    a(i, stackTrace, fVar);
                    i++;
                }
                return;
            }
            int length = stackTrace.length;
            if (length > b) {
                length = b;
            }
            for (int i2 = 0; i2 < length; i2++) {
                a(i2, stackTrace, fVar);
            }
            a(th.getCause(), fVar, false);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || b.b == null) {
            return false;
        }
        for (String compile : b.b) {
            if (Pattern.compile(compile, 2).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }
}
