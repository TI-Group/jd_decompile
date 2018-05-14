package c.a;

import android.content.Context;
import android.telephony.TelephonyManager;

/* compiled from: TbsSdkJava */
public class cf extends a {
    private Context a;

    public cf(Context context) {
        super("imei");
        this.a = context;
    }

    public String f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        if (telephonyManager == null) {
        }
        try {
            if (aq.a(this.a, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getDeviceId();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
