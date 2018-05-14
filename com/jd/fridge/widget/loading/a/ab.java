package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.h;
import com.a.a.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class ab extends s {
    public void a(Canvas canvas, Paint paint) {
        canvas.drawRect(new RectF((float) (c() / 5), (float) (d() / 5), (float) ((c() * 4) / 5), (float) ((d() * 4) / 5)), paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        j a = j.a("rotationX", 0.0f, 180.0f, 180.0f, 0.0f, 0.0f);
        j a2 = j.a("rotationY", 0.0f, 0.0f, 180.0f, 180.0f, 0.0f);
        h a3 = h.a(b(), a2, a);
        a3.a(new LinearInterpolator());
        a3.a(-1);
        a3.a(2500);
        a3.a();
        arrayList.add(a3);
        return arrayList;
    }
}
