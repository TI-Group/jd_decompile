package com.kepler.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kepler.jd.login.AuthSuccessActivity;
import com.kepler.jd.login.KeplerApiManager;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: TbsSdkJava */
public class f {
    private boolean a;

    public boolean a() {
        return this.a;
    }

    public void a(boolean z) {
        this.a = z;
    }

    protected void a(Context context, g gVar) {
        KeplerApiManager.getWebViewService();
        if (KeplerApiManager.getC() == null || !AuthSuccessActivity.isHasMoreTryTimes()) {
            p.a("suwg", "启动外部调用");
            if (ai.e(context) >= 20450) {
                try {
                    context.getApplicationContext().startActivity(b(context));
                    return;
                } catch (Exception e) {
                    p.b("suwg", "open jd app failed :" + e.getMessage());
                    gVar.openH5authPage();
                    return;
                }
            }
            gVar.openH5authPage();
            return;
        }
        a(true);
        p.a("suwg", "open auth activity in jd mode");
        try {
            context.startActivity(a(context));
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("suwg", "open auth activity app mode");
            gVar.authFailed(KeplerApiManager.KeplerApiManagerLoginErr_AuthErr_ActivityOpen);
        }
    }

    protected void b(Context context, g gVar) {
        a(context, gVar);
    }

    private Intent a(Context context) {
        Intent intent = new Intent(context, KeplerApiManager.getC());
        Bundle c = c(context);
        c.putBoolean("ifNoLoginToLogin", true);
        intent.putExtras(c);
        return intent;
    }

    private Intent b(Context context) {
        Intent intent = new Intent();
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        ComponentName componentName = new ComponentName("com.jingdong.app.mall", "com.jingdong.app.mall.open.InterfaceActivity");
        Bundle c = c(context);
        c.putBoolean("ifNoLoginToLogin", true);
        intent.putExtras(c);
        intent.setComponent(componentName);
        return intent;
    }

    private Bundle c(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("appId", h.a().e());
        bundle.putString("appKey", h.a().f());
        bundle.putString("redirect_url", k.b().a());
        bundle.putString("pkgName", context.getPackageName());
        bundle.putString("actName", "com.kepler.jd.login.AuthSuccessActivity");
        bundle.putString("sourceType", "otherapp");
        bundle.putString("sourceValue", context.getPackageName());
        bundle.putInt("moduleId", ErrorCode.INCR_UPDATE_ERROR);
        return bundle;
    }
}
