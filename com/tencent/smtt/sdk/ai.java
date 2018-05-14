package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ai extends Handler {
    final /* synthetic */ ah a;

    ai(ah ahVar, Looper looper) {
        this.a = ahVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 150) {
            this.a.n();
        }
    }
}
