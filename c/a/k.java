package c.a;

import android.content.Context;
import c.a.cg.a;
import com.b.a.e;

/* compiled from: TbsSdkJava */
public class k implements cw {
    private static k l = null;
    private final long a = 1296000000;
    private final long b = 129600000;
    private final int c = 1800000;
    private final int d = 10000;
    private com.b.a.k e;
    private c f;
    private long g = 1296000000;
    private int h = 10000;
    private long i = 0;
    private long j = 0;
    private Context k;

    public static synchronized k a(Context context, c cVar) {
        k kVar;
        synchronized (k.class) {
            if (l == null) {
                l = new k(context, cVar);
                l.a(cg.a(context).b());
            }
            kVar = l;
        }
        return kVar;
    }

    private k(Context context, c cVar) {
        this.k = context;
        this.e = com.b.a.k.a(context);
        this.f = cVar;
    }

    public boolean a() {
        if (this.e.e() || this.f.a()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f.j();
        if (currentTimeMillis > this.g) {
            this.i = (long) e.a(this.h, aw.a(this.k));
            this.j = currentTimeMillis;
            return true;
        } else if (currentTimeMillis <= 129600000) {
            return false;
        } else {
            this.i = 0;
            this.j = currentTimeMillis;
            return true;
        }
    }

    public long b() {
        return this.i;
    }

    public void a(a aVar) {
        this.g = aVar.a(1296000000);
        int b = aVar.b(0);
        if (b != 0) {
            this.h = b;
        } else if (com.b.a.a.g <= 0 || com.b.a.a.g > 1800000) {
            this.h = 10000;
        } else {
            this.h = com.b.a.a.g;
        }
    }
}
