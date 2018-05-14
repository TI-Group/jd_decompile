package com.a.a;

import android.view.View;
import com.a.b.c;
import com.a.c.a.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class h extends l {
    private static final Map<String, c> h = new HashMap();
    private Object i;
    private String j;
    private c k;

    public /* synthetic */ l b(long j) {
        return a(j);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return g();
    }

    public /* synthetic */ a e() {
        return g();
    }

    public /* synthetic */ l h() {
        return g();
    }

    static {
        h.put("alpha", i.a);
        h.put("pivotX", i.b);
        h.put("pivotY", i.c);
        h.put("translationX", i.d);
        h.put("translationY", i.e);
        h.put("rotation", i.f);
        h.put("rotationX", i.g);
        h.put("rotationY", i.h);
        h.put("scaleX", i.i);
        h.put("scaleY", i.j);
        h.put("scrollX", i.k);
        h.put("scrollY", i.l);
        h.put("x", i.m);
        h.put("y", i.n);
    }

    public void a(String str) {
        if (this.f != null) {
            j jVar = this.f[0];
            String c = jVar.c();
            jVar.a(str);
            this.g.remove(c);
            this.g.put(str, jVar);
        }
        this.j = str;
        this.e = false;
    }

    public void a(c cVar) {
        if (this.f != null) {
            j jVar = this.f[0];
            String c = jVar.c();
            jVar.a(cVar);
            this.g.remove(c);
            this.g.put(this.j, jVar);
        }
        if (this.k != null) {
            this.j = cVar.a();
        }
        this.k = cVar;
        this.e = false;
    }

    private h(Object obj, String str) {
        this.i = obj;
        a(str);
    }

    public static h a(Object obj, String str, float... fArr) {
        h hVar = new h(obj, str);
        hVar.a(fArr);
        return hVar;
    }

    public static h a(Object obj, j... jVarArr) {
        h hVar = new h();
        hVar.i = obj;
        hVar.a(jVarArr);
        return hVar;
    }

    public void a(int... iArr) {
        if (this.f != null && this.f.length != 0) {
            super.a(iArr);
        } else if (this.k != null) {
            a(j.a(this.k, iArr));
        } else {
            a(j.a(this.j, iArr));
        }
    }

    public void a(float... fArr) {
        if (this.f != null && this.f.length != 0) {
            super.a(fArr);
        } else if (this.k != null) {
            a(j.a(this.k, fArr));
        } else {
            a(j.a(this.j, fArr));
        }
    }

    public void a() {
        super.a();
    }

    void f() {
        if (!this.e) {
            if (this.k == null && a.a && (this.i instanceof View) && h.containsKey(this.j)) {
                a((c) h.get(this.j));
            }
            for (j a : this.f) {
                a.a(this.i);
            }
            super.f();
        }
    }

    public h a(long j) {
        super.b(j);
        return this;
    }

    void a(float f) {
        super.a(f);
        for (j b : this.f) {
            b.b(this.i);
        }
    }

    public h g() {
        return (h) super.h();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
        if (this.f != null) {
            for (j jVar : this.f) {
                str = str + "\n    " + jVar.toString();
            }
        }
        return str;
    }
}
