package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.d.e;
import com.sina.weibo.sdk.d.j;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;

/* compiled from: TbsSdkJava */
public class l extends e {
    private b e;
    private String f;
    private a g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(String str);
    }

    public l(Context context) {
        super(context);
        this.c = c.WIDGET;
    }

    protected void a(Bundle bundle) {
        this.k = bundle.getString(SocialConstants.PARAM_SOURCE);
        this.i = bundle.getString("packagename");
        this.l = bundle.getString("key_hash");
        this.j = bundle.getString(Constants.PARAM_ACCESS_TOKEN);
        this.m = bundle.getString("fuid");
        this.o = bundle.getString("q");
        this.n = bundle.getString("content");
        this.p = bundle.getString("category");
        this.f = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.f)) {
            this.e = i.a(this.a).a(this.f);
        }
        this.h = bundle.getString("key_widget_callback");
        if (!TextUtils.isEmpty(this.h)) {
            this.g = i.a(this.a).c(this.h);
        }
        this.b = i(this.b);
    }

    public void b(Bundle bundle) {
        this.i = this.a.getPackageName();
        if (!TextUtils.isEmpty(this.i)) {
            this.l = e.a(j.a(this.a, this.i));
        }
        bundle.putString(Constants.PARAM_ACCESS_TOKEN, this.j);
        bundle.putString(SocialConstants.PARAM_SOURCE, this.k);
        bundle.putString("packagename", this.i);
        bundle.putString("key_hash", this.l);
        bundle.putString("fuid", this.m);
        bundle.putString("q", this.o);
        bundle.putString("content", this.n);
        bundle.putString("category", this.p);
        i a = i.a(this.a);
        if (this.e != null) {
            this.f = a.a();
            a.a(this.f, this.e);
            bundle.putString("key_listener", this.f);
        }
        if (this.g != null) {
            this.h = a.a();
            a.a(this.h, this.g);
            bundle.putString("key_widget_callback", this.h);
        }
    }

    private String i(String str) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("version", "0031205000");
        if (!TextUtils.isEmpty(this.k)) {
            buildUpon.appendQueryParameter(SocialConstants.PARAM_SOURCE, this.k);
        }
        if (!TextUtils.isEmpty(this.j)) {
            buildUpon.appendQueryParameter(Constants.PARAM_ACCESS_TOKEN, this.j);
        }
        Object b = j.b(this.a, this.k);
        if (!TextUtils.isEmpty(b)) {
            buildUpon.appendQueryParameter(DeviceInfo.TAG_ANDROID_ID, b);
        }
        if (!TextUtils.isEmpty(this.i)) {
            buildUpon.appendQueryParameter("packagename", this.i);
        }
        if (!TextUtils.isEmpty(this.l)) {
            buildUpon.appendQueryParameter("key_hash", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            buildUpon.appendQueryParameter("fuid", this.m);
        }
        if (!TextUtils.isEmpty(this.o)) {
            buildUpon.appendQueryParameter("q", this.o);
        }
        if (!TextUtils.isEmpty(this.n)) {
            buildUpon.appendQueryParameter("content", this.n);
        }
        if (!TextUtils.isEmpty(this.p)) {
            buildUpon.appendQueryParameter("category", this.p);
        }
        return buildUpon.build().toString();
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.n = str;
    }

    public void e(String str) {
        this.o = str;
    }

    public void f(String str) {
        this.p = str;
    }

    public void g(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.k = str;
    }

    public b a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public a c() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(Activity activity, int i) {
        if (i == 3) {
            WeiboSdkBrowser.a(activity, this.f, this.h);
        }
    }
}
