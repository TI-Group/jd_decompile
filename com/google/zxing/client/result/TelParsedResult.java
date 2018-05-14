package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public final class TelParsedResult extends ParsedResult {
    private final String number;
    private final String telURI;
    private final String title;

    public TelParsedResult(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.number = str;
        this.telURI = str2;
        this.title = str3;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTelURI() {
        return this.telURI;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(20);
        ParsedResult.maybeAppend(this.number, stringBuilder);
        ParsedResult.maybeAppend(this.title, stringBuilder);
        return stringBuilder.toString();
    }
}
