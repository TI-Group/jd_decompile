package com.google.gson;

/* compiled from: TbsSdkJava */
public final class JsonNull extends JsonElement {
    public static final JsonNull INSTANCE = new JsonNull();

    JsonNull deepCopy() {
        return INSTANCE;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }
}
