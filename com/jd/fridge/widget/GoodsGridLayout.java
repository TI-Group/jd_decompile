package com.jd.fridge.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodsListDataBean;
import com.jingdong.jdma.JDMaInterface;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class GoodsGridLayout extends GridLayout {
    private List<FoodsListDataBean> a = new ArrayList();
    private ArrayList<View> b;
    private a c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(View view, int i);
    }

    public GoodsGridLayout(Context context) {
        super(context);
        if (!isInEditMode()) {
            a(context);
        }
    }

    public GoodsGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            a(context, attributeSet);
            a(context);
        }
    }

    public GoodsGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            a(context, attributeSet);
            a(context);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GoodsGridLayout);
        this.e = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
        this.h = obtainStyledAttributes.getInt(4, 1);
        this.i = obtainStyledAttributes.getInt(0, 1);
        this.d = this.h * this.i;
        obtainStyledAttributes.recycle();
    }

    private void a(Context context) {
        this.b = new ArrayList();
        int q = (int) (((double) ((((float) ((GlobalVariable.a().q() - (this.g * 2)) - (this.f * (this.i - 1)))) * 1.0f) / ((float) this.i))) + 0.5d);
        setRowCount(this.h);
        setColumnCount(this.i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.h, this.i});
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = 0;
            while (i3 < iArr[i2].length) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_goods, null);
                int i4 = i + 1;
                inflate.setId(i);
                LayoutParams layoutParams = new GridLayout.LayoutParams();
                if (i3 > 0) {
                    layoutParams.leftMargin = this.f;
                }
                if (i2 > 0) {
                    layoutParams.topMargin = this.e;
                }
                layoutParams.width = q;
                layoutParams.height = -2;
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ GoodsGridLayout a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (this.a.c != null) {
                            this.a.c.a(view, view.getId());
                        }
                    }
                });
                addView(inflate, layoutParams);
                this.b.add(inflate);
                i3++;
                i = i4;
            }
        }
    }

    public void setData(List<FoodsListDataBean> list) {
        this.a = list;
        int size = list.size();
        for (int i = 0; i < this.d; i++) {
            if (i < size) {
                ((View) this.b.get(i)).setVisibility(0);
                ((TextView) ((View) this.b.get(i)).findViewById(R.id.tv_product_name)).setText(((FoodsListDataBean) list.get(i)).getTitle());
                ((TextView) ((View) this.b.get(i)).findViewById(R.id.tv_product_current_price)).setText("¥" + new DecimalFormat("0.00").format(((FoodsListDataBean) list.get(i)).getPrice() > JDMaInterface.PV_UPPERLIMIT ? ((FoodsListDataBean) list.get(i)).getPrice() : JDMaInterface.PV_UPPERLIMIT));
                ImageLoader.getInstance().displayImage(((FoodsListDataBean) list.get(i)).getImgUrl(), (ImageView) ((View) this.b.get(i)).findViewById(R.id.iv_product_img));
            } else {
                ((View) this.b.get(i)).setVisibility(8);
            }
        }
    }

    public void setViewOnclickListener(a aVar) {
        this.c = aVar;
    }
}
