package cn.jiguang.c;

import android.util.Log;

public final class a implements b {
    public final void a(String str, String str2) {
        Log.v(str, str2);
    }

    public final void a(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }

    public final void b(String str, String str2) {
        Log.d(str, str2);
    }

    public final void b(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    public final void c(String str, String str2) {
        Log.i(str, str2);
    }

    public final void c(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    public final void d(String str, String str2) {
        Log.w(str, str2);
    }

    public final void d(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    public final void e(String str, String str2) {
        Log.e(str, str2);
    }

    public final void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
