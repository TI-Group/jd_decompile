package org.apache.http.impl.client;

import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public class DefaultRedirectHandler implements RedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final Log log = LogFactory.getLog(getClass());

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        switch (httpResponse.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
            case 302:
            case 307:
                String method = ((HttpRequest) httpContext.getAttribute("http.request")).getRequestLine().getMethod();
                return method.equalsIgnoreCase("GET") || method.equalsIgnoreCase(HttpHead.METHOD_NAME);
            case 303:
                return true;
            default:
                return false;
        }
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpResponse, "HTTP response");
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String value = firstHeader.getValue();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location '" + value + "'");
        }
        try {
            URI uri;
            URI uri2 = new URI(value);
            HttpParams params = httpResponse.getParams();
            if (uri2.isAbsolute()) {
                uri = uri2;
            } else if (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                throw new ProtocolException("Relative redirect location '" + uri2 + "' not allowed");
            } else {
                HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                Asserts.notNull(httpHost, "Target host");
                try {
                    uri = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) httpContext.getAttribute("http.request")).getRequestLine().getUri()), httpHost, true), uri2);
                } catch (Throwable e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            }
            if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
                RedirectLocations redirectLocations = (RedirectLocations) httpContext.getAttribute("http.protocol.redirect-locations");
                if (redirectLocations == null) {
                    redirectLocations = new RedirectLocations();
                    httpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
                }
                if (uri.getFragment() != null) {
                    try {
                        uri2 = URIUtils.rewriteURI(uri, new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                    } catch (Throwable e2) {
                        throw new ProtocolException(e2.getMessage(), e2);
                    }
                }
                uri2 = uri;
                if (redirectLocations.contains(uri2)) {
                    throw new CircularRedirectException("Circular redirect to '" + uri2 + "'");
                }
                redirectLocations.add(uri2);
            }
            return uri;
        } catch (Throwable e22) {
            throw new ProtocolException("Invalid redirect URI: " + value, e22);
        }
    }
}
