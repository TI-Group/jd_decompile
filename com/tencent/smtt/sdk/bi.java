package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.smtt.utils.Apn;

class bi extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ WebView b;

    bi(WebView webView, Context context) {
        this.b = webView;
        this.a = context;
    }

    public void run() {
        try {
            QbSdk.e = Apn.getApnType(this.a) == 3;
            QbSdk.f = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.a.getApplicationContext().registerReceiver(WebView.n, intentFilter);
        } catch (Throwable th) {
        }
    }
}
