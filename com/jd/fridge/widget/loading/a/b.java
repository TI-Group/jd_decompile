package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.a.a.a;
import com.a.a.l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class b extends s {
    float a = 1.0f;
    float b;

    public void a(Canvas canvas, Paint paint) {
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(3.0f);
        float c = (float) (c() / 2);
        float d = (float) (d() / 2);
        canvas.translate(c, d);
        canvas.scale(this.a, this.a);
        canvas.rotate(this.b);
        canvas.drawArc(new RectF((-c) + 12.0f, (-d) + 12.0f, (c + 0.0f) - 12.0f, (d + 0.0f) - 12.0f), -45.0f, 270.0f, false, paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        l b = l.b(1.0f, 0.6f, 0.5f, 1.0f);
        b.b(750);
        b.a(-1);
        b.a(new com.a.a.l.b(this) {
            final /* synthetic */ b a;

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
        b2.b(750);
        b2.a(-1);
        b2.a(new com.a.a.l.b(this) {
            final /* synthetic */ b a;

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
