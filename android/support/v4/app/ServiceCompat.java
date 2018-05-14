package android.support.v4.app;

import android.app.Service;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.os.BuildCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: TbsSdkJava */
public final class ServiceCompat {
    static final ServiceCompatImpl IMPL;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    /* compiled from: TbsSdkJava */
    interface ServiceCompatImpl {
        void stopForeground(Service service, int i);
    }

    /* compiled from: TbsSdkJava */
    static class Api24ServiceCompatImpl implements ServiceCompatImpl {
        Api24ServiceCompatImpl() {
        }

        public void stopForeground(Service service, int i) {
            ServiceCompatApi24.stopForeground(service, i);
        }
    }

    /* compiled from: TbsSdkJava */
    static class BaseServiceCompatImpl implements ServiceCompatImpl {
        BaseServiceCompatImpl() {
        }

        public void stopForeground(Service service, int i) {
            service.stopForeground((i & 1) != 0);
        }
    }

    @RestrictTo({Scope.GROUP_ID})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: TbsSdkJava */
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    static {
        if (BuildCompat.isAtLeastN()) {
            IMPL = new Api24ServiceCompatImpl();
        } else {
            IMPL = new BaseServiceCompatImpl();
        }
    }

    public static void stopForeground(Service service, int i) {
        IMPL.stopForeground(service, i);
    }
}
