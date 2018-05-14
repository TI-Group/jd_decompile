package c.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: TbsSdkJava */
public class h extends s implements cr {
    public h() {
        a(System.currentTimeMillis());
        a(t.LEGIT);
    }

    public h(String str) {
        this();
        a(str);
    }

    public h(Throwable th) {
        this();
        a(a(th));
    }

    public h a(boolean z) {
        a(z ? t.LEGIT : t.ALIEN);
        return this;
    }

    private String a(Throwable th) {
        String str = null;
        if (th != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                str = stringWriter.toString();
                printWriter.close();
                stringWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public void a(am amVar, String str) {
        if (amVar.s() > 0) {
            for (ab abVar : amVar.u()) {
                if (str.equals(abVar.c())) {
                    break;
                }
            }
        }
        ab abVar2 = null;
        if (abVar2 == null) {
            abVar2 = new ab();
            abVar2.a(str);
            amVar.a(abVar2);
        }
        abVar2.a((s) this);
    }
}
