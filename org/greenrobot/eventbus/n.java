package org.greenrobot.eventbus;

/* compiled from: TbsSdkJava */
final class n {
    final Object a;
    final l b;
    volatile boolean c = true;

    n(Object obj, l lVar) {
        this.a = obj;
        this.b = lVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.a == nVar.a && this.b.equals(nVar.b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
