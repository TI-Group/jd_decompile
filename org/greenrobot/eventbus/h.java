package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
final class h {
    private static final List<h> d = new ArrayList();
    Object a;
    n b;
    h c;

    private h(Object obj, n nVar) {
        this.a = obj;
        this.b = nVar;
    }

    static h a(n nVar, Object obj) {
        synchronized (d) {
            int size = d.size();
            if (size > 0) {
                h hVar = (h) d.remove(size - 1);
                hVar.a = obj;
                hVar.b = nVar;
                hVar.c = null;
                return hVar;
            }
            return new h(obj, nVar);
        }
    }

    static void a(h hVar) {
        hVar.a = null;
        hVar.b = null;
        hVar.c = null;
        synchronized (d) {
            if (d.size() < 10000) {
                d.add(hVar);
            }
        }
    }
}
