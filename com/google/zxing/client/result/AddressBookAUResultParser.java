package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class AddressBookAUResultParser extends ResultParser {
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        return new AddressBookParsedResult(ResultParser.maybeWrap(ResultParser.matchSinglePrefixedField("NAME1:", massagedText, '\r', true)), null, ResultParser.matchSinglePrefixedField("NAME2:", massagedText, '\r', true), matchMultipleValuePrefix("TEL", 3, massagedText, true), null, matchMultipleValuePrefix("MAIL", 3, massagedText, true), null, null, ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, '\r', false), ResultParser.matchSinglePrefixedField("ADD:", massagedText, '\r', true) == null ? null : new String[]{ResultParser.matchSinglePrefixedField("ADD:", massagedText, '\r', true)}, null, null, null, null, null, null);
    }

    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        List list = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i2 + ':', str2, '\r', z);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (list == null) {
                list = new ArrayList(i);
            }
            list.add(matchSinglePrefixedField);
        }
        if (list == null) {
            return null;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
