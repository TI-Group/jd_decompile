package android.support.v4.text;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: TbsSdkJava */
public final class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* compiled from: TbsSdkJava */
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    /* compiled from: TbsSdkJava */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return null;
        }
    }

    /* compiled from: TbsSdkJava */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    /* compiled from: TbsSdkJava */
    static class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            IMPL = new ICUCompatImplLollipop();
        } else if (i >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return IMPL.maximizeAndGetScript(locale);
    }

    private ICUCompat() {
    }
}
