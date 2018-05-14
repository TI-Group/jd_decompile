package org.greenrobot.eventbus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: TbsSdkJava */
public class c {
    public static String a = "EventBus";
    static volatile c b;
    private static final d c = new d();
    private static final Map<Class<?>, List<Class<?>>> d = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<n>> e;
    private final Map<Object, List<Class<?>>> f;
    private final Map<Class<?>, Object> g;
    private final ThreadLocal<a> h;
    private final f i;
    private final b j;
    private final a k;
    private final m l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;

    /* compiled from: TbsSdkJava */
    static final class a {
        final List<Object> a = new ArrayList();
        boolean b;
        boolean c;
        n d;
        Object e;
        boolean f;

        a() {
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public c() {
        this(c);
    }

    c(d dVar) {
        this.h = new ThreadLocal<a>(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            protected /* synthetic */ Object initialValue() {
                return a();
            }

            protected a a() {
                return new a();
            }
        };
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        this.i = new f(this, Looper.getMainLooper(), 10);
        this.j = new b(this);
        this.k = new a(this);
        this.t = dVar.j != null ? dVar.j.size() : 0;
        this.l = new m(dVar.j, dVar.h, dVar.g);
        this.o = dVar.a;
        this.p = dVar.b;
        this.q = dVar.c;
        this.r = dVar.d;
        this.n = dVar.e;
        this.s = dVar.f;
        this.m = dVar.i;
    }

    public void a(Object obj) {
        List<l> a = this.l.a(obj.getClass());
        synchronized (this) {
            for (l a2 : a) {
                a(obj, a2);
            }
        }
    }

    private void a(Object obj, l lVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class cls = lVar.c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) this.e.get(cls);
        if (copyOnWriteArrayList2 == null) {
            copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            this.e.put(cls, copyOnWriteArrayList2);
            copyOnWriteArrayList = copyOnWriteArrayList2;
        } else if (copyOnWriteArrayList2.contains(nVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        } else {
            copyOnWriteArrayList = copyOnWriteArrayList2;
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (i <= size) {
            if (i == size || lVar.d > ((n) copyOnWriteArrayList.get(i)).b.d) {
                copyOnWriteArrayList.add(i, nVar);
                break;
            }
            i++;
        }
        List list = (List) this.f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f.put(obj, list);
        }
        list.add(cls);
        if (!lVar.e) {
            return;
        }
        if (this.s) {
            for (Entry entry : this.g.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(nVar, entry.getValue());
                }
            }
            return;
        }
        b(nVar, this.g.get(cls));
    }

    private void b(n nVar, Object obj) {
        if (obj != null) {
            a(nVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    private void a(Object obj, Class<?> cls) {
        List list = (List) this.e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2;
                n nVar = (n) list.get(i);
                if (nVar.a == obj) {
                    nVar.c = false;
                    list.remove(i);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + 1;
            }
        }
    }

    public synchronized void b(Object obj) {
        List<Class> list = (List) this.f.get(obj);
        if (list != null) {
            for (Class a : list) {
                a(obj, a);
            }
            this.f.remove(obj);
        } else {
            Log.w(a, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public void c(Object obj) {
        a aVar = (a) this.h.get();
        List list = aVar.a;
        list.add(obj);
        if (!aVar.b) {
            boolean z;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z = true;
            } else {
                z = false;
            }
            aVar.c = z;
            aVar.b = true;
            if (aVar.f) {
                throw new e("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    a(list.remove(0), aVar);
                } finally {
                    aVar.b = false;
                    aVar.c = false;
                }
            }
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean z;
        Class cls = obj.getClass();
        if (this.s) {
            List a = a(cls);
            boolean z2 = false;
            for (int i = 0; i < a.size(); i++) {
                z2 |= a(obj, aVar, (Class) a.get(i));
            }
            z = z2;
        } else {
            z = a(obj, aVar, cls);
        }
        if (!z) {
            if (this.p) {
                Log.d(a, "No subscribers registered for event " + cls);
            }
            if (this.r && cls != g.class && cls != k.class) {
                c(new g(this, obj));
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        synchronized (this) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.e.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        loop0:
        while (it.hasNext()) {
            n nVar = (n) it.next();
            aVar.e = obj;
            aVar.d = nVar;
            try {
                a(nVar, obj, aVar.c);
                Object obj2 = aVar.f;
                continue;
            } finally {
                aVar.e = null;
                aVar.d = null;
                aVar.f = false;
            }
            if (obj2 != null) {
                break loop0;
            }
        }
        return true;
    }

    private void a(n nVar, Object obj, boolean z) {
        switch (nVar.b.b) {
            case POSTING:
                a(nVar, obj);
                return;
            case MAIN:
                if (z) {
                    a(nVar, obj);
                    return;
                } else {
                    this.i.a(nVar, obj);
                    return;
                }
            case BACKGROUND:
                if (z) {
                    this.j.a(nVar, obj);
                    return;
                } else {
                    a(nVar, obj);
                    return;
                }
            case ASYNC:
                this.k.a(nVar, obj);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + nVar.b.b);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (d) {
            list = (List) d.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a((List) list, cls2.getInterfaces());
                }
                d.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a((List) list, cls.getInterfaces());
            }
        }
    }

    void a(h hVar) {
        Object obj = hVar.a;
        n nVar = hVar.b;
        h.a(hVar);
        if (nVar.c) {
            a(nVar, obj);
        }
    }

    void a(n nVar, Object obj) {
        try {
            nVar.b.a.invoke(nVar.a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            a(nVar, obj, e.getCause());
        } catch (Throwable e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    private void a(n nVar, Object obj, Throwable th) {
        if (obj instanceof k) {
            if (this.o) {
                Log.e(a, "SubscriberExceptionEvent subscriber " + nVar.a.getClass() + " threw an exception", th);
                k kVar = (k) obj;
                Log.e(a, "Initial event " + kVar.c + " caused exception in " + kVar.d, kVar.b);
            }
        } else if (this.n) {
            throw new e("Invoking subscriber failed", th);
        } else {
            if (this.o) {
                Log.e(a, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.a.getClass(), th);
            }
            if (this.q) {
                c(new k(this, th, obj, nVar.a));
            }
        }
    }

    ExecutorService b() {
        return this.m;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }
}
