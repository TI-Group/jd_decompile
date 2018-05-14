package com.jingdong.crash.inner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import java.io.File;

public class JdLocalCrashReceiver extends BroadcastReceiver {
    private static JdLocalCrashReceiver a;
    private Context b;
    private IntentFilter c = new IntentFilter();

    private JdLocalCrashReceiver() {
    }

    public static JdLocalCrashReceiver a() {
        if (a != null) {
            return a;
        }
        JdLocalCrashReceiver jdLocalCrashReceiver;
        synchronized (JdLocalCrashReceiver.class) {
            a = new JdLocalCrashReceiver();
            jdLocalCrashReceiver = a;
        }
        return jdLocalCrashReceiver;
    }

    public synchronized void a(Context context) {
        try {
            context.registerReceiver(this, this.c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Context context, Intent intent) {
        if (context != null && intent != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            File c = q.c();
            if (c != null && c.exists() && b(context)) {
                q.a(new af(this, context));
            }
        }
    }

    public synchronized void a(String str) {
        if (!this.c.hasAction(str)) {
            this.c.addAction(str);
        }
    }

    public boolean b(Context context) {
        return State.CONNECTED == ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).getState();
    }

    protected void finalize() {
        super.finalize();
        if (this.b != null) {
            this.b.unregisterReceiver(this);
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
