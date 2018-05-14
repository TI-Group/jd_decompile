package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class SPNegoScheme extends GGSSchemeBase {
    private static final String SPNEGO_OID = "1.3.6.1.5.5.2";

    public SPNegoScheme(boolean z) {
        super(z);
    }

    public SPNegoScheme() {
        super(false);
    }

    public String getSchemeName() {
        return "Negotiate";
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return super.authenticate(credentials, httpRequest, httpContext);
    }

    protected byte[] generateToken(byte[] bArr, String str) throws GSSException {
        return generateGSSToken(bArr, new Oid(SPNEGO_OID), str);
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
