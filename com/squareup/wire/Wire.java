package com.squareup.wire;

import b.s;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class Wire {
    private final Map<Class<? extends Builder>, BuilderAdapter<? extends Builder>> builderAdapters;
    private final Map<Class<? extends ProtoEnum>, EnumAdapter<? extends ProtoEnum>> enumAdapters;
    private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> messageAdapters;
    final ExtensionRegistry registry;

    public Wire(Class<?>... clsArr) {
        this(Arrays.asList(clsArr));
    }

    public Wire(List<Class<?>> list) {
        this.messageAdapters = new LinkedHashMap();
        this.builderAdapters = new LinkedHashMap();
        this.enumAdapters = new LinkedHashMap();
        this.registry = new ExtensionRegistry();
        for (Class declaredFields : list) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (field.getType().equals(Extension.class)) {
                    try {
                        this.registry.add((Extension) field.get(null));
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
    }

    synchronized <M extends Message> MessageAdapter<M> messageAdapter(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        messageAdapter = (MessageAdapter) this.messageAdapters.get(cls);
        if (messageAdapter == null) {
            messageAdapter = new MessageAdapter(this, cls);
            this.messageAdapters.put(cls, messageAdapter);
        }
        return messageAdapter;
    }

    synchronized <B extends Builder> BuilderAdapter<B> builderAdapter(Class<B> cls) {
        BuilderAdapter<B> builderAdapter;
        builderAdapter = (BuilderAdapter) this.builderAdapters.get(cls);
        if (builderAdapter == null) {
            builderAdapter = new BuilderAdapter(cls);
            this.builderAdapters.put(cls, builderAdapter);
        }
        return builderAdapter;
    }

    synchronized <E extends ProtoEnum> EnumAdapter<E> enumAdapter(Class<E> cls) {
        EnumAdapter<E> enumAdapter;
        enumAdapter = (EnumAdapter) this.enumAdapters.get(cls);
        if (enumAdapter == null) {
            enumAdapter = new EnumAdapter(cls);
            this.enumAdapters.put(cls, enumAdapter);
        }
        return enumAdapter;
    }

    public <M extends Message> M parseFrom(byte[] bArr, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(bArr), (Class) cls);
    }

    public <M extends Message> M parseFrom(byte[] bArr, int i, int i2, Class<M> cls) throws IOException {
        boolean z;
        boolean z2 = true;
        Preconditions.checkNotNull(bArr, "bytes");
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset < 0");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "count < 0");
        if (i + i2 > bArr.length) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "offset + count > bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(bArr, i, i2), (Class) cls);
    }

    public <M extends Message> M parseFrom(InputStream inputStream, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(inputStream, "input");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(inputStream), (Class) cls);
    }

    public <M extends Message> M parseFrom(s sVar, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(sVar, "input");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(sVar), (Class) cls);
    }

    private <M extends Message> M parseFrom(WireInput wireInput, Class<M> cls) throws IOException {
        return messageAdapter(cls).read(wireInput);
    }

    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }
}
