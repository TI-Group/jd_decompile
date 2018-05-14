package com.jd.fridge.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.FoodsListDataBean;
import com.jd.fridge.util.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class GoodsListTable extends TableLayout {
    private List<FoodsListDataBean> a = new ArrayList();

    public GoodsListTable(Context context) {
        super(context);
        a(context);
    }

    public GoodsListTable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        if (this.a != null && this.a.size() != 0 && this.a.size() > 0) {
            int size = this.a.size();
            int i = 0;
            int i2 = 0;
            TableRow tableRow = null;
            while (i < size) {
                if (i % 2 == 0) {
                    tableRow = new TableRow(context);
                    addView(tableRow);
                }
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_goods, null);
                int i3 = i2 + 1;
                inflate.setId(i2);
                i2 = y.a(0.5f, GlobalVariable.a().p());
                tableRow.addView(inflate, (int) (((double) ((((float) ((GlobalVariable.a().q() - (y.a(15.0f, GlobalVariable.a().p()) * 2)) - (i2 * 1))) * 1.0f) / ((float) 2))) + 0.5d), -2);
                i++;
                i2 = i3;
            }
        }
    }
}
