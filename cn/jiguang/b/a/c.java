package cn.jiguang.b.a;

import android.text.TextUtils;

public final class c {
    private String a;
    private String b;
    private String c;

    public c(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final boolean d() {
        return TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c);
    }
}
