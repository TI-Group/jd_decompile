package com.jd.fridge.widget.loading.a;

import android.view.animation.LinearInterpolator;
import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class q extends r {
    public List<a> a() {
        List<a> arrayList = new ArrayList();
        float c = (float) (c() / 6);
        float c2 = (float) (c() / 6);
        for (int i = 0; i < 2; i++) {
            l b = l.b(c, ((float) c()) - c, c, ((float) c()) - c, c);
            if (i == 1) {
                b = l.b(((float) c()) - c, c, ((float) c()) - c, c, ((float) c()) - c);
            }
            l b2 = l.b(c2, c2, ((float) d()) - c2, ((float) d()) - c2, c2);
            if (i == 1) {
                b2 = l.b(((float) d()) - c2, ((float) d()) - c2, c2, c2, ((float) d()) - c2);
            }
            b.b(2000);
            b.a(new LinearInterpolator());
            b.a(-1);
            b.a(new b(this) {
                final /* synthetic */ q b;

                public void a(l lVar) {
                    this.b.a[i] = ((Float) lVar.j()).floatValue();
                    this.b.e();
                }
            });
            b.a();
            b2.b(2000);
            b2.a(new LinearInterpolator());
            b2.a(-1);
            b2.a(new b(this) {
                final /* synthetic */ q b;

                public void a(l lVar) {
                    this.b.b[i] = ((Float) lVar.j()).floatValue();
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
