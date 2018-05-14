package com.jd.fridge.food;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.GoodsGridView;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;

/* compiled from: TbsSdkJava */
public class b<T extends FoodFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;

    public b(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.notice_btn, "field 'mNoticeBtn' and method 'onClick'");
        t.mNoticeBtn = (ImageView) finder.castView(findRequiredView, R.id.notice_btn, "field 'mNoticeBtn'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        t.mFoodTitleTxt = (TextView) finder.findRequiredViewAsType(obj, R.id.food_title_txt, "field 'mFoodTitleTxt'", TextView.class);
        findRequiredView = finder.findRequiredView(obj, R.id.nutrition_btn, "field 'mNutritionBtn' and method 'onClick'");
        t.mNutritionBtn = (ImageView) finder.castView(findRequiredView, R.id.nutrition_btn, "field 'mNutritionBtn'", ImageView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        t.mNoticeNum = (TextView) finder.findRequiredViewAsType(obj, R.id.notice_num, "field 'mNoticeNum'", TextView.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        t.mFridgeImgVP = (ViewPager) finder.findRequiredViewAsType(obj, R.id.fridgeImgVP, "field 'mFridgeImgVP'", ViewPager.class);
        t.mFridgeImgCPI = (CirclePageIndicator) finder.findRequiredViewAsType(obj, R.id.fridgeImgCPI, "field 'mFridgeImgCPI'", CirclePageIndicator.class);
        t.mImgTime = (TextView) finder.findRequiredViewAsType(obj, R.id.img_time, "field 'mImgTime'", TextView.class);
        t.mShareBtn = (ImageView) finder.findRequiredViewAsType(obj, R.id.share_btn, "field 'mShareBtn'", ImageView.class);
        t.fridge_inner_picture_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.fridge_inner_picture_layout, "field 'fridge_inner_picture_layout'", RelativeLayout.class);
        t.data_layout = (ScrollView) finder.findRequiredViewAsType(obj, R.id.data_layout, "field 'data_layout'", ScrollView.class);
        t.recommend_tip = finder.findRequiredView(obj, R.id.recommend_tip, "field 'recommend_tip'");
        t.recommend_goodsList = (FrameLayout) finder.findRequiredViewAsType(obj, R.id.recommend_goodsList, "field 'recommend_goodsList'", FrameLayout.class);
        t.goodsGridView = (GoodsGridView) finder.findRequiredViewAsType(obj, R.id.goodsGridView, "field 'goodsGridView'", GoodsGridView.class);
        t.hxCameraLayout = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.hx_fridge_camera_layout, "field 'hxCameraLayout'", LinearLayout.class);
        t.hxCameraTimeText = (TextView) finder.findRequiredViewAsType(obj, R.id.hx_fridge_time_text, "field 'hxCameraTimeText'", TextView.class);
        t.cameraBreakLayout = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.camera_break_layout, "field 'cameraBreakLayout'", LinearLayout.class);
        t.cameraTopImage = (ImageView) finder.findRequiredViewAsType(obj, R.id.camera_top_image, "field 'cameraTopImage'", ImageView.class);
    }

    public void unbind() {
        FoodFragment foodFragment = this.a;
        if (foodFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        foodFragment.mNoticeBtn = null;
        foodFragment.mFoodTitleTxt = null;
        foodFragment.mNutritionBtn = null;
        foodFragment.mNoticeNum = null;
        foodFragment.mEmptyLayout = null;
        foodFragment.mFridgeImgVP = null;
        foodFragment.mFridgeImgCPI = null;
        foodFragment.mImgTime = null;
        foodFragment.mShareBtn = null;
        foodFragment.fridge_inner_picture_layout = null;
        foodFragment.data_layout = null;
        foodFragment.recommend_tip = null;
        foodFragment.recommend_goodsList = null;
        foodFragment.goodsGridView = null;
        foodFragment.hxCameraLayout = null;
        foodFragment.hxCameraTimeText = null;
        foodFragment.cameraBreakLayout = null;
        foodFragment.cameraTopImage = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.a = null;
    }
}
