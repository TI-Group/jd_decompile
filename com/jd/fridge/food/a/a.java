package com.jd.fridge.food.a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodDishListDataBean;
import com.jd.fridge.util.aa;
import com.jd.fridge.widget.RulerWheel;
import java.util.List;

/* compiled from: TbsSdkJava */
public class a extends BaseAdapter {
    private List<FoodDishListDataBean> a;
    private Context b;
    private LayoutInflater c;
    private a d;
    private com.jd.fridge.widget.b.b.a e;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(int i);
    }

    /* compiled from: TbsSdkJava */
    private static class b {
        TextView a;
        TextView b;
        TextView c;
        ImageView d;
        RulerWheel e;
        TextView f;
        TextView g;

        private b() {
        }
    }

    public a(Context context, List<FoodDishListDataBean> list, com.jd.fridge.widget.b.b.a aVar) {
        this.b = context;
        this.a = list;
        this.e = aVar;
        this.c = LayoutInflater.from(context);
    }

    public void setUpdateSizeListener(a aVar) {
        this.d = aVar;
    }

    public int getCount() {
        return this.a != null ? this.a.size() : 0;
    }

    public Object getItem(int i) {
        return this.a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = this.c.inflate(R.layout.food_add_alarm_pop_adapter_layout, viewGroup, false);
            bVar.a = (TextView) view.findViewById(R.id.food_add_alarm_pop_name_textView);
            bVar.b = (TextView) view.findViewById(R.id.food_add_alarm_pop_time_textView);
            bVar.c = (TextView) view.findViewById(R.id.food_add_alarm_pop_unit_textView);
            bVar.d = (ImageView) view.findViewById(R.id.food_add_alarm_pop_close_imageView);
            bVar.e = (RulerWheel) view.findViewById(R.id.ruler_view);
            bVar.f = (TextView) view.findViewById(R.id.food_add_alarm_pop_day_textView);
            bVar.g = (TextView) view.findViewById(R.id.food_add_alarm_pop_month_textView);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final FoodDishListDataBean foodDishListDataBean = (FoodDishListDataBean) this.a.get(i);
        if (foodDishListDataBean != null) {
            CharSequence string;
            int default_expire;
            bVar.a.setText(foodDishListDataBean.getGoods_name());
            TextView textView = bVar.c;
            if (foodDishListDataBean.getDefault_expire_unit() == 2) {
                string = this.b.getResources().getString(R.string.month);
            } else {
                string = this.b.getResources().getString(R.string.day);
            }
            textView.setText(string);
            bVar.d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a b;

                public void onClick(View view) {
                    this.b.a.remove(foodDishListDataBean);
                    if (this.b.e != null) {
                        this.b.e.a(this.b.a, foodDishListDataBean, true);
                    }
                    if (this.b.d != null) {
                        this.b.d.a(this.b.a.size());
                    }
                    this.b.notifyDataSetChanged();
                }
            });
            if (foodDishListDataBean.getCategory_id() < 0) {
                default_expire = foodDishListDataBean.getDefault_expire();
            } else {
                default_expire = foodDishListDataBean.getDefault_expired();
            }
            if (foodDishListDataBean.getDefault_expire_unit() == 2) {
                bVar.e.setData(aa.a(false));
                bVar.g.setTextColor(ContextCompat.getColor(this.b, R.color.food_add_alarm_pop_adapter_color));
                bVar.g.getPaint().setFlags(8);
                bVar.g.setEnabled(false);
                bVar.f.setTextColor(ContextCompat.getColor(this.b, R.color.jd_gray_5));
                bVar.f.getPaint().setFlags(0);
                bVar.f.setEnabled(true);
                if (default_expire > 12) {
                    default_expire = 12;
                }
            } else {
                bVar.e.setData(aa.a(true));
                bVar.f.setTextColor(ContextCompat.getColor(this.b, R.color.food_add_alarm_pop_adapter_color));
                bVar.f.getPaint().setFlags(8);
                bVar.f.setEnabled(false);
                bVar.g.setTextColor(ContextCompat.getColor(this.b, R.color.jd_gray_5));
                bVar.g.getPaint().setFlags(0);
                bVar.g.setEnabled(true);
                if (default_expire > 360) {
                    default_expire = 360;
                }
            }
            if (default_expire < 1) {
                default_expire = 1;
            }
            bVar.b.setText(String.valueOf(default_expire));
            if (foodDishListDataBean.getCategory_id() < 0) {
                foodDishListDataBean.setDefault_expire(default_expire);
            } else {
                foodDishListDataBean.setDefault_expired(default_expire);
            }
            if (this.e != null) {
                this.e.a(this.a, foodDishListDataBean, false);
            }
            bVar.e.setSelectedValue(String.valueOf(default_expire));
            bVar.e.setScrollingListener(new com.jd.fridge.widget.RulerWheel.a(this) {
                final /* synthetic */ a c;

                public void a(RulerWheel rulerWheel, Object obj, Object obj2) {
                    bVar.b.setText((String) obj2);
                    if (foodDishListDataBean.getCategory_id() < 0) {
                        foodDishListDataBean.setDefault_expire(Integer.parseInt((String) obj2));
                    } else {
                        foodDishListDataBean.setDefault_expired(Integer.parseInt((String) obj2));
                    }
                }

                public void a(RulerWheel rulerWheel) {
                }

                public void b(RulerWheel rulerWheel) {
                }
            });
            bVar.g.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a c;

                public void onClick(View view) {
                    bVar.g.setTextColor(ContextCompat.getColor(this.c.b, R.color.food_add_alarm_pop_adapter_color));
                    bVar.g.getPaint().setFlags(8);
                    bVar.g.setEnabled(false);
                    bVar.f.setTextColor(ContextCompat.getColor(this.c.b, R.color.jd_gray_5));
                    bVar.f.getPaint().setFlags(0);
                    bVar.f.setEnabled(true);
                    bVar.b.setText("1");
                    bVar.c.setText(this.c.b.getResources().getString(R.string.month));
                    bVar.e.setData(aa.a(false));
                    bVar.e.setSelectedValue("1");
                    if (foodDishListDataBean.getCategory_id() < 0) {
                        foodDishListDataBean.setDefault_expire(1);
                    } else {
                        foodDishListDataBean.setDefault_expired(1);
                    }
                    foodDishListDataBean.setDefault_expire_unit(2);
                    if (this.c.e != null) {
                        this.c.e.a(this.c.a, foodDishListDataBean, false);
                    }
                }
            });
            bVar.f.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a c;

                public void onClick(View view) {
                    bVar.f.setTextColor(ContextCompat.getColor(this.c.b, R.color.food_add_alarm_pop_adapter_color));
                    bVar.f.getPaint().setFlags(8);
                    bVar.f.setEnabled(false);
                    bVar.g.setTextColor(ContextCompat.getColor(this.c.b, R.color.jd_gray_5));
                    bVar.g.getPaint().setFlags(0);
                    bVar.g.setEnabled(true);
                    bVar.b.setText("1");
                    bVar.c.setText(this.c.b.getResources().getString(R.string.day));
                    bVar.e.setData(aa.a(true));
                    bVar.e.setSelectedValue("1");
                    if (foodDishListDataBean.getCategory_id() < 0) {
                        foodDishListDataBean.setDefault_expire(1);
                    } else {
                        foodDishListDataBean.setDefault_expired(1);
                    }
                    foodDishListDataBean.setDefault_expire_unit(0);
                    if (this.c.e != null) {
                        this.c.e.a(this.c.a, foodDishListDataBean, false);
                    }
                }
            });
        }
        return view;
    }
}
