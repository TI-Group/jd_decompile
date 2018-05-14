package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.WebResourceError;

class ag extends WebResourceError {
    final /* synthetic */ android.webkit.WebResourceError a;
    final /* synthetic */ ae b;

    ag(ae aeVar, android.webkit.WebResourceError webResourceError) {
        this.b = aeVar;
        this.a = webResourceError;
    }

    public CharSequence getDescription() {
        return this.a.getDescription();
    }

    public int getErrorCode() {
        return this.a.getErrorCode();
    }
}
