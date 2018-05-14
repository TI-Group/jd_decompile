package b;

import cn.jiguang.net.HttpUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* compiled from: TbsSdkJava */
public final class l implements s {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    public l(s sVar, Inflater inflater) {
        this(m.a(sVar), inflater);
    }

    l(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = eVar;
            this.b = inflater;
        }
    }

    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean a;
            do {
                a = a();
                try {
                    p e = cVar.e(1);
                    int inflate = this.b.inflate(e.a, e.c, 2048 - e.c);
                    if (inflate > 0) {
                        e.c += inflate;
                        cVar.b += (long) inflate;
                        return (long) inflate;
                    } else if (this.b.finished() || this.b.needsDictionary()) {
                        b();
                        if (e.b == e.c) {
                            cVar.a = e.a();
                            q.a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!a);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public boolean a() throws IOException {
        if (!this.b.needsInput()) {
            return false;
        }
        b();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException(HttpUtils.URL_AND_PARA_SEPARATOR);
        } else if (this.a.e()) {
            return true;
        } else {
            p pVar = this.a.b().a;
            this.c = pVar.c - pVar.b;
            this.b.setInput(pVar.a, pVar.b, this.c);
            return false;
        }
    }

    private void b() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.b.getRemaining();
            this.c -= remaining;
            this.a.h((long) remaining);
        }
    }

    public t timeout() {
        return this.a.timeout();
    }

    public void close() throws IOException {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }
}
