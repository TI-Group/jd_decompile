package com.jd.fridge.widget.zxing.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.jd.fridge.util.r;
import com.jingdong.jdma.common.utils.CommonUtil;

/* compiled from: TbsSdkJava */
public class d {
    private static final String a = d.class.getSimpleName();
    private Activity b;
    private BroadcastReceiver c = new b();
    private boolean d = false;
    private AsyncTask<Object, Object, Object> e;

    /* compiled from: TbsSdkJava */
    private class a extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ d a;

        private a(d dVar) {
            this.a = dVar;
        }

        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(CommonUtil.REPORT_ERROR_SLEEP_TIME);
                r.c(d.a, "Finishing activity due to inactivity");
                this.a.b.finish();
            } catch (InterruptedException e) {
            }
            return null;
        }
    }

    /* compiled from: TbsSdkJava */
    private class b extends BroadcastReceiver {
        final /* synthetic */ d a;

        private b(d dVar) {
            this.a = dVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if ((intent.getIntExtra("plugged", -1) <= 0 ? 1 : null) != null) {
                    this.a.a();
                } else {
                    this.a.f();
                }
            }
        }
    }

    public d(Activity activity) {
        this.b = activity;
        a();
    }

    @SuppressLint({"NewApi"})
    public synchronized void a() {
        f();
        this.e = new a();
        if (VERSION.SDK_INT >= 11) {
            this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            this.e.execute(new Object[0]);
        }
    }

    public synchronized void b() {
        f();
        if (this.d) {
            this.b.unregisterReceiver(this.c);
            this.d = false;
        } else {
            r.d(a, "PowerStatusReceiver was never registered?");
        }
    }

    public synchronized void c() {
        if (this.d) {
            r.d(a, "PowerStatusReceiver was already registered?");
        } else {
            this.b.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.d = true;
        }
        a();
    }

    private synchronized void f() {
        AsyncTask asyncTask = this.e;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.e = null;
        }
    }

    public void d() {
        f();
    }
}
