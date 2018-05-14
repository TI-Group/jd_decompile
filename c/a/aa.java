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

/* compiled from: TbsSdkJava */
public class aa implements av<aa, e>, Serializable, Cloneable {
    public static final Map<e, be> d;
    private static final bu e = new bu("ImprintValue");
    private static final bl f = new bl("value", ReplyCode.reply0xb, (short) 1);
    private static final bl g = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 2);
    private static final bl h = new bl("guid", ReplyCode.reply0xb, (short) 3);
    private static final Map<Class<? extends bw>, bx> i = new HashMap();
    public String a;
    public long b;
    public String c;
    private byte k;
    private e[] l;

    /* compiled from: TbsSdkJava */
    private static class a extends by<aa> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (aa) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (aa) avVar);
        }

        public void a(bo boVar, aa aaVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (aaVar.i()) {
                        aaVar.m();
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
                        aaVar.a = boVar.v();
                        aaVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != (byte) 10) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aaVar.b = boVar.t();
                        aaVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        aaVar.c = boVar.v();
                        aaVar.c(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, aa aaVar) throws az {
            aaVar.m();
            boVar.a(aa.e);
            if (aaVar.a != null && aaVar.e()) {
                boVar.a(aa.f);
                boVar.a(aaVar.a);
                boVar.b();
            }
            boVar.a(aa.g);
            boVar.a(aaVar.b);
            boVar.b();
            if (aaVar.c != null) {
                boVar.a(aa.h);
                boVar.a(aaVar.c);
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
    private static class c extends bz<aa> {
        private c() {
        }

        public void a(bo boVar, aa aaVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(aaVar.b);
            bvVar.a(aaVar.c);
            BitSet bitSet = new BitSet();
            if (aaVar.e()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (aaVar.e()) {
                bvVar.a(aaVar.a);
            }
        }

        public void b(bo boVar, aa aaVar) throws az {
            bv bvVar = (bv) boVar;
            aaVar.b = bvVar.t();
            aaVar.b(true);
            aaVar.c = bvVar.v();
            aaVar.c(true);
            if (bvVar.b(1).get(0)) {
                aaVar.a = bvVar.v();
                aaVar.a(true);
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
        VALUE((short) 1, "value"),
        TS((short) 2, DeviceInfo.TAG_TIMESTAMPS),
        GUID((short) 3, "guid");
        
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
                    return VALUE;
                case 2:
                    return TS;
                case 3:
                    return GUID;
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
        enumMap.put(e.VALUE, new be("value", (byte) 2, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        enumMap.put(e.GUID, new be("guid", (byte) 1, new bf(ReplyCode.reply0xb)));
        d = Collections.unmodifiableMap(enumMap);
        be.a(aa.class, d);
    }

    public aa() {
        this.k = (byte) 0;
        this.l = new e[]{e.VALUE};
    }

    public aa(long j, String str) {
        this();
        this.b = j;
        b(true);
        this.c = str;
    }

    public aa(aa aaVar) {
        this.k = (byte) 0;
        this.l = new e[]{e.VALUE};
        this.k = aaVar.k;
        if (aaVar.e()) {
            this.a = aaVar.a;
        }
        this.b = aaVar.b;
        if (aaVar.l()) {
            this.c = aaVar.c;
        }
    }

    public aa a() {
        return new aa(this);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public String c() {
        return this.a;
    }

    public aa a(String str) {
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

    public aa a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public void h() {
        this.k = at.b(this.k, 0);
    }

    public boolean i() {
        return at.a(this.k, 0);
    }

    public void b(boolean z) {
        this.k = at.a(this.k, 0, z);
    }

    public String j() {
        return this.c;
    }

    public aa b(String str) {
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
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        Object obj = 1;
        if (e()) {
            stringBuilder.append("value:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void m() throws az {
        if (this.c == null) {
            throw new bp("Required field 'guid' was not present! Struct: " + toString());
        }
    }
}
