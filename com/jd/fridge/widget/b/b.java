package com.jd.fridge.widget.b;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodDishListDataBean;
import com.jd.fridge.util.aa;
import java.util.List;

/* compiled from: TbsSdkJava */
public class b extends PopupWindow implements com.jd.fridge.food.a.a.a {
    private TextView a;
    private LinearLayout b;
    private Activity c;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(List<FoodDishListDataBean> list, FoodDishListDataBean foodDishListDataBean, boolean z);
    }

    private void a(View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.c, R.anim.addfood_pop_out);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                aa.a(this.a.c, 1.0f);
                this.a.a();
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void dismiss() {
        a(this.b);
    }

    private void a() {
        super.dismiss();
    }

    public void a(int i) {
        this.a.setText(String.valueOf(i));
    }
}
