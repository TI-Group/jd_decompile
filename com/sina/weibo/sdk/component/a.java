package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.b;

/* compiled from: TbsSdkJava */
public class a extends e {
    private com.sina.weibo.sdk.a.a e;
    private b f;
    private String g;

    public a(Context context) {
        super(context);
        this.c = c.AUTH;
    }

    protected void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("key_authinfo");
        if (bundle2 != null) {
            this.e = com.sina.weibo.sdk.a.a.a(this.a, bundle2);
        }
        this.g = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.g)) {
            this.f = i.a(this.a).a(this.g);
        }
    }

    public void b(Bundle bundle) {
        if (this.e != null) {
            bundle.putBundle("key_authinfo", this.e.b());
        }
        if (this.f != null) {
            i a = i.a(this.a);
            this.g = a.a();
            a.a(this.g, this.f);
            bundle.putString("key_listener", this.g);
        }
    }

    public void a(Activity activity, int i) {
        if (i == 3) {
            if (this.f != null) {
                this.f.a();
            }
            WeiboSdkBrowser.a(activity, this.g, null);
        }
    }

    public com.sina.weibo.sdk.a.a a() {
        return this.e;
    }

    public b b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }
}
