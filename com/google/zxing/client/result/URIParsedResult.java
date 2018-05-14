package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public final class URIParsedResult extends ParsedResult {
    private static final Pattern USER_IN_HOST = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String title;
    private final String uri;

    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    public String getURI() {
        return this.uri;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isPossiblyMaliciousURI() {
        return USER_IN_HOST.matcher(this.uri).find();
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(30);
        ParsedResult.maybeAppend(this.title, stringBuilder);
        ParsedResult.maybeAppend(this.uri, stringBuilder);
        return stringBuilder.toString();
    }

    private static String massageURI(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf < 0) {
            return "http://" + trim;
        }
        if (isColonFollowedByPortNumber(trim, indexOf)) {
            return "http://" + trim;
        }
        return trim;
    }

    private static boolean isColonFollowedByPortNumber(String str, int i) {
        int i2 = i + 1;
        int indexOf = str.indexOf(47, i2);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return ResultParser.isSubstringOfDigits(str, i2, indexOf - i2);
    }
}
