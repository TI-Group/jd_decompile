package c.a;

import com.jingdong.jdma.JDMaInterface;
import com.tencent.stat.DeviceInfo;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* compiled from: TbsSdkJava */
public class ad implements av<ad, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu(HttpHeaders.LOCATION);
    private static final bl f = new bl("lat", (byte) 4, (short) 1);
    private static final bl g = new bl("lng", (byte) 4, (short) 2);
    private static final bl h = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public double a;
    public double b;
    public long c;
    private byte m;

    /* compiled from: TbsSdkJava */
    private static class a extends by<ad> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (ad) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (ad) avVar);
        }

        public void a(bo boVar, ad adVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!adVar.e()) {
                        throw new bp("Required field 'lat' was not found in serialized data! Struct: " + toString());
                    } else if (!adVar.i()) {
                        throw new bp("Required field 'lng' was not found in serialized data! Struct: " + toString());
                    } else if (adVar.l()) {
                        adVar.m();
                        return;
                    } else {
                        throw new bp("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 4) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        adVar.a = boVar.u();
                        adVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 4) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        adVar.b = boVar.u();
                        adVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        adVar.c = boVar.t();
                        adVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, ad adVar) throws az {
            adVar.m();
            boVar.a(ad.e);
            boVar.a(ad.f);
            boVar.a(adVar.a);
            boVar.b();
            boVar.a(ad.g);
            boVar.a(adVar.b);
            boVar.b();
            boVar.a(ad.h);
            boVar.a(adVar.c);
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
    private static class c extends bz<ad> {
        private c() {
        }

        public void a(bo boVar, ad adVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(adVar.a);
            bvVar.a(adVar.b);
            bvVar.a(adVar.c);
        }

        public void b(bo boVar, ad adVar) throws az {
            bv bvVar = (bv) boVar;
            adVar.a = bvVar.u();
            adVar.a(true);
            adVar.b = bvVar.u();
            adVar.b(true);
            adVar.c = bvVar.t();
            adVar.c(true);
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
        LAT((short) 1, "lat"),
        LNG((short) 2, "lng"),
        TS((short) 3, DeviceInfo.TAG_TIMESTAMPS);
        
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
                    return LAT;
                case 2:
                    return LNG;
                case 3:
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
        enumMap.put(e.LAT, new be("lat", (byte) 1, new bf((byte) 4)));
        enumMap.put(e.LNG, new be("lng", (byte) 1, new bf((byte) 4)));
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(ad.class, d);
    }

    public ad() {
        this.m = (byte) 0;
    }

    public ad(double d, double d2, long j) {
        this();
        this.a = d;
        a(true);
        this.b = d2;
        b(true);
        this.c = j;
        c(true);
    }

    public ad(ad adVar) {
        this.m = (byte) 0;
        this.m = adVar.m;
        this.a = adVar.a;
        this.b = adVar.b;
        this.c = adVar.c;
    }

    public ad a() {
        return new ad(this);
    }

    public void b() {
        a(false);
        this.a = JDMaInterface.PV_UPPERLIMIT;
        b(false);
        this.b = JDMaInterface.PV_UPPERLIMIT;
        c(false);
        this.c = 0;
    }

    public double c() {
        return this.a;
    }

    public ad a(double d) {
        this.a = d;
        a(true);
        return this;
    }

    public void d() {
        this.m = at.b(this.m, 0);
    }

    public boolean e() {
        return at.a(this.m, 0);
    }

    public void a(boolean z) {
        this.m = at.a(this.m, 0, z);
    }

    public double f() {
        return this.b;
    }

    public ad b(double d) {
        this.b = d;
        b(true);
        return this;
    }

    public void h() {
        this.m = at.b(this.m, 1);
    }

    public boolean i() {
        return at.a(this.m, 1);
    }

    public void b(boolean z) {
        this.m = at.a(this.m, 1, z);
    }

    public long j() {
        return this.c;
    }

    public ad a(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public void k() {
        this.m = at.b(this.m, 2);
    }

    public boolean l() {
        return at.a(this.m, 2);
    }

    public void c(boolean z) {
        this.m = at.a(this.m, 2, z);
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
        StringBuilder stringBuilder = new StringBuilder("Location(");
        stringBuilder.append("lat:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("lng:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
    }
}
