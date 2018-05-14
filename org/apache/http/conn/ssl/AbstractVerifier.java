package org.apache.http.conn.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.util.InetAddressUtils;

@Immutable
/* compiled from: TbsSdkJava */
public abstract class AbstractVerifier implements X509HostnameVerifier {
    private static final String[] BAD_COUNTRY_2LDS = new String[]{"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
    private final Log log = LogFactory.getLog(getClass());

    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }

    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
        if (str == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        verify(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            return false;
        }
    }

    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
        verify(str, getCNs(x509Certificate), getSubjectAlts(x509Certificate, str));
    }

    public final void verify(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        int i;
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || strArr[0] == null)) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (Object obj : strArr2) {
                if (obj != null) {
                    linkedList.add(obj);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuilder stringBuilder = new StringBuilder();
        String normaliseIPv6Address = normaliseIPv6Address(str.trim().toLowerCase(Locale.ENGLISH));
        Iterator it = linkedList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            String toLowerCase = ((String) it.next()).toLowerCase(Locale.ENGLISH);
            stringBuilder.append(" <");
            stringBuilder.append(toLowerCase);
            stringBuilder.append('>');
            if (it.hasNext()) {
                stringBuilder.append(" OR");
            }
            String[] split = toLowerCase.split("\\.");
            i = (split.length < 3 || !split[0].endsWith("*") || !validCountryWildcard(toLowerCase) || isIPAddress(str)) ? 0 : 1;
            if (i != 0) {
                String str2 = split[0];
                if (str2.length() > 1) {
                    String substring = str2.substring(0, str2.length() - 1);
                    str2 = toLowerCase.substring(str2.length());
                    String substring2 = normaliseIPv6Address.substring(substring.length());
                    if (normaliseIPv6Address.startsWith(substring) && substring2.endsWith(str2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = normaliseIPv6Address.endsWith(toLowerCase.substring(1));
                }
                if (z2 && z) {
                    if (countDots(normaliseIPv6Address) == countDots(toLowerCase)) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                }
            } else {
                z2 = normaliseIPv6Address.equals(normaliseIPv6Address(toLowerCase));
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (!z2) {
            throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + stringBuilder);
        }
    }

    @Deprecated
    public static boolean acceptableCountryWildcard(String str) {
        String[] split = str.split("\\.");
        if (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, split[1]) >= 0) {
            return false;
        }
        return true;
    }

    boolean validCountryWildcard(String str) {
        String[] split = str.split("\\.");
        if (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(BAD_COUNTRY_2LDS, split[1]) >= 0) {
            return false;
        }
        return true;
    }

    public static String[] getCNs(X509Certificate x509Certificate) {
        try {
            return extractCNs(x509Certificate.getSubjectX500Principal().toString());
        } catch (SSLException e) {
            return null;
        }
    }

    static String[] extractCNs(String str) throws SSLException {
        if (str == null) {
            return null;
        }
        List arrayList = new ArrayList();
        try {
            List rdns = new LdapName(str).getRdns();
            for (int size = rdns.size() - 1; size >= 0; size--) {
                Attribute attribute = ((Rdn) rdns.get(size)).toAttributes().get("cn");
                if (attribute != null) {
                    try {
                        Object obj = attribute.get();
                        if (obj != null) {
                            arrayList.add(obj.toString());
                        }
                    } catch (NoSuchElementException e) {
                    } catch (NamingException e2) {
                    }
                }
            }
            return arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (InvalidNameException e3) {
            throw new SSLException(str + " is not a valid X500 distinguished name");
        }
    }

    private static String[] getSubjectAlts(X509Certificate x509Certificate, String str) {
        int i;
        Collection subjectAlternativeNames;
        if (isIPAddress(str)) {
            i = 7;
        } else {
            i = 2;
        }
        LinkedList linkedList = new LinkedList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            subjectAlternativeNames = null;
        }
        if (r0 != null) {
            for (List list : r0) {
                if (((Integer) list.get(0)).intValue() == i) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static String[] getDNSSubjectAlts(X509Certificate x509Certificate) {
        return getSubjectAlts(x509Certificate, null);
    }

    public static int countDots(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ClassUtils.PACKAGE_SEPARATOR_CHAR) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static boolean isIPAddress(String str) {
        return str != null && (InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str));
    }

    private String normaliseIPv6Address(String str) {
        if (str != null && InetAddressUtils.isIPv6Address(str)) {
            try {
                str = InetAddress.getByName(str).getHostAddress();
            } catch (Throwable e) {
                this.log.error("Unexpected error converting " + str, e);
            }
        }
        return str;
    }
}
