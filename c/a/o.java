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
public class o implements av<o, e>, Serializable, Cloneable {
    public static final Map<e, be> l;
    private static final bu m = new bu("AppInfo");
    private static final bl n = new bl("key", ReplyCode.reply0xb, (short) 1);
    private static final bl o = new bl("version", ReplyCode.reply0xb, (short) 2);
    private static final bl p = new bl("version_index", (byte) 8, (short) 3);
    private static final bl q = new bl("package_name", ReplyCode.reply0xb, (short) 4);
    private static final bl r = new bl("sdk_type", (byte) 8, (short) 5);
    private static final bl s = new bl("sdk_version", ReplyCode.reply0xb, (short) 6);
    private static final bl t = new bl("channel", ReplyCode.reply0xb, (short) 7);
    private static final bl u = new bl("wrapper_type", ReplyCode.reply0xb, (short) 8);
    private static final bl v = new bl("wrapper_version", ReplyCode.reply0xb, (short) 9);
    private static final bl w = new bl("vertical_type", (byte) 8, (short) 10);
    private static final bl x = new bl("app_signature", ReplyCode.reply0xb, (short) 11);
    private static final Map<Class<? extends bw>, bx> y = new HashMap();
    private byte B;
    private e[] C;
    public String a;
    public String b;
    public int c;
    public String d;
    public aj e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;

