package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class a extends s {
    int[] a = new int[]{255, 255, 255};
    private float[] b = new float[]{1.0f, 1.0f, 1.0f};

    public void a(Canvas canvas, Paint paint) {
        float c = (((float) c()) - (4.0f * 2.0f)) / 6.0f;
        float c2 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        float d = (float) (d() / 2);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate((((c * 2.0f) * ((float) i)) + c2) + (((float) i) * 4.0f), d);
            canvas.scale(this.b[i], this.b[i]);
            paint.setAlpha(this.a[i]);
            canvas.drawCircle(0.0f, 0.0f, c, paint);
            canvas.restore();
        }
    }

    public List<com.a.a.a> a() {
        List<com.a.a.a> arrayList = new ArrayList();
        int[] iArr = new int[]{350, 0, 350};
        for (int i = 0; i < 3; i++) {
            l b = l.b(1.0f, 0.75f, 1.0f);
            b.b(700);
            b.a(-1);
            b.d((long) iArr[i]);
            b.a(new b(this) {
                final /* synthetic */ a b;

                public void a(l lVar) {
                    this.b.b[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            l b2 = l.b(255, 51, 255);
            b2.b(700);
            b2.a(-1);
            b2.d((long) iArr[i]);
            b2.a(new b(this) {
                final /* synthetic */ a b;

                public void a(l lVar) {
                    this.b.a[i] = ((Integer) lVar.j()).intValue();
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
