package cn.jiguang.b.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class f extends Handler {
    final /* synthetic */ e a;

    public f(e eVar, Looper looper) {
        this.a = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            e.a(this.a, message);
        } else if (message.what == 2) {
            e.a(this.a);
        }
    }
}
