package org.apache.http.impl.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

@Deprecated
/* compiled from: TbsSdkJava */
public class NegotiateScheme extends GGSSchemeBase {
    private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
    private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
    private final Log log;
    private final SpnegoTokenGenerator spengoGenerator;

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator, boolean z) {
        super(z);
        this.log = LogFactory.getLog(getClass());
        this.spengoGenerator = spnegoTokenGenerator;
    }

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator) {
        this(spnegoTokenGenerator, false);
    }

    public NegotiateScheme() {
        this(null, false);
    }

    public String getSchemeName() {
        return "Negotiate";
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, null);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return super.authenticate(credentials, httpRequest, httpContext);
    }

    protected byte[] generateToken(byte[] bArr, String str) throws GSSException {
        byte[] bArr2;
        try {
            bArr = generateGSSToken(bArr, new Oid(SPNEGO_OID), str);
            Object obj = null;
            bArr2 = bArr;
        } catch (GSSException e) {
            if (e.getMajor() == 2) {
                this.log.debug("GSSException BAD_MECH, retry with Kerberos MECH");
                int i = 1;
                bArr2 = bArr;
            } else {
                throw e;
            }
        }
        if (obj != null) {
            this.log.debug("Using Kerberos MECH 1.2.840.113554.1.2.2");
            bArr2 = generateGSSToken(bArr2, new Oid(KERBEROS_OID), str);
            if (!(bArr2 == null || this.spengoGenerator == null)) {
                try {
                    bArr2 = this.spengoGenerator.generateSpnegoDERObject(bArr2);
                } catch (Throwable e2) {
                    this.log.error(e2.getMessage(), e2);
                }
            }
        }
        return bArr2;
    }

    public String getParameter(String str) {
        Args.notNull(str, "Parameter name");
        return null;
    }

    public String getRealm() {
        return null;
    }

    public boolean isConnectionBased() {
        return true;
    }
}
