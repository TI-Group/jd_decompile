package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.b.a.c.b;
import com.b.a.c.c;
import com.b.a.c.d;
import com.b.a.c.e;
import com.b.a.c.f;
import com.b.a.c.g;
import com.b.a.c.h;
import com.b.a.c.i;
import com.b.a.c.j;
import com.b.a.k;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class cl implements cq, cw {
    private final long a = 28800000;
    private final int b = 5000;
    private ct c = null;
    private k d = null;
    private c e = null;
    private j f = null;
    private i g = null;
    private k h = null;
    private a i = null;
    private c.a.cg.a j = null;
    private int k = 10;
    private long l = 0;
    private int m = 0;
    private int n = 0;
    private Context o;

    /* compiled from: TbsSdkJava */
    public class a {
        final /* synthetic */ cl a;
        private h b;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private int f = -1;

        public a(cl clVar) {
            this.a = clVar;
            int[] a = clVar.j.a(-1, -1);
            this.c = a[0];
            this.d = a[1];
        }

        protected void a(boolean z) {
            int i = 1;
            int i2 = 0;
            if (this.a.f.b()) {
                h hVar;
                if (!((this.b instanceof b) && this.b.a())) {
                    i = 0;
                }
                if (i != 0) {
                    hVar = this.b;
                } else {
                    hVar = new b(this.a.e, this.a.f);
                }
                this.b = hVar;
            } else {
                if (!((this.b instanceof c) && this.b.a())) {
                    i = 0;
                }
                if (i == 0) {
                    if (z && this.a.h.a()) {
                        this.b = new c((int) this.a.h.b());
                        this.a.b((int) this.a.h.b());
                    } else if (as.a && this.a.j.b()) {
                        as.a("Debug: send log every 15 seconds");
                        this.b = new com.b.a.c.a(this.a.e);
                    } else if (this.a.g.a()) {
                        as.a("Start A/B Test");
                        if (this.a.g.b() == 6) {
                            if (this.a.j.a()) {
                                i2 = this.a.j.d(90000);
                            } else if (this.d > 0) {
                                i2 = this.d;
                            } else {
                                i2 = this.f;
                            }
                        }
                        this.b = a(this.a.g.b(), i2);
                    } else {
                        i = this.e;
                        i2 = this.f;
                        if (this.c != -1) {
                            i = this.c;
                            i2 = this.d;
                        }
                        this.b = a(i, i2);
                    }
                }
            }
            as.a("Report policy : " + this.b.getClass().getSimpleName());
        }

        public h b(boolean z) {
            a(z);
            return this.b;
        }

        private h a(int i, int i2) {
            switch (i) {
                case 0:
                    return this.b instanceof g ? this.b : new g();
                case 1:
                    return this.b instanceof d ? this.b : new d();
                case 4:
                    if (this.b instanceof f) {
                        return this.b;
                    }
                    return new f(this.a.e);
                case 5:
                    if (this.b instanceof i) {
                        return this.b;
                    }
                    return new i(this.a.o);
                case 6:
                    if (!(this.b instanceof e)) {
                        return new e(this.a.e, (long) i2);
                    }
                    h hVar = this.b;
                    ((e) hVar).a((long) i2);
                    return hVar;
                case 8:
                    if (this.b instanceof j) {
                        return this.b;
                    }
                    return new j(this.a.e);
                default:
                    if (this.b instanceof d) {
                        return this.b;
                    }
                    return new d();
            }
        }

        public void a(c.a.cg.a aVar) {
            int[] a = aVar.a(-1, -1);
            this.c = a[0];
            this.d = a[1];
        }
    }

    public cl(Context context) {
        this.o = context;
        this.c = new ct(context);
        this.e = new c(context);
        this.d = k.a(context);
        this.j = cg.a(context).b();
        this.i = new a(this);
        this.g = i.a(this.o);
        this.f = j.a(this.o);
        this.h = k.a(this.o, this.e);
        SharedPreferences a = cx.a(this.o);
        this.l = a.getLong("thtstart", 0);
        this.m = a.getInt("gkvc", 0);
        this.n = a.getInt("ekvc", 0);
    }

    public void a() {
        if (aq.g(this.o)) {
            d();
        } else {
            as.a("network is unavailable");
        }
    }

    public void a(cr crVar) {
        if (crVar != null) {
            this.c.a(crVar);
        }
        a(crVar instanceof ak);
    }

    public void b(cr crVar) {
        this.c.a(crVar);
    }

    public void b() {
        if (this.c.a() > 0) {
            try {
                byte[] b = b(a(new int[0]));
                if (b != null) {
                    this.d.a(b);
                }
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    this.d.d();
                }
                if (th != null) {
                    th.printStackTrace();
                }
            }
        }
        cx.a(this.o).edit().putLong("thtstart", this.l).putInt("gkvc", this.m).putInt("ekvc", this.n).commit();
    }

    private void a(boolean z) {
        boolean a = this.e.a();
        if (a) {
            this.c.a(new m(this.e.i()));
        }
        if (b(z)) {
            d();
        } else if (a || c()) {
            b();
        }
    }

    private void a(int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.e.j());
        a(a(i, currentTimeMillis));
        com.b.a.i.a(new com.b.a.j(this) {
            final /* synthetic */ cl a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.a();
            }
        }, (long) i);
    }

    private void a(am amVar) {
        if (amVar != null) {
            ce a = ce.a(this.o);
            a.a();
            amVar.a(a.b());
            byte[] b = b(d(amVar));
            if (b != null) {
                aw b2;
                if (e()) {
                    b2 = aw.b(this.o, com.b.a.a.a(this.o), b);
                } else {
                    b2 = aw.a(this.o, com.b.a.a.a(this.o), b);
                }
                b = b2.c();
                k a2 = k.a(this.o);
                a2.d();
                a2.b(b);
                a.c();
            }
        }
    }

    protected am a(int... iArr) {
        Object obj = null;
        try {
            if (TextUtils.isEmpty(com.b.a.a.a(this.o))) {
                as.d("Appkey is missing ,Please check AndroidManifest.xml");
                return null;
            }
            byte[] c = k.a(this.o).c();
            am a = c == null ? null : a(c);
            if (a == null && this.c.a() == 0) {
                return null;
            }
            am amVar;
            if (a == null) {
                amVar = new am();
            } else {
                amVar = a;
            }
            this.c.a(amVar);
            if (as.a && amVar.B()) {
                for (ak p : amVar.z()) {
                    Object obj2;
                    if (p.p() > 0) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                }
                if (obj == null) {
                    as.c("missing Activities or PageViews");
                }
            }
            a = this.f.a(this.o, amVar);
            if (iArr == null || iArr.length != 2) {
                return a;
            }
            q qVar = new q();
            qVar.a(new ac(iArr[0] / 1000, (long) iArr[1]));
            a.a(qVar);
            return a;
        } catch (Throwable e) {
            as.b("Fail to construct message ...", e);
            k.a(this.o).d();
            return null;
        }
    }

    private am a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            av amVar = new am();
            new ay().a(amVar, bArr);
            return amVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] b(am amVar) {
        if (amVar == null) {
            return null;
        }
        try {
            byte[] a = new bb().a(amVar);
            as.a(amVar.toString());
            return a;
        } catch (Throwable e) {
            as.b("Fail to serialize log ...", e);
            return null;
        }
    }

    private boolean b(boolean z) {
        if (!aq.g(this.o)) {
            as.a("network is unavailable");
            return false;
        } else if (this.e.a()) {
            return true;
        } else {
            return this.i.b(z).a(z);
        }
    }

    private boolean c() {
        return this.c.a() > this.k;
    }

    private void d() {
        try {
            if (this.d.e()) {
                cy cyVar = new cy(this.o, this.e);
                cyVar.a((cw) this);
                if (this.f.b()) {
                    cyVar.b(true);
                }
                cyVar.a();
                return;
            }
            am a = a(new int[0]);
            if (c(a)) {
                cy cyVar2 = new cy(this.o, this.e);
                cyVar2.a((cw) this);
                if (this.f.b()) {
                    cyVar2.b(true);
                }
                cyVar2.a(d(a));
                cyVar2.a(e());
                cyVar2.a();
                return;
            }
            as.d(" not legitimate!");
        } catch (Throwable th) {
            if (th instanceof OutOfMemoryError) {
                if (th != null) {
                    th.printStackTrace();
                }
            } else if (th != null) {
                th.printStackTrace();
            }
        }
    }

    private boolean c(am amVar) {
        if (amVar == null) {
            as.d("No data to report");
            return false;
        } else if (amVar.c() == null || amVar.f() == null || amVar.j() == null || amVar.m() == null) {
            return false;
        } else {
            return true;
        }
    }

    private am d(am amVar) {
        int i;
        int i2;
        int i3;
        long currentTimeMillis;
        int i4 = 0;
        int i5 = 5000;
        List u = amVar.u();
        if (u != null) {
            int size = u.size();
            if (size > 0) {
                i = 0;
                i2 = 0;
                for (i3 = 0; i3 < size; i3++) {
                    i2 += ((ab) u.get(i3)).q();
                    i += ((ab) u.get(i3)).l();
                }
                i4 = i;
                i = i2;
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.l <= 28800000) {
                    i2 = i - 5000;
                    i3 = i4 - 5000;
                    if (i2 > 0 || i3 > 0) {
                        a(i2, i3, u);
                    }
                    if (i2 > 0) {
                        i = 5000;
                    }
                    this.m = i;
                    if (i3 <= 0) {
                        i5 = i4;
                    }
                    this.n = i5;
                    this.l = currentTimeMillis;
                } else {
                    i2 = this.m <= 5000 ? i : (this.m + i) - 5000;
                    i3 = this.n <= 5000 ? i4 : (this.n + i4) - 5000;
                    if (i2 > 0 || i3 > 0) {
                        a(i2, i3, u);
                    }
                    this.m = i2 <= 0 ? 5000 : i + this.m;
                    if (i3 <= 0) {
                        i5 = this.n + i4;
                    }
                    this.n = i5;
                }
                return amVar;
            }
        }
        i = 0;
        currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.l <= 28800000) {
            if (this.m <= 5000) {
            }
            if (this.n <= 5000) {
            }
            a(i2, i3, u);
            if (i2 <= 0) {
            }
            this.m = i2 <= 0 ? 5000 : i + this.m;
            if (i3 <= 0) {
                i5 = this.n + i4;
            }
            this.n = i5;
        } else {
            i2 = i - 5000;
            i3 = i4 - 5000;
            a(i2, i3, u);
            if (i2 > 0) {
                i = 5000;
            }
            this.m = i;
            if (i3 <= 0) {
                i5 = i4;
            }
            this.n = i5;
            this.l = currentTimeMillis;
        }
        return amVar;
    }

    private void a(int i, int i2, List<ab> list) {
        int i3;
        int size;
        int size2 = list.size();
        if (i > 0) {
            i3 = size2 - 1;
            while (i3 >= 0) {
                List s = ((ab) list.get(i3)).s();
                if (s.size() >= i) {
                    i3 = s.size() - i;
                    for (size = s.size() - 1; size >= i3; size--) {
                        s.remove(size);
                    }
                } else {
                    i -= s.size();
                    s.clear();
                    i3--;
                }
            }
        }
        if (i2 > 0) {
            for (i3 = size2 - 1; i3 >= 0; i3--) {
                List n = ((ab) list.get(i3)).n();
                if (n.size() >= i2) {
                    i3 = n.size() - i2;
                    for (size = n.size() - 1; size >= i3; size--) {
                        n.remove(size);
                    }
                    return;
                }
                i2 -= n.size();
                n.clear();
            }
        }
    }

    private boolean e() {
        switch (this.j.c(-1)) {
            case -1:
                return com.b.a.a.f;
            case 1:
                return true;
            default:
                return false;
        }
    }

    private void b(int i) {
        a(i);
    }

    public void a(c.a.cg.a aVar) {
        this.g.a(aVar);
        this.f.a(aVar);
        this.h.a(aVar);
        this.i.a(aVar);
    }
}
