package com.tencent.smtt.sdk.b.a;

import android.os.Handler;
import android.os.Message;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.b();
                return;
            default:
                return;
        }
    }
}
