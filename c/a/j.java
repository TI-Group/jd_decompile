package c.a;

import android.content.Context;
import c.a.cg.a;
import java.util.Arrays;

/* compiled from: TbsSdkJava */
public class j implements cw {
    private static j c = null;
    private int a = 0;
    private final long b = 60000;

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (c == null) {
                c = new j();
                c.a(cg.a(context).b().a(0));
            }
            jVar = c;
        }
        return jVar;
    }

    private j() {
    }

    public am a(Context context, am amVar) {
        if (amVar == null) {
            return null;
        }
        if (this.a == 1) {
            amVar.a(null);
            return amVar;
        } else if (this.a == 2) {
            amVar.b(Arrays.asList(new ak[]{b(context)}));
            amVar.a(null);
            return amVar;
        } else if (this.a != 3) {
            return amVar;
        } else {
            amVar.b(null);
            amVar.a(null);
            return amVar;
        }
    }

    public ak b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        ak akVar = new ak();
        akVar.a(b.b(context));
        akVar.a(currentTimeMillis);
        akVar.b(currentTimeMillis + 60000);
        akVar.c(60000);
        return akVar;
    }

    public long a() {
        switch (this.a) {
            case 1:
                return 14400000;
            case 2:
                return 28800000;
            case 3:
                return 86400000;
            default:
                return 0;
        }
    }

    public void a(int i) {
        if (i >= 0 && i <= 3) {
            this.a = i;
        }
    }

    public boolean b() {
        return this.a != 0;
    }

    public void a(a aVar) {
        a(aVar.a(0));
    }
}
