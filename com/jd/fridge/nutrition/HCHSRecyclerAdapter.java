package com.jd.fridge.nutrition;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.HGHCItemDataBean;
import com.jd.fridge.bean.NutritionFoodDataBean;
import com.jd.fridge.util.y;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class HCHSRecyclerAdapter extends Adapter<HCHSHolder> {
    private final Context a;
    private List<HGHCItemDataBean> b = new ArrayList();

    /* compiled from: TbsSdkJava */
    public class HCHSHolder extends ViewHolder {
        public LinearLayout a;
        public TextView b;
        final /* synthetic */ HCHSRecyclerAdapter c;

        public HCHSHolder(HCHSRecyclerAdapter hCHSRecyclerAdapter, View view) {
            this.c = hCHSRecyclerAdapter;
            super(view);
            this.a = (LinearLayout) view.findViewById(R.id.container_foods);
            this.b = (TextView) view.findViewById(R.id.date);
        }
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((HCHSHolder) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public void a(List<HGHCItemDataBean> list) {
        this.b = list;
    }

    public HCHSRecyclerAdapter(Context context) {
        this.a = context;
    }

    public HCHSHolder a(ViewGroup viewGroup, int i) {
        return new HCHSHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hchs, null));
    }

    public void a(HCHSHolder hCHSHolder, int i) {
        HGHCItemDataBean hGHCItemDataBean = (HGHCItemDataBean) this.b.get((this.b.size() - 1) - i);
        hCHSHolder.b.setText(y.a(hGHCItemDataBean.getDate()));
        if (hGHCItemDataBean.getGoods() == null || hGHCItemDataBean.getGoods().size() <= 0) {
            hCHSHolder.a.setVisibility(8);
            return;
        }
        hCHSHolder.a.setVisibility(0);
        hCHSHolder.a.removeAllViews();
        for (NutritionFoodDataBean nutritionFoodDataBean : hGHCItemDataBean.getGoods()) {
            ImageView imageView = new ImageView(this.a);
            a(nutritionFoodDataBean.getIcon_url(), imageView);
            imageView.setScaleType(ScaleType.FIT_XY);
            int a = y.a(24.0f, GlobalVariable.a().p());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
            layoutParams.setMargins(0, y.a(5.0f, GlobalVariable.a().p()), 0, 0);
            hCHSHolder.a.addView(imageView, layoutParams);
        }
    }

    public int getItemCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    private void a(String str, ImageView imageView) {
        ImageLoader.getInstance().displayImage(str, imageView);
    }
}
