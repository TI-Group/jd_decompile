package org.apache.http.client.protocol;

import cn.jiguang.net.HttpUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Lookup;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestAddCookies implements HttpRequestInterceptor {
    private final Log log = LogFactory.getLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Object obj = null;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            HttpContext adapt = HttpClientContext.adapt(httpContext);
            CookieStore cookieStore = adapt.getCookieStore();
            if (cookieStore == null) {
                this.log.debug("Cookie store not specified in HTTP context");
                return;
            }
            Lookup cookieSpecRegistry = adapt.getCookieSpecRegistry();
            if (cookieSpecRegistry == null) {
                this.log.debug("CookieSpec registry not specified in HTTP context");
                return;
            }
            HttpHost targetHost = adapt.getTargetHost();
            if (targetHost == null) {
                this.log.debug("Target host not set in the context");
                return;
            }
            RouteInfo httpRoute = adapt.getHttpRoute();
            if (httpRoute == null) {
                this.log.debug("Connection route not set in the context");
                return;
            }
            String str;
            URI uri;
            String cookieSpec = adapt.getRequestConfig().getCookieSpec();
            if (cookieSpec == null) {
                str = "best-match";
            } else {
                str = cookieSpec;
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("CookieSpec selected: " + str);
            }
            if (httpRequest instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) httpRequest).getURI();
            } else {
                try {
                    uri = new URI(httpRequest.getRequestLine().getUri());
                } catch (URISyntaxException e) {
                    uri = null;
                }
            }
            if (uri != null) {
                cookieSpec = uri.getPath();
            } else {
                cookieSpec = null;
            }
            String hostName = targetHost.getHostName();
            int port = targetHost.getPort();
            if (port < 0) {
                port = httpRoute.getTargetHost().getPort();
            }
            if (port < 0) {
                port = 0;
            }
            if (TextUtils.isEmpty(cookieSpec)) {
                cookieSpec = HttpUtils.PATHS_SEPARATOR;
            }
            CookieOrigin cookieOrigin = new CookieOrigin(hostName, port, cookieSpec, httpRoute.isSecure());
            CookieSpecProvider cookieSpecProvider = (CookieSpecProvider) cookieSpecRegistry.lookup(str);
            if (cookieSpecProvider == null) {
                throw new HttpException("Unsupported cookie policy: " + str);
            }
            Header versionHeader;
            CookieSpec create = cookieSpecProvider.create(adapt);
            List<Cookie> arrayList = new ArrayList(cookieStore.getCookies());
            List<Cookie> arrayList2 = new ArrayList();
            Date date = new Date();
            for (Cookie cookie : arrayList) {
                if (cookie.isExpired(date)) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Cookie " + cookie + " expired");
                    }
                } else if (create.match(cookie, cookieOrigin)) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                    }
                    arrayList2.add(cookie);
                }
            }
            if (!arrayList2.isEmpty()) {
                for (Header versionHeader2 : create.formatCookies(arrayList2)) {
                    httpRequest.addHeader(versionHeader2);
                }
            }
            int version = create.getVersion();
            if (version > 0) {
                for (Cookie cookie2 : arrayList2) {
                    if (version != cookie2.getVersion() || !(cookie2 instanceof SetCookie2)) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    versionHeader2 = create.getVersionHeader();
                    if (versionHeader2 != null) {
                        httpRequest.addHeader(versionHeader2);
                    }
                }
            }
            httpContext.setAttribute("http.cookie-spec", create);
            httpContext.setAttribute("http.cookie-origin", cookieOrigin);
        }
    }
}
