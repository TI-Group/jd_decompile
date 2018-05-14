package com.jd.fridge.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class a extends Dialog {
    private Context a;

    public a(Context context) {
        super(context, R.style.customProgressDialog);
        this.a = context;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        a(true);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(131072);
        setContentView(R.layout.custom_progress_dialog_layout);
    }

    public void a(boolean z) {
        if (z) {
            getWindow().setFlags(8, 8);
            getWindow().clearFlags(2);
            return;
        }
        getWindow().clearFlags(8);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
    }
}
