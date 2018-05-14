package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public PrivateKeyDetails(String str, X509Certificate[] x509CertificateArr) {
        this.type = (String) Args.notNull(str, "Private key type");
        this.certChain = x509CertificateArr;
    }

    public String getType() {
        return this.type;
    }

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}
