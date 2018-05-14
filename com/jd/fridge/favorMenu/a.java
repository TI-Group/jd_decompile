package com.jd.fridge.favorMenu;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;

/* compiled from: TbsSdkJava */
public class a<T extends FridgeGoodsActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        t.mFridgeImgVP = (ViewPager) finder.findRequiredViewAsType(obj, R.id.fridgeImgVP, "field 'mFridgeImgVP'", ViewPager.class);
        t.mFridgeImgCPI = (CirclePageIndicator) finder.findRequiredViewAsType(obj, R.id.fridgeImgCPI, "field 'mFridgeImgCPI'", CirclePageIndicator.class);
        t.mImgTime = (TextView) finder.findRequiredViewAsType(obj, R.id.img_time, "field 'mImgTime'", TextView.class);
        t.mShareBtn = (ImageView) finder.findRequiredViewAsType(obj, R.id.share_btn, "field 'mShareBtn'", ImageView.class);
        t.fridge_inner_picture_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.fridge_inner_picture_layout, "field 'fridge_inner_picture_layout'", RelativeLayout.class);
    }

    public void unbind() {
        FridgeGoodsActivity fridgeGoodsActivity = this.a;
        if (fridgeGoodsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        fridgeGoodsActivity.mEmptyLayout = null;
        fridgeGoodsActivity.mFridgeImgVP = null;
        fridgeGoodsActivity.mFridgeImgCPI = null;
        fridgeGoodsActivity.mImgTime = null;
        fridgeGoodsActivity.mShareBtn = null;
        fridgeGoodsActivity.fridge_inner_picture_layout = null;
        this.a = null;
    }
}
