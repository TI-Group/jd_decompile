package com.jd.fridge.widget.zxing.b;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: TbsSdkJava */
public class e extends Thread {
    private final QRCaptureActivity a;
    private final Map<DecodeHintType, Object> b = new EnumMap(DecodeHintType.class);
    private Handler c;
    private final CountDownLatch d = new CountDownLatch(1);

    public e(QRCaptureActivity qRCaptureActivity, int i) {
        this.a = qRCaptureActivity;
        Collection arrayList = new ArrayList();
        arrayList.addAll(EnumSet.of(BarcodeFormat.AZTEC));
        arrayList.addAll(EnumSet.of(BarcodeFormat.PDF_417));
        switch (i) {
            case 256:
                arrayList.addAll(c.b());
                break;
            case 512:
                arrayList.addAll(c.a());
                break;
            case 768:
                arrayList.addAll(c.b());
                arrayList.addAll(c.a());
                break;
        }
        this.b.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
    }

    public Handler a() {
        try {
            this.d.await();
        } catch (InterruptedException e) {
        }
        return this.c;
    }

    public void run() {
        Looper.prepare();
        this.c = new d(this.a, this.b);
        this.d.countDown();
        Looper.loop();
    }
}
