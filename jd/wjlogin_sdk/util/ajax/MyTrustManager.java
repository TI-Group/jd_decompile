package jd.wjlogin_sdk.util.ajax;

import android.content.Context;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: TbsSdkJava */
public class MyTrustManager implements X509TrustManager {
    private X509Certificate[] acceptedIssuers;
    private X509TrustManager defaultTrustManager;

    static X509TrustManager findX509TrustManager(TrustManagerFactory trustManagerFactory) {
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof X509TrustManager) {
                return (X509TrustManager) trustManagers[i];
            }
        }
        return null;
    }

    public MyTrustManager(Context context) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            this.defaultTrustManager = findX509TrustManager(instance);
            if (this.defaultTrustManager == null) {
                throw new IllegalStateException("Couldn't find X509TrustManager");
            }
            this.acceptedIssuers = this.defaultTrustManager.getAcceptedIssuers();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.defaultTrustManager.checkClientTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.acceptedIssuers;
    }
}
