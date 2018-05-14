package com.kepler.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import com.kepler.sdk.c.a;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: TbsSdkJava */
final class e extends LayoutInflater implements a {
    static final Class<?>[] a = new Class[]{Context.class, AttributeSet.class};
    private static final String[] b = new String[]{"android.widget.", "android.webkit."};
    private HashMap<String, Boolean> c;
    private final Object[] d;
    private final HashMap<String, Constructor<? extends View>> e;

    protected e(Context context) {
        this(context, new c(context));
    }

    private e(Context context, c cVar) {
        super(cVar, context);
        this.d = new Object[2];
        this.e = new HashMap();
        cVar.a(this);
    }

    protected e(e eVar, Context context) {
        super(eVar, context);
        this.d = new Object[2];
        this.e = new HashMap();
    }

    public void setFilter(Filter filter) {
        super.setFilter(filter);
        if (filter != null) {
            this.c = new HashMap();
        }
    }

    public LayoutInflater cloneInContext(Context context) {
        return new e(this, context);
    }

    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        String[] strArr = b;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                View createView = createView(str, strArr[i], attributeSet);
                if (createView != null) {
                    return createView;
                }
                i++;
            } catch (ClassNotFoundException e) {
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) throws ClassNotFoundException {
        View view2 = null;
        if (-1 != str.indexOf(46)) {
            try {
                view2 = b(str, attributeSet);
            } catch (Throwable th) {
                Log.d("PluginLayoutInflater", "fail to create view internal for " + str + " with ");
            }
        }
        if (view2 == null) {
            try {
                view2 = a(str, attributeSet);
            } catch (Throwable th2) {
            }
        }
        return view2;
    }

    private View a(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        if (-1 == str.indexOf(46)) {
            return onCreateView(str, attributeSet);
        }
        return createView(str, null, attributeSet);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"InlinedApi", "NewApi"})
    private android.view.View b(java.lang.String r10, android.util.AttributeSet r11) throws java.lang.ClassNotFoundException, android.view.InflateException {
        /*
        r9 = this;
        r4 = 1;
        r5 = 0;
        r6 = r9.d;
        monitor-enter(r6);
        r1 = r9.d;	 Catch:{ all -> 0x00d0 }
        r2 = 0;
        r3 = r9.getContext();	 Catch:{ all -> 0x00d0 }
        r1[r2] = r3;	 Catch:{ all -> 0x00d0 }
        r1 = r9.e;	 Catch:{ all -> 0x00d0 }
        r1 = r1.get(r10);	 Catch:{ all -> 0x00d0 }
        r1 = (java.lang.reflect.Constructor) r1;	 Catch:{ all -> 0x00d0 }
        r3 = 0;
        r7 = r9.getFilter();	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        if (r1 != 0) goto L_0x0066;
    L_0x001d:
        r1 = r9.getClass();	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r1 = r1.getClassLoader();	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r1 = r1.loadClass(r10);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = android.view.View.class;
        r2 = r1.asSubclass(r2);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        if (r7 == 0) goto L_0x003c;
    L_0x0031:
        if (r2 == 0) goto L_0x003c;
    L_0x0033:
        r1 = r7.onLoadClass(r2);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        if (r1 != 0) goto L_0x003c;
    L_0x0039:
        r9.c(r10, r11);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
    L_0x003c:
        r1 = a;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r1 = r2.getConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r3 = r9.e;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r3.put(r10, r1);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r3 = r2;
    L_0x0048:
        r2 = r9.d;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r4 = 1;
        r2[r4] = r11;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r1 = r1.newInstance(r2);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r1 = (android.view.View) r1;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r4 = 16;
        if (r2 < r4) goto L_0x0064;
    L_0x0059:
        r2 = r1 instanceof android.view.ViewStub;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        if (r2 == 0) goto L_0x0064;
    L_0x005d:
        r0 = r1;
        r0 = (android.view.ViewStub) r0;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
        r2 = r0;
        r2.setLayoutInflater(r9);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x012b }
    L_0x0064:
        monitor-exit(r6);	 Catch:{ all -> 0x00d0 }
        return r1;
    L_0x0066:
        if (r7 == 0) goto L_0x0048;
    L_0x0068:
        r2 = r9.c;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = r2.get(r10);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = (java.lang.Boolean) r2;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        if (r2 != 0) goto L_0x009f;
    L_0x0072:
        r2 = r9.getClass();	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = r2.getClassLoader();	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = r2.loadClass(r10);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r8 = android.view.View.class;
        r2 = r2.asSubclass(r8);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        if (r2 == 0) goto L_0x009d;
    L_0x0086:
        r3 = r7.onLoadClass(r2);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        if (r3 == 0) goto L_0x009d;
    L_0x008c:
        r3 = r4;
    L_0x008d:
        r4 = r9.c;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r5 = java.lang.Boolean.valueOf(r3);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        r4.put(r10, r5);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
        if (r3 != 0) goto L_0x009b;
    L_0x0098:
        r9.c(r10, r11);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x0129 }
    L_0x009b:
        r3 = r2;
        goto L_0x0048;
    L_0x009d:
        r3 = r5;
        goto L_0x008d;
    L_0x009f:
        r4 = java.lang.Boolean.FALSE;	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        r2 = r2.equals(r4);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        if (r2 == 0) goto L_0x0048;
    L_0x00a7:
        r9.c(r10, r11);	 Catch:{ NoSuchMethodException -> 0x00ab, ClassCastException -> 0x00d3, ClassNotFoundException -> 0x00f8, Exception -> 0x00fa }
        goto L_0x0048;
    L_0x00ab:
        r1 = move-exception;
        r2 = new android.view.InflateException;	 Catch:{ all -> 0x00d0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r3.<init>();	 Catch:{ all -> 0x00d0 }
        r4 = r11.getPositionDescription();	 Catch:{ all -> 0x00d0 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00d0 }
        r4 = ": Error inflating class ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00d0 }
        r3 = r3.append(r10);	 Catch:{ all -> 0x00d0 }
        r3 = r3.toString();	 Catch:{ all -> 0x00d0 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d0 }
        r2.initCause(r1);	 Catch:{ all -> 0x00d0 }
        throw r2;	 Catch:{ all -> 0x00d0 }
    L_0x00d0:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x00d0 }
        throw r1;
    L_0x00d3:
        r1 = move-exception;
        r2 = new android.view.InflateException;	 Catch:{ all -> 0x00d0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r3.<init>();	 Catch:{ all -> 0x00d0 }
        r4 = r11.getPositionDescription();	 Catch:{ all -> 0x00d0 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00d0 }
        r4 = ": Class is not a View ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00d0 }
        r3 = r3.append(r10);	 Catch:{ all -> 0x00d0 }
        r3 = r3.toString();	 Catch:{ all -> 0x00d0 }
        r2.<init>(r3);	 Catch:{ all -> 0x00d0 }
        r2.initCause(r1);	 Catch:{ all -> 0x00d0 }
        throw r2;	 Catch:{ all -> 0x00d0 }
    L_0x00f8:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x00d0 }
    L_0x00fa:
        r1 = move-exception;
        r2 = r3;
    L_0x00fc:
        r3 = new android.view.InflateException;	 Catch:{ all -> 0x00d0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d0 }
        r4.<init>();	 Catch:{ all -> 0x00d0 }
        r5 = r11.getPositionDescription();	 Catch:{ all -> 0x00d0 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00d0 }
        r5 = ": Error inflating class ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x00d0 }
        if (r2 != 0) goto L_0x0124;
    L_0x0113:
        r2 = "<unknown>";
    L_0x0115:
        r2 = r4.append(r2);	 Catch:{ all -> 0x00d0 }
        r2 = r2.toString();	 Catch:{ all -> 0x00d0 }
        r3.<init>(r2);	 Catch:{ all -> 0x00d0 }
        r3.initCause(r1);	 Catch:{ all -> 0x00d0 }
        throw r3;	 Catch:{ all -> 0x00d0 }
    L_0x0124:
        r2 = r2.getName();	 Catch:{ all -> 0x00d0 }
        goto L_0x0115;
    L_0x0129:
        r1 = move-exception;
        goto L_0x00fc;
    L_0x012b:
        r1 = move-exception;
        r2 = r3;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kepler.sdk.e.b(java.lang.String, android.util.AttributeSet):android.view.View");
    }

    private void c(String str, AttributeSet attributeSet) {
        throw new InflateException(attributeSet.getPositionDescription() + ": Class not allowed to be inflated " + str);
    }
}
