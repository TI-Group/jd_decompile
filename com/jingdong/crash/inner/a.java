package com.jingdong.crash.inner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class a extends BroadcastReceiver {
    public static String a = null;
    private static a b;

    private a() {
    }

    public static a a() {
        if (b != null) {
            return b;
        }
        a aVar;
        synchronized (a.class) {
            b = new a();
            aVar = b;
        }
        return aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("level", 0);
            a = ((intExtra * 100) / intent.getIntExtra("scale", 100)) + "%";
        }
    }
}
