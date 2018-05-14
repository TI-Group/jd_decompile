package c.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class al implements av<al, e>, Serializable, Cloneable {
    public static final Map<e, be> c;
    private static final bu d = new bu("Traffic");
    private static final bl e = new bl("upload_traffic", (byte) 8, (short) 1);
    private static final bl f = new bl("download_traffic", (byte) 8, (short) 2);
    private static final Map<Class<? extends bw>, bx> g = new HashMap();
    public int a;
    public int b;
    private byte j;

    /* compiled from: TbsSdkJava */
    private static class a extends by<al> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (al) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (al) avVar);
        }

        public void a(bo boVar, al alVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!alVar.e()) {
                        throw new bp("Required field 'upload_traffic' was not found in serialized data! Struct: " + toString());
                    } else if (alVar.i()) {
                        alVar.j();
                        return;
                    } else {
                        throw new bp("Required field 'download_traffic' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        alVar.a = boVar.s();
                        alVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        alVar.b = boVar.s();
                        alVar.b(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, al alVar) throws az {
            alVar.j();
            boVar.a(al.d);
            boVar.a(al.e);
            boVar.a(alVar.a);
            boVar.b();
            boVar.a(al.f);
            boVar.a(alVar.b);
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
    private static class c extends bz<al> {
        private c() {
        }

        public void a(bo boVar, al alVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(alVar.a);
            bvVar.a(alVar.b);
        }

        public void b(bo boVar, al alVar) throws az {
            bv bvVar = (bv) boVar;
            alVar.a = bvVar.s();
            alVar.a(true);
            alVar.b = bvVar.s();
            alVar.b(true);
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

    /* compiled from: TbsSdkJava */
    public enum e implements ba {
        UPLOAD_TRAFFIC((short) 1, "upload_traffic"),
        DOWNLOAD_TRAFFIC((short) 2, "download_traffic");
        
        private static final Map<String, e> c = null;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                c.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return UPLOAD_TRAFFIC;
                case 2:
                    return DOWNLOAD_TRAFFIC;
                default:
                    return null;
            }
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return (e) c.get(str);
        }

        private e(short s, String str) {
            this.d = s;
            this.e = str;
        }

        public short a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }
    }

    public /* synthetic */ ba b(int i) {
        return d(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        g.put(by.class, new b());
        g.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.UPLOAD_TRAFFIC, new be("upload_traffic", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.DOWNLOAD_TRAFFIC, new be("download_traffic", (byte) 1, new bf((byte) 8)));
        c = Collections.unmodifiableMap(enumMap);
        be.a(al.class, c);
    }

    public al() {
        this.j = (byte) 0;
    }

    public al(int i, int i2) {
        this();
        this.a = i;
        a(true);
        this.b = i2;
        b(true);
    }

    public al(al alVar) {
        this.j = (byte) 0;
        this.j = alVar.j;
        this.a = alVar.a;
        this.b = alVar.b;
    }

    public al a() {
        return new al(this);
    }

    public void b() {
        a(false);
        this.a = 0;
        b(false);
        this.b = 0;
    }

    public int c() {
        return this.a;
    }

    public al a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void d() {
        this.j = at.b(this.j, 0);
    }

    public boolean e() {
        return at.a(this.j, 0);
    }

    public void a(boolean z) {
        this.j = at.a(this.j, 0, z);
    }

    public int f() {
        return this.b;
    }

    public al c(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void h() {
        this.j = at.b(this.j, 1);
    }

    public boolean i() {
        return at.a(this.j, 1);
    }

    public void b(boolean z) {
        this.j = at.a(this.j, 1, z);
    }

    public e d(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) g.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) g.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Traffic(");
        stringBuilder.append("upload_traffic:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("download_traffic:");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void j() throws az {
    }
}
