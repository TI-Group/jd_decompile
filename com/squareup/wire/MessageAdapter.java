package com.squareup.wire;

import b.f;
import cn.jiguang.net.HttpUtils;
import com.squareup.wire.ExtendableMessage.ExtendableBuilder;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.Message.Datatype;
import com.squareup.wire.Message.Label;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
final class MessageAdapter<M extends Message> {
    private static final String FULL_BLOCK = "█";
    private static final String REDACTED = "██";
    private final Class<Builder<M>> builderType;
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    /* compiled from: TbsSdkJava */
    public static final class FieldInfo {
        private final Field builderField;
        final Datatype datatype;
        EnumAdapter<? extends ProtoEnum> enumAdapter;
        final Class<? extends ProtoEnum> enumType;
        final Label label;
        MessageAdapter<? extends Message> messageAdapter;
        private final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        private FieldInfo(int i, String str, Datatype datatype, Label label, boolean z, Class<?> cls, Field field, Field field2) {
            this.tag = i;
            this.name = str;
            this.datatype = datatype;
            this.label = label;
            this.redacted = z;
            if (datatype == Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype == Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderField = field2;
        }
    }

    /* compiled from: TbsSdkJava */
    static class ImmutableList<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        private final List<T> list = new ArrayList();

        ImmutableList() {
        }

        public Object clone() {
            return this;
        }

        public int size() {
            return this.list.size();
        }

        public T get(int i) {
            return this.list.get(i);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class Storage {
        private Map<Integer, ImmutableList<Object>> map;

        private Storage() {
        }

        void add(int i, Object obj) {
            ImmutableList immutableList = this.map == null ? null : (ImmutableList) this.map.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList();
                if (this.map == null) {
                    this.map = new LinkedHashMap();
                }
                this.map.put(Integer.valueOf(i), immutableList);
            }
            immutableList.list.add(obj);
        }

        Set<Integer> getTags() {
            if (this.map == null) {
                return Collections.emptySet();
            }
            return this.map.keySet();
        }

        List<Object> get(int i) {
            return this.map == null ? null : (ImmutableList) this.map.get(Integer.valueOf(i));
        }
    }

    Builder<M> newBuilder() {
        try {
            return (Builder) this.builderType.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    FieldInfo getField(String str) {
        Integer num = (Integer) this.tagMap.get(str);
        return num == null ? null : (FieldInfo) this.fieldInfoMap.get(num.intValue());
    }

    Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField == null) {
            throw new AssertionError("Field is not of type \"Message\"");
        }
        try {
            return fieldInfo.messageField.get(m);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    public void setBuilderField(Builder<M> builder, int i, Object obj) {
        try {
            ((FieldInfo) this.fieldInfoMap.get(i)).builderField.set(builder, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    MessageAdapter(Wire wire, Class<M> cls) {
        this.wire = wire;
        this.messageType = cls;
        this.builderType = getBuilderType(cls);
        Map linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int tag = protoField.tag();
                String name = field.getName();
                this.tagMap.put(name, Integer.valueOf(tag));
                Class cls2 = null;
                Datatype type = protoField.type();
                if (type == Datatype.ENUM) {
                    cls2 = getEnumType(field);
                } else if (type == Datatype.MESSAGE) {
                    cls2 = getMessageType(field);
                }
                linkedHashMap.put(Integer.valueOf(tag), new FieldInfo(tag, name, type, protoField.label(), protoField.redacted(), cls2, field, getBuilderField(name)));
            }
        }
        this.fieldInfoMap = TagMap.of(linkedHashMap);
    }

    private Class<Builder<M>> getBuilderType(Class<M> cls) {
        try {
            return Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field getBuilderField(String str) {
        try {
            return this.builderType.getField(str);
        } catch (NoSuchFieldException e) {
            throw new AssertionError("No builder field " + this.builderType.getName() + "." + str);
        }
    }

    private Class<? extends Message> getMessageType(Field field) {
        Class<? extends Message> type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).messageType();
        }
        return null;
    }

    private Class<? extends Enum> getEnumType(Field field) {
        Class<? extends Enum> type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).enumType();
        }
        return null;
    }

    int getSerializedSize(M m) {
        int i = 0;
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                int serializedSize;
                int i2 = fieldInfo.tag;
                Datatype datatype = fieldInfo.datatype;
                Label label = fieldInfo.label;
                if (!label.isRepeated()) {
                    serializedSize = getSerializedSize(i2, fieldValue, datatype) + i;
                } else if (label.isPacked()) {
                    serializedSize = getPackedSize((List) fieldValue, i2, datatype) + i;
                } else {
                    serializedSize = getRepeatedSize((List) fieldValue, i2, datatype) + i;
                }
                i = serializedSize;
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                i += getExtensionsSerializedSize(extendableMessage.extensionMap);
            }
        }
        return m.getUnknownFieldsSerializedSize() + i;
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int i = 0;
        for (int i2 = 0; i2 < extensionMap.size(); i2++) {
            Extension extension = extensionMap.getExtension(i2);
            Object extensionValue = extensionMap.getExtensionValue(i2);
            int tag = extension.getTag();
            Datatype datatype = extension.getDatatype();
            Label label = extension.getLabel();
            if (!label.isRepeated()) {
                i += getSerializedSize(tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                i += getPackedSize((List) extensionValue, tag, datatype);
            } else {
                i += getRepeatedSize((List) extensionValue, tag, datatype);
            }
        }
        return i;
    }

