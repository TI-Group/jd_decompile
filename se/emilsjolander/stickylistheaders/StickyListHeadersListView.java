package se.emilsjolander.stickylistheaders;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;

/* compiled from: TbsSdkJava */
public class StickyListHeadersListView extends FrameLayout {
    private h a;
    private View b;
    private Long c;
    private Integer d;
    private Integer e;
    private OnScrollListener f;
    private a g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float p;
    private boolean q;
    private float r;
    private c s;
    private e t;
    private d u;
    private a v;
    private Drawable w;
    private int x;

    /* compiled from: TbsSdkJava */
    public interface d {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j);
    }

    /* compiled from: TbsSdkJava */
    public interface e {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i);
    }

    /* compiled from: TbsSdkJava */
    private class a extends DataSetObserver {
        final /* synthetic */ StickyListHeadersListView a;

        private a(StickyListHeadersListView stickyListHeadersListView) {
            this.a = stickyListHeadersListView;
        }

        public void onChanged() {
            this.a.b();
        }

        public void onInvalidated() {
            this.a.b();
        }
    }

    /* compiled from: TbsSdkJava */
    private class b implements a {
        final /* synthetic */ StickyListHeadersListView a;

        private b(StickyListHeadersListView stickyListHeadersListView) {
            this.a = stickyListHeadersListView;
        }

        public void a(View view, int i, long j) {
            this.a.s.a(this.a, view, i, j, false);
        }
    }

    /* compiled from: TbsSdkJava */
    public interface c {
        void a(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j, boolean z);
    }

    /* compiled from: TbsSdkJava */
    private class f implements OnScrollListener {
        final /* synthetic */ StickyListHeadersListView a;

        private f(StickyListHeadersListView stickyListHeadersListView) {
            this.a = stickyListHeadersListView;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.a.f != null) {
                this.a.f.onScroll(absListView, i, i2, i3);
            }
            this.a.b(this.a.a.a());
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.a.f != null) {
                this.a.f.onScrollStateChanged(absListView, i);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class g implements a {
        final /* synthetic */ StickyListHeadersListView a;

        private g(StickyListHeadersListView stickyListHeadersListView) {
            this.a = stickyListHeadersListView;
        }

        public void a(Canvas canvas) {
            if (VERSION.SDK_INT < 8) {
                this.a.b(this.a.a.a());
            }
            if (this.a.b == null) {
                return;
            }
            if (this.a.i) {
                canvas.save();
                canvas.clipRect(0, this.a.m, this.a.getRight(), this.a.getBottom());
                this.a.drawChild(canvas, this.a.b, 0);
                canvas.restore();
                return;
            }
            this.a.drawChild(canvas, this.a.b, 0);
        }
    }

    public StickyListHeadersListView(Context context) {
        this(context, null);
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.stickyListHeadersListViewStyle);
    }

    @TargetApi(11)
    public StickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.r = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.a = new h(context);
        this.w = this.a.getDivider();
        this.x = this.a.getDividerHeight();
        this.a.setDivider(null);
        this.a.setDividerHeight(0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.StickyListHeadersListView, i, 0);
            try {
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_padding, 0);
                this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingLeft, dimensionPixelSize);
                this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingTop, dimensionPixelSize);
                this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingRight, dimensionPixelSize);
                this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingBottom, dimensionPixelSize);
                setPadding(this.l, this.m, this.n, this.o);
                this.i = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_clipToPadding, true);
                super.setClipToPadding(true);
                this.a.setClipToPadding(this.i);
                int i2 = obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_scrollbars, 512);
                this.a.setVerticalScrollBarEnabled((i2 & 512) != 0);
                h hVar = this.a;
                if ((i2 & 256) == 0) {
                    z = false;
                }
                hVar.setHorizontalScrollBarEnabled(z);
                if (VERSION.SDK_INT >= 9) {
                    this.a.setOverScrollMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_overScrollMode, 0));
                }
                this.a.setFadingEdgeLength(obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_fadingEdgeLength, this.a.getVerticalFadingEdgeLength()));
                int i3 = obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_requiresFadingEdge, 0);
                if (i3 == 4096) {
                    this.a.setVerticalFadingEdgeEnabled(false);
                    this.a.setHorizontalFadingEdgeEnabled(true);
                } else if (i3 == 8192) {
                    this.a.setVerticalFadingEdgeEnabled(true);
                    this.a.setHorizontalFadingEdgeEnabled(false);
                } else {
                    this.a.setVerticalFadingEdgeEnabled(false);
                    this.a.setHorizontalFadingEdgeEnabled(false);
                }
                this.a.setCacheColorHint(obtainStyledAttributes.getColor(R.styleable.StickyListHeadersListView_android_cacheColorHint, this.a.getCacheColorHint()));
                if (VERSION.SDK_INT >= 11) {
                    this.a.setChoiceMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_choiceMode, this.a.getChoiceMode()));
                }
                this.a.setDrawSelectorOnTop(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_drawSelectorOnTop, false));
                this.a.setFastScrollEnabled(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollEnabled, this.a.isFastScrollEnabled()));
                if (VERSION.SDK_INT >= 11) {
                    this.a.setFastScrollAlwaysVisible(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollAlwaysVisible, this.a.isFastScrollAlwaysVisible()));
                }
                this.a.setScrollBarStyle(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_scrollbarStyle, 0));
                if (obtainStyledAttributes.hasValue(R.styleable.StickyListHeadersListView_android_listSelector)) {
                    this.a.setSelector(obtainStyledAttributes.getDrawable(R.styleable.StickyListHeadersListView_android_listSelector));
                }
                this.a.setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_scrollingCache, this.a.isScrollingCacheEnabled()));
                if (obtainStyledAttributes.hasValue(R.styleable.StickyListHeadersListView_android_divider)) {
                    this.w = obtainStyledAttributes.getDrawable(R.styleable.StickyListHeadersListView_android_divider);
                }
                this.a.setStackFromBottom(obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_android_stackFromBottom, false));
                this.x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_dividerHeight, this.x);
                this.a.setTranscriptMode(obtainStyledAttributes.getInt(R.styleable.StickyListHeadersListView_android_transcriptMode, 0));
                this.h = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_hasStickyHeaders, true);
                this.j = obtainStyledAttributes.getBoolean(R.styleable.StickyListHeadersListView_isDrawingListUnderStickyHeader, true);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.a.a(new g());
        this.a.setOnScrollListener(new f());
        addView(this.a);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b(this.b);
    }

    private void a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        } else if (layoutParams.height == -1 || layoutParams.width == -2) {
            layoutParams.height = -2;
            layoutParams.width = -1;
            view.setLayoutParams(layoutParams);
        }
    }

    private void b(View view) {
        if (view != null) {
            measureChild(view, MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.l) - this.n, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, this.a.getMeasuredWidth(), getHeight());
        if (this.b != null) {
            int i5 = ((MarginLayoutParams) this.b.getLayoutParams()).topMargin;
            this.b.layout(this.l, i5, this.b.getMeasuredWidth() + this.l, this.b.getMeasuredHeight() + i5);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.a.getVisibility() == 0 || this.a.getAnimation() != null) {
            drawChild(canvas, this.a, 0);
        }
    }

    private void b() {
        if (this.b != null) {
            removeView(this.b);
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a.a(0);
            c();
        }
    }

    private void b(int i) {
        int i2 = 0;
        int count = this.g == null ? 0 : this.g.getCount();
        if (count != 0 && this.h) {
            int headerViewsCount = i - this.a.getHeaderViewsCount();
            if (this.a.getChildCount() > 0 && this.a.getChildAt(0).getBottom() < d()) {
                headerViewsCount++;
            }
            int i3 = this.a.getChildCount() != 0 ? 1 : 0;
            int i4;
            if (i3 == 0 || this.a.getFirstVisiblePosition() != 0 || this.a.getChildAt(0).getTop() < d()) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (headerViewsCount > count - 1 || headerViewsCount < 0) {
                i2 = 1;
            }
            if (i3 != 0 && r1 == 0 && r3 == 0) {
                c(headerViewsCount);
            } else {
                b();
            }
        }
    }

    private void c(int i) {
        int min;
        if (this.d == null || this.d.intValue() != i) {
            this.d = Integer.valueOf(i);
            long a = this.g.a(i);
            if (this.c == null || this.c.longValue() != a) {
                this.c = Long.valueOf(a);
                View a2 = this.g.a(this.d.intValue(), this.b, this);
                if (this.b != a2) {
                    if (a2 == null) {
                        throw new NullPointerException("header may not be null");
                    }
                    c(a2);
                }
                a(this.b);
                b(this.b);
                if (this.u != null) {
                    this.u.a(this, this.b, i, this.c.longValue());
                }
                this.e = null;
            }
        }
        int d = d();
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            View childAt = this.a.getChildAt(i2);
            Object obj = ((childAt instanceof WrapperView) && ((WrapperView) childAt).a()) ? 1 : null;
            boolean a3 = this.a.a(childAt);
            if (childAt.getTop() >= d() && (obj != null || a3)) {
                min = Math.min(childAt.getTop() - this.b.getMeasuredHeight(), d);
                break;
            }
        }
        min = d;
        setHeaderOffet(min);
        if (!this.j) {
            this.a.a(this.b.getMeasuredHeight() + this.e.intValue());
        }
        c();
    }

    private void c(View view) {
        if (this.b != null) {
            removeView(this.b);
        }
        this.b = view;
        addView(this.b);
        if (this.s != null) {
            this.b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ StickyListHeadersListView a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    this.a.s.a(this.a, this.a.b, this.a.d.intValue(), this.a.c.longValue(), true);
                }
            });
        }
        this.b.setClickable(true);
    }

    private void c() {
        int d = d();
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.getChildAt(i);
            if (childAt instanceof WrapperView) {
                WrapperView wrapperView = (WrapperView) childAt;
                if (wrapperView.a()) {
                    View view = wrapperView.d;
                    if (wrapperView.getTop() < d) {
                        if (view.getVisibility() != 4) {
                            view.setVisibility(4);
                        }
                    } else if (view.getVisibility() != 0) {
                        view.setVisibility(0);
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void setHeaderOffet(int i) {
        if (this.e == null || this.e.intValue() != i) {
            this.e = Integer.valueOf(i);
            if (VERSION.SDK_INT >= 11) {
                this.b.setTranslationY((float) this.e.intValue());
            } else {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.b.getLayoutParams();
                marginLayoutParams.topMargin = this.e.intValue();
                this.b.setLayoutParams(marginLayoutParams);
            }
            if (this.t != null) {
                this.t.a(this, this.b, -this.e.intValue());
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = motionEvent.getY();
            boolean z = this.b != null && this.p <= ((float) (this.b.getHeight() + this.e.intValue()));
            this.q = z;
        }
        if (!this.q) {
            return this.a.dispatchTouchEvent(motionEvent);
        }
        if (this.b != null && Math.abs(this.p - motionEvent.getY()) <= this.r) {
            return this.b.dispatchTouchEvent(motionEvent);
        }
        if (this.b != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            this.b.dispatchTouchEvent(obtain);
            obtain.recycle();
        }
        MotionEvent obtain2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX(), this.p, motionEvent.getMetaState());
        obtain2.setAction(0);
        z = this.a.dispatchTouchEvent(obtain2);
        obtain2.recycle();
        this.q = false;
        return z;
    }

    private boolean d(int i) {
        return i == 0 || this.g.a(i) != this.g.a(i - 1);
    }

    public int a(int i) {
        if (d(Math.max(0, i - getHeaderViewsCount()))) {
            return 0;
        }
        View a = this.g.a(i, null, this.a);
        if (a == null) {
            throw new NullPointerException("header may not be null");
        }
        a(a);
        b(a);
        return a.getMeasuredHeight();
    }

    private int d() {
        return (this.i ? this.m : 0) + this.k;
    }

    public void setAreHeadersSticky(boolean z) {
        this.h = z;
        if (z) {
            b(this.a.a());
        } else {
            b();
        }
        this.a.invalidate();
    }

    public boolean a() {
        return this.h;
    }

    @Deprecated
    public boolean getAreHeadersSticky() {
        return a();
    }

    public void setStickyHeaderTopOffset(int i) {
        this.k = i;
        b(this.a.a());
    }

    public int getStickyHeaderTopOffset() {
        return this.k;
    }

    public void setDrawingListUnderStickyHeader(boolean z) {
        this.j = z;
        this.a.a(0);
    }

    public void setOnHeaderClickListener(c cVar) {
        this.s = cVar;
        if (this.g == null) {
            return;
        }
        if (this.s != null) {
            this.g.setOnHeaderClickListener(new b());
            if (this.b != null) {
                this.b.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ StickyListHeadersListView a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.s.a(this.a, this.a.b, this.a.d.intValue(), this.a.c.longValue(), true);
                    }
                });
                return;
            }
            return;
        }
        this.g.setOnHeaderClickListener(null);
    }

    public void setOnStickyHeaderOffsetChangedListener(e eVar) {
        this.t = eVar;
    }

    public void setOnStickyHeaderChangedListener(d dVar) {
        this.u = dVar;
    }

    public int getListChildCount() {
        return this.a.getChildCount();
    }

    public ListView getWrappedList() {
        return this.a;
    }

    private boolean e(int i) {
        if (VERSION.SDK_INT >= i) {
            return true;
        }
        Log.e("StickyListHeaders", "Api lvl must be at least " + i + " to call this method");
        return false;
    }

    public void setAdapter(g gVar) {
        if (gVar == null) {
            if (this.g instanceof f) {
                ((f) this.g).b = null;
            }
            if (this.g != null) {
                this.g.a = null;
            }
            this.a.setAdapter(null);
            b();
            return;
        }
        if (this.g != null) {
            this.g.unregisterDataSetObserver(this.v);
        }
        if (gVar instanceof SectionIndexer) {
            this.g = new f(getContext(), gVar);
        } else {
            this.g = new a(getContext(), gVar);
        }
        this.v = new a();
        this.g.registerDataSetObserver(this.v);
        if (this.s != null) {
            this.g.setOnHeaderClickListener(new b());
        } else {
            this.g.setOnHeaderClickListener(null);
        }
        this.g.a(this.w, this.x);
        this.a.setAdapter(this.g);
        b();
    }

    public g getAdapter() {
        return this.g == null ? null : this.g.a;
    }

    public void setDivider(Drawable drawable) {
        this.w = drawable;
        if (this.g != null) {
            this.g.a(this.w, this.x);
        }
    }

    public void setDividerHeight(int i) {
        this.x = i;
        if (this.g != null) {
            this.g.a(this.w, this.x);
        }
    }

    public Drawable getDivider() {
        return this.w;
    }

    public int getDividerHeight() {
        return this.x;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f = onScrollListener;
    }

    public void setOnTouchListener(final OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.a.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ StickyListHeadersListView b;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return onTouchListener.onTouch(this.b, motionEvent);
                }
            });
        } else {
            this.a.setOnTouchListener(null);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.a.setOnItemClickListener(onItemClickListener);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.a.setOnItemLongClickListener(onItemLongClickListener);
    }

    public int getHeaderViewsCount() {
        return this.a.getHeaderViewsCount();
    }

    public int getFooterViewsCount() {
        return this.a.getFooterViewsCount();
    }

    public void setEmptyView(View view) {
        this.a.setEmptyView(view);
    }

    public View getEmptyView() {
        return this.a.getEmptyView();
    }

    public boolean isVerticalScrollBarEnabled() {
        return this.a.isVerticalScrollBarEnabled();
    }

    public boolean isHorizontalScrollBarEnabled() {
        return this.a.isHorizontalScrollBarEnabled();
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        this.a.setVerticalScrollBarEnabled(z);
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        this.a.setHorizontalScrollBarEnabled(z);
    }

    @TargetApi(9)
    public int getOverScrollMode() {
        if (e(9)) {
            return this.a.getOverScrollMode();
        }
        return 0;
    }

    @TargetApi(9)
    public void setOverScrollMode(int i) {
        if (e(9) && this.a != null) {
            this.a.setOverScrollMode(i);
        }
    }

    public void setSelection(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        int i3 = 0;
        int a = (this.g == null ? 0 : a(i)) + i2;
        if (!this.i) {
            i3 = this.m;
        }
        this.a.setSelectionFromTop(i, a - i3);
    }

    public void setSelector(Drawable drawable) {
        this.a.setSelector(drawable);
    }

    public void setSelector(int i) {
        this.a.setSelector(i);
    }

    public int getFirstVisiblePosition() {
        return this.a.getFirstVisiblePosition();
    }

    public int getLastVisiblePosition() {
        return this.a.getLastVisiblePosition();
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        this.a.setChoiceMode(i);
    }

    @TargetApi(11)
    public int getCheckedItemCount() {
        if (e(11)) {
            return this.a.getCheckedItemCount();
        }
        return 0;
    }

    @TargetApi(8)
    public long[] getCheckedItemIds() {
        if (e(8)) {
            return this.a.getCheckedItemIds();
        }
        return null;
    }

    @TargetApi(11)
    public int getCheckedItemPosition() {
        return this.a.getCheckedItemPosition();
    }

    @TargetApi(11)
    public SparseBooleanArray getCheckedItemPositions() {
        return this.a.getCheckedItemPositions();
    }

    public int getCount() {
        return this.a.getCount();
    }

    public void setOnCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        this.a.setOnCreateContextMenuListener(onCreateContextMenuListener);
    }

    public boolean showContextMenu() {
        return this.a.showContextMenu();
    }

    public void setClipToPadding(boolean z) {
        if (this.a != null) {
            this.a.setClipToPadding(z);
        }
        this.i = z;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.l = i;
        this.m = i2;
        this.n = i3;
        this.o = i4;
        if (this.a != null) {
            this.a.setPadding(i, i2, i3, i4);
        }
        super.setPadding(0, 0, 0, 0);
        requestLayout();
    }

    public int getPaddingLeft() {
        return this.l;
    }

    public int getPaddingTop() {
        return this.m;
    }

    public int getPaddingRight() {
        return this.n;
    }

    public int getPaddingBottom() {
        return this.o;
    }

    public void setFastScrollEnabled(boolean z) {
        this.a.setFastScrollEnabled(z);
    }

    @TargetApi(11)
    public void setFastScrollAlwaysVisible(boolean z) {
        if (e(11)) {
            this.a.setFastScrollAlwaysVisible(z);
        }
    }

    public void setScrollBarStyle(int i) {
        this.a.setScrollBarStyle(i);
    }

    public int getScrollBarStyle() {
        return this.a.getScrollBarStyle();
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (e(11)) {
            this.a.setMultiChoiceModeListener(multiChoiceModeListener);
        }
    }

    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == BaseSavedState.EMPTY_STATE) {
            return this.a.onSaveInstanceState();
        }
        throw new IllegalStateException("Handling non empty state of parent class is not implemented");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(BaseSavedState.EMPTY_STATE);
        this.a.onRestoreInstanceState(parcelable);
    }

    @TargetApi(14)
    public boolean canScrollVertically(int i) {
        return this.a.canScrollVertically(i);
    }

    public void setTranscriptMode(int i) {
        this.a.setTranscriptMode(i);
    }

    public void setBlockLayoutChildren(boolean z) {
        this.a.a(z);
    }

    public void setStackFromBottom(boolean z) {
        this.a.setStackFromBottom(z);
    }
}
