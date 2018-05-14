package com.b.a;

import android.content.Context;
import c.a.as;
import c.a.b;
import c.a.cm;
import c.a.co;
import c.a.cp;
import c.a.cv;
import c.a.cx;
import c.a.e;
import c.a.h;

/* compiled from: TbsSdkJava */
public class g implements cv {
    private Context a = null;
    private f b;
    private co c = new co();
    private e d = new e();
    private b e = new b();
    private cp f;
    private cm g;
    private boolean h = false;

    g() {
        this.c.a((cv) this);
    }

    private void a(Context context) {
        if (!this.h) {
            this.a = context.getApplicationContext();
            this.f = new cp(this.a);
            this.g = cm.a(this.a);
            this.h = true;
        }
    }

    private void b(Context context) {
        this.e.a(context);
        this.d.a(context);
        if (this.b != null) {
            this.b.a();
        }
        this.g.b();
    }

    public void a(Context context, String str, String str2, long j, int i) {
        try {
            if (!this.h) {
                a(context);
            }
            this.f.a(str, str2, j, i);
        } catch (Throwable e) {
            as.a(e);
        }
    }

    public void a(Throwable th) {
        try {
            this.d.a();
            if (this.a != null) {
                if (!(th == null || this.g == null)) {
                    this.g.b(new h(th));
                }
                b(this.a);
                cx.a(this.a).edit().commit();
            }
            i.a();
        } catch (Throwable e) {
            as.b("Exception in onAppCrash", e);
        }
    }
}
