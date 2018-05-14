package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.a;
import com.a.a.h;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class j extends s {
    float a = 0.5f;

    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 10);
        float c2 = (float) (c() / 2);
        float d = (float) (d() / 2);
        canvas.save();
        canvas.translate((c2 - (c * 2.0f)) - c, d);
        canvas.scale(this.a, this.a);
        canvas.drawCircle(0.0f, 0.0f, c, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(c2, d);
        canvas.scale(this.a, this.a);
        canvas.drawCircle(0.0f, 0.0f, c, paint);
        canvas.restore();
        canvas.save();
        canvas.translate((c2 + (c * 2.0f)) + c, d);
        canvas.scale(this.a, this.a);
        canvas.drawCircle(0.0f, 0.0f, c, paint);
        canvas.restore();
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        l b = l.b(0.5f, 1.0f, 0.5f);
        b.b(1000);
        b.a(-1);
        b.a(new b(this) {
            final /* synthetic */ j a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.a = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b.a();
        h a = h.a(b(), "rotation", 0.0f, 180.0f, 360.0f);
        a.a(1000);
        a.a(-1);
        a.a();
        arrayList.add(b);
        arrayList.add(a);
        return arrayList;
    }
}
