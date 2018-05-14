package com.tencent.smtt.sdk.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class a extends ArrayAdapter<e> implements OnClickListener, ListAdapter {
    private ArrayList<e> a;
    private e b = null;
    private Intent c = null;
    private WeakReference<ListView> d;
    private WeakReference<f> e;
    private e f;
    private Handler g;
    private String[] h = null;
    private a i = this;
    private ValueCallback<String> j;
    private Map<String, Drawable> k;

    public a(Context context, Intent intent, e eVar, e eVar2, f fVar, ListView listView, ValueCallback<String> valueCallback) {
        super(context, 0);
        a(fVar);
        a(listView);
        this.c = intent;
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) || d.b(context)) {
            this.f = null;
        } else {
            this.f = eVar;
        }
        this.j = valueCallback;
        this.g = new b(this);
        this.h = new String[2];
        this.h[0] = i.b("x5_tbs_activity_picker_recommend_to_trim");
        this.h[1] = i.b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
        a(context, eVar2);
    }

    private int a(float f) {
        f fVar = (f) this.e.get();
        return fVar == null ? (int) f : fVar.a(f);
    }

    private View a(Context context) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        linearLayout.setBackgroundDrawable(stateListDrawable);
        View relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, a(64.0f)));
        View imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(48.0f), a(48.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        int a = a(8.0f);
        layoutParams.setMargins(a, a, a, a);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(101);
        relativeLayout.addView(imageView);
        imageView = new LinearLayout(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(1, 101);
        imageView.setLayoutParams(layoutParams);
        imageView.setOrientation(1);
        View textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setMaxLines(1);
        textView.setTextColor(Color.rgb(29, 29, 29));
        textView.setTextSize(1, 17.0f);
        textView.setId(102);
        imageView.addView(textView);
        textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(i.b("x5_tbs_wechat_activity_picker_label_recommend"));
        textView.setTextColor(Color.rgb(ErrorCode.INCR_UPDATE_FAIL, ErrorCode.INCR_UPDATE_FAIL, ErrorCode.INCR_UPDATE_FAIL));
        textView.setTextSize(1, 14.0f);
        textView.setId(103);
        imageView.addView(textView);
        relativeLayout.addView(imageView);
        imageView = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(a(24.0f), a(24.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, a(14.0f), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(i.a("x5_tbs_activity_picker_check"));
        imageView.setId(104);
        relativeLayout.addView(imageView);
        imageView = new Button(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, a(31.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, a(8.0f), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setTextColor(Color.rgb(50, 50, 50));
        imageView.setTextSize(1, 14.0f);
        Drawable stateListDrawable2 = new StateListDrawable();
        float a2 = (float) a(2.0f);
        Shape roundRectShape = new RoundRectShape(new float[]{a2, a2, a2, a2, a2, a2, a2, a2}, null, null);
        Drawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(Color.argb(128, 69, 192, 26));
        stateListDrawable2.addState(new int[]{-16842910}, shapeDrawable);
        shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(Color.rgb(41, 132, 9));
        stateListDrawable2.addState(new int[]{16842919}, shapeDrawable);
        shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(Color.rgb(69, 192, 26));
        stateListDrawable2.addState(new int[]{-16842919}, shapeDrawable);
        imageView.setBackgroundDrawable(stateListDrawable2);
        imageView.setId(107);
        imageView.setPadding(a(8.0f), 0, a(8.0f), 0);
        relativeLayout.addView(imageView);
        relativeLayout.setId(105);
        linearLayout.addView(relativeLayout);
        return linearLayout;
    }

    private void a(e eVar, View view) {
        if (view != null && eVar != null) {
            ImageView imageView = (ImageView) view.findViewById(101);
            TextView textView = (TextView) view.findViewById(102);
            TextView textView2 = (TextView) view.findViewById(103);
            ImageView imageView2 = (ImageView) view.findViewById(104);
            View findViewById = view.findViewById(105);
            View findViewById2 = view.findViewById(106);
            Button button = (Button) view.findViewById(107);
            ProgressBar progressBar = (ProgressBar) view.findViewById(108);
            imageView.setImageDrawable(eVar.a(this.k));
            String replaceAll = eVar.a().trim().replaceAll(' ' + "", "");
            CharSequence charSequence = replaceAll;
            for (String str : this.h) {
                if (str != null && str.length() > 0) {
                    charSequence = charSequence.replaceAll(str, "");
                }
            }
            textView.setText(charSequence);
            if (eVar.b() == null) {
                for (ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(this.c, 65536)) {
                    if (eVar.c().equals(resolveInfo.activityInfo.packageName)) {
                        eVar.a(resolveInfo);
                        break;
                    }
                }
            }
            findViewById.setOnClickListener(new c(this));
            if (TbsConfig.APP_QB.equals(eVar.c())) {
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
            if (eVar.b() != null) {
                findViewById.setClickable(false);
                findViewById.setEnabled(false);
                if (eVar == this.b) {
                    imageView2.setVisibility(0);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                } else {
                    imageView2.setVisibility(8);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(8);
                    }
                }
                button.setVisibility(8);
                button.setOnClickListener(null);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            } else {
                findViewById.setClickable(true);
                findViewById.setEnabled(true);
                imageView2.setVisibility(8);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
                button.setVisibility(0);
                button.setText(i.b("x5_tbs_wechat_activity_picker_label_download"));
                button.setEnabled(true);
                button.setOnClickListener(new d(this));
            }
            view.setTag(eVar);
            view.setOnClickListener(this);
        }
    }

    private void a(boolean z) {
        if (this.e != null) {
            f fVar = (f) this.e.get();
            if (fVar != null) {
                fVar.a(z);
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void b(Context context, e eVar) {
        this.b = eVar;
        boolean z = this.b != null && a(context, eVar.c());
        a(z);
    }

    public e a() {
        return this.b;
    }

    public e a(int i) {
        return (i < 0 || i >= this.a.size()) ? null : (e) this.a.get(i);
    }

    void a(Context context, e eVar) {
        this.a = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(this.c, 65536)) {
            if (e.a(context, resolveInfo.activityInfo.packageName) != null) {
                int i3;
                e eVar2 = new e(context, resolveInfo);
                if (this.f != null && this.f.c().equals(resolveInfo.activityInfo.packageName)) {
                    this.a.add(0, eVar2);
                    i2 = 1;
                } else if (TbsConfig.APP_QB.equals(resolveInfo.activityInfo.packageName)) {
                    this.a.add(0, eVar2);
                } else {
                    this.a.add(eVar2);
                }
                if (i == 0 && eVar != null && eVar2.c().equals(eVar.c())) {
                    b(context, eVar2);
                    i3 = 1;
                } else {
                    i3 = i;
                }
                i = i3;
            }
        }
        if (i2 == 0 && this.f != null) {
            this.a.add(0, this.f);
        }
        if (i == 0 && this.a.size() > 0) {
            b(context, (e) this.a.get(0));
        }
    }

    void a(ListView listView) {
        this.d = new WeakReference(listView);
    }

    void a(f fVar) {
        this.e = new WeakReference(fVar);
    }

    void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.g.obtainMessage(1).sendToTarget();
            return;
        }
        ListView listView = (ListView) this.d.get();
        if (listView != null) {
            View findViewWithTag = listView.findViewWithTag(this.f);
            if (findViewWithTag != null) {
                a(this.f, findViewWithTag);
            }
        }
    }

    public int getCount() {
        return this.a.size();
    }

    public /* synthetic */ Object getItem(int i) {
        return a(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        e a = a(i);
        if (a == null) {
            return null;
        }
        if (view == null) {
            view = a(getContext());
        }
        a(a, view);
        return view;
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof e)) {
            e eVar = (e) tag;
            if (eVar != this.b) {
                ViewParent parent = view.getParent();
                View view2 = parent instanceof View ? (View) parent : null;
                e eVar2 = this.b;
                b(view.getContext(), eVar);
                a(eVar2, view2.findViewWithTag(eVar2));
                a(this.b, view);
            }
        }
    }
}
