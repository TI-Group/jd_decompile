package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class k extends s {
    float a = 1.0f;
    int b = 255;

    public void a(Canvas canvas, Paint paint) {
        paint.setAlpha(this.b);
        canvas.scale(this.a, this.a, (float) (c() / 2), (float) (d() / 2));
        paint.setAlpha(this.b);
        canvas.drawCircle((float) (c() / 2), (float) (d() / 2), ((float) (c() / 2)) - 4.0f, paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        l b = l.b(0.0f, 1.0f);
        b.a(new LinearInterpolator());
        b.b(1000);
        b.a(-1);
        b.a(new b(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.a = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b.a();
        l b2 = l.b(255, 0);
        b2.a(new LinearInterpolator());
        b2.b(1000);
        b2.a(-1);
        b2.a(new b(this) {
            final /* synthetic */ k a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.b = ((Integer) lVar.j()).intValue();
                this.a.e();
            }
        });
        b2.a();
        arrayList.add(b);
        arrayList.add(b2);
        return arrayList;
    }
}
