package org.apache.http.impl.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Asserts;
import org.apache.http.util.CharArrayBuffer;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "NTLM", "Digest", "Basic"}));
    private final Log log = LogFactory.getLog(getClass());

    protected Map<String, Header> parseChallenges(Header[] headerArr) throws MalformedChallengeException {
        Map<String, Header> hashMap = new HashMap(headerArr.length);
        for (Header header : headerArr) {
            CharArrayBuffer buffer;
            int valuePos;
            if (header instanceof FormattedHeader) {
                buffer = ((FormattedHeader) header).getBuffer();
                valuePos = ((FormattedHeader) header).getValuePos();
            } else {
                String value = header.getValue();
                if (value == null) {
                    throw new MalformedChallengeException("Header value is null");
                }
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(value.length());
                charArrayBuffer.append(value);
                buffer = charArrayBuffer;
                valuePos = 0;
            }
            while (valuePos < buffer.length() && HTTP.isWhitespace(buffer.charAt(valuePos))) {
                valuePos++;
            }
            int i = valuePos;
            while (i < buffer.length() && !HTTP.isWhitespace(buffer.charAt(i))) {
                i++;
            }
            hashMap.put(buffer.substring(valuePos, i).toLowerCase(Locale.ENGLISH), header);
        }
        return hashMap;
    }

    protected List<String> getAuthPreferences() {
        return DEFAULT_SCHEME_PRIORITY;
    }

    protected List<String> getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        return getAuthPreferences();
    }

    public AuthScheme selectScheme(Map<String, Header> map, HttpResponse httpResponse, HttpContext httpContext) throws AuthenticationException {
        AuthScheme authScheme;
        AuthSchemeRegistry authSchemeRegistry = (AuthSchemeRegistry) httpContext.getAttribute("http.authscheme-registry");
        Asserts.notNull(authSchemeRegistry, "AuthScheme registry");
        Collection authPreferences = getAuthPreferences(httpResponse, httpContext);
        if (authPreferences == null) {
            authPreferences = DEFAULT_SCHEME_PRIORITY;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Authentication schemes in the order of preference: " + r1);
        }
        for (String str : r1) {
            if (((Header) map.get(str.toLowerCase(Locale.ENGLISH))) != null) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(str + " authentication scheme selected");
                }
                try {
                    authScheme = authSchemeRegistry.getAuthScheme(str, httpResponse.getParams());
                    break;
                } catch (IllegalStateException e) {
                    if (this.log.isWarnEnabled()) {
                        this.log.warn("Authentication scheme " + str + " not supported");
                    }
                }
            } else if (this.log.isDebugEnabled()) {
                this.log.debug("Challenge for " + str + " authentication scheme not available");
            }
        }
        authScheme = null;
        if (authScheme != null) {
            return authScheme;
        }
        throw new AuthenticationException("Unable to respond to any of these challenges: " + map);
    }
}
