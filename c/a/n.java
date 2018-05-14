package c.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class n implements av<n, e>, Serializable, Cloneable {
    public static final Map<e, be> c;
    private static final bu d = new bu("ActiveUser");
    private static final bl e = new bl("provider", ReplyCode.reply0xb, (short) 1);
    private static final bl f = new bl("puid", ReplyCode.reply0xb, (short) 2);
    private static final Map<Class<? extends bw>, bx> g = new HashMap();
    public String a;
    public String b;

    /* compiled from: TbsSdkJava */
    private static class a extends by<n> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (n) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (n) avVar);
        }

        public void a(bo boVar, n nVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    nVar.j();
                    return;
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        nVar.a = boVar.v();
                        nVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        nVar.b = boVar.v();
                        nVar.b(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, n nVar) throws az {
            nVar.j();
            boVar.a(n.d);
            if (nVar.a != null) {
                boVar.a(n.e);
                boVar.a(nVar.a);
                boVar.b();
            }
            if (nVar.b != null) {
                boVar.a(n.f);
                boVar.a(nVar.b);
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
    private static class c extends bz<n> {
        private c() {
        }

        public void a(bo boVar, n nVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(nVar.a);
            bvVar.a(nVar.b);
        }

        public void b(bo boVar, n nVar) throws az {
            bv bvVar = (bv) boVar;
            nVar.a = bvVar.v();
            nVar.a(true);
            nVar.b = bvVar.v();
            nVar.b(true);
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
        PROVIDER((short) 1, "provider"),
        PUID((short) 2, "puid");
        
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
                    return PROVIDER;
                case 2:
                    return PUID;
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
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        g.put(by.class, new b());
        g.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.PROVIDER, new be("provider", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.PUID, new be("puid", (byte) 1, new bf(ReplyCode.reply0xb)));
        c = Collections.unmodifiableMap(enumMap);
        be.a(n.class, c);
    }

    public n(String str, String str2) {
        this();
        this.a = str;
        this.b = str2;
    }

    public n(n nVar) {
        if (nVar.e()) {
            this.a = nVar.a;
        }
        if (nVar.i()) {
            this.b = nVar.b;
        }
    }

    public n a() {
        return new n(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
    }

    public String c() {
        return this.a;
    }

    public n a(String str) {
        this.a = str;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public String f() {
        return this.b;
    }

    public n b(String str) {
        this.b = str;
        return this;
    }

    public void h() {
        this.b = null;
    }

    public boolean i() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) g.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) g.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActiveUser(");
        stringBuilder.append("provider:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("puid:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void j() throws az {
        if (this.a == null) {
            throw new bp("Required field 'provider' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new bp("Required field 'puid' was not present! Struct: " + toString());
        }
    }
}
