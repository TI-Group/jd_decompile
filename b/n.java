package b;

import java.io.IOException;

/* compiled from: TbsSdkJava */
final class n implements d {
    public final c a;
    public final r b;
    private boolean c;

    public n(r rVar, c cVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = cVar;
        this.b = rVar;
    }

    public n(r rVar) {
        this(rVar, new c());
    }

    public c b() {
        return this.a;
    }

    public void write(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.write(cVar, j);
        w();
    }

    public d b(f fVar) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(fVar);
        return w();
    }

    public d b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return w();
    }

    public d c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bArr);
        return w();
    }

    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bArr, i, i2);
        return w();
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this.a, 2048);
            if (read == -1) {
                return j;
            }
            j += read;
            w();
        }
    }

    public d h(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(i);
        return w();
    }

    public d g(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(i);
        return w();
    }

    public d f(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(i);
        return w();
    }

    public d l(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.i(j);
        return w();
    }

    public d k(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.j(j);
        return w();
    }

    public d w() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long g = this.a.g();
        if (g > 0) {
            this.b.write(this.a, g);
        }
        return this;
    }

    public d d() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long a = this.a.a();
        if (a > 0) {
            this.b.write(this.a, a);
        }
        return this;
    }

    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.write(this.a, this.a.b);
        }
        this.b.flush();
    }

    public void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.write(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                u.a(th);
            }
        }
    }

    public t timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
