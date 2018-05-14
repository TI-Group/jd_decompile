package com.jd.fridge.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.ShareDataBean;
import com.jd.fridge.util.y;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: TbsSdkJava */
public class b extends Dialog {
    private a a;
    private Activity b;
    private ImageView c;
    private ImageView d;
    private ShareDataBean e = new ShareDataBean();

    /* compiled from: TbsSdkJava */
    public interface a {
        void b(ShareDataBean shareDataBean);

        void c(ShareDataBean shareDataBean);
    }

    public b(Activity activity) {
        super(activity, R.style.shareDialog);
        this.b = activity;
        try {
            this.a = (a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IShareDialogListener");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_dialog_layout);
        this.c = (ImageView) findViewById(R.id.share_wx);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.a != null) {
                        this.a.e.setShareUrl(y.a(this.a.e.getShareUrl(), 1));
                        this.a.a.b(this.a.e);
                    }
                    this.a.dismiss();
                }
            }
        });
        this.d = (ImageView) findViewById(R.id.share_wxpyq);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.a != null) {
                        this.a.e.setShareUrl(y.a(this.a.e.getShareUrl(), 2));
                        this.a.a.c(this.a.e);
                    }
                    this.a.dismiss();
                }
            }
        });
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        window.setGravity(80);
        attributes.width = ((GlobalVariable) this.b.getApplicationContext()).q();
        window.setAttributes(attributes);
    }

    public void a(String str, String str2, String str3, String str4) {
        try {
            str2 = URLDecoder.decode(str2, CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.e.setSharePicUrl(str2);
        this.e.setShareUrl(str);
        this.e.setShareText(str3);
        this.e.setShareTitle(str4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void show() {
        super.show();
    }
}
