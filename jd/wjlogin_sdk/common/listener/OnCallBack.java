package jd.wjlogin_sdk.common.listener;

import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public interface OnCallBack {
    void OnGetToken(String str, String str2);

    void getCheckCode(PicDataInfo picDataInfo);

    void getMessagePassword(String str);

    void onError(String str);

    void onFail(FailResult failResult);

    void onSuccess();
}
