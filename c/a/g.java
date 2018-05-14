package c.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
public class g extends u implements cr {
    public g(String str, Map<String, Object> map, long j, int i) {
        a(str);
        b(System.currentTimeMillis());
        if (map.size() > 0) {
            a(b(map));
        }
        if (i <= 0) {
            i = 1;
        }
        a(i);
        if (j > 0) {
            a(j);
        }
    }

    private HashMap<String, ag> b(Map<String, Object> map) {
        Iterator it = map.entrySet().iterator();
        HashMap<String, ag> hashMap = new HashMap();
        int i = 0;
        while (i < 10 && it.hasNext()) {
            Entry entry = (Entry) it.next();
            ag agVar = new ag();
            Object value = entry.getValue();
            if (value instanceof String) {
                agVar.b((String) value);
            } else if (value instanceof Long) {
                agVar.b(((Long) value).longValue());
            } else if (value instanceof Integer) {
                agVar.b(((Integer) value).longValue());
            } else if (value instanceof Float) {
                agVar.b(((Float) value).longValue());
            } else if (value instanceof Double) {
                agVar.b(((Double) value).longValue());
            }
            if (agVar.k()) {
                hashMap.put(entry.getKey(), agVar);
                i++;
            }
        }
        return hashMap;
    }

    public static f a(String str, String str2, Map<String, Object> map) {
        f fVar = new f();
        fVar.b = str;
        fVar.c = str2;
        fVar.d = map;
        return fVar;
    }

    public static String b(String str, String str2, Map<String, Object> map) {
        return str + str2;
    }

    public void a(am amVar, String str) {
        if (amVar.s() > 0) {
            for (ab abVar : amVar.u()) {
                if (str.equals(abVar.c())) {
                    break;
                }
            }
        }
        ab abVar2 = null;
        if (abVar2 == null) {
            abVar2 = new ab();
            abVar2.a(str);
            amVar.a(abVar2);
        }
        abVar2.a((u) this);
    }
}
