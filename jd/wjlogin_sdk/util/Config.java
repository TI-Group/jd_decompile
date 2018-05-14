package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class Config {
    public static final String AES128_KEY = "123456abcdef0987";
    public static final String BIND_ERRORMESSAGE = "绑定失败";
    public static final int ERR_CODE_LOCAL_NETWORK_FAILED = -100;
    public static final int ERR_CODE_REQUEST_FAILED_OR_TIMEOUT = -101;
    public static final int ERR_CODE_RESPONSE_DATA_ERR = -102;
    public static final int ERR_CODE_SDK_BLOCKED = -103;
    public static final String ERR_MSG_LOCAL_NETWORK_FAILED = "网络请求失败，请检查您的网络设置!";
    public static final String ERR_MSG_REQUEST_FAILED_OR_TIMEOUT = "网络在开小差，检查后再试吧!";
    public static final String ERR_MSG_RESPONSE_DATA_ERR = "矮油，程序出错了!";
    public static final String ERR_MSG_SDK_BLOCKED = "系统繁忙，请稍后再试!";
    public static final String GUID_LOCALNAME = "GUID";
    public static final short GUID_TERMINALTYPE = (short) 1;
    public static final short GUID_VER = (short) 1;
    public static final short HEADER_VERSION = (short) 273;
    public static final String LOCAL_FILENAME = "wjlogin";
    public static final String LimitTime_String = "请%1d%2$s后再试";
    public static final int QRCODE_TYPE_TV = 1;
    public static final short SDK_VER_CODE = (short) 6;
    public static final String SDK_VER_NAME = "1.4.1";
    public static final String SOFTFINGERPRINT_LOCAL = "softFingerprint";
    public static final short TLV_VER = (short) 2;
    public static final String USERINFO_LOCALNAME = "UserInfo";
    public static final String USERTOKENINFO_LOCALNAME = "UserTokenInfo";

    public static String makeErrMsg(int i, String str) {
        return "{\"errCode\":\"" + i + "\",\"errMsg\":\"" + str + "\"}";
    }
}
