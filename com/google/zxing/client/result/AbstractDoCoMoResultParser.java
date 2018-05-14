package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    AbstractDoCoMoResultParser() {
    }

    static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchPrefixedField(str, str2, ';', z);
    }

    static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z) {
        return ResultParser.matchSinglePrefixedField(str, str2, ';', z);
    }
}