    /* compiled from: TbsSdkJava */
    private static class a extends by<o> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (o) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (o) avVar);
        }

        public void a(bo boVar, o oVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    oVar.K();
                    return;
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.a = boVar.v();
                        oVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.b = boVar.v();
                        oVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.c = boVar.s();
                        oVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.d = boVar.v();
                        oVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.e = aj.a(boVar.s());
                        oVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.f = boVar.v();
                        oVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.g = boVar.v();
                        oVar.g(true);
                        break;
                    case (short) 8:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.h = boVar.v();
                        oVar.h(true);
                        break;
                    case (short) 9:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.i = boVar.v();
                        oVar.i(true);
                        break;
                    case (short) 10:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.j = boVar.s();
                        oVar.j(true);
                        break;
                    case (short) 11:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        oVar.k = boVar.v();
                        oVar.k(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, o oVar) throws az {
            oVar.K();
            boVar.a(o.m);
            if (oVar.a != null) {
                boVar.a(o.n);
                boVar.a(oVar.a);
                boVar.b();
            }
            if (oVar.b != null && oVar.i()) {
                boVar.a(o.o);
                boVar.a(oVar.b);
                boVar.b();
            }
            if (oVar.l()) {
                boVar.a(o.p);
                boVar.a(oVar.c);
                boVar.b();
            }
            if (oVar.d != null && oVar.o()) {
                boVar.a(o.q);
                boVar.a(oVar.d);
                boVar.b();
            }
            if (oVar.e != null) {
                boVar.a(o.r);
                boVar.a(oVar.e.a());
                boVar.b();
            }
            if (oVar.f != null) {
                boVar.a(o.s);
                boVar.a(oVar.f);
                boVar.b();
            }
            if (oVar.g != null) {
                boVar.a(o.t);
                boVar.a(oVar.g);
                boVar.b();
            }
            if (oVar.h != null && oVar.A()) {
                boVar.a(o.u);
                boVar.a(oVar.h);
                boVar.b();
            }
            if (oVar.i != null && oVar.D()) {
                boVar.a(o.v);
                boVar.a(oVar.i);
                boVar.b();
            }
            if (oVar.G()) {
                boVar.a(o.w);
                boVar.a(oVar.j);
                boVar.b();
            }
            if (oVar.k != null && oVar.J()) {
                boVar.a(o.x);
                boVar.a(oVar.k);
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
    private static class c extends bz<o> {
        private c() {
        }

        public void a(bo boVar, o oVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(oVar.a);
            bvVar.a(oVar.e.a());
            bvVar.a(oVar.f);
            bvVar.a(oVar.g);
            BitSet bitSet = new BitSet();
            if (oVar.i()) {
                bitSet.set(0);
            }
            if (oVar.l()) {
                bitSet.set(1);
            }
            if (oVar.o()) {
                bitSet.set(2);
            }
            if (oVar.A()) {
                bitSet.set(3);
            }
            if (oVar.D()) {
                bitSet.set(4);
            }
            if (oVar.G()) {
                bitSet.set(5);
            }
            if (oVar.J()) {
                bitSet.set(6);
            }
            bvVar.a(bitSet, 7);
            if (oVar.i()) {
                bvVar.a(oVar.b);
            }
            if (oVar.l()) {
                bvVar.a(oVar.c);
            }
            if (oVar.o()) {
                bvVar.a(oVar.d);
            }
            if (oVar.A()) {
                bvVar.a(oVar.h);
            }
            if (oVar.D()) {
                bvVar.a(oVar.i);
            }
            if (oVar.G()) {
                bvVar.a(oVar.j);
            }
            if (oVar.J()) {
                bvVar.a(oVar.k);
            }
        }

        public void b(bo boVar, o oVar) throws az {
            bv bvVar = (bv) boVar;
            oVar.a = bvVar.v();
            oVar.a(true);
            oVar.e = aj.a(bvVar.s());
            oVar.e(true);
            oVar.f = bvVar.v();
            oVar.f(true);
            oVar.g = bvVar.v();
            oVar.g(true);
            BitSet b = bvVar.b(7);
            if (b.get(0)) {
                oVar.b = bvVar.v();
                oVar.b(true);
            }
            if (b.get(1)) {
                oVar.c = bvVar.s();
                oVar.c(true);
            }
            if (b.get(2)) {
                oVar.d = bvVar.v();
                oVar.d(true);
            }
            if (b.get(3)) {
                oVar.h = bvVar.v();
                oVar.h(true);
            }
            if (b.get(4)) {
                oVar.i = bvVar.v();
                oVar.i(true);
            }
            if (b.get(5)) {
                oVar.j = bvVar.s();
                oVar.j(true);
            }
            if (b.get(6)) {
                oVar.k = bvVar.v();
                oVar.k(true);
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
        KEY((short) 1, "key"),
        VERSION((short) 2, "version"),
        VERSION_INDEX((short) 3, "version_index"),
        PACKAGE_NAME((short) 4, "package_name"),
        SDK_TYPE((short) 5, "sdk_type"),
        SDK_VERSION((short) 6, "sdk_version"),
        CHANNEL((short) 7, "channel"),
        WRAPPER_TYPE((short) 8, "wrapper_type"),
        WRAPPER_VERSION((short) 9, "wrapper_version"),
        VERTICAL_TYPE((short) 10, "vertical_type"),
        APP_SIGNATURE((short) 11, "app_signature");
        
        private static final Map<String, e> l = null;
        private final short m;
        private final String n;

        static {
            l = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                l.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return KEY;
                case 2:
                    return VERSION;
                case 3:
                    return VERSION_INDEX;
                case 4:
                    return PACKAGE_NAME;
                case 5:
                    return SDK_TYPE;
                case 6:
                    return SDK_VERSION;
                case 7:
                    return CHANNEL;
                case 8:
                    return WRAPPER_TYPE;
                case 9:
                    return WRAPPER_VERSION;
                case 10:
                    return VERTICAL_TYPE;
                case 11:
                    return APP_SIGNATURE;
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
            return (e) l.get(str);
        }

        private e(short s, String str) {
            this.m = s;
            this.n = str;
        }

        public short a() {
            return this.m;
        }

        public String b() {
            return this.n;
        }
    }

    public /* synthetic */ ba b(int i) {
        return d(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        y.put(by.class, new b());
        y.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.KEY, new be("key", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.VERSION, new be("version", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.VERSION_INDEX, new be("version_index", (byte) 2, new bf((byte) 8)));
        enumMap.put(e.PACKAGE_NAME, new be("package_name", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.SDK_TYPE, new be("sdk_type", (byte) 1, new bd(ReplyCode.reply0x10, aj.class)));
        enumMap.put(e.SDK_VERSION, new be("sdk_version", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.CHANNEL, new be("channel", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.WRAPPER_TYPE, new be("wrapper_type", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.WRAPPER_VERSION, new be("wrapper_version", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.VERTICAL_TYPE, new be("vertical_type", (byte) 2, new bf((byte) 8)));
        enumMap.put(e.APP_SIGNATURE, new be("app_signature", (byte) 2, new bf(ReplyCode.reply0xb)));
        l = Collections.unmodifiableMap(enumMap);
        be.a(o.class, l);
    }

    public o() {
        this.B = (byte) 0;
        this.C = new e[]{e.VERSION, e.VERSION_INDEX, e.PACKAGE_NAME, e.WRAPPER_TYPE, e.WRAPPER_VERSION, e.VERTICAL_TYPE, e.APP_SIGNATURE};
    }

    public o(String str, aj ajVar, String str2, String str3) {
        this();
        this.a = str;
        this.e = ajVar;
        this.f = str2;
        this.g = str3;
    }

    public o(o oVar) {
        this.B = (byte) 0;
        this.C = new e[]{e.VERSION, e.VERSION_INDEX, e.PACKAGE_NAME, e.WRAPPER_TYPE, e.WRAPPER_VERSION, e.VERTICAL_TYPE, e.APP_SIGNATURE};
        this.B = oVar.B;
        if (oVar.e()) {
            this.a = oVar.a;
        }
        if (oVar.i()) {
            this.b = oVar.b;
        }
        this.c = oVar.c;
        if (oVar.o()) {
            this.d = oVar.d;
        }
        if (oVar.r()) {
            this.e = oVar.e;
        }
        if (oVar.u()) {
            this.f = oVar.f;
        }
        if (oVar.x()) {
            this.g = oVar.g;
        }
        if (oVar.A()) {
            this.h = oVar.h;
        }
        if (oVar.D()) {
            this.i = oVar.i;
        }
        this.j = oVar.j;
        if (oVar.J()) {
            this.k = oVar.k;
        }
    }

    public o a() {
        return new o(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        c(false);
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
        this.k = null;
    }

    public String c() {
        return this.a;
    }

    public o a(String str) {
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

    public String f() {
        return this.b;
    }

    public o b(String str) {
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

    public int j() {
        return this.c;
    }

    public o a(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public void k() {
        this.B = at.b(this.B, 0);
    }

    public boolean l() {
        return at.a(this.B, 0);
    }

    public void c(boolean z) {
        this.B = at.a(this.B, 0, z);
    }

    public String m() {
        return this.d;
    }

    public o c(String str) {
        this.d = str;
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

    public aj p() {
        return this.e;
    }

    public o a(aj ajVar) {
        this.e = ajVar;
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

    public String s() {
        return this.f;
    }

    public o d(String str) {
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

    public String v() {
        return this.g;
    }

    public o e(String str) {
        this.g = str;
        return this;
    }

    public void w() {
        this.g = null;
    }

    public boolean x() {
        return this.g != null;
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public String y() {
        return this.h;
    }

    public o f(String str) {
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

    public String B() {
        return this.i;
    }

    public o g(String str) {
        this.i = str;
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

    public int E() {
        return this.j;
    }

    public o c(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public void F() {
        this.B = at.b(this.B, 1);
    }

    public boolean G() {
        return at.a(this.B, 1);
    }

    public void j(boolean z) {
        this.B = at.a(this.B, 1, z);
    }

    public String H() {
        return this.k;
    }

    public o h(String str) {
        this.k = str;
        return this;
    }

    public void I() {
        this.k = null;
    }

    public boolean J() {
        return this.k != null;
    }

    public void k(boolean z) {
        if (!z) {
            this.k = null;
        }
    }

    public e d(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) y.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) y.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppInfo(");
        stringBuilder.append("key:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("version:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("version_index:");
            stringBuilder.append(this.c);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("package_name:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_type:");
        if (this.e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.e);
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_version:");
        if (this.f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f);
        }
        stringBuilder.append(", ");
        stringBuilder.append("channel:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        if (A()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_type:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (D()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_version:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (G()) {
            stringBuilder.append(", ");
            stringBuilder.append("vertical_type:");
            stringBuilder.append(this.j);
        }
        if (J()) {
            stringBuilder.append(", ");
            stringBuilder.append("app_signature:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void K() throws az {
        if (this.a == null) {
            throw new bp("Required field 'key' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new bp("Required field 'sdk_type' was not present! Struct: " + toString());
        } else if (this.f == null) {
            throw new bp("Required field 'sdk_version' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new bp("Required field 'channel' was not present! Struct: " + toString());
        }
    }
}
