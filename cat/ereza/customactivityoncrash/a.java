package cat.ereza.customactivityoncrash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Process;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
/* compiled from: TbsSdkJava */
public final class a {
    private static WeakReference<Activity> a = new WeakReference(null);
    private static boolean b = false;
    private static boolean c = true;
    private static boolean d = true;
    private static boolean e = true;
    private static int f = R.drawable.customactivityoncrash_error_image;
    private static Class<? extends Activity> g = null;
    private static Class<? extends Activity> h = null;
    private static a i = null;

    /* compiled from: TbsSdkJava */
    public interface a extends Serializable {
        void onCloseAppFromErrorActivity();

        void onLaunchErrorActivity();

        void onRestartAppFromErrorActivity();
    }

    public static boolean a(Intent intent) {
        return intent.getBooleanExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", true);
    }

    public static int b(Intent intent) {
        return intent.getIntExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", R.drawable.customactivityoncrash_error_image);
    }

    public static String c(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    public static String a(Context context, Intent intent) {
        Date date = new Date();
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return ((((("" + "Build version: " + a(context) + " \n") + "Build date: " + a(context, simpleDateFormat) + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + a() + " \n \n") + "Stack trace:  \n") + c(intent);
    }

    public static Class<? extends Activity> d(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS");
        if (serializableExtra == null || !(serializableExtra instanceof Class)) {
            return null;
        }
        return (Class) serializableExtra;
    }

    public static a e(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_EVENT_LISTENER");
        if (serializableExtra == null || !(serializableExtra instanceof a)) {
            return null;
        }
        return (a) serializableExtra;
    }

    public static void a(Activity activity, Intent intent, a aVar) {
        intent.addFlags(268468224);
        if (aVar != null) {
            aVar.onRestartAppFromErrorActivity();
        }
        activity.finish();
        activity.startActivity(intent);
        b();
    }

    public static void a(Activity activity, a aVar) {
        if (aVar != null) {
            aVar.onCloseAppFromErrorActivity();
        }
        activity.finish();
        b();
    }

    public static void setEventListener(a aVar) {
        if (aVar == null || aVar.getClass().getEnclosingClass() == null || Modifier.isStatic(aVar.getClass().getModifiers())) {
            i = aVar;
            return;
        }
        throw new IllegalArgumentException("The event listener cannot be an inner or anonymous class, because it will need to be serialized. Change it to a class of its own, or make it a static inner class.");
    }

    private static String a(Context context, DateFormat dateFormat) {
        try {
            ZipFile zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            String format = dateFormat.format(new Date(zipFile.getEntry("classes.dex").getTime()));
            zipFile.close();
            return format;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private static String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        return !Character.isUpperCase(charAt) ? Character.toUpperCase(charAt) + str.substring(1) : str;
    }

    private static void b() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
