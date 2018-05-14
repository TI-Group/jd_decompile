package com.kepler.sdk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jd.jdsdk.R;

/* compiled from: TbsSdkJava */
public class as extends Dialog {

    /* compiled from: TbsSdkJava */
    public static class a {
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private View f;
        private OnClickListener g;
        private OnClickListener h;

        public a(Context context) {
            this.a = context;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a a(String str, OnClickListener onClickListener) {
            this.d = str;
            this.g = onClickListener;
            return this;
        }

        public a b(String str, OnClickListener onClickListener) {
            this.e = str;
            this.h = onClickListener;
            return this;
        }

        public as a() {
            int i = R.style.KeplerDialog;
            i = R.id.title;
            int i2 = R.id.kepler_positiveButton;
            int i3 = R.id.kepler_negativeButton;
            int i4 = R.id.kepler_dialog_message;
            int i5 = R.id.kepler_dialog_content;
            final as asVar = new as(this.a, a.a().e("KeplerDialog"));
            View c = a.a().c("kepler_simple_dialog_lay");
            asVar.addContentView(c, new LayoutParams(-1, -2));
            ((TextView) c.findViewById(i)).setText(this.b);
            if (this.d != null) {
                ((Button) c.findViewById(i2)).setText(this.d);
                if (this.g != null) {
                    ((Button) c.findViewById(i2)).setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ a b;

                        public void onClick(View view) {
                            this.b.g.onClick(asVar, -1);
                        }
                    });
                }
            } else {
                c.findViewById(i2).setVisibility(8);
            }
            if (this.e != null) {
                ((Button) c.findViewById(i3)).setText(this.e);
                if (this.h != null) {
                    ((Button) c.findViewById(i3)).setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ a b;

                        public void onClick(View view) {
                            this.b.h.onClick(asVar, -2);
                        }
                    });
                }
            } else {
                c.findViewById(i3).setVisibility(8);
            }
            if (this.c != null) {
                ((TextView) c.findViewById(i4)).setText(this.c);
            } else if (this.f != null) {
                ((LinearLayout) c.findViewById(i5)).removeAllViews();
                ((LinearLayout) c.findViewById(i5)).addView(this.f, new LayoutParams(-1, -1));
            }
            asVar.setContentView(c);
            return asVar;
        }
    }

    public as(Context context, int i) {
        super(context, i);
    }
}
