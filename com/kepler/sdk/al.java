package com.kepler.sdk;

import android.content.Context;
import com.kepler.jd.login.KeplerApiManager;

/* compiled from: TbsSdkJava */
public class al {
    public static Context a() {
        return KeplerApiManager.getWebViewService().getApplicatonContext();
    }
}
