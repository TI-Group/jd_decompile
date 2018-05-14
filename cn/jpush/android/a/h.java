package cn.jpush.android.a;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: TbsSdkJava */
public final class h {
    private static Queue<Integer> a = new ConcurrentLinkedQueue();

    public static int a() {
        return a.size() > 0 ? ((Integer) a.poll()).intValue() : 0;
    }

    public static boolean a(int i) {
        return a.offer(Integer.valueOf(i));
    }

    public static int b() {
        return a.size();
    }

    public static boolean b(int i) {
        return a.contains(Integer.valueOf(i));
    }
}
