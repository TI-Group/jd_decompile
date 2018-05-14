package com.squareup.wire;

import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: TbsSdkJava */
final class ExtensionMap<T extends ExtendableMessage<?>> {
    private static final int INITIAL_SIZE = 1;
    private Object[] data;
    private int size;

    public <E> ExtensionMap(Extension<T, E> extension, E e) {
        this.data = new Object[2];
        this.data[0] = extension;
        this.data[1] = e;
        this.size = 1;
    }

    public ExtensionMap(ExtensionMap<T> extensionMap) {
        this.data = (Object[]) extensionMap.data.clone();
        this.size = extensionMap.size;
    }

    public int size() {
        return this.size;
    }

    public Extension<T, ?> getExtension(int i) {
        if (i >= 0 && i < this.size) {
            return (Extension) this.data[i];
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public Object getExtensionValue(int i) {
        if (i >= 0 && i < this.size) {
            return this.data[this.size + i];
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public List<Extension<T, ?>> getExtensions() {
        List arrayList = new ArrayList(this.size);
        for (int i = 0; i < this.size; i++) {
            arrayList.add((Extension) this.data[i]);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public <E> E get(Extension<T, E> extension) {
        int binarySearch = Arrays.binarySearch(this.data, 0, this.size, extension);
        return binarySearch < 0 ? null : this.data[binarySearch + this.size];
    }

    public <E> void put(Extension<T, E> extension, E e) {
        int binarySearch = Arrays.binarySearch(this.data, 0, this.size, extension);
        if (binarySearch >= 0) {
            this.data[binarySearch + this.size] = e;
        } else {
            insert(extension, e, -(binarySearch + 1));
        }
    }

    private <E> void insert(Extension<T, E> extension, E e, int i) {
        Object obj = this.data;
        if (this.data.length < (this.size + 1) * 2) {
            obj = new Object[(this.data.length * 2)];
            System.arraycopy(this.data, 0, obj, 0, i);
        }
        if (i < this.size) {
            System.arraycopy(this.data, this.size + i, obj, (this.size + i) + 2, this.size - i);
            System.arraycopy(this.data, i, obj, i + 1, this.size);
        } else {
            System.arraycopy(this.data, this.size, obj, this.size + 1, this.size);
        }
        this.size++;
        this.data = obj;
        this.data[i] = extension;
        this.data[this.size + i] = e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExtensionMap)) {
            return false;
        }
        ExtensionMap extensionMap = (ExtensionMap) obj;
        if (this.size != extensionMap.size) {
            return false;
        }
        for (int i = 0; i < this.size * 2; i++) {
            if (!this.data[i].equals(extensionMap.data[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (i < this.size * 2) {
            i2 = (i2 * 37) + this.data[i].hashCode();
            i++;
        }
        return i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        String str = "";
        int i = 0;
        while (i < this.size) {
            stringBuilder.append(str);
            stringBuilder.append(((Extension) this.data[i]).getTag());
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(this.data[this.size + i]);
            i++;
            str = ", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
