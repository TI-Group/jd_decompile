package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.smtt.sdk.WebView;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public EmailAddressParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MATMSG:")) {
            return null;
        }
        String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TO:", massagedText, true);
        if (matchDoCoMoPrefixedField == null) {
            return null;
        }
        String str = matchDoCoMoPrefixedField[0];
        if (isBasicallyValidEmailAddress(str)) {
            return new EmailAddressParsedResult(str, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SUB:", massagedText, false), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BODY:", massagedText, false), WebView.SCHEME_MAILTO + str);
        }
        return null;
    }

    static boolean isBasicallyValidEmailAddress(String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }
}
