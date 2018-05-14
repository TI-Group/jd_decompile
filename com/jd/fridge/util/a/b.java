package com.jd.fridge.util.a;

import android.content.Context;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.jd.fridge.util.y;

/* compiled from: TbsSdkJava */
public abstract class b implements ErrorListener {
    private Context a = null;

    public abstract void a(VolleyError volleyError);

    public b(Context context) {
        this.a = context;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (!(this.a == null || !y.b(this.a) || (volleyError instanceof c) || volleyError.networkResponse == null)) {
        }
        a(volleyError);
    }
}
