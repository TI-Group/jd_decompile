package b;

/* compiled from: TbsSdkJava */
final class p {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    p f;
    p g;

    p() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    p(p pVar) {
        this(pVar.a, pVar.b, pVar.c);
        pVar.d = true;
    }

    p(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public p a() {
        p pVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return pVar;
    }

    public p a(p pVar) {
        pVar.g = this;
        pVar.f = this.f;
        this.f.g = pVar;
        this.f = pVar;
        return pVar;
    }

    public p a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        p pVar = new p(this);
        pVar.c = pVar.b + i;
        this.b += i;
        this.g.a(pVar);
        return pVar;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        } else if (this.g.e) {
            int i = this.c - this.b;
            if (i <= (this.g.d ? 0 : this.g.b) + (2048 - this.g.c)) {
                a(this.g, i);
                a();
                q.a(this);
            }
        }
    }

    public void a(p pVar, int i) {
        if (pVar.e) {
            if (pVar.c + i > 2048) {
                if (pVar.d) {
                    throw new IllegalArgumentException();
                } else if ((pVar.c + i) - pVar.b > 2048) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(pVar.a, pVar.b, pVar.a, 0, pVar.c - pVar.b);
                    pVar.c -= pVar.b;
                    pVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, pVar.a, pVar.c, i);
            pVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
