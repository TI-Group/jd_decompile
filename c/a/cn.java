package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class cn {
    private final String a = "umeng_event_snapshot";
    private boolean b = false;
    private SharedPreferences c;
    private Map<String, ArrayList<f>> d = new HashMap();

    public cn(Context context) {
        this.c = cx.a(context, "umeng_event_snapshot");
    }

    public void a(boolean z) {
        this.b = z;
    }
}
