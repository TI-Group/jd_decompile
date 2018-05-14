package com.google.zxing.client.result;

import com.google.zxing.Result;

/* compiled from: TbsSdkJava */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
        if (matchDoCoMoPrefixedField == null) {
            return null;
        }
        text = matchDoCoMoPrefixedField[0];
        if (URIResultParser.isBasicallyValidURI(text)) {
            return new URIParsedResult(text, matchSingleDoCoMoPrefixedField);
        }
        return null;
    }
}
