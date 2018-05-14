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
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.http.cookie.ClientCookie;

/* compiled from: TbsSdkJava */
public class v implements av<v, e>, Serializable, Cloneable {
    public static final Map<e, be> e;
    private static final bu f = new bu("IdJournal");
    private static final bl g = new bl(ClientCookie.DOMAIN_ATTR, ReplyCode.reply0xb, (short) 1);
    private static final bl h = new bl("old_id", ReplyCode.reply0xb, (short) 2);
    private static final bl i = new bl("new_id", ReplyCode.reply0xb, (short) 3);
    private static final bl j = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 4);
    private static final Map<Class<? extends bw>, bx> k = new HashMap();
    public String a;
    public String b;
    public String c;
    public long d;
    private byte m;
    private e[] n;

    /* compiled from: TbsSdkJava */
    private static class a extends by<v> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (v) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (v) avVar);
        }

        public void a(bo boVar, v vVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (vVar.o()) {
                        vVar.p();
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
                        vVar.a = boVar.v();
                        vVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        vVar.b = boVar.v();
                        vVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        vVar.c = boVar.v();
                        vVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        vVar.d = boVar.t();
                        vVar.d(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, v vVar) throws az {
            vVar.p();
            boVar.a(v.f);
            if (vVar.a != null) {
                boVar.a(v.g);
                boVar.a(vVar.a);
                boVar.b();
            }
            if (vVar.b != null && vVar.i()) {
                boVar.a(v.h);
                boVar.a(vVar.b);
                boVar.b();
            }
            if (vVar.c != null) {
                boVar.a(v.i);
                boVar.a(vVar.c);
                boVar.b();
            }
            boVar.a(v.j);
            boVar.a(vVar.d);
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
    private static class c extends bz<v> {
        private c() {
        }

        public void a(bo boVar, v vVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(vVar.a);
            bvVar.a(vVar.c);
            bvVar.a(vVar.d);
            BitSet bitSet = new BitSet();
            if (vVar.i()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (vVar.i()) {
                bvVar.a(vVar.b);
            }
        }

        public void b(bo boVar, v vVar) throws az {
            bv bvVar = (bv) boVar;
            vVar.a = bvVar.v();
            vVar.a(true);
            vVar.c = bvVar.v();
            vVar.c(true);
            vVar.d = bvVar.t();
            vVar.d(true);
            if (bvVar.b(1).get(0)) {
                vVar.b = bvVar.v();
                vVar.b(true);
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
        DOMAIN((short) 1, ClientCookie.DOMAIN_ATTR),
        OLD_ID((short) 2, "old_id"),
        NEW_ID((short) 3, "new_id"),
        TS((short) 4, DeviceInfo.TAG_TIMESTAMPS);
        
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
                    return DOMAIN;
                case 2:
                    return OLD_ID;
                case 3:
                    return NEW_ID;
                case 4:
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
        enumMap.put(e.DOMAIN, new be(ClientCookie.DOMAIN_ATTR, (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.OLD_ID, new be("old_id", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.NEW_ID, new be("new_id", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        e = Collections.unmodifiableMap(enumMap);
        be.a(v.class, e);
    }

    public v() {
        this.m = (byte) 0;
        this.n = new e[]{e.OLD_ID};
    }

    public v(String str, String str2, long j) {
        this();
        this.a = str;
        this.c = str2;
        this.d = j;
        d(true);
    }

    public v(v vVar) {
        this.m = (byte) 0;
        this.n = new e[]{e.OLD_ID};
        this.m = vVar.m;
        if (vVar.e()) {
            this.a = vVar.a;
        }
        if (vVar.i()) {
            this.b = vVar.b;
        }
        if (vVar.l()) {
            this.c = vVar.c;
        }
        this.d = vVar.d;
    }

    public v a() {
        return new v(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
    }

    public String c() {
        return this.a;
    }

    public v a(String str) {
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

    public v b(String str) {
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

    public v c(String str) {
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

    public long m() {
        return this.d;
    }

    public v a(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public void n() {
        this.m = at.b(this.m, 0);
    }

    public boolean o() {
        return at.a(this.m, 0);
    }

    public void d(boolean z) {
        this.m = at.a(this.m, 0, z);
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
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void p() throws az {
        if (this.a == null) {
            throw new bp("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new bp("Required field 'new_id' was not present! Struct: " + toString());
        }
    }
}
