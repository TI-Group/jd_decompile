package jd.wjlogin_sdk.common.listener;

import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public interface OnLoginCallback {
    void onError(String str);

    void onFail(FailResult failResult, JumpResult jumpResult, PicDataInfo picDataInfo);

    void onFail(FailResult failResult, PicDataInfo picDataInfo);

    void onSuccess();
}
