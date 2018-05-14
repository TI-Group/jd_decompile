package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bn extends Thread {
    bn() {
    }

    public void run() {
        if (WebView.j == null) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            return;
        }
        q a = q.a(true);
        if (q.a) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
        }
        aj a2 = aj.a(WebView.j);
        int c = a2.c();
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c);
        if (c == 2) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            a.a(String.valueOf(a2.b()));
            a.b(true);
            return;
        }
        int b = a2.b("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + b);
        if (b == 1) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            a.a(String.valueOf(a2.c("copy_core_ver")));
            a.b(true);
        } else if (!bo.b().c()) {
            if (c == 3 || b == 3) {
                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                a.a(String.valueOf(q.d()));
                a.b(true);
            }
        }
    }
}
