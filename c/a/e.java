package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
public class e {
    private final Map<String, Long> a = new HashMap();
    private final ArrayList<d> b = new ArrayList();

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Long l;
            synchronized (this.a) {
                l = (Long) this.a.remove(str);
            }
            if (l == null) {
                as.c("please call 'onPageStart(%s)' before onPageEnd", str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (this.b) {
                this.b.add(new d(str, currentTimeMillis));
            }
        }
    }

    public void a() {
        String str = null;
        long j = 0;
        synchronized (this.a) {
            for (Entry entry : this.a.entrySet()) {
                String str2;
                long j2;
                if (((Long) entry.getValue()).longValue() > j) {
                    long longValue = ((Long) entry.getValue()).longValue();
                    str2 = (String) entry.getKey();
                    j2 = longValue;
                } else {
                    j2 = j;
                    str2 = str;
                }
                str = str2;
                j = j2;
            }
        }
        if (str != null) {
            a(str);
        }
    }

    public void a(Context context) {
        SharedPreferences a = cx.a(context);
        Editor edit = a.edit();
        if (this.b.size() > 0) {
            Object string = a.getString("activities", "");
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(string)) {
                stringBuilder.append(string);
                stringBuilder.append(";");
            }
            synchronized (this.b) {
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    stringBuilder.append(String.format("[\"%s\",%d]", new Object[]{dVar.a, Long.valueOf(dVar.b)}));
                    stringBuilder.append(";");
                }
                this.b.clear();
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            edit.remove("activities");
            edit.putString("activities", stringBuilder.toString());
        }
        edit.commit();
    }
}
