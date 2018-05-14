package com.jingdong.crash.inner;

import android.content.Context;

final class o extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Object b;
    final /* synthetic */ m c;

    o(Context context, Object obj, m mVar) {
        this.a = context;
        this.b = obj;
        this.c = mVar;
    }

    public void run() {
        String b;
        if (ah.b) {
            ah.a(n.a, "run() -->> ");
        }
        if (ah.b) {
            ah.a(n.a, "run() setWifiEnabled -->> true");
        }
        int i = 0;
        while (true) {
            b = n.b(this.a);
            if (b == null && i < 5) {
                i++;
                synchronized (this.b) {
                    try {
                        if (ah.b) {
                            ah.a(n.a, "getMacAddress() wait start 500 -->> ");
                        }
                        this.b.wait(500);
                        if (ah.b) {
                            ah.a(n.a, "getMacAddress() wait end 500 -->> ");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (ah.b) {
            ah.a(n.a, "run() setWifiEnabled -->> false");
        }
        if (ah.b) {
            ah.a(n.a, "getMacAddress() macAddress with open -->> " + b);
        }
        this.c.a(b);
    }
}
