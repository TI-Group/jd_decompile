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
public class q implements av<q, e>, Serializable, Cloneable {
    public static final Map<e, be> b;
    private static final bu c = new bu("ControlPolicy");
    private static final bl d = new bl("latent", ReplyCode.reply0xc, (short) 1);
    private static final Map<Class<? extends bw>, bx> e = new HashMap();
    public ac a;
    private e[] f;

    /* compiled from: TbsSdkJava */
    private static class a extends by<q> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (q) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (q) avVar);
        }

        public void a(bo boVar, q qVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    qVar.f();
                    return;
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        qVar.a = new ac();
                        qVar.a.a(boVar);
                        qVar.a(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, q qVar) throws az {
            qVar.f();
            boVar.a(q.c);
            if (qVar.a != null && qVar.e()) {
                boVar.a(q.d);
                qVar.a.b(boVar);
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
    private static class c extends bz<q> {
        private c() {
        }

        public void a(bo boVar, q qVar) throws az {
            boVar = (bv) boVar;
            BitSet bitSet = new BitSet();
            if (qVar.e()) {
                bitSet.set(0);
            }
            boVar.a(bitSet, 1);
            if (qVar.e()) {
                qVar.a.b(boVar);
            }
        }

        public void b(bo boVar, q qVar) throws az {
            boVar = (bv) boVar;
            if (boVar.b(1).get(0)) {
                qVar.a = new ac();
                qVar.a.a(boVar);
                qVar.a(true);
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
        LATENT((short) 1, "latent");
        
        private static final Map<String, e> b = null;
        private final short c;
        private final String d;

        static {
            b = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                b.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return LATENT;
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
            return (e) b.get(str);
        }

        private e(short s, String str) {
            this.c = s;
            this.d = str;
        }

        public short a() {
            return this.c;
        }

        public String b() {
            return this.d;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        e.put(by.class, new b());
        e.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.LATENT, new be("latent", (byte) 2, new bi(ReplyCode.reply0xc, ac.class)));
        b = Collections.unmodifiableMap(enumMap);
        be.a(q.class, b);
    }

    public q() {
        this.f = new e[]{e.LATENT};
    }

    public q(q qVar) {
        this.f = new e[]{e.LATENT};
        if (qVar.e()) {
            this.a = new ac(qVar.a);
        }
    }

    public q a() {
        return new q(this);
    }

    public void b() {
        this.a = null;
    }

    public ac c() {
        return this.a;
    }

    public q a(ac acVar) {
        this.a = acVar;
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

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) e.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) e.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ControlPolicy(");
        if (e()) {
            stringBuilder.append("latent:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void f() throws az {
        if (this.a != null) {
            this.a.j();
        }
    }
}
