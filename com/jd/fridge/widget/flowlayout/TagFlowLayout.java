package com.jd.fridge.widget.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.jd.fridge.R;
import com.jd.fridge.util.r;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class TagFlowLayout extends FlowLayout implements a {
    private a d;
    private boolean e;
    private int f;
    private MotionEvent g;
    private Set<Integer> h;
    private a i;
    private b j;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(Set<Integer> set);
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        boolean a(View view, int i, FlowLayout flowLayout);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.f = -1;
        this.h = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.e = obtainStyledAttributes.getBoolean(0, true);
        this.f = obtainStyledAttributes.getInt(1, -1);
        obtainStyledAttributes.recycle();
        if (this.e) {
            setClickable(true);
        }
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
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
        this.i = aVar;
        if (this.i != null) {
            setClickable(true);
        }
    }

    public void setOnTagClickListener(b bVar) {
        this.j = bVar;
        if (bVar != null) {
            setClickable(true);
        }
    }

    public void setAdapter(a aVar) {
        this.d = aVar;
        this.d.setOnDataChangedListener(this);
        this.h.clear();
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
            tagView.addView(a2);
            addView(tagView);
            if (a.contains(Integer.valueOf(i))) {
                tagView.setChecked(true);
            }
        }
        this.h.addAll(a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.g = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        if (this.g == null) {
            return super.performClick();
        }
        int x = (int) this.g.getX();
        int y = (int) this.g.getY();
        this.g = null;
        TagView a = a(x, y);
        y = a(a);
        if (a != null) {
            a(a, y);
            if (this.j != null) {
                return this.j.a(a.getTagView(), y, this);
            }
        }
        return true;
    }

    public void setMaxSelectCount(int i) {
        if (this.h.size() > i) {
            r.d("TagFlowLayout", "you has already select more than " + i + " views , so it will be clear .");
            this.h.clear();
        }
        this.f = i;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.h);
    }

    private void a(TagView tagView, int i) {
        if (this.e) {
            if (tagView.isChecked()) {
                tagView.setChecked(false);
                this.h.remove(Integer.valueOf(i));
            } else if (this.f == 1 && this.h.size() == 1) {
                Integer num = (Integer) this.h.iterator().next();
                ((TagView) getChildAt(num.intValue())).setChecked(false);
                tagView.setChecked(true);
                this.h.remove(num);
                this.h.add(Integer.valueOf(i));
            } else if (this.f <= 0 || this.h.size() < this.f) {
                tagView.setChecked(true);
                this.h.add(Integer.valueOf(i));
            } else {
                return;
            }
            if (this.i != null) {
                this.i.a(new HashSet(this.h));
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.h.size() > 0) {
            String str2 = str;
            for (Integer intValue : this.h) {
                str2 = str2 + intValue.intValue() + "|";
            }
            str = str2.substring(0, str2.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            Object string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String parseInt : string.split("\\|")) {
                    int parseInt2 = Integer.parseInt(parseInt);
                    this.h.add(Integer.valueOf(parseInt2));
                    TagView tagView = (TagView) getChildAt(parseInt2);
                    if (tagView != null) {
                        tagView.setChecked(true);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private int a(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    private TagView a(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8) {
                Rect rect = new Rect();
                tagView.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return tagView;
                }
            }
        }
        return null;
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
