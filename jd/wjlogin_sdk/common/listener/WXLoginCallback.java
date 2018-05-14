package jd.wjlogin_sdk.common.listener;

import jd.wjlogin_sdk.model.BindResult;
import jd.wjlogin_sdk.model.FailResult;

/* compiled from: TbsSdkJava */
public interface WXLoginCallback {
    void onError(String str);

    void onFail(FailResult failResult, BindResult bindResult);

    void onSuccess();
}
