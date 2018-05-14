package c.a;

import java.io.Serializable;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class bf implements Serializable {
    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public bf(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.c = null;
        this.d = z;
    }

    public bf(byte b) {
        this(b, false);
    }

    public bf(byte b, String str) {
        this.b = b;
        this.a = true;
        this.c = str;
        this.d = false;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == ReplyCode.reply0xc;
    }

    public boolean d() {
        return this.b == ReplyCode.reply0xf || this.b == ReplyCode.reply0xd || this.b == ReplyCode.reply0xe;
    }

    public boolean e() {
        return this.d;
    }
}
