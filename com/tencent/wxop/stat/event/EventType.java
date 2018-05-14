package com.tencent.wxop.stat.event;

import android.support.v4.view.PointerIconCompat;
import com.kepler.jd.login.KeplerApiManager;

public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(PointerIconCompat.TYPE_HAND),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
    
    private int a;

    private EventType(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }
}
