package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.a.a.l;
import com.a.a.l.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class o extends s {
    float[] a = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    int[] b = new int[]{255, 255, 255, 255, 255, 255, 255, 255};

    /* compiled from: TbsSdkJava */
    final class a {
        public float a;
        public float b;
        final /* synthetic */ o c;

        public a(o oVar, float f, float f2) {
            this.c = oVar;
            this.a = f;
            this.b = f2;
        }
    }

    public void a(Canvas canvas, Paint paint) {
        float c = (float) (c() / 10);
        for (int i = 0; i < 8; i++) {
            canvas.save();
            a a = a(c(), d(), ((float) (c() / 2)) - c, ((double) i) * 0.7853981633974483d);
            canvas.translate(a.a, a.b);
            canvas.scale(this.a[i], this.a[i]);
            paint.setAlpha(this.b[i]);
            canvas.drawCircle(0.0f, 0.0f, c, paint);
            canvas.restore();
        }
    }

    a a(int i, int i2, float f, double d) {
        return new a(this, (float) (((double) (i / 2)) + (((double) f) * Math.cos(d))), (float) (((double) (i2 / 2)) + (((double) f) * Math.sin(d))));
    }

    public List<com.a.a.a> a() {
        List<com.a.a.a> arrayList = new ArrayList();
        int[] iArr = new int[]{0, ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 240, 360, 480, 600, 720, 780, 840};
        for (int i = 0; i < 8; i++) {
            l b = l.b(1.0f, 0.4f, 1.0f);
            b.b(1000);
            b.a(-1);
            b.d((long) iArr[i]);
            b.a(new b(this) {
                final /* synthetic */ o b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            l b2 = l.b(255, 77, 255);
            b2.b(1000);
            b2.a(-1);
            b2.d((long) iArr[i]);
            b2.a(new b(this) {
                final /* synthetic */ o b;

                public void a(l lVar) {
                    this.b.b[i] = ((Integer) lVar.j()).intValue();
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
