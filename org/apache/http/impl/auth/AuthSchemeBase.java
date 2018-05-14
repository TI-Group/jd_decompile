package org.apache.http.impl.auth;

import java.util.Locale;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
    private ChallengeState challengeState;

    protected abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException;

    @Deprecated
    public AuthSchemeBase(ChallengeState challengeState) {
        this.challengeState = challengeState;
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        CharArrayBuffer buffer;
        int valuePos;
        Args.notNull(header, "Header");
        String name = header.getName();
        if (name.equalsIgnoreCase("WWW-Authenticate")) {
            this.challengeState = ChallengeState.TARGET;
        } else if (name.equalsIgnoreCase("Proxy-Authenticate")) {
            this.challengeState = ChallengeState.PROXY;
        } else {
            throw new MalformedChallengeException("Unexpected header name: " + name);
        }
        if (header instanceof FormattedHeader) {
            buffer = ((FormattedHeader) header).getBuffer();
            valuePos = ((FormattedHeader) header).getValuePos();
        } else {
            name = header.getValue();
            if (name == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            buffer = new CharArrayBuffer(name.length());
            buffer.append(name);
            valuePos = 0;
        }
        while (valuePos < buffer.length() && HTTP.isWhitespace(buffer.charAt(valuePos))) {
            valuePos++;
        }
        int i = valuePos;
        while (i < buffer.length() && !HTTP.isWhitespace(buffer.charAt(i))) {
            i++;
        }
        name = buffer.substring(valuePos, i);
        if (name.equalsIgnoreCase(getSchemeName())) {
            parseChallenge(buffer, i, buffer.length());
            return;
        }
        throw new MalformedChallengeException("Invalid scheme identifier: " + name);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return authenticate(credentials, httpRequest);
    }

    public boolean isProxy() {
        return this.challengeState != null && this.challengeState == ChallengeState.PROXY;
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public String toString() {
        String schemeName = getSchemeName();
        if (schemeName != null) {
            return schemeName.toUpperCase(Locale.ENGLISH);
        }
        return super.toString();
    }
}
