package com.jd.fridge.util;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.jd.fridge.GlobalVariable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class q {
    public static String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            String str4 = "";
            try {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                PackageInfo packageInfo = GlobalVariable.B().getPackageManager().getPackageInfo(GlobalVariable.B().getPackageName(), 0);
                String str5 = a("yyyy-MM-dd'T'HH:mm:ss.SSS", System.currentTimeMillis()) + "Z";
                str4 = packageInfo.versionName;
                String replace = Build.MODEL.replace(" ", "");
                str4 = s.a("Android" + str4 + replace + VERSION.RELEASE + ":" + Calendar.getInstance().get(6));
                str4 = "smart " + GlobalVariable.a + ":::" + Base64.encodeToString(a(str4 + str2.toLowerCase() + "json_body" + str3 + str5 + GlobalVariable.a + str4, GlobalVariable.b), 0).trim() + ":::" + str5;
                r.b("JdEncryptHelper", "Authorization=" + str4);
                return str4;
            } catch (Exception e) {
                r.b("JdEncryptHelper", e.getMessage());
            }
        }
        return "";
    }

    private static byte[] a(String str, String str2) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str2.getBytes(HTTP.UTF_8), instance.getAlgorithm()));
        return instance.doFinal(str.getBytes());
    }

    private static String a(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }
}
