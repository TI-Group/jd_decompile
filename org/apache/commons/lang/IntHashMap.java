package org.apache.commons.lang;

/* compiled from: TbsSdkJava */
class IntHashMap {
    private transient int count;
    private float loadFactor;
    private transient Entry[] table;
    private int threshold;

    /* compiled from: TbsSdkJava */
    private static class Entry {
        int hash;
        int key;
        Entry next;
        Object value;

        protected Entry(int i, int i2, Object obj, Entry entry) {
            this.hash = i;
            this.key = i2;
            this.value = obj;
            this.next = entry;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public IntHashMap(int i) {
        this(i, 0.75f);
    }

    public IntHashMap(int i, float f) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Capacity: ").append(i).toString());
        } else if (f <= 0.0f) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Load: ").append(f).toString());
        } else {
            if (i == 0) {
                i = 1;
            }
            this.loadFactor = f;
            this.table = new Entry[i];
            this.threshold = (int) (((float) i) * f);
        }
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i]; entry != null; entry = entry.next) {
                if (entry.value.equals(obj)) {
                    return true;
                }
            }
            length = i;
        }
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public boolean containsKey(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                return true;
            }
        }
        return false;
    }

    public Object get(int i) {
        Entry[] entryArr = this.table;
        for (Entry entry = entryArr[(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i) % entryArr.length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                return entry.value;
            }
        }
        return null;
    }

    protected void rehash() {
        int length = this.table.length;
        Entry[] entryArr = this.table;
        int i = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i];
        this.threshold = (int) (((float) i) * this.loadFactor);
        this.table = entryArr2;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                Entry entry = entryArr[i2];
                while (entry != null) {
                    Entry entry2 = entry.next;
                    int i3 = (entry.hash & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % i;
                    entry.next = entryArr2[i3];
                    entryArr2[i3] = entry;
                    entry = entry2;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    public Object put(int i, Object obj) {
        Entry[] entryArr = this.table;
        int length = (i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.next) {
            if (entry.hash == i) {
                Object obj2 = entry.value;
                entry.value = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            entryArr = this.table;
            length = (i & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) % entryArr.length;
        }
        entryArr[length] = new Entry(i, i, obj, entryArr[length]);
        this.count++;
        return null;
    }

    public Object remove(int i) {
        Entry[] entryArr = this.table;
        int length = (ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED & i) % entryArr.length;
        Entry entry = entryArr[length];
        Entry entry2 = null;
        while (entry != null) {
            if (entry.hash == i) {
                if (entry2 != null) {
                    entry2.next = entry.next;
                } else {
                    entryArr[length] = entry.next;
                }
                this.count--;
                Object obj = entry.value;
                entry.value = null;
                return obj;
            }
            Entry entry3 = entry;
            entry = entry.next;
            entry2 = entry3;
        }
        return null;
    }

    public synchronized void clear() {
        Entry[] entryArr = this.table;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                entryArr[length] = null;
            } else {
                this.count = 0;
            }
        }
    }
}
