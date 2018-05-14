package com.jd.fridge.switchFridge;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.FridgeInfoBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FridgeListAdapter extends Adapter<ViewHolder> {
    SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Context b;
    private b c;
    private List<FridgeInfoBean> d;

    /* compiled from: TbsSdkJava */
    class a extends ViewHolder {
        public final TextView a;
        public final TextView b;
        public final View c;
        public View d;
        final /* synthetic */ FridgeListAdapter e;

        public a(FridgeListAdapter fridgeListAdapter, View view) {
            this.e = fridgeListAdapter;
            super(view);
            this.d = view;
            this.a = (TextView) view.findViewById(R.id.fridge_band_textview);
            this.b = (TextView) view.findViewById(R.id.fridge_bind_date_textview);
            this.c = view.findViewById(R.id.fridge_selected_icon);
        }
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(int i);
    }

    public FridgeListAdapter(Context context, List<FridgeInfoBean> list) {
        this.b = context;
        this.d = list;
    }

    public FridgeListAdapter(Context context, List<FridgeInfoBean> list, b bVar) {
        this.b = context;
        this.d = list;
        this.c = bVar;
    }

    public void a(List<FridgeInfoBean> list) {
        this.d = list;
        notifyDataSetChanged();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.b).inflate(R.layout.switch_fridge_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        a aVar = (a) viewHolder;
        FridgeInfoBean fridgeInfoBean = (FridgeInfoBean) this.d.get(i);
        aVar.a.setText(fridgeInfoBean.getBrand() + fridgeInfoBean.getModel());
        Date date = new Date(fridgeInfoBean.getBindDate());
        aVar.b.setText(this.b.getString(R.string.activity_switch_fridge_bind_date_text, new Object[]{this.a.format(date)}));
        if (((FridgeInfoBean) this.d.get(i)).getFeedId().equals(GlobalVariable.C())) {
            aVar.c.setVisibility(0);
        } else {
            aVar.c.setVisibility(4);
        }
        if (this.c != null) {
            aVar.d.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FridgeListAdapter b;

                public void onClick(View view) {
                    this.b.c.a(i);
                }
            });
        }
    }

    public int getItemCount() {
        return this.d.size();
    }
}
