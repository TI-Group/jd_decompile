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
public class r implements av<r, e>, Serializable, Cloneable {
    private static final bl A = new bl("os", ReplyCode.reply0xb, (short) 7);
    private static final bl B = new bl("os_version", ReplyCode.reply0xb, (short) 8);
    private static final bl C = new bl("resolution", ReplyCode.reply0xc, (short) 9);
    private static final bl D = new bl("is_jailbroken", (byte) 2, (short) 10);
    private static final bl E = new bl("is_pirated", (byte) 2, (short) 11);
    private static final bl F = new bl("device_board", ReplyCode.reply0xb, (short) 12);
    private static final bl G = new bl("device_brand", ReplyCode.reply0xb, (short) 13);
    private static final bl H = new bl("device_manutime", (byte) 10, (short) 14);
    private static final bl I = new bl("device_manufacturer", ReplyCode.reply0xb, (short) 15);
    private static final bl J = new bl("device_manuid", ReplyCode.reply0xb, (short) 16);
    private static final bl K = new bl("device_name", ReplyCode.reply0xb, (short) 17);
    private static final bl L = new bl("wp_device", ReplyCode.reply0xb, (short) 18);
    private static final Map<Class<? extends bw>, bx> M = new HashMap();
    public static final Map<e, be> s;
    private static final bu t = new bu("DeviceInfo");
    private static final bl u = new bl("device_id", ReplyCode.reply0xb, (short) 1);
    private static final bl v = new bl("idmd5", ReplyCode.reply0xb, (short) 2);
    private static final bl w = new bl("mac_address", ReplyCode.reply0xb, (short) 3);
    private static final bl x = new bl("open_udid", ReplyCode.reply0xb, (short) 4);
    private static final bl y = new bl("model", ReplyCode.reply0xb, (short) 5);
    private static final bl z = new bl("cpu", ReplyCode.reply0xb, (short) 6);
    private byte Q;
    private e[] R;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public ah i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;
    public String o;
    public String p;
    public String q;
    public String r;

