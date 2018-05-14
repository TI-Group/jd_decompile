package com.jd.fridge.widget.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class a extends Dialog implements OnCancelListener, OnDismissListener {
    final Context a;
    private TextView b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private Button g;
    private View h;
    private a i;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: TbsSdkJava */
    public enum b {
        SINGLE_BTN,
        DOUBLE_BTN
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
    }

    public a(Context context) {
        super(context, R.style.FramelessDialog);
        this.a = context;
        setContentView(R.layout.confirm_dlg_layout);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(this);
        setOnDismissListener(this);
        a();
    }

    public a(Context context, int i) {
        super(context, R.style.FramelessDialog);
        this.a = context;
        setContentView(i);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(this);
        setOnDismissListener(this);
        a();
    }

    public a a(b bVar) {
        switch (bVar) {
            case SINGLE_BTN:
                this.h.setVisibility(8);
                this.f.setVisibility(0);
                break;
            case DOUBLE_BTN:
                this.h.setVisibility(0);
                this.f.setVisibility(8);
                break;
        }
        return this;
    }

    public a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.setText(str);
            this.b.setVisibility(0);
        }
        return this;
    }

    public a a(int i) {
        this.d.setText(getContext().getString(i));
        return this;
    }

    public a a(Spannable spannable) {
        this.d.setText(spannable);
        return this;
    }

    public a b(String str) {
        this.d.setText(str);
        return this;
    }

    public a b(int i) {
        this.g.setText(getContext().getString(i));
        return this;
    }

    public a c(int i) {
        this.e.setText(getContext().getString(i));
        return this;
    }

    public a c(String str) {
        this.e.setText(str);
        return this;
    }

    public a d(int i) {
        this.f.setText(getContext().getString(i));
        return this;
    }

    public a a(a aVar) {
        this.i = aVar;
        return this;
    }

    private void a() {
        this.h = findViewById(R.id.confirm_btn_group);
        this.b = (TextView) findViewById(R.id.title_textview);
        this.c = (TextView) findViewById(R.id.title_tip_textview);
        this.d = (TextView) findViewById(R.id.content_textview);
        this.e = (Button) findViewById(R.id.confirm_button);
        this.e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.i != null) {
                    this.a.i.a();
                }
                this.a.dismiss();
            }
        });
        this.g = (Button) findViewById(R.id.cancel_button);
        this.g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.i != null) {
                    this.a.i.b();
                }
                this.a.dismiss();
            }
        });
        this.f = (Button) findViewById(R.id.finish_button);
        this.f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.i != null) {
                    this.a.i.a();
                }
                this.a.dismiss();
            }
        });
    }
}
