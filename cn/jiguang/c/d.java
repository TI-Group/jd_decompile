package cn.jiguang.c;

import cn.jiguang.api.BaseLogger;

public final class d {
    private static BaseLogger a = new c();

    public static void a(String str, String str2) {
        a.v(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        a.v(str, str2, th);
    }

    public static void b(String str, String str2) {
        a.vv(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        a.d(str, str2, th);
    }

    public static void c(String str, String str2) {
        a.d(str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        a.w(str, str2, th);
    }

    public static void d(String str, String str2) {
        a.dd(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        a.ww(str, str2, th);
    }

    public static void e(String str, String str2) {
        a.i(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a.e(str, str2, th);
    }

    public static void f(String str, String str2) {
        a.ii(str, str2);
    }

    public static void f(String str, String str2, Throwable th) {
        a.ee(str, str2, th);
    }

    public static void g(String str, String str2) {
        a.w(str, str2);
    }

    public static void h(String str, String str2) {
        a.ww(str, str2);
    }

    public static void i(String str, String str2) {
        a.e(str, str2);
    }

    public static void j(String str, String str2) {
        a.ee(str, str2);
    }
}
