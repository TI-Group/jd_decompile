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
public class p extends s {
    float[] a = new float[3];
    float[] b = new float[3];

    public void a(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Style.STROKE);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate(this.a[i], this.b[i]);
            canvas.drawCircle(0.0f, 0.0f, (float) (c() / 10), paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        float c = (float) (c() / 5);
        float c2 = (float) (c() / 5);
        for (int i = 0; i < 3; i++) {
            l b = l.b((float) (c() / 2), ((float) c()) - c, c, (float) (c() / 2));
            if (i == 1) {
                b = l.b(((float) c()) - c, c, (float) (c() / 2), ((float) c()) - c);
            } else if (i == 2) {
                b = l.b(c, (float) (c() / 2), ((float) c()) - c, c);
            }
            l b2 = l.b(c2, ((float) d()) - c2, ((float) d()) - c2, c2);
            if (i == 1) {
                b2 = l.b(((float) d()) - c2, ((float) d()) - c2, c2, ((float) d()) - c2);
            } else if (i == 2) {
                b2 = l.b(((float) d()) - c2, c2, ((float) d()) - c2, ((float) d()) - c2);
            }
            b.b(2000);
            b.a(new LinearInterpolator());
            b.a(-1);
            b.a(new b(this) {
                final /* synthetic */ p b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            b2.b(2000);
            b2.a(new LinearInterpolator());
            b2.a(-1);
            b2.a(new b(this) {
                final /* synthetic */ p b;

                public void a(l lVar) {
                    this.b.b[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b2.a();
            arrayList.add(b);
            arrayList.add(b2);
        }
        return arrayList;
    }
}
