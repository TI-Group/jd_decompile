package com.sina.weibo.sdk.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.d.d;
import com.sina.weibo.sdk.d.j;
import com.sina.weibo.sdk.net.c;
import com.sina.weibo.sdk.net.f;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TbsSdkJava */
public class g {
    private static final String a = g.class.getName();
    private static g c;
    private Context b;
    private String d;
    private volatile ReentrantLock e = new ReentrantLock(true);
    private d f;
    private b g;

    /* compiled from: TbsSdkJava */
    private static class a {
        public static SharedPreferences a(Context context) {
            return context.getSharedPreferences("com_sina_weibo_sdk", 0);
        }

        public static long a(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("frequency_get_cmd", 3600000);
            }
            return 3600000;
        }

        public static void a(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null && j > 0) {
                Editor edit = sharedPreferences.edit();
                edit.putLong("frequency_get_cmd", j);
                edit.commit();
            }
        }

        public static long b(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("last_time_get_cmd", 0);
            }
            return 0;
        }

        public static void b(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                edit.putLong("last_time_get_cmd", j);
                edit.commit();
            }
        }
    }

    private g(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f = new d(this.b);
        this.g = new b(this.b);
        this.d = str;
    }

    public static synchronized g a(Context context, String str) {
        g gVar;
        synchronized (g.class) {
            if (c == null) {
                c = new g(context, str);
            }
            gVar = c;
        }
        return gVar;
    }

    public void a() {
        final SharedPreferences a = a.a(this.b);
        if (System.currentTimeMillis() - a.b(this.b, a) < a.a(this.b, a)) {
            d.e(a, String.format("it's only %d ms from last time get cmd", new Object[]{Long.valueOf(r4)}));
            return;
        }
        new Thread(new Runnable(this) {
            final /* synthetic */ g a;

            public void run() {
                f fVar;
                b bVar;
                Throwable th;
                d.e(g.a, "mLock.isLocked()--->" + this.a.e.isLocked());
                if (this.a.e.tryLock()) {
                    f fVar2 = null;
                    try {
                        String b = g.c(this.a.b, this.a.d);
                        if (b != null) {
                            fVar = new f(com.sina.weibo.sdk.d.a.a(b));
                            try {
                                this.a.a(fVar.a());
                                this.a.b(fVar.b());
                            } catch (b e) {
                                b bVar2 = e;
                                fVar2 = fVar;
                                bVar = bVar2;
                                try {
                                    d.c(g.a, bVar.getMessage());
                                    this.a.e.unlock();
                                    if (fVar2 != null) {
                                        a.a(this.a.b, a, (long) fVar2.c());
                                        a.b(this.a.b, a, System.currentTimeMillis());
                                    }
                                    d.e(g.a, "after unlock \n mLock.isLocked()--->" + this.a.e.isLocked());
                                } catch (Throwable th2) {
                                    th = th2;
                                    this.a.e.unlock();
                                    if (fVar2 != null) {
                                        a.a(this.a.b, a, (long) fVar2.c());
                                        a.b(this.a.b, a, System.currentTimeMillis());
                                    }
                                    d.e(g.a, "after unlock \n mLock.isLocked()--->" + this.a.e.isLocked());
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                fVar2 = fVar;
                                th = th4;
                                this.a.e.unlock();
                                if (fVar2 != null) {
                                    a.a(this.a.b, a, (long) fVar2.c());
                                    a.b(this.a.b, a, System.currentTimeMillis());
                                }
                                d.e(g.a, "after unlock \n mLock.isLocked()--->" + this.a.e.isLocked());
                                throw th;
                            }
                        }
                        fVar = null;
                        this.a.e.unlock();
                        if (fVar != null) {
                            a.a(this.a.b, a, (long) fVar.c());
                            a.b(this.a.b, a, System.currentTimeMillis());
                        }
                        d.e(g.a, "after unlock \n mLock.isLocked()--->" + this.a.e.isLocked());
                    } catch (b e2) {
                        bVar = e2;
                        d.c(g.a, bVar.getMessage());
                        this.a.e.unlock();
                        if (fVar2 != null) {
                            a.a(this.a.b, a, (long) fVar2.c());
                            a.b(this.a.b, a, System.currentTimeMillis());
                        }
                        d.e(g.a, "after unlock \n mLock.isLocked()--->" + this.a.e.isLocked());
                    }
                }
            }
        }).start();
    }

    private static String c(Context context, String str) {
        String str2 = "http://api.weibo.cn/2/client/common_config";
        str2 = context.getPackageName();
        String a = j.a(context, str2);
        f fVar = new f(str);
        fVar.a("appkey", str);
        fVar.a("packagename", str2);
        fVar.a("key_hash", a);
        fVar.a("version", "0031205000");
        return c.b(context, "http://api.weibo.cn/2/client/common_config", "GET", fVar);
    }

    private void a(List<a> list) {
        if (list != null) {
            this.g.a();
            for (a a : list) {
                this.g.a(a);
            }
            this.g.b();
        }
    }

    private void b(List<c> list) {
        if (list != null) {
            for (c a : list) {
                this.f.a(a);
            }
        }
    }
}
