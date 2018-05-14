package com.jd.fridge.login;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jd.fridge.PrivacyPolicyActivity;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.b.a.b;
import java.util.Timer;
import java.util.TimerTask;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.CheckImageCodeAndPhoneNumCallBack;
import jd.wjlogin_sdk.common.listener.OnGetMessageCodeCallback;
import jd.wjlogin_sdk.common.listener.OnGetMessagePwdExpireTimeCallback;
import jd.wjlogin_sdk.common.listener.OnNeedImageCodeCallBack;
import jd.wjlogin_sdk.common.listener.OnRefreshCheckCodeCallback;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.PicDataInfo;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class PhoneRegisterActivity extends BaseActivity {
    private final String a = "http://static.360buyimg.com/nsng/common/fridge/html/agreement/register.html";
    private EditText b;
    private ImageView c;
    private LinearLayout d;
    private EditText i;
    private ImageView j;
    private CheckBox k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private PicDataInfo p;
    private boolean q;
    private WJLoginHelper r;
    private String s;

    protected int a() {
        return R.layout.phone_register_view;
    }

    protected void b() {
        c(getString(R.string.fast_register_title));
        this.b = (EditText) findViewById(R.id.phone_number_edittext);
        this.d = (LinearLayout) findViewById(R.id.image_code_view);
        this.i = (EditText) findViewById(R.id.image_code_edittext);
        this.j = (ImageView) findViewById(R.id.image_code_img);
        this.k = (CheckBox) findViewById(R.id.register_agree_cb);
        this.k.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    this.a.m.setEnabled(false);
                } else if (this.a.b.getEditableText().length() > 0) {
                    this.a.m.setEnabled(true);
                } else {
                    this.a.m.setEnabled(false);
                }
            }
        });
        this.c = (ImageView) findViewById(R.id.clear_phone_number_image_btn);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b.setText("");
            }
        });
        this.l = (TextView) findViewById(R.id.register_agree_url);
        this.m = (TextView) findViewById(R.id.next_step_btn);
        Typeface create = Typeface.create(Typeface.DEFAULT, 0);
        this.o = (TextView) findViewById(R.id.contact_jd_pre_textview);
        this.o.setTypeface(create);
        this.n = (TextView) findViewById(R.id.contact_jd_btn);
        this.n.setTypeface(create);
        ((TextView) findViewById(R.id.register_agree_text)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.k.setChecked(!this.a.k.isChecked());
            }
        });
        this.b.setFocusable(true);
        this.b.setFocusableInTouchMode(true);
        this.b.requestFocus();
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.b.getContext().getSystemService("input_method")).showSoftInput(this.a.b, 0);
            }
        }, 500);
        a("注册第一步");
    }

    protected void c() {
        this.r = a.b();
        this.p = new PicDataInfo();
        this.p.setAuthCode("0");
        this.p.setStEncryptKey("");
        f();
        e();
    }

    private void e() {
        this.r.isNeedImageCode(new OnNeedImageCodeCallBack(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(PicDataInfo picDataInfo) {
                this.a.j();
                this.a.p = picDataInfo;
                if (picDataInfo != null) {
                    this.a.d.setVisibility(0);
                    this.a.q = true;
                    byte[] bArr = this.a.p.getsPicData();
                    this.a.j.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.a.i.setText("");
                    return;
                }
                this.a.q = false;
                this.a.d.setVisibility(8);
            }

            public void onFail(FailResult failResult) {
                this.a.b(failResult.getMessage());
                this.a.d.setVisibility(8);
                this.a.q = false;
            }

            public void onError(String str) {
                this.a.j();
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

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (a(currentFocus, motionEvent)) {
            this.b.clearFocus();
            this.i.clearFocus();
            a(currentFocus.getWindowToken());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void f() {
        this.b.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNotEmpty(this.a.b.getText().toString().trim()) && this.a.k.isChecked()) {
                    this.a.m.setEnabled(true);
                } else {
                    this.a.m.setEnabled(false);
                }
                if (this.a.b.getEditableText().length() > 0) {
                    this.a.c.setVisibility(0);
                } else {
                    this.a.c.setVisibility(4);
                }
            }
        });
        this.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    Intent intent = new Intent(this.a, PrivacyPolicyActivity.class);
                    intent.putExtra("url", "http://static.360buyimg.com/nsng/common/fridge/html/agreement/register.html");
                    intent.putExtra("title", this.a.getString(R.string.jd_service_register_title));
                    intent.putExtra("style", 0);
                    this.a.startActivity(intent);
                }
            }
        });
        this.j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    try {
                        if (this.a.p != null) {
                            this.a.a_(true);
                            this.a.p.setAuthCode("0");
                            this.a.g();
                        }
                    } catch (Exception e) {
                        this.a.j();
                    }
                }
            }
        });
        this.m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.k.isChecked()) {
                        this.a.s = this.a.b.getText().toString().trim();
                        Object trim = this.a.i.getText().toString().trim();
                        if (TextUtils.isEmpty(this.a.s)) {
                            this.a.a((int) R.string.inputPhotoNum);
                            return;
                        } else if (this.a.s.length() < 11 || this.a.s.length() > 12) {
                            this.a.a((int) R.string.phoneNumError);
                            return;
                        } else if (this.a.q && this.a.p == null) {
                            this.a.a((int) R.string.freshImageCode);
                            return;
                        } else if (this.a.q && TextUtils.isEmpty(trim)) {
                            this.a.a((int) R.string.inputImageCode);
                            return;
                        } else {
                            if (this.a.p != null) {
                                this.a.p.setAuthCode(trim);
                            }
                            this.a.r.checkImageCodeAndPhoneNum(this.a.p, this.a.s, this.a.q, new CheckImageCodeAndPhoneNumCallBack(this) {
                                final /* synthetic */ AnonymousClass14 a;

                                {
                                    this.a = r1;
                                }

                                public void onFail(FailResult failResult, PicDataInfo picDataInfo) {
                                    String message = failResult.getMessage();
                                    if (failResult.getReplyCode() == ReplyCode.reply0x16) {
                                        this.a.a.a(this.a.a, "", this.a.a.getResources().getString(R.string.unbindMsg), this.a.a.getResources().getString(R.string.confirm2), "unbind");
                                    } else if (failResult.getReplyCode() == ReplyCode.reply0xf || failResult.getReplyCode() == ReplyCode.reply0x11) {
                                        this.a.a.p = picDataInfo;
                                        if (picDataInfo != null) {
                                            this.a.a.d.setVisibility(0);
                                            byte[] bArr = this.a.a.p.getsPicData();
                                            this.a.a.j.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                            this.a.a.i.setText("");
                                        }
                                        this.a.a.d(message + this.a.a.getResources().getString(R.string.inputAgain));
                                    } else {
                                        this.a.a.d(message);
                                    }
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

                                public void onSuccess() {
                                    this.a.a.a(this.a.a, "我们将发送短信息验证码至: ", this.a.a.b.getEditableText().toString(), this.a.a.getResources().getString(R.string.confirm2), "sendsms");
                                }
                            });
                            return;
                        }
                    }
                    this.a.a((int) R.string.jd_service_agreement_unchecked_text);
                }
            }
        });
        this.n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PhoneRegisterActivity a;

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

    private void a(int i) {
        Toast.makeText(this, getString(i), 0).show();
    }

    private void d(String str) {
        Toast.makeText(this, str, 0).show();
    }

    protected void d() {
    }

    private void a(Context context, String str, String str2, String str3, final String str4) {
        new com.jd.fridge.widget.b.a(context, R.layout.unbind_phone_confirm_dlg_layout).b(str2).a(str).a(b.DOUBLE_BTN).c(str3).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ PhoneRegisterActivity b;

            public void a() {
                if (str4.equals("unbind")) {
                    this.b.i();
                } else if (str4.equals("sendsms")) {
                    this.b.h();
                }
            }

            public void b() {
            }
        }).show();
    }

    private void g() {
        this.r.refreshImageCode(this.p, new OnRefreshCheckCodeCallback(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(PicDataInfo picDataInfo) {
                this.a.j();
                this.a.d.setVisibility(0);
                this.a.p = picDataInfo;
                if (picDataInfo != null) {
                    byte[] bArr = this.a.p.getsPicData();
                    this.a.j.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                this.a.i.setText("");
            }

            public void onFail(FailResult failResult) {
                this.a.j();
                if (failResult.getReplyCode() == ReplyCode.reply0x11) {
                    this.a.p = null;
                }
                if (failResult.getReplyCode() == ReplyCode.reply0x12) {
                    this.a.p = null;
                }
                this.a.b(failResult.getMessage());
            }

            public void onError(String str) {
                this.a.j();
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

    private void a(int i, boolean z) {
        Intent intent = new Intent(this, InputMessageCodeActivity.class);
        intent.putExtra("pwdExpireTime", i);
        intent.putExtra("phoneNum", this.s);
        intent.putExtra("unbind", z);
        startActivity(intent);
        finish();
    }

    private void h() {
        a_(true);
        this.r.getMessageCode(this.s, new OnGetMessageCodeCallback(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(int i) {
                this.a.j();
                this.a.a(i, false);
            }

            public void onFail(FailResult failResult) {
                this.a.j();
                this.a.b(failResult.getMessage());
            }

            public void onError(String str) {
                this.a.j();
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

    private void i() {
        a_(true);
        this.r.unBindPhoneNum(this.s, new OnGetMessagePwdExpireTimeCallback(this) {
            final /* synthetic */ PhoneRegisterActivity a;

            {
                this.a = r1;
            }

            public void onSuccess(int i) {
                this.a.j();
                this.a.a(i, true);
            }

            public void onError(String str) {
                this.a.j();
                this.a.b(str);
            }

            public void onFail(FailResult failResult) {
                this.a.j();
                String message = failResult.getMessage();
                if (failResult.getReplyCode() == ReplyCode.reply0x17) {
                    this.a.b(message);
                } else if (failResult.getReplyCode() == ReplyCode.reply0x1f) {
                    this.a.b(message);
                } else {
                    this.a.b(message);
                }
            }
        });
    }
}
