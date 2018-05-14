package c.a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: TbsSdkJava */
public abstract class bc<T extends bc<?, ?>, F extends ba> implements av<T, F> {
    private static final Map<Class<? extends bw>, bx> a = new HashMap();
    protected Object b;
    protected F c;

    /* compiled from: TbsSdkJava */
    private static class a extends by<bc> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (bc) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (bc) avVar);
        }

        public void a(bo boVar, bc bcVar) throws az {
            bcVar.c = null;
            bcVar.b = null;
            boVar.f();
            bl h = boVar.h();
            bcVar.b = bcVar.a(boVar, h);
            if (bcVar.b != null) {
                bcVar.c = bcVar.b(h.c);
            }
            boVar.i();
            boVar.h();
            boVar.g();
        }

        public void b(bo boVar, bc bcVar) throws az {
            if (bcVar.i() == null || bcVar.j() == null) {
                throw new bp("Cannot write a TUnion with no set value!");
            }
            boVar.a(bcVar.c());
            boVar.a(bcVar.a(bcVar.c));
            bcVar.c(boVar);
            boVar.b();
            boVar.c();
            boVar.a();
        }
    }

    /* compiled from: TbsSdkJava */
    private static class b implements bx {
        private b() {
        }

        public /* synthetic */ bw b() {
            return a();
        }

        public a a() {
            return new a();
        }
    }

    /* compiled from: TbsSdkJava */
    private static class c extends bz<bc> {
        private c() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (bc) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (bc) avVar);
        }

        public void a(bo boVar, bc bcVar) throws az {
            bcVar.c = null;
            bcVar.b = null;
            short r = boVar.r();
            bcVar.b = bcVar.a(boVar, r);
            if (bcVar.b != null) {
                bcVar.c = bcVar.b(r);
            }
        }

        public void b(bo boVar, bc bcVar) throws az {
            if (bcVar.i() == null || bcVar.j() == null) {
                throw new bp("Cannot write a TUnion with no set value!");
            }
            boVar.a(bcVar.c.a());
            bcVar.d(boVar);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class d implements bx {
        private d() {
        }

        public /* synthetic */ bw b() {
            return a();
        }

        public c a() {
            return new c();
        }
    }

    protected abstract bl a(F f);

    protected abstract Object a(bo boVar, bl blVar) throws az;

    protected abstract Object a(bo boVar, short s) throws az;

    protected abstract void a(F f, Object obj) throws ClassCastException;

    protected abstract F b(short s);

    protected abstract bu c();

    protected abstract void c(bo boVar) throws az;

    protected abstract void d(bo boVar) throws az;

    protected bc() {
        this.c = null;
        this.b = null;
    }

    static {
        a.put(by.class, new b());
        a.put(bz.class, new d());
    }

    protected bc(F f, Object obj) {
        b(f, obj);
    }

    protected bc(bc<T, F> bcVar) {
        if (bcVar.getClass().equals(getClass())) {
            this.c = bcVar.c;
            this.b = a(bcVar.b);
            return;
        }
        throw new ClassCastException();
    }

    private static Object a(Object obj) {
        if (obj instanceof av) {
            return ((av) obj).g();
        }
        if (obj instanceof ByteBuffer) {
            return ax.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        if (obj instanceof Map) {
            return a((Map) obj);
        }
        return obj;
    }

    private static Map a(Map<Object, Object> map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        Set hashSet = new HashSet();
        for (Object a : set) {
            hashSet.add(a(a));
        }
        return hashSet;
    }

    private static List a(List list) {
        List arrayList = new ArrayList(list.size());
        for (Object a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public F i() {
        return this.c;
    }

    public Object j() {
        return this.b;
    }

    public Object b(F f) {
        if (f == this.c) {
            return j();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.c);
    }

    public Object c(int i) {
        return b(b((short) i));
    }

    public boolean k() {
        return this.c != null;
    }

    public boolean c(F f) {
        return this.c == f;
    }

    public boolean d(int i) {
        return c(b((short) i));
    }

    public void a(bo boVar) throws az {
        ((bx) a.get(boVar.y())).b().b(boVar, this);
    }

    public void b(F f, Object obj) {
        a((ba) f, obj);
        this.c = f;
        this.b = obj;
    }

    public void a(int i, Object obj) {
        b(b((short) i), obj);
    }

    public void b(bo boVar) throws az {
        ((bx) a.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" ");
        if (i() != null) {
            Object j = j();
            stringBuilder.append(a(i()).a);
            stringBuilder.append(":");
            if (j instanceof ByteBuffer) {
                ax.a((ByteBuffer) j, stringBuilder);
            } else {
                stringBuilder.append(j.toString());
            }
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public final void b() {
        this.c = null;
        this.b = null;
    }
}
