package c.a;

import android.content.Context;
import com.b.a.i;
import com.b.a.j;

/* compiled from: TbsSdkJava */
public final class cm implements cq {
    private static cm c;
    private cq a = new cl(this.b);
    private Context b;

    private cm(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized cm a(Context context) {
        cm cmVar;
        synchronized (cm.class) {
            if (c == null && context != null) {
                c = new cm(context);
            }
            cmVar = c;
        }
        return cmVar;
    }

    public void a(final cr crVar) {
        i.a(new j(this) {
            final /* synthetic */ cm b;

            public void a() {
                this.b.a.a(crVar);
            }
        });
    }

    public void b(cr crVar) {
        this.a.b(crVar);
    }

    public void b() {
        i.a(new j(this) {
            final /* synthetic */ cm a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.a.b();
            }
        });
    }
}
