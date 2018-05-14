package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        String buildName = buildName(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", massagedText, true));
        String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", massagedText, true);
        String matchSingleDoCoMoPrefixedField2 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", massagedText, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(buildName), null, null, buildPhoneNumbers(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, ResultParser.maybeWrap(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", massagedText, true), null, matchSingleDoCoMoPrefixedField2, null, matchSingleDoCoMoPrefixedField, null, null);
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        List arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            str = str + ' ' + str2;
        }
        return str;
    }
}
