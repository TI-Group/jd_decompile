package com.jd.fridge.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: TbsSdkJava */
public class BgFragment extends Fragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = getArguments().getInt("resId");
        View imageView = new ImageView(getActivity());
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setImageResource(i);
        return imageView;
    }
}
