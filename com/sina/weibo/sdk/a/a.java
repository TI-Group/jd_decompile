package com.sina.weibo.sdk.a;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.d.j;
import com.tencent.connect.common.Constants;

/* compiled from: TbsSdkJava */
public class a {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";

    public a(Context context, String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = context.getPackageName();
        this.e = j.a(context, this.d);
    }

    public String a() {
        return this.b;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appKey", this.a);
        bundle.putString("redirectUri", this.b);
        bundle.putString(Constants.PARAM_SCOPE, this.c);
        bundle.putString("packagename", this.d);
        bundle.putString("key_hash", this.e);
        return bundle;
    }

    public static a a(Context context, Bundle bundle) {
        return new a(context, bundle.getString("appKey"), bundle.getString("redirectUri"), bundle.getString(Constants.PARAM_SCOPE));
    }
}
