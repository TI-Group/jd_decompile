package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class n extends l {
    public void a(Canvas canvas, Paint paint) {
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(3.0f);
        super.a(canvas, paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        long[] jArr = new long[]{0, 200, 400};
        for (int i = 0; i < 3; i++) {
            l b = l.b(0.0f, 1.0f);
            b.a(new LinearInterpolator());
            b.b(1000);
            b.a(-1);
            b.a(new b(this) {
                final /* synthetic */ n b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.d(jArr[i]);
            b.a();
            l b2 = l.b(0, 255);
            b.a(new LinearInterpolator());
            b2.b(1000);
            b2.a(-1);
            b2.a(new b(this) {
                final /* synthetic */ n b;

                public void a(l lVar) {
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
