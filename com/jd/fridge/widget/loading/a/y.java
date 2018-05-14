package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: TbsSdkJava */
public class y extends o {
    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 10);
        for (int i = 0; i < 8; i++) {
            canvas.save();
            a a = a(c(), d(), (((float) c()) / 2.5f) - c, ((double) i) * 0.7853981633974483d);
            canvas.translate(a.a, a.b);
            canvas.scale(this.a[i], this.a[i]);
            canvas.rotate((float) (i * 45));
            paint.setAlpha(this.b[i]);
            canvas.drawRoundRect(new RectF(-c, (-c) / 1.5f, 1.5f * c, c / 1.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
