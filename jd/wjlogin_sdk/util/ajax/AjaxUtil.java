package jd.wjlogin_sdk.util.ajax;

import jd.wjlogin_sdk.util.HttpConfig;

/* compiled from: TbsSdkJava */
public class AjaxUtil {
    public static String getUrl(String str, boolean z) {
        if (z) {
            return "http://192.168.144.121/" + str;
        }
        return new StringBuilder(HttpConfig.LOGIN_URL).append(str).toString();
    }

    public static String getReportUrl(String str, boolean z) {
        if (z) {
            return "http://192.168.144.121/" + str;
        }
        return new StringBuilder(HttpConfig.REPORT_URL).append(str).toString();
    }
}
