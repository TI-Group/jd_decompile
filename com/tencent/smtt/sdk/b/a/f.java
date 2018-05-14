package com.tencent.smtt.sdk.b.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.sdk.ui.dialog.TBSActivityPicker.DialogButton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f extends Dialog {
    private static float l = -1.0f;
    private ListView a;
    private TextView b;
    private Button c;
    private Button d;
    private ValueCallback<String> e;
    private String f;
    private Map<Integer, DialogButton> g = new HashMap();
    private a h;
    private String i = "*/*";
    private Intent j;
    private SharedPreferences k = null;

    public f(Context context, String str, Intent intent, ValueCallback<String> valueCallback, String str2) {
        super(context, 16973835);
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if ((queryIntentActivities == null || queryIntentActivities.size() == 0) && d.b(context)) {
            QbSdk.isDefaultDialog = true;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && (queryIntentActivities == null || (queryIntentActivities != null && queryIntentActivities.size() == 0))) {
            QbSdk.isDefaultDialog = true;
        }
        b(context.getApplicationContext());
        this.f = str;
        this.j = intent;
        this.e = valueCallback;
        this.k = context.getSharedPreferences("tbs_file_open_dialog_config", 0);
        if (!TextUtils.isEmpty(str2)) {
            this.i = str2;
        }
    }

    private View a(Context context) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        View frameLayout = new FrameLayout(context);
        View linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(a(280.0f), -1);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        this.b = new TextView(context);
        layoutParams = new LinearLayout.LayoutParams(-2, a(65.0f));
        layoutParams.weight = 0.0f;
        this.b.setGravity(16);
        this.b.setLayoutParams(layoutParams);
        this.b.setPadding(a(18.0f), 0, 0, 0);
        this.b.setTextColor(Color.rgb(69, 192, 26));
        this.b.setTextSize(1, 18.0f);
        this.b.setText(this.f);
        linearLayout.addView(this.b);
        View imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.weight = 0.0f;
        imageView.setLayoutParams(layoutParams2);
        imageView.setBackgroundColor(Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView);
        this.a = new ListView(context);
        layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 16;
        this.a.setLayoutParams(layoutParams);
        this.a.setDivider(new ColorDrawable(Color.argb(41, 0, 0, 0)));
        this.a.setDividerHeight(1);
        linearLayout.addView(this.a);
        imageView = new ImageView(context);
        layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.weight = 0.0f;
        imageView.setLayoutParams(layoutParams2);
        imageView.setBackgroundColor(Color.argb(61, 0, 0, 0));
        linearLayout.addView(imageView);
        imageView = new LinearLayout(context);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 0.0f;
        imageView.setLayoutParams(layoutParams2);
        imageView.setOrientation(0);
        imageView.setContentDescription("x5_tbs_activity_picker_btn_container");
        this.c = new Button(context);
        layoutParams2 = new LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams2.weight = 1.0f;
        this.c.setLayoutParams(layoutParams2);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        this.c.setBackgroundDrawable(stateListDrawable);
        this.c.setText(i.b("x5_tbs_wechat_activity_picker_label_always"));
        this.c.setTextColor(Color.rgb(29, 29, 29));
        this.c.setTextSize(1, 17.0f);
        imageView.addView(this.c);
        View imageView2 = new ImageView(context);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(1, -1);
        layoutParams3.weight = 0.0f;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setBackgroundColor(Color.rgb(ErrorCode.INCR_UPDATE_FAIL, ErrorCode.INCR_UPDATE_FAIL, ErrorCode.INCR_UPDATE_FAIL));
        imageView.addView(imageView2);
        this.d = new Button(context);
        layoutParams2 = new LinearLayout.LayoutParams(-1, a(49.0f));
        layoutParams2.weight = 1.0f;
        this.d.setLayoutParams(layoutParams2);
        stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        this.d.setBackgroundDrawable(stateListDrawable);
        this.d.setText(i.b("x5_tbs_wechat_activity_picker_label_once"));
        this.d.setTextColor(Color.rgb(29, 29, 29));
        this.d.setTextSize(1, 17.0f);
        imageView.addView(this.d);
        linearLayout.addView(imageView);
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    private void b(Context context) {
        if (l < 0.0f) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            l = displayMetrics.density;
        }
    }

    private void c() {
        e eVar = null;
        if (this.h != null) {
            eVar = this.h.a();
        }
        this.h = new a(getContext(), this.j, new e(getContext(), i.a("application_icon"), "QQ浏览器", TbsConfig.APP_QB), eVar, this, this.a, this.e);
        this.a.setAdapter(this.h);
    }

    public int a(float f) {
        return (int) ((l * f) + 0.5f);
    }

    public String a() {
        return this.k != null ? this.k.getString("key_tbs_picked_default_browser_" + this.i, null) : null;
    }

    public void a(String str) {
        if (this.k != null) {
            this.k.edit().putString("key_tbs_picked_default_browser_" + this.i, str).commit();
        }
    }

    void a(boolean z) {
        if (this.d != null) {
            this.d.setEnabled(z);
        }
        if (this.c != null) {
            this.c.setEnabled(z);
        }
    }

    public void b() {
        setContentView(a(getContext()));
        c();
        this.c.setOnClickListener(new g(this));
        this.d.setOnClickListener(new h(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        b();
    }
}
