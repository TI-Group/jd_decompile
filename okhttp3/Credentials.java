package okhttp3;

import b.f;
import java.io.UnsupportedEncodingException;

/* compiled from: TbsSdkJava */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic " + f.of((str + ":" + str2).getBytes("ISO-8859-1")).base64();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
