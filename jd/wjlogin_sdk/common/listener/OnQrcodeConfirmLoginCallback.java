package jd.wjlogin_sdk.common.listener;

import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.QrCodeScannedResult;

/* compiled from: TbsSdkJava */
public interface OnQrcodeConfirmLoginCallback {
    void onError(String str);

    void onFail(FailResult failResult, QrCodeScannedResult qrCodeScannedResult);

    void onSuccess();
}
