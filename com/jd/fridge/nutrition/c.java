package com.jd.fridge.nutrition;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class c<T extends HCHSFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;

    public c(final T t, Finder finder, Object obj) {
        this.a = t;
        t.mLayoutContent = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.content_layout, "field 'mLayoutContent'", LinearLayout.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        View findRequiredView = finder.findRequiredView(obj, R.id.ctv_tab_btn_all, "field 'mCtvTabBtnAll' and method 'onClick'");
        t.mCtvTabBtnAll = (CheckedTextView) finder.castView(findRequiredView, R.id.ctv_tab_btn_all, "field 'mCtvTabBtnAll'", CheckedTextView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.ctv_tab_btn_hc, "field 'mCtvTabBtnHc' and method 'onClick'");
        t.mCtvTabBtnHc = (CheckedTextView) finder.castView(findRequiredView, R.id.ctv_tab_btn_hc, "field 'mCtvTabBtnHc'", CheckedTextView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.ctv_tab_btn_hs, "field 'mCtvTabBtnHs' and method 'onClick'");
        t.mCtvTabBtnHs = (CheckedTextView) finder.castView(findRequiredView, R.id.ctv_tab_btn_hs, "field 'mCtvTabBtnHs'", CheckedTextView.class);
        this.d = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        t.rcv_container = (FrameLayout) finder.findRequiredViewAsType(obj, R.id.rcv_container, "field 'rcv_container'", FrameLayout.class);
        t.scroll_layout = (ScrollView) finder.findRequiredViewAsType(obj, R.id.scroll_layout, "field 'scroll_layout'", ScrollView.class);
    }

    public void unbind() {
        HCHSFragment hCHSFragment = this.a;
        if (hCHSFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        hCHSFragment.mLayoutContent = null;
        hCHSFragment.mEmptyLayout = null;
        hCHSFragment.mCtvTabBtnAll = null;
        hCHSFragment.mCtvTabBtnHc = null;
        hCHSFragment.mCtvTabBtnHs = null;
        hCHSFragment.rcv_container = null;
        hCHSFragment.scroll_layout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.a = null;
    }
}
