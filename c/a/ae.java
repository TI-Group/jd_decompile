package c.a;

import com.jingdong.jdma.JDMaInterface;
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
public class ae implements av<ae, e>, Serializable, Cloneable {
    public static final Map<e, be> k;
    private static final bu l = new bu("MiscInfo");
    private static final bl m = new bl("time_zone", (byte) 8, (short) 1);
    private static final bl n = new bl("language", ReplyCode.reply0xb, (short) 2);
    private static final bl o = new bl("country", ReplyCode.reply0xb, (short) 3);
    private static final bl p = new bl("latitude", (byte) 4, (short) 4);
    private static final bl q = new bl("longitude", (byte) 4, (short) 5);
    private static final bl r = new bl("carrier", ReplyCode.reply0xb, (short) 6);
    private static final bl s = new bl("latency", (byte) 8, (short) 7);
    private static final bl t = new bl("display_name", ReplyCode.reply0xb, (short) 8);
    private static final bl u = new bl("access_type", (byte) 8, (short) 9);
    private static final bl v = new bl("access_subtype", ReplyCode.reply0xb, (short) 10);
    private static final Map<Class<? extends bw>, bx> w = new HashMap();
    private byte B;
    private e[] C;
    public int a;
    public String b;
    public String c;
    public double d;
    public double e;
    public String f;
    public int g;
    public String h;
    public l i;
    public String j;

