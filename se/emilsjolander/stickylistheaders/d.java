package se.emilsjolander.stickylistheaders;

import java.util.HashMap;

/* compiled from: TbsSdkJava */
class d<TKey, TValue> {
    HashMap<TKey, TValue> a = new HashMap();
    HashMap<TValue, TKey> b = new HashMap();

    d() {
    }

    public void a(TKey tKey, TValue tValue) {
        c(tKey);
        d(tValue);
        this.a.put(tKey, tValue);
        this.b.put(tValue, tKey);
    }

    public TKey a(TValue tValue) {
        return this.b.get(tValue);
    }

    public TValue b(TKey tKey) {
        return this.a.get(tKey);
    }

    public void c(TKey tKey) {
        if (b(tKey) != null) {
            this.b.remove(b(tKey));
        }
        this.a.remove(tKey);
    }

    public void d(TValue tValue) {
        if (a(tValue) != null) {
            this.a.remove(a(tValue));
        }
        this.b.remove(tValue);
    }
}
