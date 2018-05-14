package c.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class z implements av<z, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("Imprint");
    private static final bl f = new bl("property", ReplyCode.reply0xd, (short) 1);
    private static final bl g = new bl("version", (byte) 8, (short) 2);
    private static final bl h = new bl("checksum", ReplyCode.reply0xb, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public Map<String, aa> a;
    public int b;
    public String c;
    private byte k;

    /* compiled from: TbsSdkJava */
    private static class a extends by<z> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (z) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (z) avVar);
        }

        public void a(bo boVar, z zVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (zVar.j()) {
                        zVar.n();
                        return;
                    }
                    throw new bp("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xd) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        bn j = boVar.j();
                        zVar.a = new HashMap(j.c * 2);
                        for (int i = 0; i < j.c; i++) {
                            String v = boVar.v();
                            aa aaVar = new aa();
                            aaVar.a(boVar);
                            zVar.a.put(v, aaVar);
                        }
                        boVar.k();
                        zVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        zVar.b = boVar.s();
                        zVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        zVar.c = boVar.v();
                        zVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, z zVar) throws az {
            zVar.n();
            boVar.a(z.e);
            if (zVar.a != null) {
                boVar.a(z.f);
                boVar.a(new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, zVar.a.size()));
                for (Entry entry : zVar.a.entrySet()) {
                    boVar.a((String) entry.getKey());
                    ((aa) entry.getValue()).b(boVar);
                }
                boVar.d();
                boVar.b();
            }
            boVar.a(z.g);
            boVar.a(zVar.b);
            boVar.b();
            if (zVar.c != null) {
                boVar.a(z.h);
                boVar.a(zVar.c);
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
    private static class c extends bz<z> {
        private c() {
        }

        public void a(bo boVar, z zVar) throws az {
            boVar = (bv) boVar;
            boVar.a(zVar.a.size());
            for (Entry entry : zVar.a.entrySet()) {
                boVar.a((String) entry.getKey());
                ((aa) entry.getValue()).b(boVar);
            }
            boVar.a(zVar.b);
            boVar.a(zVar.c);
        }

        public void b(bo boVar, z zVar) throws az {
            boVar = (bv) boVar;
            bn bnVar = new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, boVar.s());
            zVar.a = new HashMap(bnVar.c * 2);
            for (int i = 0; i < bnVar.c; i++) {
                String v = boVar.v();
                aa aaVar = new aa();
                aaVar.a(boVar);
                zVar.a.put(v, aaVar);
            }
            zVar.a(true);
            zVar.b = boVar.s();
            zVar.b(true);
            zVar.c = boVar.v();
            zVar.c(true);
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
        PROPERTY((short) 1, "property"),
        VERSION((short) 2, "version"),
        CHECKSUM((short) 3, "checksum");
        
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
                    return PROPERTY;
                case 2:
                    return VERSION;
                case 3:
                    return CHECKSUM;
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
        return c(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        i.put(by.class, new b());
        i.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new be("property", (byte) 1, new bh(ReplyCode.reply0xd, new bf(ReplyCode.reply0xb), new bi(ReplyCode.reply0xc, aa.class))));
        enumMap.put(e.VERSION, new be("version", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.CHECKSUM, new be("checksum", (byte) 1, new bf(ReplyCode.reply0xb)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(z.class, d);
    }

    public z() {
        this.k = (byte) 0;
    }

    public z(Map<String, aa> map, int i, String str) {
        this();
        this.a = map;
        this.b = i;
        b(true);
        this.c = str;
    }

    public z(z zVar) {
        this.k = (byte) 0;
        this.k = zVar.k;
        if (zVar.f()) {
            Map hashMap = new HashMap();
            for (Entry entry : zVar.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new aa((aa) entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = zVar.b;
        if (zVar.m()) {
            this.c = zVar.c;
        }
    }

    public z a() {
        return new z(this);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public void a(String str, aa aaVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, aaVar);
    }

    public Map<String, aa> d() {
        return this.a;
    }

    public z a(Map<String, aa> map) {
        this.a = map;
        return this;
    }

    public void e() {
        this.a = null;
    }

    public boolean f() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public int h() {
        return this.b;
    }

    public z a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void i() {
        this.k = at.b(this.k, 0);
    }

    public boolean j() {
        return at.a(this.k, 0);
    }

    public void b(boolean z) {
        this.k = at.a(this.k, 0, z);
    }

    public String k() {
        return this.c;
    }

    public z a(String str) {
        this.c = str;
        return this;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public e c(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void n() throws az {
        if (this.a == null) {
            throw new bp("Required field 'property' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new bp("Required field 'checksum' was not present! Struct: " + toString());
        }
    }
}
