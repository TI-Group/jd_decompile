package com.jd.fridge.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.b.a.b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.Timer;
import java.util.TimerTask;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.common.listener.OnGetMessageCodeCallback;
import jd.wjlogin_sdk.common.listener.OnGetMessagePwdExpireTimeCallback;
import jd.wjlogin_sdk.model.FailResult;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class InputMessageCodeActivity extends BaseActivity {
    private TextView a;
    private EditText b;
    private Chronometer c;
    private TextView d;
    private TextView i;
    private TextView j;
    private ImageView k;
    private WJLoginHelper l;
    private String m;
    private boolean n;
    private long o = 0;
    private int p = ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR;

    protected int a() {
        return R.layout.phone_message_code_view;
    }

    protected void b() {
        c(getString(R.string.input_message_code_title_text));
        setAppbarBackBtnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a(this.a, "点击\"返回\"将中断注册，是否返回?", "确定");
            }
        });
        this.a = (TextView) findViewById(R.id.phone_number_text);
        this.b = (EditText) findViewById(R.id.message_code_edittext);
        this.b.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
        this.b.requestFocus();
        this.k = (ImageView) findViewById(R.id.clear_message_code_image_btn);
        this.k.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b.setText("");
            }
        });
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.b.getContext().getSystemService("input_method")).showSoftInput(this.a.b, 0);
            }
        }, 500);
        this.c = (Chronometer) findViewById(R.id.get_code_btn);
        this.d = (TextView) findViewById(R.id.next_step_btn);
        Typeface create = Typeface.create(Typeface.DEFAULT, 0);
        this.j = (TextView) findViewById(R.id.contact_jd_pre_textview);
        this.j.setTypeface(create);
        this.i = (TextView) findViewById(R.id.contact_jd_btn);
        this.i.setTypeface(create);
        a("注册第二步");
    }

    protected void c() {
        this.m = getIntent().getStringExtra("phoneNum");
        if (StringUtils.isNotEmpty(this.m)) {
            this.a.setText(getString(R.string.input_message_code_top_hint, new Object[]{this.m}));
        }
        this.o = (long) getIntent().getIntExtra("pwdExpireTime", ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
        this.n = getIntent().getBooleanExtra("unbind", false);
        this.l = a.b();
        e();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (a(currentFocus, motionEvent)) {
            this.b.clearFocus();
            a(currentFocus.getWindowToken());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void e() {
        this.b.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNotEmpty(this.a.b.getText().toString().trim())) {
                    this.a.d.setEnabled(true);
                } else {
                    this.a.d.setEnabled(false);
                }
                if (this.a.b.getEditableText().length() > 0) {
                    this.a.k.setVisibility(0);
                } else {
                    this.a.k.setVisibility(4);
                }
            }
        });
        this.c.setText(getString(R.string.get_message_code_text));
        this.c.setOnChronometerTickListener(new OnChronometerTickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onChronometerTick(Chronometer chronometer) {
                if (this.a.o - (SystemClock.elapsedRealtime() / 1000) > 0) {
                    this.a.c.setEnabled(false);
                    this.a.c.setText(this.a.getString(R.string.get_message_code_again, new Object[]{((this.a.o - (SystemClock.elapsedRealtime() / 1000)) % ((long) this.a.p)) + ""}));
                    return;
                }
                this.a.c.stop();
                this.a.c.setEnabled(true);
                this.a.c.setText(this.a.getString(R.string.get_message_code_text));
            }
        });
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.n) {
                        this.a.g();
                    } else {
                        this.a.f();
                    }
                }
            }
        });
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                String trim = this.a.b.getText().toString().trim();
                if (trim.length() == 0) {
                    this.a.a((int) R.string.inputMessageCodeToastText);
                    return;
                }
                this.a.a_(true);
                this.a.l.checkMessageCode(this.a.m, trim, new OnCommonCallback(this) {
                    final /* synthetic */ AnonymousClass9 a;

                    {
                        this.a = r1;
                    }

                    public void onSuccess() {
                        this.a.a.j();
                        Intent intent = new Intent(this.a.a, SetPasswordActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("phoneNumber", this.a.a.m);
                        intent.putExtras(bundle);
                        this.a.a.startActivity(intent);
                        this.a.a.finish();
                    }

                    public void onFail(FailResult failResult) {
                        this.a.a.j();
                        this.a.a.b(failResult.getMessage());
                    }

                    public void onError(String str) {
                        this.a.a.j();
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
        });
        this.i.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InputMessageCodeActivity a;

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
        this.o = (this.o - 1) + (SystemClock.elapsedRealtime() / 1000);
        this.c.start();
    }

    protected void d() {
    }

    private void a(int i) {
        Toast.makeText(this, getString(i), 0).show();
    }

    private void f() {
        this.l.getMessageCode(this.m, new OnGetMessageCodeCallback(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(int i) {
                this.a.p = i;
                this.a.o = ((long) (i - 1)) + (SystemClock.elapsedRealtime() / 1000);
                this.a.c.start();
                this.a.b(this.a.getString(R.string.message_code_has_been_sent_to_phone));
            }

            public void onFail(FailResult failResult) {
                this.a.b(failResult.getMessage());
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
                this.a.b(str2);
            }
        });
    }

    private void g() {
        this.l.unBindPhoneNum(this.m, new OnGetMessagePwdExpireTimeCallback(this) {
            final /* synthetic */ InputMessageCodeActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(int i) {
                this.a.p = i;
                this.a.o = ((long) (i - 1)) + (SystemClock.elapsedRealtime() / 1000);
                this.a.c.start();
                this.a.b(this.a.getString(R.string.message_code_has_been_sent_to_phone));
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
                this.a.b(str2);
            }

            public void onFail(FailResult failResult) {
                this.a.b(failResult.getMessage());
            }
        });
    }

    private void a(Context context, String str, String str2) {
        new com.jd.fridge.widget.b.a(context, R.layout.unbind_phone_confirm_dlg_layout).b(str).a(b.DOUBLE_BTN).c(str2).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ InputMessageCodeActivity a;

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
