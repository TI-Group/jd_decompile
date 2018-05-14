package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class z extends s {
    private float a;
    private int b;
    private float c;
    private float d;

    public void a(Canvas canvas, Paint paint) {
        b(canvas, paint);
        c(canvas, paint);
    }

    private void b(Canvas canvas, Paint paint) {
        float c = (float) (c() / 2);
        float d = (float) (d() / 2);
        canvas.save();
        canvas.translate(c, d);
        canvas.rotate(this.c);
        paint.setAlpha(255);
        canvas.drawArc(new RectF((-c) / 1.7f, (-d) / 1.7f, c / 1.7f, d / 1.7f), 0.0f, 270.0f, true, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(c, d);
        canvas.rotate(this.d);
        paint.setAlpha(255);
        canvas.drawArc(new RectF((-c) / 1.7f, (-d) / 1.7f, c / 1.7f, d / 1.7f), 90.0f, 270.0f, true, paint);
        canvas.restore();
    }

    private void c(Canvas canvas, Paint paint) {
        float c = (float) (c() / 11);
        paint.setAlpha(this.b);
        canvas.drawCircle(this.a, (float) (d() / 2), c, paint);
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        float c = (float) (c() / 11);
        l b = l.b(((float) c()) - c, (float) (c() / 2));
        b.b(650);
        b.a(new LinearInterpolator());
        b.a(-1);
        b.a(new b(this) {
            final /* synthetic */ z a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.a = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b.a();
        l b2 = l.b(255, ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR);
        b2.b(650);
        b2.a(-1);
        b2.a(new b(this) {
            final /* synthetic */ z a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.b = ((Integer) lVar.j()).intValue();
                this.a.e();
            }
        });
        b2.a();
        l b3 = l.b(0.0f, 45.0f, 0.0f);
        b3.b(650);
        b3.a(-1);
        b3.a(new b(this) {
            final /* synthetic */ z a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.c = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b3.a();
        l b4 = l.b(0.0f, -45.0f, 0.0f);
        b4.b(650);
        b4.a(-1);
        b4.a(new b(this) {
            final /* synthetic */ z a;

            {
                this.a = r1;
            }

            public void a(l lVar) {
                this.a.d = ((Float) lVar.j()).floatValue();
                this.a.e();
            }
        });
        b4.a();
        arrayList.add(b);
        arrayList.add(b2);
        arrayList.add(b3);
        arrayList.add(b4);
        return arrayList;
    }
}
