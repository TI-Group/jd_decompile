package com.jd.fridge.widget.zxing.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import com.jd.fridge.util.r;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: TbsSdkJava */
public class a implements AutoFocusCallback {
    private static final String a = a.class.getSimpleName();
    private static final Collection<String> b = new ArrayList(2);
    private boolean c;
    private boolean d;
    private final boolean e;
    private final Camera f;
    private AsyncTask<?, ?, ?> g;

    /* compiled from: TbsSdkJava */
    private final class a extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            this.a.a();
            return null;
        }
    }

    static {
        b.add("auto");
        b.add("macro");
    }

    public a(Context context, Camera camera) {
        this.f = camera;
        String focusMode = camera.getParameters().getFocusMode();
        this.e = b.contains(focusMode);
        r.c(a, "Current focus mode '" + focusMode + "'; use auto focus? " + this.e);
        a();
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.d = false;
        c();
    }

    @SuppressLint({"NewApi"})
    private synchronized void c() {
        if (!this.c && this.g == null) {
            AsyncTask aVar = new a();
            try {
                if (VERSION.SDK_INT >= 11) {
                    aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                } else {
                    aVar.execute(new Object[0]);
                }
                this.g = aVar;
            } catch (Throwable e) {
                r.b(a, "Could not request auto focus", e);
            }
        }
    }

    public synchronized void a() {
        if (this.e) {
            this.g = null;
            if (!(this.c || this.d)) {
                try {
                    this.f.autoFocus(this);
                    this.d = true;
                } catch (Throwable e) {
                    r.b(a, "Unexpected exception while focusing", e);
                    c();
                }
            }
        }
    }

    private synchronized void d() {
        if (this.g != null) {
            if (this.g.getStatus() != Status.FINISHED) {
                this.g.cancel(true);
            }
            this.g = null;
        }
    }

    public synchronized void b() {
        this.c = true;
        if (this.e) {
            d();
            try {
                this.f.cancelAutoFocus();
            } catch (Throwable e) {
                r.b(a, "Unexpected exception while cancelling focusing", e);
            }
        }
    }
}
