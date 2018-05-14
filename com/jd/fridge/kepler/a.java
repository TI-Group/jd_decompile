package com.jd.fridge.kepler;

import android.os.Handler;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.common.listener.OnLoginCallback;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public class a {
    public static void a(Handler handler, WJLoginHelper wJLoginHelper) {
        if (wJLoginHelper.isExistsUserInfo()) {
            b(handler, wJLoginHelper);
        } else {
            b();
        }
    }

    private static void b() {
    }

    private static void b(Handler handler, WJLoginHelper wJLoginHelper) {
        if (wJLoginHelper.isExistsA2()) {
            c(handler, wJLoginHelper);
        } else {
            e(handler, wJLoginHelper);
        }
    }

    private static void c(Handler handler, WJLoginHelper wJLoginHelper) {
        if (wJLoginHelper.checkA2TimeOut()) {
            e(handler, wJLoginHelper);
        } else {
            d(handler, wJLoginHelper);
        }
    }

    private static void d(Handler handler, WJLoginHelper wJLoginHelper) {
        if (wJLoginHelper.checkA2IsNeedRefresh()) {
            f(handler, wJLoginHelper);
        } else {
            b(handler);
        }
    }

    private static void e(Handler handler, WJLoginHelper wJLoginHelper) {
        if (wJLoginHelper.isNeedPwdInput()) {
            b();
        } else {
            g(handler, wJLoginHelper);
        }
    }

    private static void f(final Handler handler, WJLoginHelper wJLoginHelper) {
        wJLoginHelper.refreshA2(new OnCommonCallback() {
            public void onSuccess() {
                a.b(handler);
            }

            public void onError(String str) {
                a.b();
            }

            public void onFail(FailResult failResult) {
                a.b();
            }
        });
    }

    private static void g(final Handler handler, WJLoginHelper wJLoginHelper) {
        wJLoginHelper.quickLogin(new OnLoginCallback() {
            public void onSuccess() {
                a.b(handler);
            }

            public void onError(String str) {
                a.b();
            }

            public void onFail(FailResult failResult, PicDataInfo picDataInfo) {
                a.b();
            }

            public void onFail(FailResult failResult, JumpResult jumpResult, PicDataInfo picDataInfo) {
                a.b();
            }
        });
    }

    private static void b(Handler handler) {
        com.jd.fridge.a.a().b(handler);
    }
}
