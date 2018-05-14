package com.jd.fridge.widget.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.jd.fridge.util.r;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class TagFlowLayoutForProject extends FlowLayout implements a {
    private a d;
    private int e;
    private Set<Integer> f;
    private a g;
    private b h;

    /* compiled from: TbsSdkJava */
    public interface a {
    }

    /* compiled from: TbsSdkJava */
    public interface b {
    }

    public TagFlowLayoutForProject(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.f = new HashSet();
    }

    public TagFlowLayoutForProject(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayoutForProject(Context context) {
        this(context, null);
    }

    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOnSelectListener(a aVar) {
        this.g = aVar;
        if (this.g != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(b bVar) {
        this.h = bVar;
        if (bVar != null) {
            setClickable(true);
        }
    }

    public void setAdapter(a aVar) {
        this.d = aVar;
        this.d.setOnDataChangedListener(this);
        this.f.clear();
        a();
    }

    private void a() {
        removeAllViews();
        a aVar = this.d;
        Collection a = this.d.a();
        for (int i = 0; i < aVar.b(); i++) {
            View tagView = new TagView(getContext());
            View a2 = aVar.a(tagView, i, aVar.a(i));
            a2.setDuplicateParentStateEnabled(true);
            if (a2.getLayoutParams() != null) {
                tagView.setLayoutParams(a2.getLayoutParams());
            } else {
                LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(a(getContext(), 5.0f), a(getContext(), 5.0f), a(getContext(), 5.0f), a(getContext(), 5.0f));
                tagView.setLayoutParams(marginLayoutParams);
            }
            addView(tagView);
        }
        this.f.addAll(a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxSelectCount(int i) {
        if (this.f.size() > i) {
            r.d("TagFlowLayout", "you has already select more than " + i + " views , so it will be clear .");
            this.f.clear();
        }
        this.e = i;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
