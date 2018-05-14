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
public class ak implements av<ak, e>, Serializable, Cloneable {
    public static final Map<e, be> h;
    private static final bu i = new bu("Session");
    private static final bl j = new bl("id", ReplyCode.reply0xb, (short) 1);
    private static final bl k = new bl("start_time", (byte) 10, (short) 2);
    private static final bl l = new bl("end_time", (byte) 10, (short) 3);
    private static final bl m = new bl("duration", (byte) 10, (short) 4);
    private static final bl n = new bl("pages", ReplyCode.reply0xf, (short) 5);
    private static final bl o = new bl("locations", ReplyCode.reply0xf, (short) 6);
    private static final bl p = new bl("traffic", ReplyCode.reply0xc, (short) 7);
    private static final Map<Class<? extends bw>, bx> q = new HashMap();
    public String a;
    public long b;
    public long c;
    public long d;
    public List<af> e;
    public List<ad> f;
    public al g;
    private byte u;
    private e[] v;

    /* compiled from: TbsSdkJava */
    private static class a extends by<ak> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (ak) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (ak) avVar);
        }

        public void a(bo boVar, ak akVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!akVar.i()) {
                        throw new bp("Required field 'start_time' was not found in serialized data! Struct: " + toString());
                    } else if (!akVar.l()) {
                        throw new bp("Required field 'end_time' was not found in serialized data! Struct: " + toString());
                    } else if (akVar.o()) {
                        akVar.C();
                        return;
                    } else {
                        throw new bp("Required field 'duration' was not found in serialized data! Struct: " + toString());
                    }
                }
                bm l;
                int i;
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        akVar.a = boVar.v();
                        akVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        akVar.b = boVar.t();
                        akVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        akVar.c = boVar.t();
                        akVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        akVar.d = boVar.t();
                        akVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        akVar.e = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            af afVar = new af();
                            afVar.a(boVar);
                            akVar.e.add(afVar);
                        }
                        boVar.m();
                        akVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        akVar.f = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            ad adVar = new ad();
                            adVar.a(boVar);
                            akVar.f.add(adVar);
                        }
                        boVar.m();
                        akVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        akVar.g = new al();
                        akVar.g.a(boVar);
                        akVar.g(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, ak akVar) throws az {
            akVar.C();
            boVar.a(ak.i);
            if (akVar.a != null) {
                boVar.a(ak.j);
                boVar.a(akVar.a);
                boVar.b();
            }
            boVar.a(ak.k);
            boVar.a(akVar.b);
            boVar.b();
            boVar.a(ak.l);
            boVar.a(akVar.c);
            boVar.b();
            boVar.a(ak.m);
            boVar.a(akVar.d);
            boVar.b();
            if (akVar.e != null && akVar.t()) {
                boVar.a(ak.n);
                boVar.a(new bm(ReplyCode.reply0xc, akVar.e.size()));
                for (af b : akVar.e) {
                    b.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (akVar.f != null && akVar.y()) {
                boVar.a(ak.o);
                boVar.a(new bm(ReplyCode.reply0xc, akVar.f.size()));
                for (ad b2 : akVar.f) {
                    b2.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (akVar.g != null && akVar.B()) {
                boVar.a(ak.p);
                akVar.g.b(boVar);
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
    private static class c extends bz<ak> {
        private c() {
        }

        public void a(bo boVar, ak akVar) throws az {
            boVar = (bv) boVar;
            boVar.a(akVar.a);
            boVar.a(akVar.b);
            boVar.a(akVar.c);
            boVar.a(akVar.d);
            BitSet bitSet = new BitSet();
            if (akVar.t()) {
                bitSet.set(0);
            }
            if (akVar.y()) {
                bitSet.set(1);
            }
            if (akVar.B()) {
                bitSet.set(2);
            }
            boVar.a(bitSet, 3);
            if (akVar.t()) {
                boVar.a(akVar.e.size());
                for (af b : akVar.e) {
                    b.b(boVar);
                }
            }
            if (akVar.y()) {
                boVar.a(akVar.f.size());
                for (ad b2 : akVar.f) {
                    b2.b(boVar);
                }
            }
            if (akVar.B()) {
                akVar.g.b(boVar);
            }
        }

        public void b(bo boVar, ak akVar) throws az {
            int i = 0;
            boVar = (bv) boVar;
            akVar.a = boVar.v();
            akVar.a(true);
            akVar.b = boVar.t();
            akVar.b(true);
            akVar.c = boVar.t();
            akVar.c(true);
            akVar.d = boVar.t();
            akVar.d(true);
            BitSet b = boVar.b(3);
            if (b.get(0)) {
                bm bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                akVar.e = new ArrayList(bmVar.b);
                for (int i2 = 0; i2 < bmVar.b; i2++) {
                    af afVar = new af();
                    afVar.a(boVar);
                    akVar.e.add(afVar);
                }
                akVar.e(true);
            }
            if (b.get(1)) {
                bm bmVar2 = new bm(ReplyCode.reply0xc, boVar.s());
                akVar.f = new ArrayList(bmVar2.b);
                while (i < bmVar2.b) {
                    ad adVar = new ad();
                    adVar.a(boVar);
                    akVar.f.add(adVar);
                    i++;
                }
                akVar.f(true);
            }
            if (b.get(2)) {
                akVar.g = new al();
                akVar.g.a(boVar);
                akVar.g(true);
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
        START_TIME((short) 2, "start_time"),
        END_TIME((short) 3, "end_time"),
        DURATION((short) 4, "duration"),
        PAGES((short) 5, "pages"),
        LOCATIONS((short) 6, "locations"),
        TRAFFIC((short) 7, "traffic");
        
        private static final Map<String, e> h = null;
        private final short i;
        private final String j;

        static {
            h = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                h.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return ID;
                case 2:
                    return START_TIME;
                case 3:
                    return END_TIME;
                case 4:
                    return DURATION;
                case 5:
                    return PAGES;
                case 6:
                    return LOCATIONS;
                case 7:
                    return TRAFFIC;
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
            return (e) h.get(str);
        }

        private e(short s, String str) {
            this.i = s;
            this.j = str;
        }

        public short a() {
            return this.i;
        }

        public String b() {
            return this.j;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        q.put(by.class, new b());
        q.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.ID, new be("id", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.START_TIME, new be("start_time", (byte) 1, new bf((byte) 10)));
        enumMap.put(e.END_TIME, new be("end_time", (byte) 1, new bf((byte) 10)));
        enumMap.put(e.DURATION, new be("duration", (byte) 1, new bf((byte) 10)));
        enumMap.put(e.PAGES, new be("pages", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, af.class))));
        enumMap.put(e.LOCATIONS, new be("locations", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, ad.class))));
        enumMap.put(e.TRAFFIC, new be("traffic", (byte) 2, new bi(ReplyCode.reply0xc, al.class)));
        h = Collections.unmodifiableMap(enumMap);
        be.a(ak.class, h);
    }

    public ak() {
        this.u = (byte) 0;
        this.v = new e[]{e.PAGES, e.LOCATIONS, e.TRAFFIC};
    }

    public ak(String str, long j, long j2, long j3) {
        this();
        this.a = str;
        this.b = j;
        b(true);
        this.c = j2;
        c(true);
        this.d = j3;
        d(true);
    }

    public ak(ak akVar) {
        List arrayList;
        this.u = (byte) 0;
        this.v = new e[]{e.PAGES, e.LOCATIONS, e.TRAFFIC};
        this.u = akVar.u;
        if (akVar.e()) {
            this.a = akVar.a;
        }
        this.b = akVar.b;
        this.c = akVar.c;
        this.d = akVar.d;
        if (akVar.t()) {
            arrayList = new ArrayList();
            for (af afVar : akVar.e) {
                arrayList.add(new af(afVar));
            }
            this.e = arrayList;
        }
        if (akVar.y()) {
            arrayList = new ArrayList();
            for (ad adVar : akVar.f) {
                arrayList.add(new ad(adVar));
            }
            this.f = arrayList;
        }
        if (akVar.B()) {
            this.g = new al(akVar.g);
        }
    }

    public ak a() {
        return new ak(this);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = 0;
        d(false);
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public String c() {
        return this.a;
    }

    public ak a(String str) {
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

    public ak a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public void h() {
        this.u = at.b(this.u, 0);
    }

    public boolean i() {
        return at.a(this.u, 0);
    }

    public void b(boolean z) {
        this.u = at.a(this.u, 0, z);
    }

    public long j() {
        return this.c;
    }

    public ak b(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public void k() {
        this.u = at.b(this.u, 1);
    }

    public boolean l() {
        return at.a(this.u, 1);
    }

    public void c(boolean z) {
        this.u = at.a(this.u, 1, z);
    }

    public long m() {
        return this.d;
    }

    public ak c(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public void n() {
        this.u = at.b(this.u, 2);
    }

    public boolean o() {
        return at.a(this.u, 2);
    }

    public void d(boolean z) {
        this.u = at.a(this.u, 2, z);
    }

    public int p() {
        return this.e == null ? 0 : this.e.size();
    }

    public Iterator<af> q() {
        return this.e == null ? null : this.e.iterator();
    }

    public void a(af afVar) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(afVar);
    }

    public List<af> r() {
        return this.e;
    }

    public ak a(List<af> list) {
        this.e = list;
        return this;
    }

    public void s() {
        this.e = null;
    }

    public boolean t() {
        return this.e != null;
    }

    public void e(boolean z) {
        if (!z) {
            this.e = null;
        }
    }

    public int u() {
        return this.f == null ? 0 : this.f.size();
    }

    public Iterator<ad> v() {
        return this.f == null ? null : this.f.iterator();
    }

    public void a(ad adVar) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(adVar);
    }

    public List<ad> w() {
        return this.f;
    }

    public ak b(List<ad> list) {
        this.f = list;
        return this;
    }

    public void x() {
        this.f = null;
    }

    public boolean y() {
        return this.f != null;
    }

    public void f(boolean z) {
        if (!z) {
            this.f = null;
        }
    }

    public al z() {
        return this.g;
    }

    public ak a(al alVar) {
        this.g = alVar;
        return this;
    }

    public void A() {
        this.g = null;
    }

    public boolean B() {
        return this.g != null;
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) q.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) q.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session(");
        stringBuilder.append("id:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("start_time:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("end_time:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.d);
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("pages:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (y()) {
            stringBuilder.append(", ");
            stringBuilder.append("locations:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (B()) {
            stringBuilder.append(", ");
            stringBuilder.append("traffic:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void C() throws az {
        if (this.a == null) {
            throw new bp("Required field 'id' was not present! Struct: " + toString());
        } else if (this.g != null) {
            this.g.j();
        }
    }
}
