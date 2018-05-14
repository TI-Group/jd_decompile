package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.a;

class ba {
    private static ba e = null;
    bc a = null;
    Context b;
    a c;
    IUserStateChangedListener d;

    private ba(Context context) {
        this.b = context.getApplicationContext();
        this.a = new bc(this.b);
    }

    public static synchronized ba a(Context context) {
        ba baVar;
        synchronized (ba.class) {
            if (e == null) {
                e = new ba(context);
            }
            baVar = e;
        }
        return baVar;
    }

    public void a(int i, int i2, Intent intent) {
        if (this.c != null) {
            this.c.a(i, i2, intent);
        }
    }

    void a(Activity activity, int i) {
        this.a.a(activity, i);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public boolean a(String str, Bundle bundle, a aVar) {
        Object obj;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.c = aVar;
            this.d = new bb(this);
            this.c.a(this.d);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        bc bcVar = this.a;
        if (aVar == null) {
            obj = null;
        }
        bcVar.a(bundle, obj);
        return true;
    }
}
