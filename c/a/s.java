package c.a;

import com.tencent.open.SocialConstants;
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

/* compiled from: TbsSdkJava */
public class s implements av<s, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("Error");
    private static final bl f = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 1);
    private static final bl g = new bl("context", ReplyCode.reply0xb, (short) 2);
    private static final bl h = new bl(SocialConstants.PARAM_SOURCE, (byte) 8, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public long a;
    public String b;
    public t c;
    private byte k;
    private e[] l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<s> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (s) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (s) avVar);
        }

        public void a(bo boVar, s sVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (sVar.e()) {
                        sVar.m();
                        return;
                    }
                    throw new bp("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        sVar.a = boVar.t();
                        sVar.b(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        sVar.b = boVar.v();
                        sVar.c(true);
                        break;
                    case (short) 3:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        sVar.c = t.a(boVar.s());
                        sVar.d(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, s sVar) throws az {
            sVar.m();
            boVar.a(s.e);
            boVar.a(s.f);
            boVar.a(sVar.a);
            boVar.b();
            if (sVar.b != null) {
                boVar.a(s.g);
                boVar.a(sVar.b);
                boVar.b();
            }
            if (sVar.c != null && sVar.l()) {
                boVar.a(s.h);
                boVar.a(sVar.c.a());
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
    private static class c extends bz<s> {
        private c() {
        }

        public void a(bo boVar, s sVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(sVar.a);
            bvVar.a(sVar.b);
            BitSet bitSet = new BitSet();
            if (sVar.l()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (sVar.l()) {
                bvVar.a(sVar.c.a());
            }
        }

        public void b(bo boVar, s sVar) throws az {
            bv bvVar = (bv) boVar;
            sVar.a = bvVar.t();
            sVar.b(true);
            sVar.b = bvVar.v();
            sVar.c(true);
            if (bvVar.b(1).get(0)) {
                sVar.c = t.a(bvVar.s());
                sVar.d(true);
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
        TS((short) 1, DeviceInfo.TAG_TIMESTAMPS),
        CONTEXT((short) 2, "context"),
        SOURCE((short) 3, SocialConstants.PARAM_SOURCE);
        
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
                    return TS;
                case 2:
                    return CONTEXT;
                case 3:
                    return SOURCE;
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
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        enumMap.put(e.CONTEXT, new be("context", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.SOURCE, new be(SocialConstants.PARAM_SOURCE, (byte) 2, new bd(ReplyCode.reply0x10, t.class)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(s.class, d);
    }

    public s() {
        this.k = (byte) 0;
        this.l = new e[]{e.SOURCE};
    }

    public s(long j, String str) {
        this();
        this.a = j;
        b(true);
        this.b = str;
    }

    public s(s sVar) {
        this.k = (byte) 0;
        this.l = new e[]{e.SOURCE};
        this.k = sVar.k;
        this.a = sVar.a;
        if (sVar.i()) {
            this.b = sVar.b;
        }
        if (sVar.l()) {
            this.c = sVar.c;
        }
    }

    public s a() {
        return new s(this);
    }

    public void b() {
        b(false);
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public long c() {
        return this.a;
    }

    public s a(long j) {
        this.a = j;
        b(true);
        return this;
    }

    public void d() {
        this.k = at.b(this.k, 0);
    }

    public boolean e() {
        return at.a(this.k, 0);
    }

    public void b(boolean z) {
        this.k = at.a(this.k, 0, z);
    }

    public String f() {
        return this.b;
    }

    public s a(String str) {
        this.b = str;
        return this;
    }

    public void h() {
        this.b = null;
    }

    public boolean i() {
        return this.b != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public t j() {
        return this.c;
    }

    public s a(t tVar) {
        this.c = tVar;
        return this;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public void d(boolean z) {
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
        StringBuilder stringBuilder = new StringBuilder("Error(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("context:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("source:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
        if (this.b == null) {
            throw new bp("Required field 'context' was not present! Struct: " + toString());
        }
    }
}
