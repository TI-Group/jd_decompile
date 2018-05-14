package com.jd.fridge.util.a;

import android.content.Context;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.jd.fridge.bean.Event;
import com.jd.fridge.util.k;
import com.jd.fridge.util.t;
import com.jd.fridge.util.y;
import org.greenrobot.eventbus.c;

/* compiled from: TbsSdkJava */
public abstract class a implements ErrorListener {
    private Context a = null;
    private t b = null;
    private boolean c;

    public abstract void a(VolleyError volleyError);

    public a(Context context) {
        this.a = context;
        this.b = new t(this.a);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void a(String str) {
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (this.a != null && y.b(this.a)) {
            if (volleyError instanceof c) {
                if (!this.c) {
                    k.a("error.getMessage()=" + volleyError.getMessage());
                    this.b.a(volleyError.getMessage());
                }
            } else if (volleyError.networkResponse == null) {
                this.b.a(2);
                c.a().c(Event.newEvent(2, null));
            } else if (!this.c) {
                this.b.a(1);
            }
        }
        a(volleyError);
    }
}
