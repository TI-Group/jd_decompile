package okhttp3;

import b.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: TbsSdkJava */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final List<Pin> pins;
    private final TrustRootIndex trustRootIndex;

    /* compiled from: TbsSdkJava */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();
        private TrustRootIndex trustRootIndex;

        Builder(CertificatePinner certificatePinner) {
            this.pins.addAll(certificatePinner.pins);
            this.trustRootIndex = certificatePinner.trustRootIndex;
        }

        public Builder trustRootIndex(TrustRootIndex trustRootIndex) {
            this.trustRootIndex = trustRootIndex;
            return this;
        }

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new IllegalArgumentException("pattern == null");
            }
            for (String pin : strArr) {
                this.pins.add(new Pin(str, pin));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner();
        }
    }

    /* compiled from: TbsSdkJava */
    static final class Pin {
        final f hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            this.pattern = str;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = f.decodeBase64(str2.substring("sha1/".length()));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = f.decodeBase64(str2.substring("sha256/".length()));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.hash == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        boolean matches(String str) {
            boolean z = false;
            if (this.pattern.equals(str)) {
                return true;
            }
            int indexOf = str.indexOf(46);
            if (this.pattern.startsWith("*.")) {
                if (str.regionMatches(false, indexOf + 1, this.pattern, 2, this.pattern.length() - 2)) {
                    z = true;
                }
            }
            return z;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Pin) && this.pattern.equals(((Pin) obj).pattern) && this.hashAlgorithm.equals(((Pin) obj).hashAlgorithm) && this.hash.equals(((Pin) obj).hash);
        }

        public int hashCode() {
            return ((((this.pattern.hashCode() + 527) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    private CertificatePinner(Builder builder) {
        this.pins = Util.immutableList(builder.pins);
        this.trustRootIndex = builder.trustRootIndex;
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            X509Certificate x509Certificate;
            int i;
            if (this.trustRootIndex != null) {
                list = new CertificateChainCleaner(this.trustRootIndex).clean(list);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x509Certificate = (X509Certificate) list.get(i2);
                int size2 = findMatchingPins.size();
                int i3 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i3 < size2) {
                    Pin pin = (Pin) findMatchingPins.get(i3);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (obj == null) {
                            obj = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(obj)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    Object obj3 = obj;
                    i3++;
                    obj2 = obj2;
                    obj = obj3;
                }
            }
            StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (i = 0; i < size3; i++) {
                x509Certificate = (X509Certificate) list.get(i);
                append.append("\n    ").append(pin(x509Certificate)).append(": ").append(x509Certificate.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            size3 = findMatchingPins.size();
            for (i = 0; i < size3; i++) {
                append.append("\n    ").append((Pin) findMatchingPins.get(i));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }

    List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    Builder newBuilder() {
        return new Builder(this);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + sha256((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static f sha1(X509Certificate x509Certificate) {
        return Util.sha1(f.of(x509Certificate.getPublicKey().getEncoded()));
    }

    static f sha256(X509Certificate x509Certificate) {
        return Util.sha256(f.of(x509Certificate.getPublicKey().getEncoded()));
    }
}
