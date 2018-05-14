package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
class h extends ListView {
    private a a;
    private List<View> b;
    private int c;
    private Rect d = new Rect();
    private Field e;
    private boolean f = true;
    private boolean g = false;

    /* compiled from: TbsSdkJava */
    interface a {
        void a(Canvas canvas);
    }

    public h(Context context) {
        super(context);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mSelectorRect");
            declaredField.setAccessible(true);
            this.d = (Rect) declaredField.get(this);
            if (VERSION.SDK_INT >= 14) {
                this.e = AbsListView.class.getDeclaredField("mSelectorPosition");
                this.e.setAccessible(true);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    public boolean performItemClick(View view, int i, long j) {
        if (view instanceof WrapperView) {
            view = ((WrapperView) view).a;
        }
        return super.performItemClick(view, i, j);
    }

    private void b() {
        if (!this.d.isEmpty()) {
            int c = c();
            if (c >= 0) {
                View childAt = getChildAt(c - a());
                if (childAt instanceof WrapperView) {
                    WrapperView wrapperView = (WrapperView) childAt;
                    this.d.top = wrapperView.e + wrapperView.getTop();
                }
            }
        }
    }

    private int c() {
        if (this.e == null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i).getBottom() == this.d.bottom) {
                    return i + a();
                }
            }
        } else {
            try {
                return this.e.getInt(this);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    protected void dispatchDraw(Canvas canvas) {
        b();
        if (this.c != 0) {
            canvas.save();
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.top = this.c;
            canvas.clipRect(clipBounds);
            super.dispatchDraw(canvas);
            canvas.restore();
        } else {
            super.dispatchDraw(canvas);
        }
        this.a.a(canvas);
    }

    void a(a aVar) {
        this.a = aVar;
    }

    public void addFooterView(View view) {
        super.addFooterView(view);
        b(view);
    }

    public void addFooterView(View view, Object obj, boolean z) {
        super.addFooterView(view, obj, z);
        b(view);
    }

    private void b(View view) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(view);
    }

    public boolean removeFooterView(View view) {
        if (!super.removeFooterView(view)) {
            return false;
        }
        this.b.remove(view);
        return true;
    }

    boolean a(View view) {
        if (this.b == null) {
            return false;
        }
        return this.b.contains(view);
    }

    void a(int i) {
        this.c = i;
    }

    int a() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (VERSION.SDK_INT >= 11) {
            return firstVisiblePosition;
        }
        int i;
        for (i = 0; i < getChildCount(); i++) {
            if (getChildAt(i).getBottom() >= 0) {
                i += firstVisiblePosition;
                break;
            }
        }
        i = firstVisiblePosition;
        if (!this.f && getPaddingTop() > 0 && i > 0 && getChildAt(0).getTop() > 0) {
            i--;
        }
        return i;
    }

    public void setClipToPadding(boolean z) {
        this.f = z;
        super.setClipToPadding(z);
    }

    public void a(boolean z) {
        this.g = z;
    }

    protected void layoutChildren() {
        if (!this.g) {
            super.layoutChildren();
        }
    }
}
