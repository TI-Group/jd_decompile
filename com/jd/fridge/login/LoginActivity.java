package com.jd.fridge.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.HomeWebViewActivity;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.r;
import com.jd.fridge.util.s;
import com.jd.fridge.util.y;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnLoginCallback;
import jd.wjlogin_sdk.common.listener.OnRefreshCheckCodeCallback;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.PicDataInfo;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class LoginActivity extends BaseActivity implements OnClickListener {
    private Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private EditText i;
    private EditText j;
    private CheckBox k;
    private WJLoginHelper l;
    private PicDataInfo m;
    private LinearLayout n;
    private EditText o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private boolean s;
    private OnLoginCallback t = new OnLoginCallback(this) {
        final /* synthetic */ LoginActivity a;

        {
            this.a = r1;
        }

        public void onSuccess() {
            try {
                a.a().b(this.a.e, new UserPin(URLEncoder.encode(this.a.l.getPin(), CommonUtil.UTF8)));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.a.p();
            }
            r.b("infos", "=====onSuccess=====");
        }

        public void onError(String str) {
            r.b("infos", "=====onError=====" + str);
            this.a.j();
            String str2 = "";
            if (str != null) {
                try {
                    str2 = new JSONObject(str).getString("errMsg");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            r.b("infos", "tip==" + str2);
            this.a.b(str2);
        }

        public void onFail(FailResult failResult, PicDataInfo picDataInfo) {
            r.b("infos", "=====onFail=====" + picDataInfo);
            this.a.j();
            try {
                String message = failResult.getMessage();
                this.a.m = picDataInfo;
                if (picDataInfo != null) {
                    this.a.n.setVisibility(0);
                    byte[] bArr = this.a.m.getsPicData();
                    this.a.p.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                this.a.b(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onFail(FailResult failResult, JumpResult jumpResult, PicDataInfo picDataInfo) {
            r.b("infos", "=====onFail1111=====");
            this.a.j();
            try {
                failResult.getMessage();
                this.a.m = picDataInfo;
                if (picDataInfo != null) {
                    this.a.n.setVisibility(0);
                    byte[] bArr = this.a.m.getsPicData();
                    this.a.p.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                if (failResult.getReplyCode() >= Byte.MIN_VALUE && failResult.getReplyCode() <= (byte) -113 && !StringUtils.isEmpty(jumpResult.getUrl()) && !StringUtils.isEmpty(jumpResult.getToken())) {
                    Intent intent = new Intent(this.a, BindWebActivity.class);
                    intent.putExtra("url", this.a.a(failResult, jumpResult.getUrl(), jumpResult.getToken()));
                    intent.putExtra("token", jumpResult.getToken());
                    intent.putExtra("callBackActivity", LoginActivity.class.getName());
                    this.a.startActivityForResult(intent, 200);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    protected int a() {
        return R.layout.login_activity;
    }

    protected void b() {
        this.a = this;
        k();
        b(true);
        findViewById(R.id.tv_privacy_policy).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.q();
            }
        });
        this.j = (EditText) findViewById(R.id.username_edittext);
        this.j.setFocusable(true);
        this.j.setFocusableInTouchMode(true);
        this.i = (EditText) findViewById(R.id.password_edittext);
        this.i.setFocusable(true);
        this.i.setFocusableInTouchMode(true);
        this.b = (TextView) findViewById(R.id.sign_in_button);
        this.b.setOnClickListener(this);
        this.b.setEnabled(false);
        this.c = (TextView) findViewById(R.id.sign_up_button);
        this.c.setOnClickListener(this);
        this.d = (TextView) findViewById(R.id.forget_password_button);
        this.d.setOnClickListener(this);
        this.k = (CheckBox) findViewById(R.id.remember_password_checkbox);
        this.k.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.a.i.setInputType(144);
                } else {
                    this.a.i.setInputType(129);
                }
                if (StringUtils.isNotEmpty(this.a.i.getText().toString())) {
                    this.a.i.setSelection(this.a.i.getText().toString().length());
                }
            }
        });
        this.n = (LinearLayout) findViewById(R.id.image_code_view);
        this.o = (EditText) findViewById(R.id.image_code_edittext);
        this.p = (ImageView) findViewById(R.id.image_code_img);
        this.p.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    try {
                        if (this.a.m != null) {
                            this.a.m.setAuthCode("0");
                            this.a.l.refreshImageCode(this.a.m, new OnRefreshCheckCodeCallback(this) {
                                final /* synthetic */ AnonymousClass3 a;

                                {
                                    this.a = r1;
                                }

                                public void onSuccess(PicDataInfo picDataInfo) {
                                    this.a.a.m = picDataInfo;
                                    if (picDataInfo != null) {
                                        this.a.a.n.setVisibility(0);
                                        byte[] bArr = this.a.a.m.getsPicData();
                                        this.a.a.p.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                                    }
                                }

                                public void onFail(FailResult failResult) {
                                    if (failResult.getReplyCode() == ReplyCode.reply0x11) {
                                        this.a.a.m = null;
                                        this.a.a.n.setVisibility(8);
                                    }
                                    if (failResult.getReplyCode() == ReplyCode.reply0x12) {
                                        this.a.a.m = null;
                                        this.a.a.n.setVisibility(8);
                                    }
                                    this.a.a.b(failResult.getMessage());
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
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.q = (ImageView) findViewById(R.id.clear_user_name_image_btn);
        this.q.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.j.setText("");
            }
        });
        this.r = (ImageView) findViewById(R.id.clear_password_image_btn);
        this.r.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.i.setText("");
            }
        });
        a("登录页面");
        JPushInterface.resumePush(this);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (a(currentFocus, motionEvent)) {
            this.j.clearFocus();
            this.i.clearFocus();
            a(currentFocus.getWindowToken());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void c() {
        this.l = com.jd.fridge.util.c.a.b();
        Object userAccount = this.l.getUserAccount();
        if (userAccount != null) {
            this.j.setText(userAccount);
            this.j.setSelection(userAccount.length());
            this.q.setVisibility(0);
            this.i.setText("");
            this.i.clearFocus();
        }
        e();
    }

    protected void d() {
    }

    private void e() {
        this.j.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (!this.a.s) {
                    this.a.i.setText("");
                }
                if (this.a.i.getEditableText().length() <= 0 || this.a.j.getEditableText().length() <= 0) {
                    this.a.b.setEnabled(false);
                } else {
                    this.a.b.setEnabled(true);
                }
                if (this.a.j.getEditableText().length() > 0) {
                    this.a.q.setVisibility(0);
                } else {
                    this.a.q.setVisibility(4);
                }
            }
        });
        this.i.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LoginActivity a;

            {
                this.a = r1;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                this.a.s = true;
                if (this.a.i.getEditableText().length() <= 0 || this.a.j.getEditableText().length() <= 0) {
                    this.a.b.setEnabled(false);
                } else {
                    this.a.b.setEnabled(true);
                }
                if (this.a.i.getEditableText().length() > 0) {
                    this.a.r.setVisibility(0);
                } else {
                    this.a.r.setVisibility(4);
                }
            }
        });
    }

    private boolean f() {
        String trim = this.j.getText().toString().trim();
        if (trim == null || trim.equals("")) {
            b(getString(R.string.input_user_account));
            this.j.setFocusable(true);
            return false;
        }
        trim = this.i.getText().toString().trim();
        if (trim == null || trim.equals("")) {
            b(getString(R.string.input_user_password));
            this.i.setFocusable(true);
            return false;
        }
        trim = this.o.getText().toString().trim();
        if (this.m == null || (trim != null && !trim.equals(""))) {
            return true;
        }
        b(getString(R.string.input_image_code_hint_text));
        this.o.setFocusable(true);
        return false;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.l = null;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_up_button:
                if (!y.c()) {
                    g();
                    return;
                }
                return;
            case R.id.forget_password_button:
                if (!y.c()) {
                    h();
                    return;
                }
                return;
            case R.id.sign_in_button:
                if (!y.c()) {
                    b("APP_登录页_登录按钮", "fridgeapp_201609146|1");
                    i();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void g() {
        startActivityForResult(new Intent(this.a, PhoneRegisterActivity.class), 100);
    }

    private void h() {
        Intent intent = new Intent(this.a, HomeWebViewActivity.class);
        intent.putExtra("url", "https://plogin.m.jd.com/user/mfindpwd_notitle?appid=194&returnurl=http%3a%2f%2fwjlogina%3fstatus%3dtrue%26action%3dlogin");
        intent.putExtra("title", getString(R.string.find_back_password));
        startActivity(intent);
    }

    private void i() {
        if (!f()) {
            return;
        }
        if (this.s || this.l.isNeedPwdInput()) {
            String trim = this.j.getEditableText().toString().trim();
            String a = s.a(this.i.getEditableText().toString().trim(), s.a.Length32);
            if (this.m != null) {
                this.m.setAuthCode(this.o.getText().toString().trim());
            }
            a_(false);
            this.l.JDLoginWithPassword(trim, a, this.m, Boolean.valueOf(true), this.t);
            return;
        }
        this.l.quickLogin(this.t);
    }

    private String a(FailResult failResult, String str, String str2) {
        return String.format("%1$s?appid=%2$s&token=%3$s&returnurl=openApp.jdMobile://communication", new Object[]{str, Short.valueOf(com.jd.fridge.util.c.a.a().getDwAppID()), str2});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 100 == i && StringUtils.isNotEmpty(intent.getStringExtra("phoneNum"))) {
            this.j.setText(intent.getStringExtra("phoneNum"));
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                Object obj = (List) message.obj;
                if (obj != null && obj.size() != 0) {
                    if (obj.size() != 1) {
                        j();
                        b(getString(R.string.login_success));
                        obj = new Gson().toJson(obj);
                        if (!TextUtils.isEmpty(obj)) {
                            com.jd.fridge.util.a.a().b();
                            Intent intent = new Intent(this, SwitchFridgeActivity.class);
                            intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", true);
                            intent.putExtra("FEED_ID_JSON_STRING", obj);
                            startActivity(intent);
                            break;
                        }
                        p();
                        break;
                    }
                    GlobalVariable.c(((FridgeInfoBean) obj.get(0)).getFeedId());
                    GlobalVariable.d(((FridgeInfoBean) obj.get(0)).getDeviceId());
                    GlobalVariable.d(((FridgeInfoBean) obj.get(0)).getRear_camera());
                    GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getBrand());
                    GlobalVariable.f(((FridgeInfoBean) obj.get(0)).getBug_report());
                    GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getControl_page());
                    b.a().c(((FridgeInfoBean) obj.get(0)).getProduct_uuid());
                    p();
                    break;
                }
                p();
                break;
                break;
            case 2001:
                p();
                break;
        }
        return true;
    }

    private void p() {
        j();
        b(getString(R.string.login_success));
        com.jd.fridge.util.a.a().b();
        aa.a((Activity) this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        com.jd.fridge.util.a.a().b();
        return true;
    }

    private void q() {
        aa.a(this, 0, null);
    }
}
