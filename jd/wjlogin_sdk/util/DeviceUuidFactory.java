package jd.wjlogin_sdk.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.UUID;

/* compiled from: TbsSdkJava */
public class DeviceUuidFactory {
    protected static UUID uuid;

    public DeviceUuidFactory(Context context) {
        if (uuid == null) {
            synchronized (DeviceUuidFactory.class) {
                if (uuid == null) {
                    Object string = Secure.getString(context.getContentResolver(), "android_id");
                    try {
                        if (TextUtils.isEmpty(string)) {
                            UUID nameUUIDFromBytes;
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            if (deviceId != null) {
                                nameUUIDFromBytes = UUID.nameUUIDFromBytes(deviceId.getBytes("utf8"));
                            } else {
                                nameUUIDFromBytes = UUID.randomUUID();
                            }
                            uuid = nameUUIDFromBytes;
                        } else {
                            uuid = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                        }
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public UUID getDeviceUuid() {
        return uuid;
    }
}
