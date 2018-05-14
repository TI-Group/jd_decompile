package com.jd.fridge.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.nostra13.universalimageloader.core.ImageLoader;

/* compiled from: TbsSdkJava */
public class FridgeImageFragment extends Fragment {
    private String a;
    private String b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.a = getArguments().getString("url");
            this.b = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ScaleType.FIT_XY);
        ImageLoader.getInstance().displayImage(this.a, imageView);
        return imageView;
    }
}
