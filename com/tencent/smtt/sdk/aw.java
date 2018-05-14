package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;

class aw extends Handler {
    final /* synthetic */ TbsLogReport a;

    aw(TbsLogReport tbsLogReport, Looper looper) {
        this.a = tbsLogReport;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (message.what == 600) {
            if (message.obj instanceof TbsLogInfo) {
                TbsLogInfo tbsLogInfo = (TbsLogInfo) message.obj;
                this.a.a(message.arg1, tbsLogInfo);
            }
        } else if (message.what == 601) {
            this.a.f();
        }
    }
}
