package org.apache.http.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: TbsSdkJava */
public interface TrustStrategy {
    boolean isTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException;
}
