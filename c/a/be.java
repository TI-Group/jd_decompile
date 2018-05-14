package c.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class be implements Serializable {
    private static Map<Class<? extends av>, Map<? extends ba, be>> d = new HashMap();
    public final String a;
    public final byte b;
    public final bf c;

    public be(String str, byte b, bf bfVar) {
        this.a = str;
        this.b = b;
        this.c = bfVar;
    }

    public static void a(Class<? extends av> cls, Map<? extends ba, be> map) {
        d.put(cls, map);
    }

    public static Map<? extends ba, be> a(Class<? extends av> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return (Map) d.get(cls);
    }
}
