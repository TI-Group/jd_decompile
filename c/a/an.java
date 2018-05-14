package c.a;

import com.tencent.open.GameAppOperation;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class an implements av<an, e>, Serializable, Cloneable {
    public static final Map<e, be> k;
    private static final bu l = new bu("UMEnvelope");
    private static final bl m = new bl("version", ReplyCode.reply0xb, (short) 1);
    private static final bl n = new bl("address", ReplyCode.reply0xb, (short) 2);
    private static final bl o = new bl(GameAppOperation.GAME_SIGNATURE, ReplyCode.reply0xb, (short) 3);
    private static final bl p = new bl("serial_num", (byte) 8, (short) 4);
    private static final bl q = new bl("ts_secs", (byte) 8, (short) 5);
    private static final bl r = new bl("length", (byte) 8, (short) 6);
    private static final bl s = new bl("entity", ReplyCode.reply0xb, (short) 7);
    private static final bl t = new bl("guid", ReplyCode.reply0xb, (short) 8);
    private static final bl u = new bl("checksum", ReplyCode.reply0xb, (short) 9);
    private static final bl v = new bl("codex", (byte) 8, (short) 10);
    private static final Map<Class<? extends bw>, bx> w = new HashMap();
    private byte B;
    private e[] C;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* compiled from: TbsSdkJava */
    private static class a extends by<an> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (an) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (an) avVar);
        }

        public void a(bo boVar, an anVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (!anVar.o()) {
                        throw new bp("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!anVar.r()) {
                        throw new bp("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (anVar.u()) {
                        anVar.I();
                        return;
                    } else {
                        throw new bp("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.c) {
                    case (short) 1:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.a = boVar.v();
                        anVar.a(true);
                        break;
                    case (short) 2:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.b = boVar.v();
                        anVar.b(true);
                        break;
                    case (short) 3:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.c = boVar.v();
                        anVar.c(true);
                        break;
                    case (short) 4:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.d = boVar.s();
                        anVar.d(true);
                        break;
                    case (short) 5:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.e = boVar.s();
                        anVar.e(true);
                        break;
                    case (short) 6:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.f = boVar.s();
                        anVar.f(true);
                        break;
                    case (short) 7:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.g = boVar.w();
                        anVar.g(true);
                        break;
                    case (short) 8:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.h = boVar.v();
                        anVar.h(true);
                        break;
                    case (short) 9:
                        if (h.b != ReplyCode.reply0xb) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.i = boVar.v();
                        anVar.i(true);
                        break;
                    case (short) 10:
                        if (h.b != (byte) 8) {
                            bs.a(boVar, h.b);
                            break;
                        }
                        anVar.j = boVar.s();
                        anVar.j(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, an anVar) throws az {
            anVar.I();
            boVar.a(an.l);
            if (anVar.a != null) {
                boVar.a(an.m);
                boVar.a(anVar.a);
                boVar.b();
            }
            if (anVar.b != null) {
                boVar.a(an.n);
                boVar.a(anVar.b);
                boVar.b();
            }
            if (anVar.c != null) {
                boVar.a(an.o);
                boVar.a(anVar.c);
                boVar.b();
            }
            boVar.a(an.p);
            boVar.a(anVar.d);
            boVar.b();
            boVar.a(an.q);
            boVar.a(anVar.e);
            boVar.b();
            boVar.a(an.r);
            boVar.a(anVar.f);
            boVar.b();
            if (anVar.g != null) {
                boVar.a(an.s);
                boVar.a(anVar.g);
                boVar.b();
            }
            if (anVar.h != null) {
                boVar.a(an.t);
                boVar.a(anVar.h);
                boVar.b();
            }
            if (anVar.i != null) {
                boVar.a(an.u);
                boVar.a(anVar.i);
                boVar.b();
            }
            if (anVar.H()) {
                boVar.a(an.v);
                boVar.a(anVar.j);
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
    private static class c extends bz<an> {
        private c() {
        }

        public void a(bo boVar, an anVar) throws az {
            bv bvVar = (bv) boVar;
            bvVar.a(anVar.a);
            bvVar.a(anVar.b);
            bvVar.a(anVar.c);
            bvVar.a(anVar.d);
            bvVar.a(anVar.e);
            bvVar.a(anVar.f);
            bvVar.a(anVar.g);
            bvVar.a(anVar.h);
            bvVar.a(anVar.i);
            BitSet bitSet = new BitSet();
            if (anVar.H()) {
                bitSet.set(0);
            }
            bvVar.a(bitSet, 1);
            if (anVar.H()) {
                bvVar.a(anVar.j);
            }
        }

        public void b(bo boVar, an anVar) throws az {
            bv bvVar = (bv) boVar;
            anVar.a = bvVar.v();
            anVar.a(true);
            anVar.b = bvVar.v();
            anVar.b(true);
            anVar.c = bvVar.v();
            anVar.c(true);
            anVar.d = bvVar.s();
            anVar.d(true);
            anVar.e = bvVar.s();
            anVar.e(true);
            anVar.f = bvVar.s();
            anVar.f(true);
            anVar.g = bvVar.w();
            anVar.g(true);
            anVar.h = bvVar.v();
            anVar.h(true);
            anVar.i = bvVar.v();
            anVar.i(true);
            if (bvVar.b(1).get(0)) {
                anVar.j = bvVar.s();
                anVar.j(true);
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
        VERSION((short) 1, "version"),
        ADDRESS((short) 2, "address"),
        SIGNATURE((short) 3, GameAppOperation.GAME_SIGNATURE),
        SERIAL_NUM((short) 4, "serial_num"),
        TS_SECS((short) 5, "ts_secs"),
        LENGTH((short) 6, "length"),
        ENTITY((short) 7, "entity"),
        GUID((short) 8, "guid"),
        CHECKSUM((short) 9, "checksum"),
        CODEX((short) 10, "codex");
        
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
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
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
        return f(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        w.put(by.class, new b());
        w.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new be("version", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.ADDRESS, new be("address", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.SIGNATURE, new be(GameAppOperation.GAME_SIGNATURE, (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.SERIAL_NUM, new be("serial_num", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.TS_SECS, new be("ts_secs", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.LENGTH, new be("length", (byte) 1, new bf((byte) 8)));
        enumMap.put(e.ENTITY, new be("entity", (byte) 1, new bf((byte) ReplyCode.reply0xb, true)));
        enumMap.put(e.GUID, new be("guid", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.CHECKSUM, new be("checksum", (byte) 1, new bf(ReplyCode.reply0xb)));
        enumMap.put(e.CODEX, new be("codex", (byte) 2, new bf((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        be.a(an.class, k);
    }

    public an() {
        this.B = (byte) 0;
        this.C = new e[]{e.CODEX};
    }

    public an(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public an(an anVar) {
        this.B = (byte) 0;
        this.C = new e[]{e.CODEX};
        this.B = anVar.B;
        if (anVar.e()) {
            this.a = anVar.a;
        }
        if (anVar.i()) {
            this.b = anVar.b;
        }
        if (anVar.l()) {
            this.c = anVar.c;
        }
        this.d = anVar.d;
        this.e = anVar.e;
        this.f = anVar.f;
        if (anVar.y()) {
            this.g = ax.d(anVar.g);
        }
        if (anVar.B()) {
            this.h = anVar.h;
        }
        if (anVar.E()) {
            this.i = anVar.i;
        }
        this.j = anVar.j;
    }

    public an a() {
        return new an(this);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public String c() {
        return this.a;
    }

    public an a(String str) {
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

    public an b(String str) {
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

    public an c(String str) {
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

    public int m() {
        return this.d;
    }

    public an a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public void n() {
        this.B = at.b(this.B, 0);
    }

    public boolean o() {
        return at.a(this.B, 0);
    }

    public void d(boolean z) {
        this.B = at.a(this.B, 0, z);
    }

    public int p() {
        return this.e;
    }

    public an c(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public void q() {
        this.B = at.b(this.B, 1);
    }

    public boolean r() {
        return at.a(this.B, 1);
    }

    public void e(boolean z) {
        this.B = at.a(this.B, 1, z);
    }

    public int s() {
        return this.f;
    }

    public an d(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public void t() {
        this.B = at.b(this.B, 2);
    }

    public boolean u() {
        return at.a(this.B, 2);
    }

    public void f(boolean z) {
        this.B = at.a(this.B, 2, z);
    }

    public byte[] v() {
        a(ax.c(this.g));
        return this.g == null ? null : this.g.array();
    }

    public ByteBuffer w() {
        return this.g;
    }

    public an a(byte[] bArr) {
        a(bArr == null ? (ByteBuffer) null : ByteBuffer.wrap(bArr));
        return this;
    }

    public an a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public void x() {
        this.g = null;
    }

    public boolean y() {
        return this.g != null;
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public String z() {
        return this.h;
    }

    public an d(String str) {
        this.h = str;
        return this;
    }

    public void A() {
        this.h = null;
    }

    public boolean B() {
        return this.h != null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public String C() {
        return this.i;
    }

    public an e(String str) {
        this.i = str;
        return this;
    }

    public void D() {
        this.i = null;
    }

    public boolean E() {
        return this.i != null;
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public int F() {
        return this.j;
    }

    public an e(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public void G() {
        this.B = at.b(this.B, 3);
    }

    public boolean H() {
        return at.a(this.B, 3);
    }

    public void j(boolean z) {
        this.B = at.a(this.B, 3, z);
    }

    public e f(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) w.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) w.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMEnvelope(");
        stringBuilder.append("version:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("address:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("signature:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("serial_num:");
        stringBuilder.append(this.d);
        stringBuilder.append(", ");
        stringBuilder.append("ts_secs:");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append("length:");
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append("entity:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            ax.a(this.g, stringBuilder);
        }
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.h);
        }
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.i == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.i);
        }
        if (H()) {
            stringBuilder.append(", ");
            stringBuilder.append("codex:");
            stringBuilder.append(this.j);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void I() throws az {
        if (this.a == null) {
            throw new bp("Required field 'version' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new bp("Required field 'address' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new bp("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new bp("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new bp("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i == null) {
            throw new bp("Required field 'checksum' was not present! Struct: " + toString());
        }
    }
}
