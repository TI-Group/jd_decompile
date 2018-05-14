package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class h extends s {
    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 10);
        canvas.drawCircle((float) (c() / 4), c * 2.0f, c, paint);
        canvas.drawCircle((float) ((c() * 3) / 4), c * 2.0f, c, paint);
        canvas.drawCircle(c, ((float) d()) - (2.0f * c), c, paint);
        canvas.drawCircle((float) (c() / 2), ((float) d()) - (2.0f * c), c, paint);
        canvas.drawCircle(((float) c()) - c, ((float) d()) - (2.0f * c), c, paint);
    }

    public List<a> a() {
        j a = j.a("rotationX", 0.0f, 360.0f);
        com.a.a.h a2 = com.a.a.h.a(b(), a);
        a2.a(new LinearInterpolator());
        a2.a(-1);
        a2.a(1500);
        a2.a();
        List<a> arrayList = new ArrayList();
        arrayList.add(a2);
        return arrayList;
    }
}
