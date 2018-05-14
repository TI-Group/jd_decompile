package jd.wjlogin_sdk.common.listener;

import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public interface OnRefreshCheckCodeCallback {
    void onError(String str);

    void onFail(FailResult failResult);

    void onSuccess(PicDataInfo picDataInfo);
}
