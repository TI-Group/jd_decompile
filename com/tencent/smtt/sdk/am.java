package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class am extends HandlerThread {
    private static am a;

    public am(String str) {
        super(str);
    }

    public static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (a == null) {
                a = new am("TbsHandlerThread");
                a.start();
            }
            amVar = a;
        }
        return amVar;
    }
}
