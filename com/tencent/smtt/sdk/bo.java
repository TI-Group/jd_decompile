package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

class bo {
    private static bo a;
    private static FileLock e = null;
    private bp b;
    private boolean c;
    private boolean d;

    private bo() {
    }

    public static bo b() {
        if (a == null) {
            synchronized (bo.class) {
                if (a == null) {
                    a = new bo();
                }
            }
        }
        return a;
    }

    public bp a(boolean z) {
        return z ? this.b : d();
    }

    public FileLock a() {
        return e;
    }

    public synchronized FileLock a(Context context) {
        FileLock fileLock;
        if (e != null) {
            fileLock = e;
        } else {
            FileOutputStream b = k.b(context, true, "tbs_rename_lock.txt");
            if (b != null) {
                e = k.a(context, b);
                if (e == null) {
                }
            }
            fileLock = e;
        }
        return fileLock;
    }

    public synchronized void a(Context context, an anVar) {
        Object obj;
        Throwable th;
        Object obj2 = null;
        synchronized (this) {
            if (anVar != null) {
                anVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            q a = q.a(true);
            a.a(context, false, false, anVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (anVar != null) {
                anVar.a("init_x5_core", (byte) 1);
            }
            if (a.b()) {
                if (!this.d) {
                    if (anVar != null) {
                        anVar.a = true;
                    }
                    this.b = new bp(a.a().b());
                    try {
                        this.c = this.b.a();
                        if (!this.c) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.c = true;
                        obj = null;
                    } catch (Throwable th2) {
                        obj = th2;
                        this.c = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.c) {
                        CookieManager.getInstance().a();
                    }
                }
                obj = null;
            } else {
                this.c = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            }
            if (!this.c) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a.b() && obj == null) {
                    try {
                        DexLoader b = a.a().b();
                        if (b != null) {
                            obj2 = b.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            th = (Throwable) obj2;
                            stringBuilder.append("#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:" + obj2);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    if (stringBuilder != null) {
                        if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                            TbsCoreLoadStat.getInstance().a(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                        }
                    }
                    TbsCoreLoadStat.getInstance().a(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                } else if (a.b()) {
                    TbsCoreLoadStat.getInstance().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + obj));
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 410, new Throwable("mCanUseX5=false, available false, reason: " + obj));
                }
            } else if (e == null) {
                a(context);
            }
            this.d = true;
            if (anVar != null) {
                anVar.a("init_x5_core", (byte) 2);
            }
        }
    }

    public boolean c() {
        return QbSdk.a ? false : this.c;
    }

    public bp d() {
        return QbSdk.a ? null : this.b;
    }

    boolean e() {
        return this.d;
    }
}
