package com.tencent.smtt.sdk.b.a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        if ("com.tencent.mobileqq".equals(this.a.getContext().getApplicationContext().getPackageName())) {
            this.a.j.onReceiveValue("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
            ((f) this.a.e.get()).dismiss();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041"));
        intent.addFlags(268435456);
        this.a.getContext().startActivity(intent);
    }
}
