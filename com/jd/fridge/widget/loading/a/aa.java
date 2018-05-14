package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.a.a.a;
import com.a.a.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class aa extends s {
    public void a(Canvas canvas, Paint paint) {
        canvas.drawArc(new RectF(0.0f, 0.0f, (float) c(), (float) d()), -60.0f, 120.0f, false, paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        h a = h.a(b(), "rotation", 0.0f, 180.0f, 360.0f);
        a.a(600);
        a.a(-1);
        a.a();
        arrayList.add(a);
        return arrayList;
    }
}
