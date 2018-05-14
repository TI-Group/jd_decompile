package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class EmailAddressResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String str = null;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith(WebView.SCHEME_MAILTO) || massagedText.startsWith("MAILTO:")) {
            String str2;
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            substring = ResultParser.urlDecode(substring);
            Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                if (substring.isEmpty()) {
                    str2 = (String) parseNameValuePairs.get("to");
                } else {
                    str2 = substring;
                }
                substring = (String) parseNameValuePairs.get("subject");
                str = (String) parseNameValuePairs.get("body");
            } else {
                str2 = substring;
                substring = null;
            }
            return new EmailAddressParsedResult(str2, substring, str, massagedText);
        } else if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return new EmailAddressParsedResult(massagedText, null, null, WebView.SCHEME_MAILTO + massagedText);
        } else {
            return null;
        }
    }
}
