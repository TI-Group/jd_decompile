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
import java.util.Map.Entry;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class am implements av<am, e>, Serializable, Cloneable {
    private static final Map<Class<? extends bw>, bx> A = new HashMap();
    public static final Map<e, be> m;
    private static final bu n = new bu("UALogEntry");
    private static final bl o = new bl("client_stats", ReplyCode.reply0xc, (short) 1);
    private static final bl p = new bl("app_info", ReplyCode.reply0xc, (short) 2);
    private static final bl q = new bl("device_info", ReplyCode.reply0xc, (short) 3);
    private static final bl r = new bl("misc_info", ReplyCode.reply0xc, (short) 4);
    private static final bl s = new bl("activate_msg", ReplyCode.reply0xc, (short) 5);
    private static final bl t = new bl("instant_msgs", ReplyCode.reply0xf, (short) 6);
    private static final bl u = new bl("sessions", ReplyCode.reply0xf, (short) 7);
    private static final bl v = new bl("imprint", ReplyCode.reply0xc, (short) 8);
    private static final bl w = new bl("id_tracking", ReplyCode.reply0xc, (short) 9);
    private static final bl x = new bl("active_user", ReplyCode.reply0xc, (short) 10);
    private static final bl y = new bl("control_policy", ReplyCode.reply0xc, (short) 11);
    private static final bl z = new bl("group_info", ReplyCode.reply0xd, (short) 12);
    private e[] B;
    public p a;
    public o b;
    public r c;
    public ae d;
    public m e;
    public List<ab> f;
    public List<ak> g;
    public z h;
    public y i;
    public n j;
    public q k;
    public Map<String, Integer> l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<am> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (am) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (am) avVar);
        }

        public void a(bo boVar, am amVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    amVar.S();
                    return;
                }
                bm l;
                int i;
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.a = new p();
                        amVar.a.a(boVar);
                        amVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.b = new o();
                        amVar.b.a(boVar);
                        amVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.c = new r();
                        amVar.c.a(boVar);
                        amVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.d = new ae();
                        amVar.d.a(boVar);
                        amVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.e = new m();
                        amVar.e.a(boVar);
                        amVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        amVar.f = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            ab abVar = new ab();
                            abVar.a(boVar);
                            amVar.f.add(abVar);
                        }
                        boVar.m();
                        amVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        l = boVar.l();
                        amVar.g = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            ak akVar = new ak();
                            akVar.a(boVar);
                            amVar.g.add(akVar);
                        }
                        boVar.m();
                        amVar.g(true);
                        break;
                    case (short) 8:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.h = new z();
                        amVar.h.a(boVar);
                        amVar.h(true);
                        break;
                    case (short) 9:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.i = new y();
                        amVar.i.a(boVar);
                        amVar.i(true);
                        break;
                    case (short) 10:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.j = new n();
                        amVar.j.a(boVar);
                        amVar.j(true);
                        break;
                    case (short) 11:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        amVar.k = new q();
                        amVar.k.a(boVar);
                        amVar.k(true);
                        break;
                    case (short) 12:
                        if (h.b != ReplyCode.reply0xd) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        bn j = boVar.j();
                        amVar.l = new HashMap(j.c * 2);
                        for (i = 0; i < j.c; i++) {
                            amVar.l.put(boVar.v(), Integer.valueOf(boVar.s()));
                        }
                        boVar.k();
                        amVar.l(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, am amVar) throws az {
            amVar.S();
            boVar.a(am.n);
            if (amVar.a != null) {
                boVar.a(am.o);
                amVar.a.b(boVar);
                boVar.b();
            }
            if (amVar.b != null) {
                boVar.a(am.p);
                amVar.b.b(boVar);
                boVar.b();
            }
            if (amVar.c != null) {
                boVar.a(am.q);
                amVar.c.b(boVar);
                boVar.b();
            }
            if (amVar.d != null) {
                boVar.a(am.r);
                amVar.d.b(boVar);
                boVar.b();
            }
            if (amVar.e != null && amVar.r()) {
                boVar.a(am.s);
                amVar.e.b(boVar);
                boVar.b();
            }
            if (amVar.f != null && amVar.w()) {
                boVar.a(am.t);
                boVar.a(new bm(ReplyCode.reply0xc, amVar.f.size()));
                for (ab b : amVar.f) {
                    b.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (amVar.g != null && amVar.B()) {
                boVar.a(am.u);
                boVar.a(new bm(ReplyCode.reply0xc, amVar.g.size()));
                for (ak b2 : amVar.g) {
                    b2.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (amVar.h != null && amVar.E()) {
                boVar.a(am.v);
                amVar.h.b(boVar);
                boVar.b();
            }
            if (amVar.i != null && amVar.H()) {
                boVar.a(am.w);
                amVar.i.b(boVar);
                boVar.b();
            }
            if (amVar.j != null && amVar.K()) {
                boVar.a(am.x);
                amVar.j.b(boVar);
                boVar.b();
            }
            if (amVar.k != null && amVar.N()) {
                boVar.a(am.y);
                amVar.k.b(boVar);
                boVar.b();
            }
            if (amVar.l != null && amVar.R()) {
                boVar.a(am.z);
                boVar.a(new bn(ReplyCode.reply0xb, (byte) 8, amVar.l.size()));
                for (Entry entry : amVar.l.entrySet()) {
                    boVar.a((String) entry.getKey());
                    boVar.a(((Integer) entry.getValue()).intValue());
                }
                boVar.d();
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
    private static class c extends bz<am> {
        private c() {
        }

        public void a(bo boVar, am amVar) throws az {
            boVar = (bv) boVar;
            amVar.a.b(boVar);
            amVar.b.b(boVar);
            amVar.c.b(boVar);
            amVar.d.b(boVar);
            BitSet bitSet = new BitSet();
            if (amVar.r()) {
                bitSet.set(0);
            }
            if (amVar.w()) {
                bitSet.set(1);
            }
            if (amVar.B()) {
                bitSet.set(2);
            }
            if (amVar.E()) {
                bitSet.set(3);
            }
            if (amVar.H()) {
                bitSet.set(4);
            }
            if (amVar.K()) {
                bitSet.set(5);
            }
            if (amVar.N()) {
                bitSet.set(6);
            }
            if (amVar.R()) {
                bitSet.set(7);
            }
            boVar.a(bitSet, 8);
            if (amVar.r()) {
                amVar.e.b(boVar);
            }
            if (amVar.w()) {
                boVar.a(amVar.f.size());
                for (ab b : amVar.f) {
                    b.b(boVar);
                }
            }
            if (amVar.B()) {
                boVar.a(amVar.g.size());
                for (ak b2 : amVar.g) {
                    b2.b(boVar);
                }
            }
            if (amVar.E()) {
                amVar.h.b(boVar);
            }
            if (amVar.H()) {
                amVar.i.b(boVar);
            }
            if (amVar.K()) {
                amVar.j.b(boVar);
            }
            if (amVar.N()) {
                amVar.k.b(boVar);
            }
            if (amVar.R()) {
                boVar.a(amVar.l.size());
                for (Entry entry : amVar.l.entrySet()) {
                    boVar.a((String) entry.getKey());
                    boVar.a(((Integer) entry.getValue()).intValue());
                }
            }
        }

        public void b(bo boVar, am amVar) throws az {
            int i;
            int i2 = 0;
            boVar = (bv) boVar;
            amVar.a = new p();
            amVar.a.a(boVar);
            amVar.a(true);
            amVar.b = new o();
            amVar.b.a(boVar);
            amVar.b(true);
            amVar.c = new r();
            amVar.c.a(boVar);
            amVar.c(true);
            amVar.d = new ae();
            amVar.d.a(boVar);
            amVar.d(true);
            BitSet b = boVar.b(8);
            if (b.get(0)) {
                amVar.e = new m();
                amVar.e.a(boVar);
                amVar.e(true);
            }
            if (b.get(1)) {
                bm bmVar;
                bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                amVar.f = new ArrayList(bmVar.b);
                for (i = 0; i < bmVar.b; i++) {
                    ab abVar = new ab();
                    abVar.a(boVar);
                    amVar.f.add(abVar);
                }
                amVar.f(true);
            }
            if (b.get(2)) {
                bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                amVar.g = new ArrayList(bmVar.b);
                for (i = 0; i < bmVar.b; i++) {
                    ak akVar = new ak();
                    akVar.a(boVar);
                    amVar.g.add(akVar);
                }
                amVar.g(true);
            }
            if (b.get(3)) {
                amVar.h = new z();
                amVar.h.a(boVar);
                amVar.h(true);
            }
            if (b.get(4)) {
                amVar.i = new y();
                amVar.i.a(boVar);
                amVar.i(true);
            }
            if (b.get(5)) {
                amVar.j = new n();
                amVar.j.a(boVar);
                amVar.j(true);
            }
            if (b.get(6)) {
                amVar.k = new q();
                amVar.k.a(boVar);
                amVar.k(true);
            }
            if (b.get(7)) {
                bn bnVar = new bn(ReplyCode.reply0xb, (byte) 8, boVar.s());
                amVar.l = new HashMap(bnVar.c * 2);
                while (i2 < bnVar.c) {
                    amVar.l.put(boVar.v(), Integer.valueOf(boVar.s()));
                    i2++;
                }
                amVar.l(true);
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
        CLIENT_STATS((short) 1, "client_stats"),
        APP_INFO((short) 2, "app_info"),
        DEVICE_INFO((short) 3, "device_info"),
        MISC_INFO((short) 4, "misc_info"),
        ACTIVATE_MSG((short) 5, "activate_msg"),
        INSTANT_MSGS((short) 6, "instant_msgs"),
        SESSIONS((short) 7, "sessions"),
        IMPRINT((short) 8, "imprint"),
        ID_TRACKING((short) 9, "id_tracking"),
        ACTIVE_USER((short) 10, "active_user"),
        CONTROL_POLICY((short) 11, "control_policy"),
        GROUP_INFO((short) 12, "group_info");
        
        private static final Map<String, e> m = null;
        private final short n;
        private final String o;

        static {
            m = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                m.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return CLIENT_STATS;
                case 2:
                    return APP_INFO;
                case 3:
                    return DEVICE_INFO;
                case 4:
                    return MISC_INFO;
                case 5:
                    return ACTIVATE_MSG;
                case 6:
                    return INSTANT_MSGS;
                case 7:
                    return SESSIONS;
                case 8:
                    return IMPRINT;
                case 9:
                    return ID_TRACKING;
                case 10:
                    return ACTIVE_USER;
                case 11:
                    return CONTROL_POLICY;
                case 12:
                    return GROUP_INFO;
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
            return (e) m.get(str);
        }

        private e(short s, String str) {
            this.n = s;
            this.o = str;
        }

        public short a() {
            return this.n;
        }

        public String b() {
            return this.o;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        A.put(by.class, new b());
        A.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.CLIENT_STATS, new be("client_stats", (byte) 1, new bi(ReplyCode.reply0xc, p.class)));
        enumMap.put(e.APP_INFO, new be("app_info", (byte) 1, new bi(ReplyCode.reply0xc, o.class)));
        enumMap.put(e.DEVICE_INFO, new be("device_info", (byte) 1, new bi(ReplyCode.reply0xc, r.class)));
        enumMap.put(e.MISC_INFO, new be("misc_info", (byte) 1, new bi(ReplyCode.reply0xc, ae.class)));
        enumMap.put(e.ACTIVATE_MSG, new be("activate_msg", (byte) 2, new bi(ReplyCode.reply0xc, m.class)));
        enumMap.put(e.INSTANT_MSGS, new be("instant_msgs", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, ab.class))));
        enumMap.put(e.SESSIONS, new be("sessions", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, ak.class))));
        enumMap.put(e.IMPRINT, new be("imprint", (byte) 2, new bi(ReplyCode.reply0xc, z.class)));
        enumMap.put(e.ID_TRACKING, new be("id_tracking", (byte) 2, new bi(ReplyCode.reply0xc, y.class)));
        enumMap.put(e.ACTIVE_USER, new be("active_user", (byte) 2, new bi(ReplyCode.reply0xc, n.class)));
        enumMap.put(e.CONTROL_POLICY, new be("control_policy", (byte) 2, new bi(ReplyCode.reply0xc, q.class)));
        enumMap.put(e.GROUP_INFO, new be("group_info", (byte) 2, new bh(ReplyCode.reply0xd, new bf(ReplyCode.reply0xb), new bf((byte) 8))));
        m = Collections.unmodifiableMap(enumMap);
        be.a(am.class, m);
    }

    public am() {
        this.B = new e[]{e.ACTIVATE_MSG, e.INSTANT_MSGS, e.SESSIONS, e.IMPRINT, e.ID_TRACKING, e.ACTIVE_USER, e.CONTROL_POLICY, e.GROUP_INFO};
    }

    public am(p pVar, o oVar, r rVar, ae aeVar) {
        this();
        this.a = pVar;
        this.b = oVar;
        this.c = rVar;
        this.d = aeVar;
    }

    public am(am amVar) {
        List arrayList;
        this.B = new e[]{e.ACTIVATE_MSG, e.INSTANT_MSGS, e.SESSIONS, e.IMPRINT, e.ID_TRACKING, e.ACTIVE_USER, e.CONTROL_POLICY, e.GROUP_INFO};
        if (amVar.e()) {
            this.a = new p(amVar.a);
        }
        if (amVar.i()) {
            this.b = new o(amVar.b);
        }
        if (amVar.l()) {
            this.c = new r(amVar.c);
        }
        if (amVar.o()) {
            this.d = new ae(amVar.d);
        }
        if (amVar.r()) {
            this.e = new m(amVar.e);
        }
        if (amVar.w()) {
            arrayList = new ArrayList();
            for (ab abVar : amVar.f) {
                arrayList.add(new ab(abVar));
            }
            this.f = arrayList;
        }
        if (amVar.B()) {
            arrayList = new ArrayList();
            for (ak akVar : amVar.g) {
                arrayList.add(new ak(akVar));
            }
            this.g = arrayList;
        }
        if (amVar.E()) {
            this.h = new z(amVar.h);
        }
        if (amVar.H()) {
            this.i = new y(amVar.i);
        }
        if (amVar.K()) {
            this.j = new n(amVar.j);
        }
        if (amVar.N()) {
            this.k = new q(amVar.k);
        }
        if (amVar.R()) {
            Map hashMap = new HashMap();
            for (Entry entry : amVar.l.entrySet()) {
                hashMap.put((String) entry.getKey(), (Integer) entry.getValue());
            }
            this.l = hashMap;
        }
    }

    public am a() {
        return new am(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public p c() {
        return this.a;
    }

    public am a(p pVar) {
        this.a = pVar;
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

    public o f() {
        return this.b;
    }

    public am a(o oVar) {
        this.b = oVar;
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

    public r j() {
        return this.c;
    }

    public am a(r rVar) {
        this.c = rVar;
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

    public ae m() {
        return this.d;
    }

    public am a(ae aeVar) {
        this.d = aeVar;
        return this;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public m p() {
        return this.e;
    }

    public am a(m mVar) {
        this.e = mVar;
        return this;
    }

    public void q() {
        this.e = null;
    }

    public boolean r() {
        return this.e != null;
    }

    public void e(boolean z) {
        if (!z) {
            this.e = null;
        }
    }

    public int s() {
        return this.f == null ? 0 : this.f.size();
    }

    public Iterator<ab> t() {
        return this.f == null ? null : this.f.iterator();
    }

    public void a(ab abVar) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(abVar);
    }

    public List<ab> u() {
        return this.f;
    }

    public am a(List<ab> list) {
        this.f = list;
        return this;
    }

    public void v() {
        this.f = null;
    }

    public boolean w() {
        return this.f != null;
    }

    public void f(boolean z) {
        if (!z) {
            this.f = null;
        }
    }

    public int x() {
        return this.g == null ? 0 : this.g.size();
    }

    public Iterator<ak> y() {
        return this.g == null ? null : this.g.iterator();
    }

    public void a(ak akVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(akVar);
    }

    public List<ak> z() {
        return this.g;
    }

    public am b(List<ak> list) {
        this.g = list;
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

    public z C() {
        return this.h;
    }

    public am a(z zVar) {
        this.h = zVar;
        return this;
    }

    public void D() {
        this.h = null;
    }

    public boolean E() {
        return this.h != null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public y F() {
        return this.i;
    }

    public am a(y yVar) {
        this.i = yVar;
        return this;
    }

    public void G() {
        this.i = null;
    }

    public boolean H() {
        return this.i != null;
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public n I() {
        return this.j;
    }

    public am a(n nVar) {
        this.j = nVar;
        return this;
    }

    public void J() {
        this.j = null;
    }

    public boolean K() {
        return this.j != null;
    }

    public void j(boolean z) {
        if (!z) {
            this.j = null;
        }
    }

    public q L() {
        return this.k;
    }

    public am a(q qVar) {
        this.k = qVar;
        return this;
    }

    public void M() {
        this.k = null;
    }

    public boolean N() {
        return this.k != null;
    }

    public void k(boolean z) {
        if (!z) {
            this.k = null;
        }
    }

    public int O() {
        return this.l == null ? 0 : this.l.size();
    }

    public void a(String str, int i) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        this.l.put(str, Integer.valueOf(i));
    }

    public Map<String, Integer> P() {
        return this.l;
    }

    public am a(Map<String, Integer> map) {
        this.l = map;
        return this;
    }

    public void Q() {
        this.l = null;
    }

    public boolean R() {
        return this.l != null;
    }

    public void l(boolean z) {
        if (!z) {
            this.l = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) A.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) A.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UALogEntry(");
        stringBuilder.append("client_stats:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("app_info:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("device_info:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("misc_info:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.d);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("activate_msg:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (w()) {
            stringBuilder.append(", ");
            stringBuilder.append("instant_msgs:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (B()) {
            stringBuilder.append(", ");
            stringBuilder.append("sessions:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (E()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (H()) {
            stringBuilder.append(", ");
            stringBuilder.append("id_tracking:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (K()) {
            stringBuilder.append(", ");
            stringBuilder.append("active_user:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        if (N()) {
            stringBuilder.append(", ");
            stringBuilder.append("control_policy:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        if (R()) {
            stringBuilder.append(", ");
            stringBuilder.append("group_info:");
            if (this.l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.l);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void S() throws az {
        if (this.a == null) {
            throw new bp("Required field 'client_stats' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new bp("Required field 'app_info' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new bp("Required field 'device_info' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new bp("Required field 'misc_info' was not present! Struct: " + toString());
        } else {
            if (this.a != null) {
                this.a.m();
            }
            if (this.b != null) {
                this.b.K();
            }
            if (this.c != null) {
                this.c.af();
            }
            if (this.d != null) {
                this.d.H();
            }
            if (this.e != null) {
                this.e.f();
            }
            if (this.h != null) {
                this.h.n();
            }
            if (this.i != null) {
                this.i.p();
            }
            if (this.j != null) {
                this.j.j();
            }
            if (this.k != null) {
                this.k.f();
            }
        }
    }
}
