package com.jd.fridge.widget.zxing.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.jd.fridge.util.r;

/* compiled from: TbsSdkJava */
public class d implements PreviewCallback {
    private static final String a = d.class.getSimpleName();
    private final b b;
    private Handler c;
    private int d;

    public d(b bVar) {
        this.b = bVar;
    }

    public void a(Handler handler, int i) {
        this.c = handler;
        this.d = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.b.a();
        Handler handler = this.c;
        if (a == null || handler == null) {
            r.a(a, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.d, a.x, a.y, bArr).sendToTarget();
        this.c = null;
    }
}
