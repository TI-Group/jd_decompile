package org.apache.http.conn.ssl;

import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class SSLContexts {
    public static SSLContext createDefault() throws SSLInitializationException {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, null);
            return instance;
        } catch (Throwable e) {
            throw new SSLInitializationException(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new SSLInitializationException(e2.getMessage(), e2);
        }
    }

    public static SSLContext createSystemDefault() throws SSLInitializationException {
        try {
            return SSLContext.getInstance("Default");
        } catch (NoSuchAlgorithmException e) {
            return createDefault();
        }
    }

    public static SSLContextBuilder custom() {
        return new SSLContextBuilder();
    }
}
