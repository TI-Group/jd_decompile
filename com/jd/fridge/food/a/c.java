package com.jd.fridge.food.a;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodCategoryListDataBean;
import com.jd.fridge.bean.FoodDishListDataBean;
import com.jd.fridge.util.r;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import se.emilsjolander.stickylistheaders.g;

/* compiled from: TbsSdkJava */
public class c extends BaseAdapter implements g {
    private Context a;
    private LayoutInflater b;
    private List<FoodDishListDataBean> c;
    private List<FoodCategoryListDataBean> d;
    private b e;
    private FoodDishListDataBean f;

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(View view, ImageView imageView, FoodDishListDataBean foodDishListDataBean);
    }

    /* compiled from: TbsSdkJava */
    private static class a {
        TextView a;

        private a() {
        }
    }

    /* compiled from: TbsSdkJava */
    private static class c {
        ImageView a;
        TextView b;
        TextView c;
        ImageView d;

        private c() {
        }
    }

    public c(Context context, List<FoodDishListDataBean> list, List<FoodCategoryListDataBean> list2) {
        this.a = context;
        this.c = list;
        this.d = list2;
        this.b = LayoutInflater.from(context);
    }

    public void setAddAlarmClickListener(b bVar) {
        this.e = bVar;
    }

    public void a(FoodDishListDataBean foodDishListDataBean) {
        this.f = foodDishListDataBean;
        notifyDataSetChanged();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = this.b.inflate(R.layout.food_dish_adapter_header_layout, viewGroup, false);
            aVar.a = (TextView) view.findViewById(R.id.header_category_name_textView);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        FoodDishListDataBean foodDishListDataBean = (FoodDishListDataBean) this.c.get(i);
        if (!(foodDishListDataBean == null || foodDishListDataBean.getCategoryBean() == null)) {
            aVar.a.setText(foodDishListDataBean.getCategoryBean().getCategory_name() + " ( " + foodDishListDataBean.getCategoryBean().getCount() + " )");
        }
        return view;
    }

    public long a(int i) {
        return (long) this.d.indexOf(((FoodDishListDataBean) this.c.get(i)).getCategoryBean());
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
        c cVar;
        if (view == null) {
            cVar = new c();
            view = this.b.inflate(R.layout.food_dish_adapter_layout, viewGroup, false);
            cVar.a = (ImageView) view.findViewById(R.id.dish_left_imageView);
            cVar.b = (TextView) view.findViewById(R.id.dish_name_textView);
            cVar.c = (TextView) view.findViewById(R.id.dish_expire_textView);
            cVar.d = (ImageView) view.findViewById(R.id.dish_right_button);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        final FoodDishListDataBean foodDishListDataBean = (FoodDishListDataBean) this.c.get(i);
        if (foodDishListDataBean != null) {
            int default_expire;
            String expire_date;
            ImageLoader.getInstance().displayImage(foodDishListDataBean.getImg_url(), cVar.a);
            cVar.b.setText(foodDishListDataBean.getGoods_name());
            if (this.f == null || this.f.getGoods_id() != foodDishListDataBean.getGoods_id()) {
                cVar.b.setTextColor(ContextCompat.getColor(this.a, R.color.jd_gray_3));
            } else {
                cVar.b.setTextColor(ContextCompat.getColor(this.a, R.color.food_dish_adapter_right_button_add_textColor));
            }
            if (foodDishListDataBean.getCategory_id() < 0) {
                default_expire = foodDishListDataBean.getDefault_expire();
            } else {
                default_expire = foodDishListDataBean.getDefault_expired();
            }
            if (foodDishListDataBean.getCategory_id() < 0) {
                expire_date = foodDishListDataBean.getExpire_date();
            } else {
                expire_date = foodDishListDataBean.getExpired();
            }
            r.c("infos", "name=" + foodDishListDataBean.getGoods_name() + "==hasalarm==" + foodDishListDataBean.isHas_alarm() + "==expired===" + expire_date + "==id==" + foodDishListDataBean.getGoods_id());
            if (foodDishListDataBean.isHas_alarm()) {
                cVar.d.setBackgroundResource(R.drawable.ic_addfood_aladd);
                cVar.d.setEnabled(false);
                if (TextUtils.isEmpty(a(expire_date))) {
                    cVar.c.setText(this.a.getResources().getString(R.string.food_dish_adapter_layout_expire_no_alarm, new Object[]{Integer.valueOf(default_expire), b(foodDishListDataBean.getDefault_expire_unit())}));
                } else {
                    cVar.c.setText(this.a.getResources().getString(R.string.food_dish_adapter_layout_expire_has_alarm, new Object[]{a(expire_date)}));
                }
            } else {
                cVar.d.setBackgroundResource(R.drawable.ic_addfood_add);
                cVar.d.setEnabled(true);
                cVar.c.setText(this.a.getResources().getString(R.string.food_dish_adapter_layout_expire_no_alarm, new Object[]{Integer.valueOf(default_expire), b(foodDishListDataBean.getDefault_expire_unit())}));
            }
            cVar.d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c c;

                public void onClick(View view) {
                    cVar.d.setEnabled(false);
                    cVar.d.setBackgroundResource(R.drawable.ic_addfood_aladd);
                    foodDishListDataBean.setHas_alarm(true);
                    for (FoodDishListDataBean foodDishListDataBean : this.c.c) {
                        if (foodDishListDataBean.getGoods_id() == foodDishListDataBean.getGoods_id()) {
                            foodDishListDataBean.setHas_alarm(true);
                        }
                    }
                    if (this.c.e != null) {
                        this.c.e.a(view, cVar.a, foodDishListDataBean);
                    }
                }
            });
        }
        return view;
    }

    private String a(String str) {
        String str2 = "";
        if (str == null) {
            return str2;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int time = (((int) ((simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(simpleDateFormat.format(new Date(System.currentTimeMillis()))).getTime()) / 60000)) / 60) / 24;
            if (time < 0) {
                return this.a.getResources().getString(R.string.food_dish_adapter_layout_outdate);
            }
            if (time == 0) {
                return this.a.getResources().getString(R.string.food_dish_adapter_layout_today);
            }
            return time + this.a.getResources().getString(R.string.day);
        } catch (ParseException e) {
            e.printStackTrace();
            return str2;
        }
    }

    private String b(int i) {
        switch (i) {
            case 0:
                return this.a.getResources().getString(R.string.day);
            case 1:
                return this.a.getResources().getString(R.string.week);
            case 2:
                return this.a.getResources().getString(R.string.month);
            case 3:
                return this.a.getResources().getString(R.string.year);
            default:
                return this.a.getResources().getString(R.string.day);
        }
    }
}
