package b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: TbsSdkJava */
public final class k implements s {
    private int a = 0;
    private final e b;
    private final Inflater c;
    private final l d;
    private final CRC32 e = new CRC32();

    public k(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = m.a(sVar);
        this.d = new l(this.b, this.c);
    }

    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.a == 0) {
                a();
                this.a = 1;
            }
            if (this.a == 1) {
                long j2 = cVar.b;
                long read = this.d.read(cVar, j);
                if (read != -1) {
                    a(cVar, j2, read);
                    return read;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                b();
                this.a = 3;
                if (!this.b.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void a() throws IOException {
        Object obj;
        long a;
        this.b.a(10);
        byte c = this.b.b().c(3);
        if (((c >> 1) & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            a(this.b.b(), 0, 10);
        }
        a("ID1ID2", 8075, this.b.i());
        this.b.h(8);
        if (((c >> 2) & 1) == 1) {
            this.b.a(2);
            if (obj != null) {
                a(this.b.b(), 0, 2);
            }
            short l = this.b.b().l();
            this.b.a((long) l);
            if (obj != null) {
                a(this.b.b(), 0, (long) l);
            }
            this.b.h((long) l);
        }
        if (((c >> 3) & 1) == 1) {
            a = this.b.a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                a(this.b.b(), 0, 1 + a);
            }
            this.b.h(1 + a);
        }
        if (((c >> 4) & 1) == 1) {
            a = this.b.a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (obj != null) {
                a(this.b.b(), 0, 1 + a);
            }
            this.b.h(1 + a);
        }
        if (obj != null) {
            a("FHCRC", this.b.l(), (short) ((int) this.e.getValue()));
            this.e.reset();
        }
    }

    private void b() throws IOException {
        a("CRC", this.b.m(), (int) this.e.getValue());
        a("ISIZE", this.b.m(), this.c.getTotalOut());
    }

    public t timeout() {
        return this.b.timeout();
    }

    public void close() throws IOException {
        this.d.close();
    }

    private void a(c cVar, long j, long j2) {
        p pVar = cVar.a;
        while (j >= ((long) (pVar.c - pVar.b))) {
            j -= (long) (pVar.c - pVar.b);
            pVar = pVar.f;
        }
        while (j2 > 0) {
            int i = (int) (((long) pVar.b) + j);
            int min = (int) Math.min((long) (pVar.c - i), j2);
            this.e.update(pVar.a, i, min);
            j2 -= (long) min;
            pVar = pVar.f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
