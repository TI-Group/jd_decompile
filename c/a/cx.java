package c.a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: TbsSdkJava */
public class cx {
    public static SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("umeng_general_config", 0);
    }
}
