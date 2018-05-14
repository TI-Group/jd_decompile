package c.a;

import c.a.bk.a;
import java.io.ByteArrayOutputStream;

/* compiled from: TbsSdkJava */
public class bb {
    private final ByteArrayOutputStream a;
    private final ca b;
    private bo c;

    public bb() {
        this(new a());
    }

    public bb(br brVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new ca(this.a);
        this.c = brVar.a(this.b);
    }

    public byte[] a(av avVar) throws az {
        this.a.reset();
        avVar.b(this.c);
        return this.a.toByteArray();
    }
}
