package com.jd.fridge.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.b.a.b;
import java.util.Timer;
import java.util.TimerTask;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.model.FailResult;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class SetPasswordActivity extends BaseActivity {
    private WJLoginHelper a;
    private String b;
    private EditText c;
    private TextView d;
    private CheckBox i;
    private TextView j;
    private TextView k;
    private ImageView l;

    protected int a() {
        return R.layout.phone_set_password_view;
    }

    protected void b() {
        c(getString(R.string.set_login_password));
        setAppbarBackBtnClickListener(new OnClickListener(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a(this.a, "点击\"返回\"将中断注册，是否返回?", "确定");
            }
        });
        this.i = (CheckBox) findViewById(R.id.show_password_checkbox);
        this.c = (EditText) findViewById(R.id.password_edittext);
        this.d = (TextView) findViewById(R.id.next_step_btn);
        Typeface create = Typeface.create(Typeface.DEFAULT, 0);
        this.j = (TextView) findViewById(R.id.contact_jd_pre_textview);
        this.j.setTypeface(create);
        this.k = (TextView) findViewById(R.id.contact_jd_btn);
        this.k.setTypeface(create);
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.requestFocus();
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.c.getContext().getSystemService("input_method")).showSoftInput(this.a.c, 0);
            }
        }, 500);
        this.l = (ImageView) findViewById(R.id.clear_password_image_btn);
        this.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.c.setText("");
            }
        });
        a("注册第三步");
    }

    protected void c() {
        this.a = a.b();
        this.b = getIntent().getStringExtra("phoneNumber");
        e();
    }

    private void e() {
        this.c.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNotEmpty(this.a.c.getText().toString().trim())) {
                    this.a.d.setEnabled(true);
                } else {
                    this.a.d.setEnabled(false);
                }
                if (this.a.c.getEditableText().length() > 0) {
                    this.a.l.setVisibility(0);
                } else {
                    this.a.l.setVisibility(4);
                }
            }
        });
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    String trim = this.a.c.getText().toString().trim();
                    if (trim.length() < 6) {
                        this.a.b(this.a.getResources().getString(R.string.set_password_error_tips));
                    } else {
                        this.a.a.setLoginPassword(this.a.b, trim, new OnCommonCallback(this) {
                            final /* synthetic */ AnonymousClass5 a;

                            {
                                this.a = r1;
                            }

                            public void onSuccess() {
                                this.a.a.b(this.a.a.getResources().getString(R.string.set_password_success));
                                this.a.a.f();
                                this.a.a.finish();
                            }

                            public void onFail(FailResult failResult) {
                                String message = failResult.getMessage();
                                switch (failResult.getReplyCode()) {
                                }
                                this.a.a.b(message);
                            }

                            public void onError(String str) {
                                String str2 = "";
                                if (str != null) {
                                    try {
                                        str2 = new JSONObject(str).getString("errMsg");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                this.a.a.b(str2);
                            }
                        });
                    }
                }
            }
        });
        this.i.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.a.c.setInputType(144);
                } else {
                    this.a.c.setInputType(129);
                }
                if (StringUtils.isNotEmpty(this.a.c.getText().toString())) {
                    this.a.c.setSelection(this.a.c.getText().toString().length());
                }
            }
        });
        this.k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:400-606-5500"));
                    intent.setFlags(268435456);
                    this.a.startActivity(intent);
                }
            }
        });
    }

    protected void d() {
    }

    private void f() {
        aa.b(this);
        finish();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (a(currentFocus, motionEvent)) {
            this.c.clearFocus();
            a(currentFocus.getWindowToken());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void a(Context context, String str, String str2) {
        new com.jd.fridge.widget.b.a(context, R.layout.unbind_phone_confirm_dlg_layout).b(str).a(b.DOUBLE_BTN).c(str2).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ SetPasswordActivity a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.finish();
            }

            public void b() {
            }
        }).show();
    }
}
