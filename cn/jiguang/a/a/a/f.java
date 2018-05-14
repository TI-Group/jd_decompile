package cn.jiguang.a.a.a;

final class f implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ g d;
    final /* synthetic */ d e;

    f(d dVar, byte[] bArr, int i, int i2, g gVar) {
        this.e = dVar;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = gVar;
    }

    public final void run() {
        this.e.b(this.a, this.b, this.c);
        if (this.d != null) {
            this.d.a();
        }
        this.e.a.quit();
    }
}
