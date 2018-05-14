package com.jd.fridge.food.a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodCategoryListDataBean;
import java.util.List;

/* compiled from: TbsSdkJava */
public class b extends BaseAdapter {
    private Context a;
    private LayoutInflater b;
    private List<FoodCategoryListDataBean> c;
    private FoodCategoryListDataBean d;

    /* compiled from: TbsSdkJava */
    private static class a {
        TextView a;

        private a() {
        }
    }

    public b(Context context, List<FoodCategoryListDataBean> list, FoodCategoryListDataBean foodCategoryListDataBean) {
        this.a = context;
        this.c = list;
        this.d = foodCategoryListDataBean;
        this.b = LayoutInflater.from(context);
    }

    public void a(FoodCategoryListDataBean foodCategoryListDataBean) {
        this.d = foodCategoryListDataBean;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.c != null ? this.c.size() : 0;
    }

    public Object getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            a aVar = new a();
            view = this.b.inflate(R.layout.food_category_adpater_layout, viewGroup, false);
            aVar.a = (TextView) view.findViewById(R.id.category_name_textView);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        FoodCategoryListDataBean foodCategoryListDataBean = (FoodCategoryListDataBean) this.c.get(i);
        if (foodCategoryListDataBean != null) {
            aVar2.a.setText(foodCategoryListDataBean.getCategory_name());
            if (this.d == null || this.d.getCategory_id() != foodCategoryListDataBean.getCategory_id()) {
                aVar2.a.setTextColor(ContextCompat.getColor(this.a, R.color.jd_gray_8));
                aVar2.a.setBackgroundResource(R.color.jd_fridge_app_gray_bg_color);
            } else {
                aVar2.a.setTextColor(ContextCompat.getColor(this.a, R.color.jd_fridge_friend_activity_tab_highlight_color));
                aVar2.a.setBackgroundResource(R.drawable.bg_category_pressed);
            }
        }
        return view;
    }
}
