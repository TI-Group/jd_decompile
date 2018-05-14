package c.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class ce {
    public static ce a;
    private final String b = "umeng_it.cache";
    private File c;
    private y d = null;
    private long e;
    private long f;
    private Set<a> g = new HashSet();
    private a h = null;

    /* compiled from: TbsSdkJava */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public boolean a(String str) {
            return !this.b.contains(str);
        }

        public void b(String str) {
            this.b.add(str);
        }

        public void a() {
            if (!this.b.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : this.b) {
                    stringBuilder.append(append);
                    stringBuilder.append(',');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                cx.a(this.a).edit().putString("invld_id", stringBuilder.toString()).commit();
            }
        }

        public void b() {
            Object string = cx.a(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                if (split != null) {
                    for (CharSequence charSequence : split) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            this.b.add(charSequence);
                        }
                    }
                }
            }
        }
    }

    ce(Context context) {
        this.c = new File(context.getFilesDir(), "umeng_it.cache");
        this.f = 86400000;
        this.h = new a(context);
        this.h.b();
    }

    public static synchronized ce a(Context context) {
        ce ceVar;
        synchronized (ce.class) {
            if (a == null) {
                a = new ce(context);
                a.a(new cf(context));
                a.a(new ch(context));
                a.a(new w(context));
                a.a(new ck(context));
                a.a(new cj(context));
                a.a(new bq(context));
                a.a(new ci());
                a.d();
            }
            ceVar = a;
        }
        return ceVar;
    }

    public boolean a(a aVar) {
        if (this.h.a(aVar.b())) {
            return this.g.add(aVar);
        }
        return false;
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.e >= this.f) {
            Object obj = null;
            for (a aVar : this.g) {
                if (aVar.c()) {
                    if (aVar.a()) {
                        obj = 1;
                        if (!aVar.c()) {
                            this.h.b(aVar.b());
                        }
                    }
                    obj = obj;
                }
            }
            if (obj != null) {
                f();
                this.h.a();
                e();
            }
            this.e = currentTimeMillis;
        }
    }

    public y b() {
        return this.d;
    }

    private void f() {
        y yVar = new y();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (a aVar : this.g) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (!(aVar.e() == null || aVar.e().isEmpty())) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        yVar.a(arrayList);
        yVar.a(hashMap);
        synchronized (this) {
            this.d = yVar;
        }
    }

    public void c() {
        boolean z = false;
        for (a aVar : this.g) {
            if (aVar.c()) {
                boolean z2;
                if (aVar.e() == null || aVar.e().isEmpty()) {
                    z2 = z;
                } else {
                    aVar.a(null);
                    z2 = true;
                }
                z = z2;
            }
        }
        if (z) {
            this.d.b(false);
            e();
        }
    }

    public void d() {
        y g = g();
        if (g != null) {
            List<a> arrayList = new ArrayList(this.g.size());
            synchronized (this) {
                this.d = g;
                for (a aVar : this.g) {
                    aVar.a(this.d);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                for (a aVar2 : arrayList) {
                    this.g.remove(aVar2);
                }
            }
            f();
        }
    }

    public void e() {
        if (this.d != null) {
            a(this.d);
        }
    }

    private y g() {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        if (!this.c.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(this.c);
            try {
                byte[] b = ar.b(fileInputStream);
                av yVar = new y();
                new ay().a(yVar, b);
                ar.c(fileInputStream);
                return yVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    ar.c(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    ar.c(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            ar.c(fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            ar.c(fileInputStream);
            throw th;
        }
    }

    private void a(y yVar) {
        if (yVar != null) {
            try {
                byte[] a;
                synchronized (this) {
                    a = new bb().a(yVar);
                }
                if (a != null) {
                    ar.a(this.c, a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
