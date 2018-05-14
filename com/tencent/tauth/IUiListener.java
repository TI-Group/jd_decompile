package com.tencent.tauth;

/* compiled from: TbsSdkJava */
public interface IUiListener {
    void onCancel();

    void onComplete(Object obj);

    void onError(UiError uiError);
}
