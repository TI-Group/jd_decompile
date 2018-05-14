package com.tencent.smtt.sdk;

class f implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ e b;

    f(e eVar, boolean z) {
        this.b = eVar;
        this.a = z;
    }

    public void run() {
        this.b.c.onReceiveValue(Boolean.valueOf(this.a));
    }
}
