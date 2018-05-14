package com.kepler.sdk;

import android.content.Context;
import com.kepler.jd.Listener.FaceCommonCallBack;
import java.io.File;
import java.util.HashMap;

/* compiled from: TbsSdkJava */
public class x {
    private Context a;
    private t b;
    private v c;
    private File d;
    private FaceCommonCallBack<String> e;

    /* compiled from: TbsSdkJava */
    static class a {
        private static final x a = new x();
    }

    public static final x a() {
        return a.a;
    }

    private x() {
        this.e = new FaceCommonCallBack<String>(this) {
            final /* synthetic */ x a;

            {
                this.a = r1;
            }

            public /* synthetic */ boolean callBack(Object[] objArr) {
                return a((String[]) objArr);
            }

            public boolean a(String... strArr) {
                this.a.b.a(System.currentTimeMillis());
                w a = this.a.b.a(strArr[0]);
                if (a != null) {
                    this.a.a(a);
                }
                return false;
            }
        };
    }

    public void b() {
        if (System.currentTimeMillis() - this.b.b() >= k.b().d() * 1000) {
            if (this.c == null) {
                this.c = new v();
            }
            this.c.a(this.e);
        }
    }

    public void a(Context context) {
        this.a = context;
        this.b = new t(context);
        this.d = aj.c();
        w a = this.b.a();
        if (a != null) {
            a(a);
        }
        b();
    }

    private void a(w wVar) {
        HashMap hashMap = new HashMap();
        for (u uVar : wVar.b) {
            hashMap.put(uVar.b, uVar);
        }
        for (u uVar2 : wVar.c) {
            uVar2.a();
        }
        for (u uVar22 : wVar.a) {
            if (uVar22.a(this.d)) {
                hashMap.put(uVar22.b, uVar22);
            } else {
                File a = ae.a(uVar22.a, this.d, uVar22.b(), 3);
                if (a == null) {
                    l.a("load static err:" + uVar22.a, "201710201541");
                    p.b("suwg", "load err:" + uVar22.a);
                } else if (uVar22.b(a)) {
                    hashMap.put(uVar22.b, uVar22);
                    p.b("suwg", "load ok:" + uVar22.a);
                } else {
                    l.a("load static file check err:" + uVar22.a, "20171020154112");
                }
            }
        }
        this.b.a(hashMap);
    }

    public u a(String str) {
        if (this.b != null) {
            return this.b.b(str);
        }
        return null;
    }
}
