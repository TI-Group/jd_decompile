package com.jd.fridge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.jd.fridge.login.LoginActivity;
import com.jd.fridge.util.aa;

/* compiled from: TbsSdkJava */
public class GuideFragment extends Fragment {
    public static boolean a = false;
    private int b;
    private int c;

    public static GuideFragment a(int i, int i2) {
        GuideFragment guideFragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("param1", i);
        bundle.putInt("param2", i2);
        guideFragment.setArguments(bundle);
        return guideFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.b = getArguments().getInt("param1");
            this.c = getArguments().getInt("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.guide_view_item, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_guide_item);
        imageView.setImageDrawable(getResources().getDrawable(this.c));
        if (this.b == 3) {
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ GuideFragment a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    boolean booleanExtra = this.a.getActivity().getIntent().getBooleanExtra("need_login", false);
                    GuideFragment.a = ((GlobalVariable) this.a.getActivity().getApplication()).A();
                    ((GlobalVariable) this.a.getActivity().getApplication()).f(false);
                    if (booleanExtra) {
                        this.a.startActivity(new Intent(this.a.getContext(), LoginActivity.class));
                    } else if (((GlobalVariable) this.a.getActivity().getApplication()).u()) {
                        aa.a(this.a.getActivity(), 1, null);
                    } else {
                        aa.a(this.a.getActivity());
                    }
                    this.a.getActivity().finish();
                }
            });
        }
    }
}
