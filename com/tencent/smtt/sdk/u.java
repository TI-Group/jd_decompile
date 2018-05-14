package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class u implements ValueCallback<Uri> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ s b;

    u(s sVar, ValueCallback valueCallback) {
        this.b = sVar;
        this.a = valueCallback;
    }

    public void a(Uri uri) {
        this.a.onReceiveValue(new Uri[]{uri});
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        a((Uri) obj);
    }
}
