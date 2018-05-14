package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class RFC2617Scheme extends AuthSchemeBase {
    private final Charset credentialsCharset;
    private final Map<String, String> params;

    @Deprecated
    public RFC2617Scheme(ChallengeState challengeState) {
        super(challengeState);
        this.params = new HashMap();
        this.credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset charset) {
        this.params = new HashMap();
        if (charset == null) {
            charset = Consts.ASCII;
        }
        this.credentialsCharset = charset;
    }

    public RFC2617Scheme() {
        this(Consts.ASCII);
    }

    public Charset getCredentialsCharset() {
        return this.credentialsCharset;
    }

    String getCredentialsCharset(HttpRequest httpRequest) {
        String str = (String) httpRequest.getParams().getParameter(AuthPNames.CREDENTIAL_CHARSET);
        if (str == null) {
            return getCredentialsCharset().name();
        }
        return str;
    }

    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException {
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(i, charArrayBuffer.length()));
        if (parseElements.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        this.params.clear();
        for (HeaderElement headerElement : parseElements) {
            this.params.put(headerElement.getName().toLowerCase(Locale.ENGLISH), headerElement.getValue());
        }
    }

    protected Map<String, String> getParameters() {
        return this.params;
    }

    public String getParameter(String str) {
        if (str == null) {
            return null;
        }
        return (String) this.params.get(str.toLowerCase(Locale.ENGLISH));
    }

    public String getRealm() {
        return getParameter("realm");
    }
}
