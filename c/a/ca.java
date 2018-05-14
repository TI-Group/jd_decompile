package c.a;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public class ca extends cc {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected ca() {
    }

    public ca(OutputStream outputStream) {
        this.b = outputStream;
    }

    public int a(byte[] bArr, int i, int i2) throws cd {
        if (this.a == null) {
            throw new cd(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new cd(4);
        } catch (Throwable e) {
            throw new cd(0, e);
        }
    }

    public void b(byte[] bArr, int i, int i2) throws cd {
        if (this.b == null) {
            throw new cd(1, "Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new cd(0, e);
        }
    }
}
