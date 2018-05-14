package com.squareup.wire;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.Message.Label;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class Redactor<T extends Message> {
    private static final Redactor<?> NOOP_REDACTOR = new Redactor<Message>(null, null, null, null) {
        public Message redact(Message message) {
            return message;
        }
    };
    private static final Map<Class<? extends Message>, Redactor> redactors = new LinkedHashMap();
    private final Constructor<?> builderConstructor;
    private final List<Field> messageFields;
    private final List<Redactor<?>> messageRedactors;
    private final List<Field> redactedFields;

    /* compiled from: TbsSdkJava */
    private static class FutureRedactor<T extends Message> extends Redactor<T> {
        private Redactor<T> delegate;

        public FutureRedactor() {
            super(null, null, null, null);
        }

        public void setDelegate(Redactor<T> redactor) {
            this.delegate = redactor;
        }

        public T redact(T t) {
            if (this.delegate != null) {
                return this.delegate.redact(t);
            }
            throw new IllegalStateException("Delegate was not set.");
        }
    }

    Redactor(Constructor<?> constructor, List<Field> list, List<Field> list2, List<Redactor<?>> list3) {
        this.builderConstructor = constructor;
        this.redactedFields = list;
        this.messageFields = list2;
        this.messageRedactors = list3;
    }

    public static synchronized <T extends Message> Redactor<T> get(Class<T> cls) {
        Redactor<T> redactor;
        synchronized (Redactor.class) {
            redactor = (Redactor) redactors.get(cls);
            if (redactor == null) {
                FutureRedactor futureRedactor = new FutureRedactor();
                redactors.put(cls, futureRedactor);
                try {
                    Class cls2 = Class.forName(cls.getName() + "$Builder");
                    List arrayList = new ArrayList();
                    List arrayList2 = new ArrayList();
                    List arrayList3 = new ArrayList();
                    for (Field field : cls.getDeclaredFields()) {
                        if (!Modifier.isStatic(field.getModifiers())) {
                            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                            if (protoField == null || !protoField.redacted()) {
                                if (Message.class.isAssignableFrom(field.getType())) {
                                    Field declaredField = cls2.getDeclaredField(field.getName());
                                    Redactor redactor2 = get(declaredField.getType());
                                    if (redactor2 != NOOP_REDACTOR) {
                                        arrayList2.add(declaredField);
                                        arrayList3.add(redactor2);
                                    }
                                }
                            } else if (protoField.label() == Label.REQUIRED) {
                                throw new IllegalArgumentException(String.format("Field %s is REQUIRED and cannot be redacted.", new Object[]{field}));
                            } else {
                                arrayList.add(cls2.getDeclaredField(field.getName()));
                            }
                        }
                    }
                    if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                        redactor = NOOP_REDACTOR;
                    } else {
                        redactor = new Redactor(cls2.getConstructor(new Class[]{cls}), arrayList, arrayList2, arrayList3);
                    }
                    futureRedactor.setDelegate(redactor);
                    redactors.put(cls, redactor);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        return redactor;
    }

    public T redact(T t) {
        T t2 = null;
        if (t != null) {
            try {
                Field field;
                Builder builder = (Builder) this.builderConstructor.newInstance(new Object[]{t});
                for (Field field2 : this.redactedFields) {
                    field2.set(builder, null);
                }
                for (int i = 0; i < this.messageFields.size(); i++) {
                    field2 = (Field) this.messageFields.get(i);
                    field2.set(builder, ((Redactor) this.messageRedactors.get(i)).redact((Message) field2.get(builder)));
                }
                t2 = builder.build();
            } catch (Exception e) {
                throw new AssertionError(e.getMessage());
            }
        }
        return t2;
    }
}
