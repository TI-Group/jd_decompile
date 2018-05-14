package com.jingdong.crash.inner;

import android.content.Context;

class af implements u {
    final /* synthetic */ Context a;
    final /* synthetic */ JdLocalCrashReceiver b;

    af(JdLocalCrashReceiver jdLocalCrashReceiver, Context context) {
        this.b = jdLocalCrashReceiver;
        this.a = context;
    }

    public void a(boolean z) {
        if (z) {
            w.b(this.a);
        }
    }
}
