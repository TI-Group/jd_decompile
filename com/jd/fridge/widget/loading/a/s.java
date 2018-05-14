package com.jd.fridge.widget.loading.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: TbsSdkJava */
public abstract class s {
    private WeakReference<View> a;
    private List<com.a.a.a> b;

    /* compiled from: TbsSdkJava */
    public enum a {
        START,
        END,
        CANCEL
    }

    public abstract List<com.a.a.a> a();

    public abstract void a(Canvas canvas, Paint paint);

    public void a(View view) {
        this.a = new WeakReference(view);
    }

    public View b() {
        return this.a != null ? (View) this.a.get() : null;
    }

    public int c() {
        return b() != null ? b().getWidth() : 0;
    }

    public int d() {
        return b() != null ? b().getHeight() : 0;
    }

    public void e() {
        if (b() != null) {
            b().postInvalidate();
        }
    }

    public void f() {
        this.b = a();
    }

    public void a(a aVar) {
        if (this.b != null) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                com.a.a.a aVar2 = (com.a.a.a) this.b.get(i);
                boolean d = aVar2.d();
                switch (aVar) {
                    case START:
                        if (!d) {
                            aVar2.a();
                            break;
                        }
                        break;
                    case END:
                        if (!d) {
                            break;
                        }
                        aVar2.c();
                        break;
                    case CANCEL:
                        if (!d) {
                            break;
                        }
                        aVar2.b();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
