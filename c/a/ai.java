package c.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class ai implements av<ai, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("Response");
    private static final bl f = new bl("resp_code", (byte) 8, (short) 1);
    private static final bl g = new bl("msg", ReplyCode.reply0xb, (short) 2);
    private static final bl h = new bl("imprint", ReplyCode.reply0xc, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public int a;
    public String b;
    public z c;
    private byte k;
    private e[] l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<ai> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (ai) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (ai) avVar);
        }

        public void a(bo boVar, ai aiVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (aiVar.e()) {
                        aiVar.m();
                        return;
                    }
                    throw new bp("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aiVar.a = boVar.s();
                        aiVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aiVar.b = boVar.v();
                        aiVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aiVar.c = new z();
                        aiVar.c.a(boVar);
                        aiVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, ai aiVar) throws az {
            aiVar.m();
            boVar.a(ai.e);
            boVar.a(ai.f);
            boVar.a(aiVar.a);
            boVar.b();
            if (aiVar.b != null && aiVar.i()) {
                boVar.a(ai.g);
                boVar.a(aiVar.b);
                boVar.b();
            }
            if (aiVar.c != null && aiVar.l()) {
                boVar.a(ai.h);
                aiVar.c.b(boVar);
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
    private static class c extends bz<ai> {
        private c() {
        }

        public void a(bo boVar, ai aiVar) throws az {
            boVar = (bv) boVar;
            boVar.a(aiVar.a);
            BitSet bitSet = new BitSet();
            if (aiVar.i()) {
                bitSet.set(0);
            }
            if (aiVar.l()) {
                bitSet.set(1);
            }
            boVar.a(bitSet, 2);
            if (aiVar.i()) {
                boVar.a(aiVar.b);
            }
            if (aiVar.l()) {
                aiVar.c.b(boVar);
            }
        }

        public void b(bo boVar, ai aiVar) throws az {
            boVar = (bv) boVar;
            aiVar.a = boVar.s();
            aiVar.a(true);
            BitSet b = boVar.b(2);
            if (b.get(0)) {
                aiVar.b = boVar.v();
                aiVar.b(true);
            }
            if (b.get(1)) {
                aiVar.c = new z();
                aiVar.c.a(boVar);
                aiVar.c(true);
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
        RESP_CODE((short) 1, "resp_code"),
        MSG((short) 2, "msg"),
        IMPRINT((short) 3, "imprint");
        
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
                    return RESP_CODE;
                case 2:
                    return MSG;
                case 3:
                    return IMPRINT;
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
        enumMap.put(e.RESP_CODE, new be("resp_code", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.MSG, new be("msg", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.IMPRINT, new be("imprint", (byte) 2, new bi(ReplyCode.reply0xc, z.class)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(ai.class, d);
    }

    public ai() {
        this.k = (byte) 0;
        this.l = new e[]{e.MSG, e.IMPRINT};
    }

    public ai(int i) {
        this();
        this.a = i;
        a(true);
    }

    public ai(ai aiVar) {
        this.k = (byte) 0;
        this.l = new e[]{e.MSG, e.IMPRINT};
        this.k = aiVar.k;
        this.a = aiVar.a;
        if (aiVar.i()) {
            this.b = aiVar.b;
        }
        if (aiVar.l()) {
            this.c = new z(aiVar.c);
        }
    }

    public ai a() {
        return new ai(this);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public int c() {
        return this.a;
    }

    public ai a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void d() {
        this.k = at.b(this.k, 0);
    }

    public boolean e() {
        return at.a(this.k, 0);
    }

    public void a(boolean z) {
        this.k = at.a(this.k, 0, z);
    }

    public String f() {
        return this.b;
    }

    public ai a(String str) {
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

    public z j() {
        return this.c;
    }

    public ai a(z zVar) {
        this.c = zVar;
        return this;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
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
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.a);
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
        if (this.c != null) {
            this.c.n();
        }
    }
}
