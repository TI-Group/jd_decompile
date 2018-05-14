package com.google.zxing.client.result;

import com.google.zxing.Result;

/* compiled from: TbsSdkJava */
public final class WifiResultParser extends ResultParser {
    public WifiParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("WIFI:")) {
            return null;
        }
        String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", massagedText, ';', false);
        if (matchSinglePrefixedField == null || matchSinglePrefixedField.isEmpty()) {
            return null;
        }
        String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", massagedText, ';', false);
        String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", massagedText, ';', false);
        if (matchSinglePrefixedField3 == null) {
            matchSinglePrefixedField3 = "nopass";
        }
        return new WifiParsedResult(matchSinglePrefixedField3, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(ResultParser.matchSinglePrefixedField("H:", massagedText, ';', false)));
    }
}
