package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase.IconListener;
import com.tencent.smtt.sdk.WebIconDatabase.a;

class bg implements IconListener {
    final /* synthetic */ a a;
    final /* synthetic */ WebIconDatabase b;

    bg(WebIconDatabase webIconDatabase, a aVar) {
        this.b = webIconDatabase;
        this.a = aVar;
    }

    public void onReceivedIcon(String str, Bitmap bitmap) {
        this.a.a(str, bitmap);
    }
}
