package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class l extends s {
    float[] a = new float[]{1.0f, 1.0f, 1.0f};
    int[] b = new int[]{255, 255, 255};

    public void a(Canvas canvas, Paint paint) {
        for (int i = 0; i < 3; i++) {
            paint.setAlpha(this.b[i]);
            canvas.scale(this.a[i], this.a[i], (float) (c() / 2), (float) (d() / 2));
            canvas.drawCircle((float) (c() / 2), (float) (d() / 2), ((float) (c() / 2)) - 4.0f, paint);
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        long[] jArr = new long[]{0, 200, 400};
        for (int i = 0; i < 3; i++) {
            com.a.a.l b = com.a.a.l.b(0.0f, 1.0f);
            b.a(new LinearInterpolator());
            b.b(1000);
            b.a(-1);
            b.a(new b(this) {
                final /* synthetic */ l b;

                public void a(com.a.a.l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.d(jArr[i]);
            b.a();
            com.a.a.l b2 = com.a.a.l.b(255, 0);
            b2.a(new LinearInterpolator());
            b2.b(1000);
            b2.a(-1);
            b2.a(new b(this) {
                final /* synthetic */ l b;

                public void a(com.a.a.l lVar) {
                    this.b.b[i] = ((Integer) lVar.j()).intValue();
                    this.b.e();
                }
            });
            b.d(jArr[i]);
            b2.a();
            arrayList.add(b);
            arrayList.add(b2);
        }
        return arrayList;
    }
}
