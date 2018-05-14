package c.a;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class ag extends bc<ag, a> {
    public static final Map<a, be> a;
    private static final bu d = new bu("PropertyValue");
    private static final bl e = new bl("string_value", ReplyCode.reply0xb, (short) 1);
    private static final bl f = new bl("long_value", (byte) 10, (short) 2);

    /* compiled from: TbsSdkJava */
    public enum a implements ba {
        STRING_VALUE((short) 1, "string_value"),
        LONG_VALUE((short) 2, "long_value");
        
        private static final Map<String, a> c = null;
        private final short d;
        private final String e;

        static {
            c = new HashMap();
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                c.put(aVar.b(), aVar);
            }
        }

        public static a a(int i) {
            switch (i) {
                case 1:
                    return STRING_VALUE;
                case 2:
                    return LONG_VALUE;
                default:
                    return null;
            }
        }

        public static a b(int i) {
            a a = a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static a a(String str) {
            return (a) c.get(str);
        }

        private a(short s, String str) {
            this.d = s;
            this.e = str;
        }

        public short a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }
    }

    public /* synthetic */ ba b(int i) {
        return a(i);
    }

    protected /* synthetic */ ba b(short s) {
        return a(s);
    }

    public /* synthetic */ av g() {
        return a();
    }

    static {
        Map enumMap = new EnumMap(a.class);
        enumMap.put(a.STRING_VALUE, new be("string_value", (byte) 3, new bf(ReplyCode.reply0xb)));
        enumMap.put(a.LONG_VALUE, new be("long_value", (byte) 3, new bf((byte) 10)));
        a = Collections.unmodifiableMap(enumMap);
        be.a(ag.class, a);
    }

    public ag(a aVar, Object obj) {
        super(aVar, obj);
    }

    public ag(ag agVar) {
        super(agVar);
    }

    public ag a() {
        return new ag(this);
    }

    public static ag a(String str) {
        ag agVar = new ag();
        agVar.b(str);
        return agVar;
    }

    public static ag a(long j) {
        ag agVar = new ag();
        agVar.b(j);
        return agVar;
    }

    protected void a(a aVar, Object obj) throws ClassCastException {
        switch (aVar) {
            case STRING_VALUE:
                if (!(obj instanceof String)) {
                    throw new ClassCastException("Was expecting value of type String for field 'string_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            case LONG_VALUE:
                if (!(obj instanceof Long)) {
                    throw new ClassCastException("Was expecting value of type Long for field 'long_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown field id " + aVar);
        }
    }

    protected Object a(bo boVar, bl blVar) throws az {
        a a = a.a(blVar.c);
        if (a == null) {
            return null;
        }
        switch (a) {
            case STRING_VALUE:
                if (blVar.b == e.b) {
                    return boVar.v();
                }
                bs.a(boVar, blVar.b);
                return null;
            case LONG_VALUE:
                if (blVar.b == f.b) {
                    return Long.valueOf(boVar.t());
                }
                bs.a(boVar, blVar.b);
                return null;
            default:
                throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
        }
    }

    protected void c(bo boVar) throws az {
        switch ((a) this.c) {
            case STRING_VALUE:
                boVar.a((String) this.b);
                return;
            case LONG_VALUE:
                boVar.a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    protected Object a(bo boVar, short s) throws az {
        a a = a.a((int) s);
        if (a != null) {
            switch (a) {
                case STRING_VALUE:
                    return boVar.v();
                case LONG_VALUE:
                    return Long.valueOf(boVar.t());
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            }
        }
        throw new bp("Couldn't find a field with field id " + s);
    }

    protected void d(bo boVar) throws az {
        switch ((a) this.c) {
            case STRING_VALUE:
                boVar.a((String) this.b);
                return;
            case LONG_VALUE:
                boVar.a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    protected bl a(a aVar) {
        switch (aVar) {
            case STRING_VALUE:
                return e;
            case LONG_VALUE:
                return f;
            default:
                throw new IllegalArgumentException("Unknown field id " + aVar);
        }
    }

    protected bu c() {
        return d;
    }

    protected a a(short s) {
        return a.b(s);
    }

    public a a(int i) {
        return a.a(i);
    }

    public String d() {
        if (i() == a.STRING_VALUE) {
            return (String) j();
        }
        throw new RuntimeException("Cannot get field 'string_value' because union is currently set to " + a((a) i()).a);
    }

    public void b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.c = a.STRING_VALUE;
        this.b = str;
    }

    public long e() {
        if (i() == a.LONG_VALUE) {
            return ((Long) j()).longValue();
        }
        throw new RuntimeException("Cannot get field 'long_value' because union is currently set to " + a((a) i()).a);
    }

    public void b(long j) {
        this.c = a.LONG_VALUE;
        this.b = Long.valueOf(j);
    }

    public boolean f() {
        return this.c == a.STRING_VALUE;
    }

    public boolean h() {
        return this.c == a.LONG_VALUE;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ag) {
            return a((ag) obj);
        }
        return false;
    }

    public boolean a(ag agVar) {
        return agVar != null && i() == agVar.i() && j().equals(agVar.j());
    }

    public int hashCode() {
        return 0;
    }
}
