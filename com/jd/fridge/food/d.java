package com.jd.fridge.food;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class d<T extends SearchFoodActivity> implements Unbinder {
    protected T a;

    public d(T t, Finder finder, Object obj) {
        this.a = t;
        t.searchEditText = (EditText) finder.findRequiredViewAsType(obj, R.id.search_food_search_editText, "field 'searchEditText'", EditText.class);
        t.backImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.search_food_back_imageView, "field 'backImageView'", ImageView.class);
        t.closeImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.search_food_close_imageView, "field 'closeImageView'", ImageView.class);
        t.searchListView = (ListView) finder.findRequiredViewAsType(obj, R.id.search_food_search_listView, "field 'searchListView'", ListView.class);
        t.dividerView = finder.findRequiredView(obj, R.id.divider_view, "field 'dividerView'");
        t.noResultLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.search_food_no_result_layout, "field 'noResultLayout'", RelativeLayout.class);
    }

    public void unbind() {
        SearchFoodActivity searchFoodActivity = this.a;
        if (searchFoodActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        searchFoodActivity.searchEditText = null;
        searchFoodActivity.backImageView = null;
        searchFoodActivity.closeImageView = null;
        searchFoodActivity.searchListView = null;
        searchFoodActivity.dividerView = null;
        searchFoodActivity.noResultLayout = null;
        this.a = null;
    }
}