    /* compiled from: TbsSdkJava */
    private static class a extends by<ae> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (ae) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (ae) avVar);
        }

        public void a(bo boVar, ae aeVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    aeVar.H();
                    return;
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.a = boVar.s();
                        aeVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.b = boVar.v();
                        aeVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.c = boVar.v();
                        aeVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != (byte) 4) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.d = boVar.u();
                        aeVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != (byte) 4) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.e = boVar.u();
                        aeVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.f = boVar.v();
                        aeVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.g = boVar.s();
                        aeVar.g(true);
                        break;
                    case (short) 8:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.h = boVar.v();
                        aeVar.h(true);
                        break;
                    case (short) 9:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.i = l.a(boVar.s());
                        aeVar.i(true);
                        break;
                    case (short) 10:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aeVar.j = boVar.v();
                        aeVar.j(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, ae aeVar) throws az {
            aeVar.H();
            boVar.a(ae.l);
            if (aeVar.e()) {
                boVar.a(ae.m);
                boVar.a(aeVar.a);
                boVar.b();
            }
            if (aeVar.b != null && aeVar.i()) {
                boVar.a(ae.n);
                boVar.a(aeVar.b);
                boVar.b();
            }
            if (aeVar.c != null && aeVar.l()) {
                boVar.a(ae.o);
                boVar.a(aeVar.c);
                boVar.b();
            }
            if (aeVar.o()) {
                boVar.a(ae.p);
                boVar.a(aeVar.d);
                boVar.b();
            }
            if (aeVar.r()) {
                boVar.a(ae.q);
                boVar.a(aeVar.e);
                boVar.b();
            }
            if (aeVar.f != null && aeVar.u()) {
                boVar.a(ae.r);
                boVar.a(aeVar.f);
                boVar.b();
            }
            if (aeVar.x()) {
                boVar.a(ae.s);
                boVar.a(aeVar.g);
                boVar.b();
            }
            if (aeVar.h != null && aeVar.A()) {
                boVar.a(ae.t);
                boVar.a(aeVar.h);
                boVar.b();
            }
            if (aeVar.i != null && aeVar.D()) {
                boVar.a(ae.u);
                boVar.a(aeVar.i.a());
                boVar.b();
            }
            if (aeVar.j != null && aeVar.G()) {
                boVar.a(ae.v);
                boVar.a(aeVar.j);
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
    private static class c extends bz<ae> {
        private c() {
        }

        public void a(bo boVar, ae aeVar) throws az {
            bv bvVar = (bv) boVar;
            BitSet bitSet = new BitSet();
            if (aeVar.e()) {
                bitSet.set(0);
            }
            if (aeVar.i()) {
                bitSet.set(1);
            }
            if (aeVar.l()) {
                bitSet.set(2);
            }
            if (aeVar.o()) {
                bitSet.set(3);
            }
            if (aeVar.r()) {
                bitSet.set(4);
            }
            if (aeVar.u()) {
                bitSet.set(5);
            }
            if (aeVar.x()) {
                bitSet.set(6);
            }
            if (aeVar.A()) {
                bitSet.set(7);
            }
            if (aeVar.D()) {
                bitSet.set(8);
            }
            if (aeVar.G()) {
                bitSet.set(9);
            }
            bvVar.a(bitSet, 10);
            if (aeVar.e()) {
                bvVar.a(aeVar.a);
            }
            if (aeVar.i()) {
                bvVar.a(aeVar.b);
            }
            if (aeVar.l()) {
                bvVar.a(aeVar.c);
            }
            if (aeVar.o()) {
                bvVar.a(aeVar.d);
            }
            if (aeVar.r()) {
                bvVar.a(aeVar.e);
            }
            if (aeVar.u()) {
                bvVar.a(aeVar.f);
            }
            if (aeVar.x()) {
                bvVar.a(aeVar.g);
            }
            if (aeVar.A()) {
                bvVar.a(aeVar.h);
            }
            if (aeVar.D()) {
                bvVar.a(aeVar.i.a());
            }
            if (aeVar.G()) {
                bvVar.a(aeVar.j);
            }
        }

        public void b(bo boVar, ae aeVar) throws az {
            bv bvVar = (bv) boVar;
            BitSet b = bvVar.b(10);
            if (b.get(0)) {
                aeVar.a = bvVar.s();
                aeVar.a(true);
            }
            if (b.get(1)) {
                aeVar.b = bvVar.v();
                aeVar.b(true);
            }
            if (b.get(2)) {
                aeVar.c = bvVar.v();
                aeVar.c(true);
            }
            if (b.get(3)) {
                aeVar.d = bvVar.u();
                aeVar.d(true);
            }
            if (b.get(4)) {
                aeVar.e = bvVar.u();
                aeVar.e(true);
            }
            if (b.get(5)) {
                aeVar.f = bvVar.v();
                aeVar.f(true);
            }
            if (b.get(6)) {
                aeVar.g = bvVar.s();
                aeVar.g(true);
            }
            if (b.get(7)) {
                aeVar.h = bvVar.v();
                aeVar.h(true);
            }
            if (b.get(8)) {
                aeVar.i = l.a(bvVar.s());
                aeVar.i(true);
            }
            if (b.get(9)) {
                aeVar.j = bvVar.v();
                aeVar.j(true);
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
        TIME_ZONE((short) 1, "time_zone"),
        LANGUAGE((short) 2, "language"),
        COUNTRY((short) 3, "country"),
        LATITUDE((short) 4, "latitude"),
        LONGITUDE((short) 5, "longitude"),
        CARRIER((short) 6, "carrier"),
        LATENCY((short) 7, "latency"),
        DISPLAY_NAME((short) 8, "display_name"),
        ACCESS_TYPE((short) 9, "access_type"),
        ACCESS_SUBTYPE((short) 10, "access_subtype");
        
        private static final Map<String, e> k = null;
        private final short l;
        private final String m;

        static {
            k = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return TIME_ZONE;
                case 2:
                    return LANGUAGE;
                case 3:
                    return COUNTRY;
                case 4:
                    return LATITUDE;
                case 5:
                    return LONGITUDE;
                case 6:
                    return CARRIER;
                case 7:
                    return LATENCY;
                case 8:
                    return DISPLAY_NAME;
                case 9:
                    return ACCESS_TYPE;
                case 10:
                    return ACCESS_SUBTYPE;
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
            return (e) k.get(str);
        }

        private e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public short a() {
            return this.l;
        }

        public String b() {
            return this.m;
        }
    }

    public /* synthetic */ ba b(int i) {
        return d(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        w.put(by.class, new b());
        w.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.TIME_ZONE, new be("time_zone", (byte) 2, new bf((byte) 8)));
        enumMap.put(e.LANGUAGE, new be("language", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.COUNTRY, new be("country", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.LATITUDE, new be("latitude", (byte) 2, new bf((byte) 4)));
        enumMap.put(e.LONGITUDE, new be("longitude", (byte) 2, new bf((byte) 4)));
        enumMap.put(e.CARRIER, new be("carrier", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.LATENCY, new be("latency", (byte) 2, new bf((byte) 8)));
        enumMap.put(e.DISPLAY_NAME, new be("display_name", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.ACCESS_TYPE, new be("access_type", (byte) 2, new bd(ReplyCode.reply0x10, l.class)));
        enumMap.put(e.ACCESS_SUBTYPE, new be("access_subtype", (byte) 2, new bf(ReplyCode.reply0xb)));
        k = Collections.unmodifiableMap(enumMap);
        be.a(ae.class, k);
    }

    public ae() {
        this.B = (byte) 0;
        this.C = new e[]{e.TIME_ZONE, e.LANGUAGE, e.COUNTRY, e.LATITUDE, e.LONGITUDE, e.CARRIER, e.LATENCY, e.DISPLAY_NAME, e.ACCESS_TYPE, e.ACCESS_SUBTYPE};
    }

    public ae(ae aeVar) {
        this.B = (byte) 0;
        this.C = new e[]{e.TIME_ZONE, e.LANGUAGE, e.COUNTRY, e.LATITUDE, e.LONGITUDE, e.CARRIER, e.LATENCY, e.DISPLAY_NAME, e.ACCESS_TYPE, e.ACCESS_SUBTYPE};
        this.B = aeVar.B;
        this.a = aeVar.a;
        if (aeVar.i()) {
            this.b = aeVar.b;
        }
        if (aeVar.l()) {
            this.c = aeVar.c;
        }
        this.d = aeVar.d;
        this.e = aeVar.e;
        if (aeVar.u()) {
            this.f = aeVar.f;
        }
        this.g = aeVar.g;
        if (aeVar.A()) {
            this.h = aeVar.h;
        }
        if (aeVar.D()) {
            this.i = aeVar.i;
        }
        if (aeVar.G()) {
            this.j = aeVar.j;
        }
    }

    public ae a() {
        return new ae(this);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
        d(false);
        this.d = JDMaInterface.PV_UPPERLIMIT;
        e(false);
        this.e = JDMaInterface.PV_UPPERLIMIT;
        this.f = null;
        g(false);
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public int c() {
        return this.a;
    }

    public ae a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void d() {
        this.B = at.b(this.B, 0);
    }

    public boolean e() {
        return at.a(this.B, 0);
    }

    public void a(boolean z) {
        this.B = at.a(this.B, 0, z);
    }

    public String f() {
        return this.b;
    }

    public ae a(String str) {
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

    public String j() {
        return this.c;
    }

    public ae b(String str) {
        this.c = str;
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

    public double m() {
        return this.d;
    }

    public ae a(double d) {
        this.d = d;
        d(true);
        return this;
    }

    public void n() {
        this.B = at.b(this.B, 1);
    }

    public boolean o() {
        return at.a(this.B, 1);
    }

    public void d(boolean z) {
        this.B = at.a(this.B, 1, z);
    }

    public double p() {
        return this.e;
    }

    public ae b(double d) {
        this.e = d;
        e(true);
        return this;
    }

    public void q() {
        this.B = at.b(this.B, 2);
    }

    public boolean r() {
        return at.a(this.B, 2);
    }

    public void e(boolean z) {
        this.B = at.a(this.B, 2, z);
    }

    public String s() {
        return this.f;
    }

    public ae c(String str) {
        this.f = str;
        return this;
    }

    public void t() {
        this.f = null;
    }

    public boolean u() {
        return this.f != null;
    }

    public void f(boolean z) {
        if (!z) {
            this.f = null;
        }
    }

    public int v() {
        return this.g;
    }

    public ae c(int i) {
        this.g = i;
        g(true);
        return this;
    }

    public void w() {
        this.B = at.b(this.B, 3);
    }

    public boolean x() {
        return at.a(this.B, 3);
    }

    public void g(boolean z) {
        this.B = at.a(this.B, 3, z);
    }

    public String y() {
        return this.h;
    }

    public ae d(String str) {
        this.h = str;
        return this;
    }

    public void z() {
        this.h = null;
    }

    public boolean A() {
        return this.h != null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public l B() {
        return this.i;
    }

    public ae a(l lVar) {
        this.i = lVar;
        return this;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public String E() {
        return this.j;
    }

    public ae e(String str) {
        this.j = str;
        return this;
    }

    public void F() {
        this.j = null;
    }

    public boolean G() {
        return this.j != null;
    }

    public void j(boolean z) {
        if (!z) {
            this.j = null;
        }
    }

    public e d(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) w.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) w.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("MiscInfo(");
        Object obj2 = 1;
        if (e()) {
            stringBuilder.append("time_zone:");
            stringBuilder.append(this.a);
            obj2 = null;
        }
        if (i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("language:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj2 = null;
        }
        if (l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("country:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
            obj2 = null;
        }
        if (o()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latitude:");
            stringBuilder.append(this.d);
            obj2 = null;
        }
        if (r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("longitude:");
            stringBuilder.append(this.e);
            obj2 = null;
        }
        if (u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("carrier:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
            obj2 = null;
        }
        if (x()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latency:");
            stringBuilder.append(this.g);
            obj2 = null;
        }
        if (A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("display_name:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
            obj2 = null;
        }
        if (D()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_type:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        } else {
            obj = obj2;
        }
        if (G()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_subtype:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void H() throws az {
    }
}
