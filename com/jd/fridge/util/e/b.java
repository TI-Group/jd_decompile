package com.jd.fridge.util.e;

import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.e.a.a;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;

/* compiled from: TbsSdkJava */
public class b {
    private static b a;
    private a b;
    private a c;

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private void i() {
        if (this.b == null) {
            this.b = new a("com.jd.fridge.searchHistory", 0);
            this.c = this.b.a();
        }
    }

    public void a(String str) {
        i();
        this.c.putString("history", str);
        this.c.commit();
    }

    public String b() {
        i();
        return this.b.getString("history", "");
    }

    public void b(String str) {
        i();
        this.c.putString("hot", str);
        this.c.commit();
    }

    public String c() {
        i();
        return this.b.getString("hot", "");
    }

    public void c(String str) {
        i();
        this.c.putString("product_uuid", str);
        this.c.commit();
        r.b("infos", "uuid==" + str);
    }

    public String d() {
        i();
        return this.b.getString("product_uuid", "");
    }

    public void a(boolean z) {
        i();
        this.c.putBoolean("jpush_register", z);
        this.c.commit();
    }

    public boolean e() {
        i();
        return this.b.getBoolean("jpush_register", false);
    }

    public void f() {
        i();
        int g = g() + 1;
        this.c.putInt(GlobalVariable.C(), g);
        this.c.commit();
        k.a("====saveJpushNum=newNoticeNum====" + g + "==feedid==" + GlobalVariable.C());
    }

    public int g() {
        i();
        k.a("===getJpushNum=feedid==" + GlobalVariable.C());
        return this.b.getInt(GlobalVariable.C(), 0);
    }

    public void h() {
        i();
        this.c.remove(GlobalVariable.C());
        this.c.commit();
        k.a("===clearJpushNum===" + GlobalVariable.C());
    }
}
