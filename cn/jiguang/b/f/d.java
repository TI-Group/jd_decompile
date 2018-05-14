package cn.jiguang.b.f;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class d {
    private static d e = new d();
    private static final String[] z;
    private ArrayList<WeakReference<ScheduledFuture<?>>> a = new ArrayList();
    private ExecutorService b = Executors.newSingleThreadExecutor();
    private ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    private long d = 5;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0014\u001b@.z$&F\"w";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0077;
            case 1: goto L_0x007a;
            case 2: goto L_0x007d;
            case 3: goto L_0x0080;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 27;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            case 5: goto L_0x006b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "%\u000bW(n4\u0016\u0012.i2\u001c@q";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "%\u000bW(n4\u001c@kl!\u0000\u0012%n,\u001f";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0001\u0010F\"t.S\u001fkh(\u0006F/t7\u001dw3x5\u0007]9H%\u0001D\"x%S\u001fk~.\u0017";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0001\u0010F\"t.S\u001fkh(\u0006F/t7\u001dw3x5\u0007]9H%\u0001D\"x%";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0010\u001c]';$\u001aVku/\u0007\u0012?~2\u001e[%z4\u0016";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "#\u0006@9~.\u0007\u0012?s2\u0016S/;)\u0000\u0012\"u4\u0016@9n0\u0007W/;\"\n\u00128~,\u0015";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        r0 = new cn.jiguang.b.f.d;
        r0.<init>();
        e = r0;
        return;
    L_0x0077:
        r9 = 64;
        goto L_0x001f;
    L_0x007a:
        r9 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x001f;
    L_0x007d:
        r9 = 50;
        goto L_0x001f;
    L_0x0080:
        r9 = 75;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.f.d.<clinit>():void");
    }

    private d() {
    }

    public static d a() {
        return e;
    }

    public static void a(ExecutorService executorService) {
        cn.jiguang.c.d.a(z[0], z[4]);
        if (executorService == null) {
            cn.jiguang.c.d.h(z[0], z[2]);
            return;
        }
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(100, TimeUnit.MILLISECONDS)) {
                    cn.jiguang.c.d.a(z[0], z[5]);
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            cn.jiguang.c.d.a(z[0], z[6]);
            Thread.currentThread().interrupt();
        }
        cn.jiguang.c.d.a(z[0], z[3]);
    }

    public final void a(Runnable runnable) {
        if (this.b.isShutdown()) {
            this.b = Executors.newSingleThreadExecutor();
        }
        try {
            this.b.execute(runnable);
        } catch (RejectedExecutionException e) {
            cn.jiguang.c.d.i(z[0], new StringBuilder(z[1]).append(e).toString());
        }
    }
}
