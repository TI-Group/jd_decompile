package c.a;

import android.support.v4.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: TbsSdkJava */
public abstract class a {
    private final int a = 10;
    private final int b = 20;
    private final String c;
    private List<v> d;
    private x e;

    public abstract String f();

    public a(String str) {
        this.c = str;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        if (this.e == null || this.e.j() <= 20) {
            return true;
        }
        return false;
    }

    private boolean g() {
        x xVar = this.e;
        String c = xVar == null ? null : xVar.c();
        int j = xVar == null ? 0 : xVar.j();
        String a = a(f());
        if (a == null || a.equals(c)) {
            return false;
        }
        if (xVar == null) {
            xVar = new x();
        }
        xVar.a(a);
        xVar.a(System.currentTimeMillis());
        xVar.a(j + 1);
        v vVar = new v();
        vVar.a(this.c);
        vVar.c(a);
        vVar.b(c);
        vVar.a(xVar.f());
        if (this.d == null) {
            this.d = new ArrayList(2);
        }
        this.d.add(vVar);
        if (this.d.size() > 10) {
            this.d.remove(0);
        }
        this.e = xVar;
        return true;
    }

    public x d() {
        return this.e;
    }

    public List<v> e() {
        return this.d;
    }

    public void a(List<v> list) {
        this.d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || EnvironmentCompat.MEDIA_UNKNOWN.equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(y yVar) {
        this.e = (x) yVar.d().get(this.c);
        List<v> j = yVar.j();
        if (j != null && j.size() > 0) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            for (v vVar : j) {
                if (this.c.equals(vVar.a)) {
                    this.d.add(vVar);
                }
            }
        }
    }
}
