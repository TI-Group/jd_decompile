package c.a;

import com.tencent.stat.DeviceInfo;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class u implements av<u, e>, Serializable, Cloneable {
    public static final Map<e, be> f;
    private static final bu g = new bu("Event");
    private static final bl h = new bl("name", ReplyCode.reply0xb, (short) 1);
    private static final bl i = new bl("properties", ReplyCode.reply0xd, (short) 2);
    private static final bl j = new bl("duration", (byte) 10, (short) 3);
    private static final bl k = new bl("acc", (byte) 8, (short) 4);
    private static final bl l = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 5);
    private static final Map<Class<? extends bw>, bx> m = new HashMap();
    public String a;
    public Map<String, ag> b;
    public long c;
    public int d;
    public long e;
    private byte q;
    private e[] r;

    /* compiled from: TbsSdkJava */
    private static class a extends by<u> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (u) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (u) avVar);
        }

        public void a(bo boVar, u uVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (uVar.s()) {
                        uVar.t();
                        return;
                    }
                    throw new bp("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        uVar.a = boVar.v();
                        uVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xd) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        bn j = boVar.j();
                        uVar.b = new HashMap(j.c * 2);
                        for (int i = 0; i < j.c; i++) {
                            String v = boVar.v();
                            ag agVar = new ag();
                            agVar.a(boVar);
                            uVar.b.put(v, agVar);
                        }
                        boVar.k();
                        uVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        uVar.c = boVar.t();
                        uVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        uVar.d = boVar.s();
                        uVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        uVar.e = boVar.t();
                        uVar.e(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, u uVar) throws az {
            uVar.t();
            boVar.a(u.g);
            if (uVar.a != null) {
                boVar.a(u.h);
                boVar.a(uVar.a);
                boVar.b();
            }
            if (uVar.b != null) {
                boVar.a(u.i);
                boVar.a(new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, uVar.b.size()));
                for (Entry entry : uVar.b.entrySet()) {
                    boVar.a((String) entry.getKey());
                    ((ag) entry.getValue()).b(boVar);
                }
                boVar.d();
                boVar.b();
            }
            if (uVar.m()) {
                boVar.a(u.j);
                boVar.a(uVar.c);
                boVar.b();
            }
            if (uVar.p()) {
                boVar.a(u.k);
                boVar.a(uVar.d);
                boVar.b();
            }
            boVar.a(u.l);
            boVar.a(uVar.e);
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
    private static class c extends bz<u> {
        private c() {
        }

        public void a(bo boVar, u uVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(uVar.a);
            bvVar.a(uVar.b.size());
            for (Entry entry : uVar.b.entrySet()) {
                bvVar.a((String) entry.getKey());
                ((ag) entry.getValue()).b((bo) bvVar);
            }
            bvVar.a(uVar.e);
            BitSet bitSet = new BitSet();
            if (uVar.m()) {
                bitSet.set(0);
            }
            if (uVar.p()) {
                bitSet.set(1);
            }
            bvVar.a(bitSet, 2);
            if (uVar.m()) {
                bvVar.a(uVar.c);
            }
            if (uVar.p()) {
                bvVar.a(uVar.d);
            }
        }

        public void b(bo boVar, u uVar) throws az {
            bv bvVar = (bv) boVar;
            uVar.a = bvVar.v();
            uVar.a(true);
            bn bnVar = new bn(ReplyCode.reply0xb, ReplyCode.reply0xc, bvVar.s());
            uVar.b = new HashMap(bnVar.c * 2);
            for (int i = 0; i < bnVar.c; i++) {
                String v = bvVar.v();
                ag agVar = new ag();
                agVar.a((bo) bvVar);
                uVar.b.put(v, agVar);
            }
            uVar.b(true);
            uVar.e = bvVar.t();
            uVar.e(true);
            BitSet b = bvVar.b(2);
            if (b.get(0)) {
                uVar.c = bvVar.t();
                uVar.c(true);
            }
            if (b.get(1)) {
                uVar.d = bvVar.s();
                uVar.d(true);
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
        NAME((short) 1, "name"),
        PROPERTIES((short) 2, "properties"),
        DURATION((short) 3, "duration"),
        ACC((short) 4, "acc"),
        TS((short) 5, DeviceInfo.TAG_TIMESTAMPS);
        
        private static final Map<String, e> f = null;
        private final short g;
        private final String h;

        static {
            f = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return NAME;
                case 2:
                    return PROPERTIES;
                case 3:
                    return DURATION;
                case 4:
                    return ACC;
                case 5:
                    return TS;
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
            return (e) f.get(str);
        }

        private e(short s, String str) {
            this.g = s;
            this.h = str;
        }

        public short a() {
            return this.g;
        }

        public String b() {
            return this.h;
        }
    }

    public /* synthetic */ ba b(int i) {
        return c(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        m.put(by.class, new b());
        m.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.NAME, new be("name", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.PROPERTIES, new be("properties", (byte) 1, new bh(ReplyCode.reply0xd, new bf(ReplyCode.reply0xb), new bi(ReplyCode.reply0xc, ag.class))));
        enumMap.put(e.DURATION, new be("duration", (byte) 2, new bf((byte) 10)));
        enumMap.put(e.ACC, new be("acc", (byte) 2, new bf((byte) 8)));
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        f = Collections.unmodifiableMap(enumMap);
        be.a(u.class, f);
    }

    public u() {
        this.q = (byte) 0;
        this.r = new e[]{e.DURATION, e.ACC};
    }

    public u(String str, Map<String, ag> map, long j) {
        this();
        this.a = str;
        this.b = map;
        this.e = j;
        e(true);
    }

    public u(u uVar) {
        this.q = (byte) 0;
        this.r = new e[]{e.DURATION, e.ACC};
        this.q = uVar.q;
        if (uVar.e()) {
            this.a = uVar.a;
        }
        if (uVar.j()) {
            Map hashMap = new HashMap();
            for (Entry entry : uVar.b.entrySet()) {
                hashMap.put((String) entry.getKey(), new ag((ag) entry.getValue()));
            }
            this.b = hashMap;
        }
        this.c = uVar.c;
        this.d = uVar.d;
        this.e = uVar.e;
    }

    public u a() {
        return new u(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        c(false);
        this.c = 0;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
    }

    public String c() {
        return this.a;
    }

    public u a(String str) {
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

    public void a(String str, ag agVar) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, agVar);
    }

    public Map<String, ag> h() {
        return this.b;
    }

    public u a(Map<String, ag> map) {
        this.b = map;
        return this;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public long k() {
        return this.c;
    }

    public u a(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public void l() {
        this.q = at.b(this.q, 0);
    }

    public boolean m() {
        return at.a(this.q, 0);
    }

    public void c(boolean z) {
        this.q = at.a(this.q, 0, z);
    }

    public int n() {
        return this.d;
    }

    public u a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public void o() {
        this.q = at.b(this.q, 1);
    }

    public boolean p() {
        return at.a(this.q, 1);
    }

    public void d(boolean z) {
        this.q = at.a(this.q, 1, z);
    }

    public long q() {
        return this.e;
    }

    public u b(long j) {
        this.e = j;
        e(true);
        return this;
    }

    public void r() {
        this.q = at.b(this.q, 2);
    }

    public boolean s() {
        return at.a(this.q, 2);
    }

    public void e(boolean z) {
        this.q = at.a(this.q, 2, z);
    }

    public e c(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) m.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) m.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Event(");
        stringBuilder.append("name:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("properties:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("duration:");
            stringBuilder.append(this.c);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("acc:");
            stringBuilder.append(this.d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void t() throws az {
        if (this.a == null) {
            throw new bp("Required field 'name' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new bp("Required field 'properties' was not present! Struct: " + toString());
        }
    }
}
