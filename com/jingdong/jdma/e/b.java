package com.jingdong.jdma.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.d;
import com.jingdong.jdma.d.e;
import com.jingdong.jdma.f.c;
import com.jingdong.jdma.minterface.DomainInterface;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: TbsSdkJava */
public class b implements a {
    public SparseArray<Vector<e>> a;
    public long[] b;
    public long[] c;
    public boolean[] d;
    private final String e;
    private com.jingdong.jdma.a.a f;
    private long[] g;
    private final Object[] h;
    private boolean i;
    private Vector<Thread> j;
    private Vector<c> k;
    private String l;
    private com.jingdong.jdma.b.a m;
    private SparseArray<com.jingdong.jdma.h.a> n;
    private Handler o;
    private int p;
    private c q;
    private Thread r;
    private MaInitCommonInfo s;
    private Context t;
    private ExecutorService u;

    /* compiled from: TbsSdkJava */
    public class a implements com.jingdong.jdma.f.b {
        final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void a(int i, long j) {
            this.a.d[i] = true;
            this.a.a(i, j);
            if (d.d(this.a.t)) {
                this.a.d(i);
            }
        }

        public void a(int i, String str, long j) {
            if (!(j == -1 || j == 0)) {
                this.a.a(i, j);
            }
            this.a.d[i] = false;
            this.a.o.removeMessages(b.h(i) * 53);
            this.a.o.sendEmptyMessageDelayed(b.h(i) * 53, CommonUtil.REPORT_ERROR_SLEEP_TIME);
            if (!"".equals(str)) {
                this.a.a(str);
            }
        }

