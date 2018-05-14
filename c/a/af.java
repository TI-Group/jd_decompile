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
public class af implements av<af, e>, Serializable, Cloneable {
    public static final Map<e, be> c;
    private static final bu d = new bu("Page");
    private static final bl e = new bl("page_name", ReplyCode.reply0xb, (short) 1);
    private static final bl f = new bl("duration", (byte) 10, (short) 2);
    private static final Map<Class<? extends bw>, bx> g = new HashMap();
    public String a;
    public long b;
    private byte i;

    /* compiled from: TbsSdkJava */
    private static class a extends by<af> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (af) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (af) avVar);
        }

        public void a(bo boVar, af afVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (afVar.i()) {
                        afVar.j();
                        return;
                    }
                    throw new bp("Required field 'duration' was not found in serialized data! Struct: " + toString());
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        afVar.a = boVar.v();
                        afVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        afVar.b = boVar.t();
                        afVar.b(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, af afVar) throws az {
            afVar.j();
            boVar.a(af.d);
            if (afVar.a != null) {
                boVar.a(af.e);
                boVar.a(afVar.a);
                boVar.b();
            }
            boVar.a(af.f);
            boVar.a(afVar.b);
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
    private static class c extends bz<af> {
        private c() {
        }

        public void a(bo boVar, af afVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(afVar.a);
            bvVar.a(afVar.b);
        }

        public void b(bo boVar, af afVar) throws az {
            bv bvVar = (bv) boVar;
            afVar.a = bvVar.v();
            afVar.a(true);
            afVar.b = bvVar.t();
            afVar.b(true);
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
        PAGE_NAME((short) 1, "page_name"),
        DURATION((short) 2, "duration");
        
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
                    return PAGE_NAME;
                case 2:
                    return DURATION;
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
        enumMap.put(e.PAGE_NAME, new be("page_name", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.DURATION, new be("duration", (byte) 1, new bf((byte) 10)));
        c = Collections.unmodifiableMap(enumMap);
        be.a(af.class, c);
    }

    public af() {
        this.i = (byte) 0;
    }

    public af(String str, long j) {
        this();
        this.a = str;
        this.b = j;
        b(true);
    }

    public af(af afVar) {
        this.i = (byte) 0;
        this.i = afVar.i;
        if (afVar.e()) {
            this.a = afVar.a;
        }
        this.b = afVar.b;
    }

    public af a() {
        return new af(this);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
    }

    public String c() {
        return this.a;
    }

    public af a(String str) {
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

    public long f() {
        return this.b;
    }

    public af a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public void h() {
        this.i = at.b(this.i, 0);
    }

    public boolean i() {
        return at.a(this.i, 0);
    }

    public void b(boolean z) {
        this.i = at.a(this.i, 0, z);
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
        StringBuilder stringBuilder = new StringBuilder("Page(");
        stringBuilder.append("page_name:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void j() throws az {
        if (this.a == null) {
            throw new bp("Required field 'page_name' was not present! Struct: " + toString());
        }
    }
}