    private int getRepeatedSize(List<?> list, int i, Datatype datatype) {
        int i2 = 0;
        for (Object serializedSize : list) {
            i2 += getSerializedSize(i, serializedSize, datatype);
        }
        return i2;
    }

    private int getPackedSize(List<?> list, int i, Datatype datatype) {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        return i2 + (WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2));
    }

    void write(M m, WireOutput wireOutput) throws IOException {
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                int i = fieldInfo.tag;
                Datatype datatype = fieldInfo.datatype;
                Label label = fieldInfo.label;
                if (!label.isRepeated()) {
                    writeValue(wireOutput, i, fieldValue, datatype);
                } else if (label.isPacked()) {
                    writePacked(wireOutput, (List) fieldValue, i, datatype);
                } else {
                    writeRepeated(wireOutput, (List) fieldValue, i, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        for (int i = 0; i < extensionMap.size(); i++) {
            Extension extension = extensionMap.getExtension(i);
            Object extensionValue = extensionMap.getExtensionValue(i);
            int tag = extension.getTag();
            Datatype datatype = extension.getDatatype();
            Label label = extension.getLabel();
            if (!label.isRepeated()) {
                writeValue(wireOutput, tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                writePacked(wireOutput, (List) extensionValue, tag, datatype);
            } else {
                writeRepeated(wireOutput, (List) extensionValue, tag, datatype);
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Datatype datatype) throws IOException {
        for (Object writeValue : list) {
            writeValue(wireOutput, i, writeValue, datatype);
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Datatype datatype) throws IOException {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
        wireOutput.writeVarint32(i2);
        for (Object writeValueNoTag : list) {
            writeValueNoTag(wireOutput, writeValueNoTag, datatype);
        }
    }

    byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    String toString(M m) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.messageType.getSimpleName());
        stringBuilder.append("{");
        String str = "";
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                stringBuilder.append(str);
                str = ", ";
                stringBuilder.append(fieldInfo.name);
                stringBuilder.append(HttpUtils.EQUAL_SIGN);
                stringBuilder.append(fieldInfo.redacted ? REDACTED : fieldValue);
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            stringBuilder.append(str);
            stringBuilder.append("{extensions=");
            stringBuilder.append(extendableMessage.extensionsToString());
            stringBuilder.append("}");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private int getSerializedSize(int i, Object obj, Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }

    private int getSerializedSizeNoTag(Object obj, Datatype datatype) {
        int utf8Length;
        switch (datatype) {
            case INT32:
                return WireOutput.int32Size(((Integer) obj).intValue());
            case INT64:
            case UINT64:
                return WireOutput.varint64Size(((Long) obj).longValue());
            case UINT32:
                return WireOutput.varint32Size(((Integer) obj).intValue());
            case SINT32:
                return WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
            case SINT64:
                return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
            case BOOL:
                return 1;
            case ENUM:
                return getEnumSize((ProtoEnum) obj);
            case STRING:
                utf8Length = utf8Length((String) obj);
                return utf8Length + WireOutput.varint32Size(utf8Length);
            case BYTES:
                utf8Length = ((f) obj).size();
                return utf8Length + WireOutput.varint32Size(utf8Length);
            case MESSAGE:
                return getMessageSize((Message) obj);
            case FIXED32:
            case SFIXED32:
            case FLOAT:
                return 4;
            case FIXED64:
            case SFIXED64:
            case DOUBLE:
                return 8;
            default:
                throw new RuntimeException();
        }
    }

    private int utf8Length(String str) {
        int i = 0;
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= '') {
                i2++;
            } else if (charAt <= '߿') {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    private <M extends Message> int getMessageSize(M m) {
        int serializedSize = m.getSerializedSize();
        return serializedSize + WireOutput.varint32Size(serializedSize);
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Datatype datatype) throws IOException {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    private void writeValueNoTag(WireOutput wireOutput, Object obj, Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
                wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                return;
            case INT64:
            case UINT64:
                wireOutput.writeVarint64(((Long) obj).longValue());
                return;
            case UINT32:
                wireOutput.writeVarint32(((Integer) obj).intValue());
                return;
            case SINT32:
                wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                return;
            case SINT64:
                wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                return;
            case BOOL:
                wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case ENUM:
                writeEnum((ProtoEnum) obj, wireOutput);
                return;
            case STRING:
                byte[] bytes = ((String) obj).getBytes(HTTP.UTF_8);
                wireOutput.writeVarint32(bytes.length);
                wireOutput.writeRawBytes(bytes);
                return;
            case BYTES:
                f fVar = (f) obj;
                wireOutput.writeVarint32(fVar.size());
                wireOutput.writeRawBytes(fVar.toByteArray());
                return;
            case MESSAGE:
                writeMessage((Message) obj, wireOutput);
                return;
            case FIXED32:
            case SFIXED32:
                wireOutput.writeFixed32(((Integer) obj).intValue());
                return;
            case FLOAT:
                wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case FIXED64:
            case SFIXED64:
                wireOutput.writeFixed64(((Long) obj).longValue());
                return;
            case DOUBLE:
                wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    M read(WireInput wireInput) throws IOException {
        try {
            Builder builder = (Builder) this.builderType.newInstance();
            Storage storage = new Storage();
            while (true) {
                int readTag = wireInput.readTag();
                int i = readTag >> 3;
                WireType valueOf = WireType.valueOf(readTag);
                if (i == 0) {
                    break;
                }
                Datatype datatype;
                Extension extension;
                Label label;
                FieldInfo fieldInfo = (FieldInfo) this.fieldInfoMap.get(i);
                if (fieldInfo != null) {
                    datatype = fieldInfo.datatype;
                    extension = null;
                    label = fieldInfo.label;
                } else {
                    Extension extension2 = getExtension(i);
                    if (extension2 == null) {
                        readUnknownField(builder, wireInput, i, valueOf);
                    } else {
                        Datatype datatype2 = extension2.getDatatype();
                        Label label2 = extension2.getLabel();
                        extension = extension2;
                        datatype = datatype2;
                        label = label2;
                    }
                }
                Object readValue;
                if (label.isPacked() && valueOf == WireType.LENGTH_DELIMITED) {
                    int readVarint32 = wireInput.readVarint32();
                    long position = wireInput.getPosition();
                    int pushLimit = wireInput.pushLimit(readVarint32);
                    while (wireInput.getPosition() < ((long) readVarint32) + position) {
                        readValue = readValue(wireInput, i, datatype);
                        if (datatype == Datatype.ENUM && (readValue instanceof Integer)) {
                            builder.addVarint(i, (long) ((Integer) readValue).intValue());
                        } else {
                            storage.add(i, readValue);
                        }
                    }
                    wireInput.popLimit(pushLimit);
                    if (wireInput.getPosition() != ((long) readVarint32) + position) {
                        throw new IOException("Packed data had wrong length!");
                    }
                } else {
                    readValue = readValue(wireInput, i, datatype);
                    if (datatype == Datatype.ENUM && (readValue instanceof Integer)) {
                        builder.addVarint(i, (long) ((Integer) readValue).intValue());
                    } else if (label.isRepeated()) {
                        storage.add(i, readValue);
                    } else if (extension != null) {
                        setExtension((ExtendableBuilder) builder, extension, readValue);
                    } else {
                        setBuilderField(builder, i, readValue);
                    }
                }
            }
            for (Integer intValue : storage.getTags()) {
                int intValue2 = intValue.intValue();
                if (this.fieldInfoMap.containsKey(intValue2)) {
                    setBuilderField(builder, intValue2, storage.get(intValue2));
                } else {
                    setExtension((ExtendableBuilder) builder, getExtension(intValue2), storage.get(intValue2));
                }
            }
            return builder.build();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object readValue(WireInput wireInput, int i, Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
            case UINT32:
                return Integer.valueOf(wireInput.readVarint32());
            case INT64:
            case UINT64:
                return Long.valueOf(wireInput.readVarint64());
            case SINT32:
                return Integer.valueOf(WireInput.decodeZigZag32(wireInput.readVarint32()));
            case SINT64:
                return Long.valueOf(WireInput.decodeZigZag64(wireInput.readVarint64()));
            case BOOL:
                return Boolean.valueOf(wireInput.readVarint32() != 0);
            case ENUM:
                EnumAdapter enumAdapter = getEnumAdapter(i);
                int readVarint32 = wireInput.readVarint32();
                try {
                    return enumAdapter.fromInt(readVarint32);
                } catch (IllegalArgumentException e) {
                    return Integer.valueOf(readVarint32);
                }
            case STRING:
                return wireInput.readString();
            case BYTES:
                return wireInput.readBytes();
            case MESSAGE:
                return readMessage(wireInput, i);
            case FIXED32:
            case SFIXED32:
                return Integer.valueOf(wireInput.readFixed32());
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(wireInput.readFixed32()));
            case FIXED64:
            case SFIXED64:
                return Long.valueOf(wireInput.readFixed64());
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(wireInput.readFixed64()));
            default:
                throw new RuntimeException();
        }
    }

    private Message readMessage(WireInput wireInput, int i) throws IOException {
        int readVarint32 = wireInput.readVarint32();
        if (wireInput.recursionDepth >= 64) {
            throw new IOException("Wire recursion limit exceeded");
        }
        readVarint32 = wireInput.pushLimit(readVarint32);
        wireInput.recursionDepth++;
        Message read = getMessageAdapter(i).read(wireInput);
        wireInput.checkLastTagWas(0);
        wireInput.recursionDepth--;
        wireInput.popLimit(readVarint32);
        return read;
    }

    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = (FieldInfo) this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.messageAdapter != null) {
            return fieldInfo.messageAdapter;
        }
        MessageAdapter<? extends Message> messageAdapter = this.wire.messageAdapter(getMessageClass(i));
        if (fieldInfo != null) {
            fieldInfo.messageAdapter = messageAdapter;
        }
        return messageAdapter;
    }

    private EnumAdapter<? extends ProtoEnum> getEnumAdapter(int i) {
        FieldInfo fieldInfo = (FieldInfo) this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.enumAdapter != null) {
            return fieldInfo.enumAdapter;
        }
        EnumAdapter<? extends ProtoEnum> enumAdapter = this.wire.enumAdapter(getEnumClass(i));
        if (fieldInfo != null) {
            fieldInfo.enumAdapter = enumAdapter;
        }
        return enumAdapter;
    }

    private Class<Message> getMessageClass(int i) {
        FieldInfo fieldInfo = (FieldInfo) this.fieldInfoMap.get(i);
        Class<Message> cls = fieldInfo == null ? null : fieldInfo.messageType;
        if (cls != null) {
            return cls;
        }
        Extension extension = getExtension(i);
        if (extension != null) {
            return extension.getMessageType();
        }
        return cls;
    }

    private void readUnknownField(Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
        switch (wireType) {
            case VARINT:
                builder.ensureUnknownFieldMap().addVarint(i, Long.valueOf(wireInput.readVarint64()));
                return;
            case FIXED32:
                builder.ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(wireInput.readFixed32()));
                return;
            case FIXED64:
                builder.ensureUnknownFieldMap().addFixed64(i, Long.valueOf(wireInput.readFixed64()));
                return;
            case LENGTH_DELIMITED:
                builder.ensureUnknownFieldMap().addLengthDelimited(i, wireInput.readBytes(wireInput.readVarint32()));
                return;
            case START_GROUP:
                wireInput.skipGroup();
                return;
            case END_GROUP:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    private void setExtension(ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        FieldInfo fieldInfo = (FieldInfo) this.fieldInfoMap.get(i);
        Class<? extends ProtoEnum> cls = fieldInfo == null ? null : fieldInfo.enumType;
        if (cls != null) {
            return cls;
        }
        Extension extension = getExtension(i);
        if (extension != null) {
            return extension.getEnumType();
        }
        return cls;
    }
}
