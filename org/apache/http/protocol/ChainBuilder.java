package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
final class ChainBuilder<E> {
    private final LinkedList<E> list = new LinkedList();
    private final Map<Class<?>, E> uniqueClasses = new HashMap();

    private void ensureUnique(E e) {
        Object remove = this.uniqueClasses.remove(e.getClass());
        if (remove != null) {
            this.list.remove(remove);
        }
        this.uniqueClasses.put(e.getClass(), e);
    }

    public ChainBuilder<E> addFirst(E e) {
        if (e != null) {
            ensureUnique(e);
            this.list.addFirst(e);
        }
        return this;
    }

    public ChainBuilder<E> addLast(E e) {
        if (e != null) {
            ensureUnique(e);
            this.list.addLast(e);
        }
        return this;
    }

    public ChainBuilder<E> addAllFirst(Collection<E> collection) {
        if (collection != null) {
            for (E addFirst : collection) {
                addFirst(addFirst);
            }
        }
        return this;
    }

    public ChainBuilder<E> addAllFirst(E... eArr) {
        if (eArr != null) {
            for (Object addFirst : eArr) {
                addFirst(addFirst);
            }
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(Collection<E> collection) {
        if (collection != null) {
            for (E addLast : collection) {
                addLast(addLast);
            }
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(E... eArr) {
        if (eArr != null) {
            for (Object addLast : eArr) {
                addLast(addLast);
            }
        }
        return this;
    }

    public LinkedList<E> build() {
        return new LinkedList(this.list);
    }
}
