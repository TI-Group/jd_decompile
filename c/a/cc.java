package c.a;

/* compiled from: TbsSdkJava */
public abstract class cc {
    public abstract int a(byte[] bArr, int i, int i2) throws cd;

    public abstract void b(byte[] bArr, int i, int i2) throws cd;

    public int d(byte[] bArr, int i, int i2) throws cd {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new cd("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }

    public void b(byte[] bArr) throws cd {
        b(bArr, 0, bArr.length);
    }

    public byte[] b() {
        return null;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return -1;
    }

    public void a(int i) {
    }
}