        public void a(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a.c[i] > com.jingdong.jdma.h.b.a(i).b.longValue()) {
                this.a.g(i);
            }
            this.a.c[i] = currentTimeMillis;
        }
    }

    public b(Context context, MaInitCommonInfo maInitCommonInfo) {
        int i;
        this.e = b.class.getName();
        this.g = new long[]{0, 0};
        this.b = new long[]{0, 0};
        this.c = new long[]{0, 0};
        this.d = new boolean[]{true, true};
        this.i = false;
        this.l = "";
        this.o = new Handler(this, Looper.getMainLooper()) {
            final /* synthetic */ b a;

            public void handleMessage(Message message) {
                if (message.what == 1001) {
                    CommonUtil.commonUtilLog(this.a.e, "DBCore.destoryInstance");
                    com.jingdong.jdma.a.a.a();
                } else if (message.what % 51 == 0) {
                    this.a.f(b.i(message.what / 51));
                } else if (message.what % 53 == 0) {
                    this.a.j(b.i(message.what / 53));
                }
            }
        };
        this.p = 256;
        this.i = false;
        this.t = context.getApplicationContext();
        if (this.t == null) {
            this.t = context;
        }
        this.s = maInitCommonInfo;
        com.jingdong.jdma.f.a.a(this.t).a(maInitCommonInfo);
        this.h = new Object[1];
        for (i = 0; i < 1; i++) {
            this.h[i] = new Object();
        }
        this.m = com.jingdong.jdma.b.a.a();
        if (!(this.s.domainMap == null || this.s.domainMap.size() == 0)) {
            for (Entry entry : this.s.domainMap.entrySet()) {
                this.m.a(((Integer) entry.getKey()).intValue(), (DomainInterface) entry.getValue());
            }
        }
        this.l = com.jingdong.jdma.h.c.a(CommonUtil.STATISTIC_DEFULT_WIFI_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_WIFI_REPORT_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_4G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_4G_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_3G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_3G_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_2G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_2G_SIZE.longValue(), 1, 30, CommonUtil.STATISTIC_DEFULT_VERSION, CommonUtil.STATISTIC_DEFULT_CYC.longValue(), CommonUtil.STATISTIC_DEFULT_LOOPBTW.longValue(), CommonUtil.STATISTIC_REPORT_DATA_DEFAULT_DOMAIN);
        this.f = com.jingdong.jdma.a.a.a(this.t);
        this.a = new SparseArray();
        for (i = 0; i < 1; i++) {
            this.a.put(i, new Vector());
            if (i == 0) {
                com.jingdong.jdma.h.b.a(i, this.t, this.l);
            } else {
                com.jingdong.jdma.h.b.a(i, this.t);
            }
            g(i);
        }
        this.n = new SparseArray();
        for (int i2 = 0; i2 < 1; i2++) {
            String str = "";
            DomainInterface a = this.m.a(i2);
            if (a != null) {
                str = CommonUtil.URL_HEADER + a.mStrategyDomain + CommonUtil.STATISTIC_GET_STRATEGY_ADDRESS_SUFFIX;
            }
            if (!"".equals(str)) {
                final Context context2 = context;
                this.n.put(i2, new com.jingdong.jdma.h.a(this, str, maInitCommonInfo.site_id, i2) {
                    final /* synthetic */ b b;

                    public void a(String str, int i) {
                        com.jingdong.jdma.h.c a = com.jingdong.jdma.h.b.a(i, this.b.t);
                        boolean a2 = a.a();
                        a.a = !a.a(str);
                        if (a.a() && !a2) {
                            this.b.o.removeMessages(b.h(i) * 53);
                            this.b.o.sendEmptyMessageDelayed(b.h(i) * 53, a.c(d.b(context2)) * 1000);
                            this.b.d(i);
                        }
                        long b = a.b();
                        com.jingdong.jdma.g.a.a(this.b.t).a(a.d() * 1000);
                        if (b > 0) {
                            this.b.o.sendEmptyMessageDelayed(b.h(i) * 51, (b * 60) * 1000);
                        }
                    }
                });
            }
        }
    }

    public void a() {
        int i = 0;
        CommonUtil.commonUtilLog(this.e, "init,pid=" + Process.myPid());
        this.u = new ThreadPoolExecutor(0, 1, 300, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new DiscardPolicy());
        while (i < 1) {
            f(i);
            i++;
        }
        if (this.q == null) {
            this.q = new c(this.f, this, this.t);
            this.r = new Thread(this.q);
            this.r.start();
        }
        e();
    }

    private void j(int i) {
        try {
            if (this.k != null && this.j != null && CommonUtil.isMainProcess(this.t) && this.j.size() == 1) {
                c cVar = (c) this.k.get(i);
                if (cVar != null) {
                    synchronized (cVar) {
                        try {
                            cVar.notify();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.b[i] = System.currentTimeMillis();
                    com.jingdong.jdma.h.c a = com.jingdong.jdma.h.b.a(i);
                    if (a != null) {
                        this.o.removeMessages(h(i) * 53);
                        long c = a.c(d.b(this.t)) * 1000;
                        if (c > 0) {
                            this.o.sendEmptyMessageDelayed(h(i) * 53, c);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(int i) {
        com.jingdong.jdma.h.a aVar = (com.jingdong.jdma.h.a) this.n.get(i);
        if (aVar != null) {
            aVar.a(com.jingdong.jdma.h.b.a(i, this.t, this.l).c());
            this.u.execute(aVar);
        }
    }

    public Vector<e> a(int i) {
        if (i < 0 || i >= 1) {
            return null;
        }
        return (Vector) this.a.get(i);
    }

    public void a(HashMap<String, String> hashMap, int i) {
        if (!this.i && i >= 0 && i < 1) {
            com.jingdong.jdma.h.c a;
            if (i == 0) {
                a = com.jingdong.jdma.h.b.a(i, this.t, this.l);
            } else {
                a = com.jingdong.jdma.h.b.a(i, this.t);
            }
            if (a.a()) {
                if (this.q == null) {
                    this.q = new c(this.f, this, this.t);
                    this.r = new Thread(this.q);
                    this.r.start();
                }
                e eVar = new e();
                eVar.b((HashMap) hashMap);
                Vector a2 = a(i);
                synchronized (a2) {
                    if (a2.size() >= this.p) {
                        Log.e(this.e, "drop report from memqueue");
                    } else {
                        CommonUtil.commonUtilLog(CommonUtil.TAG, "[vec]add record:" + hashMap.toString());
                        a2.add(0, eVar);
                    }
                    synchronized (this.q) {
                        this.q.notify();
                    }
                }
            }
        }
    }

    public void b() {
        int i;
        CommonUtil.commonUtilLog(this.e, "destroy");
        this.i = true;
        for (i = 0; i < 1; i++) {
            this.o.removeMessages(h(i) * 51, null);
        }
        if (this.q != null) {
            this.q.a();
            synchronized (this.q) {
                try {
                    this.q.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.a != null) {
            this.a.clear();
        }
        this.q = null;
        if (this.k != null) {
            for (i = 0; i < this.k.size(); i++) {
                a((c) this.k.get(i));
                this.o.removeMessages(h(i) * 53);
            }
        }
        com.jingdong.jdma.h.b.a();
        com.jingdong.jdma.b.a.b();
        this.o.sendEmptyMessageDelayed(1001, 5000);
    }

    public long g(int i) {
        if (i < 0 || i >= 1) {
            return 0;
        }
        long a;
        String str = CommonUtil.TABLE_NAME_LIST[i];
        synchronized (this.h[i % 1]) {
            a = this.f.a(str);
            this.g[i] = a;
        }
        return a;
    }

    public long b(int i) {
        if (i < 0 || i >= 1) {
            return 0;
        }
        long j;
        synchronized (this.h[i % 1]) {
            long[] jArr = this.g;
            j = jArr[i] + 1;
            jArr[i] = j;
        }
        return j;
    }

    public long a(int i, long j) {
        if (i < 0 || i >= 1) {
            return 0;
        }
        synchronized (this.h[i % 1]) {
            if (this.g[i] - j > 0) {
                this.g[i] = this.g[i] - j;
            } else {
                this.g[i] = 0;
            }
        }
        return this.g[i];
    }

    public void d(int i) {
        if (i >= 0 && i < 1) {
            com.jingdong.jdma.h.c a = com.jingdong.jdma.h.b.a(i);
            String b = d.b(this.t);
            if (a != null && !this.i && this.d[i]) {
                long j = this.g[i];
                CommonUtil.commonUtilLog(this.e, "JudgeLimitAndSendMessage [NetType:" + b + "][Count:" + j + "]");
                if (a.a(b, j) || (j > 0 && 0 == j % 300)) {
                    this.o.removeMessages(h(i) * 53);
                    j = 2000;
                    if (a.e() > 0) {
                        j = a.e() * 1000;
                    } else if (a.e() == 0) {
                        j = 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.b[i] > j) {
                        j = 0;
                    } else {
                        j -= currentTimeMillis - this.b[i];
                    }
                    currentTimeMillis = a.c(b) * 1000;
                    if (j > currentTimeMillis && currentTimeMillis > 0) {
                        j = a.c(b) * 1000;
                    }
                    if (j == 0) {
                        j = 100;
                    }
                    this.o.sendEmptyMessageDelayed(h(i) * 53, j);
                }
            }
        }
    }

    public long c(int i) {
        if (i < 0 || i >= 1) {
            return 0;
        }
        return this.g[i];
    }

    private void e() {
        int i = 0;
        this.j = new Vector();
        this.k = new Vector();
        if (this.s != null) {
            com.jingdong.jdma.d.c.a(this.t, this.s);
            if (this.s.zipFlag == 1) {
                c.b();
                com.jingdong.jdma.f.a.a(this.t).a();
            }
            if (this.k.size() != 1) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    a((c) this.k.get(i2));
                }
                this.j.clear();
                for (int i3 = 0; i3 < 1; i3++) {
                    com.jingdong.jdma.h.c a;
                    if (i3 == 0) {
                        a = com.jingdong.jdma.h.b.a(i3, this.t, this.l);
                    } else {
                        a = com.jingdong.jdma.h.b.a(i3, this.t);
                    }
                    Runnable runnable = null;
                    if (i3 == 0) {
                        try {
                            runnable = new com.jingdong.jdma.f.d(this.t, this.s, this.l, new a(this));
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    Thread thread = new Thread(runnable);
                    thread.start();
                    this.k.insertElementAt(runnable, i3);
                    this.j.insertElementAt(thread, i3);
                    this.o.removeMessages(h(i3) * 53);
                    long c = a.c(d.b(this.t)) * 1000;
                    if (c > 0) {
                        this.o.sendEmptyMessageDelayed(h(i3) * 53, c);
                    }
                }
            }
            while (i < 1) {
                Thread thread2 = (Thread) this.j.get(i);
                if (!(thread2 == null || thread2.isAlive())) {
                    thread2.start();
                }
                i++;
            }
        }
    }

    private void a(c cVar) {
        cVar.a();
        synchronized (cVar) {
            try {
                cVar.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int h(int i) {
        return i + 1;
    }

    public static int i(int i) {
        return i - 1;
    }

    public long e(int i) {
        if (i < 0 || i >= 1 || this.f == null) {
            return 0;
        }
        return this.f.a(CommonUtil.TABLE_NAME_LIST[i]);
    }

    public void c() {
        com.jingdong.jdma.g.a.a(this.t).a();
    }

    public boolean d() {
        boolean b = com.jingdong.jdma.g.a.a(this.t).b();
        if (b) {
            j(0);
        }
        return b;
    }

    private void a(String str) {
    }
}
