package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class g extends s {
    private float[] a = new float[]{1.0f, 1.0f, 1.0f};

    public void a(Canvas canvas, Paint paint) {
        float min = (((float) Math.min(c(), d())) - (4.0f * 2.0f)) / 6.0f;
        float c = ((float) (c() / 2)) - ((min * 2.0f) + 4.0f);
        float d = (float) (d() / 2);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate((((min * 2.0f) * ((float) i)) + c) + (((float) i) * 4.0f), d);
            canvas.scale(this.a[i], this.a[i]);
            canvas.drawCircle(0.0f, 0.0f, min, paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        int[] iArr = new int[]{ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 240, 360};
        for (int i = 0; i < 3; i++) {
            l b = l.b(1.0f, 0.3f, 1.0f);
            b.b(750);
            b.a(-1);
            b.d((long) iArr[i]);
            b.a(new b(this) {
                final /* synthetic */ g b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            arrayList.add(b);
        }
        return arrayList;
    }
}
