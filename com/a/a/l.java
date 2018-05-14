package com.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: TbsSdkJava */
public class l extends a {
    private static ThreadLocal<a> h = new ThreadLocal();
    private static final ThreadLocal<ArrayList<l>> i = new ThreadLocal<ArrayList<l>>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected ArrayList<l> a() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<l>> j = new ThreadLocal<ArrayList<l>>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected ArrayList<l> a() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<l>> k = new ThreadLocal<ArrayList<l>>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected ArrayList<l> a() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<l>> l = new ThreadLocal<ArrayList<l>>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected ArrayList<l> a() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<l>> m = new ThreadLocal<ArrayList<l>>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected ArrayList<l> a() {
            return new ArrayList();
        }
    };
    private static final Interpolator n = new AccelerateDecelerateInterpolator();
    private static final k o = new d();
    private static final k p = new b();
    private static long z = 10;
    private int A = 0;
    private int B = 1;
    private Interpolator C = n;
    private ArrayList<b> D = null;
    long b;
    long c = -1;
    int d = 0;
    boolean e = false;
    j[] f;
    HashMap<String, j> g;
    private boolean q = false;
    private int r = 0;
    private float s = 0.0f;
    private boolean t = false;
    private long u;
    private boolean v = false;
    private boolean w = false;
    private long x = 300;
    private long y = 0;

    /* compiled from: TbsSdkJava */
    private static class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            ArrayList arrayList;
            Object obj;
            ArrayList arrayList2;
            int size;
            int i;
            l lVar;
            ArrayList arrayList3 = (ArrayList) l.i.get();
            ArrayList arrayList4 = (ArrayList) l.k.get();
            switch (message.what) {
                case 0:
                    arrayList = (ArrayList) l.j.get();
                    if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                        obj = null;
                    } else {
                        int i2 = 1;
                    }
                    while (arrayList.size() > 0) {
                        arrayList2 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        size = arrayList2.size();
                        for (i = 0; i < size; i++) {
                            lVar = (l) arrayList2.get(i);
                            if (lVar.y == 0) {
                                lVar.q();
                            } else {
                                arrayList4.add(lVar);
                            }
                        }
                    }
                    break;
                case 1:
                    obj = 1;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) l.m.get();
            arrayList2 = (ArrayList) l.l.get();
            size = arrayList4.size();
            for (i = 0; i < size; i++) {
                lVar = (l) arrayList4.get(i);
                if (lVar.a(currentAnimationTimeMillis)) {
                    arrayList.add(lVar);
                }
            }
            size = arrayList.size();
            if (size > 0) {
                for (i = 0; i < size; i++) {
                    lVar = (l) arrayList.get(i);
                    lVar.q();
                    lVar.v = true;
                    arrayList4.remove(lVar);
                }
                arrayList.clear();
            }
            i = arrayList3.size();
            int i3 = 0;
            while (i3 < i) {
                int i4;
                l lVar2 = (l) arrayList3.get(i3);
                if (lVar2.e(currentAnimationTimeMillis)) {
                    arrayList2.add(lVar2);
                }
                if (arrayList3.size() == i) {
                    i4 = i3 + 1;
                    i3 = i;
                } else {
                    i--;
                    arrayList2.remove(lVar2);
                    i4 = i3;
                    i3 = i;
                }
                i = i3;
                i3 = i4;
            }
            if (arrayList2.size() > 0) {
                for (i3 = 0; i3 < arrayList2.size(); i3++) {
                    ((l) arrayList2.get(i3)).g();
                }
                arrayList2.clear();
            }
            if (obj == null) {
                return;
            }
            if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, l.z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(l lVar);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return h();
    }

    public /* synthetic */ a e() {
        return h();
    }

    public static l b(int... iArr) {
        l lVar = new l();
        lVar.a(iArr);
        return lVar;
    }

    public static l b(float... fArr) {
        l lVar = new l();
        lVar.a(fArr);
        return lVar;
    }

    public void a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.f == null || this.f.length == 0) {
                a(j.a("", iArr));
            } else {
                this.f[0].a(iArr);
            }
            this.e = false;
        }
    }

    public void a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f == null || this.f.length == 0) {
                a(j.a("", fArr));
            } else {
                this.f[0].a(fArr);
            }
            this.e = false;
        }
    }

    public void a(j... jVarArr) {
        this.f = jVarArr;
        this.g = new HashMap(r2);
        for (j jVar : jVarArr) {
            this.g.put(jVar.c(), jVar);
        }
        this.e = false;
    }

    void f() {
        if (!this.e) {
            for (j b : this.f) {
                b.b();
            }
            this.e = true;
        }
    }

    public l b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.x = j;
        return this;
    }

    public void c(long j) {
        f();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.d != 1) {
            this.c = j;
            this.d = 2;
        }
        this.b = currentAnimationTimeMillis - j;
        e(currentAnimationTimeMillis);
    }

    public long i() {
        if (!this.e || this.d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.b;
    }

    public void d(long j) {
        this.y = j;
    }

    public Object j() {
        if (this.f == null || this.f.length <= 0) {
            return null;
        }
        return this.f[0].d();
    }

    public void a(int i) {
        this.A = i;
    }

    public void a(b bVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(bVar);
    }

    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.C = interpolator;
        } else {
            this.C = new LinearInterpolator();
        }
    }

    private void a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.q = z;
        this.r = 0;
        this.d = 0;
        this.w = true;
        this.t = false;
        ((ArrayList) j.get()).add(this);
        if (this.y == 0) {
            c(i());
            this.d = 0;
            this.v = true;
            if (this.a != null) {
                ArrayList arrayList = (ArrayList) this.a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((com.a.a.a.a) arrayList.get(i)).a(this);
                }
            }
        }
        a aVar = (a) h.get();
        if (aVar == null) {
            aVar = new a();
            h.set(aVar);
        }
        aVar.sendEmptyMessage(0);
    }

    public void a() {
        a(false);
    }

    public void b() {
        if (this.d != 0 || ((ArrayList) j.get()).contains(this) || ((ArrayList) k.get()).contains(this)) {
            if (this.v && this.a != null) {
                Iterator it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((com.a.a.a.a) it.next()).c(this);
                }
            }
            g();
        }
    }

    public void c() {
        if (!((ArrayList) i.get()).contains(this) && !((ArrayList) j.get()).contains(this)) {
            this.t = false;
            q();
        } else if (!this.e) {
            f();
        }
        if (this.A <= 0 || (this.A & 1) != 1) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        g();
    }

    public boolean d() {
        return this.d == 1 || this.v;
    }

    private void g() {
        ((ArrayList) i.get()).remove(this);
        ((ArrayList) j.get()).remove(this);
        ((ArrayList) k.get()).remove(this);
        this.d = 0;
        if (this.v && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((com.a.a.a.a) arrayList.get(i)).b(this);
            }
        }
        this.v = false;
        this.w = false;
    }

    private void q() {
        f();
        ((ArrayList) i.get()).add(this);
        if (this.y > 0 && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((com.a.a.a.a) arrayList.get(i)).a(this);
            }
        }
    }

    private boolean a(long j) {
        if (this.t) {
            long j2 = j - this.u;
            if (j2 > this.y) {
                this.b = j - (j2 - this.y);
                this.d = 1;
                return true;
            }
        }
        this.t = true;
        this.u = j;
        return false;
    }

    boolean e(long j) {
        boolean z = false;
        if (this.d == 0) {
            this.d = 1;
            if (this.c < 0) {
                this.b = j;
            } else {
                this.b = j - this.c;
                this.c = -1;
            }
        }
        switch (this.d) {
            case 1:
            case 2:
                float f;
                float f2 = this.x > 0 ? ((float) (j - this.b)) / ((float) this.x) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.r < this.A || this.A == -1) {
                    if (this.a != null) {
                        int size = this.a.size();
                        for (int i = 0; i < size; i++) {
                            ((com.a.a.a.a) this.a.get(i)).d(this);
                        }
                    }
                    if (this.B == 2) {
                        this.q = !this.q;
                    }
                    this.r += (int) f2;
                    f = f2 % 1.0f;
                    this.b += this.x;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.q) {
                    f = 1.0f - f;
                }
                a(f);
                break;
        }
        return z;
    }

    void a(float f) {
        int i;
        float interpolation = this.C.getInterpolation(f);
        this.s = interpolation;
        for (j a : this.f) {
            a.a(interpolation);
        }
        if (this.D != null) {
            int size = this.D.size();
            for (i = 0; i < size; i++) {
                ((b) this.D.get(i)).a(this);
            }
        }
    }

    public l h() {
        int i = 0;
        l lVar = (l) super.e();
        if (this.D != null) {
            ArrayList arrayList = this.D;
            lVar.D = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                lVar.D.add(arrayList.get(i2));
            }
        }
        lVar.c = -1;
        lVar.q = false;
        lVar.r = 0;
        lVar.e = false;
        lVar.d = 0;
        lVar.t = false;
        j[] jVarArr = this.f;
        if (jVarArr != null) {
            int length = jVarArr.length;
            lVar.f = new j[length];
            lVar.g = new HashMap(length);
            while (i < length) {
                j a = jVarArr[i].a();
                lVar.f[i] = a;
                lVar.g.put(a.c(), a);
                i++;
            }
        }
        return lVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f != null) {
            for (j jVar : this.f) {
                str = str + "\n    " + jVar.toString();
            }
        }
        return str;
    }
}
