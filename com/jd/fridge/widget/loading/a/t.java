package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class t extends s {
    float[] a = new float[2];
    float[] b = new float[2];
    float c;
    float d = 1.0f;

    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 5);
        float d = (float) (d() / 5);
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(this.a[i], this.b[i]);
            canvas.rotate(this.c);
            canvas.scale(this.d, this.d);
            canvas.drawRect(new RectF((-c) / 2.0f, (-d) / 2.0f, c / 2.0f, d / 2.0f), paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        l b;
        l b2;
        List<a> arrayList = new ArrayList();
        float c = (float) (c() / 5);
        float d = (float) (d() / 5);
        for (int i = 0; i < 2; i++) {
            this.a[i] = c;
            b = l.b(c, ((float) c()) - c, ((float) c()) - c, c, c);
            if (i == 1) {
                b = l.b(((float) c()) - c, c, c, ((float) c()) - c, ((float) c()) - c);
            }
            b.a(new LinearInterpolator());
            b.b(1600);
            b.a(-1);
            b.a(new b(this) {
                final /* synthetic */ t b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            this.b[i] = d;
            b2 = l.b(d, d, ((float) d()) - d, ((float) d()) - d, d);
            if (i == 1) {
                b2 = l.b(((float) d()) - d, ((float) d()) - d, d, d, ((float) d()) - d);
            }
            b2.b(1600);
            b2.a(new LinearInterpolator());
            b2.a(-1);
            b2.a(new b(this) {
                final /* synthetic */ t b;

                public void a(l lVar) {
                    this.b.b[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b2.a();
            arrayList.add(b);
            arrayList.add(b2);
        }
        b = l.b(1.0f, 0.5f, 1.0f, 0.5f, 1.0f);
        b.b(1600);
        b.a(new LinearInterpolator());
        b.a(-1);
        b.a(new b(this) {
            final /* synthetic */ t a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.d = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b.a();
        b2 = l.b(0.0f, 180.0f, 360.0f, 540.0f, 720.0f);
        b2.b(1600);
        b2.a(new LinearInterpolator());
        b2.a(-1);
        b2.a(new b(this) {
            final /* synthetic */ t a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.c = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b2.a();
        arrayList.add(b);
        arrayList.add(b2);
        return arrayList;
    }
}
