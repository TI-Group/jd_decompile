package com.jingdong.jdma.g;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.d.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: TbsSdkJava */
public class a {
    public static a a = null;
    Context b = null;
    private long c;
    private long d;
    private boolean e;
    private long f;
    private ExecutorService g = null;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    public a(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        this.c = System.currentTimeMillis();
        this.d = System.currentTimeMillis();
        this.e = true;
        this.g = new ThreadPoolExecutor(0, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new DiscardOldestPolicy());
        this.c = CommonUtil.parseLongPositive(b.a(this.b).a(CommonUtil.COMMON_MA_INIT_ACCESSBLOCKTIME)).longValue();
    }

    public void a() {
        this.e = false;
        this.c = System.currentTimeMillis();
        this.g.execute(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                b.a(this.a.b).a(CommonUtil.COMMON_MA_INIT_ACCESSBLOCKTIME, this.a.c + "");
            }
        });
    }

    public void a(long j) {
        this.f = j;
    }

    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (!this.e && this.c > 0 && currentTimeMillis - this.c > this.f && currentTimeMillis - this.d > this.f && this.f > 0) {
            z = true;
        }
        this.e = true;
        this.d = currentTimeMillis;
        return z;
    }
}
