package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.smtt.sdk.WebView;

/* compiled from: TbsSdkJava */
public final class SMTPResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String str = null;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smtp:") && !massagedText.startsWith("SMTP:")) {
            return null;
        }
        String substring = massagedText.substring(5);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            massagedText = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
            indexOf = massagedText.indexOf(58);
            if (indexOf >= 0) {
                str = massagedText.substring(indexOf + 1);
                massagedText = massagedText.substring(0, indexOf);
            }
        } else {
            massagedText = null;
        }
        return new EmailAddressParsedResult(substring, massagedText, str, WebView.SCHEME_MAILTO + substring);
    }
}
