package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.smtt.sdk.WebView;

/* compiled from: TbsSdkJava */
public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith(WebView.SCHEME_TEL) && !massagedText.startsWith("TEL:")) {
            return null;
        }
        String str;
        if (massagedText.startsWith("TEL:")) {
            str = WebView.SCHEME_TEL + massagedText.substring(4);
        } else {
            str = massagedText;
        }
        int indexOf = massagedText.indexOf(63, 4);
        return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
    }
}
