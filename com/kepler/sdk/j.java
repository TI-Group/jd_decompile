package com.kepler.sdk;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: TbsSdkJava */
public class j extends Activity {
    public static final String EXTRA_Auxiliary = "additive";
    public static final String EXTRA_PARAMS = "params";
    public static final String EXTRA_isGetTokenAcFinish = "param_isGetTokenAcFinish";
    public static final int TARGET_AUTH = 1;
    public static final int TARGET_SHOPPING = 2;
    protected Activity a;
    protected boolean b;

    public j(Activity activity) {
        this.a = activity;
        if (activity != null) {
            this.b = true;
        }
    }

    public void onCreate(Bundle bundle) {
        if (!this.b) {
            this.a = this;
            super.onCreate(bundle);
        }
    }
}
