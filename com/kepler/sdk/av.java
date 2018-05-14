package com.kepler.sdk;

import android.content.Context;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TbsSdkJava */
public class av {
    private ExecutorService a;
    private String b;
    private Context c;
    private String d;

    public void a(String str) {
        this.b = str;
    }

    public void a(Context context) {
        this.c = context;
    }

    public void b(String str) {
        this.d = str;
    }

    void a() {
        if (this.c == null) {
            throw new IllegalStateException("context is null ");
        } else if (this.b == null || this.b.length() == 0) {
            throw new IllegalStateException("app key is null");
        } else if (this.d == null || !az.b(this.d)) {
            throw new IllegalStateException("server URL is null");
        }
    }

    public void b() {
        if (aw.a()) {
            a();
            c("_appkey=" + this.b + "&_sv=" + az.a + "&_av=" + ax.c(this.c) + "&_m=" + ax.d(this.c) + "&start=" + ax.e(this.c));
        }
    }

    public void a(String str, boolean z) {
        if (aw.a("kepler_eday", new Date().getDate()) || !z) {
            a();
            c("_appkey=" + this.b + "&_sv=" + az.a + "&_av=" + ax.c(this.c) + "&_m=" + ax.d(this.c) + "&events=" + str);
        }
    }

    void c() {
        if (this.a == null) {
            this.a = Executors.newSingleThreadExecutor();
        }
    }

    void c(String str) {
        c();
        this.a.submit(new au(this.d, str, this.c));
    }
}
