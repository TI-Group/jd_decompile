package c.a;

import com.b.a.a;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: TbsSdkJava */
public class co implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler a;
    private cv b;

    public co() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void a(cv cvVar) {
        this.b = cvVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.a != null && this.a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.a.uncaughtException(thread, th);
        }
    }

    private void a(Throwable th) {
        if (a.k) {
            this.b.a(th);
        } else {
            this.b.a(null);
        }
    }
}
