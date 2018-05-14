package com.jd.fridge.nutrition;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NutritionFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> a = new ArrayList();

    public NutritionFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public Fragment getItem(int i) {
        return (Fragment) this.a.get(i);
    }

    public int getCount() {
        return this.a.size();
    }
}
