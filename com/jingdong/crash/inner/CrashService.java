package com.jingdong.crash.inner;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import org.json.JSONObject;

public class CrashService extends Service {
    private JSONObject a;
    private a b;
    private v c;
    private Handler d = new x(this);

    private void a() {
        this.d.post(new aa(this));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (ah.b) {
            ah.a("Crash", "createService");
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        this.b = a.a();
        registerReceiver(this.b, intentFilter);
    }

    public void onDestroy() {
        super.onDestroy();
        if (ah.b) {
            ah.a("Crash", "destroy Service");
        }
        if (this.b != null) {
            unregisterReceiver(this.b);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (ah.b) {
            ah.a("Crash", "startService");
        }
        this.c = (v) intent.getSerializableExtra("crash");
        if (this.c == null) {
            this.c = new v();
            this.c.d.put("feedback", "crash info is null");
        }
        new y(this).start();
        return 2;
    }
}
