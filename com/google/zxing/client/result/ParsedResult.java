package com.google.zxing.client.result;

/* compiled from: TbsSdkJava */
public abstract class ParsedResult {
    private final ParsedResultType type;

    public abstract String getDisplayResult();

    protected ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public final ParsedResultType getType() {
        return this.type;
    }

    public final String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(String str, StringBuilder stringBuilder) {
        if (str != null && !str.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(str);
        }
    }

    public static void maybeAppend(String[] strArr, StringBuilder stringBuilder) {
        if (strArr != null) {
            for (String maybeAppend : strArr) {
                maybeAppend(maybeAppend, stringBuilder);
            }
        }
    }
}
