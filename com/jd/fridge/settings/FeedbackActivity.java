package com.jd.fridge.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.jd.fridge.bean.requestBody.Feedback;
import com.jd.fridge.util.f;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.b.a;
import com.jd.fridge.widget.b.a.b;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TbsSdkJava */
public class FeedbackActivity extends BaseActivity {
    private Context a;
    private String b = "";
    private OnClickListener c = new OnClickListener(this) {
        final /* synthetic */ FeedbackActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (!y.c()) {
                this.a.b = this.a.feedback_edittext.getText().toString().trim();
                if (TextUtils.isEmpty(this.a.b)) {
                    new a(this.a.a).a((int) R.string.activity_feedback_empty_content_toast_text).a(b.SINGLE_BTN).d(R.string.activity_feedback_empty_content_toast_btn).show();
                } else if (f.a(this.a.b)) {
                    new a(this.a.a).a((int) R.string.message_contains_emoji_toast).a(b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
                } else {
                    this.a.e();
                }
            }
        }
    };
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    @BindView(2131558584)
    TextView feedback_count_limit_textview;
    @BindView(2131558583)
    EditText feedback_edittext;

    protected int a() {
        return R.layout.activity_feedback;
    }

    protected void b() {
        this.a = this;
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_feedback_title_text);
        c((int) R.string.activity_feedback_send_text);
        setAppbarRightTextBtnClickListener(this.c);
        f(0);
        this.emptyLayout.setErrorType(4);
        this.feedback_edittext.setFocusable(true);
        this.feedback_edittext.setFocusableInTouchMode(true);
        this.feedback_edittext.requestFocus();
        new Timer().schedule(new TimerTask(this) {
            final /* synthetic */ FeedbackActivity a;

            {
                this.a = r1;
            }

            public void run() {
                ((InputMethodManager) this.a.feedback_edittext.getContext().getSystemService("input_method")).showSoftInput(this.a.feedback_edittext, 0);
            }
        }, 500);
        this.feedback_edittext.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FeedbackActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                int length = this.a.feedback_edittext.getEditableText().length();
                this.a.feedback_count_limit_textview.setText(this.a.getString(R.string.activity_failur_report_input_limit_text, new Object[]{length + ""}));
            }
        });
        a("意见反馈页面");
    }

    protected void c() {
    }

    protected void d() {
    }

    private void e() {
        if (y.d((Context) this)) {
            this.emptyLayout.setErrorType(2);
            com.jd.fridge.a.a().a(this.e, new Feedback(Long.parseLong(GlobalVariable.C()), this.b));
            return;
        }
        this.emptyLayout.setErrorType(11);
        Toast.makeText(this.a, R.string.activity_feedback_network_error_toast, 0).show();
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                this.emptyLayout.setErrorType(4);
                if (((ResponseDataBaseBean) message.obj).getStatus() == 0) {
                    Toast.makeText(getBaseContext(), R.string.activity_feedback_success_toast_btn, 0).show();
                    finish();
                    break;
                }
                break;
            case 2001:
                this.emptyLayout.setErrorType(4);
                break;
        }
        return super.a(message);
    }
}
