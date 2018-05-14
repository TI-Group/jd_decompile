package c.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class ab implements av<ab, e>, Serializable, Cloneable {
    public static final Map<e, be> e;
    private static final bu f = new bu("InstantMsg");
    private static final bl g = new bl("id", ReplyCode.reply0xb, (short) 1);
    private static final bl h = new bl("errors", ReplyCode.reply0xf, (short) 2);
    private static final bl i = new bl("events", ReplyCode.reply0xf, (short) 3);
    private static final bl j = new bl("game_events", ReplyCode.reply0xf, (short) 4);
    private static final Map<Class<? extends bw>, bx> k = new HashMap();
    public String a;
    public List<s> b;
    public List<u> c;
    public List<u> d;
    private e[] l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<ab> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (ab) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (ab) avVar);
        }

        public void a(bo boVar, ab abVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    abVar.v();
                    return;
                }
                bm l;
                int i;
                u uVar;
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        abVar.a = boVar.v();
                        abVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        abVar.b = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            s sVar = new s();
                            sVar.a(boVar);
                            abVar.b.add(sVar);
                        }
                        boVar.m();
                        abVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        abVar.c = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            uVar = new u();
                            uVar.a(boVar);
                            abVar.c.add(uVar);
                        }
                        boVar.m();
                        abVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        abVar.d = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            uVar = new u();
                            uVar.a(boVar);
                            abVar.d.add(uVar);
                        }
                        boVar.m();
                        abVar.d(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, ab abVar) throws az {
            abVar.v();
            boVar.a(ab.f);
            if (abVar.a != null) {
                boVar.a(ab.g);
                boVar.a(abVar.a);
                boVar.b();
            }
            if (abVar.b != null && abVar.k()) {
                boVar.a(ab.h);
                boVar.a(new bm(ReplyCode.reply0xc, abVar.b.size()));
                for (s b : abVar.b) {
                    b.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (abVar.c != null && abVar.p()) {
                boVar.a(ab.i);
                boVar.a(new bm(ReplyCode.reply0xc, abVar.c.size()));
                for (u b2 : abVar.c) {
                    b2.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (abVar.d != null && abVar.u()) {
                boVar.a(ab.j);
                boVar.a(new bm(ReplyCode.reply0xc, abVar.d.size()));
                for (u b22 : abVar.d) {
                    b22.b(boVar);
                }
                boVar.e();
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
    private static class c extends bz<ab> {
        private c() {
        }

        public void a(bo boVar, ab abVar) throws az {
            boVar = (bv) boVar;
            boVar.a(abVar.a);
            BitSet bitSet = new BitSet();
            if (abVar.k()) {
                bitSet.set(0);
            }
            if (abVar.p()) {
                bitSet.set(1);
            }
            if (abVar.u()) {
                bitSet.set(2);
            }
            boVar.a(bitSet, 3);
            if (abVar.k()) {
                boVar.a(abVar.b.size());
                for (s b : abVar.b) {
                    b.b(boVar);
                }
            }
            if (abVar.p()) {
                boVar.a(abVar.c.size());
                for (u b2 : abVar.c) {
                    b2.b(boVar);
                }
            }
            if (abVar.u()) {
                boVar.a(abVar.d.size());
                for (u b22 : abVar.d) {
                    b22.b(boVar);
                }
            }
        }

        public void b(bo boVar, ab abVar) throws az {
            int i;
            int i2 = 0;
            boVar = (bv) boVar;
            abVar.a = boVar.v();
            abVar.a(true);
            BitSet b = boVar.b(3);
            if (b.get(0)) {
                bm bmVar;
                bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                abVar.b = new ArrayList(bmVar.b);
                for (i = 0; i < bmVar.b; i++) {
                    s sVar = new s();
                    sVar.a(boVar);
                    abVar.b.add(sVar);
                }
                abVar.b(true);
            }
            if (b.get(1)) {
                bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                abVar.c = new ArrayList(bmVar.b);
                for (i = 0; i < bmVar.b; i++) {
                    u uVar = new u();
                    uVar.a(boVar);
                    abVar.c.add(uVar);
                }
                abVar.c(true);
            }
            if (b.get(2)) {
                bm bmVar2 = new bm(ReplyCode.reply0xc, boVar.s());
                abVar.d = new ArrayList(bmVar2.b);
                while (i2 < bmVar2.b) {
                    u uVar2 = new u();
                    uVar2.a(boVar);
                    abVar.d.add(uVar2);
                    i2++;
                }
                abVar.d(true);
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
        ID((short) 1, "id"),
        ERRORS((short) 2, "errors"),
        EVENTS((short) 3, "events"),
        GAME_EVENTS((short) 4, "game_events");
        
        private static final Map<String, e> e = null;
        private final short f;
        private final String g;

        static {
            e = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return ID;
                case 2:
                    return ERRORS;
                case 3:
                    return EVENTS;
                case 4:
                    return GAME_EVENTS;
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
            return (e) e.get(str);
        }

        private e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public short a() {
            return this.f;
        }

        public String b() {
            return this.g;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        k.put(by.class, new b());
        k.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.ID, new be("id", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.ERRORS, new be("errors", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, s.class))));
        enumMap.put(e.EVENTS, new be("events", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, u.class))));
        enumMap.put(e.GAME_EVENTS, new be("game_events", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, u.class))));
        e = Collections.unmodifiableMap(enumMap);
        be.a(ab.class, e);
    }

    public ab() {
        this.l = new e[]{e.ERRORS, e.EVENTS, e.GAME_EVENTS};
    }

    public ab(String str) {
        this();
        this.a = str;
    }

    public ab(ab abVar) {
        List arrayList;
        this.l = new e[]{e.ERRORS, e.EVENTS, e.GAME_EVENTS};
        if (abVar.e()) {
            this.a = abVar.a;
        }
        if (abVar.k()) {
            arrayList = new ArrayList();
            for (s sVar : abVar.b) {
                arrayList.add(new s(sVar));
            }
            this.b = arrayList;
        }
        if (abVar.p()) {
            arrayList = new ArrayList();
            for (u uVar : abVar.c) {
                arrayList.add(new u(uVar));
            }
            this.c = arrayList;
        }
        if (abVar.u()) {
            arrayList = new ArrayList();
            for (u uVar2 : abVar.d) {
                arrayList.add(new u(uVar2));
            }
            this.d = arrayList;
        }
    }

    public ab a() {
        return new ab(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public String c() {
        return this.a;
    }

    public ab a(String str) {
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

    public int f() {
        return this.b == null ? 0 : this.b.size();
    }

    public Iterator<s> h() {
        return this.b == null ? null : this.b.iterator();
    }

    public void a(s sVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(sVar);
    }

    public List<s> i() {
        return this.b;
    }

    public ab a(List<s> list) {
        this.b = list;
        return this;
    }

    public void j() {
        this.b = null;
    }

    public boolean k() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public int l() {
        return this.c == null ? 0 : this.c.size();
    }

    public Iterator<u> m() {
        return this.c == null ? null : this.c.iterator();
    }

    public void a(u uVar) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(uVar);
    }

    public List<u> n() {
        return this.c;
    }

    public ab b(List<u> list) {
        this.c = list;
        return this;
    }

    public void o() {
        this.c = null;
    }

    public boolean p() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public int q() {
        return this.d == null ? 0 : this.d.size();
    }

    public Iterator<u> r() {
        return this.d == null ? null : this.d.iterator();
    }

    public void b(u uVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(uVar);
    }

    public List<u> s() {
        return this.d;
    }

    public ab c(List<u> list) {
        this.d = list;
        return this;
    }

    public void t() {
        this.d = null;
    }

    public boolean u() {
        return this.d != null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) k.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) k.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InstantMsg(");
        stringBuilder.append("id:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("errors:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("events:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        if (u()) {
            stringBuilder.append(", ");
            stringBuilder.append("game_events:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void v() throws az {
        if (this.a == null) {
            throw new bp("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
