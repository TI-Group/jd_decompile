package com.sina.weibo.sdk.api.share;

import android.os.Bundle;

/* compiled from: TbsSdkJava */
public abstract class b extends a {
    public void a(Bundle bundle) {
        bundle.putInt("_weibo_command_type", a());
        bundle.putString("_weibo_transaction", this.a);
    }
}
