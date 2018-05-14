package cn.jiguang.a.a.d;

import android.content.Context;

final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    c(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public final void run() {
        b.a(this.b, this.a);
    }
}
