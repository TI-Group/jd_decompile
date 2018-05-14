package com.jingdong.crash.inner;

import android.content.Context;
import android.content.Intent;

class ac implements b {
    ac() {
    }

    public void a(Context context, v vVar) {
        try {
            if (ah.b) {
                ah.a("DefaultOnCatchListener", "onCatch..........");
            }
            Intent intent = new Intent();
            intent.putExtra("crash", vVar);
            intent.setClass(context, CrashService.class);
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
            System.exit(0);
        }
    }
}
