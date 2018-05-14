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
public class v extends s {
    float[] a = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 9);
        float d = (float) (d() / 2);
        for (int i = 0; i < 4; i++) {
            canvas.save();
            canvas.translate((((float) ((i * 2) + 2)) * c) - (c / 2.0f), d);
            canvas.scale(this.a[i], this.a[i]);
            canvas.drawRoundRect(new RectF((-c) / 2.0f, ((float) (-d())) / 2.5f, c / 2.0f, ((float) d()) / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        long[] jArr = new long[]{1260, 430, 1010, 730};
        long[] jArr2 = new long[]{770, 290, 280, 740};
        for (int i = 0; i < 4; i++) {
            l b = l.b(1.0f, 0.4f, 1.0f);
            b.b(jArr[i]);
            b.a(-1);
            b.d(jArr2[i]);
            b.a(new b(this) {
                final /* synthetic */ v b;

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
