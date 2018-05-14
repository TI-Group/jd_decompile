package com.jd.fridge.widget.zxing.d;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.Result;
import com.jd.fridge.R;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import com.jd.fridge.widget.zxing.b.e;

/* compiled from: TbsSdkJava */
public class c extends Handler {
    private final QRCaptureActivity a;
    private final e b;
    private final com.jd.fridge.widget.zxing.a.c c;
    private a d = a.SUCCESS;

    /* compiled from: TbsSdkJava */
    private enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public c(QRCaptureActivity qRCaptureActivity, com.jd.fridge.widget.zxing.a.c cVar, int i) {
        this.a = qRCaptureActivity;
        this.b = new e(qRCaptureActivity, i);
        this.b.start();
        this.c = cVar;
        cVar.c();
        b();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case R.id.decode_failed:
                this.d = a.PREVIEW;
                this.c.a(this.b.a(), R.id.decode);
                return;
            case R.id.decode_succeeded:
                this.d = a.SUCCESS;
                this.a.a((Result) message.obj, message.getData());
                return;
            case R.id.restart_preview:
                b();
                return;
            case R.id.return_scan_result:
                this.a.setResult(-1, (Intent) message.obj);
                this.a.finish();
                return;
            default:
                return;
        }
    }

    public void a() {
        this.d = a.DONE;
        this.c.d();
        Message.obtain(this.b.a(), R.id.quit).sendToTarget();
        try {
            this.b.join(500);
        } catch (InterruptedException e) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void b() {
        if (this.d == a.SUCCESS) {
            this.d = a.PREVIEW;
            this.c.a(this.b.a(), R.id.decode);
        }
    }
}
