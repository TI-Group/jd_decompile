package com.kepler.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;

/* compiled from: TbsSdkJava */
final class c extends LayoutInflater {
    private a a;

    /* compiled from: TbsSdkJava */
    public interface a {
        View a(View view, String str, Context context, AttributeSet attributeSet) throws ClassNotFoundException;
    }

    protected c(Context context) {
        this(context, null);
    }

    protected c(Context context, a aVar) {
        super(context);
        a(aVar);
        a();
    }

    public LayoutInflater cloneInContext(Context context) {
        return null;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @SuppressLint({"InlinedApi", "NewApi"})
    private void a() {
        Object obj = null;
        if (b()) {
            try {
                setFactory2(new Factory2(this) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
                        return this.a.a(view, str, context, attributeSet);
                    }

                    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
                        return null;
                    }
                });
                obj = 1;
            } catch (Throwable th) {
            }
        }
        if (obj == null) {
            setFactory(new Factory(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public View onCreateView(String str, Context context, AttributeSet attributeSet) {
                    return this.a.a(null, str, context, attributeSet);
                }
            });
        }
    }

    private View a(View view, String str, Context context, AttributeSet attributeSet) {
        View view2 = null;
        a aVar = this.a;
        if (aVar != null) {
            try {
                view2 = aVar.a(view, str, context, attributeSet);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return view2;
    }

    private static boolean b() {
        return VERSION.SDK_INT >= 11;
    }
}
