package c.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class p implements av<p, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("ClientStats");
    private static final bl f = new bl("successful_requests", (byte) 8, (short) 1);
    private static final bl g = new bl("failed_requests", (byte) 8, (short) 2);
    private static final bl h = new bl("last_request_spent_ms", (byte) 8, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public int a;
    public int b;
    public int c;
    private byte m;
    private e[] n;

    /* compiled from: TbsSdkJava */
    private static class a extends by<p> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (p) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (p) avVar);
        }

        public void a(bo boVar, p pVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!pVar.e()) {
                        throw new bp("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
                    } else if (pVar.i()) {
                        pVar.m();
                        return;
                    } else {
                        throw new bp("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        pVar.a = boVar.s();
                        pVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        pVar.b = boVar.s();
                        pVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        pVar.c = boVar.s();
                        pVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, p pVar) throws az {
            pVar.m();
            boVar.a(p.e);
            boVar.a(p.f);
            boVar.a(pVar.a);
            boVar.b();
            boVar.a(p.g);
            boVar.a(pVar.b);
            boVar.b();
            if (pVar.l()) {
                boVar.a(p.h);
                boVar.a(pVar.c);
                boVar.b();
            }
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
    private static class c extends bz<p> {
        private c() {
        }

        public void a(bo boVar, p pVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(pVar.a);
            bvVar.a(pVar.b);
            BitSet bitSet = new BitSet();
            if (pVar.l()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (pVar.l()) {
                bvVar.a(pVar.c);
            }
        }

        public void b(bo boVar, p pVar) throws az {
            bv bvVar = (bv) boVar;
            pVar.a = bvVar.s();
            pVar.a(true);
            pVar.b = bvVar.s();
            pVar.b(true);
            if (bvVar.b(1).get(0)) {
                pVar.c = bvVar.s();
                pVar.c(true);
            }
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
        SUCCESSFUL_REQUESTS((short) 1, "successful_requests"),
        FAILED_REQUESTS((short) 2, "failed_requests"),
        LAST_REQUEST_SPENT_MS((short) 3, "last_request_spent_ms");
        
        private static final Map<String, e> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return SUCCESSFUL_REQUESTS;
                case 2:
                    return FAILED_REQUESTS;
                case 3:
                    return LAST_REQUEST_SPENT_MS;
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
            return (e) d.get(str);
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public short a() {
            return this.e;
        }

        public String b() {
            return this.f;
        }
    }

    public /* synthetic */ ba b(int i) {
        return e(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        i.put(by.class, new b());
        i.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.SUCCESSFUL_REQUESTS, new be("successful_requests", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.FAILED_REQUESTS, new be("failed_requests", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.LAST_REQUEST_SPENT_MS, new be("last_request_spent_ms", (byte) 2, new bf((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(p.class, d);
    }

    public p() {
        this.m = (byte) 0;
        this.n = new e[]{e.LAST_REQUEST_SPENT_MS};
        this.a = 0;
        this.b = 0;
    }

    public p(int i, int i2) {
        this();
        this.a = i;
        a(true);
        this.b = i2;
        b(true);
    }

    public p(p pVar) {
        this.m = (byte) 0;
        this.n = new e[]{e.LAST_REQUEST_SPENT_MS};
        this.m = pVar.m;
        this.a = pVar.a;
        this.b = pVar.b;
        this.c = pVar.c;
    }

    public p a() {
        return new p(this);
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        c(false);
        this.c = 0;
    }

    public int c() {
        return this.a;
    }

    public p a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void d() {
        this.m = at.b(this.m, 0);
    }

    public boolean e() {
        return at.a(this.m, 0);
    }

    public void a(boolean z) {
        this.m = at.a(this.m, 0, z);
    }

    public int f() {
        return this.b;
    }

    public p c(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void h() {
        this.m = at.b(this.m, 1);
    }

    public boolean i() {
        return at.a(this.m, 1);
    }

    public void b(boolean z) {
        this.m = at.a(this.m, 1, z);
    }

    public int j() {
        return this.c;
    }

    public p d(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public void k() {
        this.m = at.b(this.m, 2);
    }

    public boolean l() {
        return at.a(this.m, 2);
    }

    public void c(boolean z) {
        this.m = at.a(this.m, 2, z);
    }

    public e e(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ClientStats(");
        stringBuilder.append("successful_requests:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("failed_requests:");
        stringBuilder.append(this.b);
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("last_request_spent_ms:");
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
    }
}
