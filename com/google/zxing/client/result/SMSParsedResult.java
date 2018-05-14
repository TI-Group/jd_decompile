package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }

    public String getSMSURI() {
        Object obj = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sms:");
        int i = 0;
        Object obj2 = 1;
        while (i < this.numbers.length) {
            if (obj2 != null) {
                obj2 = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(this.numbers[i]);
            if (!(this.vias == null || this.vias[i] == null)) {
                stringBuilder.append(";via=");
                stringBuilder.append(this.vias[i]);
            }
            i++;
        }
        Object obj3 = this.body != null ? 1 : null;
        if (this.subject == null) {
            obj = null;
        }
        if (!(obj3 == null && obj == null)) {
            stringBuilder.append('?');
            if (obj3 != null) {
                stringBuilder.append("body=");
                stringBuilder.append(this.body);
            }
            if (obj != null) {
                if (obj3 != null) {
                    stringBuilder.append('&');
                }
                stringBuilder.append("subject=");
                stringBuilder.append(this.subject);
            }
        }
        return stringBuilder.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String[] getVias() {
        return this.vias;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    public String getDisplayResult() {
        StringBuilder stringBuilder = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, stringBuilder);
        ParsedResult.maybeAppend(this.subject, stringBuilder);
        ParsedResult.maybeAppend(this.body, stringBuilder);
        return stringBuilder.toString();
    }
}
