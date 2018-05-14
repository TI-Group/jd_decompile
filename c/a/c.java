package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.b.a.k;
import org.apache.commons.lang.time.DateUtils;

/* compiled from: TbsSdkJava */
public class c implements cs {
    public int a;
    public int b;
    public long c;
    private final int d = DateUtils.MILLIS_IN_HOUR;
    private int e;
    private long f = 0;
    private long g = 0;
    private Context h;

    public c(Context context) {
        b(context);
    }

    private void b(Context context) {
        this.h = context.getApplicationContext();
        SharedPreferences a = cx.a(context);
        this.a = a.getInt("successful_request", 0);
        this.b = a.getInt("failed_requests ", 0);
        this.e = a.getInt("last_request_spent_ms", 0);
        this.c = a.getLong("last_request_time", 0);
        this.f = a.getLong("last_req", 0);
    }

    public boolean a() {
        boolean z;
        if (this.c == 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (k.a(this.h).e()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    public void b() {
        this.a++;
        this.c = this.f;
    }

    public void c() {
        this.b++;
    }

    public void d() {
        this.f = System.currentTimeMillis();
    }

    public void e() {
        this.e = (int) (System.currentTimeMillis() - this.f);
    }

    public void f() {
        cx.a(this.h).edit().putInt("successful_request", this.a).putInt("failed_requests ", this.b).putInt("last_request_spent_ms", this.e).putLong("last_request_time", this.c).putLong("last_req", this.f).commit();
    }

    public void g() {
        cx.a(this.h).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
    }

    public boolean h() {
        if (this.g == 0) {
            this.g = cx.a(this.h).getLong("first_activate_time", 0);
        }
        return this.g == 0;
    }

    public long i() {
        return h() ? System.currentTimeMillis() : this.g;
    }

    public long j() {
        return this.f;
    }

    public static p a(Context context) {
        SharedPreferences a = cx.a(context);
        p pVar = new p();
        pVar.c(a.getInt("failed_requests ", 0));
        pVar.d(a.getInt("last_request_spent_ms", 0));
        pVar.a(a.getInt("successful_request", 0));
        return pVar;
    }

    public void k() {
        d();
    }

    public void l() {
        e();
    }

    public void m() {
        b();
    }

    public void n() {
        c();
    }
}
