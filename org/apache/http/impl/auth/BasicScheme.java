package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ChallengeState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicScheme extends RFC2617Scheme {
    private final Base64 base64codec;
    private boolean complete;

    public BasicScheme(Charset charset) {
        super(charset);
        this.base64codec = new Base64(0);
        this.complete = false;
    }

    @Deprecated
    public BasicScheme(ChallengeState challengeState) {
        super(challengeState);
        this.base64codec = new Base64(0);
    }

    public BasicScheme() {
        this(Consts.ASCII);
    }

    public String getSchemeName() {
        return "basic";
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isConnectionBased() {
        return false;
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, new BasicHttpContext());
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(credentials.getUserPrincipal().getName());
        stringBuilder.append(":");
        stringBuilder.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encode = this.base64codec.encode(EncodingUtils.getBytes(stringBuilder.toString(), getCredentialsCharset(httpRequest)));
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (isProxy()) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encode, 0, encode.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Deprecated
    public static Header authenticate(Credentials credentials, String str, boolean z) {
        Args.notNull(credentials, "Credentials");
        Args.notNull(str, "charset");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(credentials.getUserPrincipal().getName());
        stringBuilder.append(":");
        stringBuilder.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encodeBase64 = Base64.encodeBase64(EncodingUtils.getBytes(stringBuilder.toString(), str), false);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (z) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encodeBase64, 0, encodeBase64.length);
        return new BufferedHeader(charArrayBuffer);
    }
}
