package com.squareup.wire;

import com.squareup.wire.Message.Builder;
import java.util.Collections;
import java.util.List;

/* compiled from: TbsSdkJava */
public abstract class ExtendableMessage<T extends ExtendableMessage<?>> extends Message {
    private static final long serialVersionUID = 0;
    transient ExtensionMap<T> extensionMap;

    /* compiled from: TbsSdkJava */
    public static abstract class ExtendableBuilder<T extends ExtendableMessage<?>> extends Builder<T> {
        ExtensionMap<T> extensionMap;

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(ExtendableMessage<T> extendableMessage) {
            super(extendableMessage);
            if (extendableMessage != null && extendableMessage.extensionMap != null) {
                this.extensionMap = new ExtensionMap(extendableMessage.extensionMap);
            }
        }

        public <E> E getExtension(Extension<T, E> extension) {
            return this.extensionMap == null ? null : this.extensionMap.get(extension);
        }

        public <E> ExtendableBuilder<T> setExtension(Extension<T, E> extension, E e) {
            if (this.extensionMap == null) {
                this.extensionMap = new ExtensionMap(extension, e);
            } else {
                this.extensionMap.put(extension, e);
            }
            return this;
        }
    }

    protected ExtendableMessage() {
    }

    protected void setBuilder(ExtendableBuilder<T> extendableBuilder) {
        super.setBuilder(extendableBuilder);
        if (extendableBuilder.extensionMap != null) {
            this.extensionMap = new ExtensionMap(extendableBuilder.extensionMap);
        }
    }

    public List<Extension<T, ?>> getExtensions() {
        if (this.extensionMap == null) {
            return Collections.emptyList();
        }
        return this.extensionMap.getExtensions();
    }

    public <E> E getExtension(Extension<T, E> extension) {
        return this.extensionMap == null ? null : this.extensionMap.get(extension);
    }

    protected boolean extensionsEqual(ExtendableMessage<T> extendableMessage) {
        if (this.extensionMap == null) {
            return extendableMessage.extensionMap == null;
        } else {
            return this.extensionMap.equals(extendableMessage.extensionMap);
        }
    }

    protected int extensionsHashCode() {
        return this.extensionMap == null ? 0 : this.extensionMap.hashCode();
    }

    String extensionsToString() {
        return this.extensionMap == null ? "{}" : this.extensionMap.toString();
    }
}
