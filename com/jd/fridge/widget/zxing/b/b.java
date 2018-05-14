package com.jd.fridge.widget.zxing.b;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

/* compiled from: TbsSdkJava */
public class b extends LuminanceSource {
    private byte[] a;

    protected b(Bitmap bitmap) {
        int i = 0;
        super(bitmap.getWidth(), bitmap.getHeight());
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        this.a = new byte[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, getWidth(), 0, 0, getWidth(), getHeight());
        while (i < iArr.length) {
            this.a[i] = (byte) iArr[i];
            i++;
        }
    }

    public byte[] getMatrix() {
        return this.a;
    }

    public byte[] getRow(int i, byte[] bArr) {
        System.arraycopy(this.a, getWidth() * i, bArr, 0, getWidth());
        return bArr;
    }
}
