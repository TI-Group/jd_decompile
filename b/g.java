package b;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: TbsSdkJava */
public final class g implements r {
    private final d a;
    private final Deflater b;
    private boolean c;

    public g(r rVar, Deflater deflater) {
        this(m.a(rVar), deflater);
    }

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = dVar;
            this.b = deflater;
        }
    }

    public void write(c cVar, long j) throws IOException {
        u.a(cVar.b, 0, j);
        while (j > 0) {
            p pVar = cVar.a;
            int min = (int) Math.min(j, (long) (pVar.c - pVar.b));
            this.b.setInput(pVar.a, pVar.b, min);
            a(false);
            cVar.b -= (long) min;
            pVar.b += min;
            if (pVar.b == pVar.c) {
                cVar.a = pVar.a();
                q.a(pVar);
            }
            j -= (long) min;
        }
    }

    @IgnoreJRERequirement
    private void a(boolean z) throws IOException {
        c b = this.a.b();
        while (true) {
            int deflate;
            p e = b.e(1);
            if (z) {
                deflate = this.b.deflate(e.a, e.c, 2048 - e.c, 2);
            } else {
                deflate = this.b.deflate(e.a, e.c, 2048 - e.c);
            }
            if (deflate > 0) {
                e.c += deflate;
                b.b += (long) deflate;
                this.a.w();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (e.b == e.c) {
            b.a = e.a();
            q.a(e);
        }
    }

    public void flush() throws IOException {
        a(true);
        this.a.flush();
    }

    void a() throws IOException {
        this.b.finish();
        a(false);
    }

    public void close() throws IOException {
        Throwable th;
        if (!this.c) {
            Throwable th2 = null;
            try {
                a();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.b.end();
                th = th2;
            } catch (Throwable th4) {
                th = th4;
                if (th2 != null) {
                    th = th2;
                }
            }
            try {
                this.a.close();
            } catch (Throwable th22) {
                if (th == null) {
                    th = th22;
                }
            }
            this.c = true;
            if (th != null) {
                u.a(th);
            }
        }
    }

    public t timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.a + ")";
    }
}
