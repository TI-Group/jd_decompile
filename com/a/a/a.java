package com.a.a;

import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public abstract class a implements Cloneable {
    ArrayList<a> a = null;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);

        void d(a aVar);
    }

    public abstract boolean d();

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return e();
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public a e() {
        try {
            a aVar = (a) super.clone();
            if (this.a != null) {
                ArrayList arrayList = this.a;
                aVar.a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    aVar.a.add(arrayList.get(i));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