    /* compiled from: TbsSdkJava */
    private static class a extends by<r> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (r) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (r) avVar);
        }

        public void a(bo boVar, r rVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    rVar.af();
                    return;
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.a = boVar.v();
                        rVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.b = boVar.v();
                        rVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.c = boVar.v();
                        rVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.d = boVar.v();
                        rVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.e = boVar.v();
                        rVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.f = boVar.v();
                        rVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.g = boVar.v();
                        rVar.g(true);
                        break;
                    case (short) 8:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.h = boVar.v();
                        rVar.h(true);
                        break;
                    case (short) 9:
                        if (h.b != ReplyCode.reply0xc) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.i = new ah();
                        rVar.i.a(boVar);
                        rVar.i(true);
                        break;
                    case (short) 10:
                        if (h.b != (byte) 2) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.j = boVar.p();
                        rVar.k(true);
                        break;
                    case (short) 11:
                        if (h.b != (byte) 2) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.k = boVar.p();
                        rVar.m(true);
                        break;
                    case (short) 12:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.l = boVar.v();
                        rVar.n(true);
                        break;
                    case (short) 13:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.m = boVar.v();
                        rVar.o(true);
                        break;
                    case (short) 14:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.n = boVar.t();
                        rVar.p(true);
                        break;
                    case (short) 15:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.o = boVar.v();
                        rVar.q(true);
                        break;
                    case (short) 16:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.p = boVar.v();
                        rVar.r(true);
                        break;
                    case (short) 17:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.q = boVar.v();
                        rVar.s(true);
                        break;
                    case (short) 18:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        rVar.r = boVar.v();
                        rVar.t(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, r rVar) throws az {
            rVar.af();
            boVar.a(r.t);
            if (rVar.a != null && rVar.e()) {
                boVar.a(r.u);
                boVar.a(rVar.a);
                boVar.b();
            }
            if (rVar.b != null && rVar.i()) {
                boVar.a(r.v);
                boVar.a(rVar.b);
                boVar.b();
            }
            if (rVar.c != null && rVar.l()) {
                boVar.a(r.w);
                boVar.a(rVar.c);
                boVar.b();
            }
            if (rVar.d != null && rVar.o()) {
                boVar.a(r.x);
                boVar.a(rVar.d);
                boVar.b();
            }
            if (rVar.e != null && rVar.r()) {
                boVar.a(r.y);
                boVar.a(rVar.e);
                boVar.b();
            }
            if (rVar.f != null && rVar.u()) {
                boVar.a(r.z);
                boVar.a(rVar.f);
                boVar.b();
            }
            if (rVar.g != null && rVar.x()) {
                boVar.a(r.A);
                boVar.a(rVar.g);
                boVar.b();
            }
            if (rVar.h != null && rVar.A()) {
                boVar.a(r.B);
                boVar.a(rVar.h);
                boVar.b();
            }
            if (rVar.i != null && rVar.D()) {
                boVar.a(r.C);
                rVar.i.b(boVar);
                boVar.b();
            }
            if (rVar.G()) {
                boVar.a(r.D);
                boVar.a(rVar.j);
                boVar.b();
            }
            if (rVar.J()) {
                boVar.a(r.E);
                boVar.a(rVar.k);
                boVar.b();
            }
            if (rVar.l != null && rVar.M()) {
                boVar.a(r.F);
                boVar.a(rVar.l);
                boVar.b();
            }
            if (rVar.m != null && rVar.P()) {
                boVar.a(r.G);
                boVar.a(rVar.m);
                boVar.b();
            }
            if (rVar.S()) {
                boVar.a(r.H);
                boVar.a(rVar.n);
                boVar.b();
            }
            if (rVar.o != null && rVar.V()) {
                boVar.a(r.I);
                boVar.a(rVar.o);
                boVar.b();
            }
            if (rVar.p != null && rVar.Y()) {
                boVar.a(r.J);
                boVar.a(rVar.p);
                boVar.b();
            }
            if (rVar.q != null && rVar.ab()) {
                boVar.a(r.K);
                boVar.a(rVar.q);
                boVar.b();
            }
            if (rVar.r != null && rVar.ae()) {
                boVar.a(r.L);
                boVar.a(rVar.r);
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
    private static class c extends bz<r> {
        private c() {
        }

        public void a(bo boVar, r rVar) throws az {
            boVar = (bv) boVar;
            BitSet bitSet = new BitSet();
            if (rVar.e()) {
                bitSet.set(0);
            }
            if (rVar.i()) {
                bitSet.set(1);
            }
            if (rVar.l()) {
                bitSet.set(2);
            }
            if (rVar.o()) {
                bitSet.set(3);
            }
            if (rVar.r()) {
                bitSet.set(4);
            }
            if (rVar.u()) {
                bitSet.set(5);
            }
            if (rVar.x()) {
                bitSet.set(6);
            }
            if (rVar.A()) {
                bitSet.set(7);
            }
            if (rVar.D()) {
                bitSet.set(8);
            }
            if (rVar.G()) {
                bitSet.set(9);
            }
            if (rVar.J()) {
                bitSet.set(10);
            }
            if (rVar.M()) {
                bitSet.set(11);
            }
            if (rVar.P()) {
                bitSet.set(12);
            }
            if (rVar.S()) {
                bitSet.set(13);
            }
            if (rVar.V()) {
                bitSet.set(14);
            }
            if (rVar.Y()) {
                bitSet.set(15);
            }
            if (rVar.ab()) {
                bitSet.set(16);
            }
            if (rVar.ae()) {
                bitSet.set(17);
            }
            boVar.a(bitSet, 18);
            if (rVar.e()) {
                boVar.a(rVar.a);
            }
            if (rVar.i()) {
                boVar.a(rVar.b);
            }
            if (rVar.l()) {
                boVar.a(rVar.c);
            }
            if (rVar.o()) {
                boVar.a(rVar.d);
            }
            if (rVar.r()) {
                boVar.a(rVar.e);
            }
            if (rVar.u()) {
                boVar.a(rVar.f);
            }
            if (rVar.x()) {
                boVar.a(rVar.g);
            }
            if (rVar.A()) {
                boVar.a(rVar.h);
            }
            if (rVar.D()) {
                rVar.i.b(boVar);
            }
            if (rVar.G()) {
                boVar.a(rVar.j);
            }
            if (rVar.J()) {
                boVar.a(rVar.k);
            }
            if (rVar.M()) {
                boVar.a(rVar.l);
            }
            if (rVar.P()) {
                boVar.a(rVar.m);
            }
            if (rVar.S()) {
                boVar.a(rVar.n);
            }
            if (rVar.V()) {
                boVar.a(rVar.o);
            }
            if (rVar.Y()) {
                boVar.a(rVar.p);
            }
            if (rVar.ab()) {
                boVar.a(rVar.q);
            }
            if (rVar.ae()) {
                boVar.a(rVar.r);
            }
        }

        public void b(bo boVar, r rVar) throws az {
            boVar = (bv) boVar;
            BitSet b = boVar.b(18);
            if (b.get(0)) {
                rVar.a = boVar.v();
                rVar.a(true);
            }
            if (b.get(1)) {
                rVar.b = boVar.v();
                rVar.b(true);
            }
            if (b.get(2)) {
                rVar.c = boVar.v();
                rVar.c(true);
            }
            if (b.get(3)) {
                rVar.d = boVar.v();
                rVar.d(true);
            }
            if (b.get(4)) {
                rVar.e = boVar.v();
                rVar.e(true);
            }
            if (b.get(5)) {
                rVar.f = boVar.v();
                rVar.f(true);
            }
            if (b.get(6)) {
                rVar.g = boVar.v();
                rVar.g(true);
            }
            if (b.get(7)) {
                rVar.h = boVar.v();
                rVar.h(true);
            }
            if (b.get(8)) {
                rVar.i = new ah();
                rVar.i.a(boVar);
                rVar.i(true);
            }
            if (b.get(9)) {
                rVar.j = boVar.p();
                rVar.k(true);
            }
            if (b.get(10)) {
                rVar.k = boVar.p();
                rVar.m(true);
            }
            if (b.get(11)) {
                rVar.l = boVar.v();
                rVar.n(true);
            }
            if (b.get(12)) {
                rVar.m = boVar.v();
                rVar.o(true);
            }
            if (b.get(13)) {
                rVar.n = boVar.t();
                rVar.p(true);
            }
            if (b.get(14)) {
                rVar.o = boVar.v();
                rVar.q(true);
            }
            if (b.get(15)) {
                rVar.p = boVar.v();
                rVar.r(true);
            }
            if (b.get(16)) {
                rVar.q = boVar.v();
                rVar.s(true);
            }
            if (b.get(17)) {
                rVar.r = boVar.v();
                rVar.t(true);
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
        DEVICE_ID((short) 1, "device_id"),
        IDMD5((short) 2, "idmd5"),
        MAC_ADDRESS((short) 3, "mac_address"),
        OPEN_UDID((short) 4, "open_udid"),
        MODEL((short) 5, "model"),
        CPU((short) 6, "cpu"),
        OS((short) 7, "os"),
        OS_VERSION((short) 8, "os_version"),
        RESOLUTION((short) 9, "resolution"),
        IS_JAILBROKEN((short) 10, "is_jailbroken"),
        IS_PIRATED((short) 11, "is_pirated"),
        DEVICE_BOARD((short) 12, "device_board"),
        DEVICE_BRAND((short) 13, "device_brand"),
        DEVICE_MANUTIME((short) 14, "device_manutime"),
        DEVICE_MANUFACTURER((short) 15, "device_manufacturer"),
        DEVICE_MANUID((short) 16, "device_manuid"),
        DEVICE_NAME((short) 17, "device_name"),
        WP_DEVICE((short) 18, "wp_device");
        
        private static final Map<String, e> s = null;
        private final short t;
        private final String u;

        static {
            s = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                s.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return DEVICE_ID;
                case 2:
                    return IDMD5;
                case 3:
                    return MAC_ADDRESS;
                case 4:
                    return OPEN_UDID;
                case 5:
                    return MODEL;
                case 6:
                    return CPU;
                case 7:
                    return OS;
                case 8:
                    return OS_VERSION;
                case 9:
                    return RESOLUTION;
                case 10:
                    return IS_JAILBROKEN;
                case 11:
                    return IS_PIRATED;
                case 12:
                    return DEVICE_BOARD;
                case 13:
                    return DEVICE_BRAND;
                case 14:
                    return DEVICE_MANUTIME;
                case 15:
                    return DEVICE_MANUFACTURER;
                case 16:
                    return DEVICE_MANUID;
                case 17:
                    return DEVICE_NAME;
                case 18:
                    return WP_DEVICE;
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
            return (e) s.get(str);
        }

        private e(short s, String str) {
            this.t = s;
            this.u = str;
        }

        public short a() {
            return this.t;
        }

        public String b() {
            return this.u;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        M.put(by.class, new b());
        M.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.DEVICE_ID, new be("device_id", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.IDMD5, new be("idmd5", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.MAC_ADDRESS, new be("mac_address", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.OPEN_UDID, new be("open_udid", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.MODEL, new be("model", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.CPU, new be("cpu", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.OS, new be("os", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.OS_VERSION, new be("os_version", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.RESOLUTION, new be("resolution", (byte) 2, new bi(ReplyCode.reply0xc, ah.class)));
        enumMap.put(e.IS_JAILBROKEN, new be("is_jailbroken", (byte) 2, new bf((byte) 2)));
        enumMap.put(e.IS_PIRATED, new be("is_pirated", (byte) 2, new bf((byte) 2)));
        enumMap.put(e.DEVICE_BOARD, new be("device_board", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.DEVICE_BRAND, new be("device_brand", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.DEVICE_MANUTIME, new be("device_manutime", (byte) 2, new bf((byte) 10)));
        enumMap.put(e.DEVICE_MANUFACTURER, new be("device_manufacturer", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.DEVICE_MANUID, new be("device_manuid", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.DEVICE_NAME, new be("device_name", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.WP_DEVICE, new be("wp_device", (byte) 2, new bf(ReplyCode.reply0xb)));
        s = Collections.unmodifiableMap(enumMap);
        be.a(r.class, s);
    }

    public r() {
        this.Q = (byte) 0;
        this.R = new e[]{e.DEVICE_ID, e.IDMD5, e.MAC_ADDRESS, e.OPEN_UDID, e.MODEL, e.CPU, e.OS, e.OS_VERSION, e.RESOLUTION, e.IS_JAILBROKEN, e.IS_PIRATED, e.DEVICE_BOARD, e.DEVICE_BRAND, e.DEVICE_MANUTIME, e.DEVICE_MANUFACTURER, e.DEVICE_MANUID, e.DEVICE_NAME, e.WP_DEVICE};
    }

    public r(r rVar) {
        this.Q = (byte) 0;
        this.R = new e[]{e.DEVICE_ID, e.IDMD5, e.MAC_ADDRESS, e.OPEN_UDID, e.MODEL, e.CPU, e.OS, e.OS_VERSION, e.RESOLUTION, e.IS_JAILBROKEN, e.IS_PIRATED, e.DEVICE_BOARD, e.DEVICE_BRAND, e.DEVICE_MANUTIME, e.DEVICE_MANUFACTURER, e.DEVICE_MANUID, e.DEVICE_NAME, e.WP_DEVICE};
        this.Q = rVar.Q;
        if (rVar.e()) {
            this.a = rVar.a;
        }
        if (rVar.i()) {
            this.b = rVar.b;
        }
        if (rVar.l()) {
            this.c = rVar.c;
        }
        if (rVar.o()) {
            this.d = rVar.d;
        }
        if (rVar.r()) {
            this.e = rVar.e;
        }
        if (rVar.u()) {
            this.f = rVar.f;
        }
        if (rVar.x()) {
            this.g = rVar.g;
        }
        if (rVar.A()) {
            this.h = rVar.h;
        }
        if (rVar.D()) {
            this.i = new ah(rVar.i);
        }
        this.j = rVar.j;
        this.k = rVar.k;
        if (rVar.M()) {
            this.l = rVar.l;
        }
        if (rVar.P()) {
            this.m = rVar.m;
        }
        this.n = rVar.n;
        if (rVar.V()) {
            this.o = rVar.o;
        }
        if (rVar.Y()) {
            this.p = rVar.p;
        }
        if (rVar.ab()) {
            this.q = rVar.q;
        }
        if (rVar.ae()) {
            this.r = rVar.r;
        }
    }

    public r a() {
        return new r(this);
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
        k(false);
        this.j = false;
        m(false);
        this.k = false;
        this.l = null;
        this.m = null;
        p(false);
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    public String c() {
        return this.a;
    }

    public r a(String str) {
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

    public r b(String str) {
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

    public r c(String str) {
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

    public String m() {
        return this.d;
    }

    public r d(String str) {
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

    public String p() {
        return this.e;
    }

    public r e(String str) {
        this.e = str;
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

    public r f(String str) {
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

    public r g(String str) {
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

    public r h(String str) {
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

    public ah B() {
        return this.i;
    }

    public r a(ah ahVar) {
        this.i = ahVar;
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

    public boolean E() {
        return this.j;
    }

    public r j(boolean z) {
        this.j = z;
        k(true);
        return this;
    }

    public void F() {
        this.Q = at.b(this.Q, 0);
    }

    public boolean G() {
        return at.a(this.Q, 0);
    }

    public void k(boolean z) {
        this.Q = at.a(this.Q, 0, z);
    }

    public boolean H() {
        return this.k;
    }

    public r l(boolean z) {
        this.k = z;
        m(true);
        return this;
    }

    public void I() {
        this.Q = at.b(this.Q, 1);
    }

    public boolean J() {
        return at.a(this.Q, 1);
    }

    public void m(boolean z) {
        this.Q = at.a(this.Q, 1, z);
    }

    public String K() {
        return this.l;
    }

    public r i(String str) {
        this.l = str;
        return this;
    }

    public void L() {
        this.l = null;
    }

    public boolean M() {
        return this.l != null;
    }

    public void n(boolean z) {
        if (!z) {
            this.l = null;
        }
    }

    public String N() {
        return this.m;
    }

    public r j(String str) {
        this.m = str;
        return this;
    }

    public void O() {
        this.m = null;
    }

    public boolean P() {
        return this.m != null;
    }

    public void o(boolean z) {
        if (!z) {
            this.m = null;
        }
    }

    public long Q() {
        return this.n;
    }

    public r a(long j) {
        this.n = j;
        p(true);
        return this;
    }

    public void R() {
        this.Q = at.b(this.Q, 2);
    }

    public boolean S() {
        return at.a(this.Q, 2);
    }

    public void p(boolean z) {
        this.Q = at.a(this.Q, 2, z);
    }

    public String T() {
        return this.o;
    }

    public r k(String str) {
        this.o = str;
        return this;
    }

    public void U() {
        this.o = null;
    }

    public boolean V() {
        return this.o != null;
    }

    public void q(boolean z) {
        if (!z) {
            this.o = null;
        }
    }

    public String W() {
        return this.p;
    }

    public r l(String str) {
        this.p = str;
        return this;
    }

    public void X() {
        this.p = null;
    }

    public boolean Y() {
        return this.p != null;
    }

    public void r(boolean z) {
        if (!z) {
            this.p = null;
        }
    }

    public String Z() {
        return this.q;
    }

    public r m(String str) {
        this.q = str;
        return this;
    }

    public void aa() {
        this.q = null;
    }

    public boolean ab() {
        return this.q != null;
    }

    public void s(boolean z) {
        if (!z) {
            this.q = null;
        }
    }

    public String ac() {
        return this.r;
    }

    public r n(String str) {
        this.r = str;
        return this;
    }

    public void ad() {
        this.r = null;
    }

    public boolean ae() {
        return this.r != null;
    }

    public void t(boolean z) {
        if (!z) {
            this.r = null;
        }
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) M.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) M.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("DeviceInfo(");
        Object obj2 = 1;
        if (e()) {
            stringBuilder.append("device_id:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj2 = null;
        }
        if (i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("idmd5:");
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
            stringBuilder.append("mac_address:");
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
            stringBuilder.append("open_udid:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
            obj2 = null;
        }
        if (r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("model:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
            obj2 = null;
        }
        if (u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("cpu:");
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
            stringBuilder.append("os:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
            obj2 = null;
        }
        if (A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("os_version:");
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
            stringBuilder.append("resolution:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
            obj2 = null;
        }
        if (G()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_jailbroken:");
            stringBuilder.append(this.j);
            obj2 = null;
        }
        if (J()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_pirated:");
            stringBuilder.append(this.k);
            obj2 = null;
        }
        if (M()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_board:");
            if (this.l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.l);
            }
            obj2 = null;
        }
        if (P()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_brand:");
            if (this.m == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.m);
            }
            obj2 = null;
        }
        if (S()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manutime:");
            stringBuilder.append(this.n);
            obj2 = null;
        }
        if (V()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manufacturer:");
            if (this.o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.o);
            }
            obj2 = null;
        }
        if (Y()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manuid:");
            if (this.p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.p);
            }
            obj2 = null;
        }
        if (ab()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_name:");
            if (this.q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.q);
            }
        } else {
            obj = obj2;
        }
        if (ae()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("wp_device:");
            if (this.r == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.r);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void af() throws az {
        if (this.i != null) {
            this.i.j();
        }
    }
}
