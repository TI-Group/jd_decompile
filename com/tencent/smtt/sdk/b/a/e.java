package com.tencent.smtt.sdk.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;
import java.util.Map;

public class e {
    private Context a;
    private ResolveInfo b;
    private Drawable c;
    private String d;
    private String e;
    private int f = 0;

    e(Context context, ResolveInfo resolveInfo) {
        this.a = context.getApplicationContext();
        this.b = resolveInfo;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    e(Context context, Drawable drawable, String str, String str2) {
        this.a = context.getApplicationContext();
        this.b = null;
        this.c = drawable;
        this.d = str;
        this.e = str2;
    }

    public static Drawable a(Context context, String str) {
        Drawable drawable = null;
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                drawable = i.a("application_icon");
            } catch (Throwable th) {
                Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(th));
            }
        } else {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 1);
                if (packageInfo != null) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
                    TypedValue typedValue = new TypedValue();
                    resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
                    try {
                        drawable = Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                Log.e("sdk", "e = " + e2);
            }
        }
        return drawable;
    }

    public Drawable a(Map<String, Drawable> map) {
        Drawable a = a(this.a, c());
        return a == null ? (map == null || this.b == null) ? this.c : this.b.loadIcon(this.a.getPackageManager()) : a;
    }

    public String a() {
        return this.b != null ? this.b.loadLabel(this.a.getPackageManager()).toString() : this.d;
    }

    public void a(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public ResolveInfo b() {
        return this.b;
    }

    public String c() {
        return this.b != null ? this.b.activityInfo.packageName : this.e == null ? "" : this.e;
    }
}
