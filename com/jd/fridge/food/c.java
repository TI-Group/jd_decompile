package com.jd.fridge.food;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class c<T extends FoodNoCameraFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;

    public c(final T t, Finder finder, Object obj) {
        this.a = t;
        t.ll_content = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.ll_content, "field 'll_content'", LinearLayout.class);
        t.food_clock_recycler_view = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.food_clock_recycler_view, "field 'food_clock_recycler_view'", RecyclerView.class);
        View findRequiredView = finder.findRequiredView(obj, R.id.add_food_img, "field 'add_food_img' and method 'addGoodsClick'");
        t.add_food_img = (ImageView) finder.castView(findRequiredView, R.id.add_food_img, "field 'add_food_img'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.addGoodsClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.cancle_select_tv, "field 'cancle_select_tv' and method 'cancleSelectClick'");
        t.cancle_select_tv = (TextView) finder.castView(findRequiredView, R.id.cancle_select_tv, "field 'cancle_select_tv'", TextView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.cancleSelectClick(view);
            }
        });
        t.foods_list_view = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.foods_list_view, "field 'foods_list_view'", LinearLayout.class);
        t.no_foods_view = (TextView) finder.findRequiredViewAsType(obj, R.id.no_foods_view, "field 'no_foods_view'", TextView.class);
        findRequiredView = finder.findRequiredView(obj, R.id.notice_btn, "field 'notice_btn' and method 'noticeClick'");
        t.notice_btn = (ImageView) finder.castView(findRequiredView, R.id.notice_btn, "field 'notice_btn'", ImageView.class);
        this.d = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.noticeClick(view);
            }
        });
        t.notice_num = (TextView) finder.findRequiredViewAsType(obj, R.id.notice_num, "field 'notice_num'", TextView.class);
        t.food_title_txt = (TextView) finder.findRequiredViewAsType(obj, R.id.food_title_txt, "field 'food_title_txt'", TextView.class);
    }

    public void unbind() {
        FoodNoCameraFragment foodNoCameraFragment = this.a;
        if (foodNoCameraFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        foodNoCameraFragment.ll_content = null;
        foodNoCameraFragment.food_clock_recycler_view = null;
        foodNoCameraFragment.add_food_img = null;
        foodNoCameraFragment.cancle_select_tv = null;
        foodNoCameraFragment.foods_list_view = null;
        foodNoCameraFragment.no_foods_view = null;
        foodNoCameraFragment.notice_btn = null;
        foodNoCameraFragment.notice_num = null;
        foodNoCameraFragment.food_title_txt = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.a = null;
    }
}
