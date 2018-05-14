package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.b.a.a;

/* compiled from: TbsSdkJava */
public class b {
    private static String c = null;
    private final String a = "a_start_time";
    private final String b = "a_end_time";

    public void a(Context context) {
        SharedPreferences a = cx.a(context);
        if (a != null) {
            if (a.getLong("a_start_time", 0) == 0 && a.h) {
                as.d("onPause called before onResume");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = a.edit();
            edit.putLong("a_start_time", 0);
            edit.putLong("a_end_time", currentTimeMillis);
            edit.putLong("session_end_time", currentTimeMillis);
            edit.commit();
        }
    }

    public static String b(Context context) {
        if (c == null) {
            c = cx.a(context).getString("session_id", null);
        }
        return c;
    }
}
