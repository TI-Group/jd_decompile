package com.jd.fridge.nutrition;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.FoodsGridView;

/* compiled from: TbsSdkJava */
public class b<T extends DistributionFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;

    public b(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.ctv_tab_btn_week, "field 'mCtvTabBtnWeek' and method 'onClick'");
        t.mCtvTabBtnWeek = (CheckedTextView) finder.castView(findRequiredView, R.id.ctv_tab_btn_week, "field 'mCtvTabBtnWeek'", CheckedTextView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.ctv_tab_btn_day, "field 'mCtvTabBtnDay' and method 'onClick'");
        t.mCtvTabBtnDay = (CheckedTextView) finder.castView(findRequiredView, R.id.ctv_tab_btn_day, "field 'mCtvTabBtnDay'", CheckedTextView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        t.mDate = (TextView) finder.findRequiredViewAsType(obj, R.id.date, "field 'mDate'", TextView.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        t.mLayoutContent = (ScrollView) finder.findRequiredViewAsType(obj, R.id.layout_content, "field 'mLayoutContent'", ScrollView.class);
        t.mQuarter1Text = (TextView) finder.findRequiredViewAsType(obj, R.id.quarter1_text, "field 'mQuarter1Text'", TextView.class);
        t.mQuarter1Gridview = (FoodsGridView) finder.findRequiredViewAsType(obj, R.id.quarter1_gridview, "field 'mQuarter1Gridview'", FoodsGridView.class);
        t.mQuarter2Text = (TextView) finder.findRequiredViewAsType(obj, R.id.quarter2_text, "field 'mQuarter2Text'", TextView.class);
        t.mQuarter2Gridview = (FoodsGridView) finder.findRequiredViewAsType(obj, R.id.quarter2_gridview, "field 'mQuarter2Gridview'", FoodsGridView.class);
        t.mQuarter3Text = (TextView) finder.findRequiredViewAsType(obj, R.id.quarter3_text, "field 'mQuarter3Text'", TextView.class);
        t.mQuarter3Gridview = (FoodsGridView) finder.findRequiredViewAsType(obj, R.id.quarter3_gridview, "field 'mQuarter3Gridview'", FoodsGridView.class);
        t.mQuarter4Text = (TextView) finder.findRequiredViewAsType(obj, R.id.quarter4_text, "field 'mQuarter4Text'", TextView.class);
        t.mQuarter4Gridview = (FoodsGridView) finder.findRequiredViewAsType(obj, R.id.quarter4_gridview, "field 'mQuarter4Gridview'", FoodsGridView.class);
        t.mDoc1 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc1, "field 'mDoc1'", TextView.class);
        t.mDoc2 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc2, "field 'mDoc2'", TextView.class);
        t.mDiv = finder.findRequiredView(obj, R.id.div, "field 'mDiv'");
        t.mDoc3 = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.doc3, "field 'mDoc3'", RelativeLayout.class);
        t.mDoc31 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_1, "field 'mDoc31'", TextView.class);
        t.mDoc321 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_2_1, "field 'mDoc321'", ImageView.class);
        t.mDoc322 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_2_2, "field 'mDoc322'", TextView.class);
        t.mDoc331 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_3_1, "field 'mDoc331'", ImageView.class);
        t.mDoc332 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_3_2, "field 'mDoc332'", TextView.class);
        t.mDoc341 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_4_1, "field 'mDoc341'", ImageView.class);
        t.mDoc342 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_4_2, "field 'mDoc342'", TextView.class);
        t.mDoc351 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_5_1, "field 'mDoc351'", ImageView.class);
        t.mDoc352 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_5_2, "field 'mDoc352'", TextView.class);
        t.mDoc361 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_6_1, "field 'mDoc361'", ImageView.class);
        t.mDoc362 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_6_2, "field 'mDoc362'", TextView.class);
        t.mDoc371 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_7_1, "field 'mDoc371'", ImageView.class);
        t.mDoc372 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_7_2, "field 'mDoc372'", TextView.class);
        t.mDoc381 = (ImageView) finder.findRequiredViewAsType(obj, R.id.doc3_8_1, "field 'mDoc381'", ImageView.class);
        t.mDoc382 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc3_8_2, "field 'mDoc382'", TextView.class);
    }

    public void unbind() {
        DistributionFragment distributionFragment = this.a;
        if (distributionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        distributionFragment.mCtvTabBtnWeek = null;
        distributionFragment.mCtvTabBtnDay = null;
        distributionFragment.mDate = null;
        distributionFragment.mEmptyLayout = null;
        distributionFragment.mLayoutContent = null;
        distributionFragment.mQuarter1Text = null;
        distributionFragment.mQuarter1Gridview = null;
        distributionFragment.mQuarter2Text = null;
        distributionFragment.mQuarter2Gridview = null;
        distributionFragment.mQuarter3Text = null;
        distributionFragment.mQuarter3Gridview = null;
        distributionFragment.mQuarter4Text = null;
        distributionFragment.mQuarter4Gridview = null;
        distributionFragment.mDoc1 = null;
        distributionFragment.mDoc2 = null;
        distributionFragment.mDiv = null;
        distributionFragment.mDoc3 = null;
        distributionFragment.mDoc31 = null;
        distributionFragment.mDoc321 = null;
        distributionFragment.mDoc322 = null;
        distributionFragment.mDoc331 = null;
        distributionFragment.mDoc332 = null;
        distributionFragment.mDoc341 = null;
        distributionFragment.mDoc342 = null;
        distributionFragment.mDoc351 = null;
        distributionFragment.mDoc352 = null;
        distributionFragment.mDoc361 = null;
        distributionFragment.mDoc362 = null;
        distributionFragment.mDoc371 = null;
        distributionFragment.mDoc372 = null;
        distributionFragment.mDoc381 = null;
        distributionFragment.mDoc382 = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.a = null;
    }
}
