package com.jingdong.crash.inner;

import android.os.Process;

class aa implements Runnable {
    final /* synthetic */ CrashService a;

    aa(CrashService crashService) {
        this.a = crashService;
    }

    public void run() {
        this.a.stopSelf();
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
