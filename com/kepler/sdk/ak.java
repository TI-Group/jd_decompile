package com.kepler.sdk;

import android.content.Context;
import com.jd.jdsdk.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* compiled from: TbsSdkJava */
public class ak {
    public boolean a(Context context, String str) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(R.raw.safe);
            if (openRawResource != null) {
                byte[] a = a(openRawResource);
                if (a != null) {
                    String b = new an().b(a);
                    p.b("suwg", "image-:" + b);
                    String b2 = b(context, str);
                    p.b("suwg", "get-:" + b2);
                    if (b2.equals(b)) {
                        return true;
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "2016_4_22_17_145490");
        }
        if (o.b.booleanValue()) {
            return true;
        }
        return false;
    }

    private String b(Context context, String str) {
        try {
            ai aiVar = new ai();
            String str2 = ai.f(context) + "," + aiVar.c(context) + "," + aiVar.d(context);
            if (str2.indexOf(";") >= 0) {
                str2 = str2.replace(":", "");
            }
            str2 = str + "," + str2.toLowerCase();
            p.b("suwg", "get-str:" + str2);
            return new an().a(str2.getBytes());
        } catch (Throwable e) {
            l.a(e, "2016_4_22_17_454");
            return "";
        }
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
            } catch (Throwable e) {
                l.a(e, "2016_4_22_17_103434");
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
