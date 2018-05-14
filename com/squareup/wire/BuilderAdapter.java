package com.squareup.wire;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.Message.Label;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TbsSdkJava */
final class BuilderAdapter<B extends Builder> {
    private static final Comparator<Field> ORDER_BY_FIELD_NAME = new Comparator<Field>() {
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    };
    private static final int SUFFIX_LENGTH = "$Builder".length();
    private final List<Field> requiredFields = new ArrayList();

    public BuilderAdapter(Class<B> cls) {
        String name = cls.getName();
        try {
            for (Field field : Class.forName(name.substring(0, name.length() - SUFFIX_LENGTH)).getDeclaredFields()) {
                ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                if (protoField != null && protoField.label() == Label.REQUIRED) {
                    try {
                        this.requiredFields.add(cls.getField(field.getName()));
                    } catch (NoSuchFieldException e) {
                        throw new AssertionError("No builder field found for message field " + field.getName());
                    }
                }
            }
            Collections.sort(this.requiredFields, ORDER_BY_FIELD_NAME);
        } catch (ClassNotFoundException e2) {
            throw new AssertionError("No message class found for builder type " + name);
        }
    }

    public <B extends Builder> void checkRequiredFields(B b) {
        StringBuilder stringBuilder = null;
        String str = "";
        try {
            int size = this.requiredFields.size();
            int i = 0;
            while (i < size) {
                Field field = (Field) this.requiredFields.get(i);
                if (field.get(b) == null) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    } else {
                        str = "s";
                    }
                    stringBuilder.append("\n  ");
                    stringBuilder.append(field.getName());
                }
                String str2 = str;
                i++;
                stringBuilder = stringBuilder;
                str = str2;
            }
            if (stringBuilder != null) {
                throw new IllegalStateException("Required field" + str + " not set:" + stringBuilder);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("Unable to access required fields");
        }
    }
}
