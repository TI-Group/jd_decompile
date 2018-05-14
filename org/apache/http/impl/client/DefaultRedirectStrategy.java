package org.apache.http.impl.client;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import java.util.Locale;
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
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.TextUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String[] REDIRECT_METHODS = new String[]{"GET", HttpHead.METHOD_NAME};
    private final Log log = LogFactory.getLog(getClass());

    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String method = httpRequest.getRequestLine().getMethod();
        Header firstHeader = httpResponse.getFirstHeader("location");
        switch (statusCode) {
            case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
            case 307:
                return isRedirectable(method);
            case 302:
                if (!isRedirectable(method) || firstHeader == null) {
                    return false;
                }
                return true;
            case 303:
                return true;
            default:
                return false;
        }
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String value = firstHeader.getValue();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location '" + value + "'");
        }
        RequestConfig requestConfig = adapt.getRequestConfig();
        URI createLocationURI = createLocationURI(value);
        try {
            URI uri;
            if (createLocationURI.isAbsolute()) {
                uri = createLocationURI;
            } else if (requestConfig.isRelativeRedirectsAllowed()) {
                HttpHost targetHost = adapt.getTargetHost();
                Asserts.notNull(targetHost, "Target host");
                uri = URIUtils.resolve(URIUtils.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), targetHost, false), createLocationURI);
            } else {
                throw new ProtocolException("Relative redirect location '" + createLocationURI + "' not allowed");
            }
            RedirectLocations redirectLocations = (RedirectLocations) adapt.getAttribute("http.protocol.redirect-locations");
            if (redirectLocations == null) {
                redirectLocations = new RedirectLocations();
                httpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
            }
            if (requestConfig.isCircularRedirectsAllowed() || !redirectLocations.contains(uri)) {
                redirectLocations.add(uri);
                return uri;
            }
            throw new CircularRedirectException("Circular redirect to '" + uri + "'");
        } catch (Throwable e) {
            throw new ProtocolException(e.getMessage(), e);
        }
    }

    protected URI createLocationURI(String str) throws ProtocolException {
        try {
            URIBuilder uRIBuilder = new URIBuilder(new URI(str).normalize());
            String host = uRIBuilder.getHost();
            if (host != null) {
                uRIBuilder.setHost(host.toLowerCase(Locale.ENGLISH));
            }
            if (TextUtils.isEmpty(uRIBuilder.getPath())) {
                uRIBuilder.setPath(HttpUtils.PATHS_SEPARATOR);
            }
            return uRIBuilder.build();
        } catch (Throwable e) {
            throw new ProtocolException("Invalid redirect URI: " + str, e);
        }
    }

    protected boolean isRedirectable(String str) {
        for (String equalsIgnoreCase : REDIRECT_METHODS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = getLocationURI(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        if (method.equalsIgnoreCase(HttpHead.METHOD_NAME)) {
            return new HttpHead(locationURI);
        }
        if (method.equalsIgnoreCase("GET")) {
            return new HttpGet(locationURI);
        }
        if (httpResponse.getStatusLine().getStatusCode() == 307) {
            return RequestBuilder.copy(httpRequest).setUri(locationURI).build();
        }
        return new HttpGet(locationURI);
    }
}
