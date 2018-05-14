package com.a.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: TbsSdkJava */
class g {
    int a;
    f b;
    f c;
    Interpolator d;
    ArrayList<f> e = new ArrayList();
    k f;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public g(f... fVarArr) {
        this.a = fVarArr.length;
        this.e.addAll(Arrays.asList(fVarArr));
        this.b = (f) this.e.get(0);
        this.c = (f) this.e.get(this.a - 1);
        this.d = this.c.d();
    }

    public static g a(int... iArr) {
        int i = 1;
        int length = iArr.length;
        b[] bVarArr = new b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (b) f.a(0.0f);
            bVarArr[1] = (b) f.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (b) f.a(0.0f, iArr[0]);
            while (i < length) {
                bVarArr[i] = (b) f.a(((float) i) / ((float) (length - 1)), iArr[i]);
                i++;
            }
        }
        return new e(bVarArr);
    }

    public static g a(float... fArr) {
        int i = 1;
        int length = fArr.length;
        a[] aVarArr = new a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (a) f.b(0.0f);
            aVarArr[1] = (a) f.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (a) f.a(0.0f, fArr[0]);
            while (i < length) {
                aVarArr[i] = (a) f.a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new c(aVarArr);
    }

    public void a(k kVar) {
        this.f = kVar;
    }

    public g b() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        f[] fVarArr = new f[size];
        for (int i = 0; i < size; i++) {
            fVarArr[i] = ((f) arrayList.get(i)).e();
        }
        return new g(fVarArr);
    }

    public Object a(float f) {
        if (this.a == 2) {
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            return this.f.a(f, this.b.b(), this.c.b());
        } else if (f <= 0.0f) {
            r0 = (f) this.e.get(1);
            r1 = r0.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.b.c();
            return this.f.a((f - r1) / (r0.c() - r1), this.b.b(), r0.b());
        } else if (f >= 1.0f) {
            r0 = (f) this.e.get(this.a - 2);
            r1 = this.c.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.c();
            return this.f.a((f - r1) / (this.c.c() - r1), r0.b(), this.c.b());
        } else {
            f fVar = this.b;
            int i = 1;
            while (i < this.a) {
                r0 = (f) this.e.get(i);
                if (f < r0.c()) {
                    r1 = r0.d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = fVar.c();
                    return this.f.a((f - r1) / (r0.c() - r1), fVar.b(), r0.b());
                }
                i++;
                fVar = r0;
            }
            return this.c.b();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.a) {
            String str2 = str + ((f) this.e.get(i)).b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
