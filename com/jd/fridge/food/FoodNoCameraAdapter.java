package com.jd.fridge.food;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodsAlarmBaseBean;
import com.jd.fridge.util.g;
import com.jd.fridge.util.p;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FoodNoCameraAdapter extends Adapter<ViewHolder> {
    private static final String a = FoodNoCameraAdapter.class.getSimpleName();
    private Context b;
    private List<FoodsAlarmBaseBean> c;
    private b d;
    private SparseBooleanArray e = new SparseBooleanArray();
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private int i;
    private int j;
    private int k;

    /* compiled from: TbsSdkJava */
    class a extends ViewHolder {
        public View a;
        public ImageView b;
        public ImageView c;
        public TextView d;
        public TextView e;
        final /* synthetic */ FoodNoCameraAdapter f;

        public a(FoodNoCameraAdapter foodNoCameraAdapter, View view) {
            this.f = foodNoCameraAdapter;
            super(view);
            this.a = view;
            this.b = (ImageView) view.findViewById(R.id.selected_img);
            this.c = (ImageView) view.findViewById(R.id.food_icon_iv);
            this.d = (TextView) view.findViewById(R.id.food_info_tv);
            this.e = (TextView) view.findViewById(R.id.colck_data_tv);
        }
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(View view, int i);

        void b(View view, int i);
    }

    public FoodNoCameraAdapter(Context context, List<FoodsAlarmBaseBean> list) {
        this.b = context;
        this.c = list;
        a(context);
    }

    public void a(List<FoodsAlarmBaseBean> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    private void a(Context context) {
        this.f = ContextCompat.getDrawable(context, R.drawable.bg_food_clock_data_green);
        this.g = ContextCompat.getDrawable(context, R.drawable.bg_food_clock_data_range);
        this.h = ContextCompat.getDrawable(context, R.drawable.bg_food_clock_data_red);
        this.i = ContextCompat.getColor(context, R.color.jd_green_4);
        this.j = ContextCompat.getColor(context, R.color.jd_clock_solid_range);
        this.k = ContextCompat.getColor(context, R.color.jd_red_4);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.b).inflate(R.layout.food_no_camera_item_layout, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        a aVar = (a) viewHolder;
        aVar.d.setText(a(((FoodsAlarmBaseBean) this.c.get(i)).getGoods_name(), ""));
        ImageLoader.getInstance().displayImage(a(((FoodsAlarmBaseBean) this.c.get(i)).getImg_url(), ""), aVar.c);
        long b = g.b(a(((FoodsAlarmBaseBean) this.c.get(i)).getAlarm_date(), ""));
        p.b(a, "相差: " + b);
        CharSequence charSequence = b + "天";
        if (b <= 0) {
            aVar.e.setBackground(this.h);
            aVar.e.setTextColor(this.k);
            charSequence = b < 0 ? "过期" : "到期";
        } else if (b <= 0 || b > 2) {
            aVar.e.setBackground(this.f);
            aVar.e.setTextColor(this.i);
        } else {
            aVar.e.setBackground(this.g);
            aVar.e.setTextColor(this.j);
        }
        aVar.e.setText(charSequence);
        if (b(i)) {
            aVar.a.setBackgroundColor(ContextCompat.getColor(this.b, R.color.jd_gray_9));
            aVar.b.setVisibility(0);
        } else {
            aVar.a.setBackgroundColor(-1);
            aVar.b.setVisibility(4);
        }
        if (this.d != null) {
            aVar.a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FoodNoCameraAdapter b;

                public void onClick(View view) {
                    this.b.d.a(view, i);
                }
            });
            aVar.a.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ FoodNoCameraAdapter b;

                public boolean onLongClick(View view) {
                    this.b.d.b(view, i);
                    return false;
                }
            });
        }
    }

    private String a(String str, String str2) {
        return str == null ? str2 : str;
    }

    public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        p.b(a, "onViewDetachedFromWindow");
        super.onViewDetachedFromWindow(viewHolder);
    }

    public int getItemCount() {
        return this.c.size();
    }

    public void setOnItemClickListener(b bVar) {
        this.d = bVar;
    }

    public int a(int i) {
        if (this.e.get(i, false)) {
            this.e.delete(i);
        } else {
            this.e.put(i, true);
        }
        notifyItemChanged(i);
        return this.e.size();
    }

    public boolean b(int i) {
        return this.e.get(i, false);
    }

    public void a() {
        for (int i = 0; i < this.c.size(); i++) {
            this.e.put(i, true);
        }
        notifyDataSetChanged();
    }

    public void b() {
        this.e.clear();
        notifyDataSetChanged();
    }

    public List<Integer> c() {
        List<Integer> arrayList = new ArrayList(this.e.size());
        for (int i = 0; i < this.e.size(); i++) {
            arrayList.add(Integer.valueOf(this.e.keyAt(i)));
        }
        return arrayList;
    }

    public void c(int i) {
        this.e.delete(i);
        this.c.remove(this.c.get(i));
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.c.size() - i);
    }

    public void b(List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            c(((Integer) list.get(size)).intValue());
        }
    }
}
