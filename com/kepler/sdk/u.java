package com.kepler.sdk;

import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.File;

/* compiled from: TbsSdkJava */
public class u {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g = CommonUtil.UTF8;
    public File h;

    public u(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof u)) {
            return super.equals(obj);
        }
        u uVar = (u) obj;
        if (aq.b(uVar.c, this.c) && aq.b(uVar.d, this.d) && aq.b(uVar.e, this.e)) {
            return true;
        }
        return false;
    }

    public void a() {
        if (this.h != null) {
            aj.b(this.h);
        }
    }

    public String b() {
        return this.c;
    }

    public boolean a(File file) {
        boolean z;
        String str;
        boolean z2 = true;
        if (this.h == null) {
            File file2 = new File(file, b());
            String a = aj.a(file2);
            if (a.equalsIgnoreCase(this.c)) {
                this.h = file2;
            } else {
                aj.b(file2);
                z2 = false;
            }
            z = z2;
            str = a;
        } else {
            z = true;
            str = null;
        }
        p.b("suwg", "check fname:  " + b() + " " + str + " " + z);
        return z;
    }

    public boolean b(File file) {
        boolean z = false;
        String str = null;
        if (file != null) {
            str = aj.a(file);
            if (str.equalsIgnoreCase(this.c)) {
                this.h = file;
                z = true;
            } else {
                aj.b(file);
            }
        }
        p.b("suwg", "checkLoadFile  fname:  " + b() + " " + str + " " + z);
        return z;
    }
}
