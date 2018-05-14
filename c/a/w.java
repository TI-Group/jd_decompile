package c.a;

import android.content.Context;
import android.provider.Settings.Secure;

/* compiled from: TbsSdkJava */
public class w extends a {
    private Context a;

    public w(Context context) {
        super("android_id");
        this.a = context;
    }

    public String f() {
        String str = null;
        try {
            str = Secure.getString(this.a.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        return str;
    }
}
