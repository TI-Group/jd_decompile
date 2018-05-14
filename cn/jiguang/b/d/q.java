package cn.jiguang.b.d;

import android.content.Context;
import org.json.JSONArray;

final class q implements Runnable {
    Context a;
    JSONArray b;
    String c;

    public q(Context context, JSONArray jSONArray, String str) {
        this.a = context;
        this.b = jSONArray;
        this.c = str;
    }

    public final void run() {
        o.b(this.a, this.b, this.c);
    }
}
