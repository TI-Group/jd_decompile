package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class c extends s {
    float a = 1.0f;
    float b;

    public void a(Canvas canvas, Paint paint) {
        int i;
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Style.STROKE);
        float c = (float) (c() / 2);
        float d = (float) (d() / 2);
        canvas.save();
        canvas.translate(c, d);
        canvas.scale(this.a, this.a);
        canvas.rotate(this.b);
        float[] fArr = new float[]{135.0f, -45.0f};
        for (i = 0; i < 2; i++) {
            canvas.drawArc(new RectF((-c) + 12.0f, (-d) + 12.0f, c - 12.0f, d - 12.0f), fArr[i], 90.0f, false, paint);
        }
        canvas.restore();
        canvas.translate(c, d);
        canvas.scale(this.a, this.a);
        canvas.rotate(-this.b);
        fArr = new float[]{225.0f, 45.0f};
        for (i = 0; i < 2; i++) {
            canvas.drawArc(new RectF(((-c) / 1.8f) + 12.0f, ((-d) / 1.8f) + 12.0f, (c / 1.8f) - 12.0f, (d / 1.8f) - 12.0f), fArr[i], 90.0f, false, paint);
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        l b = l.b(1.0f, 0.6f, 1.0f);
        b.b(1000);
        b.a(-1);
        b.a(new b(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.a = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b.a();
        l b2 = l.b(0.0f, 180.0f, 360.0f);
        b2.b(1000);
        b2.a(-1);
        b2.a(new b(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.b = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b2.a();
        arrayList.add(b);
        arrayList.add(b2);
        return arrayList;
    }
}
