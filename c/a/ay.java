package c.a;

import c.a.bk.a;

/* compiled from: TbsSdkJava */
public class ay {
    private final bo a;
    private final cb b;

    public ay() {
        this(new a());
    }

    public ay(br brVar) {
        this.b = new cb();
        this.a = brVar.a(this.b);
    }

    public void a(av avVar, byte[] bArr) throws az {
        try {
            this.b.a(bArr);
            avVar.a(this.a);
        } finally {
            this.b.a();
            this.a.x();
        }
    }
}
