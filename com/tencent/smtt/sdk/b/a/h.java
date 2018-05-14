package com.tencent.smtt.sdk.b.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;

class h implements OnClickListener {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void onClick(View view) {
        e a = this.a.h.a();
        if (a != null && a.b() != null) {
            Intent b = this.a.j;
            Context context = this.a.getContext();
            String str = a.b().activityInfo.packageName;
            b.setPackage(str);
            if (TbsConfig.APP_QB.equals(str)) {
                b.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                b.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
            }
            context.startActivity(b);
            if (this.a.e != null) {
                this.a.e.onReceiveValue("once");
            }
            this.a.dismiss();
        }
    }
}
