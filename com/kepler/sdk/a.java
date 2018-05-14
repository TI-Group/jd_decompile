package com.kepler.sdk;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import cn.jiguang.net.HttpUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@TargetApi(16)
/* compiled from: TbsSdkJava */
public class a {
    public static float a = -1.0f;
    private static volatile a h;
    private Resources b;
    private ContextWrapper c;
    private Application d;
    private boolean e;
    private Map<String, Integer> f = new HashMap();
    private final LongSparseArray<WeakReference<ConstantState>> g = new LongSparseArray();

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    public void a(Application application, String str) {
        this.d = application;
        if (aq.b(str)) {
            this.c = application;
            this.e = false;
        } else {
            this.c = new d(application, str);
            this.e = true;
        }
        this.b = this.c.getResources();
        a = c();
    }

    public int a(String str, String str2) {
        String str3 = str2 + HttpUtils.PATHS_SEPARATOR + str;
        if (this.e && this.f.containsKey(str3)) {
            return ((Integer) this.f.get(str3)).intValue();
        }
        int identifier = this.b.getIdentifier(str, str2, this.c.getPackageName());
        if (identifier == 0) {
            throw new NullPointerException(str);
        } else if (!this.e) {
            return identifier;
        } else {
            this.f.put(str3, Integer.valueOf(identifier));
            return identifier;
        }
    }

    @Deprecated
    public LayoutInflater b() {
        if (this.e) {
            return ((d) this.c).a();
        }
        return (LayoutInflater) this.d.getSystemService("layout_inflater");
    }

    public CharSequence a(String str) {
        CharSequence charSequence = null;
        try {
            charSequence = this.b.getText(a(str, "string"));
        } catch (Throwable e) {
            a(e, true);
        }
        return charSequence;
    }

    public String b(String str) {
        try {
            return this.b.getString(a(str, "string"));
        } catch (Throwable e) {
            a(e, true);
            return null;
        }
    }

    public View c(String str) {
        View view = null;
        try {
            view = b().inflate(this.b.getLayout(a(str, "layout")), null, false);
        } catch (Throwable e) {
            a(e, true);
        }
        return view;
    }

    private float c() {
        WindowManager windowManager = (WindowManager) this.d.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    private void a(Throwable th, boolean z) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        Log.e("TESResource", "exceptions(" + z + "):" + stringWriter.toString());
        if (z) {
            System.exit(-1);
        }
    }

    public View a(int i, View view) {
        return view.findViewById(i);
    }

    public View d(String str) {
        return c(str);
    }

    public int e(String str) {
        return a(str, "style");
    }
}
