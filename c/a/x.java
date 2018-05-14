package c.a;

import com.tencent.stat.DeviceInfo;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class x implements av<x, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("IdSnapshot");
    private static final bl f = new bl(HTTP.IDENTITY_CODING, ReplyCode.reply0xb, (short) 1);
    private static final bl g = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 2);
    private static final bl h = new bl("version", (byte) 8, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public String a;
    public long b;
    public int c;
    private byte l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<x> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (x) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (x) avVar);
        }

        public void a(bo boVar, x xVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!xVar.i()) {
                        throw new bp("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    } else if (xVar.l()) {
                        xVar.m();
                        return;
                    } else {
                        throw new bp("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        xVar.a = boVar.v();
                        xVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        xVar.b = boVar.t();
                        xVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        xVar.c = boVar.s();
                        xVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, x xVar) throws az {
            xVar.m();
            boVar.a(x.e);
            if (xVar.a != null) {
                boVar.a(x.f);
                boVar.a(xVar.a);
                boVar.b();
            }
            boVar.a(x.g);
            boVar.a(xVar.b);
            boVar.b();
            boVar.a(x.h);
            boVar.a(xVar.c);
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
    private static class c extends bz<x> {
        private c() {
        }

        public void a(bo boVar, x xVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(xVar.a);
            bvVar.a(xVar.b);
            bvVar.a(xVar.c);
        }

        public void b(bo boVar, x xVar) throws az {
            bv bvVar = (bv) boVar;
            xVar.a = bvVar.v();
            xVar.a(true);
            xVar.b = bvVar.t();
            xVar.b(true);
            xVar.c = bvVar.s();
            xVar.c(true);
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
        IDENTITY((short) 1, HTTP.IDENTITY_CODING),
        TS((short) 2, DeviceInfo.TAG_TIMESTAMPS),
        VERSION((short) 3, "version");
        
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
                    return IDENTITY;
                case 2:
                    return TS;
                case 3:
                    return VERSION;
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
        return c(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        i.put(by.class, new b());
        i.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new be(HTTP.IDENTITY_CODING, (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        enumMap.put(e.VERSION, new be("version", (byte) 1, new bf((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(x.class, d);
    }

    public x() {
        this.l = (byte) 0;
    }

    public x(String str, long j, int i) {
        this();
        this.a = str;
        this.b = j;
        b(true);
        this.c = i;
        c(true);
    }

    public x(x xVar) {
        this.l = (byte) 0;
        this.l = xVar.l;
        if (xVar.e()) {
            this.a = xVar.a;
        }
        this.b = xVar.b;
        this.c = xVar.c;
    }

    public x a() {
        return new x(this);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = 0;
    }

    public String c() {
        return this.a;
    }

    public x a(String str) {
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

    public x a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public void h() {
        this.l = at.b(this.l, 0);
    }

    public boolean i() {
        return at.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = at.a(this.l, 0, z);
    }

    public int j() {
        return this.c;
    }

    public x a(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public void k() {
        this.l = at.b(this.l, 1);
    }

    public boolean l() {
        return at.a(this.l, 1);
    }

    public void c(boolean z) {
        this.l = at.a(this.l, 1, z);
    }

    public e c(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) i.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
        if (this.a == null) {
            throw new bp("Required field 'identity' was not present! Struct: " + toString());
        }
    }
}
