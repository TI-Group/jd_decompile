package com.squareup.wire;

import b.f;
import com.squareup.wire.Message.Datatype;
import com.squareup.wire.Message.Label;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class Extension<T extends ExtendableMessage<?>, E> implements Comparable<Extension<?, ?>> {
    private final Datatype datatype;
    private final Class<? extends ProtoEnum> enumType;
    private final Class<T> extendedType;
    private final Label label;
    private final Class<? extends Message> messageType;
    private final String name;
    private final int tag;

    /* compiled from: TbsSdkJava */
    public static final class Builder<T extends ExtendableMessage<?>, E> {
        private final Datatype datatype;
        private final Class<? extends ProtoEnum> enumType;
        private final Class<T> extendedType;
        private Label label;
        private final Class<? extends Message> messageType;
        private String name;
        private int tag;

        private Builder(Class<T> cls, Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = null;
            this.enumType = null;
            this.datatype = datatype;
        }

        private Builder(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = cls2;
            this.enumType = cls3;
            this.datatype = datatype;
        }

        public Builder<T, E> setName(String str) {
            this.name = str;
            return this;
        }

        public Builder<T, E> setTag(int i) {
            this.tag = i;
            return this;
        }

        public Extension<T, E> buildOptional() {
            this.label = Label.OPTIONAL;
            validate();
            return new Extension(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public Extension<T, E> buildRequired() {
            this.label = Label.REQUIRED;
            validate();
            return new Extension(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public Extension<T, List<E>> buildRepeated() {
            this.label = Label.REPEATED;
            validate();
            return new Extension(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        public Extension<T, List<E>> buildPacked() {
            this.label = Label.PACKED;
            validate();
            return new Extension(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype);
        }

        private void validate() {
            if (this.extendedType == null) {
                throw new IllegalArgumentException("extendedType == null");
            } else if (this.name == null) {
                throw new IllegalArgumentException("name == null");
            } else if (this.datatype == null) {
                throw new IllegalArgumentException("datatype == null");
            } else if (this.label == null) {
                throw new IllegalArgumentException("label == null");
            } else if (this.tag <= 0) {
                throw new IllegalArgumentException("tag == " + this.tag);
            } else if (this.datatype == Datatype.MESSAGE) {
                if (this.messageType == null || this.enumType != null) {
                    throw new IllegalStateException("Message w/o messageType or w/ enumType");
                }
            } else if (this.datatype == Datatype.ENUM) {
                if (this.messageType != null || this.enumType == null) {
                    throw new IllegalStateException("Enum w/ messageType or w/o enumType");
                }
            } else if (this.messageType != null || this.enumType != null) {
                throw new IllegalStateException("Scalar w/ messageType or enumType");
            }
        }
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> int32Extending(Class<T> cls) {
        return new Builder(cls, Datatype.INT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sint32Extending(Class<T> cls) {
        return new Builder(cls, Datatype.SINT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> uint32Extending(Class<T> cls) {
        return new Builder(cls, Datatype.UINT32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> fixed32Extending(Class<T> cls) {
        return new Builder(cls, Datatype.FIXED32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sfixed32Extending(Class<T> cls) {
        return new Builder(cls, Datatype.SFIXED32);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> int64Extending(Class<T> cls) {
        return new Builder(cls, Datatype.INT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sint64Extending(Class<T> cls) {
        return new Builder(cls, Datatype.SINT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> uint64Extending(Class<T> cls) {
        return new Builder(cls, Datatype.UINT64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> fixed64Extending(Class<T> cls) {
        return new Builder(cls, Datatype.FIXED64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sfixed64Extending(Class<T> cls) {
        return new Builder(cls, Datatype.SFIXED64);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Boolean> boolExtending(Class<T> cls) {
        return new Builder(cls, Datatype.BOOL);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, String> stringExtending(Class<T> cls) {
        return new Builder(cls, Datatype.STRING);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, f> bytesExtending(Class<T> cls) {
        return new Builder(cls, Datatype.BYTES);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Float> floatExtending(Class<T> cls) {
        return new Builder(cls, Datatype.FLOAT);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Double> doubleExtending(Class<T> cls) {
        return new Builder(cls, Datatype.DOUBLE);
    }

    public static <T extends ExtendableMessage<?>, E extends Enum & ProtoEnum> Builder<T, E> enumExtending(Class<E> cls, Class<T> cls2) {
        return new Builder(cls2, null, cls, Datatype.ENUM);
    }

    public static <T extends ExtendableMessage<?>, M extends Message> Builder<T, M> messageExtending(Class<M> cls, Class<T> cls2) {
        return new Builder(cls2, cls, null, Datatype.MESSAGE);
    }

    private Extension(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, String str, int i, Label label, Datatype datatype) {
        this.extendedType = cls;
        this.name = str;
        this.tag = i;
        this.datatype = datatype;
        this.label = label;
        this.messageType = cls2;
        this.enumType = cls3;
    }

    public int compareTo(Extension<?, ?> extension) {
        if (extension == this) {
            return 0;
        }
        if (this.tag != extension.tag) {
            return this.tag - extension.tag;
        }
        if (this.datatype != extension.datatype) {
            return this.datatype.value() - extension.datatype.value();
        }
        if (this.label != extension.label) {
            return this.label.value() - extension.label.value();
        }
        if (this.extendedType != null && !this.extendedType.equals(extension.extendedType)) {
            return this.extendedType.getName().compareTo(extension.extendedType.getName());
        }
        if (this.messageType != null && !this.messageType.equals(extension.messageType)) {
            return this.messageType.getName().compareTo(extension.messageType.getName());
        }
        if (this.enumType == null || this.enumType.equals(extension.enumType)) {
            return 0;
        }
        return this.enumType.getName().compareTo(extension.enumType.getName());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Extension) && compareTo((Extension) obj) == 0;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int value = ((((((this.tag * 37) + this.datatype.value()) * 37) + this.label.value()) * 37) + this.extendedType.hashCode()) * 37;
        if (this.messageType != null) {
            hashCode = this.messageType.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + value) * 37;
        if (this.enumType != null) {
            i = this.enumType.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return String.format("[%s %s %s = %d]", new Object[]{this.label, this.datatype, this.name, Integer.valueOf(this.tag)});
    }

    public Class<T> getExtendedType() {
        return this.extendedType;
    }

    public Class<? extends Message> getMessageType() {
        return this.messageType;
    }

    public Class<? extends ProtoEnum> getEnumType() {
        return this.enumType;
    }

    public String getName() {
        return this.name;
    }

    public int getTag() {
        return this.tag;
    }

    public Datatype getDatatype() {
        return this.datatype;
    }

    public Label getLabel() {
        return this.label;
    }
}
