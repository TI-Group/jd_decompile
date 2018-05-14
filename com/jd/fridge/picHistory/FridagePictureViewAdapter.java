package com.jd.fridge.picHistory;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FridagePictureViewAdapter extends PagerAdapter {
    private List<View> a;

    public FridagePictureViewAdapter(List<View> list) {
        this.a = list;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.a.get(i));
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.a.get(i));
        return this.a.get(i);
    }

    public int getCount() {
        return this.a.size();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
