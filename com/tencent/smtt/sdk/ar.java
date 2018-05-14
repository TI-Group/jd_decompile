package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

class ar extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Context b;
    final /* synthetic */ ao c;

    ar(ao aoVar, Context context, Context context2) {
        this.c = aoVar;
        this.a = context;
        this.b = context2;
    }

    public void run() {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File k = this.c.k(this.a);
            File k2 = this.c.k(this.b);
            k.a(k, k2, new as(this));
            k.a(k, k2, new at(this));
            TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
