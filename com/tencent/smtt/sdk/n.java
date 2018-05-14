package com.tencent.smtt.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class n implements OnDismissListener {
    final /* synthetic */ ValueCallback a;

    n(ValueCallback valueCallback) {
        this.a = valueCallback;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.a != null) {
            this.a.onReceiveValue("TbsReaderDialogClosed");
        }
    }
}
