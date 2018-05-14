package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class e extends s {
    int[] a = new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255};

    public void a(Canvas canvas, Paint paint) {
        float c = (((float) c()) - (4.0f * 4.0f)) / 6.0f;
        float c2 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        float c3 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                canvas.save();
                canvas.translate((((c * 2.0f) * ((float) i2)) + c2) + (((float) i2) * 4.0f), (((c * 2.0f) * ((float) i)) + c3) + (((float) i) * 4.0f));
                paint.setAlpha(this.a[(i * 3) + i2]);
                canvas.drawCircle(0.0f, 0.0f, c, paint);
                canvas.restore();
            }
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        int[] iArr = new int[]{960, 930, 1190, 1130, 1340, 940, 1200, 820, 1190};
        int[] iArr2 = new int[]{360, 400, 680, 410, 710, -150, -120, 10, 320};
        for (int i = 0; i < 9; i++) {
            l b = l.b(255, 168, 255);
            b.b((long) iArr[i]);
            b.a(-1);
            b.d((long) iArr2[i]);
            b.a(new b(this) {
                final /* synthetic */ e b;

                public void a(l lVar) {
                    this.b.a[i] = ((Integer) lVar.j()).intValue();
                    this.b.e();
                }
            });
            b.a();
            arrayList.add(b);
        }
        return arrayList;
    }
}
