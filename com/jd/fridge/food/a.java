package com.jd.fridge.food;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/* compiled from: TbsSdkJava */
public class a<T extends FoodAddAlarmActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.categoryListView = (ListView) finder.findRequiredViewAsType(obj, R.id.category_listView, "field 'categoryListView'", ListView.class);
        t.dishListView = (StickyListHeadersListView) finder.findRequiredViewAsType(obj, R.id.dish_listView, "field 'dishListView'", StickyListHeadersListView.class);
        t.rootLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.activity_food_add_alarm_root_layout, "field 'rootLayout'", RelativeLayout.class);
        t.fridgeImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_bottom_layout_fridge_imageView, "field 'fridgeImageView'", ImageView.class);
        t.searchEditText = (EditText) finder.findRequiredViewAsType(obj, R.id.activity_food_add_alarm_search_editText, "field 'searchEditText'", EditText.class);
        t.pointTextView = (TextView) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_bottom_left_layout_point_textView, "field 'pointTextView'", TextView.class);
        t.confirmTextView = (TextView) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_bottom_layout_confirm_textView, "field 'confirmTextView'", TextView.class);
        t.bottomLeftLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_bottom_left_layout, "field 'bottomLeftLayout'", RelativeLayout.class);
        t.mEmptyLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout_root, "field 'mEmptyLayout'", RelativeLayout.class);
        t.mEmptyLayoutRoot = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayoutRoot'", EmptyLayout.class);
        t.bottomLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_bottom_layout, "field 'bottomLayout'", RelativeLayout.class);
        t.progressBar = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.progress_loading, "field 'progressBar'", ProgressBar.class);
        t.popupLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_popup_layout, "field 'popupLayout'", RelativeLayout.class);
        t.clearTextView = (TextView) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_popup_window_clear_textView, "field 'clearTextView'", TextView.class);
        t.popupListView = (ListView) finder.findRequiredViewAsType(obj, R.id.food_add_alarm_popup_window_listView, "field 'popupListView'", ListView.class);
        t.titleTextView = (TextView) finder.findRequiredViewAsType(obj, R.id.app_title_textview, "field 'titleTextView'", TextView.class);
        t.leftIconBtn = (ImageView) finder.findRequiredViewAsType(obj, R.id.left_appbar_btn, "field 'leftIconBtn'", ImageView.class);
        t.searchLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.activity_food_add_alarm_search_layout, "field 'searchLayout'", RelativeLayout.class);
    }

    public void unbind() {
        FoodAddAlarmActivity foodAddAlarmActivity = this.a;
        if (foodAddAlarmActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        foodAddAlarmActivity.categoryListView = null;
        foodAddAlarmActivity.dishListView = null;
        foodAddAlarmActivity.rootLayout = null;
        foodAddAlarmActivity.fridgeImageView = null;
        foodAddAlarmActivity.searchEditText = null;
        foodAddAlarmActivity.pointTextView = null;
        foodAddAlarmActivity.confirmTextView = null;
        foodAddAlarmActivity.bottomLeftLayout = null;
        foodAddAlarmActivity.mEmptyLayout = null;
        foodAddAlarmActivity.mEmptyLayoutRoot = null;
        foodAddAlarmActivity.bottomLayout = null;
        foodAddAlarmActivity.progressBar = null;
        foodAddAlarmActivity.popupLayout = null;
        foodAddAlarmActivity.clearTextView = null;
        foodAddAlarmActivity.popupListView = null;
        foodAddAlarmActivity.titleTextView = null;
        foodAddAlarmActivity.leftIconBtn = null;
        foodAddAlarmActivity.searchLayout = null;
        this.a = null;
    }
}
