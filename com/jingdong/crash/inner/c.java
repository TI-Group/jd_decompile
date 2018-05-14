package com.jingdong.crash.inner;

import android.os.Build.VERSION;
import android.text.TextUtils;

class c {
    public static boolean a(String str) {
        return VERSION.SDK_INT < 23 ? true : TextUtils.isEmpty(str) ? false : q.d().checkSelfPermission(str) == 0;
    }
}
