package com.google.zxing.client.result;

import com.google.zxing.Result;

/* compiled from: TbsSdkJava */
public final class SMSTOMMSTOResultParser extends ResultParser {
    public SMSParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smsto:") && !massagedText.startsWith("SMSTO:") && !massagedText.startsWith("mmsto:") && !massagedText.startsWith("MMSTO:")) {
            return null;
        }
        String substring = massagedText.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            massagedText = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            massagedText = null;
        }
        return new SMSParsedResult(substring, null, null, massagedText);
    }
}
