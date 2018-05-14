package c.a;

import android.support.v4.media.TransportMediator;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class bk extends bo {
    private static final bu d = new bu("");
    private static final bl f = new bl("", (byte) 0, (short) 0);
    private static final byte[] g = new byte[16];
    byte[] a = new byte[5];
    byte[] b = new byte[10];
    byte[] c = new byte[1];
    private au h = new au(15);
    private short i = (short) 0;
    private bl j = null;
    private Boolean k = null;
    private final long l;
    private byte[] m = new byte[1];

    /* compiled from: TbsSdkJava */
    public static class a implements br {
        private final long a;

        public a() {
            this.a = -1;
        }

        public a(int i) {
            this.a = (long) i;
        }

        public bo a(cc ccVar) {
            return new bk(ccVar, this.a);
        }
    }

    static {
        g[0] = (byte) 0;
        g[2] = (byte) 1;
        g[3] = (byte) 3;
        g[6] = (byte) 4;
        g[8] = (byte) 5;
        g[10] = (byte) 6;
        g[4] = (byte) 7;
        g[11] = (byte) 8;
        g[15] = (byte) 9;
        g[14] = (byte) 10;
        g[13] = ReplyCode.reply0xb;
        g[12] = ReplyCode.reply0xc;
    }

    public bk(cc ccVar, long j) {
        super(ccVar);
        this.l = j;
    }

    public void x() {
        this.h.b();
        this.i = (short) 0;
    }

    public void a(bu buVar) throws az {
        this.h.a(this.i);
        this.i = (short) 0;
    }

    public void a() throws az {
        this.i = this.h.a();
    }

    public void a(bl blVar) throws az {
        if (blVar.b == (byte) 2) {
            this.j = blVar;
        } else {
            a(blVar, (byte) -1);
        }
    }

    private void a(bl blVar, byte b) throws az {
        if (b == (byte) -1) {
            b = e(blVar.b);
        }
        if (blVar.c <= this.i || blVar.c - this.i > 15) {
            b(b);
            a(blVar.c);
        } else {
            d(((blVar.c - this.i) << 4) | b);
        }
        this.i = blVar.c;
    }

    public void c() throws az {
        b((byte) 0);
    }

    public void a(bn bnVar) throws az {
        if (bnVar.c == 0) {
            d(0);
            return;
        }
        b(bnVar.c);
        d((e(bnVar.a) << 4) | e(bnVar.b));
    }

    public void a(bm bmVar) throws az {
        a(bmVar.a, bmVar.b);
    }

    public void a(boolean z) throws az {
        byte b = (byte) 1;
        if (this.j != null) {
            bl blVar = this.j;
            if (!z) {
                b = (byte) 2;
            }
            a(blVar, b);
            this.j = null;
            return;
        }
        if (!z) {
            b = (byte) 2;
        }
        b(b);
    }

    public void a(byte b) throws az {
        b(b);
    }

    public void a(short s) throws az {
        b(c((int) s));
    }

    public void a(int i) throws az {
        b(c(i));
    }

    public void a(long j) throws az {
        b(c(j));
    }

    public void a(double d) throws az {
        byte[] bArr = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        a(Double.doubleToLongBits(d), bArr, 0);
        this.e.b(bArr);
    }

    public void a(String str) throws az {
        try {
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new az("UTF-8 not supported!");
        }
    }

    public void a(ByteBuffer byteBuffer) throws az {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i, int i2) throws az {
        b(i2);
        this.e.b(bArr, i, i2);
    }

    public void d() throws az {
    }

    public void e() throws az {
    }

    public void b() throws az {
    }

    protected void a(byte b, int i) throws az {
        if (i <= 14) {
            d((i << 4) | e(b));
            return;
        }
        d(e(b) | 240);
        b(i);
    }

    private void b(int i) throws az {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.a[i2] = (byte) ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.a[i2] = (byte) i;
        this.e.b(this.a, 0, i4);
    }

    private void b(long j) throws az {
        int i = 0;
        while ((-128 & j) != 0) {
            int i2 = i + 1;
            this.b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.b[i] = (byte) ((int) j);
        this.e.b(this.b, 0, i3);
    }

    private long c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private int c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private void a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 7] = (byte) ((int) ((j >> 56) & 255));
    }

    private void b(byte b) throws az {
        this.m[0] = b;
        this.e.b(this.m);
    }

    private void d(int i) throws az {
        b((byte) i);
    }

    public bu f() throws az {
        this.h.a(this.i);
        this.i = (short) 0;
        return d;
    }

    public void g() throws az {
        this.i = this.h.a();
    }

    public bl h() throws az {
        byte q = q();
        if (q == (byte) 0) {
            return f;
        }
        short s = (short) ((q & 240) >> 4);
        if (s == (short) 0) {
            s = r();
        } else {
            s = (short) (s + this.i);
        }
        bl blVar = new bl("", d((byte) (q & 15)), s);
        if (c(q)) {
            this.k = ((byte) (q & 15)) == (byte) 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.i = blVar.c;
        return blVar;
    }

    public bn j() throws az {
        int z = z();
        int q = z == 0 ? 0 : q();
        return new bn(d((byte) (q >> 4)), d((byte) (q & 15)), z);
    }

    public bm l() throws az {
        byte q = q();
        int i = (q >> 4) & 15;
        if (i == 15) {
            i = z();
        }
        return new bm(d(q), i);
    }

    public bt n() throws az {
        return new bt(l());
    }

    public boolean p() throws az {
        if (this.k != null) {
            boolean booleanValue = this.k.booleanValue();
            this.k = null;
            return booleanValue;
        } else if (q() != (byte) 1) {
            return false;
        } else {
            return true;
        }
    }

    public byte q() throws az {
        if (this.e.d() > 0) {
            byte b = this.e.b()[this.e.c()];
            this.e.a(1);
            return b;
        }
        this.e.d(this.c, 0, 1);
        return this.c[0];
    }

    public short r() throws az {
        return (short) g(z());
    }

    public int s() throws az {
        return g(z());
    }

    public long t() throws az {
        return d(A());
    }

    public double u() throws az {
        byte[] bArr = new byte[8];
        this.e.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    public String v() throws az {
        int z = z();
        f(z);
        if (z == 0) {
            return "";
        }
        try {
            if (this.e.d() < z) {
                return new String(e(z), HTTP.UTF_8);
            }
            String str = new String(this.e.b(), this.e.c(), z, HTTP.UTF_8);
            this.e.a(z);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new az("UTF-8 not supported!");
        }
    }

    public ByteBuffer w() throws az {
        int z = z();
        f(z);
        if (z == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[z];
        this.e.d(bArr, 0, z);
        return ByteBuffer.wrap(bArr);
    }

    private byte[] e(int i) throws az {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.e.d(bArr, 0, i);
        return bArr;
    }

    private void f(int i) throws bp {
        if (i < 0) {
            throw new bp("Negative length: " + i);
        } else if (this.l != -1 && ((long) i) > this.l) {
            throw new bp("Length exceeded max allowed: " + i);
        }
    }

    public void i() throws az {
    }

    public void k() throws az {
    }

    public void m() throws az {
    }

    public void o() throws az {
    }

    private int z() throws az {
        int i = 0;
        int i2;
        if (this.e.d() >= 5) {
            byte[] b = this.e.b();
            int c = this.e.c();
            i2 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = b[c + i];
                i3 |= (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << i2;
                if ((b2 & 128) != 128) {
                    this.e.a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            i2 = 0;
            while (true) {
                byte q = q();
                i2 |= (q & TransportMediator.KEYCODE_MEDIA_PAUSE) << i;
                if ((q & 128) != 128) {
                    return i2;
                }
                i += 7;
            }
        }
    }

    private long A() throws az {
        long j = null;
        long j2 = 0;
        if (this.e.d() >= 10) {
            int i;
            byte[] b = this.e.b();
            int c = this.e.c();
            long j3 = 0;
            while (true) {
                byte b2 = b[c + i];
                j2 |= ((long) (b2 & TransportMediator.KEYCODE_MEDIA_PAUSE)) << j3;
                if ((b2 & 128) != 128) {
                    break;
                }
                j3 += 7;
                i++;
            }
            this.e.a(i + 1);
        } else {
            while (true) {
                byte q = q();
                j2 |= ((long) (q & TransportMediator.KEYCODE_MEDIA_PAUSE)) << j;
                if ((q & 128) != 128) {
                    break;
                }
                j += 7;
            }
        }
        return j2;
    }

    private int g(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private long d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private long a(byte[] bArr) {
        return ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)) | (((long) bArr[0]) & 255);
    }

    private boolean c(byte b) {
        int i = b & 15;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    private byte d(byte b) throws bp {
        switch ((byte) (b & 15)) {
            case (byte) 0:
                return (byte) 0;
            case (byte) 1:
            case (byte) 2:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            case (byte) 4:
                return (byte) 6;
            case (byte) 5:
                return (byte) 8;
            case (byte) 6:
                return (byte) 10;
            case (byte) 7:
                return (byte) 4;
            case (byte) 8:
                return ReplyCode.reply0xb;
            case (byte) 9:
                return ReplyCode.reply0xf;
            case (byte) 10:
                return ReplyCode.reply0xe;
            case (byte) 11:
                return ReplyCode.reply0xd;
            case (byte) 12:
                return ReplyCode.reply0xc;
            default:
                throw new bp("don't know what type: " + ((byte) (b & 15)));
        }
    }

    private byte e(byte b) {
        return g[b];
    }
}
