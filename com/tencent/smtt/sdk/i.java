package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

final class i extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Handler b;

    i(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
    }

    public void run() {
        if (ao.a().a(true, this.a) == 0) {
            ao.a().b(this.a, true);
        }
        q.a(true).a(this.a, false, false, null);
        bo b = bo.b();
        b.a(this.a, null);
        boolean c = b.c();
        this.b.sendEmptyMessage(3);
        if (c) {
            this.b.sendEmptyMessage(1);
        } else {
            this.b.sendEmptyMessage(2);
        }
    }
}
