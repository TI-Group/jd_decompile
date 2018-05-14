package cn.jiguang.a.c;

public final class b {
    private static b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }
}
