package com.jd.fridge.widget.loading.a;

import com.a.a.a;
import com.a.a.l;
import com.a.a.l.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class w extends u {
    public List<a> a() {
        List<a> arrayList = new ArrayList();
        long[] jArr = new long[]{500, 250, 0, 250, 500};
        for (int i = 0; i < 5; i++) {
            l b = l.b(1.0f, 0.3f, 1.0f);
            b.b(900);
            b.a(-1);
            b.d(jArr[i]);
            b.a(new b(this) {
                final /* synthetic */ w b;

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
