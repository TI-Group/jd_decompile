package org.apache.http.client.utils;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class URIUtils {
    @Deprecated
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) throws URISyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                stringBuilder.append(str);
                stringBuilder.append("://");
            }
            stringBuilder.append(str2);
            if (i > 0) {
                stringBuilder.append(':');
                stringBuilder.append(i);
            }
        }
        if (str3 == null || !str3.startsWith(HttpUtils.PATHS_SEPARATOR)) {
            stringBuilder.append('/');
        }
        if (str3 != null) {
            stringBuilder.append(str3);
        }
        if (str4 != null) {
            stringBuilder.append('?');
            stringBuilder.append(str4);
        }
        if (str5 != null) {
            stringBuilder.append('#');
            stringBuilder.append(str5);
        }
        return new URI(stringBuilder.toString());
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        Args.notNull(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (httpHost != null) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        } else {
            uRIBuilder.setScheme(null);
            uRIBuilder.setHost(null);
            uRIBuilder.setPort(-1);
        }
        if (z) {
            uRIBuilder.setFragment(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath(HttpUtils.PATHS_SEPARATOR);
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        return rewriteURI(uri, httpHost, false);
    }

    public static URI rewriteURI(URI uri) throws URISyntaxException {
        Args.notNull(uri, "URI");
        if (uri.isOpaque()) {
            return uri;
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (uRIBuilder.getUserInfo() != null) {
            uRIBuilder.setUserInfo(null);
        }
        if (TextUtils.isEmpty(uRIBuilder.getPath())) {
            uRIBuilder.setPath(HttpUtils.PATHS_SEPARATOR);
        }
        if (uRIBuilder.getHost() != null) {
            uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ENGLISH));
        }
        uRIBuilder.setFragment(null);
        return uRIBuilder.build();
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    public static URI resolve(URI uri, URI uri2) {
        Args.notNull(uri, "Base URI");
        Args.notNull(uri2, "Reference URI");
        String uri3 = uri2.toString();
        if (uri3.startsWith(HttpUtils.URL_AND_PARA_SEPARATOR)) {
            return resolveReferenceStartingWithQueryString(uri, uri2);
        }
        int i = uri3.length() == 0 ? 1 : 0;
        if (i != 0) {
            uri2 = URI.create("#");
        }
        URI resolve = uri.resolve(uri2);
        if (i != 0) {
            uri3 = resolve.toString();
            resolve = URI.create(uri3.substring(0, uri3.indexOf(35)));
        }
        return normalizeSyntax(resolve);
    }

    private static URI resolveReferenceStartingWithQueryString(URI uri, URI uri2) {
        String uri3 = uri.toString();
        if (uri3.indexOf(63) > -1) {
            uri3 = uri3.substring(0, uri3.indexOf(63));
        }
        return URI.create(uri3 + uri2.toString());
    }

    private static URI normalizeSyntax(URI uri) {
        if (uri.isOpaque() || uri.getAuthority() == null) {
            return uri;
        }
        Args.check(uri.isAbsolute(), "Base URI must be absolute");
        String path = uri.getPath() == null ? "" : uri.getPath();
        String[] split = path.split(HttpUtils.PATHS_SEPARATOR);
        Stack stack = new Stack();
        for (String str : split) {
            if (!(str.length() == 0 || ".".equals(str))) {
                if (!"..".equals(str)) {
                    stack.push(str);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            stringBuilder.append('/').append((String) it.next());
        }
        if (path.lastIndexOf(47) == path.length() - 1) {
            stringBuilder.append('/');
        }
        try {
            URI uri2 = new URI(uri.getScheme().toLowerCase(Locale.ENGLISH), uri.getAuthority().toLowerCase(Locale.ENGLISH), stringBuilder.toString(), null, null);
            if (uri.getQuery() == null && uri.getFragment() == null) {
                return uri2;
            }
            StringBuilder stringBuilder2 = new StringBuilder(uri2.toASCIIString());
            if (uri.getQuery() != null) {
                stringBuilder2.append('?').append(uri.getRawQuery());
            }
            if (uri.getFragment() != null) {
                stringBuilder2.append('#').append(uri.getRawFragment());
            }
            return URI.create(stringBuilder2.toString());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static HttpHost extractHost(URI uri) {
        if (uri == null) {
            return null;
        }
        HttpHost httpHost;
        if (uri.isAbsolute()) {
            int port = uri.getPort();
            String host = uri.getHost();
            if (host == null) {
                host = uri.getAuthority();
                if (host != null) {
                    String str;
                    int indexOf = host.indexOf(64);
                    if (indexOf < 0) {
                        str = host;
                    } else if (host.length() > indexOf + 1) {
                        str = host.substring(indexOf + 1);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        int indexOf2 = str.indexOf(58);
                        if (indexOf2 >= 0) {
                            indexOf = indexOf2 + 1;
                            int i = indexOf;
                            int i2 = 0;
                            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                                i2++;
                                i++;
                            }
                            if (i2 > 0) {
                                try {
                                    i = Integer.parseInt(str.substring(indexOf, indexOf + i2));
                                } catch (NumberFormatException e) {
                                    i = port;
                                }
                            } else {
                                i = port;
                            }
                            port = i;
                            host = str.substring(0, indexOf2);
                        }
                    }
                    host = str;
                }
            }
            String scheme = uri.getScheme();
            if (!TextUtils.isBlank(host)) {
                httpHost = new HttpHost(host, port, scheme);
                return httpHost;
            }
        }
        httpHost = null;
        return httpHost;
    }

    public static URI resolve(URI uri, HttpHost httpHost, List<URI> list) throws URISyntaxException {
        URIBuilder uRIBuilder;
        Args.notNull(uri, "Request URI");
        if (list == null || list.isEmpty()) {
            uRIBuilder = new URIBuilder(uri);
        } else {
            URIBuilder uRIBuilder2 = new URIBuilder((URI) list.get(list.size() - 1));
            String fragment = uRIBuilder2.getFragment();
            int size = list.size() - 1;
            while (fragment == null && size >= 0) {
                String fragment2 = ((URI) list.get(size)).getFragment();
                size--;
                fragment = fragment2;
            }
            uRIBuilder2.setFragment(fragment);
            uRIBuilder = uRIBuilder2;
        }
        if (uRIBuilder.getFragment() == null) {
            uRIBuilder.setFragment(uri.getFragment());
        }
        if (!(httpHost == null || uRIBuilder.isAbsolute())) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        }
        return uRIBuilder.build();
    }

    private URIUtils() {
    }
}
