package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class u extends s {
    float[] a = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 11);
        float d = (float) (d() / 2);
        for (int i = 0; i < 5; i++) {
            canvas.save();
            canvas.translate((((float) ((i * 2) + 2)) * c) - (c / 2.0f), d);
            canvas.scale(1.0f, this.a[i]);
            canvas.drawRoundRect(new RectF((-c) / 2.0f, ((float) (-d())) / 2.5f, c / 2.0f, ((float) d()) / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        long[] jArr = new long[]{100, 200, 300, 400, 500};
        for (int i = 0; i < 5; i++) {
            l b = l.b(1.0f, 0.4f, 1.0f);
            b.b(1000);
            b.a(-1);
            b.d(jArr[i]);
            b.a(new b(this) {
                final /* synthetic */ u b;

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
