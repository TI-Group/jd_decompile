package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.view.ResizeableLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.d.f;
import com.sina.weibo.sdk.d.g;
import com.sina.weibo.sdk.d.i;
import com.tencent.connect.common.Constants;
import java.util.Locale;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class MobileRegisterActivity extends Activity implements OnClickListener, OnFocusChangeListener, com.sina.weibo.sdk.component.view.ResizeableLayout.a {
    private static final String a = MobileRegisterActivity.class.getName();
    private ProgressDialog b;
    private TitleBar c;
    private ScrollView d;
    private LinearLayout e;
    private TextView f;
    private RelativeLayout g;
    private TextView h;
    private TextView i;
    private EditText j;
    private ImageView k;
    private EditText l;
    private Button m;
    private TextView n;
    private Button o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private b w = new b();
    private int x = 0;
    private CountDownTimer y;

    /* compiled from: TbsSdkJava */
    private class a implements TextWatcher {
        final /* synthetic */ MobileRegisterActivity a;

        private a(MobileRegisterActivity mobileRegisterActivity) {
            this.a = mobileRegisterActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(this.a.j.getText().toString()) || TextUtils.isEmpty(this.a.l.getText().toString())) {
                this.a.i();
            } else {
                this.a.j();
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class b extends Handler {
        final /* synthetic */ MobileRegisterActivity a;

        private b(MobileRegisterActivity mobileRegisterActivity) {
            this.a = mobileRegisterActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.a.f.setVisibility(0);
                    this.a.g.setVisibility(0);
                    return;
                case 1:
                    this.a.f.setVisibility(8);
                    this.a.g.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class c implements TextWatcher {
        final /* synthetic */ MobileRegisterActivity a;

        private c(MobileRegisterActivity mobileRegisterActivity) {
            this.a = mobileRegisterActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (TextUtils.isEmpty(this.a.j.getText().toString())) {
                this.a.k.setVisibility(4);
            } else {
                this.a.k.setVisibility(0);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(this.a.j.getText().toString()) || TextUtils.isEmpty(this.a.l.getText().toString())) {
                this.a.i();
            } else {
                this.a.j();
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class d extends ClickableSpan {
        final /* synthetic */ MobileRegisterActivity a;
        private Context b;
        private String c;

        public d(MobileRegisterActivity mobileRegisterActivity, Context context, String str) {
            this.a = mobileRegisterActivity;
            this.b = context;
            this.c = str;
        }

        public void onClick(View view) {
            Intent intent = new Intent(this.b, WeiboSdkBrowser.class);
            Bundle bundle = new Bundle();
            bundle.putString("key_url", this.c);
            intent.putExtras(bundle);
            this.a.startActivity(intent);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(-11502161);
            textPaint.setUnderlineText(false);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            i.a(getApplicationContext(), "Pass wrong params!!", 0);
            finish();
        }
        this.p = extras.getString("appKey");
        this.q = extras.getString("packagename");
        this.r = extras.getString("key_hash");
        if (TextUtils.isEmpty(this.p)) {
            i.a(getApplicationContext(), g.a(this, "your appkey not set", "您的app_key没有设置", "您的app_key沒有設置"), 0);
            finish();
        }
        String string = extras.getString("register_title");
        if (TextUtils.isEmpty(string)) {
            string = g.a(this, "Login", "验证码登录", "驗證碼登錄");
        }
        this.s = string;
        this.t = a.CHINA_CODE;
        this.u = g.a(this, "China", "中国", "中國");
        c();
        this.y = new CountDownTimer(this, 60000, 1000) {
            final /* synthetic */ MobileRegisterActivity a;

            public void onTick(long j) {
                this.a.m.setText(new StringBuilder(String.valueOf(g.a(this.a.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"))).append("(").append(j / 1000).append("s)").toString());
            }

            public void onFinish() {
                this.a.m.setText(g.a(this.a.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"));
                this.a.h();
            }
        };
    }

    private void c() {
        View resizeableLayout = new ResizeableLayout(this);
        resizeableLayout.setLayoutParams(new LayoutParams(-1, -1));
        resizeableLayout.setBackgroundColor(-855310);
        this.c = new TitleBar(this);
        this.c.setId(1);
        this.c.setLeftBtnText(g.a(this, "Cancel", "取消", "取消"));
        this.c.setTitleBarText(this.s);
        this.c.setTitleBarClickListener(new com.sina.weibo.sdk.component.view.TitleBar.a(this) {
            final /* synthetic */ MobileRegisterActivity a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.setResult(0);
                this.a.finish();
            }
        });
        resizeableLayout.addView(this.c);
        View view = new View(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, g.a((Context) this, 2));
        view.setBackgroundDrawable(g.b(this, "weibosdk_common_shadow_top.9.png"));
        layoutParams.addRule(3, 1);
        view.setLayoutParams(layoutParams);
        resizeableLayout.addView(view);
        this.d = new ScrollView(this);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = g.a((Context) this, 47);
        this.d.setBackgroundColor(-855310);
        this.d.setLayoutParams(layoutParams2);
        this.e = new LinearLayout(this);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.e.setOrientation(1);
        this.e.setLayoutParams(layoutParams2);
        this.f = new TextView(this);
        this.f.setTextSize(2, 13.0f);
        this.f.setHeight(g.a((Context) this, 44));
        this.f.setGravity(17);
        this.f.setTextColor(-8224126);
        this.f.setText(g.a(this, "Confirm your country/region and enter your mobile number", "请确认国家和地区并填写手机号码", "請確認國家和地區并填寫手機號"));
        this.f.setFocusable(true);
        this.f.setFocusableInTouchMode(true);
        this.e.addView(this.f);
        this.g = new RelativeLayout(this);
        layoutParams2 = new RelativeLayout.LayoutParams(-1, g.a((Context) this, 48));
        this.g.setBackgroundDrawable(g.a((Context) this, "login_country_background.9.png", "login_country_background_highlighted.9.png"));
        this.g.setLayoutParams(layoutParams2);
        this.h = new TextView(this);
        this.h.setTextSize(2, 17.0f);
        this.h.setText(a.CHINA_CODE);
        this.h.setTextColor(-11382190);
        this.h.setGravity(3);
        this.h.setGravity(16);
        layoutParams2 = new RelativeLayout.LayoutParams(-2, g.a((Context) this, 48));
        layoutParams2.leftMargin = g.a((Context) this, 15);
        layoutParams2.addRule(9);
        this.h.setLayoutParams(layoutParams2);
        view = new ImageView(this);
        view.setId(2);
        view.setImageDrawable(g.a((Context) this, "triangle.png"));
        layoutParams = new RelativeLayout.LayoutParams(g.a((Context) this, 13), g.a((Context) this, 13));
        layoutParams.rightMargin = g.a((Context) this, 15);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        view.setLayoutParams(layoutParams);
        this.i = new TextView(this);
        this.i.setTextSize(2, 17.0f);
        this.i.setTextColor(-11382190);
        this.i.setText(this.u);
        this.i.setGravity(16);
        layoutParams = new RelativeLayout.LayoutParams(-2, g.a((Context) this, 48));
        layoutParams.rightMargin = g.a((Context) this, 118);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        this.i.setLayoutParams(layoutParams);
        this.g.addView(this.h);
        this.g.addView(this.i);
        this.g.addView(view);
        this.e.addView(this.g);
        view = new LinearLayout(this);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g.a((Context) this, 10);
        view.setLayoutParams(layoutParams);
        view.setOrientation(1);
        View relativeLayout = new RelativeLayout(this);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g.a((Context) this, 50));
        layoutParams3.gravity = 16;
        relativeLayout.setBackgroundDrawable(g.b(this, "login_top_background.9.png"));
        relativeLayout.setLayoutParams(layoutParams3);
        this.k = new ImageView(this);
        this.k.setId(4);
        this.k.setImageDrawable(g.a((Context) this, "search_clear_btn_normal.png", "search_clear_btn_down.png"));
        layoutParams3 = new RelativeLayout.LayoutParams(g.a((Context) this, 22), g.a((Context) this, 22));
        layoutParams3.rightMargin = g.a((Context) this, 15);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        this.k.setVisibility(4);
        this.k.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.k);
        this.j = new EditText(this);
        this.j.setTextSize(2, 16.0f);
        this.j.setTextColor(-16777216);
        this.j.setHint(g.a(this, "Your mobile number", "请输入手机号码", "請輸入手機號"));
        this.j.setHintTextColor(-4342339);
        this.j.setBackgroundDrawable(null);
        this.j.setSelected(false);
        layoutParams3 = new RelativeLayout.LayoutParams(-1, g.a((Context) this, 50));
        layoutParams3.topMargin = g.a((Context) this, 0);
        layoutParams3.bottomMargin = g.a((Context) this, 0);
        layoutParams3.leftMargin = g.a((Context) this, 0);
        layoutParams3.rightMargin = g.a((Context) this, 0);
        layoutParams3.addRule(0, 4);
        this.j.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.j);
        View relativeLayout2 = new RelativeLayout(this);
        LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, g.a((Context) this, 50));
        relativeLayout2.setBackgroundDrawable(g.b(this, "login_bottom_background.9.png"));
        relativeLayout2.setLayoutParams(layoutParams4);
        this.m = new Button(this);
        this.m.setId(3);
        this.m.setBackgroundDrawable(g.a((Context) this, "get_code_button.9.png", "get_code_button_highlighted.9.png"));
        layoutParams4 = new RelativeLayout.LayoutParams(-2, g.a((Context) this, 29));
        layoutParams4.rightMargin = g.a((Context) this, 12);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        this.m.setPadding(18, 0, 18, 0);
        this.m.setLayoutParams(layoutParams4);
        this.m.setText(g.a(this, "Get code", "获取验证码", "獲取驗證碼"));
        this.m.setTextSize(15.0f);
        h();
        relativeLayout2.addView(this.m);
        this.l = new EditText(this);
        this.l.setTextSize(2, 16.0f);
        this.l.setTextColor(-16777216);
        this.l.setHintTextColor(-4342339);
        this.l.setHint(g.a(this, "Verification code", "请输入验证码", "請輸入驗證碼"));
        this.l.setBackgroundDrawable(null);
        layoutParams4 = new RelativeLayout.LayoutParams(-1, g.a((Context) this, 48));
        layoutParams4.addRule(0, 3);
        this.l.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.l);
        view.addView(relativeLayout);
        view.addView(relativeLayout2);
        this.e.addView(view);
        this.m.setOnClickListener(this);
        this.n = new TextView(this);
        this.n.setTextSize(2, 13.0f);
        this.n.setTextColor(-2014941);
        this.n.setText("");
        this.n.setVisibility(4);
        layoutParams2 = new LinearLayout.LayoutParams(-1, g.a((Context) this, 36));
        layoutParams2.leftMargin = g.a((Context) this, 12);
        this.n.setGravity(16);
        this.n.setLayoutParams(layoutParams2);
        this.e.addView(this.n);
        this.o = d();
        i();
        this.e.addView(this.o);
        view = e();
        relativeLayout = f();
        this.e.addView(view);
        this.e.addView(relativeLayout);
        this.d.addView(this.e);
        resizeableLayout.addView(this.d);
        l();
        this.j.setInputType(2);
        this.j.addTextChangedListener(new c());
        this.l.setInputType(2);
        this.l.addTextChangedListener(new a());
        this.k.setOnClickListener(this);
        this.j.setOnFocusChangeListener(this);
        this.o.setOnClickListener(this);
        this.g.setOnClickListener(this);
        resizeableLayout.setSizeChangeListener(this);
        setContentView(resizeableLayout);
    }

    private Button d() {
        Button button = new Button(this);
        button.setBackgroundDrawable(g.b(this, "common_button_big_blue.9.png", "common_button_big_blue_highlighted.9.png", "common_button_big_blue_disable.9.png"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, g.a((Context) this, 46));
        int a = g.a((Context) this, 12);
        layoutParams.rightMargin = a;
        layoutParams.leftMargin = a;
        button.setText(g.a(this, "OK", "确定", "確定"));
        button.setTextSize(17.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    private TextView e() {
        TextView textView = new TextView(this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g.a((Context) this, 12);
        layoutParams.leftMargin = g.a((Context) this, 12);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(13.0f);
        textView.setGravity(3);
        textView.setTextColor(-8224126);
        textView.setText(g.a(this, "Service By Sina WeiBo", "此服务由微博提供", "此服務由微博提供"));
        return textView;
    }

    private TextView f() {
        CharSequence charSequence;
        int indexOf;
        int length;
        int indexOf2;
        int length2;
        TextView textView = new TextView(this);
        textView.setTextSize(2, 13.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = g.a((Context) this, 8);
        layoutParams.leftMargin = g.a((Context) this, 12);
        layoutParams.rightMargin = g.a((Context) this, 12);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(13.0f);
        textView.setGravity(3);
        textView.setTextColor(-8224126);
        Locale a = g.a();
        String str = "点击“确定”表示你同意服务使用协议和隐私条款。";
        str = "zh_CN";
        String str2;
        String str3;
        if (Locale.SIMPLIFIED_CHINESE.equals(a)) {
            charSequence = "点击“确定”表示你同意服务使用协议和隐私条款。";
            str2 = "服务使用协议";
            str3 = "隐私条款";
            indexOf = "点击“确定”表示你同意服务使用协议和隐私条款。".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "点击“确定”表示你同意服务使用协议和隐私条款。".indexOf(str3);
            length2 = str3.length() + indexOf2;
        } else if (Locale.TRADITIONAL_CHINESE.equals(a)) {
            charSequence = "點擊“確定”標示你同意服務使用協議和隱私條款。";
            str = "zh_HK";
            str2 = "服務使用協議";
            str3 = "隱私條款";
            indexOf = "點擊“確定”標示你同意服務使用協議和隱私條款。".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "點擊“確定”標示你同意服務使用協議和隱私條款。".indexOf(str3);
            length2 = str3.length() + indexOf2;
        } else {
            charSequence = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
            str = "en_US";
            str2 = "Service Agreement";
            str3 = "Privacy Policy";
            indexOf = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf(str2);
            length = indexOf + str2.length();
            indexOf2 = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf(str3);
            length2 = str3.length() + indexOf2;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (!(indexOf == -1 || length == -1)) {
            spannableStringBuilder.setSpan(new d(this, this, "http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5&lang=" + str), indexOf, length, 33);
        }
        if (!(indexOf2 == -1 || length2 == -1)) {
            spannableStringBuilder.setSpan(new d(this, this, "http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349&lang=" + str), indexOf2, length2, 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        return textView;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (intent != null) {
                    this.t = intent.getStringExtra("code");
                    this.u = intent.getStringExtra("name");
                    this.h.setText(this.t);
                    this.i.setText(this.u);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (view == this.j && !z) {
            if (b(this.j.getText().toString())) {
                this.n.setVisibility(4);
                return;
            }
            this.n.setText(g.a(this, "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
            this.n.setVisibility(0);
        }
    }

    private boolean a(String str) {
        if (!f.a(this)) {
            k();
            return false;
        } else if (b(str)) {
            this.n.setVisibility(4);
            return true;
        } else {
            this.n.setVisibility(0);
            this.n.setText(g.a(getApplicationContext(), "Your phone number isn’t 11-digit long", "您的手机号不是11位数", "您的手機號不是11位數"));
            return false;
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!a.CHINA_CODE.equals(this.t)) {
            return true;
        }
        if (str.trim().length() == 11) {
            return true;
        }
        return false;
    }

    private boolean c(String str) {
        if (!f.a(this)) {
            k();
            return false;
        } else if (d(str)) {
            this.n.setVisibility(4);
            return true;
        } else {
            this.n.setVisibility(0);
            this.n.setText(g.a(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"));
            i.a(getApplicationContext(), g.a(getApplicationContext(), "Your code isn’t 6-digit long", "你的验证码不是6位数", "你的驗證碼不是6位數"), 0);
            return false;
        }
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 6) {
            return false;
        }
        return true;
    }

    private void g() {
        this.m.setEnabled(false);
        this.m.setTextColor(-4342339);
    }

    private void h() {
        this.m.setEnabled(true);
        this.m.setTextColor(-11502161);
    }

    private void i() {
        this.o.setTextColor(1308622847);
        this.o.setEnabled(false);
    }

    private void j() {
        this.o.setEnabled(true);
        this.o.setTextColor(-1);
    }

    private void k() {
        i.a(getApplicationContext(), g.a(getApplicationContext(), "your network is  disabled  try again later", "您的网络不可用，请稍后", "您的網絡不可用，請稍後"), 0);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }

    public void a() {
        if (this.b != null && this.b.isShowing()) {
            this.b.dismiss();
        }
    }

    private void l() {
        this.b = new ProgressDialog(this);
        this.b.setCanceledOnTouchOutside(false);
        this.b.requestWindowFeature(1);
        this.b.setMessage(g.a(this, "please wait .... ", "正在处理中.....", "正在處理中....."));
    }

    public void a(String str, String str2) {
        com.sina.weibo.sdk.net.f fVar = new com.sina.weibo.sdk.net.f(this.p);
        fVar.a("appkey", this.p);
        fVar.a("packagename", this.q);
        fVar.a("key_hash", this.r);
        String str3 = "phone";
        if (!a.CHINA_CODE.equals(str2)) {
            str = new StringBuilder(String.valueOf(str2)).append(str).toString();
        }
        fVar.a(str3, str);
        fVar.a("version", "0031205000");
        com.sina.weibo.sdk.net.c.a(this, "http://api.weibo.com/oauth2/sms_authorize/send", fVar, "GET", new com.sina.weibo.sdk.net.d(this) {
            final /* synthetic */ MobileRegisterActivity a;

            {
                this.a = r1;
            }

            public void a(com.sina.weibo.sdk.c.b bVar) {
                com.sina.weibo.sdk.d.d.a(MobileRegisterActivity.a, "get onWeiboException " + bVar.getMessage());
                CharSequence a = g.a(this.a.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
                try {
                    JSONObject jSONObject = new JSONObject(bVar.getMessage());
                    if (!TextUtils.isEmpty(jSONObject.optString("error_description"))) {
                        a = jSONObject.optString("error_description");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i.a(this.a.getApplicationContext(), a, 1);
            }

            public void a(String str) {
                com.sina.weibo.sdk.d.d.a(MobileRegisterActivity.a, "get onComplete : " + str);
                if (str != null) {
                    try {
                        this.a.v = (String) new JSONObject(str).get("cfrom");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void b(final String str, String str2) {
        com.sina.weibo.sdk.net.f fVar = new com.sina.weibo.sdk.net.f(this.p);
        fVar.a("appkey", this.p);
        fVar.a("packagename", this.q);
        fVar.a("key_hash", this.r);
        fVar.a("phone", str);
        fVar.a("version", "0031205000");
        fVar.a("code", str2);
        fVar.a("cfrom", this.v);
        this.b.show();
        com.sina.weibo.sdk.net.c.a(this, "http://api.weibo.com/oauth2/sms_authorize/submit", fVar, "GET", new com.sina.weibo.sdk.net.d(this) {
            final /* synthetic */ MobileRegisterActivity a;

            public void a(com.sina.weibo.sdk.c.b bVar) {
                com.sina.weibo.sdk.d.d.a(MobileRegisterActivity.a, "get onWeiboException " + bVar.getMessage());
                CharSequence a = g.a(this.a.getApplicationContext(), "the server is busy, please  wait", "服务器忙,请稍后再试", "服務器忙,請稍後再試");
                try {
                    JSONObject jSONObject = new JSONObject(bVar.getMessage());
                    if (!TextUtils.isEmpty(jSONObject.optString("error_description"))) {
                        a = jSONObject.optString("error_description");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.a.n.setVisibility(0);
                this.a.n.setText(a);
                this.a.a();
            }

            public void a(String str) {
                this.a.a();
                com.sina.weibo.sdk.d.d.a(MobileRegisterActivity.a, "get onComplete : " + str);
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("uid", jSONObject.optString("uid"));
                        bundle.putString("phone_num", str);
                        bundle.putString(Constants.PARAM_ACCESS_TOKEN, jSONObject.optString("oauth_token"));
                        bundle.putString(Constants.PARAM_EXPIRES_IN, jSONObject.optString(ClientCookie.EXPIRES_ATTR));
                        intent.putExtras(bundle);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void onClick(View view) {
        String editable;
        String charSequence;
        if (view == this.m) {
            editable = this.j.getText().toString();
            charSequence = this.h.getText().toString();
            if (a(editable)) {
                this.y.start();
                g();
                a(editable, charSequence);
            }
        } else if (view == this.k) {
            this.j.setText("");
        } else if (view == this.o) {
            editable = this.j.getText().toString();
            charSequence = this.l.getText().toString();
            if (c(charSequence)) {
                b(editable, charSequence);
            }
        } else if (view == this.g) {
            this.n.setVisibility(4);
            Intent intent = new Intent();
            intent.setClass(this, SelectCountryActivity.class);
            startActivityForResult(intent, 0);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.widthPixels <= displayMetrics.heightPixels) {
            this.x = this.x < i2 ? i2 : this.x;
            int i5 = 0;
            if (i2 < i4) {
                i5 = 1;
            } else if (i2 > i4 && i2 < this.x) {
                i5 = 1;
            } else if (i2 == i4 && i2 != this.x) {
                i5 = 1;
            }
            this.w.sendEmptyMessage(i5);
        }
    }
}
