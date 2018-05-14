package c.a;

import android.content.Context;
import com.b.a.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class cp {
    private final int a = 128;
    private final int b = 256;
    private cn c;
    private Context d;
    private cm e;

    public cp(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null, can't track event");
        }
        this.d = context.getApplicationContext();
        this.c = new cn(this.d);
        this.c.a(!a.j);
        this.e = cm.a(this.d);
    }

    public void a(String str, String str2, long j, int i) {
        if (a(str) && b(str2)) {
            Map hashMap = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put(str, str2);
            this.e.a(new g(str, hashMap, j, i));
        }
    }

    private boolean a(String str) {
        if (str != null) {
            int length = str.trim().getBytes().length;
            if (length > 0 && length <= 128) {
                return true;
            }
        }
        as.d("Event id is empty or too long in tracking Event");
        return false;
    }

    private boolean b(String str) {
        if (str == null || str.trim().getBytes().length <= 256) {
            return true;
        }
        as.d("Event label or value is empty or too long in tracking Event");
        return false;
    }
}
