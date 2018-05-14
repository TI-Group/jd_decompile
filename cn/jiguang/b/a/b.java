package cn.jiguang.b.a;

public final class b {
    private static volatile Long a;
    private static volatile Long b;

    static synchronized void a(long j, long j2) {
        synchronized (b.class) {
            a = Long.valueOf(j);
            b = Long.valueOf(j2);
        }
    }

    static boolean a() {
        return (a == null || b == null) ? false : true;
    }

    static long b() {
        return a.longValue() - b.longValue();
    }
}
