package cn.jiguang.a.a.d;

import android.content.Context;

final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    f(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public final void run() {
        b.b(this.b, this.a);
    }
}
