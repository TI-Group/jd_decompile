package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: TbsSdkJava */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
