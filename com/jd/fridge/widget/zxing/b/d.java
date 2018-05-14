package com.jd.fridge.widget.zxing.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import com.jd.fridge.R;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class d extends Handler {
    private final QRCaptureActivity a;
    private final MultiFormatReader b = new MultiFormatReader();
    private boolean c = true;

    public d(QRCaptureActivity qRCaptureActivity, Map<DecodeHintType, Object> map) {
        this.b.setHints(map);
        this.a = qRCaptureActivity;
    }

    public void handleMessage(Message message) {
        if (this.c) {
            switch (message.what) {
                case R.id.decode:
                    b((byte[]) message.obj, message.arg1, message.arg2);
                    return;
                case R.id.quit:
                    this.c = false;
                    Looper.myLooper().quit();
                    return;
                default:
                    return;
            }
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        int i3;
        Handler a = this.a.a();
        Size f = this.a.b().f();
        if (f == null && a != null) {
            Message.obtain(a, R.id.decode_failed).sendToTarget();
        }
        byte[] bArr2 = new byte[bArr.length];
        for (i3 = 0; i3 < f.height; i3++) {
            for (int i4 = 0; i4 < f.width; i4++) {
                bArr2[(((f.height * i4) + f.height) - i3) - 1] = bArr[(f.width * i3) + i4];
            }
        }
        i3 = f.width;
        f.width = f.height;
        f.height = i3;
        Object obj = null;
        PlanarYUVLuminanceSource a2 = a(bArr2, f.width, f.height);
        if (a2 != null) {
            try {
                obj = this.b.decodeWithState(new BinaryBitmap(new HybridBinarizer(a2)));
            } catch (ReaderException e) {
            } finally {
                a2 = this.b;
                a2.reset();
            }
        }
        if (obj != null) {
            if (a != null) {
                Message obtain = Message.obtain(a, R.id.decode_succeeded, obj);
                Bundle bundle = new Bundle();
                a(a2, bundle);
                obtain.setData(bundle);
                obtain.sendToTarget();
            }
        } else if (a != null) {
            Message.obtain(a, R.id.decode_failed).sendToTarget();
        }
    }

    private static void a(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Config.ARGB_8888);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
    }

    public PlanarYUVLuminanceSource a(byte[] bArr, int i, int i2) {
        Rect c = this.a.c();
        if (c == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, c.left, c.top, c.width(), c.height(), false);
    }
}
