package com.kepler.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.Log;
import android.view.LayoutInflater;

/* compiled from: TbsSdkJava */
public final class d extends ContextWrapper {
    private String a = null;
    private LayoutInflater b;
    private Resources c;
    private Theme d;
    private Context e;

    public d(Context context, String str) {
        ApplicationInfo applicationInfo = null;
        super(context);
        this.e = context;
        this.b = new e(this);
        this.c = b.a(context, str);
        if (this.c != null) {
            this.d = this.c.newTheme();
            PackageInfo b = b.b(context, str);
            if (b != null) {
                applicationInfo = b.applicationInfo;
            }
            if (b != null && applicationInfo != null) {
                int i = applicationInfo.theme;
                this.a = applicationInfo.packageName;
                Theme theme = getBaseContext().getTheme();
                if (theme != null) {
                    this.d.setTo(theme);
                }
                if (i != 0) {
                    this.d.applyStyle(i, true);
                    return;
                }
                return;
            }
            return;
        }
        Log.i("PluginContextWrapper", "fail to init plugin resources");
    }

    public LayoutInflater a() {
        return this.b;
    }

    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            return a();
        }
        return super.getSystemService(str);
    }

    public Resources getResources() {
        Resources resources = this.c;
        return resources != null ? resources : super.getResources();
    }

    public AssetManager getAssets() {
        Resources resources = getResources();
        AssetManager assets = resources != null ? resources.getAssets() : null;
        return assets != null ? assets : super.getAssets();
    }

    public Theme getTheme() {
        return this.d != null ? this.d : super.getTheme();
    }

    public void setTheme(int i) {
        if (this.d != null) {
            this.d.applyStyle(i, true);
        } else {
            super.setTheme(i);
        }
    }

    private Intent a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        return intent;
    }

    public void startActivity(Intent intent) {
        super.startActivity(a(intent));
    }

    public ComponentName startService(Intent intent) {
        return super.startService(a(intent));
    }

    public String getPackageName() {
        return this.a;
    }

    public Context getApplicationContext() {
        return this.e.getApplicationContext();
    }

    public Context getBaseContext() {
        return this;
    }
}
