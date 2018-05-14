package com.sina.weibo.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sina.weibo.sdk.d.d;
import com.sina.weibo.sdk.d.e;

/* compiled from: TbsSdkJava */
public class ApiUtils {
    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_440 = 10355;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    public static final int BUILD_INT_VER_2_5 = 10353;
    private static final String TAG = ApiUtils.class.getName();

    public static boolean validateWeiboSign(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            return containSign(context.getPackageManager().getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (NameNotFoundException e) {
            return z;
        }
    }

    private static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature toByteArray : signatureArr) {
            if (str.equals(e.a(toByteArray.toByteArray()))) {
                d.a(TAG, "check pass");
                return true;
            }
        }
        return false;
    }
}
