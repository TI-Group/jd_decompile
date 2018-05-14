package b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
final class o implements e {
    public final c a;
    public final s b;
    private boolean c;

    public o(s sVar, c cVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = cVar;
        this.b = sVar;
    }

    public o(s sVar) {
        this(sVar, new c());
    }

    public c b() {
        return this.a;
    }

    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.read(this.a, 2048) == -1) {
            return -1;
        } else {
            return this.a.read(cVar, Math.min(j, this.a.b));
        }
    }

    public boolean e() throws IOException {
        if (!this.c) {
            return this.a.e() && this.b.read(this.a, 2048) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.a.b < j) {
                if (this.b.read(this.a, 2048) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public byte h() throws IOException {
        a(1);
        return this.a.h();
    }

    public f d(long j) throws IOException {
        a(j);
        return this.a.d(j);
    }

    public byte[] t() throws IOException {
        this.a.a(this.b);
        return this.a.t();
    }

    public byte[] g(long j) throws IOException {
        a(j);
        return this.a.g(j);
    }

    public String a(long j, Charset charset) throws IOException {
        a(j);
        if (charset != null) {
            return this.a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String s() throws IOException {
        long a = a((byte) 10);
        if (a != -1) {
            return this.a.f(a);
        }
        c cVar = new c();
        this.a.a(cVar, 0, Math.min(32, this.a.a()));
        throw new EOFException("\\n not found: size=" + this.a.a() + " content=" + cVar.q().hex() + "...");
    }

    public short i() throws IOException {
        a(2);
        return this.a.i();
    }

    public short l() throws IOException {
        a(2);
        return this.a.l();
    }

    public int j() throws IOException {
        a(4);
        return this.a.j();
    }

    public int m() throws IOException {
        a(4);
        return this.a.m();
    }

    public long n() throws IOException {
        a(8);
        return this.a.n();
    }

    public long o() throws IOException {
        a(1);
        int i = 0;
        while (b((long) (i + 1))) {
            byte c = this.a.c((long) i);
            if ((c < (byte) 48 || c > ReplyCode.reply0x39) && !(i == 0 && c == (byte) 45)) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(c)}));
                }
                return this.a.o();
            }
            i++;
        }
        return this.a.o();
    }

    public long p() throws IOException {
        a(1);
        for (int i = 0; b((long) (i + 1)); i++) {
            byte c = this.a.c((long) i);
            if ((c < (byte) 48 || c > ReplyCode.reply0x39) && ((c < (byte) 97 || c > (byte) 102) && (c < (byte) 65 || c > (byte) 70))) {
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(c)}));
                }
                return this.a.p();
            }
        }
        return this.a.p();
    }

    public void h(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.read(this.a, 2048) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.a());
            this.a.h(min);
            j -= min;
        }
    }

    public long a(byte b) throws IOException {
        return a(b, 0);
    }

    public long a(byte b, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j >= this.a.b) {
            if (this.b.read(this.a, 2048) == -1) {
                return -1;
            }
        }
        do {
            long a = this.a.a(b, j);
            if (a != -1) {
                return a;
            }
            j = this.a.b;
        } while (this.b.read(this.a, 2048) != -1);
        return -1;
    }

    public InputStream f() {
        return new InputStream(this) {
            final /* synthetic */ o a;

            {
                this.a = r1;
            }

            public int read() throws IOException {
                if (this.a.c) {
                    throw new IOException("closed");
                } else if (this.a.a.b == 0 && this.a.b.read(this.a.a, 2048) == -1) {
                    return -1;
                } else {
                    return this.a.a.h() & 255;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (this.a.c) {
                    throw new IOException("closed");
                }
                u.a((long) bArr.length, (long) i, (long) i2);
                if (this.a.a.b == 0 && this.a.b.read(this.a.a, 2048) == -1) {
                    return -1;
                }
                return this.a.a.a(bArr, i, i2);
            }

            public int available() throws IOException {
                if (!this.a.c) {
                    return (int) Math.min(this.a.a.b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                this.a.close();
            }

            public String toString() {
                return this.a + ".inputStream()";
            }
        };
    }

    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.u();
        }
    }

    public t timeout() {
        return this.b.timeout();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
