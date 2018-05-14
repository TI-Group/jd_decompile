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
public class y implements av<y, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("IdTracking");
    private static final bl f = new bl("snapshots", ReplyCode.reply0xd, (short) 1);
    private static final bl g = new bl("journals", ReplyCode.reply0xf, (short) 2);
    private static final bl h = new bl("checksum", ReplyCode.reply0xb, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public Map<String, x> a;
    public List<v> b;
    public String c;
    private e[] j;

    /* compiled from: TbsSdkJava */
    private static class a extends by<y> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (y) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (y) avVar);
        }

        public void a(bo boVar, y yVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    yVar.p();
                    return;
                }
                int i;
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xd) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        bn j = boVar.j();
                        yVar.a = new HashMap(j.c * 2);
                        for (i = 0; i < j.c; i++) {
                            String v = boVar.v();
                            x xVar = new x();
                            xVar.a(boVar);
                            yVar.a.put(v, xVar);
                        }
                        boVar.k();
                        yVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xf) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        bm l = boVar.l();
                        yVar.b = new ArrayList(l.b);
                        for (i = 0; i < l.b; i++) {
                            v vVar = new v();
                            vVar.a(boVar);
                            yVar.b.add(vVar);
                        }
                        boVar.m();
                        yVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        yVar.c = boVar.v();
                        yVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, y yVar) throws az {
            yVar.p();
            boVar.a(y.e);
            if (yVar.a != null) {
                boVar.a(y.f);
                boVar.a(new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, yVar.a.size()));
                for (Entry entry : yVar.a.entrySet()) {
                    boVar.a((String) entry.getKey());
                    ((x) entry.getValue()).b(boVar);
                }
                boVar.d();
                boVar.b();
            }
            if (yVar.b != null && yVar.l()) {
                boVar.a(y.g);
                boVar.a(new bm(ReplyCode.reply0xc, yVar.b.size()));
                for (v b : yVar.b) {
                    b.b(boVar);
                }
                boVar.e();
                boVar.b();
            }
            if (yVar.c != null && yVar.o()) {
                boVar.a(y.h);
                boVar.a(yVar.c);
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
    private static class c extends bz<y> {
        private c() {
        }

        public void a(bo boVar, y yVar) throws az {
            boVar = (bv) boVar;
            boVar.a(yVar.a.size());
            for (Entry entry : yVar.a.entrySet()) {
                boVar.a((String) entry.getKey());
                ((x) entry.getValue()).b(boVar);
            }
            BitSet bitSet = new BitSet();
            if (yVar.l()) {
                bitSet.set(0);
            }
            if (yVar.o()) {
                bitSet.set(1);
            }
            boVar.a(bitSet, 2);
            if (yVar.l()) {
                boVar.a(yVar.b.size());
                for (v b : yVar.b) {
                    b.b(boVar);
                }
            }
            if (yVar.o()) {
                boVar.a(yVar.c);
            }
        }

        public void b(bo boVar, y yVar) throws az {
            int i = 0;
            boVar = (bv) boVar;
            bn bnVar = new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, boVar.s());
            yVar.a = new HashMap(bnVar.c * 2);
            for (int i2 = 0; i2 < bnVar.c; i2++) {
                String v = boVar.v();
                x xVar = new x();
                xVar.a(boVar);
                yVar.a.put(v, xVar);
            }
            yVar.a(true);
            BitSet b = boVar.b(2);
            if (b.get(0)) {
                bm bmVar = new bm(ReplyCode.reply0xc, boVar.s());
                yVar.b = new ArrayList(bmVar.b);
                while (i < bmVar.b) {
                    v vVar = new v();
                    vVar.a(boVar);
                    yVar.b.add(vVar);
                    i++;
                }
                yVar.b(true);
            }
            if (b.get(1)) {
                yVar.c = boVar.v();
                yVar.c(true);
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
        SNAPSHOTS((short) 1, "snapshots"),
        JOURNALS((short) 2, "journals"),
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
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
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
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        i.put(by.class, new b());
        i.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new be("snapshots", (byte) 1, new bh(ReplyCode.reply0xd, new bf(ReplyCode.reply0xb), new bi(ReplyCode.reply0xc, x.class))));
        enumMap.put(e.JOURNALS, new be("journals", (byte) 2, new bg(ReplyCode.reply0xf, new bi(ReplyCode.reply0xc, v.class))));
        enumMap.put(e.CHECKSUM, new be("checksum", (byte) 2, new bf(ReplyCode.reply0xb)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(y.class, d);
    }

    public y() {
        this.j = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public y(Map<String, x> map) {
        this();
        this.a = map;
    }

    public y(y yVar) {
        this.j = new e[]{e.JOURNALS, e.CHECKSUM};
        if (yVar.f()) {
            Map hashMap = new HashMap();
            for (Entry entry : yVar.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new x((x) entry.getValue()));
            }
            this.a = hashMap;
        }
        if (yVar.l()) {
            List arrayList = new ArrayList();
            for (v vVar : yVar.b) {
                arrayList.add(new v(vVar));
            }
            this.b = arrayList;
        }
        if (yVar.o()) {
            this.c = yVar.c;
        }
    }

    public y a() {
        return new y(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public void a(String str, x xVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, xVar);
    }

    public Map<String, x> d() {
        return this.a;
    }

    public y a(Map<String, x> map) {
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
        return this.b == null ? 0 : this.b.size();
    }

    public Iterator<v> i() {
        return this.b == null ? null : this.b.iterator();
    }

    public void a(v vVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(vVar);
    }

    public List<v> j() {
        return this.b;
    }

    public y a(List<v> list) {
        this.b = list;
        return this;
    }

    public void k() {
        this.b = null;
    }

    public boolean l() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public String m() {
        return this.c;
    }

    public y a(String str) {
        this.c = str;
        return this;
    }

    public void n() {
        this.c = null;
    }

    public boolean o() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void p() throws az {
        if (this.a == null) {
            throw new bp("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }
}
