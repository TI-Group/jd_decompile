package com.sina.weibo.sdk.c;

/* compiled from: TbsSdkJava */
public class a extends b {
    public static final String DEFAULT_AUTH_ERROR_CODE = "-1";
    public static final String DEFAULT_AUTH_ERROR_DESC = "Unknown Error Description";
    public static final String DEFAULT_AUTH_ERROR_TYPE = "Unknown Error Type";
    private static final long serialVersionUID = 1;
    private final String mErrorCode;
    private final String mErrorType;

    public a(String str, String str2, String str3) {
        super(str3);
        this.mErrorType = str2;
        this.mErrorCode = str;
    }

    public String getErrorType() {
        return this.mErrorType;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }
}
