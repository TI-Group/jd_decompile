package com.jd.fridge.widget.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class c extends Dialog implements OnCancelListener, OnDismissListener {
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

    public c(Context context) {
        super(context, R.style.FramelessDialog);
        this.a = context;
        setContentView(R.layout.update_confirm_dlg_layout);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(this);
        setOnDismissListener(this);
        a();
    }

    public c a(b bVar) {
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

    public c a(boolean z) {
        setCancelable(z);
        return this;
    }

    public c a(int i) {
        this.b.setText(getContext().getString(i));
        this.b.setVisibility(0);
        return this;
    }

    public c b(int i) {
        this.c.setText(getContext().getString(i));
        this.c.setVisibility(0);
        return this;
    }

    public c a(String str) {
        this.c.setText(str);
        this.c.setVisibility(0);
        return this;
    }

    public c b(String str) {
        this.d.setText(str);
        return this;
    }

    public c c(int i) {
        this.g.setText(getContext().getString(i));
        return this;
    }

    public c d(int i) {
        this.e.setText(getContext().getString(i));
        return this;
    }

    public c e(int i) {
        this.f.setText(getContext().getString(i));
        return this;
    }

    public c a(a aVar) {
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
            final /* synthetic */ c a;

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
            final /* synthetic */ c a;

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
            final /* synthetic */ c a;

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
