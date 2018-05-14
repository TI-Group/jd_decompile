package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class f extends s {
    int[] a = new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255};
    float[] b = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void a(Canvas canvas, Paint paint) {
        float c = (((float) c()) - (4.0f * 4.0f)) / 6.0f;
        float c2 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        float c3 = ((float) (c() / 2)) - ((c * 2.0f) + 4.0f);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                canvas.save();
                canvas.translate((((c * 2.0f) * ((float) i2)) + c2) + (((float) i2) * 4.0f), (((c * 2.0f) * ((float) i)) + c3) + (((float) i) * 4.0f));
                canvas.scale(this.b[(i * 3) + i2], this.b[(i * 3) + i2]);
                paint.setAlpha(this.a[(i * 3) + i2]);
                canvas.drawCircle(0.0f, 0.0f, c, paint);
                canvas.restore();
            }
        }
    }

    public List<a> a() {
        List<a> arrayList = new ArrayList();
        int[] iArr = new int[]{720, 1020, 1280, 1420, 1450, 1180, 870, 1450, 1060};
        int[] iArr2 = new int[]{-60, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, -170, 480, 310, 30, 460, 780, 450};
        for (int i = 0; i < 9; i++) {
            l b = l.b(1.0f, 0.5f, 1.0f);
            b.b((long) iArr[i]);
            b.a(-1);
            b.d((long) iArr2[i]);
            b.a(new b(this) {
                final /* synthetic */ f b;

                public void a(l lVar) {
                    this.b.b[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            l b2 = l.b(255, ErrorCode.ROM_NOT_ENOUGH, ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR, 255);
            b2.b((long) iArr[i]);
            b2.a(-1);
            b2.d((long) iArr2[i]);
            b2.a(new b(this) {
                final /* synthetic */ f b;

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
