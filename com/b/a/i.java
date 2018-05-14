package com.b.a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: TbsSdkJava */
public class i {
    private static List<WeakReference<ScheduledFuture<?>>> a = new ArrayList();
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static long c = 5;
    private static ScheduledExecutorService d = Executors.newSingleThreadScheduledExecutor();

    public static void a() {
        try {
            for (WeakReference weakReference : a) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) weakReference.get();
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            a.clear();
            if (!b.isShutdown()) {
                b.shutdown();
            }
            if (!d.isShutdown()) {
                d.shutdown();
            }
            b.awaitTermination(c, TimeUnit.SECONDS);
            d.awaitTermination(c, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (i.class) {
            if (d.isShutdown()) {
                d = Executors.newSingleThreadScheduledExecutor();
            }
            d.execute(runnable);
        }
    }

    public static synchronized void a(Runnable runnable, long j) {
        synchronized (i.class) {
            if (d.isShutdown()) {
                d = Executors.newSingleThreadScheduledExecutor();
            }
            a.add(new WeakReference(d.schedule(runnable, j, TimeUnit.MILLISECONDS)));
        }
    }
}
