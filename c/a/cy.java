package c.a;

import android.content.Context;
import com.b.a.a;
import com.b.a.k;
import com.b.a.k.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: TbsSdkJava */
public class cy {
    private ce a;
    private cg b;
    private final int c = 1;
    private Context d;
    private c e;
    private cu f;
    private am g;
    private boolean h = false;
    private boolean i;

    public cy(Context context, c cVar) {
        this.a = ce.a(context);
        this.b = cg.a(context);
        this.d = context;
        this.e = cVar;
        this.f = new cu(context);
        this.f.a(this.e);
    }

    public void a(am amVar) {
        this.g = amVar;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public void a(cw cwVar) {
        this.b.a(cwVar);
    }

    public void a() {
        if (this.g != null) {
            c();
        } else {
            b();
        }
    }

    private void b() {
        k.a(this.d).f().a(new b(this) {
            final /* synthetic */ cy a;

            {
                this.a = r1;
            }

            public void a(File file) {
            }

            public boolean b(File file) {
                Throwable th;
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] b = ar.b(fileInputStream);
                        try {
                            int i;
                            ar.c(fileInputStream);
                            byte[] a = this.a.f.a(b);
                            if (a == null) {
                                i = 1;
                            } else {
                                i = this.a.a(a);
                            }
                            if (i == 2 && this.a.e.h()) {
                                this.a.e.g();
                            }
                            if (!this.a.i && i == 1) {
                                return false;
                            }
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        ar.c(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    ar.c(fileInputStream);
                    throw th;
                }
            }

            public void c(File file) {
                this.a.e.f();
            }
        });
    }

    private void c() {
        this.a.a();
        am amVar = this.g;
        amVar.a(this.a.b());
        byte[] b = b(amVar);
        if (b == null) {
            as.c("message is null");
            return;
        }
        aw b2;
        int i;
        if (this.h) {
            b2 = aw.b(this.d, a.a(this.d), b);
        } else {
            b2 = aw.a(this.d, a.a(this.d), b);
        }
        byte[] c = b2.c();
        k.a(this.d).d();
        b = this.f.a(c);
        if (b == null) {
            i = 1;
        } else {
            i = a(b);
        }
        switch (i) {
            case 1:
                if (!this.i) {
                    k.a(this.d).b(c);
                }
                as.d("connection error");
                return;
            case 2:
                if (this.e.h()) {
                    this.e.g();
                }
                this.a.c();
                this.e.f();
                return;
            case 3:
                this.e.f();
                return;
            default:
                return;
        }
    }

    private int a(byte[] bArr) {
        ai aiVar = new ai();
        try {
            new ay(new bj.a()).a(aiVar, bArr);
            if (aiVar.a == 1) {
                this.b.b(aiVar.j());
                this.b.d();
            }
            as.b("send log:" + aiVar.f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (aiVar.a == 1) {
            return 2;
        }
        return 3;
    }

    private byte[] b(am amVar) {
        if (amVar == null) {
            return null;
        }
        try {
            byte[] a = new bb().a(amVar);
            if (as.a) {
                as.a(amVar.toString());
            }
            return a;
        } catch (Throwable e) {
            as.b("Fail to serialize log ...", e);
            return null;
        }
    }
}
