package com.kepler.jd.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.kepler.sdk.h;
import com.kepler.sdk.p;

/* compiled from: TbsSdkJava */
public class AuthSuccessActivity extends Activity {
    public static final int AUTH_CANCEL = 2;
    public static final int AUTH_ERR = -1;
    public static final int AUTH_FAIL = 1;
    public static int errTryTime = 0;
    protected Activity a;
    protected boolean b;

    public static boolean isHasMoreTryTimes() {
        return errTryTime < 2;
    }

    public AuthSuccessActivity(Activity activity) {
        this.a = activity;
        if (activity != null) {
            this.b = true;
        }
    }

    protected void onCreate(Bundle bundle) {
        if (!this.b) {
            this.a = this;
            super.onCreate(bundle);
        }
        if (h.a().c()) {
            Toast.makeText(this, "授权异常", 0).show();
            this.a.finish();
            return;
        }
        Bundle extras = this.a.getIntent().getExtras();
        String string = extras.getString("code");
        int i = extras.getInt("oautherror");
        extras.getString("msgcode");
        this.a.finish();
        p.b("suwg", "jd授权res:" + i);
        if (i == -1) {
            errTryTime = 2;
            h.a().a(this.a, new String[0]);
        } else if (i == 1) {
            errTryTime++;
            KeplerApiManager.getWebViewService();
            if (KeplerApiManager.getC() == null) {
                h.a().a(this.a, new String[0]);
            } else if (errTryTime >= 2) {
                h.a().a(this.a, new String[0]);
            }
        } else if (i == 2) {
            h.a().a(2);
        } else if (TextUtils.isEmpty(string)) {
            errTryTime = 2;
            h.a().a(this.a, new String[0]);
        } else {
            errTryTime = 0;
            p.a("suwg", "获取到code:" + string);
            h.a().a(string);
            h.a().a(null);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onResume() {
        super.onResume();
    }
}
