package c.a;

import com.tencent.stat.DeviceInfo;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class m implements av<m, e>, Serializable, Cloneable {
    public static final Map<e, be> b;
    private static final bu c = new bu("ActivateMsg");
    private static final bl d = new bl(DeviceInfo.TAG_TIMESTAMPS, (byte) 10, (short) 1);
    private static final Map<Class<? extends bw>, bx> e = new HashMap();
    public long a;
    private byte g;

    /* compiled from: TbsSdkJava */
    private static class a extends by<m> {
        private a() {
        }

        public /* synthetic */ void a(bo boVar, av avVar) throws az {
            b(boVar, (m) avVar);
        }

        public /* synthetic */ void b(bo boVar, av avVar) throws az {
            a(boVar, (m) avVar);
        }

        public void a(bo boVar, m mVar) throws az {
            boVar.f();
            while (true) {
                bl h = boVar.h();
                if (h.b == (byte) 0) {
                    boVar.g();
                    if (mVar.e()) {
                        mVar.f();
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
                        mVar.a = boVar.t();
                        mVar.a(true);
                        break;
                    default:
                        bs.a(boVar, h.b);
                        break;
                }
                boVar.i();
            }
        }

        public void b(bo boVar, m mVar) throws az {
            mVar.f();
            boVar.a(m.c);
            boVar.a(m.d);
            boVar.a(mVar.a);
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
    private static class c extends bz<m> {
        private c() {
        }

        public void a(bo boVar, m mVar) throws az {
            ((bv) boVar).a(mVar.a);
        }

        public void b(bo boVar, m mVar) throws az {
            mVar.a = ((bv) boVar).t();
            mVar.a(true);
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
        TS((short) 1, DeviceInfo.TAG_TIMESTAMPS);
        
        private static final Map<String, e> b = null;
        private final short c;
        private final String d;

        static {
            b = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                b.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
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
            return (e) b.get(str);
        }

        private e(short s, String str) {
            this.c = s;
            this.d = str;
        }

        public short a() {
            return this.c;
        }

        public String b() {
            return this.d;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        e.put(by.class, new b());
        e.put(bz.class, new d());
        Map enumMap = new EnumMap(e.class);
        enumMap.put(e.TS, new be(DeviceInfo.TAG_TIMESTAMPS, (byte) 1, new bf((byte) 10)));
        b = Collections.unmodifiableMap(enumMap);
        be.a(m.class, b);
    }

    public m() {
        this.g = (byte) 0;
    }

    public m(long j) {
        this();
        this.a = j;
        a(true);
    }

    public m(m mVar) {
        this.g = (byte) 0;
        this.g = mVar.g;
        this.a = mVar.a;
    }

    public m a() {
        return new m(this);
    }

    public void b() {
        a(false);
        this.a = 0;
    }

    public long c() {
        return this.a;
    }

    public m a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public void d() {
        this.g = at.b(this.g, 0);
    }

    public boolean e() {
        return at.a(this.g, 0);
    }

    public void a(boolean z) {
        this.g = at.a(this.g, 0, z);
    }

    public e a(int i) {
        return e.a(i);
    }

    public void a(bo boVar) throws az {
        ((bx) e.get(boVar.y())).b().b(boVar, this);
    }

    public void b(bo boVar) throws az {
        ((bx) e.get(boVar.y())).b().a(boVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActivateMsg(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void f() throws az {
    }
}
