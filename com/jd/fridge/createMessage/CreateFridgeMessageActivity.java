package com.jd.fridge.createMessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.ResponseDataBaseBean;
import com.jd.fridge.bean.requestBody.CreateMessage;
import com.jd.fridge.util.f;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.b.a;
import com.jd.fridge.widget.b.a.b;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TbsSdkJava */
public class CreateFridgeMessageActivity extends BaseActivity {
    private Context a;
    private OnClickListener b = new OnClickListener(this) {
        final /* synthetic */ CreateFridgeMessageActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (!y.c()) {
                this.a.b("APP_我的_新建留言页_发送按钮", "fridgeapp_201609146|34");
                String trim = this.a.fridge_message_edittext.getEditableText().toString().trim();
                if (trim.length() == 0) {
                    new a(this.a.a).a((int) R.string.creage_fridge_message_empty_toast_text).a(b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
                } else if (f.a(trim)) {
                    new a(this.a.a).a((int) R.string.message_contains_emoji_toast).a(b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
                } else {
                    this.a.h.setClickable(false);
                    this.a.h.setEnabled(false);
                    String str = null;
                    try {
                        str = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    com.jd.fridge.a.a().a(this.a.e, new CreateMessage(str, Long.parseLong(GlobalVariable.C()), trim));
                }
            }
        }
    };
    @BindView(2131558556)
    EditText fridge_message_edittext;
    @BindView(2131558557)
    TextView input_limit_textview;

    protected int a() {
        return R.layout.activity_create_fridge_message;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        this.a = this;
        b((int) R.string.activity_creage_fridge_message_title_text);
        c((int) R.string.activity_creage_fridge_message_send_text);
        setAppbarRightTextBtnClickListener(this.b);
        f(0);
        int length = this.fridge_message_edittext.getEditableText().length();
        this.input_limit_textview.setText(getString(R.string.creage_fridge_message_input_limit_text, new Object[]{length + ""}));
        this.fridge_message_edittext.setFocusable(true);
        this.fridge_message_edittext.setFocusableInTouchMode(true);
        this.fridge_message_edittext.requestFocus();
        this.fridge_message_edittext.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ CreateFridgeMessageActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                int length = this.a.fridge_message_edittext.getEditableText().length();
                this.a.input_limit_textview.setText(this.a.getString(R.string.creage_fridge_message_input_limit_text, new Object[]{length + ""}));
            }
        });
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ CreateFridgeMessageActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.fridge_message_edittext.getContext().getSystemService("input_method")).showSoftInput(this.a.fridge_message_edittext, 0);
            }
        }, 500);
        a("新建留言页");
    }

    protected void c() {
    }

    protected void d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ((GlobalVariable) getApplication()).a(displayMetrics.density);
        ((GlobalVariable) getApplication()).a(displayMetrics.widthPixels);
        ((GlobalVariable) getApplication()).b(displayMetrics.heightPixels);
    }

    public boolean a(Message message) {
        int i = 1;
        switch (message.what) {
            case 2000:
                int i2;
                ResponseDataBaseBean responseDataBaseBean = (ResponseDataBaseBean) message.obj;
                if (responseDataBaseBean.getStatus() == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (responseDataBaseBean.getResult() != null) {
                    i = 0;
                }
                if ((i2 & i) != 0) {
                    Toast.makeText(getBaseContext(), R.string.creage_fridge_message_add_message_success_toast, 0).show();
                    sendBroadcast(new Intent("ACTION_CREATE_MESSAGE_SUCCESS"));
                    finish();
                    break;
                }
                break;
        }
        return super.a(message);
    }
}
