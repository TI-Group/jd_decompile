package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: TbsSdkJava */
final class f extends Handler {
    private final i a = new i();
    private final int b;
    private final c c;
    private boolean d;

    f(c cVar, Looper looper, int i) {
        super(looper);
        this.c = cVar;
        this.b = i;
    }

    void a(n nVar, Object obj) {
        h a = h.a(nVar, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h a = this.a.a();
                if (a == null) {
                    synchronized (this) {
                        a = this.a.a();
                        if (a == null) {
                            this.d = false;
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.b));
            if (sendMessage(obtainMessage())) {
                this.d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.d = false;
        }
    }
}
