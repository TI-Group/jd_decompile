package c.a;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class bq extends a {
    private Context a;

    public bq(Context context) {
        super("idfa");
        this.a = context;
    }

    public String f() {
        String a = ao.a(this.a);
        return a == null ? "" : a;
    }
}
