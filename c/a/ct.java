package c.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.b.a.a;
import com.b.a.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class ct {
    private List<cr> a = new ArrayList();
    private m b = null;
    private o c = null;
    private r d = null;
    private ae e = null;
    private Context f = null;

    public ct(Context context) {
        this.f = context;
    }

    public synchronized int a() {
        int size;
        size = this.a.size();
        if (this.b != null) {
            size++;
        }
        return size;
    }

    public synchronized void a(cr crVar) {
        this.a.add(crVar);
    }

    public void a(am amVar) {
        String b = b.b(this.f);
        if (b != null) {
            synchronized (this) {
                if (this.b != null && new c(this.f).a()) {
                    amVar.a(this.b);
                    this.b = null;
                }
                for (cr a : this.a) {
                    a.a(amVar, b);
                }
                this.a.clear();
            }
            amVar.a(b());
            amVar.a(c());
            amVar.a(d());
            amVar.a(g());
            amVar.a(e());
            amVar.a(f());
            amVar.a(i());
            amVar.a(h());
        }
    }

    public synchronized void a(m mVar) {
        this.b = mVar;
    }

    public synchronized o b() {
        if (this.c == null) {
            this.c = new o();
            a(this.f);
        }
        return this.c;
    }

    public synchronized r c() {
        if (this.d == null) {
            this.d = new r();
            b(this.f);
        }
        return this.d;
    }

    public synchronized ae d() {
        if (this.e == null) {
            this.e = new ae();
            c(this.f);
        }
        return this.e;
    }

    public z e() {
        try {
            return cg.a(this.f).a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public y f() {
        try {
            return ce.a(this.f).b();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public p g() {
        try {
            return c.a(this.f);
        } catch (Exception e) {
            e.printStackTrace();
            return new p();
        }
    }

    public Map<String, Integer> h() {
        return i.a(this.f).c();
    }

    public n i() {
        String[] a = h.a(this.f);
        if (a == null || TextUtils.isEmpty(a[0]) || TextUtils.isEmpty(a[1])) {
            return null;
        }
        return new n(a[0], a[1]);
    }

    private void a(Context context) {
        try {
            this.c.a(a.a(context));
            this.c.e(a.b(context));
            if (!(a.a == null || a.b == null)) {
                this.c.f(a.a);
                this.c.g(a.b);
            }
            this.c.c(aq.o(context));
            this.c.a(aj.ANDROID);
            this.c.d("5.6.7");
            this.c.b(aq.b(context));
            this.c.a(Integer.parseInt(aq.a(context)));
            this.c.h(aq.p(context));
            this.c.c(a.c);
            this.c.d(a.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(Context context) {
        try {
            this.d.f(aq.a());
            this.d.a(aq.c(context));
            this.d.b(aq.d(context));
            this.d.c(aq.k(context));
            this.d.e(Build.MODEL);
            this.d.g("Android");
            this.d.h(VERSION.RELEASE);
            int[] l = aq.l(context);
            if (l != null) {
                this.d.a(new ah(l[1], l[0]));
            }
            if (a.e == null || a.d != null) {
                this.d.i(Build.BOARD);
                this.d.j(Build.BRAND);
                this.d.a(Build.TIME);
                this.d.k(Build.MANUFACTURER);
                this.d.l(Build.ID);
                this.d.m(Build.DEVICE);
            } else {
                this.d.i(Build.BOARD);
                this.d.j(Build.BRAND);
                this.d.a(Build.TIME);
                this.d.k(Build.MANUFACTURER);
                this.d.l(Build.ID);
                this.d.m(Build.DEVICE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(Context context) {
        try {
            String[] e = aq.e(context);
            if ("Wi-Fi".equals(e[0])) {
                this.e.a(l.ACCESS_TYPE_WIFI);
            } else if ("2G/3G".equals(e[0])) {
                this.e.a(l.ACCESS_TYPE_2G_3G);
            } else {
                this.e.a(l.ACCESS_TYPE_UNKNOWN);
            }
            if (!"".equals(e[1])) {
                this.e.e(e[1]);
            }
            this.e.c(aq.m(context));
            e = aq.i(context);
            this.e.d(aq.r(context));
            this.e.b(e[0]);
            this.e.a(e[1]);
            this.e.a(aq.h(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
