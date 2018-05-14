package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: TbsSdkJava */
public abstract class e {
    protected Context a;
    protected String b;
    protected c c;
    protected String d;

    public abstract void a(Activity activity, int i);

    protected abstract void a(Bundle bundle);

    protected abstract void b(Bundle bundle);

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    public void c(Bundle bundle) {
        this.b = bundle.getString("key_url");
        this.c = (c) bundle.getSerializable("key_launcher");
        this.d = bundle.getString("key_specify_title");
        a(bundle);
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.b)) {
            bundle.putString("key_url", this.b);
        }
        if (this.c != null) {
            bundle.putSerializable("key_launcher", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("key_specify_title", this.d);
        }
        b(bundle);
        return bundle;
    }

    public void a(String str) {
        this.b = str;
    }

    public String e() {
        return this.b;
    }

    public c f() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String g() {
        return this.d;
    }
}
