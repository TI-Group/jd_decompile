package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class i extends s {
    float[] a = new float[3];

    public void a(Canvas canvas, Paint paint) {
        float c = (((float) c()) - (4.0f * 2.0f)) / 6.0f;
        float c2 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate((((c * 2.0f) * ((float) i)) + c2) + (((float) i) * 4.0f), this.a[i]);
            canvas.drawCircle(0.0f, 0.0f, c, paint);
            canvas.restore();
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        float c = (((float) c()) - (4.0f * 2.0f)) / 6.0f;
        int[] iArr = new int[]{70, 140, ErrorCode.ROM_NOT_ENOUGH};
        for (int i = 0; i < 3; i++) {
            l b = l.b((float) (d() / 2), ((float) (d() / 2)) - (c * 2.0f), (float) (d() / 2));
            b.b(600);
            b.a(-1);
            b.d((long) iArr[i]);
            b.a(new b(this) {
                final /* synthetic */ i b;

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
