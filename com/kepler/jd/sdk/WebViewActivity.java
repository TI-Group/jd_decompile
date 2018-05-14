package com.kepler.jd.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import com.kepler.sdk.a;
import com.kepler.sdk.am;
import com.kepler.sdk.h;
import com.kepler.sdk.j;
import com.kepler.sdk.l;
import com.kepler.sdk.p;

/* compiled from: TbsSdkJava */
public class WebViewActivity extends j {
    private JdView c;

    public WebViewActivity(Activity activity) {
        super(activity);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (!h.a().h()) {
                Toast.makeText(this, a.a().a("Illegal_info"), 1).show();
                finish();
            }
            Intent intent = this.a.getIntent();
            KeplerAttachParameter keplerAttachParameter = (KeplerAttachParameter) intent.getSerializableExtra(j.EXTRA_Auxiliary);
            this.c = new JdView(intent.getStringExtra(j.EXTRA_PARAMS).replace(" ", ""), keplerAttachParameter, intent.getBooleanExtra(j.EXTRA_isGetTokenAcFinish, false), this.a);
            this.a.setContentView(this.c);
        } catch (Throwable e) {
            l.a(e, "2016043013498");
            Toast.makeText(this, am.d, 1).show();
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.onPause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.onResume();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.c.goBack(0)) {
                    return true;
                }
            } catch (Throwable e) {
                p.a(e, null);
                l.a(e, "201603213498");
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.c != null) {
            this.c.onActivityResult(i, i2, intent);
        }
    }
}
