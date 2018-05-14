package com.jd.fridge.userInfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.ModifyNickBaseBean;
import com.jd.fridge.bean.requestBody.Nickname;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.b.a;
import com.jd.fridge.widget.b.a.b;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TbsSdkJava */
public class ModifyNickActivity extends BaseActivity {
    private Context a;
    private OnClickListener b = new OnClickListener(this) {
        final /* synthetic */ ModifyNickActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (!y.c()) {
                if (this.a.user_nickname_edittext.length() > 20 || this.a.user_nickname_edittext.length() < 4) {
                    new a(this.a.a).a((int) R.string.activity_modify_user_nickname_out_of_bound_text).a(b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
                } else {
                    this.a.e();
                }
            }
        }
    };
    @BindView(2131558611)
    ImageView clear_text_image_btn;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    @BindView(2131558610)
    EditText user_nickname_edittext;

    protected int a() {
        return R.layout.activity_modify_nickname;
    }

    protected void b() {
        this.a = this;
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_modify_user_nickname_title_text);
        c((int) R.string.activity_modify_user_nickname_comfirm_text);
        setAppbarRightTextBtnClickListener(this.b);
        f(0);
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ ModifyNickActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.e();
            }
        });
        CharSequence trim = getIntent().getStringExtra("UserNickname").trim();
        this.user_nickname_edittext.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ModifyNickActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    if (this.a.clear_text_image_btn.getVisibility() == 0) {
                        this.a.clear_text_image_btn.setVisibility(4);
                    }
                } else if (this.a.clear_text_image_btn.getVisibility() == 4) {
                    this.a.clear_text_image_btn.setVisibility(0);
                }
            }
        });
        if (TextUtils.isEmpty(trim)) {
            this.clear_text_image_btn.setVisibility(4);
            return;
        }
        this.user_nickname_edittext.setText(trim);
        this.user_nickname_edittext.selectAll();
        this.user_nickname_edittext.setFocusable(true);
        this.user_nickname_edittext.setFocusableInTouchMode(true);
        this.user_nickname_edittext.requestFocus();
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ ModifyNickActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.user_nickname_edittext.getContext().getSystemService("input_method")).showSoftInput(this.a.user_nickname_edittext, 0);
            }
        }, 500);
    }

    protected void c() {
    }

    protected void d() {
    }

    @OnClick({2131558611})
    public void clearEditText() {
        this.user_nickname_edittext.setText("");
    }

    private void e() {
        if (y.d((Context) this)) {
            this.emptyLayout.setErrorType(2);
            com.jd.fridge.a.a().a(this.e, new Nickname(this.user_nickname_edittext.getText().toString()));
            return;
        }
        this.emptyLayout.setErrorType(11);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                this.emptyLayout.setErrorType(4);
                ModifyNickBaseBean modifyNickBaseBean = (ModifyNickBaseBean) message.obj;
                if (modifyNickBaseBean.getResult().getResultCode() != 1) {
                    new a(this.a).b(modifyNickBaseBean.getResult().getResultMsg()).a(b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
                    break;
                }
                Toast.makeText(getBaseContext(), modifyNickBaseBean.getResult().getResultMsg(), 1).show();
                Intent intent = new Intent("ACTION_MODIFY_NICKNAME_SUCCESS");
                intent.putExtra("nickname", this.user_nickname_edittext.getEditableText().toString());
                sendBroadcast(intent);
                finish();
                break;
            case 2001:
                this.emptyLayout.setErrorType(10);
                break;
        }
        return super.a(message);
    }
}
