package com.squareup.wire;

import b.f;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public abstract class Message implements Serializable {
    private static final Wire WIRE = new Wire(new Class[0]);
    private static final long serialVersionUID = 0;
    private transient int cachedSerializedSize;
    protected transient int hashCode = 0;
    private transient boolean haveCachedSerializedSize;
    private transient UnknownFieldMap unknownFields;

    /* compiled from: TbsSdkJava */
    public static abstract class Builder<T extends Message> {
        UnknownFieldMap unknownFieldMap;

        public abstract T build();

        public Builder(Message message) {
            if (message != null && message.unknownFields != null) {
                this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
            }
        }

        public void addVarint(int i, long j) {
            try {
                ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed32(int i, int i2) {
            try {
                ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addFixed64(int i, long j) {
            try {
                ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        public void addLengthDelimited(int i, f fVar) {
            try {
                ensureUnknownFieldMap().addLengthDelimited(i, fVar);
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }

        UnknownFieldMap ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new UnknownFieldMap();
            }
            return this.unknownFieldMap;
        }

        public void checkRequiredFields() {
            Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
        }

        protected static <T> List<T> checkForNulls(List<T> list) {
            if (!(list == null || list.isEmpty())) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) == null) {
                        throw new NullPointerException("Element at index " + i + " is null");
                    }
                }
            }
            return list;
        }
    }

    /* compiled from: TbsSdkJava */
    public enum Datatype {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);
        
        public static final Comparator<Datatype> ORDER_BY_NAME = null;
        private static final Map<String, Datatype> TYPES_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<Datatype>() {
                public int compare(Datatype datatype, Datatype datatype2) {
                    return datatype.name().compareTo(datatype2.name());
                }
            };
            TYPES_BY_NAME = new LinkedHashMap();
            TYPES_BY_NAME.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put("string", STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put("message", MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put("float", FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        private Datatype(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public WireType wireType() {
            switch (this) {
                case INT32:
                case INT64:
                case UINT32:
                case UINT64:
                case SINT32:
                case SINT64:
                case BOOL:
                case ENUM:
                    return WireType.VARINT;
                case FIXED32:
                case SFIXED32:
                case FLOAT:
                    return WireType.FIXED32;
                case FIXED64:
                case SFIXED64:
                case DOUBLE:
                    return WireType.FIXED64;
                case STRING:
                case BYTES:
                case MESSAGE:
                    return WireType.LENGTH_DELIMITED;
                default:
                    throw new AssertionError("No wiretype for datatype " + this);
            }
        }

        public static Datatype of(String str) {
            return (Datatype) TYPES_BY_NAME.get(str);
        }
    }

    /* compiled from: TbsSdkJava */
    public enum Label {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(256);
        
        public static final Comparator<Label> ORDER_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<Label>() {
                public int compare(Label label, Label label2) {
                    return label.name().compareTo(label2.name());
                }
            };
        }

        private Label(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public boolean isPacked() {
            return this == PACKED;
        }
    }

    protected Message() {
    }

    protected void setBuilder(Builder builder) {
        if (builder.unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(builder.unknownFieldMap);
        }
    }

    protected Collection<List<FieldValue>> unknownFields() {
        if (this.unknownFields == null) {
            return Collections.emptySet();
        }
        return this.unknownFields.fieldMap.values();
    }

    protected static <T> List<T> copyOf(List<T> list) {
        return list == null ? null : new ArrayList(list);
    }

    protected static <T> List<T> immutableCopyOf(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return !(list instanceof ImmutableList) ? Collections.unmodifiableList(new ArrayList(list)) : list;
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e) {
        return WIRE.enumAdapter(e.getClass()).toInt((ProtoEnum) e);
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i) {
        return (Enum) WIRE.enumAdapter(cls).fromInt(i);
    }

    public byte[] toByteArray() {
        return WIRE.messageAdapter(getClass()).toByteArray(this);
    }

    public void writeTo(byte[] bArr) {
        writeTo(bArr, 0, bArr.length);
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        write(WireOutput.newInstance(bArr, i, i2));
    }

    private void write(WireOutput wireOutput) {
        try {
            WIRE.messageAdapter(getClass()).write(this, wireOutput);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        if (this.unknownFields != null) {
            this.unknownFields.write(wireOutput);
        }
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        return this.unknownFields == null ? 0 : this.unknownFields.getSerializedSize();
    }

    protected boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    protected boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        return list == list2 || (list != null && list.equals(list2));
    }

    public String toString() {
        return WIRE.messageAdapter(getClass()).toString(this);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(this, getClass());
    }
}
