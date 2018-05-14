package c.a;

import android.os.Build;
import android.os.Build.VERSION;

/* compiled from: TbsSdkJava */
public class ci extends a {
    public ci() {
        super("serial");
    }

    public String f() {
        if (VERSION.SDK_INT >= 9) {
            return Build.SERIAL;
        }
        return null;
    }
}
