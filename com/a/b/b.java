package com.a.b;

/* compiled from: TbsSdkJava */
public abstract class b<T> extends c<T, Integer> {
    public abstract void a(T t, int i);

    public b(String str) {
        super(Integer.class, str);
    }

    public final void a(T t, Integer num) {
        a((Object) t, Integer.valueOf(num.intValue()));
    }
}
