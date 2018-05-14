package cn.jiguang.e;

import android.content.Context;
import android.widget.Toast;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    b(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void run() {
        Toast.makeText(this.a, this.b, 0).show();
    }
}
