package b;

import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public final class c implements d, e, Cloneable {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 97, (byte) 98, (byte) 99, ReplyCode.reply0x64, (byte) 101, (byte) 102};
    p a;
    long b;

    public /* synthetic */ d b(f fVar) throws IOException {
        return a(fVar);
    }

    public /* synthetic */ d b(String str) throws IOException {
        return a(str);
    }

    public /* synthetic */ d c(byte[] bArr) throws IOException {
        return b(bArr);
    }

    public /* synthetic */ d c(byte[] bArr, int i, int i2) throws IOException {
        return b(bArr, i, i2);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return v();
    }

    public /* synthetic */ d f(int i) throws IOException {
        return d(i);
    }

    public /* synthetic */ d g(int i) throws IOException {
        return c(i);
    }

    public /* synthetic */ d h(int i) throws IOException {
        return b(i);
    }

    public /* synthetic */ d k(long j) throws IOException {
        return j(j);
    }

    public /* synthetic */ d l(long j) throws IOException {
        return i(j);
    }

    public /* synthetic */ d w() throws IOException {
        return c();
    }

    public long a() {
        return this.b;
    }

    public c b() {
        return this;
    }

    public c c() {
        return this;
    }

    public d d() {
        return this;
    }

    public boolean e() {
        return this.b == 0;
    }

    public void a(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        return this.b >= j;
    }

    public InputStream f() {
        return new InputStream(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public int read() {
                if (this.a.b > 0) {
                    return this.a.h() & 255;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return this.a.a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(this.a.b, 2147483647L);
            }

            public void close() {
            }

            public String toString() {
                return this.a + ".inputStream()";
            }
        };
    }

    public c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.b, j, j2);
        if (j2 != 0) {
            cVar.b += j2;
            p pVar = this.a;
            while (j >= ((long) (pVar.c - pVar.b))) {
                j -= (long) (pVar.c - pVar.b);
                pVar = pVar.f;
            }
            while (j2 > 0) {
                p pVar2 = new p(pVar);
                pVar2.b = (int) (((long) pVar2.b) + j);
                pVar2.c = Math.min(pVar2.b + ((int) j2), pVar2.c);
                if (cVar.a == null) {
                    pVar2.g = pVar2;
                    pVar2.f = pVar2;
                    cVar.a = pVar2;
                } else {
                    cVar.a.g.a(pVar2);
                }
                j2 -= (long) (pVar2.c - pVar2.b);
                pVar = pVar.f;
                j = 0;
            }
        }
        return this;
    }

    public long g() {
        long j = this.b;
        if (j == 0) {
            return 0;
        }
        p pVar = this.a.g;
        if (pVar.c >= 2048 || !pVar.e) {
            return j;
        }
        return j - ((long) (pVar.c - pVar.b));
    }

    public byte h() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        p pVar = this.a;
        int i = pVar.b;
        int i2 = pVar.c;
        int i3 = i + 1;
        byte b = pVar.a[i];
        this.b--;
        if (i3 == i2) {
            this.a = pVar.a();
            q.a(pVar);
        } else {
            pVar.b = i3;
        }
        return b;
    }

    public byte c(long j) {
        u.a(this.b, j, 1);
        p pVar = this.a;
        while (true) {
            int i = pVar.c - pVar.b;
            if (j < ((long) i)) {
                return pVar.a[pVar.b + ((int) j)];
            }
            j -= (long) i;
            pVar = pVar.f;
        }
    }

    public short i() {
        if (this.b < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        p pVar = this.a;
        int i = pVar.b;
        int i2 = pVar.c;
        if (i2 - i < 2) {
            return (short) (((h() & 255) << 8) | (h() & 255));
        }
        byte[] bArr = pVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b -= 2;
        if (i4 == i2) {
            this.a = pVar.a();
            q.a(pVar);
        } else {
            pVar.b = i4;
        }
        return (short) i;
    }

    public int j() {
        if (this.b < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        p pVar = this.a;
        int i = pVar.b;
        int i2 = pVar.c;
        if (i2 - i < 4) {
            return ((((h() & 255) << 24) | ((h() & 255) << 16)) | ((h() & 255) << 8)) | (h() & 255);
        }
        byte[] bArr = pVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        i = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        i3 = i4 + 1;
        i |= (bArr[i4] & 255) << 8;
        i4 = i3 + 1;
        i |= bArr[i3] & 255;
        this.b -= 4;
        if (i4 == i2) {
            this.a = pVar.a();
            q.a(pVar);
            return i;
        }
        pVar.b = i4;
        return i;
    }

    public long k() {
        if (this.b < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        p pVar = this.a;
        int i = pVar.b;
        int i2 = pVar.c;
        if (i2 - i < 8) {
            return ((((long) j()) & 4294967295L) << 32) | (((long) j()) & 4294967295L);
        }
        byte[] bArr = pVar.a;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        i = i3 + 1;
        long j2 = ((((long) bArr[i3]) & 255) << 48) | j;
        int i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 40)) | ((((long) bArr[i4]) & 255) << 32);
        i4 = i + 1;
        i = i4 + 1;
        j2 = (j2 | ((((long) bArr[i]) & 255) << 24)) | ((((long) bArr[i4]) & 255) << 16);
        i4 = i + 1;
        int i5 = i4 + 1;
        long j3 = (((long) bArr[i4]) & 255) | (j2 | ((((long) bArr[i]) & 255) << 8));
        this.b -= 8;
        if (i5 == i2) {
            this.a = pVar.a();
            q.a(pVar);
            return j3;
        }
        pVar.b = i5;
        return j3;
    }

    public short l() {
        return u.a(i());
    }

    public int m() {
        return u.a(j());
    }

    public long n() {
        return u.a(k());
    }

    public long o() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        Object obj2 = null;
        long j2 = -7;
        do {
            p pVar = this.a;
            byte[] bArr = pVar.a;
            int i2 = pVar.b;
            int i3 = pVar.c;
            while (i2 < i3) {
                int i4 = bArr[i2];
                if (i4 >= (byte) 48 && i4 <= (byte) 57) {
                    int i5 = 48 - i4;
                    if (j < -922337203685477580L || (j == -922337203685477580L && ((long) i5) < j2)) {
                        c b = new c().i(j).b(i4);
                        if (obj == null) {
                            b.h();
                        }
                        throw new NumberFormatException("Number too large: " + b.r());
                    }
                    j = (j * 10) + ((long) i5);
                } else if (i4 != 45 || i != 0) {
                    if (i != 0) {
                        obj2 = 1;
                        if (i2 != i3) {
                            this.a = pVar.a();
                            q.a(pVar);
                        } else {
                            pVar.b = i2;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i4));
                    }
                } else {
                    obj = 1;
                    j2--;
                }
                i2++;
                i++;
            }
            if (i2 != i3) {
                pVar.b = i2;
            } else {
                this.a = pVar.a();
                q.a(pVar);
            }
            if (obj2 == null) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i;
        if (obj != null) {
            return j;
        }
        return -j;
    }

    public long p() {
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        long j = 0;
        int i = 0;
        Object obj = null;
        do {
            p pVar = this.a;
            byte[] bArr = pVar.a;
            int i2 = pVar.b;
            int i3 = pVar.c;
            int i4 = i2;
            while (i4 < i3) {
                byte b = bArr[i4];
                if (b >= (byte) 48 && b <= ReplyCode.reply0x39) {
                    i2 = b - 48;
                } else if (b >= (byte) 97 && b <= (byte) 102) {
                    i2 = (b - 97) + 10;
                } else if (b < (byte) 65 || b > (byte) 70) {
                    if (i != 0) {
                        obj = 1;
                        if (i4 != i3) {
                            this.a = pVar.a();
                            q.a(pVar);
                        } else {
                            pVar.b = i4;
                        }
                        if (obj == null) {
                            break;
                        }
                    } else {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                } else {
                    i2 = (b - 65) + 10;
                }
                if ((-1152921504606846976L & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().j(j).b((int) b).r());
                }
                i++;
                i4++;
                j = ((long) i2) | (j << 4);
            }
            if (i4 != i3) {
                pVar.b = i4;
            } else {
                this.a = pVar.a();
                q.a(pVar);
            }
            if (obj == null) {
                break;
            }
        } while (this.a != null);
        this.b -= (long) i;
        return j;
    }

    public f q() {
        return new f(t());
    }

    public f d(long j) throws EOFException {
        return new f(g(j));
    }

    public String r() {
        try {
            return a(this.b, u.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String e(long j) throws EOFException {
        return a(j, u.a);
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            p pVar = this.a;
            if (((long) pVar.b) + j > ((long) pVar.c)) {
                return new String(g(j), charset);
            }
            String str = new String(pVar.a, pVar.b, (int) j, charset);
            pVar.b = (int) (((long) pVar.b) + j);
            this.b -= j;
            if (pVar.b != pVar.c) {
                return str;
            }
            this.a = pVar.a();
            q.a(pVar);
            return str;
        }
    }

    public String s() throws EOFException {
        long a = a((byte) 10);
        if (a != -1) {
            return f(a);
        }
        c cVar = new c();
        a(cVar, 0, Math.min(32, this.b));
        throw new EOFException("\\n not found: size=" + a() + " content=" + cVar.q().hex() + "...");
    }

    String f(long j) throws EOFException {
        if (j <= 0 || c(j - 1) != ReplyCode.reply0xd) {
            String e = e(j);
            h(1);
            return e;
        }
        e = e(j - 1);
        h(2);
        return e;
    }

    public byte[] t() {
        try {
            return g(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] g(long j) throws EOFException {
        u.a(this.b, 0, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[((int) j)];
        a(bArr);
        return bArr;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a = a(bArr, i, bArr.length - i);
            if (a == -1) {
                throw new EOFException();
            }
            i += a;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a((long) bArr.length, (long) i, (long) i2);
        p pVar = this.a;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(i2, pVar.c - pVar.b);
        System.arraycopy(pVar.a, pVar.b, bArr, i, min);
        pVar.b += min;
        this.b -= (long) min;
        if (pVar.b != pVar.c) {
            return min;
        }
        this.a = pVar.a();
        q.a(pVar);
        return min;
    }

    public void u() {
        try {
            h(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, (long) (this.a.c - this.a.b));
            this.b -= (long) min;
            j -= (long) min;
            p pVar = this.a;
            pVar.b = min + pVar.b;
            if (this.a.b == this.a.c) {
                p pVar2 = this.a;
                this.a = pVar2.a();
                q.a(pVar2);
            }
        }
    }

    public c a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        fVar.write(this);
        return this;
    }

    public c a(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else {
            while (i < i2) {
                int i3;
                char charAt = str.charAt(i);
                if (charAt < '') {
                    int i4;
                    p e = e(1);
                    byte[] bArr = e.a;
                    int i5 = e.c - i;
                    int min = Math.min(i2, 2048 - i5);
                    i3 = i + 1;
                    bArr[i5 + i] = (byte) charAt;
                    while (i3 < min) {
                        char charAt2 = str.charAt(i3);
                        if (charAt2 >= '') {
                            break;
                        }
                        i4 = i3 + 1;
                        bArr[i3 + i5] = (byte) charAt2;
                        i3 = i4;
                    }
                    i4 = (i3 + i5) - e.c;
                    e.c += i4;
                    this.b += (long) i4;
                } else if (charAt < 'ࠀ') {
                    b((charAt >> 6) | 192);
                    b((charAt & 63) | 128);
                    i3 = i + 1;
                } else if (charAt < '?' || charAt > '?') {
                    b((charAt >> 12) | ErrorCode.EXCEED_INCR_UPDATE);
                    b(((charAt >> 6) & 63) | 128);
                    b((charAt & 63) | 128);
                    i3 = i + 1;
                } else {
                    i3 = i + 1 < i2 ? str.charAt(i + 1) : 0;
                    if (charAt > '?' || i3 < 56320 || i3 > 57343) {
                        b(63);
                        i++;
                    } else {
                        i3 = ((i3 & -56321) | ((charAt & -55297) << 10)) + 65536;
                        b((i3 >> 18) | 240);
                        b(((i3 >> 12) & 63) | 128);
                        b(((i3 >> 6) & 63) | 128);
                        b((i3 & 63) | 128);
                        i3 = i + 2;
                    }
                }
                i = i3;
            }
            return this;
        }
    }

    public c a(int i) {
        if (i < 128) {
            b(i);
        } else if (i < 2048) {
            b((i >> 6) | 192);
            b((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                b((i >> 12) | ErrorCode.EXCEED_INCR_UPDATE);
                b(((i >> 6) & 63) | 128);
                b((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            b((i >> 18) | 240);
            b(((i >> 12) & 63) | 128);
            b(((i >> 6) & 63) | 128);
            b((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(u.a)) {
            return a(str);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return b(bytes, 0, bytes.length);
        }
    }

    public c b(byte[] bArr) {
        if (bArr != null) {
            return b(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public c b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        u.a((long) bArr.length, (long) i, (long) i2);
        int i3 = i + i2;
        while (i < i3) {
            p e = e(1);
            int min = Math.min(i3 - i, 2048 - e.c);
            System.arraycopy(bArr, i, e.a, e.c, min);
            i += min;
            e.c = min + e.c;
        }
        this.b += (long) i2;
        return this;
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = sVar.read(this, 2048);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public c b(int i) {
        p e = e(1);
        byte[] bArr = e.a;
        int i2 = e.c;
        e.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    public c c(int i) {
        p e = e(2);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 2;
        return this;
    }

    public c d(int i) {
        p e = e(4);
        byte[] bArr = e.a;
        int i2 = e.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i & 255);
        e.c = i2;
        this.b += 4;
        return this;
    }

    public c i(long j) {
        if (j == 0) {
            return b(48);
        }
        long j2;
        Object obj;
        if (j < 0) {
            j2 = -j;
            if (j2 < 0) {
                return a("-9223372036854775808");
            }
            obj = 1;
        } else {
            obj = null;
            j2 = j;
        }
        int i = j2 < 100000000 ? j2 < 10000 ? j2 < 100 ? j2 < 10 ? 1 : 2 : j2 < 1000 ? 3 : 4 : j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8 : j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        if (obj != null) {
            i++;
        }
        p e = e(i);
        byte[] bArr = e.a;
        int i2 = e.c + i;
        while (j2 != 0) {
            i2--;
            bArr[i2] = c[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (obj != null) {
            bArr[i2 - 1] = (byte) 45;
        }
        e.c += i;
        this.b = ((long) i) + this.b;
        return this;
    }

    public c j(long j) {
        if (j == 0) {
            return b(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        p e = e(numberOfTrailingZeros);
        byte[] bArr = e.a;
        int i = e.c;
        for (int i2 = (e.c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        e.c += numberOfTrailingZeros;
        this.b = ((long) numberOfTrailingZeros) + this.b;
        return this;
    }

    p e(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        } else if (this.a == null) {
            this.a = q.a();
            p pVar = this.a;
            p pVar2 = this.a;
            r0 = this.a;
            pVar2.g = r0;
            pVar.f = r0;
            return r0;
        } else {
            r0 = this.a.g;
            if (r0.c + i > 2048 || !r0.e) {
                return r0.a(q.a());
            }
            return r0;
        }
    }

    public void write(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            u.a(cVar.b, 0, j);
            while (j > 0) {
                p pVar;
                if (j < ((long) (cVar.a.c - cVar.a.b))) {
                    pVar = this.a != null ? this.a.g : null;
                    if (pVar != null && pVar.e) {
                        if ((((long) pVar.c) + j) - ((long) (pVar.d ? 0 : pVar.b)) <= 2048) {
                            cVar.a.a(pVar, (int) j);
                            cVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    cVar.a = cVar.a.a((int) j);
                }
                p pVar2 = cVar.a;
                long j2 = (long) (pVar2.c - pVar2.b);
                cVar.a = pVar2.a();
                if (this.a == null) {
                    this.a = pVar2;
                    pVar2 = this.a;
                    pVar = this.a;
                    p pVar3 = this.a;
                    pVar.g = pVar3;
                    pVar2.f = pVar3;
                } else {
                    this.a.g.a(pVar2).b();
                }
                cVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            cVar.write(this, j);
            return j;
        }
    }

    public long a(byte b) {
        return a(b, 0);
    }

    public long a(byte b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        p pVar = this.a;
        if (pVar == null) {
            return -1;
        }
        p pVar2 = pVar;
        long j2 = 0;
        do {
            int i = pVar2.c - pVar2.b;
            if (j >= ((long) i)) {
                j -= (long) i;
            } else {
                byte[] bArr = pVar2.a;
                int i2 = pVar2.c;
                for (int i3 = (int) (((long) pVar2.b) + j); i3 < i2; i3++) {
                    if (bArr[i3] == b) {
                        return (j2 + ((long) i3)) - ((long) pVar2.b);
                    }
                }
                j = 0;
            }
            j2 += (long) i;
            pVar2 = pVar2.f;
        } while (pVar2 != this.a);
        return -1;
    }

    public void flush() {
    }

    public void close() {
    }

    public t timeout() {
        return t.NONE;
    }

    public boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b != cVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        p pVar = this.a;
        p pVar2 = cVar.a;
        int i = pVar.b;
        int i2 = pVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(pVar.c - i, pVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = pVar.a[i];
                i = i2 + 1;
                if (b != pVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == pVar.c) {
                pVar = pVar.f;
                i = pVar.b;
            }
            if (i2 == pVar2.c) {
                pVar2 = pVar2.f;
                i2 = pVar2.b;
            }
            j += min;
        }
        return true;
    }

    public int hashCode() {
        p pVar = this.a;
        if (pVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = pVar.b;
            while (i2 < pVar.c) {
                int i3 = pVar.a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            pVar = pVar.f;
        } while (pVar != this.a);
        return i;
    }

    public String toString() {
        if (this.b == 0) {
            return "Buffer[size=0]";
        }
        if (this.b <= 16) {
            f q = v().q();
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.b), q.hex()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.a.a, this.a.b, this.a.c - this.a.b);
            for (p pVar = this.a.f; pVar != this.a; pVar = pVar.f) {
                instance.update(pVar.a, pVar.b, pVar.c - pVar.b);
            }
            return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.b), f.of(instance.digest()).hex()});
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public c v() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        cVar.a = new p(this.a);
        p pVar = cVar.a;
        p pVar2 = cVar.a;
        p pVar3 = cVar.a;
        pVar2.g = pVar3;
        pVar.f = pVar3;
        for (pVar = this.a.f; pVar != this.a; pVar = pVar.f) {
            cVar.a.g.a(new p(pVar));
        }
        cVar.b = this.b;
        return cVar;
    }
}
