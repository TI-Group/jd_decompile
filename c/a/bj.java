package c.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class bj extends bo {
    private static final bu f = new bu();
    protected boolean a = false;
    protected boolean b = true;
    protected int c;
    protected boolean d = false;
    private byte[] g = new byte[1];
    private byte[] h = new byte[2];
    private byte[] i = new byte[4];
    private byte[] j = new byte[8];
    private byte[] k = new byte[1];
    private byte[] l = new byte[2];
    private byte[] m = new byte[4];
    private byte[] n = new byte[8];

    /* compiled from: TbsSdkJava */
    public static class a implements br {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        public bo a(cc ccVar) {
            bo bjVar = new bj(ccVar, this.a, this.b);
            if (this.c != 0) {
                bjVar.c(this.c);
            }
            return bjVar;
        }
    }

    public bj(cc ccVar, boolean z, boolean z2) {
        super(ccVar);
        this.a = z;
        this.b = z2;
    }

    public void a(bu buVar) {
    }

    public void a() {
    }

    public void a(bl blVar) throws az {
        a(blVar.b);
        a(blVar.c);
    }

    public void b() {
    }

    public void c() throws az {
        a((byte) 0);
    }

    public void a(bn bnVar) throws az {
        a(bnVar.a);
        a(bnVar.b);
        a(bnVar.c);
    }

    public void d() {
    }

    public void a(bm bmVar) throws az {
        a(bmVar.a);
        a(bmVar.b);
    }

    public void e() {
    }

    public void a(boolean z) throws az {
        a(z ? (byte) 1 : (byte) 0);
    }

    public void a(byte b) throws az {
        this.g[0] = b;
        this.e.b(this.g, 0, 1);
    }

    public void a(short s) throws az {
        this.h[0] = (byte) ((s >> 8) & 255);
        this.h[1] = (byte) (s & 255);
        this.e.b(this.h, 0, 2);
    }

    public void a(int i) throws az {
        this.i[0] = (byte) ((i >> 24) & 255);
        this.i[1] = (byte) ((i >> 16) & 255);
        this.i[2] = (byte) ((i >> 8) & 255);
        this.i[3] = (byte) (i & 255);
        this.e.b(this.i, 0, 4);
    }

    public void a(long j) throws az {
        this.j[0] = (byte) ((int) ((j >> 56) & 255));
        this.j[1] = (byte) ((int) ((j >> 48) & 255));
        this.j[2] = (byte) ((int) ((j >> 40) & 255));
        this.j[3] = (byte) ((int) ((j >> 32) & 255));
        this.j[4] = (byte) ((int) ((j >> 24) & 255));
        this.j[5] = (byte) ((int) ((j >> 16) & 255));
        this.j[6] = (byte) ((int) ((j >> 8) & 255));
        this.j[7] = (byte) ((int) (255 & j));
        this.e.b(this.j, 0, 8);
    }

    public void a(double d) throws az {
        a(Double.doubleToLongBits(d));
    }

    public void a(String str) throws az {
        try {
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            a(bytes.length);
            this.e.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new az("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) throws az {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.e.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public bu f() {
        return f;
    }

    public void g() {
    }

    public bl h() throws az {
        byte q = q();
        return new bl("", q, q == (byte) 0 ? (short) 0 : r());
    }

    public void i() {
    }

    public bn j() throws az {
        return new bn(q(), q(), s());
    }

    public void k() {
    }

    public bm l() throws az {
        return new bm(q(), s());
    }

    public void m() {
    }

    public bt n() throws az {
        return new bt(q(), s());
    }

    public void o() {
    }

    public boolean p() throws az {
        return q() == (byte) 1;
    }

    public byte q() throws az {
        if (this.e.d() >= 1) {
            byte b = this.e.b()[this.e.c()];
            this.e.a(1);
            return b;
        }
        a(this.k, 0, 1);
        return this.k[0];
    }

    public short r() throws az {
        int i = 0;
        byte[] bArr = this.l;
        if (this.e.d() >= 2) {
            bArr = this.e.b();
            i = this.e.c();
            this.e.a(2);
        } else {
            a(this.l, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public int s() throws az {
        int i = 0;
        byte[] bArr = this.m;
        if (this.e.d() >= 4) {
            bArr = this.e.b();
            i = this.e.c();
            this.e.a(4);
        } else {
            a(this.m, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public long t() throws az {
        int i = 0;
        byte[] bArr = this.n;
        if (this.e.d() >= 8) {
            bArr = this.e.b();
            i = this.e.c();
            this.e.a(8);
        } else {
            a(this.n, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8));
    }

    public double u() throws az {
        return Double.longBitsToDouble(t());
    }

    public String v() throws az {
        int s = s();
        if (this.e.d() < s) {
            return b(s);
        }
        try {
            String str = new String(this.e.b(), this.e.c(), s, HTTP.UTF_8);
            this.e.a(s);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new az("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public String b(int i) throws az {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.e.d(bArr, 0, i);
            return new String(bArr, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new az("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ByteBuffer w() throws az {
        int s = s();
        d(s);
        if (this.e.d() >= s) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.b(), this.e.c(), s);
            this.e.a(s);
            return wrap;
        }
        byte[] bArr = new byte[s];
        this.e.d(bArr, 0, s);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i, int i2) throws az {
        d(i2);
        return this.e.d(bArr, i, i2);
    }

    public void c(int i) {
        this.c = i;
        this.d = true;
    }

    protected void d(int i) throws az {
        if (i < 0) {
            throw new bp("Negative length: " + i);
        } else if (this.d) {
            this.c -= i;
            if (this.c < 0) {
                throw new bp("Message length exceeded: " + i);
            }
        }
    }
}
