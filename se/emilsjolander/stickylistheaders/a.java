package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TbsSdkJava */
class a extends BaseAdapter implements g {
    g a;
    private final List<View> b = new LinkedList();
    private final Context c;
    private Drawable d;
    private int e;
    private a f;
    private DataSetObserver g = new DataSetObserver(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void onInvalidated() {
            this.a.b.clear();
            super.notifyDataSetInvalidated();
        }

        public void onChanged() {
            super.notifyDataSetChanged();
        }
    };

    /* compiled from: TbsSdkJava */
    interface a {
        void a(View view, int i, long j);
    }

    public /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return b(i, view, viewGroup);
    }

    a(Context context, g gVar) {
        this.c = context;
        this.a = gVar;
        gVar.registerDataSetObserver(this.g);
    }

    void a(Drawable drawable, int i) {
        this.d = drawable;
        this.e = i;
        notifyDataSetChanged();
    }

    public boolean areAllItemsEnabled() {
        return this.a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.a.isEnabled(i);
    }

    public int getCount() {
        return this.a.getCount();
    }

    public Object getItem(int i) {
        return this.a.getItem(i);
    }

    public long getItemId(int i) {
        return this.a.getItemId(i);
    }

    public boolean hasStableIds() {
        return this.a.hasStableIds();
    }

    public int getItemViewType(int i) {
        return this.a.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.a.getViewTypeCount();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    private void a(WrapperView wrapperView) {
        View view = wrapperView.d;
        if (view != null) {
            view.setVisibility(0);
            this.b.add(view);
        }
    }

    private View a(WrapperView wrapperView, final int i) {
        View a = this.a.a(i, wrapperView.d == null ? a() : wrapperView.d, wrapperView);
        if (a == null) {
            throw new NullPointerException("Header view must not be null.");
        }
        a.setClickable(true);
        a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a b;

            public void onClick(View view) {
                if (this.b.f != null) {
                    this.b.f.a(view, i, this.b.a.a(i));
                }
            }
        });
        return a;
    }

    private View a() {
        if (this.b.size() > 0) {
            return (View) this.b.remove(0);
        }
        return null;
    }

    private boolean b(int i) {
        return i != 0 && this.a.a(i) == this.a.a(i - 1);
    }

    public WrapperView b(int i, View view, ViewGroup viewGroup) {
        WrapperView wrapperView = view == null ? new WrapperView(this.c) : (WrapperView) view;
        View view2 = this.a.getView(i, wrapperView.a, viewGroup);
        View view3 = null;
        if (b(i)) {
            a(wrapperView);
        } else {
            view3 = a(wrapperView, i);
        }
        if ((view2 instanceof Checkable) && !(wrapperView instanceof b)) {
            view = new b(this.c);
        } else if (!(view2 instanceof Checkable) && (wrapperView instanceof b)) {
            view = new WrapperView(this.c);
        }
        view.a(view2, view3, this.d, this.e);
        return view;
    }

    public void setOnHeaderClickListener(a aVar) {
        this.f = aVar;
    }

    public boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return ((BaseAdapter) this.a).getDropDownView(i, view, viewGroup);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void notifyDataSetChanged() {
        ((BaseAdapter) this.a).notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        ((BaseAdapter) this.a).notifyDataSetInvalidated();
    }

    public String toString() {
        return this.a.toString();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        return this.a.a(i, view, viewGroup);
    }

    public long a(int i) {
        return this.a.a(i);
    }
}
