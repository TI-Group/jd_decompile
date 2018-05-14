package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.l;
import java.util.Timer;
import java.util.TimerTask;

public class d {
    private static volatile d b = null;
    private Timer a = null;
    private Context c = null;

    private d(Context context) {
        this.c = context.getApplicationContext();
        this.a = new Timer(false);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    public void a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = (long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000);
            if (StatConfig.isDebugEnable()) {
                l.b().i("setupPeriodTimer delay:" + sendPeriodMinutes);
            }
            a(new e(this), sendPeriodMinutes);
        }
    }

    public void a(TimerTask timerTask, long j) {
        if (this.a != null) {
            if (StatConfig.isDebugEnable()) {
                l.b().i("setupPeriodTimer schedule delay:" + j);
            }
            this.a.schedule(timerTask, j);
        } else if (StatConfig.isDebugEnable()) {
            l.b().w("setupPeriodTimer schedule timer == null");
        }
    }
}
